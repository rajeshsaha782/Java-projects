import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Delete extends JFrame implements ActionListener
{
	private JLabel shopName1,shopName2,id_Label,user_Label,note;
	private JTextField idTextField;
	private JComboBox combo;
	private JButton back,delete;
	private JPanel panel;
	private String id;
	public Delete(String id)
	{
		super("Delete");
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.id=id;
		
		panel = new JPanel();
		panel.setBackground(Color.gray);
		panel.setBounds(0,0,400,600);
		this.setLayout(null);
		
		
		shopName1 =new JLabel("DELTA FORCE",JLabel.CENTER);
		shopName1.setFont(new Font("Arial Black", Font.BOLD, 42));
		shopName1.setBounds(10, 10, 362, 50);
		shopName1.setBackground(Color.red);
		shopName1.setForeground(Color.white);
		shopName1.setOpaque(true);
		this.add(shopName1);
		
		shopName2=new JLabel("                                         Super Shop");
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
		
		id_Label=new JLabel("Enter Id",JLabel.CENTER);
		id_Label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		id_Label.setBounds(70, 180, 100, 35);
		id_Label.setForeground(Color.white);
		this.add(id_Label);
		
		idTextField = new JTextField("");
		idTextField.setBounds(220, 180, 120, 30);
		idTextField.setFont(new Font("Times New Roman",0, 25));
		this.add(idTextField);
		
		user_Label=new JLabel("Select One",JLabel.CENTER);
		user_Label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		user_Label.setBounds(70, 240, 120, 35);
		user_Label.setForeground(Color.white);
		this.add(user_Label);
		
		String s[] = {"Customer","Employee","Admin","Product"};
		combo = new JComboBox(s);
		combo.setBounds(220, 240, 120, 30);
		combo.setFont(new Font("Times New Roman",0, 20));
		this.add(combo);
		
		delete = new JButton("Delete");
		delete.setBounds(140,350,120,40);
		delete.setFont(new Font("Arial Black", 0, 20));
		delete.addActionListener(this);
		delete.setBackground(Color.red);
		delete.setForeground(Color.white);
		delete.setOpaque(true);
		this.add(delete);
		
		note= new JLabel("",JLabel.CENTER);
		note.setFont(new Font("Times New Roman", Font.BOLD, 15));
		note.setBounds(90, 470, 240, 30);
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
			this.setVisible(false);
			dispose();
			new Admin(id).setVisible(true);
		}
		else if(str.equals("Delete") && !idTextField.getText().equals(""))
		{
			String user = combo.getSelectedItem().toString(),query="";
			boolean p=false;
			if(user.equals("Customer"))
			{
				query = "DELETE from customer where CID="+idTextField.getText()+";";
				String query1= "SELECT * FROM `customer`;";
				p=queryexecute(query1,3);
			}
			else if(user.equals("Employee"))
			{
				query = "DELETE from employee where EID="+idTextField.getText()+";";
				String query1= "SELECT * FROM `employee`;";
				p=queryexecute(query1,2);
			}
			else if(user.equals("Admin"))
			{
				query = "DELETE from adminstrator where AID="+idTextField.getText()+";";
				String query1= "SELECT * FROM `adminstrator`;";
				p=queryexecute(query1,1);
			}
			else if(user.equals("Product"))
			{
				query = "DELETE from product where pID="+idTextField.getText()+";";
				String query1= "SELECT * FROM `product`;";
				p=queryexecute(query1,4);
			} 
			System.out.println("id "+id+"\nidTextField.getText() "+idTextField.getText());
			
			if(p==true)
			{
				if(!idTextField.getText().equals(id))
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_3", "root", "");
						Statement stm = con.createStatement();
						stm.execute(query);
						stm.close();
						con.close();
						note.setVisible(true);
						note.setText("Successfully Deleted");		
					}
					catch(Exception ex)
					{
						System.out.println("Exception : " +ex.getMessage());
					}
				}
				else if(idTextField.getText().equals(id))
				{
					note.setVisible(true);
					note.setText("You can't Delete your Own Account");
				}
			}
			else
			{
				note.setVisible(true);
				note.setText("Id Not Found");
			}
		}
	}
	public boolean queryexecute(String query,int i)
	{
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		String user;
		boolean p=false;
		if(i==1)
		{
			user="AID";
		}	
		else if(i==2)
		{
			user="EID";
		}
		else if(i==3)
		{
			user="CID";
		}
		else
		{
			user="PID";
		}
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_3","root","");
				st = con.createStatement();
				rs = st.executeQuery(query);
					
				while(rs.next())
				{
					if(rs.getString(user).equals(idTextField.getText()))
					{	
						p=true;
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
			return p;
	}
}