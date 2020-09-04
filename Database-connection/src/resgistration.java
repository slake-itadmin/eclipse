import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.*;

public class resgistration extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resgistration frame = new resgistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public resgistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 236, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		txtUsername = new JTextField();
		txtUsername.setBounds(10, 89, 200, 31);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(10, 145, 200, 31);
		contentPane.add(txtPassword);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 199, 200, 31);
		contentPane.add(txtEmail);

		JLabel lblUsername = new JLabel("User Name");
		lblUsername.setBounds(10, 65, 200, 24);
		contentPane.add(lblUsername);

		JLabel lblPasword = new JLabel("Email");
		lblPasword.setBounds(10, 121, 200, 24);
		contentPane.add(lblPasword);

		JLabel lblEmail = new JLabel("Password");
		lblEmail.setBounds(10, 176, 200, 24);
		contentPane.add(lblEmail);

		JButton btnRegistration = new JButton("Registration");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/password_portal", "edmund", "edmund");
					PreparedStatement ps = conn.prepareStatement("insert into user_detail(user_name,user_password,user_email) values(?,?,?);");
					ps.setString(1, txtUsername.getText());
					ps.setString(2, txtEmail.getText());
					ps.setString(3, txtPassword.getText());
					int x = ps.executeUpdate();
					if (x > 0) {
						System.out.println("Resigtration Done Successfully...");
					}
					else
						System.out.println("Resigtration Failed...");
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnRegistration.setBounds(10, 241, 89, 23);
		contentPane.add(btnRegistration);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new JPanel();
				if (JOptionPane.showConfirmDialog(contentPane, "Confirm if you want to exit","Registration",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(121, 241, 89, 23);
		contentPane.add(btnExit);
	}
}
