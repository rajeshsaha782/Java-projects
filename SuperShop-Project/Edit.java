import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Edit extends JFrame implements ActionListener
{
	private JLabel shopName1,shopName2,idLabel,nameLabel,passLabel,rePassLabel,note;
	private JTextField nameText;
	private JButton back,submit;
	private JPasswordField passText,rePassText;
	private JPanel panel;
	private String id;
	private int identifier;
	
	
	public Edit(String d,int i)
	{
		super("Edit");
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		id=d;
		identifier=i;
		
		panel = new JPanel();
		panel.setBackground(Color.gray);
		panel.setBounds(0,0,400,600);
		this.setLayout(null);
		
		
		shopName1 = new JLabel("DELTA FORCE",JLabel.CENTER);
		shopName1.setFont(new Font("Arial Black", Font.BOLD, 42));
		shopName1.setBounds(10, 10, 362, 50);
		shopName1.setBackground(Color.red);
		shopName1.setForeground(Color.white);
		shopName1.setOpaque(true);
		this.add(shopName1);
		
		shopName2 = new JLabel("                                         Super Shop");
		shopName2.setFont(new Font("Arial Black", Font.BOLD, 15));
		shopName2.setBounds(10, 60, 362, 20);
		shopName2.setBackground(Color.red);
		shopName2.setForeground(Color.white);
		shopName2.setOpaque(true);
		this.add(shopName2);
		
		back = new JButton("Back");
		back.setBounds(10,90,100,30);
		back.setFont(new Font("Times New Roman", 0, 20));
		back.addActionListener(this);
		this.add(back);
		
		idLabel = new JLabel("User Id: "+id,JLabel.CENTER);
		idLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		idLabel.setBounds(100, 180, 200, 30);
		idLabel.setOpaque(true);
		this.add(idLabel);
		
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		nameLabel.setBounds(80, 240, 90, 30);
		nameLabel.setForeground(Color.white);
		this.add(nameLabel);
		
		
		nameText = new JTextField("");
		nameText.setFont(new Font("Times New Roman", 0, 20));
		nameText.setBounds(180, 240, 120, 30);
		this.add(nameText);
		
		passLabel= new JLabel("Password");
		passLabel.setFont(new Font("Arial Black", 0, 15));
		passLabel.setBounds(80, 300, 100, 30);
		passLabel.setForeground(Color.white);
		this.add(passLabel);
		
		
		passText= new JPasswordField();
		passText.setFont(new Font("Times New Roman", 0, 20));
		passText.setBounds(180, 300, 120, 30);
		this.add(passText);
		
		rePassLabel= new JLabel("ReEnter");
		rePassLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		rePassLabel.setBounds(80, 360, 100, 30);
		rePassLabel.setForeground(Color.white);
		this.add(rePassLabel);
		
		
		rePassText= new JPasswordField();
		rePassText.setFont(new Font("Times New Roman", 0, 20));
		rePassText.setBounds(180, 360, 120, 30);
		this.add(rePassText);
		
		submit= new JButton("Submit");
		submit.setFont(new Font("Arial Black", Font.BOLD, 15));
		submit.setBounds(150, 430, 100, 30);
		submit.setForeground(Color.white);
		submit.setBackground(Color.blue);
		submit.addActionListener(this);
		this.add(submit);
		
		note= new JLabel("",JLabel.CENTER);
		note.setFont(new Font("Arial Black", 0, 15));
		note.setBounds(100, 470, 200, 30);
		note.setForeground(Color.red);
		note.setBackground(Color.white);
		note.setOpaque(true);
		note.setVisible(false);
		this.add(note);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();

		if(str.equals("Back"))
		{
			if(identifier==1)
			{
				this.setVisible(false);
				dispose();
				new Admin(id).setVisible(true);
			}
			else if(identifier==2)
			{
				this.setVisible(false);
				dispose();
				new Employee(id).setVisible(true);
			}
			else
			{
				this.setVisible(false);
				dispose();
				new Customer(id).setVisible(true);
			}
			
		}
		else if(str.equals("Submit"))
		{
			
			if(!nameText.getText().equals(""))
			{
				
				Connection con=null;
				Statement st = null;
				ResultSet rs = null;
				
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("driver loaded");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_3","root","");
					System.out.println("connection done");
					st = con.createStatement();
					System.out.println("statement created");
					String query;
					if(identifier==1)
					{
						query = "UPDATE adminstrator SET NAME="+"'"+nameText.getText()+"'"+" where AID="+"'"+id+"';";
					}
					else if(identifier==2)
					{
						query = "UPDATE employee SET NAME="+"'"+nameText.getText()+"'"+" where EID="+"'"+id+"';";
					}
					else
					{
						query = "UPDATE customer SET NAME="+"'"+nameText.getText()+"'"+" where CID="+"'"+id+"';";
					}
					
					System.out.println(query);
					st.executeUpdate(query);
					st.close();
					con.close();
					note.setVisible(true);
					note.setText("Name Changed");
			
				}
				catch(Exception e){System.out.println(e.getMessage());}
			}
			
			if(!passText.getText().equals(""))
			{
				
				if(passText.getText().equals(rePassText.getText()))
				{
					note.setVisible(false);
					note.setText("");
					
					Connection con=null;
					Statement st = null;
					ResultSet rs = null;
					
					try
					{
						
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("driver loaded");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_3","root","");
						System.out.println("connection done");
						st = con.createStatement();
						System.out.println("statement created");
						
						String query;
						if(identifier==1)
						{
							query = "UPDATE adminstrator SET PASS="+"'"+passText.getText()+"'"+" where AID="+"'"+id+"';";
						}
						else if(identifier==2)
						{
							query = "UPDATE employee SET PASS="+"'"+passText.getText()+"'"+" where EID="+"'"+id+"';";
						}
						else
						{
							query = "UPDATE customer SET PASS="+"'"+passText.getText()+"'"+" where CID="+"'"+id+"';";
						}
						
						
						System.out.println(query);
						st.executeUpdate(query);
						st.close();
						con.close();
						note.setVisible(true);
						note.setText("Password Changed");
				
					}
					catch(Exception e){System.out.println(e.getMessage());}
				}
				else
				{
					note.setVisible(true);
					note.setText("Password not matched");
				}
				
				
			}
		}
	}
	
}