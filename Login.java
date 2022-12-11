package LibraryManagementSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Login extends JFrame 
{
	JLabel l1,l2,l3,l4;
	JTextField t1;
	JPasswordField p1;
	JButton b1;
	
	 
	Login()
	{
		
		l1  = new JLabel("Username : ");
		l2  = new JLabel("Password: ");
	    l3 = new JLabel("Library Management System");
        l4 = new JLabel("Librarian Login");
       
		t1  = new JTextField();
		p1  = new JPasswordField();
		b1  = new JButton("Submit");
		   
		        
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Rohan\\OneDrive\\Desktop\\library.jpg")));
		
		l1.setBounds(250, 320, 150, 40);
		t1.setBounds(400, 320, 200, 40);
		
		l2.setBounds(250, 390, 150, 40);
		p1.setBounds(400, 390, 200, 40);
	
		l3.setBounds(200, 100, 500, 50);
		l4.setBounds(350, 220, 300, 40);
		
	
		
		b1.setBounds(350, 500, 140, 40);
		
		p1.setEchoChar('*');
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		
		
		add(t1);
		add(p1);
		
		add(b1);
		
		
		
		
		setTitle("Login");
		setSize(900,900);
		setLayout(null);
		setVisible(true);

		  
		addWindowListener(new WindowAdapter()
		{  
            public void windowClosing(WindowEvent e)
            {  
                dispose();  
            }  
        });
		
	
		Font myfont=new Font("serif",Font.BOLD,28);
		Font Title=new Font("serif",Font.BOLD,40);
		
		l1.setFont(myfont);
		l2.setFont(myfont);
		
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);;
		
	    l3.setFont(Title);
	    l4.setFont(myfont);
	    
		t1.setFont(myfont);
		p1.setFont(myfont);
		
		b1.setFont(myfont);
		
		
		   
	
	
	         b1.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            {   
		            	
		            	
						try{  
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123");
				         Statement stmt = conn.createStatement();
				         String strSelect = "select * from login where Username='"+t1.getText()+"'&& Password='"+new String(p1.getPassword())+"'";
				         ResultSet rset = stmt.executeQuery(strSelect);
							
				    
							if(rset.next())
						{
							
					     JOptionPane.showMessageDialog(Login.this,"Login Successfully...!");
					     Home.main(new String[]{});
					     dispose();
						}
						else
							{
							
						JOptionPane.showMessageDialog(Login.this,"Invalid Login");
							}
						}
						catch(SQLException ex) 
						{
						ex.printStackTrace();
						}					
				  
		            }});  
		 }
	

	public static void main(String[] args)
	{
		new Login();
	}
}
