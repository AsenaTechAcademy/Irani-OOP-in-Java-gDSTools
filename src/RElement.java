import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;


public class RElement extends JComponent implements MouseListener, MouseMotionListener, KeyListener, FocusListener
{
	private JLabel		text;
	private final int	right			=20;
	
	private int			px				=-1, py=-1;
	private int			key1			=-1;
	private int			key2			=-1;
	
	
	private RConnector	Connectors[]	=new RConnector[20];
	private int			cConnectors		=0;
	
	public void AddConnector(RConnector newConnector)
	{
		Connectors[cConnectors++]=newConnector;
	}
	
	private void ChangeElement()
	{
		for (int i=0; i<cConnectors; i++)
			Connectors[i].repaint();
	}
	
	public RElement(String Name, int x, int y)
	{
		super();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addFocusListener(this);
		this.setBounds(x, y, 80, 40);
		this.setLayout(null);
		this.setEnabled(true);
		
		text=new JLabel(Name);
		text.setBounds(0, 0, getWidth()-right, getHeight());
		text.setText("<html><p align=center>"+Name+"</p></html>");
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVerticalAlignment(JLabel.CENTER);
		this.add(text);
	}
	
	public void setSize(int width, int height)
	{
		if (width>=40&&width<=200)
		{
			super.setSize(width, getHeight());
			text.setSize(getWidth()-right, getHeight());
		}
		if (height>=30&&height<=200)
		{
			super.setSize(getWidth(), height);
			text.setSize(getWidth()-right, getHeight());
		}
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(new Color(230, 230, 100));
		g.fillRect(0, 0, getWidth()-1, getHeight()-1);
		
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		g.drawLine(getWidth()-right, 0, getWidth()-right, getHeight());
		
		if (hasFocus())
		{
			g.setColor(Color.red);
			g.drawRect(1, 1, getWidth()-3, getHeight()-3);
			g.drawRect(2, 2, getWidth()-5, getHeight()-5);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		//move
		if (key1==-1)
		{
			int newX=getX()+e.getX()-px;
			newX=newX-(newX%10);
			
			int newY=getY()+e.getY()-py;
			newY=newY-(newY%10);
			
			setLocation(newX, newY);
			ChangeElement();
		}
		
		//resize
		if (key1!=-1&&key1==KeyEvent.VK_SHIFT)
		{
			setSize(getWidth()-(px-e.getX())/10, getHeight()-(py-e.getY())/10);
			ChangeElement();
		}
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		ConnectorHelper.setSelectedElement(this);
		
		px=e.getX();
		py=e.getY();
		
		requestFocus();
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		key1=e.getKeyCode();
		
		/*		if (e.getKeyCode()==KeyEvent.VK_CONTROL)
				{
					key1=e.getKeyCode();
					key2=-1;
				}
				
				if (e.getKeyCode()!=KeyEvent.VK_CONTROL&&key1==KeyEvent.VK_CONTROL)
				{
					key2=e.getKeyCode();
				}
				
				if (e.getKeyCode()!=KeyEvent.VK_CONTROL&&key1==-1)
				{
					key1=e.getKeyCode();
					key2=-1;
				}
		*/
		
		if (key1==KeyEvent.VK_RIGHT)
			this.setLocation(this.getX()+10, getY());
		
		if (key1==KeyEvent.VK_LEFT)
			this.setLocation(this.getX()-10, getY());
		
		if (key1==KeyEvent.VK_UP)
			this.setLocation(this.getX(), getY()-10);
		
		if (key1==KeyEvent.VK_DOWN)
			this.setLocation(this.getX(), getY()+10);
		
		
		
		if (key1==KeyEvent.VK_CONTROL||key1==KeyEvent.VK_CONTROL)
			for (int i=0; i<this.getParent().getComponentCount(); i++)
			{
				if (this.getParent().getComponent(i)==this)
				{
					int x=-1;
					if (key1==KeyEvent.VK_CONTROL)
						x=(i+1==this.getParent().getComponentCount() ? 0 : i+1);
					else if (key1==KeyEvent.VK_CONTROL)
						x=(i-1==-1 ? this.getParent().getComponentCount()-1 : i-1);
					
					
					if (x!=-1)
						this.getParent().getComponent(x).requestFocus();
					break;
				}
			}//for
	}// keypressed
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		key1=-1;
		/*		if (key1==e.getKeyCode())
				{
					key1=-1;
					key2=-1;
				}
				else if (key2==e.getKeyCode())
					key2=-1;
		*/}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
	
	@Override
	public void focusGained(FocusEvent arg0)
	{
		repaint();
	}
	
	@Override
	public void focusLost(FocusEvent arg0)
	{
		repaint();
	}
	
	public int getRight()
	{
		return right;
	}
	
	
}// End of Class
