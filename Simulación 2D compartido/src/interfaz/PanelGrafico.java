package interfaz;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import simulador.*;

public class PanelGrafico extends JPanel
{
	private static final long serialVersionUID = 1L;
	private TablaDatos tabla_datos;
	private int tiempo = 0;
	
	public PanelGrafico(TablaDatos tabla_datos)
	{
		this.tabla_datos = tabla_datos;
	}
	
	@Override
	public void paintComponent(Graphics grafico)
	{
		super.paintComponent(grafico);
		if(this.tabla_datos != null)
		{
			for(TiposDeDatos actual: this.tabla_datos)
			{
				if(actual instanceof Objeto)
				{
					Objeto objeto = (Objeto)actual;
					Logico visible = (Logico)objeto.obtenerAtributo("visible");
					if(visible.obtenerDato())
					{
						Decimal posicion_x = (Decimal)objeto.obtenerAtributo("posicion_x");
						Decimal posicion_y = (Decimal)objeto.obtenerAtributo("posicion_y");
						Entero ancho = (Entero)objeto.obtenerAtributo("ancho");
						Entero alto = (Entero)objeto.obtenerAtributo("alto");
						Forma forma = (Forma)objeto.obtenerAtributo("forma");
						Tinte color = (Tinte)objeto.obtenerAtributo("color");
						Logico relleno = (Logico)objeto.obtenerAtributo("relleno");
						
						grafico.setColor(color.obtenerDato());
						if(forma.esRectangulo())
						{
							if(relleno.obtenerDato())
								grafico.fillRect((int)posicion_x.obtenerDato(), (int)posicion_y.obtenerDato(), ancho.obtenerDato(), alto.obtenerDato());
							else
								grafico.drawRect((int)posicion_x.obtenerDato(), (int)posicion_y.obtenerDato(), ancho.obtenerDato(), alto.obtenerDato());
							
						}
						else if(forma.esOvalo())
						{
							if(relleno.obtenerDato())
								grafico.fillOval((int)posicion_x.obtenerDato(), (int)posicion_y.obtenerDato(), ancho.obtenerDato(), alto.obtenerDato());
							else
								grafico.drawOval((int)posicion_x.obtenerDato(), (int)posicion_y.obtenerDato(), ancho.obtenerDato(), alto.obtenerDato());
						}
						else if(forma.esTriangulo())
						{
							//posicion_x, ancho/2, ancho+posicion_x
					        int [] x = {(int)posicion_x.obtenerDato(), (ancho.obtenerDato()/2)+(int)posicion_x.obtenerDato(), ancho.obtenerDato()+(int)posicion_x.obtenerDato()};
					      //alto+posicion_y, posicion_y,alto+posicion_y
					        int [] y = {alto.obtenerDato()+(int)posicion_y.obtenerDato(), (int)posicion_y.obtenerDato(), alto.obtenerDato()+(int)posicion_y.obtenerDato()};
					        
					        if(relleno.obtenerDato())
					        	grafico.fillPolygon(x, y, 3);
					        else
					        	grafico.drawPolygon(x, y, 3);
						}
					}
				}
			}
			grafico.setColor(Color.BLACK);
			if(tiempo > 0) grafico.drawString("FPS: "+(1000/tiempo), 10, 20);
			else grafico.drawString("FPS: 0", 10, 20);
		}
	}
	
	public void estabecerTiempo(int tiempo)
	{
		this.tiempo = tiempo;
	}
}
