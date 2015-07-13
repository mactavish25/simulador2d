package simulador;

public class Forma extends TiposDeDatos
{
	private byte forma;
	public static byte RECTANGULO = 0;
	public static byte OVALO = 1;
	public static byte TRIANGULO = 2;
	
	public Forma(String nombre, String forma)
	{
		super(nombre);
		this.forma = convertirCadenaForma(forma);
	}
	
	public Forma(String forma)
	{
		this.forma = convertirCadenaForma(forma);
	}
	
	public Forma(String nombre, byte forma)
	{
		super(nombre);
		this.forma = forma;
	}
	
	public Forma(byte forma)
	{
		this.forma = forma;
	}
	
	public Forma operacionAsignar(TiposDeDatos dato)
	{
		if(dato instanceof Forma)
		{
			this.forma = ((Forma)dato).obtenerDato();
			return this;
		}
		dato.error(" la variable " + dato.obtenerNombre() + " no es de tipo Forma, es " + dato.tipoDeDato());
		return null;
	}
	
	public Forma copiar()
	{
		return new Forma(this.obtenerNombre(), this.obtenerDato());
	}
	
	private byte convertirCadenaForma(String forma)
	{
		if(forma.equalsIgnoreCase("rectangulo")) return RECTANGULO;
		else if(forma.equalsIgnoreCase("ovalo")) return OVALO;
		else if(forma.equalsIgnoreCase("triangulo")) return TRIANGULO;
		else
		{
			//Forma por defecto si se ingresa mal es el rectangulo
			Mensaje.imprimir("No se reconoce la forma \""+forma+"\"", Mensaje.ERROR);
			return RECTANGULO;
		}
	}
	
	//Operadores Logicos
	public Logico compararIgual(TiposDeDatos dato)
	{
		if(dato instanceof Forma)
		{
			return new Logico(this.forma == ((Forma)dato).obtenerDato());
		}
		dato.error(" no se puede comparar " + dato.obtenerNombre() + " no es de tipo Forma, es " + dato.tipoDeDato());
		return null;
	}
	
	public Logico compararDistinto(TiposDeDatos dato)
	{
		if(dato instanceof Forma)
		{
			return new Logico(this.forma != ((Forma)dato).obtenerDato());
		}
		dato.error(" no se puede comparar " + dato.obtenerNombre() + " no es de tipo Forma, es " + dato.tipoDeDato());
		return null;
	}
	
	public boolean esRectangulo()
	{
		if(this.forma == RECTANGULO) return true;
		return false;
	}
	
	public boolean esOvalo()
	{
		if(this.forma == OVALO) return true;
		return false;
	}
	
	public boolean esTriangulo()
	{
		if(this.forma == TRIANGULO) return true;
		return false;
	}
	
	public byte obtenerDato()
	{
		return this.forma;
	}
	
	public void establecerForma(byte forma)
	{
		this.forma = forma;
	}
	
	public void establecerForma(String forma)
	{
		this.forma = convertirCadenaForma(forma);
	}
	
	public String tipoDeDato()
	{
		return "forma";
	}
	
	public String toString()
	{
		if(this.obtenerDato() == Forma.RECTANGULO)
			return "Tipo de dato: " + this.tipoDeDato() + ", Nombre de la variable: " +  this.obtenerNombre() + " = rectangulo";
		else if(this.obtenerDato() == Forma.OVALO)
			return "Tipo de dato: " + this.tipoDeDato() + ", Nombre de la variable: " +  this.obtenerNombre() + " = ovalo";
		else if(this.obtenerDato() == Forma.TRIANGULO)
			return "Tipo de dato: " + this.tipoDeDato() + ", Nombre de la variable: " +  this.obtenerNombre() + " = triangulo";
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
