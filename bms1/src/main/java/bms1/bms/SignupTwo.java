package bms1.bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener {

	JTextField pan, aadhar;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JComboBox religion, category, Income, occupation, education;
	String formno;

	SignupTwo(String formno) {
		this.formno = formno;
		setLayout(null);

		setTitle("NEW ACCOUNT APPLICATION FORM:PAGE 2");

		JLabel additionaldetails = new JLabel("Page 2:Additional Details");
		additionaldetails.setFont(new Font("Railway", Font.BOLD, 22));
		additionaldetails.setBounds(290, 80, 400, 30);
		add(additionaldetails);

		JLabel name = new JLabel("Religion:");
		name.setFont(new Font("Railway", Font.BOLD, 22));
		name.setBounds(100, 140, 100, 30);
		add(name);

		String val[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
		religion = new JComboBox(val);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);

		JLabel Fname = new JLabel("Category:");
		Fname.setFont(new Font("Railway", Font.BOLD, 22));
		Fname.setBounds(100, 190, 200, 30);
		add(Fname);

		String valc[] = { "Genral", "OBC", "SC", "ST", "Other" };
		category = new JComboBox(valc);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);

		JLabel dob = new JLabel("Income:");
		dob.setFont(new Font("Railway", Font.BOLD, 22));
		dob.setBounds(100, 240, 200, 30);
		add(dob);

		String valI[] = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "upto 10,00,000" };
		Income = new JComboBox(valI);
		Income.setBounds(300, 240, 400, 30);
		Income.setBackground(Color.WHITE);
		add(Income);

		JLabel gender = new JLabel("Educational:");
		gender.setFont(new Font("Railway", Font.BOLD, 22));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		JLabel email = new JLabel("Qualification:");
		email.setFont(new Font("Railway", Font.BOLD, 22));
		email.setBounds(100, 315, 200, 30);
		add(email);

		String eduvalued[] = { "Non Graduate", "Graduation", "PG", "Dr", "Others" };
		education = new JComboBox(eduvalued);
		education.setBounds(300, 315, 400, 30);
		add(education);

		JLabel marital = new JLabel("Occupation:");
		marital.setFont(new Font("Railway", Font.BOLD, 22));
		marital.setBounds(100, 390, 200, 30);
		add(marital);

		String occupationalvalues[] = { "Salaried", "Self_employed", "Bussiness", "Student", "Retirement", "Others" };
		occupation = new JComboBox(occupationalvalues);
		occupation.setBounds(300, 390, 400, 30);
		add(occupation);

		JLabel address = new JLabel("Pan_no:");
		address.setFont(new Font("Railway", Font.BOLD, 22));
		address.setBounds(100, 440, 200, 30);
		add(address);

		pan = new JTextField();
		pan.setFont(new Font("Railway", Font.BOLD, 14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);

		JLabel city = new JLabel("Aadhar_no:");
		city.setFont(new Font("Railway", Font.BOLD, 22));
		city.setBounds(100, 490, 200, 30);
		add(city);

		aadhar = new JTextField();
		aadhar.setFont(new Font("Railway", Font.BOLD, 14));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);

		JLabel state = new JLabel("Senior_citizen:");
		state.setFont(new Font("Railway", Font.BOLD, 22));
		state.setBounds(100, 540, 200, 30);
		add(state);

		syes = new JRadioButton("yes");
		syes.setBounds(300, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);

		sno = new JRadioButton("No");
		sno.setBounds(450, 540, 100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);

		ButtonGroup sgroup1 = new ButtonGroup();
		sgroup1.add(syes);
		sgroup1.add(sno);

		JLabel pincode = new JLabel("Existing account:");
		pincode.setFont(new Font("Railway", Font.BOLD, 22));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);

		eyes = new JRadioButton("yes");
		eyes.setBounds(300, 590, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);

		eno = new JRadioButton("No");
		eno.setBounds(450, 590, 100, 30);
		eno.setBackground(Color.WHITE);
		add(eno);

		ButtonGroup egroup1 = new ButtonGroup();
		egroup1.add(eyes);
		egroup1.add(eno);

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
		new SignupTwo("");
	}

	public void actionPerformed(ActionEvent e) {

		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) category.getSelectedItem();
		String sincome = (String) category.getSelectedItem();
		String seducaton = (String) education.getSelectedItem();
		String soccuption = (String) occupation.getSelectedItem();
		String seniorcitizen = null;
		if (syes.isSelected()) {
			seniorcitizen = "Yes";
		} else if (sno.isSelected()) {
			seniorcitizen = "No";
		}

		String exisitingaccount = null;
		if (eyes.isSelected()) {
			exisitingaccount = "Yes";
		} else if (sno.isSelected()) {
			exisitingaccount = "No";
		}

		String span = pan.getText();
		String saadhar = aadhar.getText();

		try {
			Conn c = new Conn();
			String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','"
					+ sincome + "','" + seducaton + "','" + soccuption + "','" + span + "','" + saadhar + "','"
					+ seniorcitizen + "','" + exisitingaccount + "')";
			c.s.executeUpdate(query);

			setVisible(false);
			new SignupThree(formno).setVisible(true);

		} catch (Exception ee) {
			System.out.println(ee);
		}

	}

}
