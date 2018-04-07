package DataObjects;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import javax.swing.JOptionPane;
public class RoleReg {
	
	
	public static void main(String[] args)
	{
	ColorsFrame1 frame=new ColorsFrame1();
	//System.out.println("Hello world");

	}
	
}
    class ColorsFrame1 extends Frame implements ActionListener
	{
	Button b1;
	Label name;
	
	TextField t1;
	Panel controlpanel;
	Choice type,seclevel,cat;
	ColorsFrame1()
	{
	this.setVisible(true);
	this.setSize(700,700);
	this.setTitle("Button Example");
	controlpanel=new Panel();
	controlpanel.setLayout(new FlowLayout());
	name=new Label("name");
	
	
	t1=new TextField(10);
	//t1.setText("def");
	
	t1.setBounds(50,100, 200,30); 
	type=new Choice();
	seclevel=new Choice();
	cat=new Choice();
	seclevel.add("unclassified");
	seclevel.add("classified");
	seclevel.add("secret");
	seclevel.add("topsecret");
	type.add("subject");
	type.add("object");
	cat.add("nato");
	cat.add("nuclear");
	cat.add("navy");



	b1=new Button("Login");
	


	

	b1.addActionListener(this);
	

	this.add(controlpanel);
	//controlpanel.add(name1);
	controlpanel.add(type);
	controlpanel.add(name);
	controlpanel.add(t1);
	controlpanel.add(seclevel);
	controlpanel.add(cat);
	

	controlpanel.add(b1);
	//this.add(b2);
	//this.add(b3);

	 addWindowListener(new WindowAdapter(){  
	            public void windowClosing(WindowEvent e) {  
	                dispose();  
	            }  
	        }); 

	 

	}

	 

	public void actionPerformed(ActionEvent ae)
	{


	String button_label=ae.getActionCommand();
	

	if(button_label.equals("Login"))
	{
		
		try{
			
			 String tpe=type.getSelectedItem(); 
			 String sl=seclevel.getSelectedItem();
			 String ct=cat.getSelectedItem();
			 String nme=t1.getText();
			 
			 System.out.println("type is "+tpe);
			 System.out.println("sec level is "+sl);
			 System.out.println("category is  "+ct);
			 System.out.println("name is  "+nme);
			 
			 
			 Connection Con= DbConnection.GetDbConnection();
			 JOptionPane.showMessageDialog(this," established");
			 
			 Statement stmt = null;	 stmt = Con.createStatement();
			 
			 String sql = "SELECT username FROM userpasswd";
		     ResultSet rs = stmt.executeQuery(sql);
		     int set=99;
		     String ud=null;
		     while(rs.next()){
		         //Retrieve by column name
		     	  ud= rs.getString("username");
		     	  
		     	  if(ud.trim().equals(nme))
		     	  {
		     		  set=100;
		     		  System.out.println("i set 100");
		     	  }
		     	  
		     	 System.out.println("userid: " + ud);
		   
		         }
		      // rs.beforeFirst();
		       
		      if(set==100)
		    	  JOptionPane.showMessageDialog(this,"user name already exists bitch! ");
		       
		   if(set!=100 && nme!="def" )
		     {
		    	 
		    	 String sql1 = "INSERT INTO userpasswd(username)VALUES (?)";
		    	 
		    	 PreparedStatement statement = Con.prepareStatement(sql1);
		    	 
		    	 
		    	 statement.setString(1,nme);
		    	 
		    	  
		    	 int rowsInserted = statement.executeUpdate();
		    	 if (rowsInserted > 0) {
		    	     System.out.println("A new user was inserted successfully!");
		    	     JOptionPane.showMessageDialog(this,"Thank u bitch! ");
		    	 }
		    	 
		    	 }
		   System.out.println("empty string given"+t1.getText());
			
		     
			if(nme.equals(""))
			{
				JOptionPane.showMessageDialog(this,"give some name bitch! ");
				System.out.println("empty string given");
				
			}
			 
			
			 
			 
			 
			 
			 
			 
			 
			 
		
		
		}catch(Exception e){
			
			
		}
		
	}


	}//end if button

	/*else{
	JOptionPane.showMessageDialog(this,"wrong password","Error Message Box",JOptionPane.ERROR_MESSAGE);
	}
	this.setBackground(Color.red);
	}

	if(button_label.equals("GREEN"))
	{
	this.setBackground(Color.green);
	}

	if(button_label.equals("BLUE"))
	{
	this.setBackground(Color.blue);
	}*/


	}//end method


	//}
	//end class










	
	
	
	
	
	


