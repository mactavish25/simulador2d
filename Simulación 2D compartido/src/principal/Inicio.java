package principal;

import interfaz.Principal;
import simulador.Mensaje;

public class Inicio
{
	public static void main(String[] args)
	{
		Mensaje.encender(Mensaje.ERROR);
		new Principal();
	}
}
