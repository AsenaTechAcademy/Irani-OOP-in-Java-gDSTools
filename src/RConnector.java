import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;


public class RConnector extends JComponent implements MouseListener, MouseMotionListener, KeyListener, FocusListener
{
	private int	px	=-1, py=-1;
	private int	key	=-1;
	private RElement	_source, _target;
	private int			x1, y1, xn, yn;
	
	public RConnector(RElement Source, RElement Target)
	{
		super();
		
		_source=Source;
		_target=Target;
		
		_source.AddConnector(this);
		_target.AddConnector(this);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addFocusListener(this);
		
		this.setBounds(0, 0, 5000, 5000);
		
		this.setLayout(null);
		this.setEnabled(true);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		x1=_source.getX()+_source.getWidth()-_source.getRight()/2;
		y1=_source.getY()+_source.getHeight()/2;
		xn=_target.getX();
		yn=_target.getY()+_target.getHeight()/2;
		
		Graphics2D g2=(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		g.setColor(Color.black);
		g.drawLine(x1, y1, xn, yn);
		
		
		if (hasFocus())
		{
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			final float dash1[]= { 5.0f };
			final BasicStroke dashed=new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
			g2.setStroke(dashed);
			
			g.setColor(Color.yellow);
			g.drawLine(x1, y1, xn, yn);
		}
	}
	
	@Override
	public boolean contains(int x, int y)
	{
		int d=GMath.getPointLineDistance(x, y, x1, y1, xn, yn);
		
		if (d<=5)
			if (x>=Math.min(x1, xn)&&x<=Math.max(x1, xn)&&y>=Math.min(y1, yn)&&y<=Math.max(y1, yn))
				return true;
		
		return false;
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		
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
		key=e.getKeyCode();
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		key=-1;
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		key=e.getKeyCode();
		
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
	
	
	
}// End of Class
