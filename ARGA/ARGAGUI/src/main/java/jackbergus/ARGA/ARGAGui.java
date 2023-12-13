package jackbergus.ARGA;

import DundeeLogic.AnalysisType;
import DundeeLogic.ArgGraph;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import sdsProject.GraphStreamView;
import jackbergus.ARGA.javanatives.ProgressBarHandler;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;

/**
 * Running ARGA as a minimalistic GUI App, while using the mock-server operations
 */
public class ARGAGui {
    public static BackendServer server;

    JFrame frame;

    private JTree corpora;
    private JPanel mainPanel;
    private JButton text;
    private JButton graph;
    private JTabbedPane tabbedPane1;
    private JEditorPane contentPane;
    private JButton linkGraphs;
    private JButton load;
    private JButton viewLoadedButton;
    private JTable queryableNodes;
    private JLabel q;
    private JComboBox analysisType;
    private JCheckBox isGroundedOtherwisePreferredCheckBox;
    private JButton fillEntryPointsButton;
    private JButton fillTargetsButton;
    private JButton fillObjectivesButton;
    private JList entries;
    private JList targets;
    private JList objectives;
    private JButton Run;
    private JTextArea queryResult;
    private JProgressBar progressBar1;
    private JSlider errorLevel;
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
        ARGAGui.server = new BackendServer();
        var app = new ARGAGui();
//        app.createUIComponents();
        app.init();
    }

    public void showGraphPopUp(String corpusID, String documentID) {
        EventQueue.invokeLater(() -> {
            ArgGraph arga = server.getArgumentationGraph(corpusID, documentID);
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
            if ((corpusID != null) && (documentID != null)) {
                contentPane.setContentType("text/html");
                contentPane.setText("<html><body>"+server.getDocument(corpusID, documentID)+"</body></html>");
            } else {
                System.err.println("No document being selected!");
            }
        }));
        graph.addMouseListener(onClickMethod(e -> {
            if ((corpusID != null) && (documentID != null)) {
                showGraphPopUp(corpusID, documentID);
            } else {
                System.err.println("No document being selected! (2)");
            }
        }));
        load.addMouseListener(onClickMethod(me -> {
            if (ls != null) {
                ProgressBarHandler pb = new ProgressBarHandler(progressBar1, frame);
                pb.init(0, ls.size());
                int i = 0;
                for (var x : ls) {
                    server.loadIntoDB(x.getKey(), x.getValue());
                    pb.updateTo(i++);
                }
                pb.updateTo(0);
                pb.beep();
            }
        }));
        linkGraphs.addMouseListener(onClickMethod(me -> {
            if (!server.hasARGALinker()) {
                JOptionPane.showMessageDialog(null, "Python ARGALinker (dundee_linker.py) is not running: this program will not link documents", "Service Missing", JOptionPane.WARNING_MESSAGE);
            } else {
                Set<Pair<String,String>> missingDocs = new HashSet<>();
                ProgressBarHandler pb = new ProgressBarHandler(progressBar1, frame);
                pb.init(0, ls.size()*ls.size());

//                final JDialog dlg = new JDialog(frame, "TITLE", true);
//                JProgressBar dpb = new JProgressBar(0, 500);
//                dlg.add(BorderLayout.CENTER, dpb);
//                dlg.add(BorderLayout.NORTH, new JLabel("PROGRESS"));
//                dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
//                dlg.setSize(300, 75);
//                dlg.setLocationRelativeTo(frame);
//                Thread t = new Thread(() -> dlg.setVisible(true));
//                t.start();
                int i = 0;
                for (var x : ls) {
                    if (missingDocs.contains(x)) {
                        i = i+ls.size();

                        continue;
                    }
                    if (!server.isDocumentLoaded(x.getKey(), x.getValue())) {
                        i = i+ls.size();
                        pb.updateTo(i);
                        JOptionPane.showMessageDialog(null, "Document " + x.getValue() +" from corpus " + x.getKey() +" is not loaded: cannot consider this: skipping", "Document Not Loaded", JOptionPane.WARNING_MESSAGE);
                        missingDocs.add(x);
                        continue;
                    }
                    for (var y : ls) {
                        if (missingDocs.contains(y)) {
                            i++;
                            pb.updateTo(i);
                            continue;
                        }
                        if (!server.isDocumentLoaded(y.getKey(), y.getValue())) {
                            JOptionPane.showMessageDialog(null, "Document " + y.getValue() +" from corpus " + y.getKey() +" is not loaded: cannot consider this: skipping", "Document Not Loaded", JOptionPane.WARNING_MESSAGE);
                            missingDocs.add(y);
                            i++;
                            pb.updateTo(i);
                            continue;
                        }
                        if (!Objects.equals(x,y)) {
                            server.linkGraphs(x.getKey(), x.getValue(), y.getKey(), y.getValue());
                        }
                        i++;
                        pb.updateTo(i);
                    }
                }
                pb.updateTo(0);
                pb.beep();
            }
        }));
        viewLoadedButton.addMouseListener(onClickMethod(me -> {
            var arga = server.returnDumpedArgumentation();
            popupFromArgaGraph(arga, "Loaded Argumentation");
        }));
        tabbedPane1.addChangeListener(e -> {
            JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
            int selectedIndex = tabbedPane.getSelectedIndex();
            if (selectedIndex == 1) {
                Object[][] var = server.getQueryableNodeWithInfo();
                String[] schema = new String[]{"Node ID (I)", "Text"};
                queryableNodes.setModel(new DefaultTableModel(var, schema));
            } else {
                DefaultTableModel model = (DefaultTableModel) queryableNodes.getModel();
                model.setRowCount(0);
            }
        });
        for (var x : AnalysisType.values()) {
            analysisType.addItem(x.toString());
        }
        fillEntryPointsButton.addMouseListener(onClickMethod(e -> {
            entries.removeAll();
            DefaultListModel lm = new DefaultListModel();
            for (int row : queryableNodes.getSelectedRows()) {
                lm.addElement(queryableNodes.getValueAt(row, 0));
            }
            entries.setModel(lm);
        }));
        fillTargetsButton.addMouseListener(onClickMethod(e -> {
            targets.removeAll();
            DefaultListModel lm = new DefaultListModel();
            for (int row : queryableNodes.getSelectedRows()) {
                lm.addElement(queryableNodes.getValueAt(row, 0));
            }
            targets.setModel(lm);
        }));
        fillObjectivesButton.addMouseListener(onClickMethod(e -> {
            objectives.removeAll();
            DefaultListModel lm = new DefaultListModel();
            for (int row : queryableNodes.getSelectedRows()) {
                lm.addElement(queryableNodes.getValueAt(row, 0));
            }
            objectives.setModel(lm);
        }));
        Run.addMouseListener(onClickMethod(e-> {
            queryResult.setText("");
            MultiValueMap<String, String> args = new LinkedMultiValueMap<>();
            for (int i = 0, n = entries.getModel().getSize(); i<n; i++) {
                args.add("query", entries.getModel().getElementAt(i).toString());
            }
            args.add("type",  analysisType.getItemAt(analysisType.getSelectedIndex()).toString());
            if (isGroundedOtherwisePreferredCheckBox.isSelected()) {
                args.add("semantics", "grounded");
            } else {
                args.add("semantics", "preferred");
            }
            for (int i = 0, n = targets.getModel().getSize(); i<n; i++) {
                args.add("target", targets.getModel().getElementAt(i).toString());
            }
            for (int i = 0, n = objectives.getModel().getSize(); i<n; i++) {
                args.add("objective", objectives.getModel().getElementAt(i).toString());
            }
            args.add("errorLevel", String.valueOf(((double)errorLevel.getValue())/(100.0)));
            args.add("threads", "1");
            queryResult.setText(server.southamptonQuery(args));
        }));

        frame = new JFrame("ARGA GUI");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsEnvironment env =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        frame.setMaximizedBounds(env.getMaximumWindowBounds());
        frame.setExtendedState(frame.getExtendedState() | Frame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

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
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        if (!server.hasGoldenRetriever()) {
            JOptionPane.showMessageDialog(null, "Python GolenRetriever (mock_miner.py) is not running: this program will stop", "Service Missing", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        server.listCorpora().forEach(x-> {
            var basicElement = new DefaultMutableTreeNode(x);
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
