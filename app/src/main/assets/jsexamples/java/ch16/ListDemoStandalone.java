import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.io.*;
import java.util.*;

// Demonstrate a simple JList.
class ListDemoStandalone implements ListSelectionListener {
    JList<String> jlst;
    JTextArea jlab;
    JScrollPane jscrlp;
    String names[] = {"Alex", "Carol", "Simon", "George", "Nancy",
            "Lisa", "Samia", "Khader", "Nina", "Natalie", "Malakeh", "Samer"};

    ListDemoStandalone() {
        JFrame jfrm = new JFrame("JList Demo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(200, 210);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Arrays.sort(names);
        jlst = new JList<String>(names);
        jlst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jscrlp = new JScrollPane(jlst);
        jscrlp.setPreferredSize(new Dimension(120, 90));
        jlab = new JTextArea("Please choose a name");
        jlab.setBackground(Color.WHITE);
        jlst.addListSelectionListener(this);
        jfrm.add(jscrlp);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public void valueChanged(ListSelectionEvent le) {
        int[] indices = jlst.getSelectedIndices();
        if (indices.length != 0) {
        	String selectString = "Current selection:\n";
        	for (int i=0; i<indices.length; i++) {
        		selectString += names[indices[i]];
        		selectString += ((i+1)%4 == 0)? "\n": " ";
        	}
            jlab.setText(selectString);
        } else {
            jlab.setText("Please choose a name");
        }
    }

    static void main() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListDemoStandalone();
            }
        });
    }

    public static void main(String[] args) {
        ListDemoStandalone.main();
    }
}
