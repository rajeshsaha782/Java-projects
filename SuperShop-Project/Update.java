import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Update extends JFrame implements ActionListener
{
	private JLabel shopName1,shopName2;
	private JButton back,product,admin,employee,buttonSubmit,searchSubmit;
	private JLabel adminLabel,aIdLabel,aPassLabel,aNameLabel,select,idSearchLabel,note;
	private JLabel productLabel,pIdLabel,pNameLabel,comNameLabel,priceLabel,inventoryLabel;
	private JLabel employeeLabel,eIdLabel,ePassLabel,eNameLabel,eSalaryLabel,eDesignationLabel;
	private JTextField productText,pIdText,pNameText,comNameText,priceText,inventoryText,idSearchText;
	private JTextField employeeText,eIdText,ePassText,eNameText,eSalaryText,eDesignationText;
	private JTextField adminText,aPassText,aNameText,aIdText;
	private int identifier;
	private String query1;
	//private JButton buttonBack, buttonLogout, buttonSubmit,product,employee,admin;
	private JPanel panel;
	private String userId;
	private String id;
	public Update(String id)
	{
		super("Update");
		
		this.id=id;
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
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
		
		
		product = new JButton("Product");
		product.setBounds(120,150,120,30);
		product.setFont(new Font("Times New Roman", 0, 20));
		product.addActionListener(this);
		this.add(product);
		
		employee = new JButton("Employee");
		employee.setBounds(120,220,120,30);
		employee.setFont(new Font("Times New Roman", 0, 20));
		employee.addActionListener(this);
		this.add(employee);
		
		admin = new JButton("Admin");
		admin.setBounds(120,290,120,30);
		admin.setFont(new Font("Times New Roman", 0, 20));
		admin.addActionListener(this);
		this.add(admin);
		
		productLabel = new JLabel("Product");
		productLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		productLabel.setVisible(false);
		productLabel.setBounds(10, 340, 100, 20);
		this.add(productLabel);
		
		pIdLabel = new JLabel("ID",JLabel.CENTER);
		pIdLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		pIdLabel.setVisible(false);
		pIdLabel.setBounds(10, 380, 80, 20);
		this.add(pIdLabel);
		
		pNameLabel = new JLabel("Name",JLabel.CENTER);
		pNameLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		pNameLabel.setVisible(false);
		pNameLabel.setBounds(110, 380, 100, 20);
		this.add(pNameLabel);
		
		comNameLabel = new JLabel("Company",JLabel.CENTER);
		comNameLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		comNameLabel.setVisible(false);
		comNameLabel.setBounds(240, 380, 100, 20);
		this.add(comNameLabel);
		
		pIdText = new JTextField();
		pIdText.setFont(new Font("Times New Roman",Font.BOLD, 15));
		pIdText.setVisible(false);
		pIdText.setEditable(false);
		pIdText.setBounds(10, 410, 80, 20);
		this.add(pIdText);
		
		pNameText = new JTextField();
		pNameText.setFont(new Font("Times New Roman",0, 15));
		pNameText.setVisible(false);
		pNameText.setBounds(110, 410, 100, 20);
		this.add(pNameText);
		
		comNameText = new JTextField();
		comNameText.setFont(new Font("Times New Roman",0, 15));
		comNameText.setVisible(false);
		comNameText.setBounds(245, 410, 100, 20);
		this.add(comNameText);
		
		priceLabel = new JLabel("Price",JLabel.CENTER);
		priceLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		priceLabel.setVisible(false);
		priceLabel.setBounds(10, 460, 100, 20);
		this.add(priceLabel);
		
		inventoryLabel = new JLabel("No of Product",JLabel.CENTER);
		inventoryLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		inventoryLabel.setVisible(false);
		inventoryLabel.setBounds(160, 460, 130, 20);
		this.add(inventoryLabel);
		
		priceText = new JTextField();
		priceText.setFont(new Font("Times New Roman",0, 15));
		priceText.setVisible(false);
		priceText.setBounds(10, 490, 100, 20);
		this.add(priceText);
		
		inventoryText = new JTextField();
		inventoryText.setFont(new Font("Times New Roman",0, 15));
		inventoryText.setVisible(false);
		inventoryText.setBounds(160, 490, 120, 20);
		this.add(inventoryText);
		
		
		employeeLabel = new JLabel("Employee");
		employeeLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		employeeLabel.setVisible(false);
		employeeLabel.setBounds(10, 340, 100, 20);
		this.add(employeeLabel);
		
		eIdLabel = new JLabel("ID",JLabel.CENTER);
		eIdLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		eIdLabel.setVisible(false);
		eIdLabel.setBounds(10, 380, 80, 20);
		this.add(eIdLabel);
		
		ePassLabel = new JLabel("PassWord",JLabel.CENTER);
		ePassLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		ePassLabel.setVisible(false);
		ePassLabel.setBounds(110, 380, 100, 20);
		this.add(ePassLabel);
		
		eNameLabel = new JLabel("Name",JLabel.CENTER);
		eNameLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		eNameLabel.setVisible(false);
		eNameLabel.setBounds(240, 380, 100, 20);
		this.add(eNameLabel);
		
		eIdText = new JTextField();
		eIdText.setFont(new Font("Times New Roman",0, 15));
		eIdText.setEditable(false);
		eIdText.setVisible(false);
		eIdText.setBounds(10, 410, 80, 20);
		this.add(eIdText);
		
		ePassText = new JTextField();
		ePassText.setFont(new Font("Times New Roman",0, 15));
		ePassText.setVisible(false);
		ePassText.setBounds(110, 410, 100, 20);
		this.add(ePassText);
		
		eNameText = new JTextField();
		eNameText.setFont(new Font("Times New Roman",0, 15));
		eNameText.setVisible(false);
		eNameText.setBounds(245, 410, 100, 20);
		this.add(eNameText);
		
		eSalaryLabel = new JLabel("Salary",JLabel.CENTER);
		eSalaryLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		eSalaryLabel.setVisible(false);
		eSalaryLabel.setBounds(10, 460, 100, 20);
		this.add(eSalaryLabel);
		
		eDesignationLabel = new JLabel("Designation",JLabel.CENTER);
		eDesignationLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		eDesignationLabel.setVisible(false);
		eDesignationLabel.setBounds(160, 460, 130, 20);
		this.add(eDesignationLabel);
		
		eSalaryText = new JTextField();
		eSalaryText.setFont(new Font("Times New Roman",0, 15));
		eSalaryText.setVisible(false);
		eSalaryText.setBounds(10, 490, 100, 20);
		this.add(eSalaryText);
		
		eDesignationText = new JTextField();
		eDesignationText.setFont(new Font("Times New Roman",0, 15));
		eDesignationText.setVisible(false);
		eDesignationText.setBounds(160, 490, 120, 20);
		this.add(eDesignationText);
		
		
		
		adminLabel = new JLabel("Admin");
		adminLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		adminLabel.setVisible(false);
		adminLabel.setBounds(10, 340, 100, 20);
		this.add(adminLabel);
		
		aIdLabel = new JLabel("ID",JLabel.CENTER);
		aIdLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		aIdLabel.setVisible(false);
		aIdLabel.setBounds(10, 380, 80, 20);
		this.add(aIdLabel);
		
		aPassLabel = new JLabel("PassWord",JLabel.CENTER);
		aPassLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		aPassLabel.setVisible(false);
		aPassLabel.setBounds(110, 380, 100, 20);
		this.add(aPassLabel);
		
		aNameLabel = new JLabel("Name",JLabel.CENTER);
		aNameLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		aNameLabel.setVisible(false);
		aNameLabel.setBounds(240, 380, 100, 20);
		this.add(aNameLabel);
		
		aIdText = new JTextField();
		aIdText.setFont(new Font("Times New Roman",0, 15));
		aIdText.setEditable(false);
		aIdText.setVisible(false);
		aIdText.setBounds(10, 410, 80, 20);
		this.add(aIdText);
		
		aPassText = new JTextField();
		aPassText.setFont(new Font("Times New Roman",0, 15));
		aPassText.setVisible(false);
		aPassText.setBounds(110, 410, 100, 20);
		this.add(aPassText);
		
		aNameText = new JTextField();
		aNameText.setFont(new Font("Times New Roman",0, 15));
		aNameText.setVisible(false);
		aNameText.setBounds(245, 410, 100, 20);
		this.add(aNameText);
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setBounds(120,520,120,30);
		buttonSubmit.setVisible(false);
		buttonSubmit.setFont(new Font("Times New Roman", 0, 20));
		buttonSubmit.addActionListener(this);
		this.add(buttonSubmit);
		
		
		
		idSearchLabel = new JLabel("Enter Id",JLabel.CENTER);
		idSearchLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		idSearchLabel.setVisible(false);
		idSearchLabel.setBounds(120, 390, 100, 20);
		this.add(idSearchLabel);
		
		idSearchText = new JTextField();
		idSearchText.setFont(new Font("Times New Roman",0, 15));
		idSearchText.setVisible(false);
		idSearchText.setBounds(120, 430, 120, 25);
		this.add(idSearchText);
		
		searchSubmit = new JButton("Search");
		searchSubmit.setBounds(120,480,120,30);
		searchSubmit.setVisible(false);
		searchSubmit.setFont(new Font("Times New Roman", 0, 20));
		searchSubmit.addActionListener(this);
		this.add(searchSubmit);
		
		note = new JLabel("",JLabel.CENTER);
		note.setFont(new Font("Times New Roman", Font.BOLD, 15));
		note.setBounds(80, 530, 200, 20);
		note.setVisible(false);
		note.setBackground(Color.red);
		note.setForeground(Color.white);
		note.setOpaque(true);
		this.add(note);
		
		this.add(panel);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("Back"))
		{
			this.setVisible(false);
			dispose();
			new Admin(id).setVisible(true);
		}
		else if(s.equals("Product"))
		{
			buttonSubmit.setVisible(false);
			
			searchSubmit.setVisible(true);
			idSearchLabel.setVisible(true);
			idSearchText.setVisible(true);
			
			note.setVisible(false);
			
			identifier=1;
			product.setBackground(Color.cyan);
			employee.setBackground(new JButton().getBackground());
			admin.setBackground(new JButton().getBackground());
			
			productLabel.setVisible(false);
			pNameLabel.setVisible(false);
			pIdLabel.setVisible(false);
			comNameLabel.setVisible(false);
			pNameText.setVisible(false);
			pIdText.setVisible(false);
			comNameText.setVisible(false);
			priceLabel.setVisible(false);
			inventoryLabel.setVisible(false);
			priceText.setVisible(false);
			inventoryText.setVisible(false);
			
			employeeLabel.setVisible(false);
			eIdLabel.setVisible(false);
			ePassLabel.setVisible(false);
			eNameLabel.setVisible(false);
			eIdText.setVisible(false);
			ePassText.setVisible(false);
			eNameText.setVisible(false);
			eSalaryLabel.setVisible(false);
			eDesignationLabel.setVisible(false);
			eSalaryText.setVisible(false);
			eDesignationText.setVisible(false);
			
			adminLabel.setVisible(false);
			aIdLabel.setVisible(false);
			aPassLabel.setVisible(false);
			aNameLabel.setVisible(false);
			aIdText.setVisible(false);
			aPassText.setVisible(false);
			aNameText.setVisible(false);
			
		}
		
		else if(s.equals("Employee"))
		{
			buttonSubmit.setVisible(false);
			
			searchSubmit.setVisible(true);
			idSearchLabel.setVisible(true);
			idSearchText.setVisible(true);
			
			identifier=2;
			employee.setBackground(Color.cyan);
			product.setBackground(new JButton().getBackground());
			admin.setBackground(new JButton().getBackground());
			
			employeeLabel.setVisible(false);
			eIdLabel.setVisible(false);
			ePassLabel.setVisible(false);
			eNameLabel.setVisible(false);
			eIdText.setVisible(false);
			ePassText.setVisible(false);
			eNameText.setVisible(false);
			eSalaryLabel.setVisible(false);
			eDesignationLabel.setVisible(false);
			eSalaryText.setVisible(false);
			eDesignationText.setVisible(false);
			
			
			note.setVisible(false);
			
			
			productLabel.setVisible(false);
			pNameLabel.setVisible(false);
			pIdLabel.setVisible(false);
			comNameLabel.setVisible(false);
			pNameText.setVisible(false);
			pIdText.setVisible(false);
			comNameText.setVisible(false);
			priceLabel.setVisible(false);
			inventoryLabel.setVisible(false);
			priceText.setVisible(false);
			inventoryText.setVisible(false);
			
			adminLabel.setVisible(false);
			aIdLabel.setVisible(false);
			aPassLabel.setVisible(false);
			aNameLabel.setVisible(false);
			aIdText.setVisible(false);
			aPassText.setVisible(false);
			aNameText.setVisible(false);
			
			
		}
		
		else if(s.equals("Admin"))
		{
			buttonSubmit.setVisible(false);
			
			searchSubmit.setVisible(true);
			idSearchLabel.setVisible(true);
			idSearchText.setVisible(true);
			
			identifier=3;
			
			adminLabel.setVisible(false);
			aIdLabel.setVisible(false);
			aPassLabel.setVisible(false);
			aNameLabel.setVisible(false);
			aIdText.setVisible(false);
			aPassText.setVisible(false);
			aNameText.setVisible(false);
			
			note.setVisible(false);
			admin.setBackground(Color.cyan);
			employee.setBackground(new JButton().getBackground());
			product.setBackground(new JButton().getBackground());
			
			employeeLabel.setVisible(false);
			eIdLabel.setVisible(false);
			ePassLabel.setVisible(false);
			eNameLabel.setVisible(false);
			eIdText.setVisible(false);
			ePassText.setVisible(false);
			eNameText.setVisible(false);
			eSalaryLabel.setVisible(false);
			eDesignationLabel.setVisible(false);
			eSalaryText.setVisible(false);
			eDesignationText.setVisible(false);
			
			productLabel.setVisible(false);
			pNameLabel.setVisible(false);
			pIdLabel.setVisible(false);
			comNameLabel.setVisible(false);
			pNameText.setVisible(false);
			pIdText.setVisible(false);
			comNameText.setVisible(false);
			priceLabel.setVisible(false);
			inventoryLabel.setVisible(false);
			priceText.setVisible(false);
			inventoryText.setVisible(false);
		}
		
		else if(s.equals("Search"))
		{
			String query="";

			if(identifier==1)
			{
				query = "SELECT `PID` FROM `PRODUCT`;"; 
			}
			else if(identifier==2)
			{
				query = "SELECT `EID` FROM `Employee`;"; 
			}		
			else
			{
				query = "SELECT `AID` FROM `Adminstrator`;"; 
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
					
					if(identifier==1)
					{
						if(rs.getString("PID").equals(idSearchText.getText()))
						{

							searchSubmit.setVisible(false);
							idSearchLabel.setVisible(false);
							idSearchText.setVisible(false);
							
							note.setVisible(false);
							
							pIdText.setText(idSearchText.getText());
		
							buttonSubmit.setVisible(true);
							productLabel.setVisible(true);
							pNameLabel.setVisible(true);
							pIdLabel.setVisible(true);
							comNameLabel.setVisible(true);
							pNameText.setVisible(true);
							pIdText.setVisible(true);
							comNameText.setVisible(true);
							priceLabel.setVisible(true);
							inventoryLabel.setVisible(true);
							priceText.setVisible(true);
							inventoryText.setVisible(true);
							System.out.println(pNameText.getText());
							
							break;
	
						}
						else
						{
							note.setVisible(true);
							note.setText("Product Not Found");
						}
					}
					else if(identifier==2)
					{
						if(rs.getString("EID").equals(idSearchText.getText()))
						{
							System.out.println("Found");
							searchSubmit.setVisible(false);
							idSearchLabel.setVisible(false);
							idSearchText.setVisible(false);
							
							note.setVisible(false);
							
							eIdText.setText(idSearchText.getText());
							
							employeeLabel.setVisible(true);
							eIdLabel.setVisible(true);
							ePassLabel.setVisible(true);
							eNameLabel.setVisible(true);
							eIdText.setVisible(true);
							ePassText.setVisible(true);
							eNameText.setVisible(true);
							eSalaryLabel.setVisible(true);
							eDesignationLabel.setVisible(true);
							eSalaryText.setVisible(true);
							eDesignationText.setVisible(true);
							
							buttonSubmit.setVisible(true);
							break;
						}
						else
						{		
							
							note.setVisible(true);
							note.setText("Employee Not Found");
						}
					}		
					else
					{
						if(rs.getString("AID").equals(idSearchText.getText()))
						{
							
							System.out.println("Found");
							searchSubmit.setVisible(false);
							idSearchLabel.setVisible(false);
							idSearchText.setVisible(false);
							
							note.setVisible(false);
							
							aIdText.setText(idSearchText.getText());
							
							buttonSubmit.setVisible(true);
							adminLabel.setVisible(true);
							aIdLabel.setVisible(true);
							aPassLabel.setVisible(true);
							aNameLabel.setVisible(true);
							aIdText.setVisible(true);
							aPassText.setVisible(true);
							aNameText.setVisible(true);
							break;
							
							//buttonSubmit.setVisible(true);
						}
						else
						{
							note.setVisible(true);
							note.setText("Admin Not Found");
						}
					}
				}
			}
					
			catch(Exception ex){}	
				//String password = rs.getString("PASS");
				
				
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
			else if(s.equals("Submit"))
			{
				if(identifier==1)
				{
					if(!pNameText.getText().equals(""))
					{
						query1 = "UPDATE product SET PNAME="+"'"+pNameText.getText()+"'"+" where PID="+"'"+idSearchText.getText()+"';";
						queryExecute(query1);
						
					}
						
					if(!comNameText.getText().equals(""))
					{
						query1 = "UPDATE product SET COMPANY_NAME="+"'"+comNameText.getText()+"'"+" where PID="+"'"+idSearchText.getText()+"';";
						queryExecute(query1);
					
					}
					if(!priceText.getText().equals(""))
					{
						query1 = "UPDATE product SET PRICE="+"'"+priceText.getText()+"'"+" where PID="+"'"+idSearchText.getText()+"';";
						queryExecute(query1);
					}
					
					if(!inventoryText.getText().equals(""))
					{
						query1 = "UPDATE product SET INVENTORY="+"'"+inventoryText.getText()+"'"+" where PID="+"'"+idSearchText.getText()+"';";
						queryExecute(query1);
					}
					JOptionPane.showMessageDialog(this,"Successfully Updated");
				}
					
				else if(identifier==2)
				{	
					if(!eDesignationText.getText().equals(""))
					{
						query1 = "UPDATE employee SET DESIGNATION="+"'"+eDesignationText.getText()+"'"+" where EID="+"'"+idSearchText.getText()+"';";
						queryExecute(query1);
					
					}
					if(!ePassText.getText().equals(""))
					{
						query1 = "UPDATE employee SET PASS="+"'"+ePassText.getText()+"'"+" where EID="+"'"+idSearchText.getText()+"';";
						queryExecute(query1);
					}
						
					if(!eNameText.getText().equals(""))
					{
						query1 = "UPDATE employee SET NAME="+"'"+eNameText.getText()+"'"+" where EID="+"'"+idSearchText.getText()+"';";
						queryExecute(query1);
					
					}
					if(!eSalaryText.getText().equals(""))
					{
						query1 = "UPDATE employee SET SALARY="+"'"+eSalaryText.getText()+"'"+" where EID="+"'"+idSearchText.getText()+"';";
						queryExecute(query1);
					}
					JOptionPane.showMessageDialog(this,"Successfully Updated");
				}
					
				else if(identifier==3)
				{	
					if(!aPassText.getText().equals(""))
					{
						query1 = "UPDATE ADMINSTRATOR SET PASS="+"'"+aPassText.getText()+"'"+" where AID="+"'"+idSearchText.getText()+"';";
						queryExecute(query1);
					
					}
					if(!aNameText.getText().equals(""))
					{
						query1 = "UPDATE ADMINSTRATOR SET PASS="+"'"+aNameText.getText()+"'"+" where AID="+"'"+idSearchText.getText()+"';";
						queryExecute(query1);
					}
					JOptionPane.showMessageDialog(this,"Successfully Updated");	
				}	
			}
	}
	
	private void queryExecute(String query1)
	{
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		System.out.println(query1);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_3","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			//rs = st.executeQuery(query1);
			System.out.println("results received");
			st.executeUpdate(query1);
			//query = "UPDATE product SET NAME="+"'"+pNameText.getText()+"'"+" where PID="+"'"+idSearchText.getText()+"';";
		}
		catch(Exception e){}
	}
}