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

	@Override
	public TiposDeDatos copiar()
	{
		Mensaje.imprimir("Esta tratando de copiar la funcion " + this.obtenerNombre(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos operacionAsignar(TiposDeDatos dato)
	{
		Mensaje.imprimir("Metodo operacionAsignar no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos operacionSuma(TiposDeDatos dato)
	{
		Mensaje.imprimir("Metodo operacionSuma no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos operacionResta(TiposDeDatos dato)
	{
		Mensaje.imprimir("Metodo operacionResta no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos operacionMultiplicar(TiposDeDatos dato)
	{
		Mensaje.imprimir("Metodo operacionMultiplicar no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos operacionDividir(TiposDeDatos dato)
	{
		Mensaje.imprimir("Metodo operacionDividir no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos operacionModulo(TiposDeDatos dato)
	{
		Mensaje.imprimir("Metodo operacionModulo no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos operacionNegado()
	{
		Mensaje.imprimir("Metodo operacionNegado no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos compararIgual(TiposDeDatos dato)
	{
		Mensaje.imprimir("Metodo compararIgual no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos compararDistinto(TiposDeDatos dato)
	{
		Mensaje.imprimir("Metodo compararDistinto no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos compararMayor(TiposDeDatos datos)
	{
		Mensaje.imprimir("Metodo compararMayor no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos compararMayorIgual(TiposDeDatos datos)
	{
		Mensaje.imprimir("Metodo compararMayorIgual no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos compararMenor(TiposDeDatos datos)
	{
		Mensaje.imprimir("Metodo compararMenor no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}

	@Override
	public TiposDeDatos compararMenorIgual(TiposDeDatos datos)
	{
		Mensaje.imprimir("Metodo compararMenorIgual no aplicable al tipo de dato "+this.tipoDeDato(), Mensaje.ERROR);
		return null;
	}
}
