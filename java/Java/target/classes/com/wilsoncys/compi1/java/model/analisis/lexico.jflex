package com.wilsoncys.compi1.java.model.analisis;


// importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import com.wilsoncys.compi1.java.model.excepciones.Errores;


%%

//codigo de usuario
%{
    public LinkedList<Errores> listaErrores = new LinkedList<>();    
    
    private Symbol symbol(int type){
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol symbol(int type, Object value){
		return new Symbol(type, yyline, yycolumn, value);
	}
%}  

%init{
    // sout.println("teto aanlizarrrrrrr: " + yytext());
    yyline = 1;
    yycolumn = 1;
    listaErrores = new LinkedList<>();
%init}

//caracteristicas de jflex
%cup
%class scanner
%public
%line
%char
%column
%full
//%debug
// %ignorecase
 
%state JAVA
%state PROGRAMA



BLANCOS=[\ \r\t\f\n]+
entero = [0-9]+
decimal = [0-9]+ "."[0-9][0-9]*
cadena = \"([^\"\\]|(\\\'|\\\"|\\\\|\\t|\\n))*\"
comment = "//"[^\n]*
commentMultiLine = "/"\*([^*]|\*+[^*/])*\*+"/"   
id = [a-zA-Z][a-zA-Z0-9_]*
// characc = '[^\']+'
characc = '([^\\\']|\\'|\\\\|\\n|\\t|\\r|\\"")'
// characc = ([^\\']|\\'|\\\\|\\n|\\t|\\r|\\")

JAVASIMP = \"JAVA\.\*\"
PASCALSIMP = \"PASCAL\"

JAVAUNO = \"JAVA\.{id}\"
PASCALUNO = \"PASCAL\.{id}\"
Lbrack = \[
Rbrack = \]


%eofval{
	return symbol(sym.EOF);
%eofval}

%%
    
        <YYINITIAL>{    
            "procedure"            { return  symbol(sym.PROCEDURE, yytext());}
            
            "%%PASCAL"            {yybegin(YYINITIAL);}
            "%%JAVA"            {yybegin(JAVA);}



        }
        
        <JAVA>{
         "%%PROGRAMA"          {yybegin(PROGRAMA);}     


        "protected"            { return  symbol(sym.PROTECTED, yytext());}
        "private"            { return  symbol(sym.PRIVATE, yytext());}
        "public"            { return  symbol(sym.PUBLIC, yytext());}        
        "extends"            { return  symbol(sym.EXTENDS, yytext());}
        "this"            { return  symbol(sym.THIS, yytext());}
        "class"            { return  symbol(sym.CLASS, yytext());}
        "print"            { return  symbol(sym.PRINT, yytext());}
        "println"            { return  symbol(sym.PRINTLN, yytext());}
        "true"            { return symbol(sym.BOOL, yytext());}
        "false"            { return symbol(sym.BOOL, yytext());}


        "int"            { return symbol(sym.INT, yytext());}
        "float"            { return symbol(sym.DOUBLE, yytext());}
        "boolean"            { return symbol(sym.BOOLEAN, yytext());}
        "char"            { return symbol(sym.CHAR, yytext());}
        "String"            { return symbol(sym.STRING, yytext());}

        "for"            { return symbol(sym.FOR, yytext());}
        "while"            { return symbol(sym.WHILE, yytext());}
        "do"            { return symbol(sym.DO, yytext());}
        "continue"            { return symbol(sym.CONTINUE, yytext());}
        "Break"            { return symbol(sym.BREAK, yytext());}
        "if"            { return symbol(sym.IF, yytext());}
        "else"            { return symbol(sym.ELSE, yytext());}
        "switch"            { return symbol(sym.SWITCH, yytext());}
        "case"            { return symbol(sym.CASE, yytext());}
        "default"            { return symbol(sym.DEFAULT, yytext());}



        "void"            { return symbol(sym.VOID, yytext());}
        "new"            { return symbol(sym.NEW, yytext());}
        "return"            { return symbol(sym.RETURN, yytext());}
        "intinput"            { return symbol(sym.INP_INT, yytext());}
        "floatinput"            { return symbol(sym.INP_F, yytext());}
        "charinput"            { return symbol(sym.INP_C, yytext());}



        ">="            { return symbol(sym.G_EQUALS, yytext());}
        "<="            { return symbol(sym.L_EQUALS, yytext());}
        ">"            { return symbol(sym.GREATER, yytext());}
        "<"            { return symbol(sym.LESS, yytext());}
        "=="            { return symbol(sym.EQUALS, yytext());}

        "="            { return symbol(sym.ASSIGNMENT, yytext());}
        "++"            { return symbol(sym.PLUSPLUS, yytext());}
        "--"            { return symbol(sym.MINUSMINUS, yytext());}

        "+"            { return symbol(sym.PLUS, yytext());}
         "-"            { return symbol(sym.MINUS, yytext());}
         "*"            { return symbol(sym.TIMES, yytext());}
         "/"            { return symbol(sym.DIVIDED, yytext());}
        "^"            { return symbol(sym.RAISED, yytext());}
        "%"            { return symbol(sym.MOD, yytext());}


        {comment}                 { }
        {commentMultiLine}        { }


        "||"            { return symbol(sym.OR, yytext());}
        "&&"            { return symbol(sym.AND, yytext());}
         "!="           {return symbol(sym.DIFFERENT, yytext());}

         "!"            { return symbol(sym.NOT, yytext());}

         "("            { return symbol(sym.PAR_OP, yytext());}
         ")"            { return symbol(sym.PAR_CL, yytext());}

        "{"            { return symbol(sym.K_OP, yytext());}
       "}"            { return symbol(sym.K_CL, yytext());}
        ";"            { return symbol(sym.SEMIC, yytext());}
        ":"            { return symbol(sym.POINTS, yytext());}
        {Lbrack}            { return symbol(sym.BRACK_L, yytext());}
        {Rbrack}            { return symbol(sym.BRACK_R, yytext());}
        ","            { return symbol(sym.COLON, yytext());}
        "."            { return symbol(sym.DOT, yytext());}




        {entero}            { return symbol(sym.ENTERO, yytext());}
        {decimal}             { return symbol(sym.DECIMAL, yytext());}



        {id}            { return symbol(sym.ID, yytext());}
        {characc}         {String charac = yytext();
                        charac = charac.substring(1, charac.length()-1);
                        return new Symbol(sym.CHARAC, yyline, yycolumn,charac); }

        {cadena}       {String cadenaReconocida = yytext();
                        String cadenaEntregar = cadenaReconocida.substring(1, cadenaReconocida.length() - 1); 
                        return symbol(sym.CADENA, cadenaEntregar ); }


        }


 

        <PROGRAMA>{
            "#include"        {return symbol(sym.INCLUDE, yytext());}           
            "PASCAL"        {return symbol(sym.PASCAL, yytext());}
            "JAVA"        {return symbol(sym.JAVA, yytext());}
            {JAVASIMP}            { return  symbol(sym.JAVATODO, yytext());}
            {JAVAUNO}            { return  symbol(sym.JAVAUNO, yytext());}

            {PASCALSIMP}            { return  symbol(sym.PASCALSIMP, yytext());}
            {PASCALUNO}            { return  symbol(sym.PASCALUNO, yytext());}


        "int"            { return symbol(sym.INT, yytext());}
        "char"            { return symbol(sym.CHAR, yytext());}
        "float"            { return symbol(sym.DOUBLE, yytext());}
        "string"            { return symbol(sym.STRING, yytext());}

        "const"            { return symbol(sym.CONST, yytext());}

        "if"            { return symbol(sym.IF, yytext());}
        "else"            { return symbol(sym.ELSE, yytext());}
        "for"            { return symbol(sym.FOR, yytext());}
        "do"            { return symbol(sym.DO, yytext());}
        "while"            { return symbol(sym.WHILE, yytext());}
        "Break"            { return symbol(sym.BREAK, yytext());}
        "continue"            { return symbol(sym.CONTINUE, yytext());}
        "void"            { return symbol(sym.VOID, yytext());}
        "switch"            { return symbol(sym.SWITCH, yytext());}
        "case"            { return symbol(sym.CASE, yytext());}
        "default"            { return symbol(sym.DEFAULT, yytext());}


        "scanf"        {return symbol(sym.SCAN, yytext());}
        "%d"        {return symbol(sym.MASK_D, yytext());}
        "%c"        {return symbol(sym.MASK_C, yytext());}
        "%f"        {return symbol(sym.MASK_F, yytext());}
        "%s"        {return symbol(sym.MASK_S, yytext());}


        "getch"        {return symbol(sym.GETCH, yytext());}
        "printf"        {return symbol(sym.PRINT, yytext());}
        "clrscr"        {return symbol(sym.CLRSCR, yytext());}
        "main"            { return  symbol(sym.MAIN, yytext());}



        ">="            { return symbol(sym.G_EQUALS, yytext());}
        "<="            { return symbol(sym.L_EQUALS, yytext());}
        ">"            { return symbol(sym.GREATER, yytext());}
        "<"            { return symbol(sym.LESS, yytext());}
        "=="            { return symbol(sym.EQUALS, yytext());}

        "="            { return symbol(sym.ASSIGNMENT, yytext());}
        "++"            { return symbol(sym.PLUSPLUS, yytext());}
        "--"            { return symbol(sym.MINUSMINUS, yytext());}

        "+"            { return symbol(sym.PLUS, yytext());}
         "-"            { return symbol(sym.MINUS, yytext());}
         "*"            { return symbol(sym.TIMES, yytext());}
         "/"            { return symbol(sym.DIVIDED, yytext());}
        "%"            { return symbol(sym.MOD, yytext());}
        "^"            { return symbol(sym.RAISED, yytext());}


        {comment}                 { }
        {commentMultiLine}        { }


        "||"            { return symbol(sym.OR, yytext());}
        "&&"            { return symbol(sym.AND, yytext());}
        "&"            { return symbol(sym.ANDSIMPLE, yytext());}
         "!="           {return symbol(sym.DIFFERENT, yytext());}

         "!"            { return symbol(sym.NOT, yytext());}

         "("            { return symbol(sym.PAR_OP, yytext());}
         ")"            { return symbol(sym.PAR_CL, yytext());}

        "{"            { return symbol(sym.K_OP, yytext());}
       "}"            { return symbol(sym.K_CL, yytext());}
        ";"            { return symbol(sym.SEMIC, yytext());}
        ":"            { return symbol(sym.POINTS, yytext());}
        "_"            { return symbol(sym.DEFAULT, yytext());}
        {Lbrack}            { return symbol(sym.BRACK_L, yytext());}
        {Rbrack}            { return symbol(sym.BRACK_R, yytext());}
        ","            { return symbol(sym.COLON, yytext());}
        "."            { return symbol(sym.DOT, yytext());}




        {entero}            { return symbol(sym.ENTERO, yytext());}
        {decimal}             { return symbol(sym.DECIMAL, yytext());}



        {id}            { return symbol(sym.ID, yytext());}
        {characc}         {String charac = yytext();
                        charac = charac.substring(1, charac.length()-1);
                        return new Symbol(sym.CHARAC, yyline, yycolumn,charac); }

        {cadena}       {String cadenaReconocida = yytext();
                        String cadenaEntregar = cadenaReconocida.substring(1, cadenaReconocida.length() - 1); 
                        return symbol(sym.CADENA, cadenaEntregar ); }

        }





 



 {BLANCOS} {}

 . {
                listaErrores.add(new Errores("LEXICO","El caracter "+
                yytext()+" NO pertenece al lenguaje", yyline, yycolumn));
}