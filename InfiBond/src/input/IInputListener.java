package input;
import observer.IListener;

public interface IInputListener<Model> extends IListener<Model> 
{
	public void onInputRecieved(Model model);
}
