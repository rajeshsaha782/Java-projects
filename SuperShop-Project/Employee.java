import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Employee extends JFrame implements ActionListener
{
	private JLabel shopName1,shopName2,note,pIdLabel,nopLabel;
	private JTextField pId,nop;
	private JButton back,edit,sell,viewProduct,logOut,profile;
	private JPanel panel;
	private String eId;
	public Employee(String id)
	{
		super("Employee Home");
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		eId=id;
		
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
		
		edit = new JButton("Edit");
		edit.setBounds(140,90,100,30);
		edit.setFont(new Font("Times New Roman", 0, 20));
		edit.addActionListener(this);
		this.add(edit);
		
		logOut = new JButton("LogOut");
		logOut.setBounds(270,90,100,30);
		logOut.setFont(new Font("Times New Roman", 0, 20));
		logOut.addActionListener(this);
		this.add(logOut);
		
		viewProduct = new JButton("ViewProduct");
		viewProduct.setBounds(10,140,165,30);
		viewProduct.setFont(new Font("Times New Roman", 0, 20));
		viewProduct.addActionListener(this);
		this.add(viewProduct);
		
		profile = new JButton("Profile");
		profile.setBounds(205,140,165,30);
		profile.setFont(new Font("Times New Roman", 0, 20));
		profile.addActionListener(this);
		this.add(profile);
		
		pIdLabel = new JLabel("Product ID",JLabel.CENTER);
		pIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pIdLabel.setBounds(50, 230, 100, 30);
		pIdLabel.setForeground(Color.white);
		this.add(pIdLabel);
		
		nopLabel = new JLabel("No of Product",JLabel.CENTER);
		nopLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nopLabel.setBounds(210, 230, 120, 30);
		nopLabel.setForeground(Color.white);
		this.add(nopLabel);
		
		pId = new JTextField("");
		pId.setFont(new Font("Times New Roman", 0, 20));
		pId.setBounds(38, 280, 120, 30);
		this.add(pId);
		
		nop = new JTextField("");
		nop.setFont(new Font("Times New Roman", 0, 20));
		nop.setBounds(210, 280, 120, 30);
		this.add(nop);
		
		sell = new JButton("SELL");
		sell.setBounds(130,330,100,50);
		sell.setFont(new Font("Arial Black", Font.BOLD, 20));
		sell.setBackground(Color.green);
		sell.addActionListener(this);
		this.add(sell);
		
		note = new JLabel("",JLabel.CENTER);
		note.setFont(new Font("Times New Roman", Font.BOLD, 20));
		note.setBounds(70, 450, 220, 30);
		note.setOpaque(true);
		note.setVisible(false);
		note.setBackground(Color.white);
		note.setForeground(Color.red);
		this.add(note);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();

		if(str.equals("Back"))
		{
			this.setVisible(false);
			dispose();
			new Login().setVisible(true);
		}
		else if(str.equals("ViewProduct"))
		{
			this.setVisible(false);
			dispose();
			new ViewProduct(eId,2).setVisible(true);
		}
		else if(str.equals("Profile"))
		{
			String query = "SELECT * FROM `EMPLOYEE`;";
			Connection con=null;
			Statement st = null;
			ResultSet rs = null;
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_3","root","");
				st = con.createStatement();
				rs = st.executeQuery(query);
					
				while(rs.next())
				{
					if(rs.getString("EID").equals(eId))
					{
						String s="ID"+"         "+"NAME"+"          "+"SALARY"+"              "+"DESIGNATION"+"\r\n";
						s=s+rs.getString("EID")+"            "+rs.getString("NAME")+"           "+rs.getString("SALARY")+"             "+rs.getString("DESIGNATION")+"\r\n";
						JOptionPane.showMessageDialog(this,s);	
						break;
					}
				}
	
			}
			catch(Exception e)
			{
				System.out.println("Exception : " +e.getMessage());
			}
			finally
			{
				try
				{
					if(rs!=null)
						rs.close();

					if(st!=null)
						st.close();

					if(con!=null)
						con.close();
				}
				catch(Exception ex){}
				
			}
        
		}
		
		else if(str.equals("Edit"))
		{
			this.setVisible(false);
			dispose();
			new Edit(eId,2).setVisible(true);
		}
		else if(str.equals("LogOut"))
		{
			this.setVisible(false);
			dispose();
			new Login().setVisible(true);
		}
		
		else if (str.equals("SELL") && !pId.getText().equals("") && !nop.getText().equals(""))
		{
			note.setVisible(true);
			note.setText("Produt Not Found");
			String query = "SELECT `PID`, `PNAME`,`COMPANY_NAME`,`PRICE`,`INVENTORY` FROM `product`;"; 
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
				rs = st.executeQuery(query);
				System.out.println("results received");
				
				while(rs.next())
				{
					String Id = rs.getString("PID");
					int inventory=rs.getInt("inventory");
					
					if(pId.getText().equals(Id))
					{
						if(inventory>=Integer.parseInt(nop.getText()))
						{
							try
							{
								inventory=inventory-Integer.parseInt(nop.getText());
								query = "UPDATE product SET INVENTORY="+"'"+inventory+"'"+" where PID="+"'"+pId.getText()+"';";
								System.out.println(query);
								st.executeUpdate(query);
								st.close();
								con.close();
								rs.close();
								
								note.setVisible(true);
								note.setText("Successfully SOLD");
								break;
							}
							catch(Exception e){System.out.println(e.getMessage());}
						}	
						else
						{
							note.setVisible(true);
							note.setText("Out of Stock");
						}
					}
				}
				
		
			}
			catch(Exception e){System.out.println(e.getMessage());}
			
			
		}
	}
}
	