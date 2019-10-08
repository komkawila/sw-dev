import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("TH Sarabun New", Font.BOLD, 30));
		lblLogin.setBounds(0, 31, 234, 29);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("TH Sarabun New", Font.BOLD, 20));
		lblUsername.setBounds(20, 75, 70, 21);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("TH Sarabun New", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(20, 147, 65, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnregis = new JButton("Register");
		btnregis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Register r = new Register();
		        r.setVisible(true);
			}

		});
		btnregis.setBounds(120, 215, 89, 23);
		contentPane.add(btnregis);

		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (("admin".equals(user.getText()) && "123456789".equals(pass.getText().toString()))  || ("ADMIN".equals(user.getText()) && "123456789".equals(pass.getText().toString())) ) {
						JOptionPane.showMessageDialog(null, "Login Sucessfully...");
						Admin admin = new Admin();
						admin.setVisible(true);
					}
				
					else {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/book_rental_system", "root", "123456789");
						String sql = "SELECT * FROM member_table WHERE user= '" +user.getText()+"' and pass='"+pass.getText().toString()+"'";
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(sql);
	
							if ( rs.next() ) {
								JOptionPane.showMessageDialog(null, "Login Sucessfully...");
								Book_Rental book= new Book_Rental();
								book.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "Incorrect username and Password...");
								conn.close();
							}
					}	
				}	
				catch (Exception e1) {
					System.out.println(e1);
				}
				
				
			}
		});
		btnlogin.setBounds(19, 215, 89, 23);
		contentPane.add(btnlogin);
		
		user = new JTextField();
		user.setBounds(19, 101, 188, 35);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(20, 172, 189, 35);
		contentPane.add(pass);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
