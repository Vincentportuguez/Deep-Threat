package view;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

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

public class EmpLoginUI extends JFrame implements KeyListener{


	private JPanel contentPane;
	private JLabel background;
	private JTextField userTF;
	private JPasswordField passTF;

	public EmpLoginUI() {
		setTitle("Payroll System");
		
		background = new JLabel();
		background.setIcon(new ImageIcon("/Users/carendelapena/Documents/Payroll/src/Photos/emp.png"));
		background.setBounds(340, 0, 564, 210);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 200, 580, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		centerFrame();

		userTF = new JTextField();
		userTF.setBounds(117, 83, 169, 31);
		contentPane.add(userTF);
		userTF.setColumns(10);

		JLabel lblEmployeeLogin = new JLabel("Employee Login:");
		lblEmployeeLogin.setBounds(50, 20, 108, 61);
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

		passTF = new JPasswordField();
        passTF.addKeyListener(this);
		passTF.setBounds(117, 125, 169, 31);
		contentPane.add(passTF);
		JButton btnLogin ;
		btnLogin = new JButton();
		btnLogin.setIcon(new ImageIcon("/Users/carendelapena/Documents/Payroll/src/Photos/login.png"));
		
	
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogin() ;
				EmpLoginCtrl();
			}

			public void EmpLoginCtrl() {
				// TODO Auto-generated method stub
				
			}
		});

	
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setUI(new StyledButtonUI());
		btnLogin.setBounds(150, 233, 156, 51);
		contentPane.add(btnLogin);


		JButton btnEmp = new JButton("Admin Login");
		btnEmp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminLoginUI();
				dispose();
			}
		});
		btnEmp.setFont(new Font("Calibri", Font.BOLD, 14));
		btnEmp.setBackground(Color.BLACK);
		btnEmp.setForeground(Color.white);
		btnEmp.setUI(new StyledButtonUI());
		btnEmp.setBounds(354, 189, 149, 31);
		contentPane.add(btnEmp);

		

		JLabel lblForgotPassword = new JLabel("Forgot Password?");
		lblForgotPassword.setBounds(30, 197, 111, 23);
		lblForgotPassword.setForeground(Color.WHITE);
		lblForgotPassword.setToolTipText("Contact idiot 09187654321");
		contentPane.add(lblForgotPassword);
		contentPane.add(background);
		setVisible(true);
	}


	public static void main(String[] args) {
		new EmpLoginUI();

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
	
