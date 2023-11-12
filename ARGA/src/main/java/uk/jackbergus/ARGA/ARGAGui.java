package uk.jackbergus.ARGA;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;
import sdsProject.GraphStreamView;
import uk.jackbergus.DundeeLogic.ArgGraph;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class ARGAGui {
    public static BackendServer server;
    private JTree corpora;
    private JPanel mainPanel;
    private JButton text;
    private JButton graph;
    private JTabbedPane tabbedPane1;
    private JEditorPane contentPane;
    private JButton linkGraphs;
    private JButton load;
    private JButton viewLoadedButton;
    private JPanel graphPane;

    private static void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }

    List<Pair<String,String>> ls = null;

    public ARGAGui() {
        ls = new ArrayList<>();
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("ARGA GUI");
        ARGAGui.server = new BackendServer();
        var app = new ARGAGui();
        app.init();
        frame.setContentPane(app.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsEnvironment env =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        frame.setMaximizedBounds(env.getMaximumWindowBounds());
        frame.setExtendedState(frame.getExtendedState() | Frame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }

    public void showGraphPopUp(String corpusID, String documentID) {
        EventQueue.invokeLater(() -> {
            var arga = server.getArgumentationGraph(corpusID, documentID);
            popupFromArgaGraph(arga, corpusID+":"+documentID);
        });
    }

    private static void popupFromArgaGraph(ArgGraph arga, String title) {
        Graph graph = new MultiGraph("embedded");
        String css =  "graph { fill-mode: dyn-plain; }" +
                "node { size: 10px; text-background-mode: rounded-box; text-alignment: at-right; shape: box; fill-mode: dyn-plain; fill-color: green, red; }" +
                "edge { size: 1px; fill-color: #444; text-alignment:above; }" +
                "edge.sent { fill-color: blue; }" +
                "node.sent { fill-color:blue,blue; shape: diamond; }";
//            graph.addAttribute("ui.stylesheet", css);
// inizializzo l'interfaccia grafica
        System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

        // inizializzo il grafo
        graph.addAttribute("ui.stylesheet", css);
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        if (arga.nodes != null)
        for (var node : arga.nodes) {
            var graphNode = graph.addNode(node.nodeID);
            graphNode.setAttribute("ui.label", node.text);
            if (node.schemeID != null || (Objects.equals(node.text, "YA") || Objects.equals(node.text, "TA"))) {
                graphNode.setAttribute("ui.class", "sent");
            }
        }
        int count = 0;
        if (arga.edges != null)
        for (var edge : arga.edges) {
            graph.addEdge(String.valueOf(count++), edge.fromID, edge.toID, true);
        }
        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        View view = viewer.addDefaultView(false);   // false indicates "no JFrame".
        GraphStreamView jf = new GraphStreamView(view, graph, title);
        jf.setPreferredSize(new Dimension(800, 600));
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setResizable(true);
        jf.setVisible(true);
    }

    public static MouseListener onClickMethod(Consumer<MouseEvent> c) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c.accept(e);
            }
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
    }

    private void init() {
        text.addMouseListener(onClickMethod(e -> {
            contentPane.setContentType("text/html");
            contentPane.setText("<html><body>"+server.getDocument(corpusID, documentID)+"</body></html>");
        }));
        graph.addMouseListener(onClickMethod(e -> {
            showGraphPopUp(corpusID, documentID);
        }));
        load.addMouseListener(onClickMethod(me -> {
            if (ls != null)
                for (var x : ls) {
                    server.loadIntoDB(x.getKey(), x.getValue());
                }
        }));
        linkGraphs.addMouseListener(onClickMethod(me -> {
            if (!server.hasARGALinker()) {
                JOptionPane.showMessageDialog(null, "Python ARGALinker (dundee_linker.py) is not running: this program will not link documents", "Service Missing", JOptionPane.WARNING_MESSAGE);
            } else {
                for (var x : ls) {
                    for (var y : ls) {
                        if (!Objects.equals(x,y))
                            server.linkGraphs(x.getKey(), x.getValue(), y.getKey(), y.getValue());
                    }
                }
            }
        }));
        viewLoadedButton.addMouseListener(onClickMethod(me -> {
            var arga = server.returnDumpedArgumentation();
            popupFromArgaGraph(arga, "Loaded Argumentation");
        }));
    }

    boolean areEnabled = false;
    private String corpusID = null;
    private String documentID = null;

    private void enableDocumentComponents(boolean enabled) {
        areEnabled = enabled;
        text.setEnabled(enabled);
        graph.setEnabled(enabled);
        linkGraphs.setEnabled(enabled);
        load.setEnabled(enabled);
        if (!enabled) {
            corpusID = null;
            documentID = null;
            contentPane.setText("");
        }
    }

    private void createUIComponents() {
        initLookAndFeel();
        // TODO: place custom component creation code here
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        if (!server.hasGoldenRetriever()) {
            JOptionPane.showMessageDialog(null, "Python GolenRetriever (mock_miner.py) is not running: this program will stop", "Service Missing", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

//        HashMap<String, DefaultMutableTreeNode> corpora = new HashMap<>();
//        HashMap<String, List<DefaultMutableTreeNode>> corpusContent = new HashMap<>();
        server.listCorpora().forEach(x-> {
            var basicElement = new DefaultMutableTreeNode(x);
//            corpusContent.put(x, ls);
//            corpora.put(x, basicElement);
            for (var y : server.listDocuments(x)) {
                var child = new DefaultMutableTreeNode(y);
                child.setAllowsChildren(false);
                basicElement.add(child);
            }
            root.add(basicElement);
        });
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        treeModel.setAsksAllowsChildren(true);
        corpora = new JTree(treeModel);
        corpora.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        corpora.addTreeSelectionListener(e -> {
            JTree treeSource = (JTree) e.getSource();
            var rows = treeSource.getSelectionPaths();
            ls.clear();
            for (var tp : Objects.requireNonNull(treeSource.getSelectionPaths())) {
                if (tp != null) {
                    var p = tp.getPath();
                    if (p.length == 3) {
                        ls.add(new ImmutablePair<>(p[1].toString(),p[2].toString()));
                    }
                }
            }
        });
        corpora.addMouseListener(onClickMethod(me -> {
            TreePath tp = corpora.getPathForLocation(me.getX(), me.getY());
            if (tp != null) {
                var p = tp.getPath();
                if (p.length == 3) {
                    enableDocumentComponents(true);
                    corpusID = p[1].toString();
                    documentID = p[2].toString();
                } else {
                    enableDocumentComponents(false);
                }
            }
        }));
    }
}
