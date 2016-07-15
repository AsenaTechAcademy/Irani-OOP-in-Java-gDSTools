import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class TPanel extends JPanel
{
	private JButton			Tools1;
	private JButton			Tools2;
	private static Diagram	d;
	
	public TPanel(Diagram dd)
	{
		super();
		
		this.d=dd;
		this.setBounds(0, 0, 100, 600);
		this.setPreferredSize(new Dimension(120, 600));
		this.setOpaque(true);
		this.setBackground(Color.cyan);
		
		
		Tools1=new JButton("Add Element");
		Tools1.setPreferredSize(new Dimension(115, 30));
		Tools1.setFont(new Font("Tahoma", 10, 10));
		Tools1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				AddNewElement();
			}
		});
		this.add(Tools1);
		
		Tools2=new JButton("Add Connector");
		Tools2.setPreferredSize(new Dimension(115, 30));
		Tools2.setFont(new Font("Tahoma", 10, 10));
		Tools2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				ConnectorHelper.isWaitingforSourceTarget=true;
			}
		});
		this.add(Tools2);
	}
	
	public static void AddNewConnector(RConnector e)
	{
		d.add(e);
		d.repaint();
	}
	
	private void AddNewElement()
	{
		RElement x=new RElement("new RElement", 50, 50);
		d.add(x);
		d.repaint();
	}
	
}
