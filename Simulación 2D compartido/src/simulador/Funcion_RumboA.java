package simulador;

public class Funcion_RumboA extends Funcion
{
	public Funcion_RumboA()
	{
		super("rumbo_a");
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
		
		Double angulo = Math.toDegrees(Math.atan2( destino_x.obtenerDato() - origen_x.obtenerDato(),	origen_y.obtenerDato() - destino_y.obtenerDato()));
		if (angulo > 360.0)	angulo = angulo - 360;
		else if (angulo < 0.0)	angulo = angulo + 360;
		
		return new Decimal(angulo);
	}
	
	public String tipoDeDato()
	{
		return "rumbo_a";
	}
	
	public String toString()
	{
		return "Funcion: " + this.tipoDeDato() + ", Nombre: " +  this.obtenerNombre();
	}
}
