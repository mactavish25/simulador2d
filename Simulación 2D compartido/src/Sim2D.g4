grammar Sim2D;

@parser::header
{package gramatica;
import simulador.*;
}
@lexer::header
{package gramatica;
}
@parser::members
{
	private Interprete interprete = Interprete.obtenerInterprete();
}

DIVICION: '/';
MULTIPLICACION: '*';
SUMA: '+';
RESTA: '-';
ASIGNAR: '<-';
IGUAL: '=';
DIFERENTE: '!=';
MENOR: '<';
MAYOR: '>';
MENORIGUAL: '<=';
MAYORIGUAL: '>=';
COMA: ',';
PUNTOYCOMA: ';';
DEREF: '.';
PARENTESIS_IZQ: '(';
PARENTESIS_DER: ')';
CORCHETE_IZQ: '{';
CORCHETE_DER: '}';

/*Palabras reservadas */
OBJETO: 'objeto ';
REGLA: 'regla ';
FUNCION: 'funcion ';
SI: 'si';
ENTONCES: 'entonces';
Y: 'y';
O: 'o';
VERDADERO: 'verdadero';
FALSO: 'falso';

COLOR: 'rojo' | 'azul' | 'verde' | 'amarillo' | 'naranja' | 'gris' | 'negro' | 'rosado' | 'magenta' | 'cian';
FORMA: 'rectangulo' | 'ovalo' | 'triangulo';

ID: ('a'..'z' | 'A'..'Z' | 'ñ' | 'Ñ') ('a'..'z' | 'A'..'Z' | 'ñ' | 'Ñ' | '_' | '0'..'9') *;
NUMERO: (DIGITO)+ ('.' (DIGITO+))? EXPONENTE?;
EXPONENTE: ('e' | 'E') ('+' | '-')? DIGITO+;
DIGITO: '0'..'9';
CADENA: '"' .*? '"'; //falta que no se inclullan las comillas en el reconocimiento

NUEVA_LINEA: ('\n' | '\r') ->skip;
ESPACIOS_BLANCOS: (' ' | '\t') ->skip;
COMENTARIOS: (('/*' .*? '*/') | ('//' ~('\n')*)) ->skip;

//archivo: NUMERO;
archivo: (objeto_declarar | regla_declarar | funcion_declarar)+;

/* Las 3 partes principales del archivo, objeto, regla y funcion */
objeto_declarar:	OBJETO nombreObjeto=ID {interprete.iniciarAsignacionObjeto($nombreObjeto.text);}
							CORCHETE_IZQ
								(asignacion)*
							CORCHETE_DER {interprete.finalizarAsignacionObjeto();};
							
regla_declarar:		REGLA nombreRegla=ID
							CORCHETE_IZQ
								subagrupado
							CORCHETE_DER;
							
funcion_declarar:	FUNCION nombreFuncion=ID argumentosFuncion
							CORCHETE_IZQ
								subagrupado
							CORCHETE_DER;

/* Asignacion ej: velocidad <- 53;*/
asignacion: id ASIGNAR expresion PUNTOYCOMA
{
	if(interprete.definiendoObjeto()) interprete.agregarAtributoObjeto($id.text, $expresion.retorno);
};

condicional:	SI expresion
					CORCHETE_IZQ
						subagrupado
					CORCHETE_DER
					(ENTONCES
					CORCHETE_IZQ
						subagrupado
					CORCHETE_DER)?;
					


/* Argumentos en una funcion */
argumentosFuncion: PARENTESIS_IZQ lista_argumentos_funcion PARENTESIS_DER;
lista_argumentos_funcion: ID (COMA ID)*;

/* Pueden estar dentro de otros como en funciones, reglas y condicionales */
subagrupado: (cualquier_declaracion)*;
cualquier_declaracion:		condicional
									|	asignacion
									|	llamadaFuncion PUNTOYCOMA;

/* Llamada a funcion */
llamadaFuncion: ID argumento; //identificador(exprecion)
argumento: PARENTESIS_IZQ lista_argumento? PARENTESIS_DER;
lista_argumento: expresion (COMA expresion)*;

id: ID (DEREF ID)*;
/* 
expresion: and (op=O and)*;
and: comparadores (op=Y comparadores)*;
comparadores: operacionSumaResta (op=(IGUAL | DIFERENTE | MENOR | MAYOR | MAYORIGUAL | MENORIGUAL) operacionSumaResta)?;
operacionSumaResta: operacionMultiplicacionDivicion (op=(SUMA | RESTA) operacionMultiplicacionDivicion)*;
operacionMultiplicacionDivicion: signo (op=(MULTIPLICACION | DIVICION) signo)*;
signo:	op=SUMA dereferencia
		|	op=RESTA dereferencia
		|	dereferencia;
dereferencia returns [TiposDeDatos retorno]: constante (op=DEREF constante)*;
constante returns [TiposDeDatos retorno]:
				numE=NUMERO {$retorno = interprete.convertirCadenaNumero($numE.text);}
				| CADENA //no usada asta el momento
				| VERDADERO {$retorno = new Logico(true);}
				| FALSO {$retorno = new Logico(false);}
				| colE=COLOR {$retorno = new Tinte($colE.text);}
				| forE=FORMA {$retorno = new Forma($forE.text);}
				| idE=id //{$retorno = interprete.obtenerSimbolo($idE.text);}
				| llamE=llamadaFuncion
				| PARENTESIS_IZQ expresion PARENTESIS_DER;
*/

expresion returns [TiposDeDatos retorno] :
				PARENTESIS_IZQ expresion PARENTESIS_DER
				| expresion op=O expresion
				| expresion op=Y expresion
				| expresion op=(IGUAL | DIFERENTE | MENOR | MAYOR | MAYORIGUAL | MENORIGUAL) expresion
				| expresion op=(SUMA | RESTA) expresion
				| expresion op=(MULTIPLICACION | DIVICION) expresion
				| op=(SUMA | RESTA) expNegado=expresion
				{
					if($op.type==RESTA)
						$retorno = $expNegado.retorno.operacionNegado();
					else if ($op.type==SUMA)
						$retorno = $expNegado.retorno;
				}
				| expresion op=DEREF expresion
				| a=NUMERO {$retorno = interprete.convertirCadenaNumero($a.text);}
				| a=VERDADERO {$retorno = new Logico(true);}
				| a=FALSO {$retorno = new Logico(false);}
				| a=COLOR {$retorno = new Tinte($a.text);}
				| a=FORMA {$retorno = new Forma($a.text);}
				| id
				| llamadaFuncion
				;
