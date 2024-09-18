package bms1.bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener {

	JRadioButton r1, r2, r3, r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String formno;

	SignupThree(String formno) {
		this.formno = formno;
		setLayout(null);

		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(280, 35, 400, 40);
		add(l1);

		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Raleway", Font.BOLD, 22));
		type.setBounds(100, 120, 200, 30);
		add(type);

		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD, 16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100, 180, 150, 20);
		add(r1);

		r2 = new JRadioButton("Fixed Deposite Account");
		r2.setFont(new Font("Raleway", Font.BOLD, 16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350, 180, 250, 20);
		add(r2);

		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway", Font.BOLD, 16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100, 220, 250, 20);
		add(r3);

		r4 = new JRadioButton("Recurring Deposite Account");
		r4.setFont(new Font("Raleway", Font.BOLD, 16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350, 220, 250, 20);
		add(r4);

		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);

		JLabel card = new JLabel("Card_Number");
		card.setFont(new Font("Raleway", Font.BOLD, 22));
		card.setBounds(100, 270, 200, 30);
		add(card);

		JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
		number.setFont(new Font("Raleway", Font.BOLD, 22));
		number.setBounds(330, 270, 300, 30);
		add(number);

		JLabel carddetail = new JLabel("Your 16 digit card number");
		carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
		carddetail.setBounds(100, 300, 300, 20);
		add(carddetail);

		JLabel pin = new JLabel("Pin");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100, 340, 200, 30);
		add(pin);

		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
		pnumber.setBounds(330, 340, 300, 30);
		add(pnumber);

		JLabel pindetails = new JLabel("Your four digit pin");
		pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
		pindetails.setBounds(100, 370, 300, 30);
		add(pindetails);

		JLabel Services = new JLabel("Services required:");
		Services.setFont(new Font("Raleway", Font.BOLD, 22));
		Services.setBounds(100, 420, 200, 30);
		add(Services);

		c1 = new JCheckBox("ATM Card");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBounds(100, 470, 200, 30);
		add(c1);

		c2 = new JCheckBox("Internet banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBounds(350, 470, 200, 30);
		add(c2);

		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBounds(100, 520, 230, 30);
		add(c3);

		c4 = new JCheckBox("Email & SMS");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBounds(350, 520, 200, 30);
		add(c4);

		c5 = new JCheckBox("Check book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBounds(100, 570, 200, 30);
		add(c5);

		c6 = new JCheckBox("E-statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBounds(350, 570, 200, 30);
		add(c6);

		c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knoweledge");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway", Font.BOLD, 12));
		c7.setBounds(100, 620, 600, 30);
		add(c7);

		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(250, 660, 100, 30);
		submit.addActionListener(this);
		add(submit);

		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(420, 660, 100, 30);
		cancel.addActionListener(this);
		add(cancel);

		getContentPane().setBackground(Color.WHITE);

		setSize(850, 820);
		setLocation(350, 0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SignupThree("");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			String type = null;
			if (r1.isSelected()) {
				type = "Saving Account";
			} else if (r2.isSelected()) {
				type = "Fixed Depodite Account";
			} else if (r3.isSelected()) {
				type = "Curent Account";
			} else if (r4.isSelected()) {
				type = "Reccuring Deposite Account";
			}

			Random random = new Random();
			String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

			String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

			String facility = "";
			if (c1.isSelected()) {
				facility = facility + "ATM Card";
			} else if (c2.isSelected()) {
				facility = facility + "Internet Banking";
			} else if (c3.isSelected()) {
				facility = facility + "Mobile Banking";
			} else if (c4.isSelected()) {
				facility = facility + "Email & SMS Alerts Banking";
			} else if (c5.isSelected()) {
				facility = facility + "Check Book ";
			} else if (c6.isSelected()) {
				facility = facility + "E-statement";
			}

			try {
				if (type.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is required");
				} else {
					Conn conn = new Conn();
					String query1 = "insert into signupthree values('" + formno + "','" + type + "','" + cardnumber
							+ "','" + pinnumber + "','" + facility + "')";
					String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber
							+ "')";

					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);

					JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n pin: " + pinnumber);

					setVisible(true);
					new Deposite(pinnumber).setVisible(false);
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}

		} else if (e.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}

	}

}
