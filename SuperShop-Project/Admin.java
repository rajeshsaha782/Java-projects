import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener
{
	private JLabel shopName1,shopName2;
	private JButton back,edit,viewProduct,add,update,delete,logOut;
	private JPanel panel;
	private String aId;
	public Admin(String id)
	{
		super("Admin Home");
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		aId=id;
		
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
		viewProduct.setBounds(100,170,180,40);
		viewProduct.setFont(new Font("Times New Roman", 0, 20));
		viewProduct.addActionListener(this);
		this.add(viewProduct);
		
		add = new JButton("Add");
		add.setBounds(100,240,180,40);
		add.setFont(new Font("Times New Roman", 0, 20));
		add.addActionListener(this);
		this.add(add);
		
		update = new JButton("Update");
		update.setBounds(100,310,180,40);
		update.setFont(new Font("Times New Roman", 0, 20));
		update.addActionListener(this);
		this.add(update);
		
		delete = new JButton("Delete");
		delete.setBounds(100,380,180,40);
		delete.setFont(new Font("Times New Roman", 0, 20));
		delete.addActionListener(this);
		this.add(delete);
		
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
			new ViewProduct(aId,1).setVisible(true);
		}
		else if(str.equals("Edit"))
		{
			this.setVisible(false);
			dispose();
			new Edit(aId,1).setVisible(true);
		}
		else if(str.equals("LogOut"))
		{
			this.setVisible(false);
			dispose();
			new Login().setVisible(true);
		}
		else if(str.equals("Add"))
		{
			this.setVisible(false);
			dispose();
			new Add(aId).setVisible(true);
		}
		else if(str.equals("Delete"))
		{
			this.setVisible(false);
			dispose();
			new Delete(aId).setVisible(true);
		}
		else if(str.equals("Update"))
		{
			this.setVisible(false);
			dispose();
			new Update(aId).setVisible(true);
		}
	}
}
	