/*Yahya
Taylor
Jess
George
Trevor
Cody

*/
package computer.database;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/* This a published code as of right now, I am assignng everbody the task we talked about
last meeting. My intention since this simple app to get this done before spring break.

*/

public class ComputerDatabase{
  
    private Frame frame; //We only have one frame, panels decitate the next screem
    
    private Panel window; // panel 1 intro, opening, needs design
    private Panel user; //user interface Yahya
    private Panel sign;// user-login- figure out how to clear the user and pass
    //and cover the password
    private Panel data; // data-sql sync yahya
    /* Each Buttons, textfield are under each panel*/
    
    //under window control
    private Button open;
    
   //Under sign-in controls
    private Button log;
    private TextField name,pass;
    private Label username,password;
    
    //user setup controls
    private Button b1,b2;
    private TextField t1;
    private Label l1;
    
    //user data
    private Button b3;
    private TextField t2,t3,t4,t5,t6;
    private Label l2,l3,l4,l5,l6;
    
    //menu creation
    //Since only one frame it now distrubutes to the whole panel.
    private MenuBar mbar;
    private Menu menu;
    
 
  
    
    public static void main(String[] args) {
    ComputerDatabase cd = new ComputerDatabase();
    Table_Setup tb = new Table_Setup();
    tb.getData();
    cd.setup();
    cd.display();
    cd.control();
    // main runs method
    
    
    }
    //construtor
    public ComputerDatabase(){
        //initailize variables,methods,data, anything
     }
    public final void setup(){
        frame = new Frame("Computer Datebase");
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
         frame.setBackground(Color.LIGHT_GRAY);
        
        
        
       //frame add attachment
        window = new Panel();
        open = new Button("OPEN");
        window.add(open);
        window.setVisible(true);
       
        
        frame.add(window);
        
        //second panel attachment
        sign = new Panel();
        name = new TextField(12);
        pass = new TextField(12);
        username = new Label("Username");
        password = new Label("Password");
        log = new Button("Login");
        
        
        
        
        
        
        
        
        
        sign.add(username);
        sign.add(name);
        sign.add(password);
        sign.add(pass);
        sign.add(log);
        sign.setVisible(false);
        frame.add(sign);
        
        //user Interaction
        user = new Panel();
        b1 = new Button("Search");
        b2 = new Button("View Database");
        l1 = new Label("Search Items");
        t1 = new TextField(12);
        
        user.add(l1);
        user.add(t1);
        user.add(b1);
        user.add(b2);
        
        user.setVisible(false);
        frame.add(user);
       
        //data panel
        data = new Panel();
        data.setLayout(new BoxLayout(data, BoxLayout.Y_AXIS));
        l2 = new Label("Model Name");
        l3 = new Label("Manufacturer");
        l4 = new Label("Quantity");
        l5 = new Label("Serial Number");
        l6 = new Label("Type");
        b3 = new Button("Submit");
        t2 = new TextField(12);
        t3 = new TextField(12);
        t4 = new TextField(12);
        t5 = new TextField(12);
        t6 = new TextField(12);
       
        
        data.add(l2);
        data.add(t2);
        data.add(l3);
        data.add(t3);
        data.add(l4);
        data.add(t4);
        data.add(l5);
        data.add(t5);
        data.add(l6);
        data.add(t6);
        data.add(b3);
        data.setVisible(false);
        frame.add(data);
        
        
        //menu creation
        mbar = new MenuBar(); //Bar holds menu controls
        
        menu = new Menu("Settings"); //title
        
        MenuItem i1,i2,i3,i4; //Item for each control
        
        i1 = new MenuItem("Go to Main");
        i2 = new MenuItem("View Table");
        i3 = new MenuItem("Logout");
        i4 = new MenuItem("Exit");
        
        menu.add(i1);
        
        i1.addActionListener((ActionEvent e) -> {
            window.setVisible(true);
            sign.setVisible(false);
            user.setVisible(false);
            data.setVisible(false);
            
          
         });
        menu.add(i2);
        
        menu.add(i3);
        menu.addSeparator(); // seperates Exit from the groups
        menu.add(i4);
        i4.addActionListener((ActionEvent e) -> {
            System.exit(0);
         });
        
        mbar.add(menu); // holds menu
        
        frame.setMenuBar(mbar); //frame hold menubar
         
  }
    public final void control(){
          open.addActionListener((ActionEvent e) -> {
            window.setVisible(false);
            sign.setVisible(true);
            sign.revalidate();
       });
          //user login code and login
         
    
          log.addActionListener((ActionEvent e) -> {
            String n = name.getText();
            String p = pass.getText();
            pass.setEchoChar('●');
         if(n.equals("computer") && p.equals("club")){
                 
                JOptionPane.showMessageDialog(sign,"You are logined");
                user.setVisible(true);
                sign.setVisible(false);
                user.revalidate();
           }
            else
                JOptionPane.showMessageDialog(sign,"You are not logined");
            
         });
          
            b2.addActionListener((ActionEvent e) -> {
            data.setVisible(true);
            user.setVisible(false);
            user.revalidate();
       });
            b3.addActionListener((ActionEvent e) -> {
                
            String item = t2.getText();
            String item1 = t3.getText();
            String item2 = t4.getText();
            String item3 = t5.getText();
            String item4 = t6.getText();
           
            
         });
         
            
            
  }
    public final void display(){
      
          frame.setVisible(true);
    }
   
}
