import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class Computer extends JFrame implements ActionListener, MouseListener
{
	private JLabel TTT=new JLabel("Tic Tac Toe",JLabel.CENTER);
	private JLabel back=new JLabel("");
	private JLabel Combo_lebel=new JLabel("Select Sign");
	private JLabel turn=new JLabel("",JLabel.CENTER);
	private JLabel p1wins=new JLabel("Player1 Wins:0");
	private JLabel comwins=new JLabel("Computer Wins:0");
	private JLabel Draw=new JLabel("Draw:0");
	private JRadioButton Player1, Computer;
	public JButton Start,B1,B2,B3,B4,B5,B6,B7,B8,B9,PFriend;
	private JPanel PanelForm1;
	private JComboBox combo;
	private ButtonGroup bg1;
	public String g[],p1,p2,name1="Player1",name2="Computer";
	int t=1,p1win=0,comwin=0,draw=0;;
	boolean p=true,win=false;
	public Computer()
	{
		super("Tic Tac Toe");
		this.setSize(600,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		g=new String[10];
		g[0]="abc";g[1]=" ";g[2]=" ";g[3]=" ";g[4]=" ";g[5]=" ";g[6]=" ";g[7]=" ";g[8]=" ";g[9]=" ";
		
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
		
		turn.setBounds(200, 250, 125, 30);
		turn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//turn.setForeground(Color.white);
		PanelForm1.add(turn);
		
		p1wins.setBounds(50, 620, 125, 30);
		p1wins.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//p1wins.setForeground(Color.white);
		//p1wins.setBackground(Color.white);
		PanelForm1.add(p1wins);
		
		comwins.setBounds(420, 620, 135, 30);
		comwins.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//comwins.setForeground(Color.white);
		//comwins.setBackground(Color.white);
		PanelForm1.add(comwins);
		
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
		
		Computer = new JRadioButton(name2);
		Computer.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Computer.setBackground(Color.cyan);
		Computer.setBounds(100,150,100,30);
		PanelForm1.add(Computer);
		
		bg1= new ButtonGroup();
		bg1.add(Player1);
		bg1.add(Computer);
		
		String s[] = {"O", "X"};
		combo = new JComboBox(s);
		combo.setBounds(330, 150, 80, 30);
		combo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PanelForm1.add(combo);
		
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
		
		PFriend = new JButton("Play With Friend");
		PFriend.setBounds(430, 200, 140, 30);
		PFriend.setFont(new Font("", Font.BOLD, 10));
		PFriend.addActionListener(this);
		PanelForm1.add(PFriend);
		
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
		if(str.equals("Play With Friend"))
		{
			new Frame1("Player1","Player2").setVisible(true);
			this.setVisible(false);
		}
		else if(str.equals("Start"))
		{
			String value = combo.getSelectedItem().toString();
			turn.setBackground(Color.white);
			
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
			Computer.setEnabled(false);
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
			Random_turn();
		}
		if(p==true)
		{
			if(source==B1)
			{
				if(g[1]==" ")
				{	
						match_sign_color(B1,p1);
						B1.setText(p1);
						p=false;
						g[1]=p1;
						t++;
						turn.setText("Computer's Turn");
				}
			}
			else if(source==B2)
			{
				if(g[2]==" ")
				{	
					
						match_sign_color(B2,p1);
						B2.setText(p1);
						p=false;
						g[2]=p1;t++;
						turn.setText("Computer's Turn");
				}	
			}
			else if(source==B3)
			{
				if(g[3]==" ")
				{	
					
						match_sign_color(B3,p1);
						B3.setText(p1);
						p=false;
						g[3]=p1;t++;
						turn.setText("Computer's Turn");
				}
			}
			else if(source==B4)
			{
				if(g[4]==" ")
				{	
					
						match_sign_color(B4,p1);
						B4.setText(p1);
						p=false;
						g[4]=p1;t++;
						turn.setText("Computer's Turn");
					
				}
			}
			else if(source==B5)
			{
				if(g[5]==" ")
				{		
					
						match_sign_color(B5,p1);
						B5.setText(p1);
						p=false;
						g[5]=p1;t++;
						turn.setText("Computer's Turn");
				
				}
			}
			else if(source==B6)
			{
				if(g[6]==" ")
				{		
					
						match_sign_color(B6,p1);
						B6.setText(p1);
						p=false;
						g[6]=p1;t++;
						turn.setText("Computer's Turn");
					
				}
			}
			else if(source==B7)
			{
				if(g[7]==" ")
				{		
					
						match_sign_color(B7,p1);
						B7.setText(p1);
						p=false;
						g[7]=p1;t++;
						turn.setText("Computer's Turn");
					
				}
			}
			else if(source==B8)
			{
				if(g[8]==" ")
				{		
					
						match_sign_color(B8,p1);
						B8.setText(p1);
						p=false;
						g[8]=p1;t++;
						turn.setText("Computer's Turn");
					
				}
			}
			else if(source==B9)
			{
				if(g[9]==" ")
				{		
						match_sign_color(B9,p1);
						B9.setText(p1);
						p=false;
						g[9]=p1;t++;
						turn.setText("Computer's Turn");
					
				}
			}
			check_result();
			if(t==10&&win==false)
			{
				win=true;
				draw++;
				JOptionPane.showMessageDialog( this, "This round is a draw", "", JOptionPane.NO_OPTION);
				p1wins.setText("Player1 Wins:"+Integer.toString(p1win));
				comwins.setText("Computer Wins:"+Integer.toString(comwin));
				Draw.setText("Draw:"+Integer.toString(draw));
			}
		}
		
		if(p==false)
		{
			int r=random();
			if(r==1)
			{
				match_sign_color(B1,p2);
				B1.setText(p2);
				p=true;
				g[1]=p2;t++;
				turn.setText("Player1's Turn");
			}
			else if(r==2)
			{
				match_sign_color(B2,p2);
				B2.setText(p2);
				p=true;
				g[2]=p2;t++;
				turn.setText("Player1's Turn");
			}
			else if(r==3)
			{
				match_sign_color(B3,p2);
				B3.setText(p2);
				p=true;
				g[3]=p2;t++;
				turn.setText("Player1's Turn");
			}
			else if(r==4)
			{
				match_sign_color(B4,p2);
				B4.setText(p2);
				p=true;
				g[4]=p2;t++;
				turn.setText("Player1's Turn");
			}
			else if(r==5)
			{
				match_sign_color(B5,p2);
				B5.setText(p2);
				p=true;
				g[5]=p2;t++;
				turn.setText("Player1's Turn");
			}
			else if(r==6)
			{
				match_sign_color(B6,p2);
				B6.setText(p2);
				p=true;
				g[6]=p2;t++;
				turn.setText("Player1's Turn");
			}
			else if(r==7)
			{
				match_sign_color(B7,p2);
				B7.setText(p2);
				p=true;
				g[7]=p2;t++;
				turn.setText("Player1's Turn");
			}
			else if(r==8)
			{
				match_sign_color(B8,p2);
				B8.setText(p2);
				p=true;
				g[8]=p2;t++;
				turn.setText("Player1's Turn");
			}
			else if(r==9)
			{
				match_sign_color(B9,p2);
				B9.setText(p2);
				p=true;
				g[9]=p2;t++;
				turn.setText("Player1's Turn");
			}
			
			if(win==false)
			{
				check_result();
				if(t==10&&win==false)
				{
					draw++;
					JOptionPane.showMessageDialog( this, "This round is a draw", "", JOptionPane.NO_OPTION);
					p1wins.setText("Player1 Wins:"+Integer.toString(p1win));
					comwins.setText("Computer Wins:"+Integer.toString(comwin));
					Draw.setText("Draw:"+Integer.toString(draw));
				}
			}
		}
	}
	public void check_result()
	{
		if(g[1].equals(p1)&&g[2].equals(p1)&&g[3].equals(p1))
		{
			B1.setBackground(Color.green);B2.setBackground(Color.green);B3.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Player1 Won this round", "", JOptionPane.NO_OPTION);;
			win=true;p1win++;
		}
		else if(g[1].equals(p2)&&g[2].equals(p2)&&g[3].equals(p2))
        {
			B1.setBackground(Color.green);B2.setBackground(Color.green);B3.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Computer Won this round", "", JOptionPane.NO_OPTION);
			win=true;comwin++;
		}
		else if(g[4].equals(p1)&&g[5].equals(p1)&&g[6].equals(p1))
        {
			B4.setBackground(Color.green);B5.setBackground(Color.green);B6.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Player1 Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[4].equals(p2)&&g[5].equals(p2)&&g[6].equals(p2))
        {
			B4.setBackground(Color.green);B5.setBackground(Color.green);B6.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Computer Won this round", "", JOptionPane.NO_OPTION);
			win=true;comwin++;
		}
		else if(g[7].equals(p1)&&g[8].equals(p1)&&g[9].equals(p1))
        {
			B7.setBackground(Color.green);B8.setBackground(Color.green);B9.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Player1 Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[7].equals(p2)&&g[8].equals(p2)&&g[9].equals(p2))
        {
			B7.setBackground(Color.green);B8.setBackground(Color.green);B9.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Computer Won this round", "", JOptionPane.NO_OPTION);
			win=true;comwin++;
		}
		else if(g[1].equals(p1)&&g[4].equals(p1)&&g[7].equals(p1))
        {
			B7.setBackground(Color.green);B1.setBackground(Color.green);B4.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Player1 Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[1].equals(p2)&&g[4].equals(p2)&&g[7].equals(p2))
        {
			B7.setBackground(Color.green);B1.setBackground(Color.green);B4.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Computer Won this round", "", JOptionPane.NO_OPTION);
			win=true;comwin++;
		}
		else if(g[2].equals(p1)&&g[5].equals(p1)&&g[8].equals(p1))
        {
			B2.setBackground(Color.green);B5.setBackground(Color.green);B8.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Player1 Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[2].equals(p2)&&g[5].equals(p2)&&g[8].equals(p2))
        {
			B2.setBackground(Color.green);B5.setBackground(Color.green);B8.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Computer Won this round", "", JOptionPane.NO_OPTION);
			win=true;comwin++;
		}
		else if(g[3].equals(p1)&&g[6].equals(p1)&&g[9].equals(p1))
        {
			B3.setBackground(Color.green);B6.setBackground(Color.green);B9.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Player1 Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[3].equals(p2)&&g[6].equals(p2)&&g[9].equals(p2))
        {
			B3.setBackground(Color.green);B6.setBackground(Color.green);B9.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Computer Won this round", "", JOptionPane.NO_OPTION);
			win=true;comwin++;
		}
		else if(g[1].equals(p1)&&g[5].equals(p1)&&g[9].equals(p1))
        {
			B1.setBackground(Color.green);B5.setBackground(Color.green);B9.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Player1 Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[1].equals(p2)&&g[5].equals(p2)&&g[9].equals(p2))
        {
			B1.setBackground(Color.green);B5.setBackground(Color.green);B9.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Computer Won this round", "", JOptionPane.NO_OPTION);
			win=true;comwin++;
		}
		else if(g[3].equals(p1)&&g[5].equals(p1)&&g[7].equals(p1))
        {
			B3.setBackground(Color.green);B5.setBackground(Color.green);B7.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Player1 Won this round", "", JOptionPane.NO_OPTION);
			win=true;p1win++;
		}
		else if(g[3].equals(p2)&&g[5].equals(p2)&&g[7].equals(p2))
        {
			B3.setBackground(Color.green);B5.setBackground(Color.green);B7.setBackground(Color.green);
			JOptionPane.showMessageDialog( this, "Computer Won this round", "", JOptionPane.NO_OPTION);
			win=true;comwin++;
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
			p1wins.setText("Player1 Wins:"+Integer.toString(p1win));
			comwins.setText("Computer Wins:"+Integer.toString(comwin));
			Draw.setText("Draw:"+Integer.toString(draw));
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
	public int random()
	{
		int x=0;
		boolean p=false;
		Random r=new Random();
		while(p==false&&win==false)
		{
			x=r.nextInt(10);
			if(g[x].equals(" "))
			{
				p=true;
			}
		}
		return x;
	}
	public void Random_turn()
	{
		turn.setOpaque(true);
		turn.setBackground(Color.white);
		Random r=new Random();
		int x=r.nextInt(2);
		if(x==0)
		{
			p=true;
			turn.setText("Player1's Turn");
		}
		else
		{
			p=false;
			turn.setText("Player2's Turn");
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