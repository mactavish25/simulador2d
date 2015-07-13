package simulador;

public class Logico extends TiposDeDatos
{
	private boolean valor;
	
	public Logico(String nombre, boolean valor)
	{
		super(nombre);
		this.valor = valor;
	}
	
	public Logico(boolean valor)
	{
		this.valor = valor;
	}
	
	public Logico asignar(TiposDeDatos dato)
	{
		if(dato instanceof Logico)
		{
			this.valor = ((Logico)dato).obtenerDato();
			return this;
		}
		dato.error(" la variable " + dato.obtenerNombre() + " no es de tipo Logico, es " + dato.tipoDeDato());
		return null;
	}
	
	public Logico copiar()
	{
		return new Logico(this.obtenerNombre(),this.obtenerDato());
	}
	
	public Logico asignar(Logico dato)
	{
		this.valor = dato.obtenerDato();
		return this;
	}
	
	//Operadores Logicos
	public Logico operadorY(TiposDeDatos dato)
	{
		if(dato instanceof Logico)
		{
			return new Logico(this.valor && ((Logico)dato).obtenerDato());
		}
		dato.error(" en operador Y " + dato.obtenerNombre() + " no es de tipo Logico, es " + dato.tipoDeDato());
		return this;
	}
	
	public Logico operadorO(TiposDeDatos dato)
	{
		if(dato instanceof Logico)
		{
			return new Logico(this.valor || ((Logico)dato).obtenerDato());
		}
		dato.error(" en operador O " + dato.obtenerNombre() + " no es de tipo Logico, es " + dato.tipoDeDato());
		return this;
	}
	
	public Logico operadorIgual(TiposDeDatos dato)
	{
		if(dato instanceof Logico)
		{
			return new Logico((this.valor && ((Logico)dato).obtenerDato()) || (!this.valor && !((Logico)dato).obtenerDato()));
		}
		dato.error(" en esIgual " + dato.obtenerNombre() + " no es de tipo Logico, es " + dato.tipoDeDato());
		return this;
	}
	
	public Logico operadorDistinto(TiposDeDatos dato)
	{
		if(dato instanceof Logico)
		{
			return new Logico((!this.valor && ((Logico)dato).obtenerDato()) || (this.valor && !((Logico)dato).obtenerDato()));
		}
		dato.error(" en esIgual " + dato.obtenerNombre() + " no es de tipo Logico, es " + dato.tipoDeDato());
		return this;
	}
	
	public Logico operadorNegado()
	{
		return new Logico(this.obtenerNombre(), !this.obtenerDato());
	}
	
	public boolean obtenerDato()
	{
		return this.valor;
	}
	
	public String tipoDeDato()
	{
		return "logico";
	}
	
	public String toString()
	{
		return "Tipo de dato: " + this.tipoDeDato() + ", Nombre de la variable: " +  this.obtenerNombre() + " = " + this.obtenerDato();
	}
}
