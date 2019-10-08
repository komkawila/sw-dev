import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;

import javax.swing.JFileChooser;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.DropMode;
public class Admin extends JFrame {

	private JPanel contentPane;
	protected String path;
	protected Window lblNewLabel;
	private JTextField price_book;
	private JTextField name_book;
	private String bPath;

	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("\u0E40\u0E25\u0E37\u0E2D\u0E01\u0E23\u0E39\u0E1B");
		btn.setFont(new Font("TH Sarabun New", Font.PLAIN, 20));
		btn.setBounds(67, 96, 87, 23);
		contentPane.add(btn);
		
		JLabel label = new JLabel("Image");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(199, 63, 223, 147);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u0E40\u0E1E\u0E34\u0E48\u0E21\u0E2B\u0E19\u0E31\u0E07\u0E2A\u0E37\u0E2D");
		label_1.setFont(new Font("TH Sarabun New", Font.BOLD, 30));
		label_1.setBounds(189, 11, 93, 41);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u0E23\u0E32\u0E04\u0E32");
		label_2.setFont(new Font("TH Sarabun New", Font.BOLD, 20));
		label_2.setBounds(67, 256, 34, 14);
		contentPane.add(label_2);
		
		price_book = new JTextField();
		price_book.setFont(new Font("TH Sarabun New", Font.BOLD, 20));
		price_book.setBounds(150, 252, 273, 20);
		contentPane.add(price_book);
		price_book.setColumns(10);
		

		JTextArea detail_book = new JTextArea();
		detail_book.setLineWrap(true);
		detail_book.setFont(new Font("TH Sarabun New", Font.BOLD, 20));
		detail_book.setBounds(152, 285, 271, 122);
		contentPane.add(detail_book);
		
		JButton btnNewButton = new JButton("\u0E15\u0E01\u0E25\u0E07");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					theQuery("INSERT INTO `book_table`(`name_book`, `price_book`, `detail_book`, `image_book`) VALUES ('"+name_book.getText()+"','"+price_book.getText()
					+"','"+detail_book.getText()+"','"+bPath+"')");
					label.setVisible(false);
					name_book.setText(null);
					price_book.setText(null);
					detail_book.setText(null);
				} catch ( Exception e2 ) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
		});
		btnNewButton.setFont(new Font("TH Sarabun New", Font.PLAIN, 20));
		btnNewButton.setBounds(133, 426, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setVisible(false);
				name_book.setText(null);
				price_book.setText(null);
				detail_book.setText(null);			
			}
		});
		btnNewButton_1.setFont(new Font("TH Sarabun New", Font.PLAIN, 20));
		btnNewButton_1.setBounds(244, 426, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel label_3 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E2B\u0E19\u0E31\u0E07\u0E2A\u0E37\u0E2D");
		label_3.setFont(new Font("TH Sarabun New", Font.BOLD, 20));
		label_3.setBounds(68, 220, 72, 22);
		contentPane.add(label_3);
		
		name_book = new JTextField();
		name_book.setFont(new Font("TH Sarabun New", Font.BOLD, 20));
		name_book.setBounds(151, 221, 272, 20);
		contentPane.add(name_book);
		name_book.setColumns(10);
		setLocationRelativeTo(null);
		
		
		JLabel label_4 = new JLabel("\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14");
		label_4.setFont(new Font("TH Sarabun New", Font.BOLD, 20));
		label_4.setBounds(67, 281, 73, 41);
		contentPane.add(label_4);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
		        JFileChooser file = new JFileChooser();
		        file.setCurrentDirectory(new File(System.getProperty("user.home")));
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png", "jpeg");
		        file.addChoosableFileFilter(filter);
		        int result = file.showOpenDialog(null);
		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = file.getSelectedFile();
		            path = selectedFile.getAbsolutePath();
		            bPath = path.replaceAll("\\\\","\\\\\\\\");
		            System.out.println(bPath);
		            String filename = file.getSelectedFile().getName();
		            ImageIcon myImage = new ImageIcon(path);
		            Image img = myImage.getImage();
		            Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		            ImageIcon image = new ImageIcon(newImg);
		            label.setVisible(true);
		            label.setIcon(image);
		            label.setText(filename+" Selected");            
		        } 
				
			}
		});
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
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
