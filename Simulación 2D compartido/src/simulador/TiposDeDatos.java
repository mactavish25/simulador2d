package simulador;

public class TiposDeDatos
{
	private String nombre;
	
	//Constructores
	public TiposDeDatos()
	{
		this.establecerNombre(null);
	}
	
	public TiposDeDatos(String nombre)
	{
		this.establecerNombre(nombre);
	}
	
	//Obtener y establecer datos
	public void establecerNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String obtenerNombre()
	{
		return this.nombre;
	}
	
	//Funcioines
	public TiposDeDatos copiar()
	{
		return new TiposDeDatos(this.obtenerNombre());
	}
	
	public void error(String error)
	{
		System.out.println("Error tipo de dato: " + error);
	}
	
	public String tipoDeDato()
	{
		return "desconocido";
	}
	
	public String toString()
	{
		return "Tipo de dato: " + this.tipoDeDato() + ", Nombre de la variable: " +  this.obtenerNombre();
	}
}
