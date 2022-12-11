package LibraryManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.*;
public class RemoveRecord extends JFrame {
	
	JLabel j,j1,j2,j3,j4,j5,j6,j7,j8,j9;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3;
	JRadioButton r1,r2,r3;
	JList l1;
	public RemoveRecord()
	{
		j=new JLabel("Remove Record ");
		j1=new JLabel("Record No :");
		j2=new JLabel("Enrollment No :");
		j3=new JLabel("Student Name ");	
		j6=new JLabel("Mobile No :");
		j7=new JLabel("Book ID :");
		j8=new JLabel("Book Name :");
		j9=new JLabel("Author Name");
			
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		
		b1 =new JButton("Remove Record");
		b2 =new JButton("Search");
		b3 =new JButton("Back");
		
			
		j.setBounds(400, 150, 400, 40);
		j1.setBounds(50, 250, 150, 30);
		j2.setBounds(50, 400, 180, 30);
		j3.setBounds(50, 450, 150, 30);
		j6.setBounds(650, 250, 150, 30);
		j7.setBounds(650, 350, 150, 30);
		j8.setBounds(650, 400, 150, 30);
		j9.setBounds(650, 450, 150, 30);
		
		t1.setBounds(250, 250, 250, 30);
		t2.setBounds(250, 400, 250, 30);
		t3.setBounds(250, 450, 250, 30);
		
		t4.setBounds(800, 250, 250, 30);
		t5.setBounds(800, 350, 250, 30);
		t6.setBounds(800, 400, 250, 30);
		t7.setBounds(800, 450, 250, 30);
		
		b1.setBounds(400, 600,200, 30);
		b2.setBounds(280, 320, 120, 30);
		b3.setBounds(750, 100, 180, 30);
		
		
		
		
		add(j);
		add(j1);
		add(j2);
		add(j3);
		add(j6);
		add(j7);
		add(j8);
		add(j9);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(b1);
		add(b2);
		add(b3);
	
		getContentPane().setBackground(Color.yellow);
		setTitle("Remove Record");
		setSize(1100,900);
		setLayout(null);
		setVisible(true);
		
		Font myfont=new Font("serif",Font.BOLD,24);
		j1.setFont(myfont);
		j2.setFont(myfont);
		j3.setFont(myfont);
		j6.setFont(myfont);
		j7.setFont(myfont);
		j8.setFont(myfont);
		j9.setFont(myfont);
		b1.setFont(myfont);
		b2.setFont(myfont);
		b3.setFont(myfont);	
		t1.setFont(myfont);
		t2.setFont(myfont);
		t3.setFont(myfont);
		t4.setFont(myfont);
		t5.setFont(myfont);
		t6.setFont(myfont);
		t7.setFont(myfont);
	 
		Font Title=new Font("serif",Font.BOLD,40);
		j.setForeground(Color.RED);
		j.setFont(Title);
		
		//Search Record
		  b2.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	
		            	if(t1.getText().equals(""))
		            	{
		            		 JOptionPane.showMessageDialog(RemoveRecord.this,"Please enter Record No");
		            		
		            	}
		            	else{
		            	try{
		            	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123");
		    	         Statement stmt = conn.createStatement();
		    	         String strSelect = "select *  from Records where RecordNo="+t1.getText() ;
		    	         ResultSet rset = stmt.executeQuery(strSelect);
		    	         if(rset.next())
		    	         {
		    	        	 int RecordNo=rset.getInt("RecordNo");
		    	        	 int EnrollmentNo=rset.getInt("EnrollmentNo");
		 				     String StudentName = rset.getString("StudentName");
		 	                 long MobileNo =rset.getLong("MobileNo");
		 	                 int  BookID =rset.getInt("BookID");
		 	                 String BookName = rset.getString("BookName");
		 	                 String AuthorName = rset.getString("AuthorName");
		 	                 t2.setText(""+EnrollmentNo+"");
		 	                 t3.setText(StudentName);
		 	                 t4.setText(""+MobileNo+"");
		 	                 t5.setText(""+BookID+"");
		 	                 t6.setText(BookName);
		 	                 t7.setText(AuthorName);
		 	                 
		 	               
		    	         }
		    	         else
		    	         {
		    	        	JOptionPane.showMessageDialog(RemoveRecord.this,"No Record Found");
		    	        
		    	         }
		            	}
		            	catch(SQLException ex) {
							ex.printStackTrace();
							}
		            	}
		            }
	         });
		  
		  //Remove Record
		  b1.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	try{
							 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123"); 
					         Statement stmt = conn.createStatement();
					         String sqlInsert = "delete from records where RecordNo="+t1.getText(); 
					         stmt.executeUpdate(sqlInsert);
					         JOptionPane.showMessageDialog(RemoveRecord.this,"Record removed from the library successfully" );
					         
					         String strSelect1 = "select *  from Books where BookID="+t5.getText() ;
			    	         ResultSet rset1 = stmt.executeQuery(strSelect1);
			    	         if(rset1.next())
			    	         {
			 			
			 	            int Quantity = rset1.getInt("Quantity");
			 	            Quantity=Quantity+1;
			 	            
			 	           String sqlInsert1 = "update Books set Quantity="+Quantity+" where BookID="+ t5.getText();  
					        
					         stmt.executeUpdate(sqlInsert1);
			    	         }
			    	         
			    	         t1.setText("");
					         t2.setText("");
					         t3.setText("");
					         t4.setText("");
					         t5.setText("");
					         t6.setText("");
					         t7.setText("");
					         
							}
						catch(SQLException ex)
		            	{
							ex.printStackTrace();
							}
		            	
		            }
	         });
		  
		  
		  b3.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 Home.main(new String[]{});
					     RemoveRecord.this.dispose();
		            	
		            }
	         });
		          
	}
	public static void main(String[] args) {
		
    new RemoveRecord();
	}

}

