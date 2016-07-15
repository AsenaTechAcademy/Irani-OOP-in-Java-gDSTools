public class ConnectorHelper
{
	public static boolean	isWaitingforSourceTarget	=false;
	private static RElement	_source						=null;
	private static RElement	_target						=null;
	
	
	public static void setSelectedElement(RElement e)
	{
		if (!isWaitingforSourceTarget)
			return;
		
		if (_source==null)
			_source=e;
		
		else if (_source!=null&&_target==null)
		{
			_target=e;
			isWaitingforSourceTarget=false;
			
			RConnector ee=new RConnector(_source, _target);
			TPanel.AddNewConnector(ee);
			
			_source=null;
			_target=null;
		}
	}
}
