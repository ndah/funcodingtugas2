package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import funcoding.Tugas2Loop;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiTugas2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTugas2 frame = new GuiTugas2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiTugas2() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuiTugas2.class.getResource("/res/10.png")));
		setTitle("FunCoding Tugas 2 - Loop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 500);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu game = new JMenu("Game");
		menuBar.add(game);
		
		JMenuItem newGame = new JMenuItem("New");
		game.add(newGame);
		
		JMenuItem giveUp = new JMenuItem("See Asnwer");
		game.add(giveUp);
		
		JMenu quit = new JMenu("Quit");
		menuBar.add(quit);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JLabel hangman = new JLabel("");
		hangman.setVerticalAlignment(SwingConstants.TOP);
		hangman.setIcon(new ImageIcon(GuiTugas2.class.getResource("/res/10.png")));
		hangman.setBounds(10, 11, 270, 281);
		layeredPane.add(hangman);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		final JLabel labelHuruf = new JLabel();
		labelHuruf.setBounds(100, 100, 200, 200);
		panel.setBounds(289, 11, 271, 279);
		layeredPane.add(panel);
		
		
		
		JButton[] alphabet = new JButton[26]; 
		for(int i = 'A'; i <= 'Z'; i++){
			char button = (char) i;
			alphabet[i-'A'] = new JButton(""+button);
			alphabet[i-'A'].setFont(new Font("Consolas", Font.PLAIN, 14));
			final int huruf = i;
			alphabet[i-'A'].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
	            {
	                System.out.println("You clicked the "+ (char) huruf +" button");
	                labelHuruf.setText(labelHuruf.getText() + (char) huruf);
	            }
			});
			panel.add(alphabet[i-'A']);
		}
		
		JButton tes = new JButton("tes");
		tes.setFont(new Font("Consolas", Font.PLAIN, 11));
		panel.add(tes);
		panel.add(labelHuruf);
	}
	
}
