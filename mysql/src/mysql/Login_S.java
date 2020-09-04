package mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Login_S {

	private JFrame frmLoginSystem;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
					window.frmLoginSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginSystem = new JFrame();
		frmLoginSystem.setBounds(200, 200, 500, 300);
		frmLoginSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginSystem.getContentPane().setLayout(null);
		
		JLabel lblLoginSystem = new JLabel("Login System");
		lblLoginSystem.setBounds(182, 21, 101, 14);
		frmLoginSystem.getContentPane().add(lblLoginSystem);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(88, 82, 81, 14);
		frmLoginSystem.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setBounds(88, 134, 81, 14);
		frmLoginSystem.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(221, 79, 155, 20);
		frmLoginSystem.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(221, 131, 155, 20);
		frmLoginSystem.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				if (password.contains("king") && username.contains("one")) {
					txtPassword.setText(null);
					txtUsername.setText(null);	
					JOptionPane.showMessageDialog(null, "Login Successfull","Login",JOptionPane.DEFAULT_OPTION);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Login Detail","Login Error",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
			}
		});
		btnLogin.setBounds(62, 215, 89, 23);
		frmLoginSystem.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(207, 215, 89, 23);
		frmLoginSystem.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}				
			}
		});
		btnExit.setBounds(340, 215, 89, 23);
		frmLoginSystem.getContentPane().add(btnExit);
						
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 183, 407, 2);
		frmLoginSystem.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(39, 55, 407, 2);
		frmLoginSystem.getContentPane().add(separator_1);
	}
}
