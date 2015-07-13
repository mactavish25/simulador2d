package simulador;

public class Funcion extends TiposDeDatos
{
	public Funcion(String nombre)
	{
		super(nombre);
	}
	
	public TiposDeDatos ejecutar(TablaDatos tabla, TiposDeDatos datos[])
	{
		Mensaje.imprimir("Al ejecutar la funcion " + this.obtenerNombre() + ", no esta definida", Mensaje.ERROR);
		return null;
	}
	
	public String tipoDeDato()
	{
		return "funcion";
	}
	
	public String toString()
	{
		return "Funcion: " + this.tipoDeDato() + ", Nombre: " +  this.obtenerNombre();
	}
}
