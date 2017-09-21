package view;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import CaseStudy.AdminLoginUI.StyledButtonUI;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class AdminLoginUI extends JFrame implements KeyListener{

	private JPanel contentPane;
	private JLabel background;
	private JTextField textField;
	private JPasswordField passwordField;
	private Connection connection;
	private Admin user;
	private AdminLoginCtrl adminDA;

	
	public AdminLoginUI() {
		setTitle("Payroll System");

		background = new JLabel();
		background.setIcon(new ImageIcon("/Users/carendelapena/Documents/Payroll/src/Photos/admin.png"));
		background.setBounds(330, 10, 560, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 349);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		centerFrame();

		textField = new JTextField();
		textField.setBounds(117, 83, 169, 31);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblEmployeeLogin = new JLabel("Admin Login:");
		lblEmployeeLogin.setBounds(28, 23, 101, 31);
		lblEmployeeLogin.setForeground(Color.WHITE);
		contentPane.add(lblEmployeeLogin);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(28, 87, 64, 23);
		lblUsername.setForeground(Color.WHITE);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(28, 129, 64, 23);
		lblPassword.setForeground(Color.WHITE);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(117, 125, 169, 31);
		passwordField.addKeyListener(this);;
		contentPane.add(passwordField);

		JButton btnLogin = new JButton();
		btnLogin.setIcon(new ImageIcon("/Users/carendelapena/Documents/Payroll/src/Photos/login.png"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				loginButton();
				dispose();
			}
		});
		
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setUI(new StyledButtonUI());
		btnLogin.setBounds(130, 210, 156, 47);
		contentPane.add(btnLogin);

		JButton btnEmp = new JButton("Employee Login");
		btnEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmpLoginUI();
				dispose();
			}
		});
		btnEmp.setFont(new Font("Calibri", Font.BOLD, 14));
		btnEmp.setBackground(Color.BLACK);
		btnEmp.setForeground(Color.white);
		btnEmp.setUI(new StyledButtonUI());
		btnEmp.setBounds(334, 249, 159, 31);
		contentPane.add(btnEmp);

		
		contentPane.add(background);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AdminLoginUI();

	}

	private void centerFrame() {

		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();

		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	}

	class StyledButtonUI extends BasicButtonUI {

		@Override
		public void installUI(JComponent c) {
			super.installUI(c);
			AbstractButton button = (AbstractButton) c;
			button.setOpaque(false);
			button.setBorder(new EmptyBorder(5, 15, 5, 15));
		}

		@Override
		public void paint(Graphics g, JComponent c) {
			AbstractButton b = (AbstractButton) c;
			paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
			super.paint(g, c);
		}

		private void paintBackground(Graphics g, JComponent c, int yOffset) {
			Dimension size = c.getSize();
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(c.getBackground().darker());
			g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
			g.setColor(c.getBackground());
			g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
		}
	}

	public Connection getConnection() {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			connection = DriverManager.getConnection("jdbc:db2://localhost:50000/payroll", "Charlie", "1231234");

		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
	
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	     btnLogin();
			
		}
	}


	public void btnLogin() {
		// TODO Auto-generated method stub
		
				String uname=userTF.getText();
				String pass=passTF.getText();
				if(uname.equals("username")	&& pass.equals("password")){
					final ImageIcon icon = new ImageIcon("/Users/carendelapena/Documents/Payroll/src/Photos/Log.png");
			        JOptionPane.showMessageDialog(null, "Hello User, You are successfully logined. ", "EMPLOYEE PROFILE", JOptionPane.INFORMATION_MESSAGE, icon);
			        userTF.setText(null);
				    passTF.setText(null);
			          
		    
		          
		    	dispose();}
				else{
					userTF.setText(null);
					passTF.setText(null);
					final ImageIcon icon2 = new ImageIcon("/Users/carendelapena/Documents/Payroll/src/Photos/Error.png");
		    		JOptionPane.showMessageDialog(null, "The username or password is incorrect","EMPLOYEE PROFILE",JOptionPane.INFORMATION_MESSAGE,icon2);
	    		}
			
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	

	

	public void displayMain(Admin user) throws ClassNotFoundException, SQLException {
		new AdminProfileUI();

	}
}
