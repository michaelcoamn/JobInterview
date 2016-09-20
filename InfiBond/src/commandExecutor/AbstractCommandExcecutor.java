package commandExecutor;
import input.IInputListener;

public abstract class AbstractCommandExcecutor implements IInputListener<Command>
{
	@Override
	public void onInputRecieved(Command model) 
	{
		if(model.validate())
		{
			activateCommand(model);
		}
		else
		{
			// TODO: log
		}
	}
	
	protected abstract void activateCommand(Command command);
}