
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JFrame;

public class TypingTutor extends JFrame implements ActionListener {

	private JLabel lbltimer;
	private JLabel lblscore;
	private JLabel lblword;
	private JTextField txtword;
	private JButton btnstart;
	private JButton btnstop;

	private int timerem = 0;
	private String[] word = null;
	private Timer time;
	private boolean running;

	private int score = 0;

	public TypingTutor(String[] args) {
		word = args;

		GridLayout layout = new GridLayout(3, 2);
		super.setLayout(layout);

		Font font = new Font("chiller", 1, 50);
		lbltimer = new JLabel("TIMER");
		lbltimer.setFont(font);
		lbltimer.setForeground(Color.RED);
		lbltimer.setToolTipText("time left");
		lbltimer.setAlignmentX(Component.RIGHT_ALIGNMENT);

		super.add(lbltimer);

		lblscore = new JLabel("SCORE");
		lblscore.setFont(font);
		super.add(lblscore);

		lblword = new JLabel("WORD");
		lblword.setFont(font);
		super.add(lblword);

		txtword = new JTextField("TEXT");
		txtword.setFont(font);
		super.add(txtword);

		btnstart = new JButton("START");
		btnstart.setFont(font);
		btnstart.addActionListener(this);
		super.add(btnstart);

		btnstop = new JButton("STOP");
		btnstop.setFont(font);
		btnstop.addActionListener(this);
		super.add(btnstop);

		super.setVisible(true);
		super.setTitle("typing tutor");
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setproperties();
	}

	private void setproperties() {
		time = new Timer(2000, this);
		timerem = 5;
		score = 0;

		lblscore.setText("SCORE :" + score);
		lbltimer.setText("TIME: " + timerem);
		txtword.setText("");
		btnstart.setText("START");
		btnstop.setText("STOP");

		txtword.setEnabled(false);
		btnstop.setEnabled(false);

		running = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnstart) {
			handlestart();
		} else if (e.getSource() == btnstop) {
			handlestop();
		} else {
			handletimer();
			// if (e.getSource() == time)
		}
	}

	private void handlestop() {
		// JOptionPane.showMessageDialog(this, "STOP WAS CLICKED");

		time.stop();

		int choice = JOptionPane.showConfirmDialog(this, "Score:" + score + "replay?");

		if (choice == JOptionPane.YES_OPTION) {
			setproperties();
			handlestart();
		} else if (choice == JOptionPane.NO_OPTION) {
			super.dispose();
		} else {

			if (timerem < 0) {
				setproperties();
			} else {
				time.start();
			}

		}

	}

	private void handlestart() {
		// JOptionPane.showMessageDialog(this, "START WAS CLICKED");

		if (running) {
			running = false;
			time.stop();
			txtword.setEnabled(false);
			btnstop.setEnabled(false);
			btnstart.setText("RESUME");

		} else {
			running = true;
			time.start();
			txtword.setEnabled(true);
			btnstop.setEnabled(true);
			btnstart.setText("PAUSE");
			txtword.setText("");

		}

	}

	private void handletimer() {
		timerem--;

		String actual, expected;

		actual = txtword.getText();
		expected = lblword.getText();

		if (actual.equals(expected) && actual.length() > 0) {
			++score;
		}
		lblscore.setText("SCORE:" + score);
		lbltimer.setText("TIME:" + timerem);

		if (timerem == 0) {
			lblword.setText("");
			handlestop();
		} else {

			int ridx = (int) (Math.random() * word.length);
			lblword.setText(word[ridx]);
			txtword.setText("");
		}

	}

}
