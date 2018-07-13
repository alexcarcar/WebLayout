import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

class SwingFC implements ActionListener, ItemListener {
    JTextField jtfFirst;
    JTextField jtfSecond;
    JCheckBox jcbDifference;
    JButton jbtnComp;
    JLabel jlabFirst, jlabSecond;
    JLabel jlabResult;
    boolean showDifference = false;

    SwingFC() {
        JFrame jfrm = new JFrame("Compare Files");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(230, 230);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtfFirst = new JTextField(14);
        jtfSecond = new JTextField(14);
        jtfFirst.setActionCommand("fileA");
        jtfFirst.setActionCommand("fileB");
        JButton jbtnComp = new JButton("Compare");
        jbtnComp.addActionListener(this);
        jlabFirst = new JLabel("First file: ");
        jlabSecond = new JLabel("Second file: ");
        jcbDifference = new JCheckBox("Show position of mismatch");
        jcbDifference.addItemListener(this);

        jlabResult = new JLabel("");
        jfrm.add(jlabFirst);
        jfrm.add(jtfFirst);
        jfrm.add(jlabSecond);
        jfrm.add(jtfSecond);
        jfrm.add(jcbDifference);
        jfrm.add(jbtnComp);
        jfrm.add(jlabResult);
        jfrm.setVisible(true);
    }

    public void itemStateChanged(ItemEvent ie) {
        JCheckBox cb = (JCheckBox) ie.getItem();
        showDifference = cb.isSelected();
    }

    public void actionPerformed(ActionEvent ae) {
        int i = 0, j = 0, n = 0;
        if (jtfFirst.getText().equals("")) {
            jlabResult.setText("First file name missing.");
            return;
        }
        if (jtfSecond.getText().equals("")) {
            jlabResult.setText("Second file name missing.");
            return;
        }
        try (FileInputStream f1 = new FileInputStream(jtfFirst.getText());
             FileInputStream f2 = new FileInputStream(jtfSecond.getText());
        ) {
            do {
                i = f1.read();
                j = f2.read();
                n++;
                if (i != j) break;
            } while (i != -1 && j != -1);
            if (i != j) {
                if (showDifference) {
                    jlabResult.setText("Files are different at " + n + ".");
                } else {
                    jlabResult.setText("Files are not the same.");
                }
            } else {
                jlabResult.setText("Files compare equal.");
            }
        } catch (IOException e) {
            jlabResult.setText("File Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingFC();
            }
        });
    }
}
