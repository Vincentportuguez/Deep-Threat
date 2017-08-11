package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class EmpProfileUI extends JFrame {

	private JPanel contentPane;
	private JTextField empNameTF;
	private  JTextField idTF;
	private JLabel background;
	private String[] salaryList = { "Daily", "Hours", "Month" };
	private  JTextField rateTF;
	private  JTextField nofdaysTF;
	private  JTextField otTF;
	private  JTextField holidayTF;
	private  JTextField legalHolTF;
	private JTextField sssTF;
	private JTextField phTF;
	private JTextField withHoldTF;
	private JTextField pagibigTF;
	private JTextField pagibigloanTF;
	private JTextField sssloanTF;
	private JTextField deducTF;
	private JTextField deduc2TF;
	private JTextField totaldeducTF;
	private JTextField npayTF;
	private JTextField totalOTTF;
	private JTextField allowTF;
	private JTextField otherTF;
	private JTextField grossTF;
	private JTextField sss2TF;
	private JTextField ph2TF;
	private JTextField pagibig2TF;

	public EmpProfileUI() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Charlie\\eclipse-workspace\\PayIdiot\\src\\Images\\one.jpg"));
		background = new JLabel();
		background
				.setIcon(new ImageIcon("C:\\Users\\Charlie\\eclipse-workspace\\PayIdiot\\src\\Images\\empprofile.jpg"));
		background.setBounds(0, 0, 804, 643);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		centerFrame();

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editButton();
			}
		});
		btnEdit.setBounds(10, 11, 95, 26);
		contentPane.add(btnEdit);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeTF();
			}
		});
		btnSave.setBounds(115, 11, 95, 26);
		contentPane.add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeTF();
			}
		});
		btnCancel.setBounds(220, 11, 106, 26);
		contentPane.add(btnCancel);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmpLoginUI();
				dispose();
			}
		});
		btnLogout.setBounds(336, 11, 112, 26);
		contentPane.add(btnLogout);

		JLabel lblEmpName = new JLabel("Emp Name");
		lblEmpName.setBounds(23, 73, 65, 19);

		contentPane.add(lblEmpName);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(23, 103, 46, 14);

		contentPane.add(lblId);

		empNameTF = new JTextField();
		empNameTF.setEditable(false);
		empNameTF.setBounds(92, 72, 136, 20);
		contentPane.add(empNameTF);
		empNameTF.setColumns(10);

		idTF = new JTextField();
		idTF.setEditable(false);
		idTF.setBounds(92, 100, 136, 20);
		contentPane.add(idTF);
		idTF.setColumns(10);

		JLabel lblSalaryMethod = new JLabel("Salary Method");
		lblSalaryMethod.setBounds(276, 73, 95, 19);
		contentPane.add(lblSalaryMethod);

		JComboBox comboBox = new JComboBox(salaryList);
		comboBox.setBounds(381, 72, 95, 20);
		contentPane.add(comboBox);

		JLabel lblRegularOvertime = new JLabel("Regular & Overtime pay:");
		lblRegularOvertime.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRegularOvertime.setBounds(23, 148, 143, 19);
		contentPane.add(lblRegularOvertime);

		JLabel lblRate = new JLabel("Rate:");
		lblRate.setBounds(23, 186, 46, 14);
		contentPane.add(lblRate);

		rateTF = new JTextField();
		rateTF.setEditable(false);
		rateTF.setBounds(142, 178, 86, 20);
		contentPane.add(rateTF);
		rateTF.setColumns(10);

		JLabel lblNoOfDays = new JLabel("No. of Days:");
		lblNoOfDays.setBounds(23, 211, 82, 19);
		contentPane.add(lblNoOfDays);

		nofdaysTF = new JTextField();
		nofdaysTF.setEditable(false);
		nofdaysTF.setBounds(142, 209, 86, 20);
		contentPane.add(nofdaysTF);
		nofdaysTF.setColumns(10);

		JLabel lblRegularOt = new JLabel("Regular OT:");
		lblRegularOt.setBounds(23, 241, 95, 19);
		contentPane.add(lblRegularOt);

		otTF = new JTextField();
		otTF.setEditable(false);
		otTF.setBounds(142, 240, 86, 20);
		contentPane.add(otTF);
		otTF.setColumns(10);

		JLabel lblSpecialHoliday = new JLabel("Special Holiday");
		lblSpecialHoliday.setBounds(23, 271, 82, 19);
		contentPane.add(lblSpecialHoliday);

		holidayTF = new JTextField();
		holidayTF.setEditable(false);
		holidayTF.setBounds(142, 271, 86, 20);
		contentPane.add(holidayTF);
		holidayTF.setColumns(10);

		JLabel lblLegalHoliday = new JLabel("Legal Holiday:");
		lblLegalHoliday.setBounds(23, 301, 82, 19);
		contentPane.add(lblLegalHoliday);

		legalHolTF = new JTextField();
		legalHolTF.setEditable(false);
		legalHolTF.setBounds(142, 302, 86, 20);
		contentPane.add(legalHolTF);
		legalHolTF.setColumns(10);

		JLabel lblEmployeeContribution = new JLabel("Employee Contribution");
		lblEmployeeContribution.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEmployeeContribution.setBounds(276, 148, 136, 19);
		contentPane.add(lblEmployeeContribution);

		JLabel lblSss = new JLabel("SSS:");
		lblSss.setBounds(276, 181, 65, 19);
		contentPane.add(lblSss);

		sssTF = new JTextField();
		sssTF.setEditable(false);
		sssTF.setBounds(390, 178, 86, 20);
		contentPane.add(sssTF);
		sssTF.setColumns(10);

		JLabel lblPhilhealth = new JLabel("PhilHealth:");
		lblPhilhealth.setBounds(276, 213, 65, 17);
		contentPane.add(lblPhilhealth);

		phTF = new JTextField();
		phTF.setEditable(false);
		phTF.setBounds(390, 210, 86, 20);
		contentPane.add(phTF);
		phTF.setColumns(10);

		JLabel lblWithholdingTax = new JLabel("Withholding Tax:");
		lblWithholdingTax.setBounds(276, 243, 95, 17);
		contentPane.add(lblWithholdingTax);

		withHoldTF = new JTextField();
		withHoldTF.setEditable(false);
		withHoldTF.setBounds(390, 240, 86, 20);
		contentPane.add(withHoldTF);
		withHoldTF.setColumns(10);

		JLabel lblPagibigFund = new JLabel("Pagibig Fund:");
		lblPagibigFund.setBounds(276, 273, 95, 17);
		contentPane.add(lblPagibigFund);

		pagibigTF = new JTextField();
		pagibigTF.setEditable(false);
		pagibigTF.setBounds(390, 270, 86, 20);
		contentPane.add(pagibigTF);
		pagibigTF.setColumns(10);

		JLabel lblPagibigLoan = new JLabel("Pagibig Loan:");
		lblPagibigLoan.setBounds(276, 303, 95, 17);
		contentPane.add(lblPagibigLoan);

		pagibigloanTF = new JTextField();
		pagibigloanTF.setEditable(false);
		pagibigloanTF.setBounds(390, 300, 86, 20);
		contentPane.add(pagibigloanTF);
		pagibigloanTF.setColumns(10);

		JLabel lblSssLoan = new JLabel("SSS Loan:");
		lblSssLoan.setBounds(276, 333, 95, 17);
		contentPane.add(lblSssLoan);

		sssloanTF = new JTextField();
		sssloanTF.setEditable(false);
		sssloanTF.setBounds(390, 330, 86, 20);
		contentPane.add(sssloanTF);
		sssloanTF.setColumns(10);

		JLabel lblDeduction = new JLabel("Deduction:");
		lblDeduction.setBounds(276, 361, 95, 19);
		contentPane.add(lblDeduction);

		deducTF = new JTextField();
		deducTF.setEditable(false);
		deducTF.setBounds(390, 360, 86, 20);
		contentPane.add(deducTF);
		deducTF.setColumns(10);

		JLabel lblOtherDeduction = new JLabel("Other Deduction:");
		lblOtherDeduction.setBounds(276, 391, 95, 19);
		contentPane.add(lblOtherDeduction);

		deduc2TF = new JTextField();
		deduc2TF.setEditable(false);
		deduc2TF.setBounds(390, 390, 86, 20);
		contentPane.add(deduc2TF);
		deduc2TF.setColumns(10);

		JLabel lblTotalDeduction = new JLabel("Total Deduction:");
		lblTotalDeduction.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTotalDeduction.setBounds(276, 421, 95, 19);
		contentPane.add(lblTotalDeduction);

		totaldeducTF = new JTextField();
		totaldeducTF.setEditable(false);
		totaldeducTF.setBounds(390, 421, 86, 20);
		contentPane.add(totaldeducTF);
		totaldeducTF.setColumns(10);

		JLabel lblNetPay = new JLabel("Net Pay:");
		lblNetPay.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNetPay.setBounds(276, 451, 95, 19);
		contentPane.add(lblNetPay);

		npayTF = new JTextField();
		npayTF.setEditable(false);
		npayTF.setBounds(390, 452, 86, 20);
		contentPane.add(npayTF);
		npayTF.setColumns(10);

		JLabel lblTotalOtPay = new JLabel("Total OT Pay:");
		lblTotalOtPay.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTotalOtPay.setBounds(23, 360, 106, 19);
		contentPane.add(lblTotalOtPay);

		totalOTTF = new JTextField();
		totalOTTF.setEditable(false);
		totalOTTF.setBounds(142, 359, 86, 20);
		contentPane.add(totalOTTF);
		totalOTTF.setColumns(10);

		JLabel lblAllowance = new JLabel("Allowance:");
		lblAllowance.setBounds(23, 392, 106, 17);
		contentPane.add(lblAllowance);

		allowTF = new JTextField();
		allowTF.setEditable(false);
		allowTF.setBounds(142, 389, 86, 20);
		contentPane.add(allowTF);
		allowTF.setColumns(10);

		JLabel lblOtherPay = new JLabel("Other Pay:");
		lblOtherPay.setBounds(23, 422, 95, 17);
		contentPane.add(lblOtherPay);

		otherTF = new JTextField();
		otherTF.setEditable(false);
		otherTF.setBounds(142, 419, 86, 20);
		contentPane.add(otherTF);
		otherTF.setColumns(10);

		JLabel lblGrossPay = new JLabel("Gross Pay:");
		lblGrossPay.setFont(new Font("Dialog", Font.BOLD, 12));
		lblGrossPay.setBounds(23, 450, 106, 19);
		contentPane.add(lblGrossPay);

		grossTF = new JTextField();
		grossTF.setEditable(false);
		grossTF.setBounds(142, 450, 86, 20);
		contentPane.add(grossTF);
		grossTF.setColumns(10);

		JLabel lblEmployerContribution = new JLabel("Employer Contribution");
		lblEmployerContribution.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEmployerContribution.setBounds(562, 144, 162, 26);
		contentPane.add(lblEmployerContribution);

		JLabel lblSss_1 = new JLabel("SSS:");
		lblSss_1.setBounds(541, 181, 82, 19);
		contentPane.add(lblSss_1);

		sss2TF = new JTextField();
		sss2TF.setEditable(false);
		sss2TF.setBounds(638, 178, 86, 20);
		contentPane.add(sss2TF);
		sss2TF.setColumns(10);

		JLabel lblPhilhealth_1 = new JLabel("PhilHealth");
		lblPhilhealth_1.setBounds(541, 213, 82, 17);
		contentPane.add(lblPhilhealth_1);

		ph2TF = new JTextField();
		ph2TF.setEditable(false);
		ph2TF.setBounds(638, 210, 86, 20);
		contentPane.add(ph2TF);
		ph2TF.setColumns(10);

		JLabel lblPagibigFund_1 = new JLabel("Pagibig Fund");
		lblPagibigFund_1.setBounds(541, 243, 82, 17);
		contentPane.add(lblPagibigFund_1);

		pagibig2TF = new JTextField();
		pagibig2TF.setEditable(false);
		pagibig2TF.setBounds(638, 240, 86, 20);
		contentPane.add(pagibig2TF);
		pagibig2TF.setColumns(10);
		
		
		
		// contentPane.add(background);
		setVisible(true);

	}

	public static void main(String[] args) {
		
		new EmpProfileUI();
	}

	

	private void centerFrame() {

		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();

		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	
	}
	
	
}
