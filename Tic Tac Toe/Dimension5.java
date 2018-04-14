import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class Dimension5 extends JFrame implements ActionListener, MouseListener 
{
	private JLabel TTT=new JLabel("Tic Tac Toe",JLabel.CENTER);
	private JLabel back=new JLabel("");
	private JLabel Combo_lebel=new JLabel("Select Sign");
	private JLabel Dimension_lebel=new JLabel("Select Dimension");
	private JLabel Align_lebel=new JLabel("No of Sign to Align");
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
	public JButton Start,B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21,B22,B23,B24,B25,CName,ok;
	private JPanel PanelForm1;
	private JComboBox combo,Dimension,Align;
	private ButtonGroup bg1;
	public String g[],p1,p2,name1="Player1",name2="Player2";
	int t=1,p1win=0,p2win=0,draw=0;
	boolean p=true,win=false;
	public Dimension5(String n1,String n2)
	{
		super("Tic Tac Toe");
		this.setSize(600,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		g=new String[26];
		g[1]=" ";g[2]=" ";g[3]=" ";g[4]=" ";g[5]=" ";g[6]=" ";g[7]=" ";g[8]=" ";g[9]=" ";g[10]=" ";g[11]=" ";g[12]=" ";g[13]=" ";g[14]=" ";g[15]=" ";g[16]=" ";
		g[17]=" ";g[18]=" ";g[19]=" ";g[20]=" ";g[21]=" ";g[22]=" ";g[23]=" ";g[24]=" ";g[25]=" ";
		
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
		
		Align_lebel.setBounds(440, 170, 140, 50);
		Align_lebel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//Align_lebel.setForeground(Color.white);
		//Align_lebel.setBackground(Color.pink);
		PanelForm1.add(Align_lebel);
		
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
		
		String d[] = {"5x5","4x4","3x3"};
		Dimension = new JComboBox(d);
		Dimension.setBounds(440, 150, 80, 30);
		Dimension.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Dimension.addActionListener(this);
		PanelForm1.add(Dimension);
		
		String a[] = {"4"};
		Align = new JComboBox(a);
		Align.setBounds(440, 210, 80, 30);
		Align.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PanelForm1.add(Align);
		
		Start = new JButton("Start");
		Start.setBounds(190, 190, 150, 50);
		Start.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Start.addActionListener(this);
		Start.setForeground(Color.black);
		Start.setBackground(Color.green);
		PanelForm1.add(Start);
		
		B1 = new JButton("");
		B1.setBounds(120, 297, 60, 60);
		B1.setFont(new Font("", Font.BOLD, 34));
		B1.setBackground(Color.red);
		B1.addActionListener(this);
		PanelForm1.add(B1);
		
		B6 = new JButton("");
		B6.setBounds(120, 361, 60, 60);
		B6.setFont(new Font("", Font.BOLD, 34));
		B6.setBackground(Color.red);
		B6.addActionListener(this);
		PanelForm1.add(B6);
		
		B11 = new JButton("");
		B11.setBounds(120, 425, 60, 60);
		B11.setFont(new Font("", Font.BOLD, 34));
		B11.setBackground(Color.red);
		B11.addActionListener(this);
		PanelForm1.add(B11);
		
		B16 = new JButton("");
		B16.setBounds(120, 489, 60, 60);
		B16.setFont(new Font("", Font.BOLD, 34));
		B16.setBackground(Color.red);
		B16.addActionListener(this);
		PanelForm1.add(B16);
		
		B21 = new JButton("");
		B21.setBounds(120, 553, 60, 60);
		B21.setFont(new Font("", Font.BOLD, 34));
		B21.setBackground(Color.red);
		B21.addActionListener(this);
		PanelForm1.add(B21);
		
		B2 = new JButton("");
		B2.setBounds(184, 297, 60, 60);
		B2.setFont(new Font("", Font.BOLD, 34));
		B2.setBackground(Color.red);
		B2.addActionListener(this);
		PanelForm1.add(B2);
		
		B7 = new JButton("");
		B7.setBounds(184, 361, 60, 60);
		B7.setFont(new Font("", Font.BOLD, 34));
		B7.setBackground(Color.red);
		B7.addActionListener(this);
		PanelForm1.add(B7);
		
		B12 = new JButton("");
		B12.setBounds(184, 425, 60, 60);
		B12.setFont(new Font("", Font.BOLD, 34));
		B12.setBackground(Color.red);
		B12.addActionListener(this);
		PanelForm1.add(B12);
		
		B17 = new JButton("");
		B17.setBounds(184, 489, 60, 60);
		B17.setFont(new Font("", Font.BOLD, 34));
		B17.setBackground(Color.red);
		B17.addActionListener(this);
		PanelForm1.add(B17);
		
		B22 = new JButton("");
		B22.setBounds(184, 553, 60, 60);
		B22.setFont(new Font("", Font.BOLD, 34));
		B22.setBackground(Color.red);
		B22.addActionListener(this);
		PanelForm1.add(B22);
		
		B3 = new JButton("");
		B3.setBounds(248, 297, 60, 60);
		B3.setFont(new Font("", Font.BOLD, 34));
		B3.setBackground(Color.red);
		B3.addActionListener(this);
		PanelForm1.add(B3);
		
		B8 = new JButton("");
		B8.setBounds(248, 361, 60, 60);
		B8.setFont(new Font("", Font.BOLD, 34));
		B8.setBackground(Color.red);
		B8.addActionListener(this);
		PanelForm1.add(B8);
		
		B13 = new JButton("");
		B13.setBounds(248, 425, 60, 60);
		B13.setFont(new Font("", Font.BOLD, 34));
		B13.setBackground(Color.red);
		B13.addActionListener(this);
		PanelForm1.add(B13);
		
		B18 = new JButton("");
		B18.setBounds(248, 489, 60, 60);
		B18.setFont(new Font("", Font.BOLD, 34));
		B18.setBackground(Color.red);
		B18.addActionListener(this);
		PanelForm1.add(B18);
		
		B23 = new JButton("");
		B23.setBounds(248, 553, 60, 60);
		B23.setFont(new Font("", Font.BOLD, 34));
		B23.setBackground(Color.red);
		B23.addActionListener(this);
		PanelForm1.add(B23);
		
		B4 = new JButton("");
		B4.setBounds(312, 297, 60, 60);
		B4.setFont(new Font("", Font.BOLD, 34));
		B4.setBackground(Color.red);
		B4.addActionListener(this);
		PanelForm1.add(B4);
		
		B9 = new JButton("");
		B9.setBounds(312, 361, 60, 60);
		B9.setFont(new Font("", Font.BOLD, 34));
		B9.setBackground(Color.red);
		B9.addActionListener(this);
		PanelForm1.add(B9);
		
		B14 = new JButton("");
		B14.setBounds(312, 425, 60, 60);
		B14.setFont(new Font("", Font.BOLD, 34));
		B14.setBackground(Color.red);
		B14.addActionListener(this);
		PanelForm1.add(B14);
		
		B19 = new JButton("");
		B19.setBounds(312, 489, 60, 60);
		B19.setFont(new Font("", Font.BOLD, 34));
		B19.setBackground(Color.red);
		B19.addActionListener(this);
		PanelForm1.add(B19);
		
		B24 = new JButton("");
		B24.setBounds(312, 553, 60, 60);
		B24.setFont(new Font("", Font.BOLD, 34));
		B24.setBackground(Color.red);
		B24.addActionListener(this);
		PanelForm1.add(B24);
	
		B5 = new JButton("");
		B5.setBounds(376, 297, 60, 60);
		B5.setFont(new Font("", Font.BOLD, 34));
		B5.setBackground(Color.red);
		B5.addActionListener(this);
		PanelForm1.add(B5);
		
		B10 = new JButton("");
		B10.setBounds(376, 361, 60, 60);
		B10.setFont(new Font("", Font.BOLD, 34));
		B10.setBackground(Color.red);
		B10.addActionListener(this);
		PanelForm1.add(B10);
		
		B15 = new JButton("");
		B15.setBounds(376, 425, 60, 60);
		B15.setFont(new Font("", Font.BOLD, 34));
		B15.setBackground(Color.red);
		B15.addActionListener(this);
		PanelForm1.add(B15);
		
		B20 = new JButton("");
		B20.setBounds(376, 489, 60, 60);
		B20.setFont(new Font("", Font.BOLD, 34));
		B20.setBackground(Color.red);
		B20.addActionListener(this);
		PanelForm1.add(B20);
		
		B25 = new JButton("");
		B25.setBounds(376, 553, 60, 60);
		B25.setFont(new Font("", Font.BOLD, 34));
		B25.setBackground(Color.red);
		B25.addActionListener(this);
		PanelForm1.add(B25);
		
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
		back.setBounds(120, 297, 316, 316);
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
		B10.setEnabled(false);
		B11.setEnabled(false);
		B12.setEnabled(false);
		B13.setEnabled(false);
		B14.setEnabled(false);
		B15.setEnabled(false);
		B16.setEnabled(false);
		B17.setEnabled(false);
		B18.setEnabled(false);
		B19.setEnabled(false);
		B20.setEnabled(false);
		B21.setEnabled(false);
		B22.setEnabled(false);
		B23.setEnabled(false);
		B24.setEnabled(false);
		B25.setEnabled(false);
		this.add(PanelForm1);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		Object source = ae.getSource();
		String dia = Dimension.getSelectedItem().toString();
		
		if(dia.equals("3x3"))
		{
			new Frame1(name1,name2).setVisible(true);
			this.setVisible(false);
		}
		else if(dia.equals("4x4"))
		{
			new Dimension4(name1,name2).setVisible(true);
			this.setVisible(false);
		}
		
		else if(str.equals("Change Name"))
		{
			g[1]=" ";g[2]=" ";g[3]=" ";g[4]=" ";g[5]=" ";g[6]=" ";g[7]=" ";g[8]=" ";g[9]=" ";g[10]=" ";g[11]=" ";g[12]=" ";g[13]=" ";g[14]=" ";g[15]=" ";g[16]=" ";
			g[17]=" ";g[18]=" ";g[19]=" ";g[20]=" ";g[21]=" ";g[22]=" ";g[23]=" ";g[24]=" ";g[25]=" ";p=true;win=false;t=1;
			Start.setVisible(false);turn.setVisible(false);
			Player1.setVisible(false);Player2.setVisible(false);
			CName.setVisible(false);Align_lebel.setVisible(false);
			Dimension.setVisible(false);combo.setVisible(false);Align.setVisible(false);
			Combo_lebel.setVisible(false);Dimension_lebel.setVisible(false);
			p1name.setVisible(true);p2name.setVisible(true);
			p1text.setVisible(true);p2text.setVisible(true);
			ok.setVisible(true);note.setVisible(true);
			
		}
		else if(str.equals("OK"))
		{
			Start.setVisible(true);
			Player1.setVisible(true);Player2.setVisible(true);
			CName.setVisible(true);Align_lebel.setVisible(true);
			Dimension.setVisible(true);combo.setVisible(true);Align.setVisible(true);
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
			g[1]=" ";g[2]=" ";g[3]=" ";g[4]=" ";g[5]=" ";g[6]=" ";g[7]=" ";g[8]=" ";g[9]=" ";g[10]=" ";g[11]=" ";g[12]=" ";g[13]=" ";g[14]=" ";g[15]=" ";g[16]=" ";
			g[17]=" ";g[18]=" ";g[19]=" ";g[20]=" ";g[21]=" ";g[22]=" ";g[23]=" ";g[24]=" ";g[25]=" ";p=true;win=false;t=1;
			Start.setText("Restart");
			Player1.setEnabled(false);
			Player2.setEnabled(false);
			combo.setEnabled(false);
			B1.setEnabled(true);B1.setText("");
			B2.setEnabled(true);B2.setText("");
			B3.setEnabled(true);B3.setText("");
			B4.setEnabled(true);B4.setText("");
			B5.setEnabled(true);B5.setText("");
			B6.setEnabled(true);B6.setText("");
			B7.setEnabled(true);B7.setText("");
			B8.setEnabled(true);B8.setText("");
			B9.setEnabled(true);B9.setText("");
			B10.setEnabled(true);B10.setText("");
			B11.setEnabled(true);B11.setText("");
			B12.setEnabled(true);B12.setText("");
			B13.setEnabled(true);B13.setText("");
			B14.setEnabled(true);B14.setText("");
			B15.setEnabled(true);B15.setText("");
			B16.setEnabled(true);B16.setText("");
			B17.setEnabled(true);B17.setText("");
			B18.setEnabled(true);B18.setText("");
			B19.setEnabled(true);B19.setText("");
			B20.setEnabled(true);B20.setText("");
			B21.setEnabled(true);B21.setText("");
			B22.setEnabled(true);B22.setText("");
			B23.setEnabled(true);B23.setText("");
			B24.setEnabled(true);B24.setText("");
			B25.setEnabled(true);B25.setText("");
			Random_turn();
			Align.setEnabled(false);CName.setEnabled(false);
		}
		else if(str.equals("Restart"))
		{
			g[1]=" ";g[2]=" ";g[3]=" ";g[4]=" ";g[5]=" ";g[6]=" ";g[7]=" ";g[8]=" ";g[9]=" ";g[10]=" ";g[11]=" ";g[12]=" ";g[13]=" ";g[14]=" ";g[15]=" ";g[16]=" ";
			g[17]=" ";g[18]=" ";g[19]=" ";g[20]=" ";g[21]=" ";g[22]=" ";g[23]=" ";g[24]=" ";g[25]=" ";p=true;win=false;t=1;
			B1.setEnabled(true);B1.setText("");B1.setBackground(Color.red);
			B2.setEnabled(true);B2.setText("");B2.setBackground(Color.red);
			B3.setEnabled(true);B3.setText("");B3.setBackground(Color.red);
			B4.setEnabled(true);B4.setText("");B4.setBackground(Color.red);
			B5.setEnabled(true);B5.setText("");B5.setBackground(Color.red);
			B6.setEnabled(true);B6.setText("");B6.setBackground(Color.red);
			B7.setEnabled(true);B7.setText("");B7.setBackground(Color.red);
			B8.setEnabled(true);B8.setText("");B8.setBackground(Color.red);
			B9.setEnabled(true);B9.setText("");B9.setBackground(Color.red);
			B10.setEnabled(true);B10.setText("");B10.setBackground(Color.red);
			B11.setEnabled(true);B11.setText("");B11.setBackground(Color.red);
			B12.setEnabled(true);B12.setText("");B12.setBackground(Color.red);
			B13.setEnabled(true);B13.setText("");B13.setBackground(Color.red);
			B14.setEnabled(true);B14.setText("");B14.setBackground(Color.red);
			B15.setEnabled(true);B15.setText("");B15.setBackground(Color.red);
			B16.setEnabled(true);B16.setText("");B16.setBackground(Color.red);
			B17.setEnabled(true);B17.setText("");B17.setBackground(Color.red);
			B18.setEnabled(true);B18.setText("");B18.setBackground(Color.red);
			B19.setEnabled(true);B19.setText("");B19.setBackground(Color.red);
			B20.setEnabled(true);B20.setText("");B20.setBackground(Color.red);
			B21.setEnabled(true);B21.setText("");B21.setBackground(Color.red);
			B22.setEnabled(true);B22.setText("");B22.setBackground(Color.red);
			B23.setEnabled(true);B23.setText("");B23.setBackground(Color.red);
			B24.setEnabled(true);B24.setText("");B24.setBackground(Color.red);
			B25.setEnabled(true);B25.setText("");B25.setBackground(Color.red);
			Random_turn();
			Align.setEnabled(false);CName.setEnabled(false);
		}
		else if(source==B1)
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
		else if(source==B10)
		{
			if(g[10]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B10,p1);
					B10.setText(p1);
					p=false;
					g[10]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B10,p2);
					p=true;
					B10.setText(p2);
					g[10]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B11)
		{
			if(g[11]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B11,p1);
					B11.setText(p1);
					p=false;
					g[11]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B11,p2);
					p=true;
					B11.setText(p2);
					g[11]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B12)
		{
			if(g[12]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B12,p1);
					B12.setText(p1);
					p=false;
					g[12]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B12,p2);
					p=true;
					B12.setText(p2);
					g[12]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B13)
		{
			if(g[13]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B13,p1);
					B13.setText(p1);
					p=false;
					g[13]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B13,p2);
					p=true;
					B13.setText(p2);
					g[13]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B14)
		{
			if(g[14]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B14,p1);
					B14.setText(p1);
					p=false;
					g[14]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B14,p2);
					p=true;
					B14.setText(p2);
					g[14]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B15)
		{
			if(g[15]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B15,p1);
					B15.setText(p1);
					p=false;
					g[15]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B15,p2);
					p=true;
					B15.setText(p2);
					g[15]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B16)
		{
			if(g[16]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B16,p1);
					B16.setText(p1);
					p=false;
					g[16]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B16,p2);
					p=true;
					B16.setText(p2);
					g[16]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B17)
		{
			if(g[17]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B17,p1);
					B17.setText(p1);
					p=false;
					g[17]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B17,p2);
					p=true;
					B17.setText(p2);
					g[17]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B18)
		{
			if(g[18]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B18,p1);
					B18.setText(p1);
					p=false;
					g[18]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B18,p2);
					p=true;
					B18.setText(p2);
					g[18]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B19)
		{
			if(g[19]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B19,p1);
					B19.setText(p1);
					p=false;
					g[19]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B19,p2);
					p=true;
					B19.setText(p2);
					g[19]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B20)
		{
			if(g[20]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B20,p1);
					B20.setText(p1);
					p=false;
					g[20]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B20,p2);
					p=true;
					B20.setText(p2);
					g[20]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B21)
		{
			if(g[21]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B21,p1);
					B21.setText(p1);
					p=false;
					g[21]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B21,p2);
					p=true;
					B21.setText(p2);
					g[21]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B22)
		{
			if(g[22]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B22,p1);
					B22.setText(p1);
					p=false;
					g[22]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B22,p2);
					p=true;
					B22.setText(p2);
					g[22]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B23)
		{
			if(g[23]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B23,p1);
					B23.setText(p1);
					p=false;
					g[23]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B23,p2);
					p=true;
					B23.setText(p2);
					g[23]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B24)
		{
			if(g[24]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B24,p1);
					B24.setText(p1);
					p=false;
					g[24]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B24,p2);
					p=true;
					B24.setText(p2);
					g[24]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		else if(source==B25)
		{
			if(g[25]==" ")
			{		
				if(p==true)
				{
					match_sign_color(B25,p1);
					B25.setText(p1);
					p=false;
					g[25]=p1;t++;
					turn.setText(name2+"'s Turn");
				}
				else
				{
					match_sign_color(B25,p2);
					p=true;
					B25.setText(p2);
					g[25]=p2;t++;
					turn.setText(name1+"'s Turn");
				}
			}
		}
		
		
		if(g[1].equals(p1)&&g[2].equals(p1)&&g[3].equals(p1)&&g[4].equals(p1))
		{
			B1.setBackground(Color.green);B2.setBackground(Color.green);B3.setBackground(Color.green);B4.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[1].equals(p2)&&g[2].equals(p2)&&g[3].equals(p2)&&g[4].equals(p2))
		{
			B1.setBackground(Color.green);B2.setBackground(Color.green);B3.setBackground(Color.green);B4.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[5].equals(p1)&&g[2].equals(p1)&&g[3].equals(p1)&&g[4].equals(p1))
		{
			B5.setBackground(Color.green);B2.setBackground(Color.green);B3.setBackground(Color.green);B4.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[5].equals(p2)&&g[2].equals(p2)&&g[3].equals(p2)&&g[4].equals(p2))
		{
			B5.setBackground(Color.green);B2.setBackground(Color.green);B3.setBackground(Color.green);B4.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[6].equals(p1)&&g[7].equals(p1)&&g[8].equals(p1)&&g[9].equals(p1))
		{
			B6.setBackground(Color.green);B7.setBackground(Color.green);B8.setBackground(Color.green);B9.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[6].equals(p2)&&g[7].equals(p2)&&g[8].equals(p2)&&g[9].equals(p2))
		{
			B6.setBackground(Color.green);B7.setBackground(Color.green);B8.setBackground(Color.green);B9.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[10].equals(p1)&&g[7].equals(p1)&&g[8].equals(p1)&&g[9].equals(p1))
		{
			B10.setBackground(Color.green);B7.setBackground(Color.green);B8.setBackground(Color.green);B9.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[10].equals(p2)&&g[7].equals(p2)&&g[8].equals(p2)&&g[9].equals(p2))
		{
			B10.setBackground(Color.green);B7.setBackground(Color.green);B8.setBackground(Color.green);B9.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[11].equals(p1)&&g[12].equals(p1)&&g[13].equals(p1)&&g[14].equals(p1))
		{
			B11.setBackground(Color.green);B12.setBackground(Color.green);B13.setBackground(Color.green);B14.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[11].equals(p2)&&g[12].equals(p2)&&g[13].equals(p2)&&g[14].equals(p2))
		{
			B11.setBackground(Color.green);B12.setBackground(Color.green);B13.setBackground(Color.green);B14.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[15].equals(p1)&&g[12].equals(p1)&&g[13].equals(p1)&&g[14].equals(p1))
		{
			B15.setBackground(Color.green);B12.setBackground(Color.green);B13.setBackground(Color.green);B14.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[15].equals(p2)&&g[12].equals(p2)&&g[13].equals(p2)&&g[14].equals(p2))
		{
			B15.setBackground(Color.green);B12.setBackground(Color.green);B13.setBackground(Color.green);B14.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[16].equals(p1)&&g[17].equals(p1)&&g[18].equals(p1)&&g[19].equals(p1))
		{
			B16.setBackground(Color.green);B17.setBackground(Color.green);B18.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[16].equals(p2)&&g[17].equals(p2)&&g[18].equals(p2)&&g[19].equals(p2))
		{
			B16.setBackground(Color.green);B17.setBackground(Color.green);B18.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[20].equals(p1)&&g[17].equals(p1)&&g[18].equals(p1)&&g[19].equals(p1))
		{
			B20.setBackground(Color.green);B17.setBackground(Color.green);B18.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[20].equals(p2)&&g[17].equals(p2)&&g[18].equals(p2)&&g[19].equals(p2))
		{
			B20.setBackground(Color.green);B17.setBackground(Color.green);B18.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[21].equals(p1)&&g[22].equals(p1)&&g[23].equals(p1)&&g[24].equals(p1))
		{
			B21.setBackground(Color.green);B22.setBackground(Color.green);B23.setBackground(Color.green);B24.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[21].equals(p2)&&g[22].equals(p2)&&g[23].equals(p2)&&g[24].equals(p2))
		{
			B21.setBackground(Color.green);B22.setBackground(Color.green);B23.setBackground(Color.green);B24.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[25].equals(p1)&&g[22].equals(p1)&&g[23].equals(p1)&&g[24].equals(p1))
		{
			B25.setBackground(Color.green);B21.setBackground(Color.green);B13.setBackground(Color.green);B24.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[25].equals(p2)&&g[22].equals(p2)&&g[23].equals(p2)&&g[24].equals(p2))
		{
			B25.setBackground(Color.green);B22.setBackground(Color.green);B23.setBackground(Color.green);B24.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		
		
		else if(g[1].equals(p1)&&g[6].equals(p1)&&g[11].equals(p1)&&g[16].equals(p1))
		{
			B1.setBackground(Color.green);B6.setBackground(Color.green);B11.setBackground(Color.green);B16.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[1].equals(p2)&&g[6].equals(p2)&&g[11].equals(p2)&&g[16].equals(p2))
		{
			B1.setBackground(Color.green);B6.setBackground(Color.green);B11.setBackground(Color.green);B16.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[21].equals(p1)&&g[6].equals(p1)&&g[11].equals(p1)&&g[16].equals(p1))
		{
			B21.setBackground(Color.green);B6.setBackground(Color.green);B11.setBackground(Color.green);B16.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[21].equals(p2)&&g[6].equals(p2)&&g[11].equals(p2)&&g[16].equals(p2))
		{
			B21.setBackground(Color.green);B6.setBackground(Color.green);B11.setBackground(Color.green);B16.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[2].equals(p1)&&g[7].equals(p1)&&g[12].equals(p1)&&g[17].equals(p1))
		{
			B2.setBackground(Color.green);B7.setBackground(Color.green);B12.setBackground(Color.green);B17.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[2].equals(p2)&&g[7].equals(p2)&&g[12].equals(p2)&&g[17].equals(p2))
		{
			B2.setBackground(Color.green);B7.setBackground(Color.green);B12.setBackground(Color.green);B17.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[22].equals(p1)&&g[7].equals(p1)&&g[12].equals(p1)&&g[17].equals(p1))
		{
			B2.setBackground(Color.green);B7.setBackground(Color.green);B12.setBackground(Color.green);B17.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[22].equals(p2)&&g[7].equals(p2)&&g[12].equals(p2)&&g[17].equals(p2))
		{
			B22.setBackground(Color.green);B7.setBackground(Color.green);B12.setBackground(Color.green);B17.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[3].equals(p1)&&g[8].equals(p1)&&g[13].equals(p1)&&g[18].equals(p1))
		{
			B3.setBackground(Color.green);B8.setBackground(Color.green);B13.setBackground(Color.green);B18.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[3].equals(p2)&&g[8].equals(p2)&&g[13].equals(p2)&&g[18].equals(p2))
		{
			B3.setBackground(Color.green);B8.setBackground(Color.green);B13.setBackground(Color.green);B18.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[23].equals(p1)&&g[8].equals(p1)&&g[13].equals(p1)&&g[18].equals(p1))
		{
			B23.setBackground(Color.green);B8.setBackground(Color.green);B13.setBackground(Color.green);B18.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[23].equals(p2)&&g[8].equals(p2)&&g[13].equals(p2)&&g[18].equals(p2))
		{
			B23.setBackground(Color.green);B8.setBackground(Color.green);B13.setBackground(Color.green);B18.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[4].equals(p1)&&g[9].equals(p1)&&g[14].equals(p1)&&g[19].equals(p1))
		{
			B4.setBackground(Color.green);B9.setBackground(Color.green);B14.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[4].equals(p2)&&g[9].equals(p2)&&g[14].equals(p2)&&g[19].equals(p2))
		{
			B4.setBackground(Color.green);B9.setBackground(Color.green);B14.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[24].equals(p1)&&g[9].equals(p1)&&g[14].equals(p1)&&g[19].equals(p1))
		{
			B24.setBackground(Color.green);B9.setBackground(Color.green);B14.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[24].equals(p2)&&g[9].equals(p2)&&g[14].equals(p2)&&g[19].equals(p2))
		{
			B24.setBackground(Color.green);B9.setBackground(Color.green);B14.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[5].equals(p1)&&g[10].equals(p1)&&g[15].equals(p1)&&g[20].equals(p1))
		{
			B5.setBackground(Color.green);B10.setBackground(Color.green);B15.setBackground(Color.green);B20.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[5].equals(p2)&&g[10].equals(p2)&&g[15].equals(p2)&&g[20].equals(p2))
		{
			B5.setBackground(Color.green);B10.setBackground(Color.green);B15.setBackground(Color.green);B20.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[25].equals(p1)&&g[10].equals(p1)&&g[15].equals(p1)&&g[20].equals(p1))
		{
			B25.setBackground(Color.green);B10.setBackground(Color.green);B15.setBackground(Color.green);B20.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[25].equals(p2)&&g[10].equals(p2)&&g[15].equals(p2)&&g[20].equals(p2))
		{
			B25.setBackground(Color.green);B10.setBackground(Color.green);B15.setBackground(Color.green);B20.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		
		
		else if(g[4].equals(p1)&&g[8].equals(p1)&&g[12].equals(p1)&&g[16].equals(p1))
		{
			B4.setBackground(Color.green);B8.setBackground(Color.green);B12.setBackground(Color.green);B16.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[4].equals(p2)&&g[8].equals(p2)&&g[12].equals(p2)&&g[16].equals(p2))
		{
			B4.setBackground(Color.green);B8.setBackground(Color.green);B12.setBackground(Color.green);B16.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[5].equals(p1)&&g[9].equals(p1)&&g[13].equals(p1)&&g[17].equals(p1))
		{
			B5.setBackground(Color.green);B9.setBackground(Color.green);B13.setBackground(Color.green);B17.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[5].equals(p2)&&g[9].equals(p2)&&g[13].equals(p2)&&g[17].equals(p2))
		{
			B5.setBackground(Color.green);B9.setBackground(Color.green);B13.setBackground(Color.green);B17.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[21].equals(p1)&&g[9].equals(p1)&&g[13].equals(p1)&&g[17].equals(p1))
		{
			B21.setBackground(Color.green);B9.setBackground(Color.green);B13.setBackground(Color.green);B17.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[21].equals(p2)&&g[9].equals(p2)&&g[13].equals(p2)&&g[17].equals(p2))
		{
			B21.setBackground(Color.green);B9.setBackground(Color.green);B13.setBackground(Color.green);B17.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[10].equals(p1)&&g[14].equals(p1)&&g[18].equals(p1)&&g[22].equals(p1))
		{
			B10.setBackground(Color.green);B14.setBackground(Color.green);B18.setBackground(Color.green);B22.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[10].equals(p2)&&g[14].equals(p2)&&g[18].equals(p2)&&g[22].equals(p2))
		{
			B10.setBackground(Color.green);B14.setBackground(Color.green);B18.setBackground(Color.green);B22.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[2].equals(p1)&&g[14].equals(p1)&&g[8].equals(p1)&&g[20].equals(p1))
		{
			B2.setBackground(Color.green);B14.setBackground(Color.green);B8.setBackground(Color.green);B20.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[2].equals(p2)&&g[14].equals(p2)&&g[8].equals(p2)&&g[20].equals(p2))
		{
			B2.setBackground(Color.green);B14.setBackground(Color.green);B8.setBackground(Color.green);B20.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[1].equals(p1)&&g[7].equals(p1)&&g[13].equals(p1)&&g[19].equals(p1))
		{
			B1.setBackground(Color.green);B7.setBackground(Color.green);B13.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[1].equals(p2)&&g[7].equals(p2)&&g[13].equals(p2)&&g[19].equals(p2))
		{
			B1.setBackground(Color.green);B7.setBackground(Color.green);B13.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[25].equals(p1)&&g[7].equals(p1)&&g[13].equals(p1)&&g[19].equals(p1))
		{
			B25.setBackground(Color.green);B7.setBackground(Color.green);B13.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[25].equals(p2)&&g[7].equals(p2)&&g[13].equals(p2)&&g[19].equals(p2))
		{
			B25.setBackground(Color.green);B7.setBackground(Color.green);B13.setBackground(Color.green);B19.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name2+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p2win++;
		}
		else if(g[6].equals(p1)&&g[12].equals(p1)&&g[18].equals(p1)&&g[24].equals(p1))
		{
			B6.setBackground(Color.green);B12.setBackground(Color.green);B18.setBackground(Color.green);B24.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, name1+" Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[6].equals(p2)&&g[12].equals(p2)&&g[18].equals(p2)&&g[24].equals(p2))
		{
			B6.setBackground(Color.green);B12.setBackground(Color.green);B18.setBackground(Color.green);B24.setBackground(Color.green);
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
				B9.setEnabled(false);
				B10.setEnabled(false);
				B11.setEnabled(false);
				B12.setEnabled(false);
				B13.setEnabled(false);
				B14.setEnabled(false);
				B15.setEnabled(false);
				B16.setEnabled(false);
				B17.setEnabled(false);
				B18.setEnabled(false);
				B19.setEnabled(false);
				B20.setEnabled(false);
				B21.setEnabled(false);
				B22.setEnabled(false);
				B23.setEnabled(false);
				B24.setEnabled(false);
				B25.setEnabled(false);
				p1wins.setText(name1+" Wins:"+Integer.toString(p1win));
				p2wins.setText(name2+" Wins:"+Integer.toString(p2win));
				Draw.setText("Draw:"+Integer.toString(draw));
				Align.setEnabled(true);CName.setEnabled(true);
			}	
			
			else if(t==26)
			{
				draw++;win=true;
				JOptionPane.showMessageDialog( this, "This round is a draw", "", JOptionPane.NO_OPTION);
				p1wins.setText(name1+" Wins:"+Integer.toString(p1win));
				p2wins.setText(name2+" Wins:"+Integer.toString(p2win));
				Draw.setText("Draw:"+Integer.toString(draw));
				Align.setEnabled(true);CName.setEnabled(true);
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
	public void mouseEntered(MouseEvent me)
	{
	}
	public void mouseExited(MouseEvent me)
	{
	}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
}