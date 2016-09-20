import commandExecutor.Command;

public class SpecificCommand extends Command
{
	public SpecificCommand(String[] params) {
		super(params);
	}

	@Override
	public boolean validate() {
		return m_params.length == 1;
	}
	
}
