import javax.swing.*;

public class JFrameClick extends JFrame {
	public static void main(String[] args) {
		JFrame window = new JFrame("Alex's Window");
		JPanel panel = new JPanel();
		JButton button = new JButton("Click me!");
		panel.add(button);
		window.add(panel);
		window.setSize(300,100);
		button.addActionListener(e -> System.out.println("Ouch! You clicked me!"));
		window.setVisible(true);	
	}
}

/*
% javac JFrameClick.java

% java JFrameClick
Ouch! You clicked me!
Ouch! You clicked me!
Ouch! You clicked me!
Ouch! You clicked me!
*/