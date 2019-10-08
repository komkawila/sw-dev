import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Font;
public class Book_Rental extends JFrame {
	
	static int i =0;
	public static String[] name_book = new String[50];
	public static String[] price_book = new String[50];
	public static String[] detail_book = new String[50];
	public static String[] image_book = new String[50];
	//public static String[] bookName = new String[50];
	public static String data[][]  = new String[50][50];
	private static JPanel contentPane;
	private static JTable table= new JTable();
	
	public Book_Rental() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		ImageIcon myImage = new ImageIcon(image_book[1]);
//        Image img = myImage.getImage();
//        ImageIcon image = new ImageIcon(newImg);
        
        JLabel name = new JLabel("New label");
        name.setBounds(169, 267, 112, 38);
        contentPane.add(name);
        name.setText(name_book[2]);
        
        JLabel price = new JLabel("New label");
        price.setBounds(169, 316, 112, 38);
        contentPane.add(price);
        price.setText(price_book[2]);
        
        JLabel detail = new JLabel("New label");
        detail.setBounds(169, 376, 112, 38);
        contentPane.add(detail);
        detail.setText(detail_book[2]);
        
        
//        String data[][] = { { "Row1/1", "Row1/2", "Row1/3" },
//        		
//        		{ "Row2/1", "Row2/2", "Row2/3" },
//        	
//        		{ "Row3/1", "Row3/2", "Row3/3" },
//        		
//        		{ "Row4/1", "Row4/2", "Row4/3" }, };
        String header[] = { "Column 1", "Column 2", "Column 3", "Column 4" };
        table = new JTable(data,header);
        table.setBounds(28, 97, 587, 170);
        
        System.out.println(table.getSelectedRow());
        System.out.println(table.getSelectedRowCount());
        contentPane.add(table);
        
        JLabel label_1 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E2B\u0E19\u0E31\u0E07\u0E2A\u0E37\u0E2D");
        label_1.setFont(new Font("TH Sarabun New", Font.PLAIN, 20));
        label_1.setBounds(67, 66, 66, 31);
        contentPane.add(label_1);
        
        JLabel label_2 = new JLabel("\u0E23\u0E32\u0E04\u0E32");
        label_2.setFont(new Font("TH Sarabun New", Font.PLAIN, 20));
        label_2.setBounds(238, 66, 34, 31);
        contentPane.add(label_2);
        
        JLabel label_3 = new JLabel("\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14");
        label_3.setFont(new Font("TH Sarabun New", Font.PLAIN, 20));
        label_3.setBounds(364, 66, 66, 31);
        contentPane.add(label_3);
        
        JLabel label_4 = new JLabel("\u0E23\u0E39\u0E1B\u0E20\u0E32\u0E1E");
        label_4.setFont(new Font("TH Sarabun New", Font.PLAIN, 20));
        label_4.setBounds(519, 66, 66, 31);
        contentPane.add(label_4);
        
        JLabel label = new JLabel("\u0E14\u0E39\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E2B\u0E19\u0E31\u0E07\u0E2A\u0E37\u0E2D");
        label.setFont(new Font("TH Sarabun New", Font.BOLD, 36));
        label.setBounds(256, 11, 151, 44);
        contentPane.add(label);
      	
         	
//        System.out.format("bookName[1] = %s %s %s %s\n", name_book[1],price_book[1],detail_book[1],image_book[1]);
//		System.out.format("bookName[2] = %s %s %s %s\n", name_book[2],price_book[2],detail_book[2],image_book[2]);
	}
	
	
	
	public static void main(String[] args) {
		try {		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/book_rental_system", "root", "123456789");
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM `book_table`";
			stmt.execute(query);
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
			      {		
					name_book[i] = rs.getString("name_book");
			        price_book[i] = rs.getString("price_book");
			        detail_book[i] = rs.getString("detail_book");
			        image_book[i] = rs.getString("image_book"); 	
			        data[i][0] = name_book[i];
					data[i][1] = price_book[i];
					data[i][2] = detail_book[i];
					data[i][3] = image_book[i];
					i++;      
			      }
			      	
			//for(int j=0;j<i;j++) {
				
			//}
			
			System.out.println(table.getSelectedRow());
	        System.out.println(table.getSelectedRowCount());
			st.close();
			JOptionPane.showMessageDialog(null, "Query Excepted");	
//			Book_Rental book = new Book_Rental();			
//			book.setVisible(true);		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		Book_Rental book = new Book_Rental();			
		book.setVisible(true);	
	}
	
	}


