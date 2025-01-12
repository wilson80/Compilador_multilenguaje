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
%ignorecase
 
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

SCANd = \"%d\"
SCANc = \"%c\"
SCANf = \"%f\"
SCANs = \"%s\"


Lbrack = \[
Rbrack = \]


//#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$
                        // PASCAL
//#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$
NQUOTE = [^']
PAREN_OP = "("
PAREN_CL = ")"
keyOP = "{"
keyCl = "}"
// cadena = \"([^\"\\]|(\\\'|\\\"|\\\\|\\t|\\n))*\"
// cadena = \'([^\'\\]|(\\\'|\\\'|\\\\|\\t|\\n))*\'   //da error cuando solo hay un caracter
// cadena = \'([^\']     |       (\\\'|\\\'|\\\\|\\t|\\n))*\'
// cadena = \'([^\\\']*|[^\\\'])\'         //no funciona
// cadena = \'.*?\'                     

// cadena = \'([^\\\'])*\'         //no funciona 'd'  esto si 'aa'
cadenaP =  '({NQUOTE}|'')*'      //no funciona 'd'  esto si 'aa'
id = [a-zA-Z][a-zA-Z0-9_]*
characcP = '([^\\\']|\\'|\\\\|\\n|\\t|\\r|\\"")'
// specialSimbols = []
/* */

// characc = '[^\']'
// characc = ([^\\']|\\'|\\\\|\\n|\\t|\\r|\\")
commentMultiLineP = \(\*([^*]|\*[^)])*\*\)
//#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$












%eofval{
	return symbol(sym.EOF);
%eofval}

%%
    
        <YYINITIAL>{    
            "%%PASCAL"            {yybegin(YYINITIAL);}
            "%%JAVA"            {yybegin(JAVA);}
        "and"            { return  symbol(sym.AND, yytext());}
        "array"            { return  symbol(sym.ARRAY, yytext());}
        "begin"            { return  symbol(sym.BEGIN, yytext());}
        "else"            { return  symbol(sym.ELSE, yytext());}
        "case"            { return  symbol(sym.CASE, yytext());}
//         "const"            { return  symbol(sym.CONST, yytext());}
        "do"            { return  symbol(sym.DO, yytext());}
        "end"            { return  symbol(sym.END, yytext());}
        "for"            { return  symbol(sym.FOR, yytext());}
        "function"            { return  symbol(sym.FUNCTION, yytext());}
        "if"            { return  symbol(sym.IF, yytext());}
//         "label"            { return  symbol(sym.LABEL, yytext());}
        "mod"            { return  symbol(sym.MOD, yytext());}
        "not"            { return  symbol(sym.NOT, yytext());}
        "of"            { return  symbol(sym.OF, yytext());}
        "or"            { return  symbol(sym.OR, yytext());}
        "procedure"            { return  symbol(sym.PROCEDURE, yytext());}
        "repeat"            { return  symbol(sym.REPEAT, yytext());}
        "then"            { return  symbol(sym.THEN, yytext());}
        "to"            { return  symbol(sym.TO, yytext());}
        "until"            { return  symbol(sym.UNTIL, yytext());}
        "var"            { return  symbol(sym.VAR, yytext());}
        "while"            { return  symbol(sym.WHILE, yytext());}
        "println"            { return  symbol(sym.PRINTLN, yytext());}
        "readln"            { return  symbol(sym.READLN, yytext());}
        "break"            { return  symbol(sym.BREAK, yytext());}
        "continue"            { return  symbol(sym.CONTINUE, yytext());}

// boolean para false  = 0
// para true = cualquier numero de 0


         "integer"            { return symbol(sym.INT, yytext());}
        "real"            { return symbol(sym.REAL, yytext());}
        "boolean"            { return symbol(sym.BOOLEAN, yytext());}
        "char"            { return symbol(sym.CHAR, yytext());}
        "String"            { return symbol(sym.STRING, yytext());}

        // <YYINITIAL>"VOID"            { return symbol(sym.VOID, yytext());}


//relacionales
         ">="            { return symbol(sym.G_EQUALS, yytext());}
         "<="            { return symbol(sym.L_EQUALS, yytext());}
         ">"            { return symbol(sym.GREATER, yytext());}
         "<"            { return symbol(sym.LESS, yytext());}

        "="            { return symbol(sym.EQUALS, yytext());}
//assignment
        ":="            { return symbol(sym.ASSIGNMENT, yytext());}



//operadores aritmeticos
         "+"            { return symbol(sym.PLUS, yytext());}
         "-"            { return symbol(sym.MINUS, yytext());}
         "*"            { return symbol(sym.TIMES, yytext());}
         "div"            { return symbol(sym.DIVIDED, yytext());}

//operadores booleanos




//comentario una linea
        {keyOP}[^\n]* {keyCl}                 { }
//comentario multilinea
        // {PAREN_OP}[\*][^]*[\*] {PAREN_CL}        { }
        {commentMultiLineP}        { }


        <YYINITIAL> "<>"           {return symbol(sym.DIFFERENT, yytext());}


        {PAREN_OP}            { return symbol(sym.PAR_OP, yytext());}
        {PAREN_CL}            { return symbol(sym.PAR_CL, yytext());}

          {keyOP}          { return symbol(sym.K_OP, yytext());}
          {keyCl}            { return symbol(sym.K_CL, yytext());}

        <YYINITIAL>";"            { return symbol(sym.SEMIC, yytext());}
        <YYINITIAL>{Lbrack}            { return symbol(sym.BRACK_L, yytext());}
        <YYINITIAL>{Rbrack}            { return symbol(sym.BRACK_R, yytext());}
        <YYINITIAL>","            { return symbol(sym.COLON, yytext());}
        <YYINITIAL>"."            { return symbol(sym.DOT, yytext());}
        <YYINITIAL>":"            { return symbol(sym.POINTS, yytext());}


        {entero}            { return symbol(sym.ENTERO, yytext());}
        {decimal}             { return symbol(sym.DECIMAL, yytext());}



        {id}            { return symbol(sym.ID, yytext());}
        {characcP}         {String charac = yytext();
                        charac = charac.substring(1, charac.length()-1);
                        return new Symbol(sym.CHARAC, yyline, yycolumn,charac); }

        {cadenaP}       {String cadenaReconocida = yytext();
                        String cadenaEntregar = cadenaReconocida.substring(1, cadenaReconocida.length() - 1); 
                        return symbol(sym.CADENA, cadenaEntregar ); }
 
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
        "null"            { return symbol(sym.NULL, yytext());}


        "int"            { return symbol(sym.INT, yytext());}
        "double"            { return symbol(sym.DOUBLE, yytext());}
        "boolean"            { return symbol(sym.BOOLEAN, yytext());}
        "char"            { return symbol(sym.CHAR, yytext());}
        "String"            { return symbol(sym.STRING, yytext());}

        "for"            { return symbol(sym.FOR, yytext());}
        "while"            { return symbol(sym.WHILE, yytext());}
        "do"            { return symbol(sym.DO, yytext());}
        "continue"            { return symbol(sym.CONTINUE, yytext());}
        "break"            { return symbol(sym.BREAK, yytext());}
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
            {PASCALSIMP}            { return  symbol(sym.PASCALSIMP, yytext());}
            
            // {JAVAUNO}            { return  symbol(sym.JAVAUNO, yytext());}
            {JAVAUNO} { 
                String id = yytext().substring(6, yytext().length() - 1); // extrae el id
                return symbol(sym.JAVAUNO, id); 
            }

            // {PASCALUNO}            { return  symbol(sym.PASCALUNO, yytext());}
            {PASCALUNO}            { 
                String id = yytext().substring(8, yytext().length() - 1); // extrae el id
                return symbol(sym.PASCALUNO, id); 
            }


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
        "break"            { return symbol(sym.BREAK, yytext());}
        "continue"            { return symbol(sym.CONTINUE, yytext());}
        "void"            { return symbol(sym.VOID, yytext());}
        "switch"            { return symbol(sym.SWITCH, yytext());}
        "case"            { return symbol(sym.CASE, yytext());}
        "default"            { return symbol(sym.DEFAULT, yytext());}


        "scanf"        {return symbol(sym.SCAN, yytext());}
        {SCANd}        { String idd = "d";
            return symbol(sym.MASK_D, idd); }
        {SCANc}        { String idd = "c";
            return symbol(sym.MASK_C, idd);}
        {SCANf}        { String idd = "f";
            return symbol(sym.MASK_F, idd);}
        {SCANs}        { String idd = "s";
            return symbol(sym.MASK_S, idd);}
 

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
        "default"            { return symbol(sym.DEFAULT, yytext());}
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