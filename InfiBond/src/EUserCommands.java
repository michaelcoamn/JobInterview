import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import commandExecutor.Command;
import modelGenerator.IModelGenerator;

public enum EUserCommands 
{
	ALL("all")
	{
		@Override
		protected Command generateCommand(String[] vairables)
		{
			return new AllCommand(vairables);
		}
	},
	SPECIFIC("get")
	{
		@Override
		protected Command generateCommand(String[] vairables) {
			return new SpecificCommand(vairables);
		}
	};
	protected String m_commandName;
	
	private EUserCommands(String name) 
	{
		m_commandName = name;
	}
	
	protected Command generateCommand(String[] vairables)
	{
		return null;
	}
	
	private static Map<String, EUserCommands> m_commandsMap;
	private static IModelGenerator<String, Command> m_modelGenerator;
	
	static 
	{
		m_modelGenerator = new UserCommandsModelGenerator();
		m_commandsMap = new HashMap<>();

		for(EUserCommands command : values())
		{
			m_commandsMap.put(command.m_commandName.toLowerCase(), command);
		}
	}
	
	public static  IModelGenerator<String, Command> getModelGenerator()
	{
		return m_modelGenerator;
	}
	
	private static class UserCommandsModelGenerator implements IModelGenerator<String, Command>
	{
		@Override
		public Command generateModel(String input) 
		{
			String[] data = input.split(" ");
			String command = data[0];
			Command retVal = null;
			
			EUserCommands generator = m_commandsMap.get(command.toLowerCase());
			
			if(generator != null)
			{
				String[] parameters = null;
				
				if(data.length > 1)
				{
					parameters = Arrays.copyOfRange(data, 1, data.length);
				}
				
				retVal = generator.generateCommand(parameters);
			}
			
			return retVal;
		}
	}
	
}
