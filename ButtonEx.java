import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ColorsFrame extends Frame implements ActionListener
{
Button b1,b2,b3;
Label name;
Label passwd;
TextField t1,t2;
Panel controlpanel;


ColorsFrame()
{
this.setVisible(true);
this.setSize(700,700);
this.setTitle("Button Example");
controlpanel=new Panel();
controlpanel.setLayout(new FlowLayout());
name=new Label("User ID:");
passwd=new Label("password: ");
t1=new TextField(10);
t2=new TextField(10);
t2.setEchoChar('*');
t1.setBounds(50,100, 200,30);  



b1=new Button("Login");
b2=new Button("GREEN");
b3=new Button("BLUE");


b1.setBackground(Color.red);
b2.setBackground(Color.green);
b3.setBackground(Color.blue);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);


this.add(controlpanel);
controlpanel.add(name);
controlpanel.add(t1);
controlpanel.add(passwd);
controlpanel.add(t2);

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
String user=t2.getText();
if(user.equals("bala"))
JOptionPane.showMessageDialog(this," correct password");

else{
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
}


}


}










class ButtonEx
{


public static void main(String[] args)
{
ColorsFrame frame=new ColorsFrame();
//System.out.println("Hello world");

}


}