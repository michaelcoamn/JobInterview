package commandExecutor;

public abstract class Command 
{
	protected String[] m_params;
	
	public Command(String[] params) 
	{
		m_params = params;
	}
	
	public abstract boolean validate();
	
	public String[] getParams()
	{
		return m_params;
	}
}
