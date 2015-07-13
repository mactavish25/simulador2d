package simulador;

public class Funcion_Arccoseno extends Funcion
{
	public Funcion_Arccoseno()
	{
		super("arccoseno");
	}
	
	public TiposDeDatos ejecutar(TablaDatos tabla, TiposDeDatos datos[])
	{
		Mensaje.imprimir("Ejecutando la función " + this.obtenerNombre(), Mensaje.TRAZA);
		if(datos.length != 1)
		{
			Mensaje.imprimir("Se esperaba 1 argumento pero se recivieron " + datos.length + "argumentos", Mensaje.ERROR);
			return null;
		}
		float valor;
		if(datos[0] instanceof Entero)	valor = ((Entero)datos[0]).obtenerDato();
		else if(datos[0] instanceof Decimal) valor =((Decimal)datos[0]).obtenerDato();
		else
		{
			Mensaje.imprimir("Tipo de dato invalido, se esperava un numero en la funcion " + this.obtenerNombre(), Mensaje.ERROR);
			return null;
		}

		return new Decimal(Math.toDegrees(Math.acos(valor)));
	}
	
	public String tipoDeDato()
	{
		return "arccoseno";
	}
	
	public String toString()
	{
		return "Funcion: " + this.tipoDeDato() + ", Nombre: " +  this.obtenerNombre();
	}
}
