package LibraryManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Home extends JFrame 
{
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8; 
	String msg="";
	
	TextArea display_details;

 Home()
	{
		b1=new JButton("Add Book");
		b2=new JButton("Remove Book");		
		b3=new JButton("Update Book");
		b4=new JButton("View Books");
		b5=new JButton("Add Record");
		b6=new JButton("Remove Record");
		b7=new JButton("All Records");
		b8=new JButton("Log Out");
		l1=new JLabel("WELCOME LIBRARIAN");
		
		b1.setBounds(300, 300, 300, 40);
		b2.setBounds(300, 370, 300, 40);
		b3.setBounds(300, 440, 300, 40);
		b4.setBounds(300, 510, 300, 40);
		b5.setBounds(300, 580, 300, 40);
		b6.setBounds(300, 650, 300, 40);
		b7.setBounds(300, 720, 300, 40);
		b8.setBounds(650, 80, 150, 40);
		l1.setBounds(250, 200, 500, 40);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
	    add(b7);
	    add(b8);
		add(l1);
	    
	    setTitle("Welcome Frame");
		setSize(900,900);
		setLayout(null);
		setVisible(true);
		
		Font myfont=new Font("serif",Font.BOLD,28);
		Font Title=new Font("serif",Font.BOLD,40);
		
		b1.setFont(myfont);
		b2.setFont(myfont);
		b3.setFont(myfont);
		b4.setFont(myfont);
		b5.setFont(myfont);
		b6.setFont(myfont);
		b7.setFont(myfont);
		b8.setFont(myfont);
		l1.setFont(Title);
		l1.setForeground(Color.RED);
		
		getContentPane().setBackground(Color.ORANGE);
		
	
		
		
		  b1.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 AddBook.main(new String[]{});
					     Home.this.dispose();
		            	
		            }
	         });
		  
		  b2.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 DeleteBook.main(new String[]{});
					     Home.this.dispose();
		            	
		            }
	         });
		  b3.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 UpdateBook.main(new String[]{});
					     Home.this.dispose();
		            	
		            }
	         });
		  b4.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 ViewBooks.main(new String[]{});
					     Home.this.dispose();
		            	
		            }
	         });
		  b5.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 AddRecord.main(new String[]{});
					     Home.this.dispose();
		            	
		            }
	         });
		  b6.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 RemoveRecord.main(new String[]{});
					     Home.this.dispose();
		            	
		            }
	         });
		  b7.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 ViewRecords.main(new String[]{});
					     Home.this.dispose();
		            	
		            }
	         });
		  
		  b8.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 Login.main(new String[]{});
					     Home.this.dispose();
		            	
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
   new Home();
	}

}