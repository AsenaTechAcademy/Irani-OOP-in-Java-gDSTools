import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;


public class Diagram extends JComponent implements MouseListener, MouseMotionListener
{
	public Diagram()
	{
		super();
		this.setBounds(0, 0, 800, 600);
		this.setPreferredSize(new Dimension(800, 600));
		this.setLayout(null);
		this.setEnabled(true);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		/*		g.setColor(Color.lightGray);
				g.fillRect(0, 0, getWidth()-1, getHeight()-1);
		*/
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
	}
	
	
	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		requestFocus();
	}
	
	
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
