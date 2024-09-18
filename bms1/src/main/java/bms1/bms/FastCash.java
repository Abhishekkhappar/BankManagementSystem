package bms1.bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {

	JButton deposite, withdraw, fastcash, ministatement, pinchange, balanceenqueiry, exit;
	String pinnumber;

	FastCash(String pinnumber) {
		this.pinnumber = pinnumber;

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bankmanagement project/icon/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 850);
		add(image);

		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(215, 280, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);

		deposite = new JButton("Rs 100");
		deposite.setBounds(170, 395, 150, 30);
		deposite.addActionListener(this);
		image.add(deposite);

		withdraw = new JButton("Rs 500");
		withdraw.setBounds(355, 395, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);

		fastcash = new JButton("Rs 1000");
		fastcash.setBounds(170, 430, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);

		ministatement = new JButton("Rs 2000");
		ministatement.setBounds(355, 430, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);

		pinchange = new JButton("Rs 5000");
		pinchange.setBounds(170, 465, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);

		balanceenqueiry = new JButton("Rs 10000");
		balanceenqueiry.setBounds(355, 465, 150, 30);
		balanceenqueiry.addActionListener(this);
		image.add(balanceenqueiry);

		exit = new JButton("Back");
		exit.setBounds(355, 500, 150, 30);
		exit.addActionListener(this);
		image.add(exit);

		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FastCash("");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		} else {
			String amount = ((JButton) e.getSource()).getText().substring(3);
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pinnumber + "'");
				int balance = 0;
				while (rs.next()) {
					if (rs.getString("type").equals("Deposite")) {
						balance += Integer.parseInt(rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}

				if (e.getSource() != exit && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
					return;
				}
				else {
				Date date = new Date();
				String query = ("insert into bank values('" + pinnumber + "','" + date + "','" + withdraw
						+ "','"
						+ amount + "')");
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs " + amount + "Debited Sucessfully");
				}
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			} catch (Exception ae) {
				System.out.println(ae);
			}
		}

	}
}
