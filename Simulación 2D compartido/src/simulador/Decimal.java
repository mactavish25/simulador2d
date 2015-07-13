package simulador;

public class Decimal extends TiposDeDatos
{
	private float numero;
	
	//Constructores
	public Decimal(String nombre, float numero)
	{
		super(nombre);
		this.numero = numero;
	}
	
	public Decimal(float numero)
	{
		this.numero = numero;
	}
	
	public Decimal(Double numero)
	{
		this.numero = numero.floatValue();
	}
	
	//Operadores Matematicos
	//Asignacion
	public Decimal operacionAsignar(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = ((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Decimal operacionAsignar(Entero dato)
	{
		this.numero = dato.obtenerDato();
		return this;
	}
	
	public Decimal operacionAsignar(Decimal dato)
	{
		this.numero = dato.obtenerDato();
		return this;
	}
	
	//Sumar
	public Decimal operacionSuma(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = this.numero + ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = this.numero + ((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Decimal operacionSuma(Entero dato)
	{
		this.numero = this.numero + dato.obtenerDato();
		return this;
	}
	
	public Decimal operacionSuma(Decimal dato)
	{
		this.numero = this.numero + dato.obtenerDato();
		return this;
	}
	
	//Resta
	public Decimal operacionResta(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = this.numero - ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = this.numero - ((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Decimal operacionResta(Entero dato)
	{
		this.numero = this.numero - dato.obtenerDato();
		return this;
	}
	
	public Decimal operacionResta(Decimal dato)
	{
		this.numero = this.numero - dato.obtenerDato();
		return this;
	}
	
	//Multiplicar
	public Decimal operacionMultiplicar(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = this.numero * ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = this.numero * ((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Decimal operacionMultiplicar(Entero dato)
	{
		this.numero = this.numero * dato.obtenerDato();
		return this;
	}
	
	public Decimal operacionMultiplicar(Decimal dato)
	{
		this.numero = this.numero * dato.obtenerDato();
		return this;
	}
	
	//Dividir
	public Decimal operacionDividir(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = this.numero / ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = this.numero / ((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Decimal operacionDividir(Entero dato)
	{
		this.numero = this.numero / dato.obtenerDato();
		return this;
	}
	
	public Decimal operacionDividir(Decimal dato)
	{
		this.numero = this.numero / dato.obtenerDato();
		return this;
	}
	
	//Modulo
	public Decimal operacionModulo(TiposDeDatos dato)
	{
		if(dato instanceof Entero)
		{
			this.numero = this.numero % ((Entero)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else if(dato instanceof Decimal)
		{
			this.numero = this.numero % ((Decimal)dato).obtenerDato();
			return this; //Retorna este objeto
		}
		else
		{
			this.error("la variable "+ dato.obtenerNombre()+ " no es un Entero o Decimal");
		}
		return null;
	}
	
	public Decimal operacionModulo(Entero dato)
	{
		this.numero = this.numero % dato.obtenerDato();
		return this;
	}
	
	public Decimal operacionModulo(Decimal dato)
	{
		this.numero = this.numero % dato.obtenerDato();
		return this;
	}
	
	//Negado
	public Decimal operacionNegado()
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
			return new Logico(this.numero == ((Decimal)dato).obtenerDato());
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
			return new Logico(this.numero != ((Decimal)dato).obtenerDato());
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
			return new Logico(this.numero > ((Decimal)datos).obtenerDato());
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
			return new Logico(this.numero >= ((Decimal)datos).obtenerDato());
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
			return new Logico(this.numero < ((Decimal)datos).obtenerDato());
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
			return new Logico(this.numero <= ((Decimal)datos).obtenerDato());
		}
		datos.error(" No se puede comparar " + this.obtenerNombre() + " con " + datos.obtenerNombre() + " son de distintos tipo");
		return null;
	}
	
	//Estatico
	public static float obtenerDecima(Decimal dato)
	{
			return dato.obtenerDato();
	}
	
	public Decimal copiar()
	{
		return new Decimal(this.obtenerNombre(), this.obtenerDato());
	}
	
	public float obtenerDato()
	{
		return this.numero;
	}
	
	public String tipoDeDato()
	{
		return "decimal";
	}
	
	public String toString()
	{
		return "Tipo de dato: " + this.tipoDeDato() + ", Nombre de la variable: " +  this.obtenerNombre() + " = " + this.obtenerDato();
	}
}
