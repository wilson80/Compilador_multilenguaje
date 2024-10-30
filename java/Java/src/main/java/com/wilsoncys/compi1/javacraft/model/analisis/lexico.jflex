package com.wilsoncys.compi1.javacraft.model.analisis;


// importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import com.wilsoncys.compi1.javacraft.model.excepciones.Errores;


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

//simbolos del sistema


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

Lbrack = \[
Rbrack = \]

%eofval{
	return symbol(sym.EOF);
%eofval}

%%





       <YYINITIAL> "protected"            { return  symbol(sym.PROTECTED, yytext());}
       <YYINITIAL> "private"            { return  symbol(sym.PRIVATE, yytext());}
       <YYINITIAL> "public"            { return  symbol(sym.PUBLIC, yytext());}

       <YYINITIAL> "extends"            { return  symbol(sym.EXTENDS, yytext());}
       <YYINITIAL> "this"            { return  symbol(sym.THIS, yytext());}
       <YYINITIAL> "Main"            { return  symbol(sym.MAIN, yytext());}
       <YYINITIAL> "class"            { return  symbol(sym.CLASS, yytext());}
       <YYINITIAL> "print"            { return  symbol(sym.PRINT, yytext());}
       <YYINITIAL> "println"            { return  symbol(sym.PRINTLN, yytext());}
       <YYINITIAL> "true"            { return symbol(sym.BOOL, yytext());}
       <YYINITIAL> "false"            { return symbol(sym.BOOL, yytext());}

    

        <YYINITIAL> "var"            { return symbol(sym.VAR, yytext());}
                <YYINITIAL> "const"            { return symbol(sym.CONST, yytext());}

        <YYINITIAL> "int"            { return symbol(sym.INT, yytext());}
       <YYINITIAL> "double"            { return symbol(sym.DOUBLE, yytext());}
        <YYINITIAL>"bool"            { return symbol(sym.BOOLEAN, yytext());}
        <YYINITIAL>"char"            { return symbol(sym.CHAR, yytext());}
        <YYINITIAL>"String"            { return symbol(sym.STRING, yytext());}

        <YYINITIAL>"if"            { return symbol(sym.IF, yytext());}
        <YYINITIAL>"else"            { return symbol(sym.ELSE, yytext());}
        <YYINITIAL>"for"            { return symbol(sym.FOR, yytext());}
        <YYINITIAL>"do"            { return symbol(sym.DO, yytext());}
        <YYINITIAL>"while"            { return symbol(sym.WHILE, yytext());}
        <YYINITIAL>"while"            { return symbol(sym.WHILE, yytext());}
        <YYINITIAL>"Break"            { return symbol(sym.BREAK, yytext());}
        <YYINITIAL>"match"            { return symbol(sym.MATCH, yytext());}
        <YYINITIAL>"continue"            { return symbol(sym.CONTINUE, yytext());}



        <YYINITIAL>"void"            { return symbol(sym.VOID, yytext());}
        <YYINITIAL>"new"            { return symbol(sym.NEW, yytext());}
        <YYINITIAL>"return"            { return symbol(sym.RETURN, yytext());}
        <YYINITIAL>"intinput"            { return symbol(sym.INP_INT, yytext());}
        <YYINITIAL>"floatinput"            { return symbol(sym.INP_F, yytext());}
        <YYINITIAL>"charinput"            { return symbol(sym.INP_C, yytext());}



        <YYINITIAL>">="            { return symbol(sym.G_EQUALS, yytext());}
        <YYINITIAL>"<="            { return symbol(sym.L_EQUALS, yytext());}
        <YYINITIAL>">"            { return symbol(sym.GREATER, yytext());}
        <YYINITIAL>"<"            { return symbol(sym.LESS, yytext());}
        <YYINITIAL>"=="            { return symbol(sym.EQUALS, yytext());}
        <YYINITIAL>"=>"            { return symbol(sym.ARROW, yytext());}

        <YYINITIAL>"="            { return symbol(sym.ASSIGNMENT, yytext());}

                        <YYINITIAL>"++"            { return symbol(sym.PLUSPLUS, yytext());}
                        <YYINITIAL>"--"            { return symbol(sym.MINUSMINUS, yytext());}

        <YYINITIAL> "+"            { return symbol(sym.PLUS, yytext());}
        <YYINITIAL> "-"            { return symbol(sym.MINUS, yytext());}
        <YYINITIAL> "*"            { return symbol(sym.TIMES, yytext());}
        <YYINITIAL> "/"            { return symbol(sym.DIVIDED, yytext());}


        {comment}                 { }
        {commentMultiLine}        { }

        <YYINITIAL>"**"            { return symbol(sym.RAISED, yytext());}
        <YYINITIAL>"%"            { return symbol(sym.MOD, yytext());}

        <YYINITIAL>"^"            { return symbol(sym.XOR, yytext());}
        <YYINITIAL>"||"            { return symbol(sym.OR, yytext());}
        <YYINITIAL>"&&"            { return symbol(sym.AND, yytext());}
        <YYINITIAL> "!="           {return symbol(sym.DIFFERENT, yytext());}

        <YYINITIAL> "!"            { return symbol(sym.NOT, yytext());}

        <YYINITIAL> "("            { return symbol(sym.PAR_OP, yytext());}
        <YYINITIAL> ")"            { return symbol(sym.PAR_CL, yytext());}

        <YYINITIAL>"{"            { return symbol(sym.K_OP, yytext());}
       <YYINITIAL>"}"            { return symbol(sym.K_CL, yytext());}
        <YYINITIAL>";"            { return symbol(sym.SEMIC, yytext());}
        <YYINITIAL>":"            { return symbol(sym.POINTS, yytext());}
        <YYINITIAL>"_"            { return symbol(sym.DEFAULT, yytext());}
        <YYINITIAL>{Lbrack}            { return symbol(sym.BRACK_L, yytext());}
        <YYINITIAL>{Rbrack}            { return symbol(sym.BRACK_R, yytext());}
        <YYINITIAL>","            { return symbol(sym.COLON, yytext());}
        <YYINITIAL>"."            { return symbol(sym.DOT, yytext());}




        {entero}            { return symbol(sym.ENTERO, yytext());}
        {decimal}             { return symbol(sym.DECIMAL, yytext());}



        {id}            { return symbol(sym.ID, yytext());}
        {characc}         {String charac = yytext();
                        charac = charac.substring(1, charac.length()-1);
                        return new Symbol(sym.CHARAC, yyline, yycolumn,charac); }

        {cadena}       {String cadenaReconocida = yytext();
                        String cadenaEntregar = cadenaReconocida.substring(1, cadenaReconocida.length() - 1); 
                        return symbol(sym.CADENA, cadenaEntregar ); }





// <YYINITIAL> "imprimir" {return new Symbol(sym.IMPRIMIR, yyline, yycolumn,yytext());}
// <YYINITIAL> "true" {return new Symbol(sym.BOOL, yyline, yycolumn,yytext());}
// <YYINITIAL> "false" {return new Symbol(sym.BOOL, yyline, yycolumn,yytext());}

// <YYINITIAL> {DECIMAL} {return new Symbol(sym.DECIMAL, yyline, yycolumn,yytext());}
// <YYINITIAL> {ENTERO} {return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());}

// <YYINITIAL> {CADENA} {
//     String cadena = yytext();
//     cadena = cadena.substring(1, cadena.length()-1);
//     return new Symbol(sym.CADENA, yyline, yycolumn,cadena);
//     }

// <YYINITIAL> {CHARAC} {
//     String charac = yytext();
//     charac = charac.substring(1, charac.length()-1);
//     return new Symbol(sym.CHARAC, yyline, yycolumn,charac);
//     }

// <YYINITIAL> ";" {return new Symbol(sym.FINCADENA, yyline, yycolumn,yytext());}
// <YYINITIAL> "(" {return new Symbol(sym.PAR1, yyline, yycolumn,yytext());}
// <YYINITIAL> ")" {return new Symbol(sym.PAR2, yyline, yycolumn,yytext());}

// <YYINITIAL> "+" {return new Symbol(sym.MAS, yyline, yycolumn,yytext());}
// <YYINITIAL> "-" {return new Symbol(sym.MENOS, yyline, yycolumn,yytext());}
// <YYINITIAL> "*" {return new Symbol(sym.MULT, yyline, yycolumn,yytext());}
// <YYINITIAL> "/" {return new Symbol(sym.DIV, yyline, yycolumn,yytext());}
// <YYINITIAL> "%" {return new Symbol(sym.MOD, yyline, yycolumn,yytext());}
// <YYINITIAL> "**" {return new Symbol(sym.POT, yyline, yycolumn,yytext());}
// <YYINITIAL> ">" {return new Symbol(sym.GREATER, yyline, yycolumn,yytext());}
// <YYINITIAL> "<" {return new Symbol(sym.LESS, yyline, yycolumn,yytext());}
// <YYINITIAL> ">=" {return new Symbol(sym.G_EQUALS, yyline, yycolumn,yytext());}
// <YYINITIAL> "<=" {return new Symbol(sym.L_EQUALS, yyline, yycolumn,yytext());}
// <YYINITIAL> "==" {return new Symbol(sym.EQUALS, yyline, yycolumn,yytext());}
// <YYINITIAL> "!=" {return new Symbol(sym.DIFFERENT, yyline, yycolumn,yytext());}
// //el otro lo nombrare asignacion assignment
// <YYINITIAL> "&&" {return new Symbol(sym.AND, yyline, yycolumn,yytext());}
// <YYINITIAL> "||" {return new Symbol(sym.OR, yyline, yycolumn,yytext());}
// <YYINITIAL> "^" {return new Symbol(sym.XOR, yyline, yycolumn,yytext());}
// <YYINITIAL> "!" {return new Symbol(sym.NOT, yyline, yycolumn,yytext());}


<YYINITIAL> {BLANCOS} {}

<YYINITIAL> . {
                listaErrores.add(new Errores("LEXICO","El caracter "+
                yytext()+" NO pertenece al lenguaje", yyline, yycolumn));
}