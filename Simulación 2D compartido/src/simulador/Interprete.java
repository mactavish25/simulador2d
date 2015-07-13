package simulador;

//import java.util.Vector;

public class Interprete
{
	private static Interprete interprete;
	private boolean modo_definiendo_objeto;
	private TablaDatos tabla_datos;
	private Objeto objetoTemporal; //Usado para mantener temporal mentes los atributos
	
	private Interprete()
	{
		tabla_datos = new TablaDatos(null);//Se crea una tabla con el padre nulo
		modo_definiendo_objeto = false;
		//Se agregan las funciones internas
		tabla_datos.agregar(new Funcion_DistanciaA());
		tabla_datos.agregar(new Funcion_RumboA());
		tabla_datos.agregar(new Funcion_Arccoseno());
	}
	
	public static Interprete obtenerInterprete()
	{
		//Si es la primera vez que se ejecuta crea un interprete de lo contrario retorna
		//una referencia al interprete ya creado
		if(interprete == null)
		{
			interprete = new Interprete();
		}
		return interprete;
	}
	
	public TablaDatos obtenerTabla()
	{
		return this.tabla_datos;
	}
	
	public void iniciarAsignacionObjeto(String nombre)
	{
		this.modo_definiendo_objeto = true;
		objetoTemporal = new Objeto(nombre);
	}
	
	public void finalizarAsignacionObjeto()
	{
		//Agrega los atributos que son necesarios y no fueron introducidos
		objetoTemporal.agregarAtributosInternos();
		tabla_datos.agregar(objetoTemporal);
		this.modo_definiendo_objeto =false;
	}
	
	public boolean definiendoObjeto()
	{
		return this.modo_definiendo_objeto;
	}
	
	public void agregarAtributoObjeto(String nombreVariable, TiposDeDatos valor)
	{
		if(nombreVariable.equalsIgnoreCase("posicion_x") || nombreVariable.equalsIgnoreCase("posicion_y") ||
			nombreVariable.equalsIgnoreCase("velocidad") || nombreVariable.equalsIgnoreCase("rumbo"))
		{
			//Es un Decimal
			if(valor instanceof Decimal)
				objetoTemporal.agregarAtributo(new Decimal(nombreVariable,((Decimal)valor).obtenerDato()));
			else if(valor instanceof Entero)
				objetoTemporal.agregarAtributo(new Decimal(nombreVariable,((Entero)valor).obtenerDato()));
			else
				new Sim2DExcepcion("Se requiere un Numero en la variable " + nombreVariable + " del objeto " + objetoTemporal.obtenerNombre());
		}
		else if(nombreVariable.equalsIgnoreCase("ancho") || nombreVariable.equalsIgnoreCase("alto"))
		{
			//Es un Entero
			if(valor instanceof Entero)
				objetoTemporal.agregarAtributo(new Entero(nombreVariable,((Entero)valor).obtenerDato()));
			else if(valor instanceof Decimal)
				objetoTemporal.agregarAtributo(new Entero(nombreVariable,(int)((Decimal)valor).obtenerDato()));
			else
				new Sim2DExcepcion("Se requiere un Numero en la variable " + nombreVariable + " del objeto " + objetoTemporal.obtenerNombre());
		}
		else if(nombreVariable.equalsIgnoreCase("relleno") || nombreVariable.equalsIgnoreCase("visible"))
		{
			//Es un Logico
			if(valor instanceof Logico)
				objetoTemporal.agregarAtributo(new Logico(nombreVariable,((Logico)valor).obtenerDato()));
			else
				new Sim2DExcepcion("Se requiere un Logico en la variable " + nombreVariable + " del objeto " + objetoTemporal.obtenerNombre());
		}
		else if(nombreVariable.equalsIgnoreCase("forma"))
		{
			//Es un Forma
			if(valor instanceof Forma)
				objetoTemporal.agregarAtributo(new Forma(nombreVariable,((Forma)valor).obtenerDato()));
			else
				new Sim2DExcepcion("Se requiere un Forma en la variable " + nombreVariable + " del objeto " + objetoTemporal.obtenerNombre());
		}
		else if(nombreVariable.equalsIgnoreCase("color"))
		{
			//Es un Tinte
			if(valor instanceof Tinte)
				objetoTemporal.agregarAtributo(new Tinte(nombreVariable,((Tinte)valor).obtenerDato()));
			else
				new Sim2DExcepcion("Se requiere un Tinte en la variable " + nombreVariable + " del objeto " + objetoTemporal.obtenerNombre());
		}
		else
		{
			TiposDeDatos temporal = valor;
			valor.establecerNombre(nombreVariable);
			objetoTemporal.agregarAtributo(temporal);
		}
	}
	public TiposDeDatos obtenerVariable(String nombre)
	{
		TiposDeDatos nuevo = this.tabla_datos.obtener(nombre);
		if(this.modo_definiendo_objeto)
		{
			//if(nuevo == null) return new TiposDeDatos(nombre);
			//else Mensaje.imprimir("Ya existe una variable con el nombre "+ nombre, Mensaje.ERROR);
		}
		else
		{
			if(nuevo == null) Mensaje.imprimir("Variable u objeto desconocido", Mensaje.ERROR);
		}
		return nuevo;
	}
	/*
	public TiposDeDatos obtenerVariable(String nombre)
	{
		TiposDeDatos variableGuardada = this.tabla_datos.obtener(nombre);
		if(!this.modo_definiendo_objeto)
		{
			if(variableGuardada == null) Mensaje.imprimir("Variable desconocida", Mensaje.ERROR);
			else return variableGuardada;
		}
		return null;
	}*/
	/*
	public TiposDeDatos convertirCadenaVariable(String nombre, String texto)
	{
		try
		{
			Mensaje.imprimir("Texto combertido a Entero", Mensaje.TRAZA);
			return new Entero(nombre, Integer.parseInt(texto));
		}
		catch(NumberFormatException e){}
		try
		{
			Mensaje.imprimir("Texto combertido a Decimal", Mensaje.TRAZA);
			return new Decimal(nombre, Float.parseFloat(texto));
		}
		catch(NumberFormatException e){}
		if(texto.equalsIgnoreCase("verdadero"))
			objetoTemporal.agregarAtributo(new Logico(nombre, true));
		else if(texto.equalsIgnoreCase("falso"))
			objetoTemporal.agregarAtributo(new Logico(nombre, false));
		else if(Forma.esUnaForma(texto))
			return new Forma(nombre, texto);
		else if(Tinte.esUnColor(texto))
			return new Tinte(nombre, texto);
		return null;
	}*/
	public TiposDeDatos convertirCadenaNumero(String texto)
	{
		try
		{
			Mensaje.imprimir("Texto combertido a Entero", Mensaje.TRAZA);
			return new Entero(Integer.parseInt(texto));
		}
		catch(NumberFormatException e){}
		try
		{
			Mensaje.imprimir("Texto combertido a Decimal", Mensaje.TRAZA);
			return new Decimal(Float.parseFloat(texto));
		}
		catch(NumberFormatException e)
		{
			throw new Sim2DExcepcion("\""+ texto +"\" no es un numero valido");
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	public TiposDeDatos[] convertirVectorArreglo(Vector<TiposDeDatos> vector)
	{
		//Se usa un vector porque no se sabe el tamaño que puede tener el arreglo
		TiposDeDatos[] arreglo = new TiposDeDatos[vector.size()];
		for(int x=0; x<arreglo.length; x++)
		{
			arreglo[x] = vector.elementAt(x);
		}
		return arreglo;
	}
	
	public TiposDeDatos convertirCadenaNumero(String texto)
	{
		try
		{
			Mensaje.imprimir("Texto combertido a Entero", Mensaje.TRAZA);
			return new Entero(Integer.parseInt(texto));
		}
		catch(NumberFormatException e){}
		try
		{
			Mensaje.imprimir("Texto combertido a Decimal", Mensaje.TRAZA);
			return new Decimal(Float.parseFloat(texto));
		}
		catch(NumberFormatException e)
		{
			Mensaje.imprimir("La cadena \"" + texto + "\" no es un numero", Mensaje.ERROR);
			return null;
		}
	}
	*/
	/*
	public TiposDeDatos obtenerVariable(String nombre)
	{
		TiposDeDatos nuevo = this.tabla_datos.obtener(nombre);
		if(this.modo_definiendo_objeto)
		{
			if(nuevo == null) return new TiposDeDatos(nombre);
			else Mensaje.imprimir("Ya existe una variable con el nombre "+ nombre, Mensaje.ERROR);
		}
		else
		{
			if(nuevo == null) Mensaje.imprimir("Variable desconocida", Mensaje.ERROR);
		}
		return nuevo;
	}
	*/
	/*
	public void entrarNodo()
	{
		TablaDatos nueva_tabla;
		nueva_tabla = new TablaDatos(this.tabla_datos);
		this.tabla_datos = nueva_tabla;
		Mensaje.imprimir("Entrar al nodo", Mensaje.TRAZA);
	}
	*/
	/*
	public void salirNodo()
	{
		this.tabla_datos = this.tabla_datos.obtenerPadre();
		Mensaje.imprimir("Salir del nodo", Mensaje.TRAZA);
	}
	*/
	/*
	public void postProcesamientoObjeto()
	{
		//Esta funcion agrega los atributos que todos los objetos tienen
		TiposDeDatos objeto = this.tabla_datos.getLast();
		Mensaje.imprimir("Posprocesamiento del objeto " + objeto.obtenerNombre(), Mensaje.TRAZA);
		if(!(objeto instanceof Objeto))
		{
			Mensaje.imprimir(objeto.obtenerNombre() + " no es un objeto ", Mensaje.ERROR);
		}
		else
		{
			Objeto actualizarObjeto = (Objeto)objeto;
			actualizarObjeto.agregarAtributosInternos();
		}
	}
	*/
	/*
	public boolean agrebarAtributosObjeto(TiposDeDatos atributo1, TiposDeDatos atributo2)
	{
		if(atributo1.obtenerNombre() == null)
		{
			Mensaje.imprimir("Atributo invalido", Mensaje.ERROR);
			return false;
		}
		
		TiposDeDatos objeto = this.tabla_datos.getLast();
		Mensaje.imprimir("Agregando atributo " + atributo1.obtenerNombre() + " al objeto " + objeto.obtenerNombre(), Mensaje.TRAZA);
		if(!(objeto instanceof Objeto))
		{
			Mensaje.imprimir("El dato" + objeto.obtenerNombre() + " no es un objeto", Mensaje.ERROR);
			return false;
		}
		
		TiposDeDatos nuevoAtributo = atributo2.copiar();
		nuevoAtributo.establecerNombre(atributo1.obtenerNombre());
		Objeto objetoModificar = (Objeto)objeto;
		objetoModificar.agregarAtributo(nuevoAtributo);
		return true;
	}
	*/
	/*
	public boolean ejecutarRegla()
	{
		//Ejecuta la regla aun no se como reemplazar el AST
		return false;
	}
	*/
	/*
	public void operacionAsignar(TiposDeDatos dato1, TiposDeDatos dato2)
	{
		//Solo se usa para mostrar error, aun no le encuentro sentido
		if(dato1.obtenerNombre() == null)
		{
			Mensaje.imprimir("no se puede asignar en el interprete, el nombre de la variable no esta definido", Mensaje.ERROR);
		}
		else
		{
			if(dato1 != null) dato1.error("no se puede asignar la variable " + dato1.obtenerNombre());
		}
	}
	*/
}
