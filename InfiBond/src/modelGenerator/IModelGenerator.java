package modelGenerator;

public interface IModelGenerator <Input, Model>
{
	public Model generateModel(Input input);
}
