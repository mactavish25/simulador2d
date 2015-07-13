// Generated from Sim2D.g4 by ANTLR 4.5
package gramatica;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import simulador.Interprete;
import simulador.Mensaje;
import simulador.TablaDatos;

public class Sim2DBaseListener implements Sim2DListener
{
	private Interprete interprete = Interprete.obtenerInterprete();
	
	@Override
	public void enterArchivo(Sim2DParser.ArchivoContext ctx)
	{
		
	}
	@Override
	public void exitArchivo(Sim2DParser.ArchivoContext ctx)
	{
		
	}
	@Override
	public void enterObjeto_declarar(Sim2DParser.Objeto_declararContext ctx)
	{
		interprete.iniciarAsignacionObjeto();//Se indica que todo lo leido es parte del objeto actual
	}
	@Override
	public void exitObjeto_declarar(Sim2DParser.Objeto_declararContext ctx)
	{
		interprete.finalizarAsignacionObjeto(ctx.nombreObjeto.getText());//Se indica que se termino de crear el objeto
	}
	@Override
	public void enterRegla_declarar(Sim2DParser.Regla_declararContext ctx)
	{
		
	}
	@Override
	public void exitRegla_declarar(Sim2DParser.Regla_declararContext ctx)
	{
		
	}
	@Override
	public void enterFuncion_declarar(Sim2DParser.Funcion_declararContext ctx)
	{
		
	}
	@Override
	public void exitFuncion_declarar(Sim2DParser.Funcion_declararContext ctx)
	{
		
	}
	@Override
	public void enterAsignacion(Sim2DParser.AsignacionContext ctx)
	{
		Mensaje.imprimir("Asignacion entrar " + ctx.getText(), Mensaje.TRAZA);
	}
	@Override
	public void exitAsignacion(Sim2DParser.AsignacionContext ctx)
	{
		if(interprete.definiendoObjeto())
		{
			interprete.agregarAtributoObjeto(ctx.nombreVariable.getText(), ctx.resultadoAsignacion.getText());
		}
	}
	@Override
	public void enterCondicional(Sim2DParser.CondicionalContext ctx)
	{
		
	}
	@Override
	public void exitCondicional(Sim2DParser.CondicionalContext ctx)
	{
		
	}
	@Override
	public void enterArgumentosFuncion(Sim2DParser.ArgumentosFuncionContext ctx)
	{
		
	}
	@Override
	public void exitArgumentosFuncion(Sim2DParser.ArgumentosFuncionContext ctx)
	{
		
	}
	@Override
	public void enterLista_argumentos_funcion(Sim2DParser.Lista_argumentos_funcionContext ctx)
	{
		
	}
	@Override
	public void exitLista_argumentos_funcion(Sim2DParser.Lista_argumentos_funcionContext ctx)
	{
		
	}
	@Override
	public void enterSubagrupado(Sim2DParser.SubagrupadoContext ctx)
	{
		
	}
	@Override
	public void exitSubagrupado(Sim2DParser.SubagrupadoContext ctx)
	{
		
	}
	@Override
	public void enterCualquier_declaracion(Sim2DParser.Cualquier_declaracionContext ctx)
	{
		
	}
	@Override
	public void exitCualquier_declaracion(Sim2DParser.Cualquier_declaracionContext ctx)
	{
		
	}
	@Override
	public void enterLlamadaFuncion(Sim2DParser.LlamadaFuncionContext ctx)
	{
		
	}
	@Override
	public void exitLlamadaFuncion(Sim2DParser.LlamadaFuncionContext ctx)
	{
		
	}
	@Override
	public void enterArgumento(Sim2DParser.ArgumentoContext ctx)
	{
		
	}
	@Override
	public void exitArgumento(Sim2DParser.ArgumentoContext ctx)
	{
		
	}
	@Override
	public void enterLista_argumento(Sim2DParser.Lista_argumentoContext ctx)
	{
		
	}
	@Override
	public void exitLista_argumento(Sim2DParser.Lista_argumentoContext ctx)
	{
		
	}
	@Override
	public void enterId(Sim2DParser.IdContext ctx)
	{
		
	}
	@Override
	public void exitId(Sim2DParser.IdContext ctx)
	{
		
	}
	@Override
	public void enterExpresion(Sim2DParser.ExpresionContext ctx)
	{
		
	}
	@Override
	public void exitExpresion(Sim2DParser.ExpresionContext ctx)
	{
		
	}
	@Override
	public void enterAnd(Sim2DParser.AndContext ctx)
	{
		
	}
	@Override
	public void exitAnd(Sim2DParser.AndContext ctx)
	{
		
	}
	@Override
	public void enterComparadores(Sim2DParser.ComparadoresContext ctx)
	{
		
	}
	@Override
	public void exitComparadores(Sim2DParser.ComparadoresContext ctx)
	{
		
	}
	@Override
	public void enterOperacionSumaResta(Sim2DParser.OperacionSumaRestaContext ctx)
	{
		
	}
	@Override
	public void exitOperacionSumaResta(Sim2DParser.OperacionSumaRestaContext ctx)
	{
		
	}
	@Override
	public void enterOperacionMultiplicacionDivicion(Sim2DParser.OperacionMultiplicacionDivicionContext ctx)
	{
		
	}
	@Override
	public void exitOperacionMultiplicacionDivicion(Sim2DParser.OperacionMultiplicacionDivicionContext ctx)
	{
		
	}
	@Override
	public void enterSigno(Sim2DParser.SignoContext ctx)
	{
		
	}
	@Override
	public void exitSigno(Sim2DParser.SignoContext ctx)
	{
		
	}
	@Override
	public void enterDereferencia(Sim2DParser.DereferenciaContext ctx)
	{
		
	}
	@Override
	public void exitDereferencia(Sim2DParser.DereferenciaContext ctx)
	{
		
	}
	@Override
	public void enterConstante(Sim2DParser.ConstanteContext ctx)
	{
		
	}
	@Override
	public void exitConstante(Sim2DParser.ConstanteContext ctx)
	{
		
	}
	@Override
	public void enterEveryRule(ParserRuleContext ctx)
	{
		
	}
	@Override
	public void exitEveryRule(ParserRuleContext ctx)
	{
		
	}
	@Override
	public void visitTerminal(TerminalNode node)
	{
		
	}
	@Override
	public void visitErrorNode(ErrorNode node)
	{
		
	}
}