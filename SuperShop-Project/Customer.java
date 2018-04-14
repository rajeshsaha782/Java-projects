import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Customer extends JFrame implements ActionListener
{
	private JLabel shopName1,shopName2;
	private JTextArea showProduct;
	private JTextField searchProduct;
	private JButton search,back,edit,logOut;
	private JScrollPane Scroll;
	private JPanel panel;
	private String cId;

	public Customer(String id)
	{
		super("Customer Home");
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cId=id;
		
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
		
		searchProduct = new JTextField("");
		searchProduct.setBounds(10, 130, 250, 35);
		searchProduct.setFont(new Font("Times New Roman",0, 20));
		this.add(searchProduct);
		
		search = new JButton("Search");
		search.setBounds(270,130,100,35);
		search.setFont(new Font("Times New Roman", Font.BOLD, 20));
		search.setBackground(Color.blue);
		search.setForeground(Color.white);
		search.addActionListener(this);
		this.add(search);
		
		
		showProduct=new JTextArea();
		//showProduct.setBackground(Color.white);
		showProduct.setFont(new Font("Times New Roman", Font.BOLD, 15));
		showProduct.setEditable(false);
		showProduct.setBackground(Color.gray);
		showProduct.setForeground(Color.white);
		Scroll = new JScrollPane(showProduct);
		Scroll.setBounds(0, 180,385, 380);
		this.add(Scroll);
		
		showPro();
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
		else if(str.equals("Edit"))
		{
			this.setVisible(false);
			dispose();
			new Edit(cId,3).setVisible(true);
		}
		else if(str.equals("LogOut"))
		{
			this.setVisible(false);
			dispose();
			new Login().setVisible(true);
		}
		else if(str.equals("Search") && !searchProduct.getText().equals(""))
		{
			String query = "SELECT `PNAME`,`COMPANY_NAME`,`PRICE` FROM `PRODUCT`;";
			Connection con=null;
			Statement st = null;
			ResultSet rs = null;
			System.out.println(query);
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_3","root","");
				st = con.createStatement();
				rs = st.executeQuery(query);
				String s="PNAME"+"           "+"COMPANY_NAME"+"         "+"PRICE"+"\r\n";
				while(rs.next())
				{
					if(rs.getString("PNAME").equals(searchProduct.getText()))
					{
						s=s+rs.getString("PNAME")+"                "+rs.getString("COMPANY_NAME")+"                       "+rs.getString("PRICE")+"\r\n";
					}
				}
				if(s.equals("PNAME"+"           "+"COMPANY_NAME"+"         "+"PRICE"+"\r\n"))
				{
					JOptionPane.showMessageDialog(this,"Product Not Found");
				}
				else
				{
					JOptionPane.showMessageDialog(this,s);
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
	public void showPro()
	{
		String query = "SELECT `PNAME`,`COMPANY_NAME`,`PRICE` FROM `PRODUCT`;";
		Connection con=null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_3","root","");
			st = con.createStatement();
			rs = st.executeQuery(query);
			String s="PNAME"+"           "+"COMPANY_NAME"+"           "+"PRICE"+"\r\n";
			while(rs.next())
			{
				s=s+rs.getString("PNAME")+"                      "+rs.getString("COMPANY_NAME")+"                              "+rs.getString("PRICE")+"\r\n";
			}
			showProduct.setText(s);
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