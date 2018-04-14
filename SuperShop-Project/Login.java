import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
	private JLabel idLabel, passLabel,shopName1,shopName2,comboLabel;
	private JTextField idTextField,newId;
	private JPasswordField passField,newpass;
	private JButton Login,createAcc,back;
	private JPanel panel;
	private JComboBox combo;
	private boolean flag;
	public Login()
	{
		super("Login");
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.gray);
		panel.setLayout(null);
		
		shopName1 = new JLabel("DELTA FORCE",JLabel.CENTER);
		shopName1.setFont(new Font("Arial Black", Font.BOLD, 42));
		shopName1.setBounds(10, 10, 362, 50);
		shopName1.setBackground(Color.red);
		shopName1.setForeground(Color.white);
		shopName1.setOpaque(true);
		panel.add(shopName1);
		
		shopName2 = new JLabel("                                         Super Shop");
		shopName2.setFont(new Font("Arial Black", Font.BOLD, 15));
		shopName2.setBounds(10, 60, 362, 20);
		shopName2.setBackground(Color.red);
		shopName2.setForeground(Color.white);
		shopName2.setOpaque(true);
		panel.add(shopName2);
		
		idLabel = new JLabel("UserId	 ");
		idLabel.setBounds(80, 180, 100, 25);
		idLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(200, 180, 120, 25);
		idTextField.setFont(new Font("Times New Roman",0, 20));
		panel.add(idTextField);
		
		passLabel = new JLabel("Password	 ");
		passLabel.setBounds(80, 230, 100, 25);
		passLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(passLabel);
		
		passField = new JPasswordField();
		passField.setBounds(200, 230, 120, 25);
		passField.setFont(new Font("Times New Roman",0, 20));
		panel.add(passField);
		
		comboLabel = new JLabel("You are");
		comboLabel.setBounds(80, 285, 100, 25);
		comboLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(comboLabel);
		
		String s[] = {"Customer","Employee","Admin"};
		combo = new JComboBox(s);
		combo.setBounds(200, 285, 120, 25);
		combo.setFont(new Font("Times New Roman",0, 20));
		panel.add(combo);
		
		Login = new JButton("Login");
		Login.setBounds(140,370,120,40);
		Login.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Login.setBackground(Color.blue);
		Login.setForeground(Color.white);
		Login.addActionListener(this);
		panel.add(Login);
		
		back = new JButton("Back");
		back.setBounds(10,90,100,30);
		back.setFont(new Font("Times New Roman", 0, 20));
		back.addActionListener(this);
		back.setVisible(false);
		this.add(back);
		
		createAcc = new JButton("Create New Account");
		createAcc.setBounds(100,500,200,30);
		createAcc.setFont(new Font("Times New Roman",0, 15));
		createAcc.addActionListener(this);
		panel.add(createAcc);
	
		
		newpass = new JPasswordField("");
		newpass.setBounds(200, 285, 120, 25);
		newpass.setFont(new Font("Times New Roman",0, 20));
		newpass.setVisible(false);
		panel.add(newpass);
	
	
		newId = new JTextField("");
		newId.setBounds(200, 230, 120, 25);
		newId.setFont(new Font("Times New Roman",0, 20));
		newId.setVisible(false);
		panel.add(newId);
	
		this.add(panel);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		String user = combo.getSelectedItem().toString();
		
		if(str.equals("Login"))
		{
			if(user.equals("Customer"))
			{
				flag=false;
				check(3);
			}
			else if(user.equals("Employee"))
			{
				flag=false;
				check(2);
			}
			else if(user.equals("Admin"))
			{
				flag=false;
				check(1);
			}
		}
		else if(str.equals("Back"))
		{
			back.setVisible(false);
			new Login().setVisible(true);
		}
		else if(str.equals("Create New Account"))
		{
			passField.setVisible(false);
			combo.setVisible(false);
			createAcc.setVisible(false);
			
			idTextField.setText("");
			passField.setText("");
			
			idLabel.setText("Name");
			passLabel.setText("User ID");
			comboLabel.setText("Password");
			back.setVisible(true);
			newId.setVisible(true);
			newpass.setVisible(true);
			Login.setText("Create");
		}
		else if(str.equals("Create") && !newId.getText().equals("") && !newpass.getText().equals("") && !idTextField.getText().equals(""))
		{
			String query = "INSERT INTO CUSTOMER VALUES ('"+newId.getText()+"','"+newpass.getText()+"','"+idTextField.getText()+"');";
			System.out.println(query);                                                               
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_3", "root", "");
				Statement stm = con.createStatement();
				stm.execute(query);
				stm.close();
				con.close();
				JOptionPane.showMessageDialog(this,"Successfully Created"); 		
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this,"User Id Already Exists"); 
			}
			
			passField.setVisible(true);
			combo.setVisible(true);
			createAcc.setVisible(true);
			newId.setVisible(false);
			newpass.setVisible(false);
			back.setVisible(false);
			idLabel.setText("UserId");
			passLabel.setText("Password");
			comboLabel.setText("You are");
			Login.setText("Login");
			idTextField.setText("");
			passField.setText("");
			newId.setText("");
			newpass.setText("");
			
		}
	}
	public void check(int i)
	{
		String query="";
		
		if(i==3)
		{
			query = "SELECT `CID`, `PASS` FROM `CUSTOMER`;"; 
		}
        else if(i==2)
		{
			query = "SELECT `EID`, `PASS` FROM `Employee`;"; 
		}		
		else
		{
			query = "SELECT `AID`, `PASS` FROM `Adminstrator`;"; 
		}
		
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
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
                String userId="";
				if(i==3)
				{
					userId = rs.getString("CID");
				}
				else if(i==2)
				{
					userId = rs.getString("EID");
				}		
				else
				{
					userId = rs.getString("AID");
				}
				
				
                String password = rs.getString("PASS");
				
				if(userId.equals(idTextField.getText()))
				{
					flag=true;
					if(password.equals(passField.getText()))
					{
						if(i==3)
						{
							new Customer(userId).setVisible(true);
						}
						else if(i==2)
						{
							new Employee(userId).setVisible(true);
						}
						else
						{
							new Admin(userId).setVisible(true);
						}
						this.setVisible(false);
						dispose();
						
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Invalid password"); 
					}
				}
				
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid USER ID");
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
	
}