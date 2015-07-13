package interfaz;

import java.io.IOException;

import gramatica.Sim2DBaseListener;
import gramatica.Sim2DLexer;
import gramatica.Sim2DParser;

import javax.swing.JFileChooser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import simulador.Mensaje;

public class CargarArchivo
{
	public CargarArchivo()
	{
		JFileChooser ventanaDialogo = new JFileChooser();
		String rutaArchivo;
		int valorRetorno = ventanaDialogo.showOpenDialog(null);
		if(valorRetorno == JFileChooser.APPROVE_OPTION)
		{
			rutaArchivo = ""+ventanaDialogo.getSelectedFile();
			Mensaje.imprimir("Archivo seleccionado: " + rutaArchivo, Mensaje.TRAZA);
			analizarAntlr(rutaArchivo);
		}
	}
	
	private void analizarAntlr(String rutaArchivo)
	{
		Mensaje.imprimir("Analizando el archivo: " + rutaArchivo, Mensaje.TRAZA);
		ANTLRInputStream archivoEntrada;
		try
		{
			archivoEntrada = new ANTLRFileStream(rutaArchivo);
			Sim2DLexer lexico = new Sim2DLexer(archivoEntrada);
			CommonTokenStream simbolos = new CommonTokenStream(lexico);
			Sim2DParser analisisSintactico = new Sim2DParser(simbolos);
			analisisSintactico.setBuildParseTree(true);
			analisisSintactico.addParseListener(new Sim2DBaseListener());
			analisisSintactico.archivo();//Inicia el analisis
			//ParseTree arbol = analisisSintactico.archivo();
			//System.out.println("Arbol: "+arbol.toStringTree(analisisSintactico));
			//System.out.println("Analisis Finalizado");*/
		}
		catch (IOException e)
		{
			Mensaje.imprimir("Error de ANTLR 4.5 en el archivo CargarArchivo.java", Mensaje.ERROR);
		}
	}
}
