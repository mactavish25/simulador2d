package simulador;

public class Sim2DExcepcion extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public Sim2DExcepcion(String error)
	{
		System.err.println("Error: "+ error);
	}
}
