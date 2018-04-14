import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import static java.lang.Math.*;
import java.io.*;
import java.util.*;
import java.text.*;
public class Calculator extends JFrame implements ActionListener, MouseListener 
{
	String number="",operation="",topscreen="",all="",his="";
	int DOTCOUNTER=0,operation_counter=0,number_counter=0,sqrt_counter=0,plus_counter=0,minus_counter=0,mult_counter=0,div_counter=0,equl_counter=0,word=0,MR_counter=0;
	double x=0,y=0,memory=0;
	boolean op=false;
	JLabel screen=new JLabel("0",JLabel.RIGHT);
	JLabel toplabel=new JLabel("",JLabel.RIGHT);
	JLabel memory_level=new JLabel("",JLabel.LEFT);
	private JButton B1,B2,B3,B4,B5,B6,B7,B8,B9,B0,BDOT,BEQL,BPLUS,BMINUS,BMULT,BDIV,BACKSPACE,SQRT,AC,CE,HISTORY,PLUSMINUS,MPLUS,MMINUS,MR,MC,CH;
	private JPanel PanelForm1;
	DateFormat df = new SimpleDateFormat("dd/MM/yy");
	Date dateobj = new Date();
	public Calculator()
	{
		super("Rajesh's CALCULATOR");
		this.setSize(325,510);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String temp="";
		try
		{
			//File file = new File("History.txt");
			//file.createNewFile();
			FileReader Hreader = new FileReader("History.txt");
			BufferedReader bfl = new BufferedReader(Hreader);
			while ((temp=bfl.readLine())!=null) 
				{
					his=his+temp+"\r\n";
				}
				Hreader.close();
		}
		catch(Exception e)
		{}
		
		
		try
		{
			FileReader Mreader = new FileReader("Memory.txt");
			BufferedReader bfl1 = new BufferedReader(Mreader);
			while ((temp=bfl1.readLine())!=null) 
				{
					memory=Double.parseDouble(temp);
				}
				Mreader.close();
		}
		catch(Exception e)
		{}
		
		if(memory==0)
		{
			memory_level.setText("");
		}
		else
		{
			memory_level.setText("M");
		}
		
		PanelForm1 = new JPanel();
		PanelForm1.setLayout(null);
		
		toplabel.setOpaque(true);
		toplabel.setBounds(10, 10, 290, 30);
		toplabel.setForeground(Color.white);
		toplabel.setBackground(Color.gray);
		toplabel.setFont(new Font("",0, 15));
		PanelForm1.add(toplabel);
		
		screen.setOpaque(true);
		screen.setBounds(20, 40, 280, 60);
		screen.setForeground(Color.white);
        screen.setBackground(Color.gray);
		screen.setFont(new Font("Times New Roman", Font.BOLD, 39));
		PanelForm1.add(screen);
		
		memory_level.setOpaque(true);
		memory_level.setBounds(10, 40, 10, 60);
		memory_level.setForeground(Color.white);
        memory_level.setBackground(Color.gray);
		memory_level.setFont(new Font("",Font.BOLD, 10));
		PanelForm1.add(memory_level);
	
		B1 = new JButton("1");
		B1.setBounds(10, 350, 50, 50);
		B1.addActionListener(this);
		B1.addMouseListener(this);
		B1.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(B1);
		
		B2 = new JButton("2");
		B2.setBounds(70, 350, 50, 50);
		B2.addActionListener(this);
		B2.addMouseListener(this);
		B2.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(B2);
		
		B3 = new JButton("3");
		B3.setBounds(130, 350, 50, 50);
		B3.addActionListener(this);
		B3.addMouseListener(this);
		B3.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(B3);
		
		B4 = new JButton("4");
		B4.setBounds(10, 290, 50, 50);
		B4.addActionListener(this);
		B4.addMouseListener(this);
		B4.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(B4);
		
		B5 = new JButton("5");
		B5.setBounds(70, 290, 50, 50);
		B5.addActionListener(this);
		B5.addMouseListener(this);
		B5.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(B5);
		
		B6 = new JButton("6");
		B6.setBounds(130, 290, 50, 50);
		B6.addActionListener(this);
		B6.addMouseListener(this);
		B6.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(B6);
		
		B7 = new JButton("7");
		B7.setBounds(10, 230, 50, 50);
		B7.addActionListener(this);
		B7.addMouseListener(this);
		B7.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(B7);
		
		B8 = new JButton("8");
		B8.setBounds(70, 230, 50, 50);
		B8.addActionListener(this);
		B8.addMouseListener(this);
		B8.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(B8);
		
		B9 = new JButton("9");
		B9.setBounds(130, 230, 50, 50);
		B9.addActionListener(this);
		B9.addMouseListener(this);
		B9.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(B9);
		
		B0 = new JButton("0");
		B0.setBounds(10, 410, 110, 50);
		B0.addActionListener(this);
		B0.addMouseListener(this);
		B0.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(B0);
		
		BDOT = new JButton(".");
		BDOT.setBounds(130, 410, 50, 50);
		BDOT.addActionListener(this);
		BDOT.addMouseListener(this);
		BDOT.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(BDOT);
		
		BPLUS = new JButton("+");
		BPLUS.setBounds(190, 410, 50, 50);
		BPLUS.addActionListener(this);
		BPLUS.addMouseListener(this);
		BPLUS.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(BPLUS);
		
		BMINUS = new JButton("-");
		BMINUS.setBounds(190, 350, 50, 50);
		BMINUS.addActionListener(this);
		BMINUS.addMouseListener(this);
		BMINUS.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(BMINUS);
		
		BMULT = new JButton("*");
		BMULT.setBounds(190, 290, 50, 50);
		BMULT.addActionListener(this);
		BMULT.addMouseListener(this);
		BMULT.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(BMULT);
		
		BDIV = new JButton("/");
		BDIV.setBounds(190, 230, 50, 50);
		BDIV.addActionListener(this);
		BDIV.addMouseListener(this);
		BDIV.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(BDIV);
		
		BEQL = new JButton("=");
		BEQL.setBounds(250, 350, 50, 110);
		BEQL.addActionListener(this);
		BEQL.addMouseListener(this);
		BEQL.setFont(new Font("", Font.BOLD, 20));
		PanelForm1.add(BEQL);
		
		BACKSPACE = new JButton("<-");
		BACKSPACE.setBounds(10, 170, 50, 50);
		BACKSPACE.addActionListener(this);
		BACKSPACE.addMouseListener(this);
		BACKSPACE.setFont(new Font("", Font.BOLD, 15));
		PanelForm1.add(BACKSPACE);
		
		SQRT = new JButton("sqrt");
		SQRT.setBounds(70, 170, 60, 50);
		SQRT.addActionListener(this);
		SQRT.addMouseListener(this);
		PanelForm1.add(SQRT);
		
		AC = new JButton("AC");
		AC.setBounds(250, 170, 50, 50);
		AC.addActionListener(this);
		AC.addMouseListener(this);
		AC.setForeground(Color.white);
		AC.setFont(new Font("", Font.BOLD, 12));
		AC.setBackground(Color.red);
		PanelForm1.add(AC);
		
		CE = new JButton("CE");
		CE.setBounds(250, 230, 50, 50);
		CE.addActionListener(this);
		CE.addMouseListener(this);
		CE.setForeground(Color.white);
		CE.setFont(new Font("", Font.BOLD, 12));
		CE.setBackground(Color.red);
		PanelForm1.add(CE);
		
		MPLUS = new JButton("M+");
		MPLUS.setBounds(10, 110, 50, 50);
		MPLUS.addActionListener(this);
		MPLUS.addMouseListener(this);
		MPLUS.setFont(new Font("", Font.BOLD, 11));
		PanelForm1.add(MPLUS);
		
		MMINUS = new JButton("M-");
		MMINUS.setBounds(70, 110, 50, 50);
		MMINUS.addActionListener(this);
		MMINUS.addMouseListener(this);
		MMINUS.setFont(new Font("", Font.BOLD, 11));
		PanelForm1.add(MMINUS);
		
		MR = new JButton("MR");
		MR.setBounds(130, 110, 50, 50);
		MR.addActionListener(this);
		MR.addMouseListener(this);
		MR.setFont(new Font("", Font.BOLD, 10));
		PanelForm1.add(MR);
		
		MC = new JButton("MC");
		MC.setBounds(190, 110, 50, 50);
		MC.addActionListener(this);
		MC.addMouseListener(this);
		MC.setFont(new Font("", Font.BOLD, 10));
		PanelForm1.add(MC);
		
		CH = new JButton("CH");
		CH.setBounds(250, 110, 50, 50);
		CH.addActionListener(this);
		CH.addMouseListener(this);
		CH.setFont(new Font("", Font.BOLD, 12));
		PanelForm1.add(CH);
		
		HISTORY = new JButton("HISTORY");
		HISTORY.setBounds(140, 170, 100, 50);
		HISTORY.addActionListener(this);
		HISTORY.addMouseListener(this);
		//HISTORY.setFont(new Font("", Font.BOLD, 13));
		PanelForm1.add(HISTORY);
		
		PLUSMINUS = new JButton("+/-");
		PLUSMINUS.setBounds(250, 290, 50, 50);
		PLUSMINUS.addActionListener(this);
		PLUSMINUS.addMouseListener(this);
		PLUSMINUS.setFont(new Font("", Font.BOLD, 13));
		PanelForm1.add(PLUSMINUS);
		
		this.add(PanelForm1);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		
		if(str.equals("HISTORY"))
		{
			//System.out.println("Hisory="+his);
			//JOptionPane.showMessageDialog( this, his, "HISTORY", JOptionPane.NO_OPTION);
			new History().setVisible(true);
			this.setVisible(false);
		}
		
		else if(str.equals("CH"))
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
			catch(Exception e)
			{}
		}
		
		else if(str.equals("M+"))
		{
			double n=0;
			String m=screen.getText();
			n=Double.parseDouble(m);
			memory=memory+n;number="";
			set_Memory(Double.toString(memory));
			if(memory==0)
			{
				memory_level.setText("");
			}
			else
			{
				memory_level.setText("M");
			}
			
		}
		
		else if(str.equals("M-"))
		{
			double n=0;
			String m=screen.getText();
			m=Dot_fix(m);
			n=Double.parseDouble(m);
			memory=memory-n;number="";
			set_Memory(Double.toString(memory));
			if(memory==0)
			{
				memory_level.setText("");
			}
			else
			{
				memory_level.setText("M");
			}
		}
		
		else if(str.equals("MR"))
		{
			MR_counter=1;
			
			String m=Double.toString(memory);
			m=Dot_fix(m);
			if(m.length()>13)
			{
				screen.setFont(new Font("Times New Roman", Font.BOLD, 28));
			}
			screen.setText(m);number=m;
			
			plus_counter=0;
			minus_counter=0;
			mult_counter=0;
			div_counter=0;equl_counter=0;
			operation_counter=0;
		}
		else if(str.equals("MC"))
		{
			memory=0;
			set_Memory(Double.toString(memory));
			memory_level.setText("");
		}
		
		else if(str.equals("<-")&& !number.equals(""))
		{
			number=number.substring(0, number.length() - 1);
			screen.setText(number);
			number_counter--;DOTCOUNTER=0;
			if(number.length()==0)
			{
				screen.setText("0");
			}
		}
		
		
		else if(str.equals("+/-")&& !number.equals(""))
		{
			String r;
			if(number.charAt(0)=='-')
			{
				r=number.substring(1, number.length());
			}
			else
			{
				r="-"+number;
			}
			number=r;
			screen.setText(number);
		}
		
		
		else if(str.equals("CE"))
		{
			number="";
			screen.setFont(new Font("Times New Roman", Font.BOLD, 39));	
			screen.setText("0");
		}
		
		
		else if(str.equals("AC"))
		{
			x=0;y=0;
			plus_counter=0;
			minus_counter=0;
			mult_counter=0;
			div_counter=0;equl_counter=0;sqrt_counter=0;
			word=0;
			number="";operation="";topscreen="";
			DOTCOUNTER=0;operation_counter=0;number_counter=0;
			screen.setText("0");
			toplabel.setText(topscreen);
			screen.setFont(new Font("Times New Roman", Font.BOLD, 39));	
		}
		
		
		else if((str.charAt(0)>='0' && str.charAt(0)<='9')&&number_counter<13)
		{
			screen.setFont(new Font("Times New Roman", Font.BOLD, 39));		
			if(equl_counter==1)
			{
				number="";
			}
			if(MR_counter==1)
			{
				number="";
			}
			if(sqrt_counter>0)
			{
				topscreen="";
				toplabel.setText(topscreen);
				x=0;y=0;
				sqrt_counter--;
				//all=topscreen;
			}
			number=number+str;
			screen.setText(number);
			number_counter++;
			plus_counter=0;
			minus_counter=0;
			mult_counter=0;
			div_counter=0;equl_counter=0;
			operation_counter=0;
			MR_counter=0;
		}
		
		
		else if(str.equals(".")&& DOTCOUNTER==0)
		{
			if(number.equals(""))
			{
				number="0";
			}
			if(equl_counter==1)
			{
				number="0";equl_counter=0;
			}
			number=number+str;
			screen.setText(number);
			DOTCOUNTER++;
		}
		
		
		else if((str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")))
		{
			DOTCOUNTER=0;equl_counter=0;
			word++;
			
			if(word==1)
			{
				operation=str;
			}
			
			if(plus_counter==0&&minus_counter==0&&mult_counter==0&&div_counter==0&&number.length()!=0)
			{
				double p=0;
				p =Double.parseDouble(screen.getText());
				
				
				if(operation.equals("+"))
				{
					x=x+p;
					
					String s;
					s=String.format("%.10f", x);
					x=Double.parseDouble(s);
				}
				else if(operation.equals("-"))
				{
					if(word==1)
					{
						x=p;	
					}
					else
					{
						x=x-p;
						
						String s;
						s=String.format("%.10f", x);
						x=Double.parseDouble(s);
					}		
				}
				else if(operation.equals("*"))
				{
					if(word==1)
					{
						x=p;
					}
					else
					{
						x=x*p;
						
						String s;
						s=String.format("%.10f", x);
						x=Double.parseDouble(s);
					}
				}
				else if(operation.equals("/"))
				{
					if(word==1)
					{
						x=p;
					}
					else
					{
						x=x/p;
						
						String s;
						s=String.format("%.10f", x);
						x=Double.parseDouble(s);
					}
				}
			}
			
			
			if(str.equals("+")&&plus_counter==0)
			{
				plus_counter++;
				minus_counter=0;
				mult_counter=0;
				div_counter=0;
			}
			else if(str.equals("-")&&minus_counter==0)
			{
				plus_counter=0;
				minus_counter++;
				mult_counter=0;
				div_counter=0;
				
			}
			else if(str.equals("*")&&mult_counter==0)
			{
				plus_counter=0;
				minus_counter=0;
				mult_counter++;
				div_counter=0;
				
			}
			else if(str.equals("/")&&div_counter==0)
			{
				plus_counter=0;
				minus_counter=0;
				mult_counter=0;
				div_counter++;
				
			}
			
			operation_counter++;
			if((plus_counter+minus_counter+mult_counter+div_counter)==1)
			{
				if(number.length()!=0)
				{
					number=Dot_fix(number);
				}
				
				//screen.setText(number);
				
				if(operation_counter==1)
				{
					if(number.equals("")&&sqrt_counter==0)
					{
						topscreen=topscreen+"0"+str;
					}
					else
					{
						topscreen=topscreen+number+str;
					}
					
					toplabel.setText(topscreen);
					
					//System.out.println(topscreen);
					//screen.setText(Double.toString(x));
				}
				else
				{
					topscreen=topscreen.substring(0, topscreen.length() - 1);
					topscreen=topscreen+str;
				    toplabel.setText(topscreen);
					
					//System.out.println(topscreen);
					//screen.setText(Double.toString(x));
				}
				all=topscreen;
				String s;
				s=Double.toString(x);
					
				s=Dot_fix(s);
						
						if(s.charAt(0)=='-'&&s.charAt(1)=='0'&&s.length()==2)
						{
							s=s.substring(1, s.length());
						}
						if(sqrt_counter>0)
						{
							if(number.length()>13)
							{
								screen.setFont(new Font("Times New Roman", Font.BOLD, 28));
							}
							screen.setText(number);
							sqrt_counter--;
						}
						else
						{
							if(s.length()>13)
							{
								screen.setFont(new Font("Times New Roman", Font.BOLD, 28));
							}
							screen.setText(s);
						}
				
			}
			
			op=true;
			operation=str;
			number="";
			number_counter=0;
			//System.out.println(x+1);
		}
		
		
		else if(str.equals("sqrt")&& !number.equals(""))
		{
			topscreen=topscreen+"sqrt(" + number + ")";
			double p=0;
			p = Double.parseDouble(number);
			p = sqrt(p);
			if(op==true)
			{
				all=all+"sqrt("+ number + ")";
				set_History(all);
				all="";
			}
			if(operation.equals("+"))
			{
				x=x+p;
			}
			else if(operation.equals("-"))
			{
				x=x-p;
			}
			else if(operation.equals("*"))
			{
				x=x*p;
			}
			else if(operation.equals("/"))
			{
				x=x/p;
			}
			
			/*x = Double.parseDouble(number);
			x = sqrt(x);*/
			//number=Double.toString(x);
			number=String.format("%.10f", p);
			number=Dot_fix(number);
				
			toplabel.setText(topscreen);
			screen.setText(number);
			if(op==false)
			{
				all=all+topscreen+"="+number+"\r\n";
				set_History(all);
				all="";
			}
			
			sqrt_counter++;
			word=0;
			plus_counter=0;
			minus_counter=0;
			mult_counter=0;
			div_counter=0;
			operation_counter=0;
			number_counter=0;
			number="";
		}
		
		
		else if(str.equals("=")&&equl_counter==0)
		{
			equl_counter++;
			word=0;
			DOTCOUNTER=0;
			plus_counter=0;
			minus_counter=0;
			mult_counter=0;
			div_counter=0;
			operation_counter=0;
			number_counter=0;
			
			
			if(number.equals(""))
			{
				if(sqrt_counter>0)
				{
					number=Double.toString(x);
				}
				else if(operation.equals("+"))
				{
					y=0;
					x=x+y;
					number=String.format("%.10f", x);
					x=Double.parseDouble(number);
					number=Double.toString(x);
					screen.setText(number);
				}
				else if(operation.equals("-"))
				{
					if(x==0)
					{
						screen.setText("0");
					}
					else
					{
						x=-x;
						number=String.format("%.10f", x);
						x=Double.parseDouble(number);
						number=Double.toString(x);
						screen.setText(number);
					}
					
				}
				else if(operation.equals("*"))
				{
					y=x;
					x=x*y;
					number=String.format("%.10f", x);
					x=Double.parseDouble(number);
					number=Double.toString(x);
					screen.setText(number);
				}
				else if(operation.equals("/"))
				{
					if(x==0)
					{
						screen.setText("Math Error");
					}
					else
					{
						y=1;
						x=x/y;
						number=String.format("%.10f", x);
						x=Double.parseDouble(number);
						number=Double.toString(x);
						screen.setText(number);
					}
				}
			}
			else
			{
				y = Double.parseDouble(screen.getText());
				topscreen=topscreen+number;
				//number="";
				
				if(operation.equals("+"))
				{
					x=x+y;
					number=String.format("%.10f", x);
					x=Double.parseDouble(number);
					number=Double.toString(x);
					//screen.setText(number);
				}
				else if(operation.equals("-"))
				{
					x=x-y;
					number=String.format("%.10f", x);
					x=Double.parseDouble(number);
					number=Double.toString(x);
					//screen.setText(number);
				}
				else if(operation.equals("*"))
				{
					x=x*y;
					number=String.format("%.10f", x);
					x=Double.parseDouble(number);
					number=Double.toString(x);
					//screen.setText(number);
				}
				else if(operation.equals("/"))
				{
						x=x/y;
						//number=Double.toString(x);
						number=String.format("%.10f", x);
						x=Double.parseDouble(number);
						number=Double.toString(x);
				}
				
			}
			if(number.length()!=0)
			{
				number=Dot_fix(number);
			}
			else
			{
				number="0";
			}
			
			
			if(operation.equals("/")&&y==0)
			{
				screen.setText("Math Error");
			}
			else
			{
				if(number.length()==2&&number.charAt(0)=='-'&&number.charAt(1)=='0')
				{
					number=number.substring(1, number.length());
				}
				if(number.length()>13)
				{
					screen.setFont(new Font("Times New Roman", Font.BOLD, 28));
				}
				screen.setText(number);
			}
			
			String s;
			s=Double.toString(y);
			s=Dot_fix(s);
			
			if(sqrt_counter>0)
			{
				s="";
			}
			
			all=all+s+"="+number+"\r\n";
			//System.out.println(all);
			set_History(all);
			all="";
			
			topscreen="";
			toplabel.setText("");
			x=0;
			y=0;op=false;operation="";	
		}
		
	}
	public String Dot_fix(String s)
	{
		double d1,v2;
		int v1;
		d1=Double.parseDouble(s);
		v1=(int)d1;
		v2=(double)v1;
		if(v2==d1)
		{
			s=Integer.toString(v1);
		}
		else
		{
			s=Double.toString(d1);
		}
		return s;
	}
	public void set_History(String h)
	{
		String temp="";
		try
		{
			FileReader reader1 = new FileReader("Date.txt");
			BufferedReader bfl1 = new BufferedReader(reader1);
			temp=bfl1.readLine();
            reader1.close();
			
			if(!temp.equals(df.format(dateobj)))
			{
				his=his+"-------------------------------"+df.format(dateobj)+"\r\n";
				set_Date(df.format(dateobj)+"\r\n");
			}
			
			FileWriter writer = new FileWriter("History.txt"); 
			his=his+h;
			writer.write(his); 
			writer.flush();
			writer.close();
		
		}
		catch(Exception e)
		{}
	}
	public void set_Date(String d)
	{
		try
		{
		FileWriter writer = new FileWriter("Date.txt"); 
		writer.write(d); 
		writer.flush();
		writer.close();
		}
		catch(Exception e)
		{}
	}
	public void set_Memory(String m)
	{
		try
		{
		FileWriter writer = new FileWriter("Memory.txt"); 
		writer.write(m); 
		writer.flush();
		writer.close();
		}
		catch(Exception e)
		{}
	}
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
}