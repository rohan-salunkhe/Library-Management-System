package LibraryManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


public class UpdateBook extends JFrame {

	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t6;
	JButton b1,b2,b3;
	int TotalBooks=0;
	
	UpdateBook()
	{
		l1=new JLabel("Book ID");
		t1=new JTextField();
		l2=new JLabel("Book Name");
		t2=new JTextField();
		l3=new JLabel("Author Name");
		t3=new JTextField();
		l4=new JLabel("Old Copies");
		t4=new JTextField();
		l5=new JLabel("UPDATE BOOK");
		l6=new JLabel("New Copies ");
		t6=new JTextField();
		b1=new JButton("Update Book");
		b2=new JButton("Search Book");
		b3=new JButton("Back");
		
		
		l1.setBounds(120, 300, 200, 40);
		t1.setBounds(350, 300, 250, 40);
		l2.setBounds(120, 380, 200, 40);
		t2.setBounds(350, 380, 250, 40);
		l3.setBounds(120, 460, 200, 40);
		t3.setBounds(350, 460, 250, 40);
		l4.setBounds(120, 540, 200, 40);
		t4.setBounds(350, 540, 250, 40);
		l6.setBounds(120, 620, 200, 40);
		t6.setBounds(350, 620, 250, 40);
		b1.setBounds(250, 700, 200, 40);
		b2.setBounds(640, 300, 200, 40);
		b3.setBounds(650, 80, 200, 40);
		l5.setBounds(250, 200, 400, 40);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l6);
		add(t6);
		add(l5);
		add(b1);
		add(b2);
		add(b3);
		
		getContentPane().setBackground(Color.GREEN);
		setTitle("Delete Book");
		setSize(900,900);
		setLayout(null);
		setVisible(true);
		
		Font myfont=new Font("serif",Font.BOLD,28);
		l1.setFont(myfont);
		l2.setFont(myfont);
		l3.setFont(myfont);
		l4.setFont(myfont);
		l6.setFont(myfont);
		t1.setFont(myfont);
		t2.setFont(myfont);
		t3.setFont(myfont);
		t4.setFont(myfont);
		t6.setFont(myfont);
		b1.setFont(myfont);
		b2.setFont(myfont);
		b3.setFont(myfont);

		
		Font Title=new Font("serif",Font.BOLD,40);
		l5.setForeground(Color.RED);
		l5.setFont(Title);
		
	 
		//Update book
		 b1.addActionListener(new ActionListener() {  
	            public void actionPerformed(ActionEvent e) {       
					try{Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123"); 
			          Statement stmt = conn.createStatement();
			          
			          //Book Count Updation
			          if(t6.getText().equals(""))
			          {
			        	  TotalBooks = Integer.parseInt(t4.getText());  
			        	  
			          }
			          else
			          {
			          TotalBooks = Integer.parseInt(t4.getText()) + Integer.parseInt(t6.getText());
			          if(TotalBooks<0)
			          {
			        	  TotalBooks=0;
			        	  
			          }
			          }
				         String sqlInsert = "update Books set BookID='"+t1.getText()+"',BookName='"+t2.getText()+"',AuthorName='"+t3.getText()+"',Quantity="+TotalBooks+" where BookID="+ t1.getText();  
				        
				         stmt.executeUpdate(sqlInsert);
				         JOptionPane.showMessageDialog(UpdateBook.this,"Book Updated !");
				         
				        //Book retrieve after updating
				         String strSelect = "select *  from Books where BookID="+t1.getText() ;
		    	         ResultSet rset = stmt.executeQuery(strSelect);
		    	         if(rset.next())
		    	         {
		 				String Bookname = rset.getString("BookName");
		 	            String Authorname = rset.getString("AuthorName");
		 	            int Quantity = rset.getInt("Quantity");
		 				t2.setText(Bookname);
		 				t3.setText(Authorname);
		 				t4.setText(""+Quantity);
		 				t6.setText("");
		    	         }
		    	            
				            
				}
					catch(Exception ex) {
						ex.printStackTrace();
						}
			}

				
			}); 
		 
		 //Search Book
		  b2.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	
		            	if(t1.getText().equals(""))
		            	{
		            		 JOptionPane.showMessageDialog(UpdateBook.this,"Please enter BookID");
		            		
		            	}
		            	else{
		            	try{
		            	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123");
		    	         Statement stmt = conn.createStatement();
		    	         String strSelect = "select *  from Books where BookID="+t1.getText() ;
		    	         ResultSet rset = stmt.executeQuery(strSelect);
		    	         if(rset.next())
		    	         {
		 				String Bookname = rset.getString("BookName");
		 	            String Authorname = rset.getString("AuthorName");
		 	            int Quantity = rset.getInt("Quantity");
		 				t2.setText(Bookname);
		 				t3.setText(Authorname);
		 				t4.setText(""+Quantity);
		    	         }
		    	         else
		    	         {
		    	        	JOptionPane.showMessageDialog(UpdateBook.this,"No Book Found");
		    	        	t2.setText("");
				 			t3.setText("");
				 			t4.setText("");
		    	         }
		            	}
		            	catch(SQLException ex) {
							ex.printStackTrace();
							}
		            	}
		            }
	         });
	         
		  
		 //Home Frame
		  b3.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 Home.main(new String[]{});
					    UpdateBook.this.dispose();
		            	
		            }
	         });
		  
		  
		
		addWindowListener(new WindowAdapter()
		{  
            public void windowClosing(WindowEvent e)
            {  
                dispose();  
            }  
        });
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new UpdateBook();
	}

}

