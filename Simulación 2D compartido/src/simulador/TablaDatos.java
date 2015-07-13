package simulador;

import java.util.LinkedList;

public class TablaDatos extends LinkedList<TiposDeDatos>
{
	private static final long serialVersionUID = 1L;
	private TablaDatos padre;
	private int endentar;
	
	public TablaDatos(TablaDatos datos)
	{
		this.padre = datos;
	}
	
	public void agregar(TiposDeDatos dato)
	{
		for(TiposDeDatos busqueda : this)
		{
			if(busqueda.obtenerNombre().equals(dato.obtenerNombre()))
			{
				if(dato.getClass() == busqueda.getClass())
				{
					Mensaje.imprimir("Ya existe "+ dato.tipoDeDato() + " " + dato.obtenerNombre(), Mensaje.ERROR);
					return;
				}
			}
		}
		this.add(dato);
	}
	
	public TiposDeDatos obtener(String nombre)
	{
		for(TiposDeDatos dato : this)
		{
			if(dato.obtenerNombre().equals(nombre))
			{
				return dato;
			}
		}
		//Si no encuentra el nombre en la lista actual y el padre no es nulo
		//realiza la busqueda dentro de padre de forma recursiva
		if(this.padre != null)
		{
			return this.padre.obtener(nombre);
		}
		return null;
	}
	
	public void imprimirTabla()
	{
		Mensaje.imprimir("Imprimiendo la tabla de datos",Mensaje.TRAZA);
		this.imprimirTabla(this);
	}
	
	public TablaDatos obtenerPadre()
	{
		return this.padre;
	}
	
	public void imprimirTabla(TablaDatos datos)
	{
		if(datos == null)
		{
			return;
		}
		this.endentar --;
		this.imprimirTabla(this.padre);
		this.endentar++;
		for(TiposDeDatos dato : datos)
		{
			for(int x=0; x<this.endentar; x++)
			{
				//Dibuja espacios para dibujar de forma correcta el arbol
				//Creo que no funciona esto ya que aun no hay nada que haga
				//que endentar sea mayor a  1
				System.out.println(" ");
			}
			
			if(!(dato instanceof Funcion))
			{
				//Lo imprime solo si no es una función
				System.out.println(dato);
			}
		}
	}
}
