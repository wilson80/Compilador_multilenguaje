
/* codigo de usuario */
package com.wilsoncys.compi1.javacraft.analizadores;



import java_cup.runtime.*;
import java.util.ArrayList;

%% //separador de area

/* opciones y declaraciones de jflex */

%class LexerJavaCraft   
%public
%cup
%line
%column
%char //conteo de caracteres
%full //reconocimiento de caracteres
%ignorecase

LineTerminator = \r|\n|\r\n

WhiteSpace = {LineTerminator} | [ \t\f]

/* integer literals */
//cadena = \"[^\"\n]*\"
//cadena = \"([^\"\\]|\\[^\n])*\\\"


entero = [0-9]+
decimal = [0-9]+ "."[0-9][0-9]*
cadena = \"([^\"\\]|(\\\'|\\\"|\\\\|\\t|\\n))*\"
comment = "//"[^\n]*
commentMultiLine = "/"\*([^*]|\*+[^*/])*\*+"/"   
id = [a-zA-Z][a-zA-Z0-9_]*
// characc = '([^\\]|\\')'
characc = '([^\\\']|\\'|\\\\)'



 
  
%{


  private int contador = 0;  

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


  public void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
    System.out.println("Contador: " +contador);

  }
    
    
    

%}

%% // separador de areas

/* reglas lexicas */

        println            { return symbol(sym.PRINT, yytext());}
        "true"            { return symbol(sym.TRUE, yytext());}
        "false"            { return symbol(sym.FALSE, yytext());}



        "var"            { return symbol(sym.VAR, yytext());}
        "const"            { return symbol(sym.CONST, yytext());}

        "int"            { return symbol(sym.INT, yytext());}
        "double"            { return symbol(sym.DOUBLE, yytext());}
        "bool"            { return symbol(sym.BOOL, yytext());}
        "char"            { return symbol(sym.CHAR, yytext());}
        "String"            { return symbol(sym.STRING, yytext());}

        "if"            { return symbol(sym.IF, yytext());}
        "else"            { return symbol(sym.ELSE, yytext());}
        "for"            { return symbol(sym.FOR, yytext());}
        "do"            { return symbol(sym.DO, yytext());}
        "while"            { return symbol(sym.WHILE, yytext());}
        "while"            { return symbol(sym.WHILE, yytext());}
        "Break"            { return symbol(sym.BREAK, yytext());}
        "match"            { return symbol(sym.MATCH, yytext());}
        "continue"            { return symbol(sym.CONTINUE, yytext());}



        ">"            { return symbol(sym.MAYOR, yytext());}
        "<"            { return symbol(sym.MENOR, yytext());}
        ">="            { return symbol(sym.MAYOR_IGUAL, yytext());}
        "<="            { return symbol(sym.MENOR_IGUAL, yytext());}
        "="            { return symbol(sym.EQUALS, yytext());}
        "=="            { return symbol(sym.COMPARA, yytext());}

        "+"            { return symbol(sym.PLUS, yytext());}
        "-"            { return symbol(sym.MINUS, yytext());}
        "*"            { return symbol(sym.TIMES, yytext());}
        "/"            { return symbol(sym.DIVIDED, yytext());}

        "++"            { return symbol(sym.PLUSPLUS, yytext());}
        "--"            { return symbol(sym.MINUSMINUS, yytext());}

        {comment}                 { }
        {commentMultiLine}        { }

        "**"            { return symbol(sym.RAISED, yytext());}
        "%"            { return symbol(sym.MOD, yytext());}

        "^"            { return symbol(sym.XOR, yytext());}
        "||"            { return symbol(sym.OR, yytext());}
        "&&"            { return symbol(sym.AND, yytext());}
        "!"            { return symbol(sym.NOT, yytext());}

        "("            { return symbol(sym.PAREN_OPEN, yytext());}
        ")"            { return symbol(sym.PAREN_CLOSE, yytext());}

        "{"            { return symbol(sym.KEY_OPEN, yytext());}
        "}"            { return symbol(sym.KEY_CLOSE, yytext());}
        ";"            { return symbol(sym.SEMICOLON, yytext());}
        ":"            { return symbol(sym.POINTS, yytext());}




        {entero}            { return symbol(sym.ENTERO, yytext());}
        {decimal}             { return symbol(sym.DECIMAL, yytext());}



        {id}            { return symbol(sym.ID, yytext());}

        {cadena}       {String cadenaReconocida = yytext(); 
                                String cadenaEntregar = cadenaReconocida.substring(1, cadenaReconocida.length() - 1); 
                                return symbol(sym.CADENA, cadenaEntregar ); }
                                

	{WhiteSpace} 	{/* ignoramos */}




/* error fallback */
[^]                              /*{ throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }*/
			{
                            contador++;
                            error("Simbolo invalido <"+ yytext()+">");
                                
                        }
<<EOF>>                 { return symbol(sym.EOF); }