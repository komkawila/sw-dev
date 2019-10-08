import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.Label;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;
	private JTextField name;
	private JTextField mail;
	private JTextField phone;


	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("TH Sarabun New", Font.BOLD, 30));
		lblRegister.setBounds(73, 11, 83, 29);
		contentPane.add(lblRegister);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					theQuery("INSERT INTO `member_table`(`user`, `pass`, `name`, `mail`, `phone`) VALUES ('"+user.getText()+"','"+pass.getText()+
							"','"+name.getText()+"','"+mail.getText()+"','"+phone.getText()+"')");
					user.setText(null);
					pass.setText(null);
					name.setText(null);
					mail.setText(null);
					phone.setText(null);
					} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton.setBounds(10, 215, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(135, 215, 89, 23);
		contentPane.add(btnNewButton_1);
		
		Label label = new Label("Username");
		label.setBounds(26, 57, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Password");
		label_1.setBounds(26, 89, 62, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Name");
		label_2.setBounds(26, 121, 62, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("E-mail");
		label_3.setBounds(26, 152, 62, 22);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Phone");
		label_4.setBounds(26, 180, 62, 22);
		contentPane.add(label_4);
		
		user = new JTextField();
		user.setBounds(93, 59, 96, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(94, 89, 96, 20);
		contentPane.add(pass);
		pass.setColumns(10);
		
		name = new JTextField();
		name.setBounds(93, 123, 96, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(94, 154, 96, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(94, 185, 96, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		setLocationRelativeTo(null);
	}
	
	public void theQuery (String query){
		try {		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/book_rental_system", "root", "123456789");
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "Query Excepted");			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
