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
}
