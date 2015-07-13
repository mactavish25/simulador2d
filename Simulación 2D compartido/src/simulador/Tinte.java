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
	
	public Tinte asignar(TiposDeDatos dato)
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
	public Logico operadorIgual(TiposDeDatos dato)
	{
		if(dato instanceof Tinte)
		{
			return new Logico(this.color == ((Tinte)dato).obtenerDato());
		}
		dato.error(" no se puede comparar " + dato.obtenerNombre() + " no es de tipo Tinte, es " + dato.tipoDeDato());
		return null;
	}
	
	public Logico operadorDistinto(TiposDeDatos dato)
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
}
