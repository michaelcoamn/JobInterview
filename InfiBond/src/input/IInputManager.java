package input;
import observer.ISubject;

public interface IInputManager<Model> extends ISubject<Model, IInputListener<Model>>
{
	public void start();
}
