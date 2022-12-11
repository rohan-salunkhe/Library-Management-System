package LibraryManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class AddRecord extends JFrame {
	
	JLabel j,j1,j2,j3,j4,j5,j6,j7,j8,j9;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3;
	JRadioButton r1,r2,r3;
	JList l1;
	public AddRecord()
	{
		j=new JLabel("Issue Book Record ");
		j1=new JLabel("Record No :");
		j2=new JLabel("Enrollment No :");
		j3=new JLabel("Student Name ");
		j4=new JLabel("Year : ");
		j5=new JLabel("Tarde : ");	
		j6=new JLabel("Mobile No :");
		j7=new JLabel("Book ID :");
		j8=new JLabel("Book Name :");
		j9=new JLabel("Author Name");
			
		t1=new JTextField();
		t1.setEditable(false);
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		r1=new JRadioButton("FY");
		r2=new JRadioButton("SY");
		r3=new JRadioButton("TY");
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		r1.setActionCommand("FY");
		r2.setActionCommand("SY");
		r3.setActionCommand("TY");
		
		String Trades[] ={"Civil","Mechanical","Electrical","Electronics","Computer","Instrumentation"};
		l1= new JList(Trades);
		l1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		
		b1 =new JButton("Issue Record");
		b2 =new JButton("Search Book");
		b3 =new JButton("Back");
			
		j.setBounds(400, 150, 400, 40);
		j1.setBounds(50, 250, 150, 30);
		j2.setBounds(50, 300, 180, 30);
		j3.setBounds(50, 350, 150, 30);
		j4.setBounds(50, 400, 150, 30);
		j5.setBounds(50, 450, 150, 30);
		j6.setBounds(550, 250, 150, 30);
		j7.setBounds(550, 300, 150, 30);
		j8.setBounds(550, 400, 150, 30);
		j9.setBounds(550, 450, 150, 30);
		
		t1.setBounds(250, 250, 250, 30);
		t2.setBounds(250, 300, 250, 30);
		t3.setBounds(250, 350, 250, 30);
		r1.setBounds(250, 400, 60, 30);
	    r2.setBounds(310, 400, 60, 30);
	    r3.setBounds(370, 400, 60, 30);
	    l1.setBounds(250, 450, 250, 200);
		
		t4.setBounds(700, 250, 250, 30);
		t5.setBounds(700, 300, 250, 30);
		t6.setBounds(700, 400, 250, 30);
		t7.setBounds(700, 450, 250, 30);
		
		b1.setBounds(400, 700, 180, 30);
		b2.setBounds(650, 350, 180, 30);
		b3.setBounds(750, 100, 180, 30);
		
		
		add(j);
		add(j1);
		add(j2);
		add(j3);
		add(j4);
		add(j5);
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
		add(r1);
		add(r2);
		add(r3);
		add(l1);
		add(b1);
		add(b2);
		add(b3);
		getContentPane().setBackground(Color.ORANGE);
		setTitle("Issue Record");
		setSize(1100,900);
		setLayout(null);
		setVisible(true);
		
		Font myfont=new Font("serif",Font.BOLD,24);
		j1.setFont(myfont);
		j2.setFont(myfont);
		j3.setFont(myfont);
		j4.setFont(myfont);
		j5.setFont(myfont);
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
		r1.setFont(myfont);
		r2.setFont(myfont);
		r3.setFont(myfont);
		l1.setFont(myfont);
	 
		Font Title=new Font("serif",Font.BOLD,40);
		j.setForeground(Color.RED);
		j.setFont(Title);
		
		//Auto Incrementation of RecordNo
		try{
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123"); 
         Statement stmt = conn.createStatement();
         String strSelect = "select *  from Records order by RecordNo desc" ;
         ResultSet rset = stmt.executeQuery(strSelect);
         if(rset.next())
         {
			String RecordNo = rset.getString("RecordNo");
			int Record_No = Integer.parseInt(RecordNo) + 1;
			
			t1.setText(Integer.toString(Record_No));
         }
         
         
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			}
    	
         
		
	//Add Record
		  b1.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	try{
							 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123"); 
					         Statement stmt = conn.createStatement();
					         String sqlInsert = "insert into records values ("+t1.getText()+","+t2.getText()+",'"+t3.getText()+"','"+bg.getSelection().getActionCommand()+"','"+l1.getSelectedValue()+"',"+t4.getText()+","+t5.getText()+",'"+t6.getText()+"','"+t7.getText()+"')"; 
					         stmt.executeUpdate(sqlInsert);
					         JOptionPane.showMessageDialog(AddRecord.this,""+t6.getText()+" is issued to "+t3.getText()+"" );
					        
					         
					        
					         //Book count - 1
					         String strSelect1 = "select *  from Books where BookID="+t5.getText() ;
			    	         ResultSet rset1 = stmt.executeQuery(strSelect1);
			    	         if(rset1.next())
			    	         {
			 			
			 	            int Quantity = rset1.getInt("Quantity");
			 	            Quantity=Quantity-1;
			 	            
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
					         l1.clearSelection();
					         bg.clearSelection();
					         
					        
					       //RecordNo + 1 After adding Record
					             String strSelect2 = "select *  from Records order by RecordNo desc" ;
					             ResultSet rset2 = stmt.executeQuery(strSelect2);
					             if(rset2.next())
					             {
					    			String RecordNo = rset2.getString("RecordNo");
					    			int Record_No = Integer.parseInt(RecordNo) + 1;
					    			
					    			t1.setText(Integer.toString(Record_No));
					             }
					             
					             
					    	
							}
						catch(SQLException ex) {
							ex.printStackTrace();
							}
		            	
		            }
	         });
		  
        //Search Book
		 b2.addActionListener(new ActionListener() {  
	            public void actionPerformed(ActionEvent e) {       
					try{Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123"); 
			             Statement stmt = conn.createStatement();
				         String strSelect = "select *  from Books where BookID="+t5.getText() ;
		    	         ResultSet rset = stmt.executeQuery(strSelect);
		    	         if(rset.next())
		    	         {
		    	        	 
		 				String Bookname = rset.getString("BookName");
		 	            String Authorname = rset.getString("AuthorName");
		 	            int Quantity = rset.getInt("Quantity");
		 	            if(Quantity>0)
		 	            {
		 				t6.setText(Bookname);
		 				t7.setText(Authorname);
		 				
		 	            }
		 	            else
		 	            
		 	            {
		 	            	JOptionPane.showMessageDialog(AddRecord.this,"Book is not available");	
		 	            	
		 	            }
		    	         }
		    	         else
		    	         {
		    	        	 JOptionPane.showMessageDialog(AddRecord.this,"Book is not available");
		    	        	 t6.setText("");
				 			 t7.setText("");
		    	         }
		    	            
				            
				}
					catch(Exception ex) {
						ex.printStackTrace();
						}
			}

				
			}); 
		 
		 // Go to Home Frame
		  b3.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 Home.main(new String[]{});
					    AddRecord.this.dispose();
		            	
		            }
	         });
		
}
	


	public static void main(String[] args) {
	
new AddRecord();
	}

}
