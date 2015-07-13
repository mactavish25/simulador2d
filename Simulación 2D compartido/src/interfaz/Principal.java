package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import simulador.*;

public class Principal implements ActionListener, Runnable
{
	private JFrame ventana;
	private JPanel panelFondo;
	private JToolBar barraMenu;
	private JButton abrirArchivo, control, velocidadMas, velocidadMenos , limpiar, ayuda;
	private PanelGrafico grafico;
	private Interprete interprete;
	
	private boolean reproduciendo = false;
	private int tiempo = 33;
	private Thread hilo;
	
	private TablaDatos tabla;
	
	public Principal()
	{
		ventana = new JFrame("Semulador 2D");
		panelFondo = new JPanel();
		
		barraMenu = new JToolBar();
		barraMenu.setFloatable(false);
		
		abrirArchivo = new JButton();
		abrirArchivo.setIcon(new ImageIcon(getClass().getResource("/iconos/abrir.png")));
		abrirArchivo.setFocusable(false);
		
		control = new JButton("Reproducir");
		control.setIcon(new ImageIcon(getClass().getResource("/iconos/reproducir.png")));
		control.setFocusable(false);
		
		velocidadMas = new JButton();
		velocidadMas.setIcon(new ImageIcon(getClass().getResource("/iconos/mas.png")));
		velocidadMas.setFocusable(false);
		
		velocidadMenos = new JButton();
		velocidadMenos.setIcon(new ImageIcon(getClass().getResource("/iconos/menos.png")));
		velocidadMenos.setFocusable(false);
		
		limpiar = new JButton();
		limpiar.setIcon(new ImageIcon(getClass().getResource("/iconos/limpiar.png")));
		limpiar.setFocusable(false);
		
		ayuda = new JButton();
		ayuda.setIcon(new ImageIcon(getClass().getResource("/iconos/ayuda.png")));
		ayuda.setFocusable(false);
		
		abrirArchivo.addActionListener(this);
		control.addActionListener(this);
		velocidadMas.addActionListener(this);
		velocidadMenos.addActionListener(this);
		limpiar.addActionListener(this);
		ayuda.addActionListener(this);
		
		barraMenu.add(abrirArchivo);
		barraMenu.add(control);
		barraMenu.addSeparator();
		barraMenu.add(velocidadMas);
		barraMenu.add(velocidadMenos);
		barraMenu.add(limpiar);
		barraMenu.addSeparator();
		barraMenu.add(ayuda);
		
		interprete = Interprete.obtenerInterprete();
		tabla = interprete.obtenerTabla();
		grafico = new PanelGrafico(tabla);
		grafico.setPreferredSize(new Dimension(600, 600));
		grafico.setBackground(Color.WHITE);
		grafico.setBorder(BorderFactory.createLineBorder (Color.BLUE, 1));
		
		panelFondo.setLayout(new BorderLayout());
		panelFondo.add(barraMenu, "North");
		panelFondo.add(grafico, "Center");
		
		ventana.setContentPane(panelFondo);
		
		/*Se adapta a la interfaz grafica del sistema operativo*/
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(ventana);
		}
		catch (Exception evt){}
		
		ventana.pack();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		ventana.setLocation((d.width/2)-(ventana.getWidth()/2), (d.height/2)-(ventana.getHeight()/2));
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void actualizarGrafico()
	{
		for(TiposDeDatos objeto : tabla)
		{
			if(objeto instanceof Objeto)
			{
				Mensaje.imprimir("Actualizando atributos del objeto " + objeto.obtenerNombre(), Mensaje.TRAZA);
				Objeto ob = (Objeto)tabla.obtener(objeto.obtenerNombre());
				Decimal x = (Decimal)ob.obtenerAtributo("posicion_x");
				Decimal y = (Decimal)ob.obtenerAtributo("posicion_y");
				Decimal velocidad = (Decimal)ob.obtenerAtributo("velocidad");
				Decimal rumbo = (Decimal)ob.obtenerAtributo("rumbo");
				
				x.operacionAsignar(new Decimal(x.obtenerDato() + velocidad.obtenerDato() * Math.sin(Math.toRadians(rumbo.obtenerDato()))));
				y.operacionAsignar(new Decimal(y.obtenerDato() - velocidad.obtenerDato() * Math.cos(Math.toRadians(rumbo.obtenerDato()))));
			}
		}
		grafico.repaint();
	}
	
	private void reproducir()
	{
			hilo = new Thread(this);
			hilo.start();
	}
	
	@Override
	public void run()
	{
		while(reproduciendo)
		{
			actualizarGrafico();
			try
			{
				Thread.sleep(tiempo);
			}
			catch (InterruptedException e){}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource() == abrirArchivo)
		{
			tabla.clear();
			new CargarArchivo();
			grafico.repaint();
		}
		else if(evento.getSource() == control)
		{
			if(reproduciendo)
			{
				control.setIcon(new ImageIcon(getClass().getResource("/iconos/reproducir.png")));
				control.setText("Reproducir");
				control.repaint();
				grafico.estabecerTiempo(0);
				actualizarGrafico();
				reproduciendo = false;
			}
			else
			{
				control.setIcon(new ImageIcon(getClass().getResource("/iconos/detener.png")));
				control.setText("Detener    ");
				control.repaint();
				grafico.estabecerTiempo(tiempo);
				reproducir();
				reproduciendo = true;
			}
		}
		else if(evento.getSource() == velocidadMas)
		{
			tiempo = tiempo - 1;
			if (tiempo <= 0) tiempo = 1;
			grafico.estabecerTiempo(tiempo);
		}
		else if(evento.getSource() == velocidadMenos)
		{
			tiempo = tiempo + 1;
			if (tiempo > 1000) tiempo = 1000;
			grafico.estabecerTiempo(tiempo);
		}
		else if(evento.getSource() == limpiar)
		{
			tabla.clear();
			actualizarGrafico();
		}
	}
}
