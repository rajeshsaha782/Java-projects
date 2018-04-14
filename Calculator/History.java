import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
public class History extends JFrame implements ActionListener
{
	private JButton ButtonBack,BClear;
	private JScrollPane Scroll;
	private JTextArea LabelTitle;
	String his="",temp="";
	public History()
	{
		super("History");
		this.setLayout(null);
		this.setSize(350,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LabelTitle=new JTextArea();
		LabelTitle.setBackground(Color.white);
		LabelTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		LabelTitle.setEditable(false);
		Scroll = new JScrollPane(LabelTitle);
		Scroll.setBounds(10, 10, 315, 400);
		this.add(Scroll);
		
		ButtonBack = new JButton("Back");
		ButtonBack.setBounds(50, 415, 80, 40);
		ButtonBack.setBackground(Color.red);
		ButtonBack.setForeground(Color.white);
		ButtonBack.addActionListener(this);
		ButtonBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.add(ButtonBack);
		
		BClear = new JButton("Clear History");
		BClear.setBounds(180, 415, 130, 40);
		BClear.setBackground(Color.red);
		BClear.setForeground(Color.white);
		BClear.addActionListener(this);
		BClear.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(BClear);
		
		try
		{
			File file = new File("History.txt");
			file.createNewFile();
			FileReader reader = new FileReader(file);
			BufferedReader bfl = new BufferedReader(reader);
			while ((temp=bfl.readLine())!=null) 
			{
				his=his+temp+"\r\n";
            }
            reader.close();
		}
		catch(Exception e)
		{}
		LabelTitle.setText(his);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		
		if(str.equals("Back"))
		{
			this.setVisible(false);
			new Calculator().setVisible(true);
		}
		if(str.equals("Clear History"))
		{
			try
			{
				FileWriter writer = new FileWriter("History.txt"); 
				his="";
				writer.write(his); 
				writer.flush();
				writer.close();
				
				FileWriter Date = new FileWriter("Date.txt"); 
				Date.write("01/04/96"); 
				Date.flush();
				Date.close();
			}
			catch(Exception e){}
			this.setVisible(false);
			new History().setVisible(true);
		}
	}
}
