package bms1.bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener {

	JButton deposite, withdraw, fastcash, ministatement, pinchange, balanceenqueiry, exit;
	String pinnumber;

	Transaction(String pinnumber) {
		this.pinnumber = pinnumber;

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bankmanagement project/icon/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 850);
		add(image);

		JLabel text = new JLabel("Please select Your Transaction");
		text.setBounds(215, 280, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);

		deposite = new JButton("Deposite");
		deposite.setBounds(170, 395, 150, 30);
		deposite.addActionListener(this);
		image.add(deposite);

		withdraw = new JButton("Cash Withdraw");
		withdraw.setBounds(355, 395, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);

		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170, 430, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);

		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(355, 430, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);

		pinchange = new JButton("Pin Change");
		pinchange.setBounds(170, 465, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);

		balanceenqueiry = new JButton("Balance Enqueiry");
		balanceenqueiry.setBounds(355, 465, 150, 30);
		balanceenqueiry.addActionListener(this);
		image.add(balanceenqueiry);

		exit = new JButton("Exit");
		exit.setBounds(355, 500, 150, 30);
		exit.addActionListener(this);
		image.add(exit);

		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Transaction("");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			System.exit(0);
		} else if (e.getSource() == deposite) {
			setVisible(false);
			new Deposite(pinnumber).setVisible(true);
		} else if (e.getSource() == withdraw) {
			setVisible(false);
			new Withdraw(pinnumber).setVisible(true);
		} else if (e.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}

	}
}
