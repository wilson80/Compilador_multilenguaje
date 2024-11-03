package com.wilsoncys.compi1.java.model.analisis;


// importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.vistas.colorInfo;
import com.wilsoncys.compi1.java.vistas.TipoT;
import java.io.StringReader;
import java.io.Reader;


%%

//codigo de usuario
%{
     private Reader yyreader;

    public colorear2(String input) {
        this.yyreader = new StringReader(input); 
            }


    public LinkedList<Errores> listaErrores = new LinkedList<>();    
    
    private Symbol symbol(int type){
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol symbol(int type, Object value){
		return new Symbol(type, yyline, yycolumn, value);
	}
        StringBuilder string;
    private colorInfo colorr(TipoT type){
        return new  colorInfo(type, yychar, yylength());
    }
    private colorInfo colorSTR(TipoT type){
        return new  colorInfo(type, yychar-string.toString().length()-1,  string.toString().length()+1); 
    }



%}  

 

%init{
     
 
%init}

//caracteristicas de jflex
%public
%unicode
%class colorear2
%char
%type colorInfo 

 
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
	// return symbol(sym.EOF);

%eofval}

%%



        <YYINITIAL>{    
            "procedure"            { return colorr(TipoT.RESERV); }
            
            "%%PASCAL"            {yybegin(YYINITIAL); return colorr(TipoT.SECTION); }
            "%%JAVA"            {yybegin(JAVA); return colorr(TipoT.SECTION); }



        }
        
        <JAVA>{
         "%%PROGRAMA"          {yybegin(PROGRAMA); return colorr(TipoT.SECTION); }     


        "protected"            { return colorr(TipoT.RESERV);}
        "private"            { return colorr(TipoT.RESERV);}
        "public"            { return colorr(TipoT.RESERV);}        
        "extends"            { return colorr(TipoT.RESERV);}
        "this"            { return colorr(TipoT.RESERV);}
        "class"            { return colorr(TipoT.RESERV);}
        "print"            { return colorr(TipoT.RESERV);}
        "println"            { return colorr(TipoT.RESERV);}
        "true"            { return colorr(TipoT.RESERV);}
        "false"            { return colorr(TipoT.RESERV);}


        "int"            { return colorr(TipoT.RESERV);}
        "float"            { return colorr(TipoT.RESERV);}
        "boolean"            { return colorr(TipoT.RESERV);}
        "char"            { return colorr(TipoT.RESERV);}
        "String"            { return colorr(TipoT.RESERV);}

        "for"            { return colorr(TipoT.RESERV);}
        "while"            { return colorr(TipoT.RESERV);}
        "do"            { return colorr(TipoT.RESERV);}
        "continue"            { return colorr(TipoT.RESERV);}
        "Break"            { return colorr(TipoT.RESERV);}
        "if"            { return colorr(TipoT.RESERV);}
        "else"            { return colorr(TipoT.RESERV);}
        "switch"            { return colorr(TipoT.RESERV);}
        "case"            { return colorr(TipoT.RESERV);}
        "default"            { return colorr(TipoT.RESERV);}



        "void"            { return colorr(TipoT.TODOO);}
        "new"            { return colorr(TipoT.TODOO);}
        "return"            { return colorr(TipoT.TODOO);}
        "intinput"            { return colorr(TipoT.TODOO);}
        "floatinput"            { return colorr(TipoT.TODOO);}
        "charinput"            { return colorr(TipoT.TODOO);}



        ">="            { return colorr(TipoT.TODOO);}
        "<="            { return colorr(TipoT.TODOO);}
        ">"            { return colorr(TipoT.TODOO);}
        "<"            { return colorr(TipoT.TODOO);}
        "=="            { return colorr(TipoT.TODOO);}

        "="            { return colorr(TipoT.TODOO);}
        "++"            { return colorr(TipoT.TODOO);}
        "--"            { return colorr(TipoT.TODOO);}

        "+"            { return colorr(TipoT.SECTION);}
         "-"            { return colorr(TipoT.SECTION);}
         "*"            { return colorr(TipoT.SECTION);}
         "/"            { return colorr(TipoT.SECTION);}
        "^"            { return colorr(TipoT.SECTION);}
        "%"            { return colorr(TipoT.SECTION);}


        {comment}                 { }
        {commentMultiLine}        { }


        "||"            { return colorr(TipoT.SYMSS);}
        "&&"            { return colorr(TipoT.SYMSS);}
         "!="           {return colorr(TipoT.SYMSS);}

         "!"            { return colorr(TipoT.SYMSS);}

         "("            { return colorr(TipoT.SYMSS);}
         ")"            { return colorr(TipoT.SYMSS);}

        "{"            { return colorr(TipoT.SYMSS);}
       "}"            { return colorr(TipoT.SYMSS);}
        ";"            { return colorr(TipoT.SYMSS);}
        ":"            { return colorr(TipoT.SYMSS);}
        {Lbrack}            { return colorr(TipoT.SYMSS);}
        {Rbrack}            { return colorr(TipoT.SYMSS);}
        ","            { return colorr(TipoT.SYMSS);}
        "."            { return colorr(TipoT.SYMSS);}




        {entero}            { return colorr(TipoT.TODOO);}
        {decimal}             { return colorr(TipoT.TODOO);}



        {id}            { return colorr(TipoT.TODOO);}
        {characc}         { 
                        return colorr(TipoT.TODOO);  }

        {cadena}       {  return colorr(TipoT.TODOO);}


        }


 

        <PROGRAMA>{
            "#include"        {return colorr(TipoT.TODOO);}           
            "PASCAL"        {return colorr(TipoT.TODOO);}
            "JAVA"        {return colorr(TipoT.TODOO);}
            {JAVASIMP}            { return colorr(TipoT.TODOO);}
            {JAVAUNO}            { return colorr(TipoT.TODOO);}

            {PASCALSIMP}            { return colorr(TipoT.TODOO);}
            {PASCALUNO}            { return colorr(TipoT.TODOO);}


        "int"            { return colorr(TipoT.TODOO);}
        "char"            { return colorr(TipoT.TODOO);}
        "float"            { return colorr(TipoT.TODOO);}
        "string"            { return colorr(TipoT.TODOO);}

        "const"            { return colorr(TipoT.TODOO);}

        "if"            { return colorr(TipoT.TODOO);}
        "else"            { return colorr(TipoT.TODOO);}
        "for"            { return colorr(TipoT.TODOO);}
        "do"            { return colorr(TipoT.TODOO);}
        "while"            { return colorr(TipoT.TODOO);}
        "Break"            { return colorr(TipoT.TODOO);}
        "continue"            { return colorr(TipoT.TODOO);}
        "void"            { return colorr(TipoT.TODOO);}
        "switch"            { return colorr(TipoT.TODOO);}
        "case"            { return colorr(TipoT.TODOO);}
        "default"            { return colorr(TipoT.TODOO);}


        "scanf"        {return colorr(TipoT.TODOO);}
        "%d"        {return colorr(TipoT.TODOO);}
        "%c"        {return colorr(TipoT.TODOO);}
        "%f"        {return colorr(TipoT.TODOO);}
        "%s"        {return colorr(TipoT.TODOO);}


        "getch"        {return colorr(TipoT.TODOO);}
        "printf"        {return colorr(TipoT.TODOO);}
        "clrscr"        {return colorr(TipoT.TODOO);}
        "main"            { return colorr(TipoT.TODOO);}



        ">="            { return colorr(TipoT.TODOO);}
        "<="            { return colorr(TipoT.TODOO);}
        ">"            { return colorr(TipoT.TODOO);}
        "<"            { return colorr(TipoT.TODOO);}
        "=="            { return colorr(TipoT.TODOO);}

        "="            { return colorr(TipoT.TODOO);}
        "++"            { return colorr(TipoT.TODOO);}
        "--"            { return colorr(TipoT.TODOO);}

        "+"            { return colorr(TipoT.TODOO);}
         "-"            { return colorr(TipoT.TODOO);}
         "*"            { return colorr(TipoT.TODOO);}
         "/"            { return colorr(TipoT.TODOO);}
        "%"            { return colorr(TipoT.TODOO);}
        "^"            { return colorr(TipoT.TODOO);}


        {comment}                 { }
        {commentMultiLine}        { }


        "||"            { return colorr(TipoT.TODOO);}
        "&&"            { return colorr(TipoT.TODOO);}
        "&"            { return colorr(TipoT.TODOO);}
         "!="           {return colorr(TipoT.TODOO);}

         "!"            { return colorr(TipoT.TODOO);}

         "("            { return colorr(TipoT.TODOO);}
         ")"            { return colorr(TipoT.TODOO);}

        "{"            { return colorr(TipoT.TODOO);}
       "}"            { return colorr(TipoT.TODOO);}
        ";"            { return colorr(TipoT.TODOO);}
        ":"            { return colorr(TipoT.TODOO);}
        "_"            { return colorr(TipoT.TODOO);}
        {Lbrack}            { return colorr(TipoT.TODOO);}
        {Rbrack}            { return colorr(TipoT.TODOO);}
        ","            { return colorr(TipoT.TODOO);}
        "."            { return colorr(TipoT.TODOO);}




        {entero}            { return colorr(TipoT.TODOO);}
        {decimal}             { return colorr(TipoT.TODOO);}



        {id}            { return colorr(TipoT.TODOO);}
        {characc}         { return colorr(TipoT.TODOO); }

        {cadena}       {  return colorr(TipoT.TODOO);}

        }





     

  
 {BLANCOS} {}

 . {
                { return colorr(TipoT.ERROR); }


}