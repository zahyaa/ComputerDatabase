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
import javax.swing.table.*;
import java.util.*;
import java.io.*;

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
    
    private Panel store; //Create a JTable for the application
    
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
    private TextField t2,t3,t4,t7,t8;
    private Label l2,l3,l4,l5,l6,l7,l8;
    private Choice c, c1;
    
    //under panel table
    JScrollPane scroll;
    private Button srt,remove,update;
    private TextField ta,tc,td,te,tf;
    private Label la,lb,lc,ld,le,lf,lg;
    Choice c2,c3;
    
    JTable table = new JTable(); // creates a table
    
    DefaultTableModel model = new DefaultTableModel(); // create a model to add item rows x colms
    
    //menu creation
    //Since only one frame it now distrubutes to the whole panel.
    private MenuBar mbar;
    private Menu menu;
    private MenuItem i1,i2,i4,i5,i7; //Item for each control
    
 
  
    
    public static void main(String[] args) {
    ComputerDatabase cd = new ComputerDatabase();
    cd.setup();
    cd.display();
    cd.control();
    // main runs method
    
    
    }
    //construtor
    public ComputerDatabase(){
        //initailize variables,methods,data
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
        b2 = new Button("Input Data");
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
        l2 = new Label("ID #");
        l3 = new Label("Model-Name");
        l4 = new Label("Manufacturer");
        l5 = new Label("Type");
        l6 = new Label("Platform");
        l7 = new Label("Serial #");
        l8 = new Label("Quantity");
        b3 = new Button("Submit");
        t2 = new TextField(12);
        t3 = new TextField(12);
        t4 = new TextField(12);
        t7 = new TextField(12);
        t8 = new TextField(12);
        c = new Choice();
        c.add("Desktop");
        c.add("Console");
        c.add("Keyboard");
        c.add("Mouse");
        c.add("Controller");
        c.add("Cables");
        c.add("Harddrive");
        c.add("Monitor");
        
        c1 = new Choice();
        
        c1.add("Gaming");
        c1.add("PC");
        c1.add("Portable");
        
        data.add(l2);
        data.add(t2);
        data.add(l3);
        data.add(t3);
        data.add(l4);
        data.add(t4);
        data.add(l5);
        data.add(c);
        data.add(l6);
        data.add(c1);
        data.add(l7);
        data.add(t7);
        data.add(l8);
        data.add(t8);
        data.add(b3);
        data.setVisible(false);
        frame.add(data);
        
        //Table setup
        store = new Panel();
        store.setLayout(new BoxLayout(store, BoxLayout.Y_AXIS));
        srt = new Button("Sort");
        remove = new Button("Remove");
        update = new Button("Update");
        la = new Label("ID #");
        lb = new Label("Model-Name");
        lc = new Label("Manufacturer");
        ld = new Label("Type");
        le = new Label("Platform");
        lf = new Label("Serial #");
        lg = new Label("Quantity");
       
        ta = new TextField(12);
        tc = new TextField(12);
        td = new TextField(12);
        te = new TextField(12);
        tf = new TextField(12);
        c2 = new Choice();
        c2.add("Desktop");
        c2.add("Console");
        c2.add("Keyboard");
        c2.add("Mouse");
        c2.add("Controller");
        c2.add("Cables");
        c2.add("Harddrive");
        c2.add("Monitor");
        
        c3 = new Choice();
        
        c3.add("Gaming");
        c3.add("PC");
        c3.add("Portable");
        Object[] colms = {"ID",
                        "Model-Name",
                        "Manufacture",
                        "Type",
                        "Platform",
                        "Serial",
                        "Quantity"};
        
        
        model.setColumnIdentifiers(colms);
        table.setModel(model);
        
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
       
        
        
        scroll = new JScrollPane(table);
        store.add(scroll);
        store.add(srt);
        store.add(remove);
        store.add(update);
        store.add(la);
        store.add(ta);
        store.add(lb);
        store.add(tc);
        store.add(lc);
        store.add(td);
        store.add(ld);
        store.add(c2);
        store.add(le);
        store.add(c3);
        store.add(lf);
        store.add(te);
        store.add(lg);
        store.add(tf);
        
        store.setVisible(false);
        frame.add(store);
        //menu creation
        mbar = new MenuBar(); //Bar holds menu controls
        
        menu = new Menu("Settings"); //title
        
        
        
        i1 = new MenuItem("Go to Main");
        i2 = new MenuItem("View Table");
        i4 = new MenuItem("Exit");
        i5 = new MenuItem("Export-File");
        i7 = new MenuItem("Import File");
        
        menu.add(i1);
        
        i1.addActionListener((ActionEvent e) -> {
            window.setVisible(true);
            sign.setVisible(false);
            user.setVisible(false);
            data.setVisible(false);
            store.setVisible(false);
            
          
         });
        menu.add(i2);
        i2.addActionListener((ActionEvent e) -> {
            store.setVisible(true);
            window.setVisible(false);
            sign.setVisible(false);
            user.setVisible(false);
            data.setVisible(false);
           
            
            frame.revalidate();
        });
        menu.add(i5);
        menu.add(i7);
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
            Object[] row = new Object[7];
            b3.addActionListener((ActionEvent e) -> {
            
           
            row[0] = t2.getText();
            row[1] = t3.getText();
            row[2] = t4.getText();
            row[3] = c.getSelectedItem();
            row[4]= c1.getSelectedItem();
            row[5]= t7.getText();
            row[6] = t8.getText();
            
            model.addRow(row);
            JOptionPane.showMessageDialog(data,"Data Submited");
           
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t7.setText("");
            t8.setText("");
           
            
         });
      remove.addActionListener((ActionEvent e) -> {
           int s = table.getSelectedRow();
          try{
              model.removeRow(s);

          }catch(Exception ex){
              ex.printStackTrace();
          }
       });
      //This method highlights a row and changes the information
       update.addActionListener((ActionEvent e) -> {
           int s = table.getSelectedRow();
          try{
                 model.setValueAt(ta.getText(), s, 0);
                 model.setValueAt(tc.getText(), s, 1);
                 model.setValueAt(td.getText(), s, 2);
                 model.setValueAt(c2.getSelectedItem(), s, 3);
                 model.setValueAt(c3.getSelectedItem(), s, 4);
                 model.setValueAt(te.getText(), s, 5);
                 model.setValueAt(tf.getText(), s, 6);
                 

          }catch(Exception ex){
              ex.printStackTrace();
          }
       });
            
       i5.addActionListener((ActionEvent e) -> {
       try{
           //change your windows user name
           String filePath = "C:\\Users\\masterbird\\Desktop\\data.txt"; //file path change it to your computer
           File file = new File(filePath);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i = 0; i < model.getRowCount(); i++){//rows
                for(int j = 0; j < model.getColumnCount(); j++){//columns
                    bw.write(model.getValueAt(i, j).toString()+" ");
                }
                bw.newLine();
            }
            
            bw.close();
            fw.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         
           
       }catch(Exception ex){
           System.out.println("Error can't write" + ex.getMessage());
           
       }
        
         });
       
       
       
       
      i7.addActionListener((ActionEvent e) -> {
       try{
           String filePath = "C:\\Users\\masterbird\\Desktop\\data.txt";
           File file = new File(filePath);
          try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            
            Object[] lines = br.lines().toArray();
            
            for(int i = 0; i < lines.length; i++){
                String[] row1 = lines[i].toString().split(" ");
            
                model.addRow(row1);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         
           
       }catch(Exception ex){
           System.out.println("Error can't write" + ex.getMessage());
           
       }
        
         });
        
        
         
            
            
  }
    public final void display(){
      
          frame.setVisible(true);
    }
   
}
