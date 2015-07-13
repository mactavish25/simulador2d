package simulador;

public class Mensaje
{
	private static boolean mostrarError = false;
	private static boolean mostrarAdvertencia = false;
	private static boolean mostrarTraza = false;
	
	public static byte ERROR = 0;
	public static byte ADVERTENCIA = 1;
	public static byte TRAZA = 2;
	public static byte TODO = 3;
	
	public static void encender(byte tipo)
	{
		if(tipo == ERROR) mostrarError= true;
		else if(tipo == ADVERTENCIA) mostrarAdvertencia = true;
		else if(tipo == TRAZA) mostrarTraza = true;
		else if(tipo == TODO)
		{
			mostrarError = true;
			mostrarAdvertencia = true;
			mostrarTraza = true;
		}
	}
	
	public static void apagar(byte tipo)
	{
		if(tipo == ERROR) mostrarError= false;
		else if(tipo == ADVERTENCIA) mostrarAdvertencia = false;
		else if(tipo == TRAZA) mostrarTraza = false;
		else if(tipo == TODO)
		{
			mostrarError = false;
			mostrarAdvertencia = false;
			mostrarTraza = false;
		}
	}
	
	public static void imprimir(String texto, byte tipo)
	{
		if(mostrarError)
		{
			if(tipo == ERROR)	System.err.println("Error: " + texto);
		}
		if(mostrarAdvertencia)
		{
			if(tipo == ADVERTENCIA) System.out.println("Advertencia: " + texto);
		}
		if(mostrarTraza)
		{
			if(tipo == TRAZA) System.out.println("Traza: " + texto);
		}
	}
}
