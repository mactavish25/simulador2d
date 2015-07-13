package simulador;

public class Funcion_DistanciaA extends Funcion
{
	public Funcion_DistanciaA()
	{
		super("distancia_a");
	}
	
	public TiposDeDatos ejecutar(TablaDatos tabla, TiposDeDatos datos[])
	{
		Mensaje.imprimir("Ejecutando la función " + this.obtenerNombre(), Mensaje.TRAZA);
		if(datos.length != 1)
		{
			Mensaje.imprimir("Se esperaba 1 argumento pero se recivieron " + datos.length + "argumentos", Mensaje.ERROR);
			return null;
		}
		if(!(datos[0] instanceof Objeto))
		{
			Mensaje.imprimir("El argumento de "+ this.obtenerNombre() + " no es un objeto",Mensaje.ERROR);
			return null;
		}
		
		//Obtiene las coordenadas del objeto de origen
		Decimal origen_x = (Decimal)tabla.obtener("posicion_x");
		Decimal origen_y = (Decimal)tabla.obtener("posicion_y");
		
		//Obtiene las coordenadas del objeto de destino
		Objeto destino = (Objeto)datos[0];
		Decimal destino_x = (Decimal)destino.obtenerAtributo("posicion_x");
		Decimal destino_y = (Decimal)destino.obtenerAtributo("posicion_y");
		return new Decimal(Math.pow(Math.pow(destino_y.obtenerDato() - origen_y.obtenerDato(), 2) + Math.pow(destino_x.obtenerDato() - origen_x.obtenerDato(), 2), 0.5)); 
	}
	
	public String tipoDeDato()
	{
		return "distancia_a";
	}
	
	public String toString()
	{
		return "Funcion: " + this.tipoDeDato() + ", Nombre: " +  this.obtenerNombre();
	}
}
