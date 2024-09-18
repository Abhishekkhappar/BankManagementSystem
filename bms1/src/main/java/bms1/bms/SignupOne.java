package bms1.bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Random;
import com.toedter.calendar.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupOne extends JFrame implements ActionListener {

	long random;
	JTextField nameTextField, fnameTextField, email1TextField, adds, city1, state1, pincode1;
	JButton next;
	JRadioButton male, female, dob, other, married, unmarried;

	SignupOne() {
		setLayout(null);

		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000l) + 1000l);

		JLabel formno = new JLabel("APPLICSTION FORM NO." + random);
		formno.setFont(new Font("Railway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);

		JLabel persondetails = new JLabel("Page 1:Personal Details");
		persondetails.setFont(new Font("Railway", Font.BOLD, 22));
		persondetails.setBounds(290, 80, 400, 30);
		add(persondetails);

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Railway", Font.BOLD, 22));
		name.setBounds(100, 140, 100, 30);
		add(name);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Railway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);

		JLabel Fname = new JLabel("Father_Name:");
		Fname.setFont(new Font("Railway", Font.BOLD, 22));
		Fname.setBounds(100, 190, 200, 30);
		add(Fname);

		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Railway", Font.BOLD, 14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);

		JLabel dob = new JLabel("Date_of_birth:");
		dob.setFont(new Font("Railway", Font.BOLD, 22));
		dob.setBounds(100, 240, 200, 30);
		add(dob);

		JDateChooser datechooser = new JDateChooser();
		datechooser.setBounds(300, 240, 400, 30);
		add(datechooser);

		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Railway", Font.BOLD, 22));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		male = new JRadioButton("male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);

		female = new JRadioButton("female");
		female.setBounds(450, 290, 120, 30);
		female.setBackground(Color.WHITE);
		add(female);

		ButtonGroup group = new ButtonGroup();
		group.add(male);
		group.add(female);

		JLabel email = new JLabel("Email address:");
		email.setFont(new Font("Railway", Font.BOLD, 22));
		email.setBounds(100, 340, 200, 30);
		add(email);

		email1TextField = new JTextField();
		email1TextField.setFont(new Font("Railway", Font.BOLD, 14));
		email1TextField.setBounds(300, 340, 400, 30);
		add(email1TextField);

		JLabel marital = new JLabel("Marital_status:");
		marital.setFont(new Font("Railway", Font.BOLD, 22));
		marital.setBounds(100, 390, 200, 30);
		add(marital);

		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);

		unmarried = new JRadioButton("Umarried");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);

		other = new JRadioButton("other");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.WHITE);
		add(other);

		ButtonGroup group1 = new ButtonGroup();
		group1.add(married);
		group1.add(unmarried);
		group1.add(other);

		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Railway", Font.BOLD, 22));
		address.setBounds(100, 440, 200, 30);
		add(address);

		adds = new JTextField();
		adds.setFont(new Font("Railway", Font.BOLD, 14));
		adds.setBounds(300, 440, 400, 30);
		add(adds);

		JLabel city = new JLabel("city:");
		city.setFont(new Font("Railway", Font.BOLD, 22));
		city.setBounds(100, 490, 200, 30);
		add(city);

		city1 = new JTextField();
		city1.setFont(new Font("Railway", Font.BOLD, 14));
		city1.setBounds(300, 490, 400, 30);
		add(city1);

		JLabel state = new JLabel("State:");
		state.setFont(new Font("Railway", Font.BOLD, 22));
		state.setBounds(100, 540, 200, 30);
		add(state);

		state1 = new JTextField();
		state1.setFont(new Font("Railway", Font.BOLD, 14));
		state1.setBounds(300, 540, 400, 30);
		add(state1);

		JLabel pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Railway", Font.BOLD, 22));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);

		pincode1 = new JTextField();
		pincode1.setFont(new Font("Railway", Font.BOLD, 14));
		pincode1.setBounds(300, 590, 400, 30);
		add(pincode1);

		next = new JButton("NEXT");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.WHITE);// it makes the background color as white

		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SignupOne();
	}

	public void actionPerformed(ActionEvent e) {
		String formno = "" + random; // long no converted into String
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = JDateChooser.getDefaultLocale().getCountry();
		String gender = null;
		if (male.isSelected()) {
			gender = "male";
		} else if (female.isSelected()) {
			gender = "female";
		}
		String email = email1TextField.getText();
		String marital = null;
		if (married.isSelected()) {
			marital = "Married";
		} else if (unmarried.isSelected()) {
			marital = "Unmarried";
		} else if (other.isSelected()) {
			marital = "Other";
		}
		String address = adds.getText();
		String city = city1.getText();
		String state = state1.getText();
		String pin = pincode1.getText();
		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			} else {
				Conn c = new Conn();
				String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob
						+ "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','"
						+ state + "','" + pin + "')";
				c.s.executeUpdate(query);

				setVisible(false);
				new SignupTwo(formno).setVisible(true);
			}

		} catch (Exception ee) {
			System.out.println(ee);
		}

	}

}
