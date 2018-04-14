import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class Fool extends JFrame implements ActionListener, MouseListener
{
	private JLabel LabelTitle_cmnt;
	private JLabel LabelTitle;
	private JButton ButtonYes;
	private JButton ButtonNo;
	private JPanel PanelForm1;
	public Random no; 
	public Fool()
	{
		
		super("Fool");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelForm1 = new JPanel();
		PanelForm1.setLayout(null);
		
		LabelTitle = new JLabel("ARE YOU A FOOL???");
		LabelTitle.setBounds(150, 100, 200, 50);
		PanelForm1.add(LabelTitle);
		
		LabelTitle_cmnt = new JLabel();
		LabelTitle_cmnt.setBounds(150, 370, 200, 50);
		PanelForm1.add(LabelTitle_cmnt);
		
		ButtonYes = new JButton("Yes");
		ButtonYes.setBounds(120, 200, 80, 80);
		ButtonYes.addActionListener(this);
		//ButtonYes.addMouseListener(this);
		PanelForm1.add(ButtonYes);
		
		ButtonNo = new JButton("No");
		ButtonNo.setBounds(220, 200, 80, 80);
		ButtonNo.addActionListener(this);
		ButtonNo.addMouseListener(this);
		PanelForm1.add(ButtonNo);
		no=new Random();
		this.add(PanelForm1);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		if(str.equals("Yes"))
		{
			LabelTitle_cmnt.setText("YOU ARE A FOOL!!!");
		}
		else 
		{
			LabelTitle_cmnt.setText("YOU ARE NOT A FOOL!!!");
		}
		
	}
	public void mouseEntered(MouseEvent me)
	{
		int x,y;
		x=no.nextInt(280);
		y=no.nextInt(280);
		ButtonNo.setBounds(x+80, y, 80, 80);
	
	}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
}