package jackbergus.ARGA.javanatives;

import javax.swing.*;

public class ProgressBarHandler {

    final JProgressBar progressBar1;
    final JFrame parent;
    DefaultBoundedRangeModel model;

    public ProgressBarHandler(JProgressBar progressBar1, JFrame parent) {
        this.progressBar1 = progressBar1;
        this.parent = parent;
        model = null;
    }

    public void init(int min, int max) {
        model = new DefaultBoundedRangeModel();
        model.setMinimum(min);
        model.setMaximum(max);
        model.setValue(min);
        progressBar1.setModel(model);
        progressBar1.paint( progressBar1.getGraphics() );
    }

    public void updateTo(int val) {
        model.setValue(val);
        progressBar1.paint( progressBar1.getGraphics() );
    }

    public void beep() {
        java.awt.Toolkit.getDefaultToolkit().beep();
    }
}
