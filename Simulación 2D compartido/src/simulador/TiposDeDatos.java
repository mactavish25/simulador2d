package simulador;

public abstract class TiposDeDatos
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
	
	
	
	public void error(String error)
	{
		System.out.println("Error tipo de dato: " + error);
	}
	
	//Funcioines Abstractas
	public abstract TiposDeDatos operacionAsignar(TiposDeDatos dato);
	public abstract TiposDeDatos operacionSuma(TiposDeDatos dato);
	public abstract TiposDeDatos operacionResta(TiposDeDatos dato);
	public abstract TiposDeDatos operacionMultiplicar(TiposDeDatos dato);
	public abstract TiposDeDatos operacionDividir(TiposDeDatos dato);
	public abstract TiposDeDatos operacionModulo(TiposDeDatos dato);
	public abstract TiposDeDatos operacionNegado();
	public abstract TiposDeDatos compararIgual(TiposDeDatos dato);
	public abstract TiposDeDatos compararDistinto(TiposDeDatos dato);
	public abstract TiposDeDatos compararMayor(TiposDeDatos datos);
	public abstract TiposDeDatos compararMayorIgual(TiposDeDatos datos);
	public abstract TiposDeDatos compararMenor(TiposDeDatos datos);
	public abstract TiposDeDatos compararMenorIgual(TiposDeDatos datos);
	public abstract TiposDeDatos copiar();
	public abstract String tipoDeDato();
	
	public String toString()
	{
		return "Tipo de dato: " + this.tipoDeDato() + ", Nombre de la variable: " +  this.obtenerNombre();
	}
}
