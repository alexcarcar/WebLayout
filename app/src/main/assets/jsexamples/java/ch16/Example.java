import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

class SwingDemo {
	SwingDemo() {
		JFrame jfrm = new JFrame("A Simple Swing Application");
		jfrm.setSize(275, 100);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel jlab = new JLabel(" GUI programming with Swing.");
		jfrm.add(jlab);
		jfrm.setVisible(true);
	}	

	static void main() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingDemo();
			}
		});
	}
}

// Demonstrate a push button and handle action events
class ButtonDemo implements ActionListener {
	JLabel jlab;
	ButtonDemo() {
		JFrame jfrm = new JFrame("A Button Example");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(220, 90);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton jbtnUp = new JButton("Up");
		JButton jbtnDown = new JButton("Down");
		jbtnUp.addActionListener(this);
		jbtnDown.addActionListener(this);
		jfrm.add(jbtnUp);
		jfrm.add(jbtnDown);
		jlab = new JLabel("Press a button.");
		jfrm.add(jlab);
		jfrm.setVisible(true);
	}

	// Handle button events.
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Up")) {
			jlab.setText("You pressed up.");
		} else {
			jlab.setText("You pressed down.");
		}
	}

	static void main() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ButtonDemo();
			}
		});
	}
}

// Use a text field.
class TFDemo implements ActionListener {
	JTextField jtf;
	JButton jbtnRev;
	JLabel jlabPrompt, jlabContents;

	TFDemo() {
		JFrame jfrm = new JFrame("Use a Text Field");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(240, 120);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtf = new JTextField(10);
		jtf.setActionCommand("myTF");
		JButton jbtnRev = new JButton("Reverse");

		jtf.addActionListener(this);
		jbtnRev.addActionListener(this);
		jlabPrompt = new JLabel("Enter text: ");
		jlabContents = new JLabel("");
		jfrm.add(jlabPrompt);
		jfrm.add(jtf);
		jfrm.add(jbtnRev);
		jfrm.add(jlabContents);
		jfrm.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Reverse")) {
			String orgStr = jtf.getText();
			String resStr = "";
			for (int i=orgStr.length()-1; i>=0; i--) {
				resStr += orgStr.charAt(i);
			}
			jtf.setText(resStr);
		} else {
			jlabContents.setText("You pressed ENTER.  Text is: " + jtf.getText());
		}
	}

	static void main() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TFDemo();
			}
		});
	}
}

// Demonstrate check boxes.
class CBDemo implements ItemListener {
	JLabel jlabSelected;
	JLabel jlabChanged;
	JCheckBox jcbAlpha;
	JCheckBox jcbBeta;
	JCheckBox jcbGamma;

	CBDemo() {
		JFrame jfrm = new JFrame("Demonstrate Check Boxes");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(280, 120);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jlabSelected = new JLabel("");
		jlabChanged = new JLabel("");
		jcbAlpha = new JCheckBox("Alpha");
		jcbBeta = new JCheckBox("Beta");
		jcbGamma = new JCheckBox("Gamma");
		jcbAlpha.addItemListener(this);
		jcbBeta.addItemListener(this);
		jcbGamma.addItemListener(this);
		jfrm.add(jcbAlpha);
		jfrm.add(jcbBeta);
		jfrm.add(jcbGamma);
		jfrm.add(jlabChanged);
		jfrm.add(jlabSelected);
		jfrm.setVisible(true);
	}

	public void itemStateChanged(ItemEvent ie) {
		String str = "";
		JCheckBox cb = (JCheckBox) ie.getItem();
		if (cb.isSelected()) {
			jlabChanged.setText(cb.getText() + " was just selected.");
		} else {
			jlabChanged.setText(cb.getText() + " was just cleared.");
		}

		if (jcbAlpha.isSelected()) str += "Alpha ";
		if (jcbBeta.isSelected()) str += "Beta ";
		if (jcbGamma.isSelected()) str += "Gamma ";
		jlabSelected.setText("Selected check boxes: " + str);
	}

	static void main() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CBDemo();
			}
		});
	}
}

// Demonstrate a simple JList.
class ListDemo implements ListSelectionListener {
	JList<String> jlst;
	JLabel jlab;
	JScrollPane jscrlp;
	String names[] = {"Alex", "Carol", "Simon", "George", "Nancy",
		"Lisa", "Samia", "Khader", "Nina", "Natalie", "Malakeh", "Samer"};

	ListDemo() {
		JFrame jfrm = new JFrame("JList Demo");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(200, 160);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Arrays.sort(names);
		jlst = new JList<String>(names);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jscrlp = new JScrollPane(jlst);
		jscrlp.setPreferredSize(new Dimension(120, 90));
		jlab = new JLabel("Please choose a name");
		jlst.addListSelectionListener(this);
		jfrm.add(jscrlp);
		jfrm.add(jlab);
		jfrm.setVisible(true);
	}

	public void valueChanged(ListSelectionEvent le) {
		int idx = jlst.getSelectedIndex();
		if (idx != -1) {
			jlab.setText("Current selection: " + names[idx]);
		} else {
			jlab.setText("Please choose a name");
		}
	}

	static void main() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ListDemo();
			}
		});
	}
}
class Example {
	public static void main(String[] args) {
		System.out.println("Menu");
		System.out.println("1. SwingDemo");
		System.out.println("2. ButtonDemo");
		System.out.println("3. TFDemo");
		System.out.println("4. CBDemo");
		System.out.println("5. ListDemo");
		System.out.println();
		Scanner in = new Scanner(System.in);
		switch(in.nextLine()) {
			case "1": SwingDemo.main(); break;
			case "2": ButtonDemo.main(); break;
			case "3": TFDemo.main(); break;
			case "4": CBDemo.main(); break;
			case "5": ListDemo.main(); break;
		}
	}
}