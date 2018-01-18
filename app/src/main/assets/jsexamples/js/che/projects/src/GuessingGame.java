import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;

	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber) {
				message = guess + " is too low. Try again.";
			} else if (guess > theNumber) {
				message = guess + " is too high. Try again.";
			} else {
				message = guess + " is correct. You win! Let's play again!";
				newGame();
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}

	public void newGame() {
		theNumber = (int)(Math.random()*100+1);
	}

	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Alex's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblAlexsHiloGuessing = new JLabel("Alex's Hi-Lo Guessing Game");
		lblAlexsHiloGuessing.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAlexsHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlexsHiloGuessing.setBounds(0, 36, 434, 30);
		getContentPane().add(lblAlexsHiloGuessing);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessANumber.setBounds(0, 102, 279, 14);
		getContentPane().add(lblGuessANumber);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(172, 152, 89, 23);
		getContentPane().add(btnGuess);
		
		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(289, 99, 44, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 211, 424, 14);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);
	}
}
