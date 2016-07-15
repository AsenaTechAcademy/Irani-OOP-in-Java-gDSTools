import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GMain
{
	public static final int	formWidth	=1000;
	public static final int	formHeight	=650;
	
	private JFrame			frmMain;
	private TPanel			ToolsPanel;
	private Diagram			d;
	
	
	public GMain()
	{
		// frmMain setting
		frmMain=new JFrame();
		frmMain.setTitle("Welcome to MyDSTools 001");
		frmMain.setBounds(10, 10, formWidth, formHeight);
		frmMain.setResizable(false);
		frmMain.setLayout(new FlowLayout());
		frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		/////// Diagram
		/////// Tools
		d=new Diagram();
		ToolsPanel=new TPanel(d);
		
		
		
		frmMain.add(ToolsPanel);
		frmMain.add(d);
		
		RElement e1=new RElement("e1", 100, 100);
		RElement e2=new RElement("e2", 300, 200);
		
		RConnector c1=new RConnector(e1, e2);
		
		d.add(c1);
		d.add(e1);
		d.add(e2);
		
		
		frmMain.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		new GMain();
	}
	
	
}// END of Class GMain
