package simulador;

public class Entero extends TiposDeDatos
{
	private int numero;
	
	//Constructores
	public Entero(String nombre, int numero)
	{
		super(nombre);
		this.numero = numero;
	}
	
	public Entero(int numero)
	{
		this.numero = numero;
	}
	
	//Operadores Matematicos
	//Asignacion
	public Entero operacionAsignar(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = (int)((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Entero operacionAsignar(Entero dato)
	{
		this.numero = dato.obtenerDato();
		return this;
	}
	
	public Entero operacionAsignar(Decimal dato)
	{
		this.numero = (int)dato.obtenerDato();
		return this;
	}
	
	//Sumar
	public Entero operacionSuma(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = this.numero + ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = this.numero + (int)((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Entero operacionSuma(Entero dato)
	{
		this.numero = this.numero + dato.obtenerDato();
		return this;
	}
	
	public Entero operacionSuma(Decimal dato)
	{
		this.numero = this.numero + (int)dato.obtenerDato();
		return this;
	}
	
	//Resta
	public Entero operacionResta(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = this.numero - ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = this.numero - (int)((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Entero operacionResta(Entero dato)
	{
		this.numero = this.numero - dato.obtenerDato();
		return this;
	}
	
	public Entero operacionResta(Decimal dato)
	{
		this.numero = this.numero - (int)dato.obtenerDato();
		return this;
	}
	
	//Multiplicar
	public Entero operacionMultiplicar(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = this.numero * ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = this.numero * (int)((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Entero operacionMultiplicar(Entero dato)
	{
		this.numero = this.numero * dato.obtenerDato();
		return this;
	}
	
	public Entero operacionMultiplicar(Decimal dato)
	{
		this.numero = this.numero * (int)dato.obtenerDato();
		return this;
	}
	
	//Dividir
	public Entero operacionDividir(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = this.numero / ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = this.numero / (int)((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Entero operacionDividir(Entero dato)
	{
		this.numero = this.numero / dato.obtenerDato();
		return this;
	}
	
	public Entero operacionDividir(Decimal dato)
	{
		this.numero = this.numero / (int)dato.obtenerDato();
		return this;
	}
	
	//Modulo
	public Entero operacionModulo(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = this.numero % ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = this.numero % (int)((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Entero operacionModulo(Entero dato)
	{
		this.numero = this.numero % dato.obtenerDato();
		return this;
	}
	
	public Entero operacionModulo(Decimal dato)
	{
		this.numero = this.numero % (int)dato.obtenerDato();
		return this;
	}
	
	//Negado
	public Entero operacionNegado()
	{
		this.numero = -this.numero;
		return this;
	}
	
	//Operadores Logicos
	public Logico compararIgual(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			return new Logico(this.numero == ((Entero)dato).obtenerDato());
		}
		else if (dato instanceof Decimal)
		{
			return new Logico(this.numero == (int)((Decimal)dato).obtenerDato());
		}
		dato.error(" No se puede comparar " + this.obtenerNombre() + " con " + dato.obtenerNombre() + " son de distintos tipo");
		return null;
	}
	
	public Logico compararDistinto(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			return new Logico(this.numero != ((Entero)dato).obtenerDato());
		}
		else if (dato instanceof Decimal)
		{
			return new Logico(this.numero != (int)((Decimal)dato).obtenerDato());
		}
		dato.error(" No se puede comparar " + this.obtenerNombre() + " con " + dato.obtenerNombre() + " son de distintos tipo");
		return null;
	}
	
	public Logico compararMayor(TiposDeDatos datos)
	{
		if(datos instanceof Entero)
		{
			return new Logico(this.numero > ((Entero)datos).obtenerDato());
		}
		else if (datos instanceof Decimal)
		{
			return new Logico(this.numero > (int)((Decimal)datos).obtenerDato());
		}
		datos.error(" No se puede comparar " + this.obtenerNombre() + " con " + datos.obtenerNombre() + " son de distintos tipo");
		return null;
	}
	
	public Logico compararMayorIgual(TiposDeDatos datos)
	{
		if(datos instanceof Entero)
		{
			return new Logico(this.numero >= ((Entero)datos).obtenerDato());
		}
		else if (datos instanceof Decimal)
		{
			return new Logico(this.numero >= (int)((Decimal)datos).obtenerDato());
		}
		datos.error(" No se puede comparar " + this.obtenerNombre() + " con " + datos.obtenerNombre() + " son de distintos tipo");
		return null;
	}
	
	public Logico compararMenor(TiposDeDatos datos)
	{
		if(datos instanceof Entero)
		{
			return new Logico(this.numero < ((Entero)datos).obtenerDato());
		}
		else if (datos instanceof Decimal)
		{
			return new Logico(this.numero < (int)((Decimal)datos).obtenerDato());
		}
		datos.error(" No se puede comparar " + this.obtenerNombre() + " con " + datos.obtenerNombre() + " son de distintos tipo");
		return null;
	}
	
	public Logico compararMenorIgual(TiposDeDatos datos)
	{
		if(datos instanceof Entero)
		{
			return new Logico(this.numero <= ((Entero)datos).obtenerDato());
		}
		else if (datos instanceof Decimal)
		{
			return new Logico(this.numero <= (int)((Decimal)datos).obtenerDato());
		}
		datos.error(" No se puede comparar " + this.obtenerNombre() + " con " + datos.obtenerNombre() + " son de distintos tipo");
		return null;
	}
	
	//Estatico
	public static int obtenerEntero(Entero dato)
	{
			return ((Entero)dato).obtenerDato();
	}
	
	public Entero copiar()
	{
		return new Entero(this.obtenerNombre(), this.obtenerDato());
	}
	
	public int obtenerDato()
	{
		return this.numero;
	}
	
	public String tipoDeDato()
	{
		return "entero";
	}
	
	public String toString()
	{
		return "Tipo de dato: " + this.tipoDeDato() + ", Nombre de la variable: " +  this.obtenerNombre() + " = " + this.obtenerDato();
	}
}
