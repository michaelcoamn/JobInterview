import commandExecutor.Command;

public class AllCommand extends Command {

	public AllCommand(String[] params) {
		super(params);
	}

	@Override
	public boolean validate() {
		return true;
	}

}
