package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ButtonUI;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.plaf.basic.BasicButtonUI;

import k.AdminLoginUI.StyledButtonUI;
import k.AdminLoginUI;

import java.sql.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.design.*;
import net.sf.jasperreports.xml.*;
public class EmpProfileUI extends JFrame {
   
	private JPanel contentPane;
	private JTextField empNameTF;
	private JTextField idTF;
	private JLabel background;
	private Connection con;
    private Statement st;
	private ResultSet rs;
	private JTextField bpTF;
	private JTextField allowTF;
	private JTextField otTF;
	private JTextField sssTF;
	private JTextField phTF;
	private JTextField hdmfTF;
	private JTextField npTF;
	private JTextField taxTF;

	public EmpProfileUI() throws ClassNotFoundException, SQLException {
		setTitle("Edit Employee");
		
		background = new JLabel();
	
		
		background.setIcon(new ImageIcon("/Users/caren/Documents/Logo.png"));
		background.setBounds(330, 10, 804, 643);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(new BorderLayout());
		//contentPane.add(lblEmpName, BorderLayout.LINE_START);
		
		//centerFrame();
        contentPane.setBackground(Color.DARK_GRAY);
		JLabel lblEmpName = new JLabel("Emp Name :");
		lblEmpName.setForeground(Color.WHITE);
		lblEmpName.setBounds(36, 36, 75, 29);
		contentPane.setLayout(null);
		//contentPane.add(lblEmpName, BorderLayout.LINE_START);

		contentPane.add(lblEmpName);

		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(46, 76, 46, 14);

		contentPane.add(lblId);

		empNameTF = new JTextField();
		empNameTF.setEditable(false);
		empNameTF.setBounds(115, 45, 193, 20);
		contentPane.add(empNameTF);
		empNameTF.setColumns(10);

		idTF = new JTextField();
		idTF.setEditable(false);
		idTF.setBounds(115, 73, 193, 20);
		contentPane.add(idTF);
		idTF.setColumns(10);

		bpTF = new JTextField();
		bpTF.setBounds(226, 189, 136, 26);
		bpTF.setEditable(false);
		contentPane.add(bpTF);
		bpTF.setColumns(10);

		JLabel lblBasicPay = new JLabel("Basic Pay:");
		lblBasicPay.setBounds(157, 194, 65, 16);
		lblBasicPay.setForeground(Color.WHITE);
		contentPane.add(lblBasicPay);

		JLabel lblAllowance = new JLabel("Allowance:");
		lblAllowance.setBounds(157, 224, 165, 19);
		lblAllowance.setForeground(Color.WHITE);
		contentPane.add(lblAllowance);

		allowTF = new JTextField();
		allowTF.setBounds(226, 220, 136, 26);
		allowTF.setEditable(false);
		contentPane.add(allowTF);
		allowTF.setColumns(10);

		JLabel lblOvertime = new JLabel("Overtime: ");
		lblOvertime.setBounds(157, 257, 65, 19);
		lblOvertime.setForeground(Color.WHITE);
		contentPane.add(lblOvertime);

		otTF = new JTextField();
		otTF.setColumns(10);
		otTF.setEditable(false);
		otTF.setBounds(226, 253, 136, 26);
		contentPane.add(otTF);

		JLabel lblDeductions = new JLabel("Deductions");
		lblDeductions.setBounds(500, 148, 112, 26);
		lblDeductions.setForeground(Color.WHITE);
		contentPane.add(lblDeductions);

		JLabel lblSss = new JLabel("SSS:");
		lblSss.setForeground(Color.WHITE);
		lblSss.setBounds(417, 195, 52, 20);
		contentPane.add(lblSss);

		sssTF = new JTextField();
		sssTF.setEditable(false);
		sssTF.setColumns(10);
		sssTF.setBounds(479, 189, 136, 26);
		contentPane.add(sssTF);

		JLabel lblPhilhealth = new JLabel("PhilHealth");
		lblPhilhealth.setBounds(417, 225, 65, 17);
		lblPhilhealth.setForeground(Color.WHITE);
		contentPane.add(lblPhilhealth);

		phTF = new JTextField();
		phTF.setColumns(10);
		phTF.setEditable(false);
		phTF.setBounds(479, 220, 136, 26);
		contentPane.add(phTF);

		JLabel lblHdmf = new JLabel("HDMF:");
		lblHdmf.setBounds(417, 258, 55, 17);
		lblHdmf.setForeground(Color.WHITE);
		contentPane.add(lblHdmf);

		hdmfTF = new JTextField();
		hdmfTF.setColumns(10);
		hdmfTF.setEditable(false);
		hdmfTF.setBounds(479, 253, 136, 26);
		contentPane.add(hdmfTF);

		JLabel lblNetpay = new JLabel("NetPay");
		lblNetpay.setForeground(Color.WHITE);
		lblNetpay.setBounds(272, 366, 65, 19);
		contentPane.add(lblNetpay);

		JButton btnCompute = new JButton("Compute");
		btnCompute.setBackground(Color.BLACK);
		
		btnCompute.setForeground(Color.BLACK);
		//btnCompute.setIcon(new ImageIcon("/Users/caren/Documents/Loading.gif"));
		
		btnCompute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double bp = Double.parseDouble(bpTF.getText());
				double allow = Double.parseDouble(allowTF.getText());
				double ot = Double.parseDouble(otTF.getText());
				double sss = Double.parseDouble(sssTF.getText());
				double ph = Double.parseDouble(phTF.getText());
				double hdmf = Double.parseDouble(hdmfTF.getText());
				double partialtax = Double.parseDouble(taxTF.getText());
				double tax = partialtax / 100;

				double redeem = bp + allow + ot;
				double xtax = redeem * tax;
				double deduc1 = sss + ph + hdmf + xtax;
				double netpay = redeem - deduc1;

				npTF.setText("" + netpay);

			}
		});
		btnCompute.setBounds(346, 403, 112, 46);
		btnCompute.setBackground(Color.BLACK);
	
		contentPane.add(btnCompute);
        
		JButton btnReport =new JButton("Receipt");
        btnReport.setForeground(Color.BLACK);
        contentPane.add(btnReport);
        btnReport.setBounds(346, 453, 112, 46);
        btnReport.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() instanceof JButton){
					if(e.getActionCommand().equals("Report")){
					showReport();
					} 
					}
				}

			private void showReport() {
				try{
				JasperDesign jasperDesign = JRXmlLoader.load(JrxmlFilePath);
				JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
				java.sql.Connection con=//write your connection here;

				JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,null,connection);
				JasperExportManager.exportReporttoPdfFile(jasperPrint,"destination.pdf");
				  Runtime.getRuntime().exec("");
				}catch(JRException | IOException e){
					e.printStackTrace();
				}
					
				}
			
				
					});	
					
        
     
        
		npTF = new JTextField();
		npTF.setColumns(10);
		npTF.setEditable(false);
		npTF.setBounds(336, 362, 136, 26);
		contentPane.add(npTF);

		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(417, 290, 54, 19);
		lblTax.setForeground(Color.WHITE);
		contentPane.add(lblTax);

		taxTF = new JTextField();
		taxTF.setEditable(false);
		taxTF.setColumns(10);
		taxTF.setBounds(479, 286, 46, 26);
		contentPane.add(taxTF);

		JLabel label = new JLabel("");
	   label.setBounds(426, 362, 136, 26);
		contentPane.add(label);

		display();
		 contentPane.add(background);
		setVisible(true);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

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

	public void display() throws ClassNotFoundException, SQLException {

		String driver = "com.ibm.db2.jcc.DB2Driver";
		Class.forName(driver);

		con = DriverManager.getConnection("jdbc:db2://localhost:50000/payroll", "Charlie", "1231234");
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		String sql = "select * from employees order by empname";
		rs = st.executeQuery(sql);

	    try {
			rs.next();
			{

				empNameTF.setText(rs.getString("empname"));
				idTF.setText(rs.getString("id"));
				bpTF.setText(rs.getString("basicpay"));
				allowTF.setText(rs.getString("allowance"));
				otTF.setText(rs.getString("overtime"));
				sssTF.setText(rs.getString("sss"));
				phTF.setText(rs.getString("phealth"));
				hdmfTF.setText(rs.getString("hdmf"));
				taxTF.setText(rs.getString("tax"));
			}

		} catch (SQLException ex) {
		ex.printStackTrace();
		}
	}
}
