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
	
	public Logico operacionAsignar(TiposDeDatos dato)
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
	
	public Logico operacionAsignar(Logico dato)
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
	
	public Logico compararIgual(TiposDeDatos dato)
	{
		if(dato instanceof Logico)
		{
			return new Logico((this.valor && ((Logico)dato).obtenerDato()) || (!this.valor && !((Logico)dato).obtenerDato()));
		}
		dato.error(" en esIgual " + dato.obtenerNombre() + " no es de tipo Logico, es " + dato.tipoDeDato());
		return this;
	}
	
	public Logico compararDistinto(TiposDeDatos dato)
	{
		if(dato instanceof Logico)
		{
			return new Logico((!this.valor && ((Logico)dato).obtenerDato()) || (this.valor && !((Logico)dato).obtenerDato()));
		}
		dato.error(" en esIgual " + dato.obtenerNombre() + " no es de tipo Logico, es " + dato.tipoDeDato());
		return this;
	}
	
	public Logico operacionNegado()
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
