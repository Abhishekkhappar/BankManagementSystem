package bms1.bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends JFrame implements ActionListener {

	private static final String Withdraw = "Withdraw";
	JTextField amount;
	JButton withdraw, back;
	String pinnumber;

	Withdraw(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bankmanagement project/icon/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 800);
		add(image);

		JLabel text = new JLabel("Enter amount you want to withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170, 260, 400, 20);
		image.add(text);

		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(170, 310, 320, 25);
		image.add(amount);

		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355, 435, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);

		back = new JButton("Back");
		back.setBounds(355, 470, 150, 30);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Withdraw("");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == withdraw) {
			String number = amount.getText();
			Date date = new Date();
			if (number.equals("")) {
				JOptionPane.showMessageDialog(null, "please enter the amount you want to withdraw");
			} else {
				try {
					Conn conn = new Conn();
					String query = "insert into bank values('" + pinnumber + "','" + date + "','" + Withdraw + "','"
							+ number + "')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		} else if (e.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}

	}
}
