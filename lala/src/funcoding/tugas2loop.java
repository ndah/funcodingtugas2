package funcoding;

import gui.GuiTugas2;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * 
 * @author Nur Endah Safitri
 * 
 */
public class Tugas2loop implements ActionListener {
	private String[] countries;
	private boolean[] rightGuesses;
	private static GuiTugas2 frame;
	private int chances;
	private boolean win;
	private String guessThisString;

	/**
	 * Baca String dari file 'Countries.txt' di folder res untuk ke array of
	 * String <code>countries</code>.
	 * 
	 * @throws FileNotFoundException
	 */
	private void loadStrings() {
		Scanner in = new Scanner(
				Tugas2loop.class.getResourceAsStream("/res/countries.txt"));
		countries = new String[199];
		// /////////////////////////////////////////////////////////////////
		// Soal 1
		// For loop untuk membaca input.
		for (int i = 0; i < countries.length; i++) {
			countries[i] = in.nextLine();
		}
		// Soal 1 end
		// /////////////////////////////////////////////////////////////////
	}

	/**
	 * Menampilkan jawaban jika user menjawab benar, mengurangi kesempatan untuk
	 * menebak jika user salah.
	 * 
	 * @param guessThis
	 *            String yang akan dtebak
	 * @param character
	 *            String satu huruf yang dimasukkan
	 */
	public void guess(String character) {
		boolean right = false;
		// /////////////////////////////////////////////////////////////////
		// Soal 2
		// For loop untuk menebak.
		for (int i = 0; i < guessThisString.length(); i++) {
			if (character.equalsIgnoreCase("" + guessThisString.charAt(i))) {
				frame.guessThis[i].setVisible(true);
				rightGuesses[i] = true;
				right = true;
			}
		}
		// Soal 2 end
		// /////////////////////////////////////////////////////////////////

		// /////////////////////////////////////////////////////////////////
		// Soal 3
		// For loop untuk cek apakah sudah menang atau belum.
		win = true;
		for (int i = 0; i < guessThisString.length(); i++) {
			if (!rightGuesses[i]) {
				win = false;
			}
		}
		if (win) {
			frame.setMessage("Correct guess!");
			frame.playAgain.setVisible(true);
		}
		// Soal 3 end
		// /////////////////////////////////////////////////////////////////

		if (!right) {
			--chances;
			frame.changePicture(chances);
			if (chances <= 0) {
				seeAnswer();
				frame.setMessage("Oops, the right answer is: ");
				frame.playAgain.setVisible(true);
			}
		}
	}

	/**
	 * Set semua guessThis jadi visible.
	 */
	public void seeAnswer() {
		chances = 0;
		// /////////////////////////////////////////////////////////////////
		// Soal 4
		// For loop untuk melihat jawaban.
		for (int i = 0; i < guessThisString.length(); i++) {
			frame.guessThis[i].setVisible(true);
		}
		frame.playAgain.setVisible(true);
		// Soal 4 end
		// /////////////////////////////////////////////////////////////////
	}

	/**
	 * Ambil String secara random dari array <code>countries</code>.
	 * 
	 * @return String random dari array <code>countries</code>
	 */
	public String getRandomString() {
		loadStrings();
		Random r = new Random();
		int random = r.nextInt(199);
		guessThisString = countries[random];
		rightGuesses = new boolean[guessThisString.length()];
		return guessThisString;
	}

	/**
	 * Constructor
	 */
	public Tugas2loop() {
		chances = 10;
	}

	/**
	 * Listener untuk semua kejadian.
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof JMenuItem) {
			JMenuItem menu = (JMenuItem) source;
			String command = menu.getText();
			if (command.equals("New")) {
				frame.dispose();
				frame = new GuiTugas2();
				frame.setVisible(true);
			} else if (command.equals("See Answer") && !win) {
				seeAnswer();
				frame.setMessage("Why give up? >_<.");
			} else if (command.equals("Quit")) {
				System.exit(0);
			}
		}
		if (source instanceof JButton) {
			JButton tombol = (JButton) source;
			String command = tombol.getText();
			if (command.equals("Yes")) {
				frame.dispose();
				frame = new GuiTugas2();
				frame.setVisible(true);
			} else if (command.equals("No")) {
				frame.playAgain.setVisible(false);
			} else if (chances > 0 && !win) {
				frame.alphabet[tombol.getText().toUpperCase().charAt(0) - 'A']
						.setEnabled(false);
				guess(tombol.getText());
			}
		}
	}

	/**
	 * Run the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		frame = new GuiTugas2();
		frame.setVisible(true);
	}
}
