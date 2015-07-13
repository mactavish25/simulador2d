package simulador;

import java.util.LinkedHashMap;

public class Objeto extends TiposDeDatos
{
	private LinkedHashMap<String, TiposDeDatos> atributos;
	
	public Objeto(String nombre)
	{
		super(nombre);
		atributos = new LinkedHashMap<String, TiposDeDatos>();
	}
	
	public TiposDeDatos obtenerAtributo(String nombre)
	{
		return this.atributos.get(nombre);
	}

	public void agregarAtributo(TiposDeDatos dato)
	{
		Mensaje.imprimir("Agregando el atributo " + dato.obtenerNombre() + " al objeto " + this.obtenerNombre(), Mensaje.TRAZA);
		if(this.atributos.containsKey(dato.obtenerNombre()))
		{
			Mensaje.imprimir("El objeto " + this.obtenerNombre() + " ya contiene un atributo con el nombre " + dato.obtenerNombre(), Mensaje.ADVERTENCIA);
		}
		else
		{
			this.atributos.put(dato.obtenerNombre(), dato);
		}
	}
	
	public void agregarAtributosInternos()
	{
		Mensaje.imprimir("Agregando atributos internos por defecto", Mensaje.TRAZA);
		this.agregarAtributo(new Decimal("posicion_x",0));
		this.agregarAtributo(new Decimal("posicion_y",0));
		this.agregarAtributo(new Entero("ancho",5));
		this.agregarAtributo(new Entero("alto",5));
		this.agregarAtributo(new Decimal("velocidad",0));
		this.agregarAtributo(new Decimal("rumbo",0));
		this.agregarAtributo(new Forma("forma","rectangulo"));
		this.agregarAtributo(new Tinte("color","negro"));
		this.agregarAtributo(new Logico("relleno",true));
		this.agregarAtributo(new Logico("visible",true));
	}
	
	public String tipoDeDato()
	{
		return "objeto";
	}
	
	public String toString()
	{
		String aux = this.tipoDeDato() + " " +this.obtenerNombre() + "() //contiene " + this.atributos.size() + " atributos\n";
		aux = aux + "{\n";
		for(String a: this.atributos.keySet())
		{
			aux = aux + "\t" + this.obtenerAtributo(a).toString() + ";\n";
		}
		aux = aux + "}\n";
		return aux;
	}

	@Override
	public TiposDeDatos copiar()
	{
		Mensaje.imprimir("Esta tratando de copiar el objeto " + this.obtenerNombre(), Mensaje.ERROR);
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
