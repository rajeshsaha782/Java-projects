import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class Frame1 extends JFrame implements ActionListener, MouseListener ,Runnable
{
	private JLabel TTT=new JLabel("Tic Tac Toe",JLabel.CENTER);
	private JLabel back=new JLabel("");
	private JLabel Combo_lebel=new JLabel("Select Sign");
	private JLabel Dimension_lebel=new JLabel("Select Dimension");
	private JLabel turn=new JLabel("",JLabel.CENTER);
	private JLabel p1wins=new JLabel("Player1 Wins:0");
	private JLabel p2wins=new JLabel("Player2 Wins:0");
	private JLabel Draw=new JLabel("Draw:0");
	
	private JLabel p1name=new JLabel("Player1 Name");
	private JLabel p2name=new JLabel("Player2 Name");
	private JTextField p1text=new JTextField();
	private JTextField p2text=new JTextField();
	private JLabel note=new JLabel("*Please Enter your name between 6 letters");
	
	private JRadioButton Player1, Player2;
	public JButton Start,B1,B2,B3,B4,B5,B6,B7,B8,B9,PComputer,CName,ok;
	private JPanel PanelForm1;
	private JComboBox combo,Dimension;
	private ButtonGroup bg1;
	public String g[],p1,p2,name1="Player1",name2="Player2";
	int t=1,p1win=0,p2win=0,draw=0;
	boolean p=true,win=false;
	public Frame1(String n1,String n2)
	{
		super("Tic Tac Toe");
		this.setSize(600,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		g=new String[10];
		g[1]=" ";g[2]=" ";g[3]=" ";g[4]=" ";g[5]=" ";g[6]=" ";g[7]=" ";g[8]=" ";g[9]=" ";
		name1=n1;name2=n2;
		p1wins.setText(name1+" Wins:0");p2wins.setText(name2+" Wins:0");
		
		PanelForm1 = new JPanel();
		PanelForm1.setBackground(Color.orange);
		PanelForm1.setLayout(null);
		
		TTT.setBounds(10, 10, 560, 85);
		TTT.setFont(new Font("Times New Roman", Font.BOLD, 109));
		TTT.setForeground(Color.black);
		PanelForm1.add(TTT);
		
		Combo_lebel.setBounds(330, 100, 100, 50);
		Combo_lebel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//Combo_lebel.setForeground(Color.white);
		//Combo_lebel.setBackground(Color.pink);
		PanelForm1.add(Combo_lebel);
		
		Dimension_lebel.setBounds(440, 100, 140, 50);
		Dimension_lebel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//Dimension_lebel.setForeground(Color.white);
		//Dimension_lebel.setBackground(Color.pink);
		PanelForm1.add(Dimension_lebel);
		
		turn.setBounds(210, 250, 115, 30);
		turn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//turn.setForeground(Color.white);
		PanelForm1.add(turn);
		
		p1wins.setBounds(50, 620, 125, 30);
		p1wins.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//p1wins.setForeground(Color.white);
		//p1wins.setBackground(Color.white);
		PanelForm1.add(p1wins);
		
		p2wins.setBounds(420, 620, 125, 30);
		p2wins.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//p2wins.setForeground(Color.white);
		//p2wins.setBackground(Color.white);
		PanelForm1.add(p2wins);
		
		Draw.setBounds(250, 620, 115, 30);
		Draw.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//Draw.setForeground(Color.white);
		//Draw.setBackground(Color.white);
		PanelForm1.add(Draw);
		
		Player1 = new JRadioButton(name1);
		Player1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Player1.setBackground(Color.magenta);
		Player1.setSelected(true);
		Player1.setBounds(100,110,100,30);
		PanelForm1.add(Player1);
		
		Player2 = new JRadioButton(name2);
		Player2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Player2.setBackground(Color.cyan);
		Player2.setBounds(100,150,100,30);
		PanelForm1.add(Player2);
		
		bg1= new ButtonGroup();
		bg1.add(Player1);
		bg1.add(Player2);
		
		String s[] = {"O", "X"};
		combo = new JComboBox(s);
		combo.setBounds(330, 150, 80, 30);
		combo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PanelForm1.add(combo);
		
		String d[] = {"3x3", "4x4","5x5"};
		Dimension = new JComboBox(d);
		Dimension.setBounds(440, 150, 80, 30);
		Dimension.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Dimension.addActionListener(this);
		PanelForm1.add(Dimension);
		
		Start = new JButton("Start");
		Start.setBounds(190, 190, 150, 50);
		Start.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Start.addActionListener(this);
		Start.setForeground(Color.black);
		Start.setBackground(Color.green);
		PanelForm1.add(Start);
		
		B1 = new JButton("");
		B1.setBounds(120, 300, 100, 100);
		B1.setFont(new Font("", Font.BOLD, 85));
		B1.setBackground(Color.red);
		B1.addActionListener(this);
		PanelForm1.add(B1);
		
		B4 = new JButton("");
		B4.setBounds(120, 405, 100, 100);
		B4.setFont(new Font("", Font.BOLD, 85));
		B4.setBackground(Color.red);
		B4.addActionListener(this);
		PanelForm1.add(B4);
		
		B7 = new JButton("");
		B7.setBounds(120, 510, 100, 100);
		B7.setFont(new Font("", Font.BOLD, 85));
		B7.setBackground(Color.red);
		B7.addActionListener(this);
		PanelForm1.add(B7);
		
		B2 = new JButton("");
		B2.setBounds(225, 300, 100, 100);
		B2.setFont(new Font("", Font.BOLD, 85));
		B2.setBackground(Color.red);
		B2.addActionListener(this);
		PanelForm1.add(B2);
		
		B3 = new JButton("");
		B3.setBounds(330, 300, 100, 100);
		B3.setFont(new Font("", Font.BOLD, 85));
		B3.setBackground(Color.red);
		B3.addActionListener(this);
		PanelForm1.add(B3);
		
		B5 = new JButton("");
		B5.setBounds(225, 405, 100, 100);
		B5.setFont(new Font("", Font.BOLD, 85));
		B5.setBackground(Color.red);
		B5.addActionListener(this);
		PanelForm1.add(B5);
		
		B6 = new JButton("");
		B6.setBounds(330, 405, 100, 100);
		B6.setFont(new Font("", Font.BOLD, 85));
		B6.setBackground(Color.red);
		B6.addActionListener(this);
		PanelForm1.add(B6);
		
		B8 = new JButton("");
		B8.setBounds(225, 510, 100, 100);
		B8.setFont(new Font("", Font.BOLD, 85));
		B8.setBackground(Color.red);
		B8.addActionListener(this);
		PanelForm1.add(B8);
		
		B9 = new JButton("");
		B9.setBounds(330, 510, 100, 100);
		B9.setFont(new Font("", Font.BOLD, 85));
		B9.setBackground(Color.red);
		B9.addActionListener(this);
		PanelForm1.add(B9);
		
		PComputer = new JButton("Play With Computer");
		PComputer.setBounds(430, 200, 140, 30);
		PComputer.setFont(new Font("", Font.BOLD, 10));
		PComputer.addActionListener(this);
		PanelForm1.add(PComputer);
		
		CName = new JButton("Change Name");
		CName.setBounds(20, 200, 110, 30);
		CName.setFont(new Font("", Font.BOLD, 10));
		CName.addActionListener(this);
		PanelForm1.add(CName);
		
		ok = new JButton("OK");
		ok.setBounds(230, 230, 80, 50);
		ok.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ok.setVisible(false);
		ok.addActionListener(this);
		PanelForm1.add(ok);
		
		p1name.setBounds(100,120,100,30);
		p1name.setFont(new Font("Times New Roman", Font.BOLD, 15));
		p1name.setVisible(false);
		PanelForm1.add(p1name);
		
		p2name.setBounds(100,170,100,30);
		p2name.setFont(new Font("Times New Roman", Font.BOLD, 15));
		p2name.setVisible(false);
		PanelForm1.add(p2name);
		
		note.setBounds(300,200,300,30);
		note.setFont(new Font("Times New Roman",0, 15));
		note.setForeground(Color.red);
		note.setVisible(false);
		PanelForm1.add(note);
		
		p1text.setBounds(220,120,100,30);
		p1text.setFont(new Font("Times New Roman", Font.BOLD, 15));
		p1text.setVisible(false);
		PanelForm1.add(p1text);
		
		p2text.setBounds(220,170,100,30);
		p2text.setFont(new Font("Times New Roman", Font.BOLD, 15));
		p2text.setVisible(false);
		PanelForm1.add(p2text);
		
		back.setOpaque(true);
		back.setBounds(120, 300, 310, 310);
		back.setBackground(Color.black);
		PanelForm1.add(back);
		
		B1.setEnabled(false);
		B2.setEnabled(false);
		B3.setEnabled(false);
		B4.setEnabled(false);
		B5.setEnabled(false);
		B6.setEnabled(false);
		B7.setEnabled(false);
		B8.setEnabled(false);
		B9.setEnabled(false);
		
		this.add(PanelForm1);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		Object source = ae.getSource();
		String dia = Dimension.getSelectedItem().toString();

		if(dia.equals("4x4"))
		{
			new Dimension4(name1,name2).setVisible(true);
			this.setVisible(false);
		}
		else if(dia.equals("5x5"))
		{
			new Dimension5(name1,name2).setVisible(true);
			this.setVisible(false);
		}
		
		else if(str.equals("Play With Computer"))
		{
			new Computer().setVisible(true);
			this.setVisible(false);
		}
		
		else if(str.equals("Change Name"))
		{
			g[1]=" ";g[2]=" ";g[3]=" ";g[4]=" ";g[5]=" ";g[6]=" ";g[7]=" ";g[8]=" ";g[9]=" ";p=true;win=false;t=1;
			Start.setVisible(false);turn.setVisible(false);
			Player1.setVisible(false);Player2.setVisible(false);
			CName.setVisible(false);PComputer.setVisible(false);
			Dimension.setVisible(false);combo.setVisible(false);
			Combo_lebel.setVisible(false);Dimension_lebel.setVisible(false);
			p1name.setVisible(true);p2name.setVisible(true);
			p1text.setVisible(true);p2text.setVisible(true);
			ok.setVisible(true);note.setVisible(true);
			
		}
		else if(str.equals("OK"))
		{
			Start.setVisible(true);
			Player1.setVisible(true);Player2.setVisible(true);
			CName.setVisible(true);PComputer.setVisible(true);
			Dimension.setVisible(true);combo.setVisible(true);
			Combo_lebel.setVisible(true);Dimension_lebel.setVisible(true);
			p1name.setVisible(false);p2name.setVisible(false);
			p1text.setVisible(false);p2text.setVisible(false);
			ok.setVisible(false);note.setVisible(false);
			
			name1=p1text.getText();
			name2=p2text.getText();
			if(name1.equals("")||name1.length()>=7){name1="Player1";}
			if(name2.equals("")||name2.length()>=7){name2="Player2";}
			Player1.setText(name1);Player2.setText(name2);
			p1wins.setText(name1+" Wins:"+Integer.toString(p1win));
			p2wins.setText(name2+" Wins:"+Integer.toString(p2win));
		}
		
		else if(str.equals("Start"))
		{
			String value = combo.getSelectedItem().toString();
			
			if(Player1.isSelected())
			{
				if(value.equals("X"))
				{
					p1="X";p2="O";
				}
				else
				{
					p1="O";p2="X";
				}
				
			}
			else
			{
				if(value.equals("X"))
				{
					p1="O";p2="X";
				}
				else
				{
					p1="X";p2="O";
				}
			}
			g[1]=" ";g[2]=" ";g[3]=" ";g[4]=" ";g[5]=" ";g[6]=" ";g[7]=" ";g[8]=" ";g[9]=" ";p=true;win=false;t=1;
			Start.setText("Restart");
			Player1.setEnabled(false);
			Player2.setEnabled(false);
			combo.setEnabled(false);CName.setEnabled(false);
			B1.setEnabled(true);B1.setText("");
			B2.setEnabled(true);B2.setText("");
			B3.setEnabled(true);B3.setText("");
			B4.setEnabled(true);B4.setText("");
			B5.setEnabled(true);B5.setText("");
			B6.setEnabled(true);B6.setText("");
			B7.setEnabled(true);B7.setText("");
			B8.setEnabled(true);B8.setText("");
			B9.setEnabled(true);B9.setText("");
			Random_turn();
		}
		else if(str.equals("Restart"))
		{
			g[1]=" ";g[2]=" ";g[3]=" ";g[4]=" ";g[5]=" ";g[6]=" ";g[7]=" ";g[8]=" ";g[9]=" ";p=true;win=false;t=1;
			B1.setEnabled(true);B1.setText("");B1.setBackground(Color.red);
			B2.setEnabled(true);B2.setText("");B2.setBackground(Color.red);
			B3.setEnabled(true);B3.setText("");B3.setBackground(Color.red);
			B4.setEnabled(true);B4.setText("");B4.setBackground(Color.red);
			B5.setEnabled(true);B5.setText("");B5.setBackground(Color.red);
			B6.setEnabled(true);B6.setText("");B6.setBackground(Color.red);
			B7.setEnabled(true);B7.setText("");B7.setBackground(Color.red);
			B8.setEnabled(true);B8.setText("");B8.setBackground(Color.red);
			B9.setEnabled(true);B9.setText("");B9.setBackground(Color.red);
			Random_turn();CName.setEnabled(false);
		}
		
		if(dia.equals("3x3"))
		{
			if(source==B1)
			{
				if(g[1]==" ")
				{	
					if(p==true)
					{
						match_sign_color(B1,p1);
						B1.setText(p1);
						p=false;
						g[1]=p1;
						t++;
						turn.setText(name2+"'s Turn");
					}
					else
					{
						match_sign_color(B1,p2);
						p=true;
						B1.setText(p2);
						g[1]=p2;t++;
						turn.setText(name1+"'s Turn");
					}
					
				}
			}
			else if(source==B2)
			{
				if(g[2]==" ")
				{	
					if(p==true)
					{
						match_sign_color(B2,p1);
						B2.setText(p1);
						p=false;
						g[2]=p1;t++;
						turn.setText(name2+"'s Turn");
					}
					else
					{
						match_sign_color(B2,p2);
						p=true;
						B2.setText(p2);
						g[2]=p2;t++;
						turn.setText(name1+"'s Turn");
					}
				}	
			}
			else if(source==B3)
			{
				if(g[3]==" ")
				{	
					if(p==true)
					{
						match_sign_color(B3,p1);
						B3.setText(p1);
						p=false;
						g[3]=p1;t++;
						turn.setText(name2+"'s Turn");
					}
					else
					{
						match_sign_color(B3,p2);
						p=true;
						B3.setText(p2);
						g[3]=p2;t++;
						turn.setText(name1+"'s Turn");
					}
				}
			}
			else if(source==B4)
			{
				if(g[4]==" ")
				{	
					if(p==true)
					{
						match_sign_color(B4,p1);
						B4.setText(p1);
						p=false;
						g[4]=p1;t++;
						turn.setText(name2+"'s Turn");
					}
					else
					{
						match_sign_color(B4,p2);
						p=true;
						B4.setText(p2);
						g[4]=p2;t++;
						turn.setText(name1+"'s Turn");
					}
				}
			}
			else if(source==B5)
			{
				if(g[5]==" ")
				{		
					if(p==true)
					{
						match_sign_color(B5,p1);
						B5.setText(p1);
						p=false;
						g[5]=p1;t++;
						turn.setText(name2+"'s Turn");
					}
					else
					{
						match_sign_color(B5,p2);
						p=true;
						B5.setText(p2);
						g[5]=p2;t++;
						turn.setText(name1+"'s Turn");
					}
				}
			}
			else if(source==B6)
			{
				if(g[6]==" ")
				{		
					if(p==true)
					{
						match_sign_color(B6,p1);
						B6.setText(p1);
						p=false;
						g[6]=p1;t++;
						turn.setText(name2+"'s Turn");
					}
					else
					{
						match_sign_color(B6,p2);
						p=true;
						B6.setText(p2);
						g[6]=p2;t++;
						turn.setText(name1+"'s Turn");
					}
				}
			}
			else if(source==B7)
			{
				if(g[7]==" ")
				{		
					if(p==true)
					{
						match_sign_color(B7,p1);
						B7.setText(p1);
						p=false;
						g[7]=p1;t++;
						turn.setText(name2+"'s Turn");
					}
					else
					{
						match_sign_color(B7,p2);
						p=true;
						B7.setText(p2);
						g[7]=p2;t++;
						turn.setText(name1+"'s Turn");
					}
				}
			}
			else if(source==B8)
			{
				if(g[8]==" ")
				{		
					if(p==true)
					{
						match_sign_color(B8,p1);
						B8.setText(p1);
						p=false;
						g[8]=p1;t++;
						turn.setText(name2+"'s Turn");
					}
					else
					{
						match_sign_color(B8,p2);
						p=true;
						B8.setText(p2);
						g[8]=p2;t++;
						turn.setText(name1+"'s Turn");
					}
				}
			}
			else if(source==B9)
			{
				if(g[9]==" ")
				{		
					if(p==true)
					{
						match_sign_color(B9,p1);
						B9.setText(p1);
						p=false;
						g[9]=p1;t++;
						turn.setText(name2+"'s Turn");
					}
					else
					{
						match_sign_color(B9,p2);
						p=true;
						B9.setText(p2);
						g[9]=p2;t++;
						turn.setText(name1+"'s Turn");
					}
				}
			}
			if(g[1].equals(p1)&&g[2].equals(p1)&&g[3].equals(p1))
			{
				B1.setBackground(Color.green);B2.setBackground(Color.green);B3.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p1win++;
			}
			else if(g[1].equals(p2)&&g[2].equals(p2)&&g[3].equals(p2))
			{
				B1.setBackground(Color.green);B2.setBackground(Color.green);B3.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p2win++;
			}
			else if(g[4].equals(p1)&&g[5].equals(p1)&&g[6].equals(p1))
			{
				B4.setBackground(Color.green);B5.setBackground(Color.green);B6.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p1win++;
			}
			else if(g[4].equals(p2)&&g[5].equals(p2)&&g[6].equals(p2))
			{
				B4.setBackground(Color.green);B5.setBackground(Color.green);B6.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p2win++;
			}
			else if(g[7].equals(p1)&&g[8].equals(p1)&&g[9].equals(p1))
			{
				B7.setBackground(Color.green);B8.setBackground(Color.green);B9.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p1win++;
			}
			else if(g[7].equals(p2)&&g[8].equals(p2)&&g[9].equals(p2))
			{
				B7.setBackground(Color.green);B8.setBackground(Color.green);B9.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p2win++;
			}
			else if(g[1].equals(p1)&&g[4].equals(p1)&&g[7].equals(p1))
			{
				B7.setBackground(Color.green);B1.setBackground(Color.green);B4.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p1win++;
			}
			else if(g[1].equals(p2)&&g[4].equals(p2)&&g[7].equals(p2))
			{
				B7.setBackground(Color.green);B1.setBackground(Color.green);B4.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p2win++;
			}
			else if(g[2].equals(p1)&&g[5].equals(p1)&&g[8].equals(p1))
			{
				B2.setBackground(Color.green);B5.setBackground(Color.green);B8.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p1win++;
			}
			else if(g[2].equals(p2)&&g[5].equals(p2)&&g[8].equals(p2))
			{
				B2.setBackground(Color.green);B5.setBackground(Color.green);B8.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p2win++;
			}
			else if(g[3].equals(p1)&&g[6].equals(p1)&&g[9].equals(p1))
			{
				B3.setBackground(Color.green);B6.setBackground(Color.green);B9.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p1win++;
			}
			else if(g[3].equals(p2)&&g[6].equals(p2)&&g[9].equals(p2))
			{
				B3.setBackground(Color.green);B6.setBackground(Color.green);B9.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p2win++;
			}
			else if(g[1].equals(p1)&&g[5].equals(p1)&&g[9].equals(p1))
			{
				B1.setBackground(Color.green);B5.setBackground(Color.green);B9.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p1win++;
			}
			else if(g[1].equals(p2)&&g[5].equals(p2)&&g[9].equals(p2))
			{
				B1.setBackground(Color.green);B5.setBackground(Color.green);B9.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p2win++;
			}
			else if(g[3].equals(p1)&&g[5].equals(p1)&&g[7].equals(p1))
			{
				B3.setBackground(Color.green);B5.setBackground(Color.green);B7.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p1win++;
			}
			else if(g[3].equals(p2)&&g[5].equals(p2)&&g[7].equals(p2))
			{
				B3.setBackground(Color.green);B5.setBackground(Color.green);B7.setBackground(Color.green);
				JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
				win=true;p2win++;
			}
			if(win==true)
			{
				B1.setEnabled(false);
				B2.setEnabled(false);
				B3.setEnabled(false);
				B4.setEnabled(false);
				B5.setEnabled(false);
				B6.setEnabled(false);
				B7.setEnabled(false);
				B8.setEnabled(false);
				B9.setEnabled(false);CName.setEnabled(true);
				p1wins.setText(name1+" Wins:"+Integer.toString(p1win));
				p2wins.setText(name2+" Wins:"+Integer.toString(p2win));
				Draw.setText("Draw:"+Integer.toString(draw));
			}	
			
			else if(t==10)
			{
				draw++;win=true;CName.setEnabled(true);
				JOptionPane.showMessageDialog( this, "This round is a draw", "", JOptionPane.NO_OPTION);
				p1wins.setText(name1+" Wins:"+Integer.toString(p1win));
				p2wins.setText(name2+" Wins:"+Integer.toString(p2win));
				Draw.setText("Draw:"+Integer.toString(draw));
			}
		}
	
	}
	public void match_sign_color(JButton o,String p)
	{
		if(p.equals("X"))
		{
			o.setForeground(Color.black);
		}
		else
		{
			o.setForeground(Color.white);
		}
	}
	public void Random_turn()
	{
		turn.setOpaque(true);turn.setVisible(true);
		turn.setBackground(Color.white);
		Random r=new Random();
		int x=r.nextInt(2);
		if(x==0)
		{
			p=true;
			turn.setText(name1+"'s Turn");
		}
		else
		{
			p=false;
			turn.setText(name2+"'s Turn");
		}
	}
	public void run()
	{
		try
		{
			while(true)
			{
				Thread.sleep(500);
				TTT.setForeground(Color.white);
				Thread.sleep(500);
				TTT.setForeground(Color.blue);
				Thread.sleep(500);
				TTT.setForeground(Color.gray);
				Thread.sleep(500);
				TTT.setForeground(Color.red);
				Thread.sleep(500);
				TTT.setForeground(Color.black);
			}
		}
		catch(Exception e){}
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
}