package LibraryManagementSystem;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddBook extends JFrame {
	
	
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	JButton b1,b2;
	
	AddBook()
	{
		l1=new JLabel("Book ID");
		t1=new JTextField();
		t1.setEditable(false);
		l2=new JLabel("Book Name");
		t2=new JTextField();
		l3=new JLabel("Author name");
		t3=new JTextField();
		l4=new JLabel("Copies");
		t4=new JTextField();
		l5=new JLabel("ADD BOOK");
		b1=new JButton("Add Book");
		b2=new JButton("Back");
		
		
		
		l1.setBounds(200, 300, 200, 40);
		t1.setBounds(400, 300, 250, 40);
		l2.setBounds(200, 380, 200, 40);
		t2.setBounds(400, 380, 250, 40);
		l3.setBounds(200, 460, 200, 40);
		t3.setBounds(400, 460, 250, 40);
		l4.setBounds(200, 540, 200, 40);
		t4.setBounds(400, 540, 250, 40);
		b1.setBounds(320, 680, 200, 40);
		b2.setBounds(650, 80, 200, 40);
		l5.setBounds(320, 200, 400, 40);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(b1);
		add(b2);
	
		getContentPane().setBackground(Color.pink);
		setTitle("Add Book");
		setSize(900,900);
		setLayout(null);
		setVisible(true);
		
		
		Font myfont=new Font("serif",Font.BOLD,28);
		l1.setFont(myfont);
		l2.setFont(myfont);
		l3.setFont(myfont);
		l4.setFont(myfont);
		t1.setFont(myfont);
		t2.setFont(myfont);
		t3.setFont(myfont);
		t4.setFont(myfont);
		b1.setFont(myfont);
		b2.setFont(myfont);
	
		
		Font Title=new Font("serif",Font.BOLD,40);
		l5.setForeground(Color.RED);
		l5.setFont(Title);
		
	
		
		addWindowListener(new WindowAdapter()
		{  
            public void windowClosing(WindowEvent e)
            {  
                dispose();  
            }  
        });
		
		//Auto incrementation
		try
		{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123"); 
        Statement stmt = conn.createStatement();
		 String strSelect = "select *  from Books order by BookID desc" ;
         ResultSet rset = stmt.executeQuery(strSelect);
         if(rset.next())
         {
			String BookID = rset.getString("BookID");
			int BkID = Integer.parseInt(BookID) + 1;
			
			t1.setText(Integer.toString(BkID));
         }
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			}
    	
			//Add book 
		  b1.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	try{
							 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123"); 
					         Statement stmt = conn.createStatement();
					         String sqlInsert = "insert into books values ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"',"+t4.getText()+")"; 
					         stmt.executeUpdate(sqlInsert);
					         JOptionPane.showMessageDialog(AddBook.this,"" +t2.getText()+ " " +t4.getText()+ " copies added to the library. \n");
					         
					            t2.setText("");
					 			t3.setText("");
					 			t4.setText("");
					         
					         String strSelect = "select *  from Books order by BookID desc" ;
					         ResultSet rset = stmt.executeQuery(strSelect);
					         if(rset.next())
					         {
								String BookID = rset.getString("BookID");
								int BkID = Integer.parseInt(BookID) + 1;
								
								t1.setText(Integer.toString(BkID));
					         }
							}
						catch(SQLException ex) {
							ex.printStackTrace();
							}
		            	
		            }
	         });
		  
		  //Back Button
		  b2.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 Home.main(new String[]{});
					     AddBook.this.dispose();
		            	
		            }
	         });
		  
		
		
		  
		
	}



	public static void main(String[] args) {
		new AddBook();

	}

}
