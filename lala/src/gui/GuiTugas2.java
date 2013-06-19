package gui;

import funcoding.Tugas2loop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GuiTugas2 extends JFrame {

	public Tugas2loop t;
	public JLabel guessThis[];
	public JButton[] alphabet;
	public JPanel playAgain;
	private JPanel contentPane;
	private JLabel messageLabel;
	private JLabel hangman;

	/**
	 * Create the frame.
	 */
	public GuiTugas2() {
		t = new Tugas2loop();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				GuiTugas2.class.getResource("/res/10.png")));
		setTitle("FunCoding Tugas 2 - Loop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 500);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);

		JMenu game = new JMenu("Game");
		menuBar.add(game);

		JMenuItem newGame = new JMenuItem("New");
		newGame.addActionListener(t);
		game.add(newGame);

		JMenuItem giveUp = new JMenuItem("See Answer");
		giveUp.addActionListener(t);
		game.add(giveUp);

		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		game.add(quit);

		JLayeredPane mainPanel = new JLayeredPane();
		contentPane.add(mainPanel);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[] { 280, 261, 0 };
		gbl_mainPanel.rowHeights = new int[] { 291, 150, 0 };
		gbl_mainPanel.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_mainPanel.rowWeights = new double[] { 0.0, 0.0, 1.0 };
		mainPanel.setLayout(gbl_mainPanel);

		JPanel hangmanPanel = new JPanel();
		GridBagConstraints gbc_hangmanPanel = new GridBagConstraints();
		gbc_hangmanPanel.insets = new Insets(0, 0, 0, 5);
		gbc_hangmanPanel.fill = GridBagConstraints.BOTH;
		gbc_hangmanPanel.gridx = 0;
		gbc_hangmanPanel.gridy = 0;
		mainPanel.add(hangmanPanel, gbc_hangmanPanel);

		hangman = new JLabel("");
		hangman.setHorizontalAlignment(SwingConstants.CENTER);
		hangman.setFont(new Font("Kristen ITC", Font.PLAIN, 22));
		hangmanPanel.add(hangman);
		hangman.setText("Hangman");

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		mainPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 261, 0 };
		gbl_panel.rowHeights = new int[] {50, 30, 50, 30, 0};
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0 };
		panel.setLayout(gbl_panel);

		JPanel message = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) message.getLayout();
		GridBagConstraints gbc_message = new GridBagConstraints();
		gbc_message.fill = GridBagConstraints.HORIZONTAL;
		gbc_message.anchor = GridBagConstraints.NORTH;
		gbc_message.insets = new Insets(0, 0, 5, 0);
		gbc_message.gridx = 0;
		gbc_message.gridy = 0;
		panel.add(message, gbc_message);

		messageLabel = new JLabel("Guess the country name!");
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		message.add(messageLabel);

		JPanel guess = new JPanel();
		guess.setLayout(null);
		GridBagConstraints gbc_guess = new GridBagConstraints();
		gbc_guess.fill = GridBagConstraints.BOTH;
		gbc_guess.anchor = GridBagConstraints.NORTH;
		gbc_guess.insets = new Insets(0, 0, 5, 0);
		gbc_guess.gridx = 0;
		gbc_guess.gridy = 2;
		panel.add(guess, gbc_guess);
		
		JPanel pointer = new JPanel();
		pointer.setLayout(null);
		GridBagConstraints gbc_pointer = new GridBagConstraints();
		gbc_pointer.insets = new Insets(0, 0, 5, 0);
		gbc_pointer.fill = GridBagConstraints.BOTH;
		gbc_pointer.anchor = GridBagConstraints.NORTH;
		gbc_pointer.gridx = 0;
		gbc_pointer.gridy = 3;
		panel.add(pointer, gbc_pointer);
		
		playAgain = new JPanel();
		GridBagConstraints gbc_playAgain = new GridBagConstraints();
		gbc_playAgain.fill = GridBagConstraints.BOTH;
		gbc_playAgain.gridx = 0;
		gbc_playAgain.gridy = 4;
		panel.add(playAgain, gbc_playAgain);
		
		JLabel playAgainLabel = new JLabel("Play Again?");
		playAgainLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		playAgain.add(playAgainLabel);
		playAgain.setVisible(false);
		
		JButton yesPlay = new JButton("Yes");
		playAgain.add(yesPlay);
		yesPlay.addActionListener(t);
		
		JButton noPlay = new JButton("No");
		playAgain.add(noPlay);
		noPlay.addActionListener(t);

		JPanel button = new JPanel();
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridwidth = 2;
		gbc_button.gridy = 1;
		gbc_button.gridx = 0;
		mainPanel.add(button, gbc_button);

		String guessThisString = t.getRandomString();
		guessThis = new JLabel[guessThisString.length()];
		for (int i = 0; i < guessThisString.length(); i++) {
			guessThis[i] = new JLabel("" + guessThisString.charAt(i));
			guess.add(guessThis[i]);
			guessThis[i].setForeground(Color.GRAY);
			guessThis[i].setFont(new Font("Consolas", Font.PLAIN, 17));
			guessThis[i].setBounds(i*15, 0, 15, 15);
			guessThis[i].setVisible(false);
		}

		JLabel hide[] = new JLabel[guessThisString.length()];
		for (int i = 0; i < guessThisString.length(); i++) {
			hide[i] = new JLabel("-");
			pointer.add(hide[i]);
			hide[i].setForeground(Color.GRAY);
			hide[i].setFont(new Font("Consolas", Font.PLAIN, 17));
			hide[i].setBounds(i*15, 0, 15, 15);
		}

		alphabet = new JButton[26];
		for (int i = 'A'; i <= 'Z'; i++) {
			char b = (char) i;
			alphabet[i - 'A'] = new JButton("" + b);
			alphabet[i - 'A'].setFont(new Font("Consolas", Font.PLAIN, 14));
			button.add(alphabet[i - 'A']);
			alphabet[i - 'A'].addActionListener(t);
		}
	}

	public void changePicture(int a) {
		String res = "/res/" + (10 - a) + ".png";
		hangman.setIcon(new ImageIcon(GuiTugas2.class.getResource(res)));
		hangman.setText("");
	}

	public void setMessage(String s) {
		messageLabel.setText(s);
	}
}
