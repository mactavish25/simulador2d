package simulador;

import java.awt.Color;

public class Tinte extends TiposDeDatos
{
	private Color color;
	
	public Tinte(String nombre, String color)
	{
		super(nombre);
		this.color = convertirCadenaColor(color);
	}
	
	public Tinte(String color)
	{
		this.color = convertirCadenaColor(color);
	}
	
	public Tinte(String nombre, Color color)
	{
		super(nombre);
		this.color = color;
	}
	
	public Tinte(Color color)
	{
		
		this.color = color;
	}
	
	private Color convertirCadenaColor(String color)
	{
		if(color.equalsIgnoreCase("rojo")) return Color.RED;
		else if(color.equalsIgnoreCase("azul")) return Color.BLUE;
		else if(color.equalsIgnoreCase("verde")) return Color.GREEN;
		else if(color.equalsIgnoreCase("amarillo")) return Color.YELLOW;
		else if(color.equalsIgnoreCase("cian")) return Color.CYAN;
		else if(color.equalsIgnoreCase("magenta")) return Color.MAGENTA;
		else if(color.equalsIgnoreCase("rosado")) return Color.PINK;
		else if(color.equalsIgnoreCase("naranja")) return Color.ORANGE;
		else if(color.equalsIgnoreCase("gris")) return Color.GRAY;
		else if(color.equalsIgnoreCase("negro")) return Color.BLACK;
		Mensaje.imprimir("El color "+color+" no esta dsponible", Mensaje.ERROR);
		return Color.BLACK;
	}
	
	public Tinte operacionAsignar(TiposDeDatos dato)
	{
		if(dato instanceof Tinte)
		{
			this.color = ((Tinte)dato).obtenerDato();
			return this;
		}
		dato.error(" la variable " + dato.obtenerNombre() + " no es de tipo Tinte, es " + dato.tipoDeDato());
		return null;
	}
	
	public Tinte copiar()
	{
		return new Tinte(this.obtenerNombre(), this.obtenerDato());
	}
	
	//Operadores Logicos
	public Logico compararIgual(TiposDeDatos dato)
	{
		if(dato instanceof Tinte)
		{
			return new Logico(this.color == ((Tinte)dato).obtenerDato());
		}
		dato.error(" no se puede comparar " + dato.obtenerNombre() + " no es de tipo Tinte, es " + dato.tipoDeDato());
		return null;
	}
	
	public Logico compararDistinto(TiposDeDatos dato)
	{
		if(dato instanceof Tinte)
		{
			return new Logico(this.color != ((Tinte)dato).obtenerDato());
		}
		dato.error(" no se puede comparar " + dato.obtenerNombre() + " no es de tipo Tinte, es " + dato.tipoDeDato());
		return null;
	}
	
	public Color obtenerDato()
	{
		return this.color;
	}
	
	public void establecerColor(String color)
	{
		this.color = convertirCadenaColor(color);
	}
	
	public void establecerColor(Color color)
	{
		this.color = color;
	}
	
	public String tipoDeDato()
	{
		return "color";
	}
	
	public String toString()
	{
		return "Tipo de dato: " + this.tipoDeDato() + ", Nombre de la variable: " +  this.obtenerNombre() + " = " + this.obtenerDato();
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
