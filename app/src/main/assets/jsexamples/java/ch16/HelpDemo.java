import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.io.*;
import java.util.*;

// Demonstrate a simple JList.
class HelpDemo implements ListSelectionListener {
    JList<String> jlst;
    JLabel jlab;
    JScrollPane jscrlp;
    String names[] = {"if", "switch", "for", "while", "do-while", "break", "continue"};

    HelpDemo() {
        JFrame jfrm = new JFrame("Help Demo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(200, 330);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlst = new JList<String>(names);
        jlst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jscrlp = new JScrollPane(jlst);
        jscrlp.setPreferredSize(new Dimension(120, 130));
        jlab = new JLabel("<html><br/>Please choose a keyword</html>");
        jlab.setBackground(Color.WHITE);
        jlst.addListSelectionListener(this);
        jfrm.add(jscrlp);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public void valueChanged(ListSelectionEvent le) {
        jlab.setText(helpOn(jlst.getSelectedIndex()));
    }

    static void main() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HelpDemo();
            }
        });
    }

    String helpOn(int what) {
        String str = "<html><br/>";
        switch (what + 1) {
            case 1:
                str += "<u>The if:</u><br/>";
                str += "if(condition) statement;<br/>";
                str += "else statement;<br/>";
                break;

            case 2:
                str += "<u>The switch:</u><br/>";
                str += "switch(expression) {<br/>";
                str += "  case constant:<br/>";
                str += "    statement sequence<br/>";
                str += "    break;<br/>";
                str += "  // ...<br/>";
                str += "}<br/>";
                break;

            case 3:
                str += "<u>The for:</u><br/>";
                str += "for(init; condition; iteration)<br/>";
                str += "&nbsp; statement;<br/>";
                break;

            case 4:
                str += "<u>The while:</u><br/>";
                str += "while(condition) statement;<br/>";
                break;

            case 5:
                str += "<u>The do-while:</u><br/>";
                str += "do {<br/>";
                str += "&nbsp; statement;<br/>";
                str += "} while(condition);<br/>";
                break;

            case 6:
                str += "<u>The break:</u><br/>";
                str += "break; or break label;<br/>";
                break;

            case 7:
                str += "<u>The continue:</u><br/>";
                str += "continue; or continue label;<br/>";
                break;
        }
        return str + "</html>";
    }

    public static void main(String[] args) {
        HelpDemo.main();
    }
}
