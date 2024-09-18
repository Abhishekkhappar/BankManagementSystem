package bms1.bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	JButton login, signup, clear;// i had declared globally so that i can access outside the constructor
	JTextField cardTextField;
	JPasswordField pinTextField;

	Login() {
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bankmanagement project/icon/icons/logo.jpg"));// adding
																													// image
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // set image size and directly it
																					// will not come under Jlabel we
																					// have ti conver it into ImageIcon
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);

		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 36));
		text.setBounds(200, 40, 400, 40);
		add(text);// logo and font

		JLabel cardno = new JLabel("Card no :");
		cardno.setFont(new Font("Railway", Font.BOLD, 28));
		cardno.setBounds(120, 150, 150, 30);
		add(cardno);// card no

		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);// setting textfield to card

		JLabel pin = new JLabel("PIN :");
		pin.setFont(new Font("Railway", Font.BOLD, 28));
		pin.setBounds(120, 220, 250, 30);
		add(pin);// pin no

		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTextField);// setting textfield to pin

		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);// signin button

		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);

		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);

		getContentPane().setBackground(Color.WHITE);
		setSize(800, 480);
		setVisible(true);
		setLocation(350, 200);
	}

	public static void main(String[] args) {
		new Login();
	}

	public void actionPerformed(ActionEvent e) {// this is used for which action to be performed like login,sign
												// up,clear
		if (e.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		} else if (e.getSource() == login) {
			Conn c = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "select * from login where cardnumber = '" + cardnumber + "' and pin='" + pinnumber + "'";
			try {
				ResultSet rs = c.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin");
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}

		} else if (e.getSource() == signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}

	}
}
