import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ViewProduct extends JFrame implements ActionListener
{
	private JLabel shopName1,shopName2;
	private JTextArea showProduct;
	private JTextField searchProduct;
	private JButton search,back,edit;
	private JScrollPane Scroll;
	private JPanel panel;
	private int identifier;
	private String id;
	public ViewProduct(String id,int i)
	{
		super("ViewProduct Home");
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		identifier=i;
		this.id=id;
		
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
		//back.setBackground(Color.blue);
		//back.setForeground(Color.white);
		back.addActionListener(this);
		this.add(back);
		
		showProduct=new JTextArea();
		//showProduct.setBackground(Color.white);
		showProduct.setFont(new Font("Times New Roman", Font.BOLD, 15));
		showProduct.setEditable(false);
		showProduct.setBackground(Color.gray);
		showProduct.setForeground(Color.white);
		Scroll = new JScrollPane(showProduct);
		Scroll.setBounds(0, 170,385, 390);
		this.add(Scroll);
		
		showPro();
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
			else
			{
				this.setVisible(false);
				dispose();
				new Employee(id).setVisible(true);
			}
			
		}
		
	}
	public void showPro()
	{
		String query = "SELECT `PID`,`PNAME`,`COMPANY_NAME`,`PRICE`,`INVENTORY` FROM `PRODUCT`;";
		Connection con=null;
        Statement st = null;
		ResultSet rs = null;
		
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_3","root","");
			st = con.createStatement();
			rs = st.executeQuery(query);
			String s="PID"+"      "+"PNAME"+"      "+"COMPANY_NAME"+"     "+"PRICE"+"  "+"NOP"+"\r\n";
			while(rs.next())
			{
				s=s+rs.getString("PID")+"        "+rs.getString("PNAME")+"               "+rs.getString("COMPANY_NAME")+"                     "+rs.getString("PRICE")+"          "+rs.getString("INVENTORY")+"\r\n";
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