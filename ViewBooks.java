package LibraryManagementSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

public class ViewBooks extends JFrame {

	
	public ViewBooks() {
		
		
		 JTable table;
		 JButton b1;
		 JLabel l1;
		
		b1=new JButton("Back");
		b1.setBounds(600,80,200,40);
		l1= new JLabel("Available books in Library");
		l1.setBounds(300,150,400,40);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Rohan@123"); 
			PreparedStatement ps=con.prepareStatement("select * from books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		table.setRowHeight(40);
		JScrollPane sp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setBounds(100,200,700,500);
		contentPane.add(b1);
		contentPane.add(l1);
		contentPane.add(sp);
		getContentPane().setBackground(Color.MAGENTA);
		setVisible(true);
		setSize(900, 900);
		
		Font myfont1=new Font("serif",Font.BOLD,22);
		Font myfont2=new Font("serif",Font.BOLD,28);
		Font myfont=new Font("serif",Font.BOLD,20);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(myfont1);
		table.setFont(myfont);
		b1.setFont(myfont2);
		l1.setFont(myfont2);
		
		
		  b1.addActionListener(new ActionListener() 
	         {  
		            public void actionPerformed(ActionEvent e) 
		            { 
		            	 Home.main(new String[]{});
					     ViewBooks.this.dispose();
		            	
		            }
	         });
		  
	}

	
	public static void main(String[] args) {
		
		 new ViewBooks();
		
		
}		

}
