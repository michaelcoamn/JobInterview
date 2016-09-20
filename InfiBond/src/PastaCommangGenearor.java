import java.util.HashMap;
import java.util.Map;

import commandExecutor.AbstractCommandExcecutor;
import commandExecutor.Command;
import output.IOutputManager;

public class PastaCommangGenearor extends AbstractCommandExcecutor{
	private Map<String, String> m_pastas;
	private IOutputManager<String> m_outputManager;
	
	public PastaCommangGenearor(IOutputManager<String> outputManager) 
	{
		m_outputManager = outputManager;
		m_pastas = new HashMap<>();
		m_pastas.put("spagetti", "Good");
		m_pastas.put("raviolli", "ok");
		
	}
	@Override
	protected void activateCommand(Command command)
	{
		if(command instanceof AllCommand)
		{
			m_outputManager.send(m_pastas.toString());
		}
		else if (command instanceof SpecificCommand)
		{
			m_outputManager.send(m_pastas.get(command.getParams()[0]));
		}
	}
}
