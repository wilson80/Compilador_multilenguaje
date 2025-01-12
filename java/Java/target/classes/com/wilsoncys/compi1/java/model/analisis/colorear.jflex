package com.wilsoncys.compi1.java.model.analisis;


// importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.vistas.colorInfo;
import com.wilsoncys.compi1.java.vistas.TipoT; 


%%

//codigo de usuario
%{
    //  private Reader yyreader;

    // public colorear2(String input) {
    //     this.yyreader = new StringReader(input); 
    //         }

                    //linea que provocaba el sobre elvado uso del procesador 
    // public LinkedList<Errores> listaErrores = new LinkedList<>();   
    
 
        StringBuilder string;
    private colorInfo colorr(TipoT type){
        return new  colorInfo(type, yychar, yylength());
    }
    private colorInfo colorSTR(TipoT type){
        return new  colorInfo(type, yychar-string.toString().length()-1,  string.toString().length()+1); 
    }
 


%}  

 

%init{
    string = new StringBuilder();
     
 
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





%%



        <YYINITIAL>{    
             "%%PASCAL"            {yybegin(YYINITIAL); return colorr(TipoT.SECTION); }
            "%%JAVA"            {yybegin(JAVA); return colorr(TipoT.SECTION); }
   
        "and"            { return colorr(TipoT.RESERV);}
        "array"            { return colorr(TipoT.RESERV);}
        "begin"            { return colorr(TipoT.RESERV);}
        "else"            { return colorr(TipoT.RESERV);}
        "case"            { return colorr(TipoT.RESERV);}
//         "const"            { return colorr(TipoT.RESERV);}
        "do"            { return colorr(TipoT.RESERV);}
        "end"            { return colorr(TipoT.RESERV);}
        "for"            { return colorr(TipoT.RESERV);}
        "function"            { return colorr(TipoT.RESERV);}
        "if"            { return colorr(TipoT.RESERV);}
//         "label"            { return colorr(TipoT.RESERV);}
        "mod"            { return colorr(TipoT.RESERV);}
        "not"            { return colorr(TipoT.RESERV);}
        "of"            { return colorr(TipoT.RESERV);}
        "or"            { return colorr(TipoT.RESERV);}
        "procedure"            { return colorr(TipoT.RESERV);}
        "repeat"            { return colorr(TipoT.RESERV);}
        "then"            { return colorr(TipoT.RESERV);}
        "to"            { return colorr(TipoT.RESERV);}
        "until"            { return colorr(TipoT.RESERV);}
        "var"            { return colorr(TipoT.RESERV);}
        "while"            { return colorr(TipoT.RESERV);}
        "println"            { return colorr(TipoT.RESERV);}
        "readln"            { return colorr(TipoT.RESERV);}
        "break"            { return colorr(TipoT.RESERV);}
        "continue"            { return colorr(TipoT.RESERV);}

// boolean para false  = 0
// para true = cualquier numero de 0


         "integer"            { return colorr(TipoT.RESERV);}
        "real"            { return colorr(TipoT.RESERV);}
        "boolean"            { return colorr(TipoT.RESERV);}
        "char"            { return colorr(TipoT.RESERV);}
        "String"            { return colorr(TipoT.RESERV);}

        // <YYINITIAL>"VOID"            { return symbol(sym.VOID, yytext());}


//relacionales
         ">="            { return colorr(TipoT.SYMSS);}
         "<="            { return colorr(TipoT.SYMSS);}
         ">"             { return colorr(TipoT.SYMSS);}
         "<"             { return colorr(TipoT.SYMSS);}

        "="            { return colorr(TipoT.SYMSS);}
//assignment
        ":="            { return colorr(TipoT.SYMSS);}



//operadores aritmeticos
         "+"            { return colorr(TipoT.SYMSS);}
         "-"            { return colorr(TipoT.SYMSS);}
         "*"            { return colorr(TipoT.SYMSS);}
         "div"          { return colorr(TipoT.SYMSS);}

//operadores booleanos




//comentario una linea
        {keyOP}[^\n]* {keyCl}                { }
//comentario multilinea
        // {PAREN_OP}[\*][^]*[\*] {PAREN_CL}        { }
        {commentMultiLineP}       {return colorr(TipoT.COMMENT); }


        <YYINITIAL> "<>"           { return colorr(TipoT.SYMSS);}


        {PAREN_OP}            {return colorr(TipoT.COMMENT); }
        {PAREN_CL}            {return colorr(TipoT.COMMENT); }

          {keyOP}          {return colorr(TipoT.COMMENT); }
          {keyCl}            {return colorr(TipoT.COMMENT); }

        <YYINITIAL>";"            { return colorr(TipoT.SYMSS);}
        <YYINITIAL>{Lbrack}            {return colorr(TipoT.COMMENT); }
        <YYINITIAL>{Rbrack}            {return colorr(TipoT.COMMENT); }
        <YYINITIAL>","            { return colorr(TipoT.SYMSS);}
        <YYINITIAL>"."            { return colorr(TipoT.SYMSS);}
        <YYINITIAL>":"            { return colorr(TipoT.SYMSS);}


        {entero}            { return colorr(TipoT.VAL);}
        {decimal}             { return colorr(TipoT.VAL);}



        {id}             { return colorr(TipoT.VAL);}
        {characcP}         { return colorr(TipoT.VAL);}

        {cadenaP}       { return colorr(TipoT.VAL);}
 
        
         
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



        "void"            { return colorr(TipoT.RESERV);}
        "new"            { return colorr(TipoT.RESERV);}
        "return"            { return colorr(TipoT.RESERV);}
        "intinput"            { return colorr(TipoT.RESERV);}
        "floatinput"            { return colorr(TipoT.RESERV);}
        "charinput"            { return colorr(TipoT.RESERV);}



        ">="            { return colorr(TipoT.SYMSS);}
        "<="            { return colorr(TipoT.SYMSS);}
        ">"            { return colorr(TipoT.SYMSS);}
        "<"            { return colorr(TipoT.SYMSS);}
        "=="            { return colorr(TipoT.SYMSS);}

        "="            { return colorr(TipoT.SYMSS);}
        "++"            { return colorr(TipoT.SYMSS);}
        "--"            { return colorr(TipoT.SYMSS);}

        "+"            { return colorr(TipoT.SYMSS);}
         "-"            { return colorr(TipoT.SYMSS);}
         "*"            { return colorr(TipoT.SYMSS);}
         "/"            { return colorr(TipoT.SYMSS);}
        "^"            { return colorr(TipoT.SYMSS);}
        "%"            { return colorr(TipoT.SYMSS);}


        {comment}                 {return colorr(TipoT.COMMENT); }
        {commentMultiLine}        { return colorr(TipoT.COMMENT);}


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




        {entero}            { return colorr(TipoT.VAL);}
        {decimal}             { return colorr(TipoT.VAL);}

        {id}            { return colorr(TipoT.VAL);}
        {characc}         { 
                        return colorr(TipoT.VAL);  }

        {cadena}       {  return colorr(TipoT.VAL);}


        }


 

        <PROGRAMA>{
            "#include"        {return colorr(TipoT.TODOO);}           
            "PASCAL"        {return colorr(TipoT.TODOO);}
            "JAVA"        {return colorr(TipoT.TODOO);}
            {JAVASIMP}            { return colorr(TipoT.TODOO);}
            {JAVAUNO}            { return colorr(TipoT.TODOO);}

            {PASCALSIMP}            { return colorr(TipoT.TODOO);}
            {PASCALUNO}            { return colorr(TipoT.TODOO);}


        "int"            { return colorr(TipoT.RESERV);}
        "char"            { return colorr(TipoT.RESERV);}
        "float"            { return colorr(TipoT.RESERV);}
        "string"            { return colorr(TipoT.RESERV);}

        "const"            { return colorr(TipoT.RESERV);}

        "if"            { return colorr(TipoT.RESERV);}
        "else"            { return colorr(TipoT.RESERV);}
        "for"            { return colorr(TipoT.RESERV);}
        "do"            { return colorr(TipoT.RESERV);}
        "while"            { return colorr(TipoT.RESERV);}
        "Break"            { return colorr(TipoT.RESERV);}
        "continue"            { return colorr(TipoT.RESERV);}
        "void"            { return colorr(TipoT.RESERV);}
        "switch"            { return colorr(TipoT.RESERV);}
        "case"            { return colorr(TipoT.RESERV);}
        "default"            { return colorr(TipoT.RESERV);}

        "scanf"        {return colorr(TipoT.RESERV);}

        "%d"        {return colorr(TipoT.SYMSS);}
        "%c"        {return colorr(TipoT.SYMSS);}
        "%f"        {return colorr(TipoT.SYMSS);}
        "%s"        {return colorr(TipoT.SYMSS);}


        "getch"        {return colorr(TipoT.RESERV);}
        "printf"        {return colorr(TipoT.RESERV);}
        "clrscr"        {return colorr(TipoT.RESERV);}
        "main"            { return colorr(TipoT.RESERV);}



        ">="            { return colorr(TipoT.SYMSS);}
        "<="            { return colorr(TipoT.SYMSS);}
        ">"            { return colorr(TipoT.SYMSS);}
        "<"            { return colorr(TipoT.SYMSS);}
        "=="            { return colorr(TipoT.SYMSS);}

        "="            { return colorr(TipoT.SYMSS);}
        "++"            { return colorr(TipoT.SYMSS);}
        "--"            { return colorr(TipoT.SYMSS);}

        "+"            { return colorr(TipoT.SYMSS);}
         "-"            { return colorr(TipoT.SYMSS);}
         "*"            { return colorr(TipoT.SYMSS);}
         "/"            { return colorr(TipoT.SYMSS);}
        "%"            { return colorr(TipoT.SYMSS);} 
        "^"            { return colorr(TipoT.SYMSS);}


        {comment}                 { return colorr(TipoT.COMMENT);}
        {commentMultiLine}        {return colorr(TipoT.COMMENT); }


        "||"            { return colorr(TipoT.SYMSS);}
        "&&"            { return colorr(TipoT.SYMSS);}
        "&"            { return colorr(TipoT.SYMSS);}
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




        {entero}            { return colorr(TipoT.VAL);}
        {decimal}             { return colorr(TipoT.VAL);}



        {id}            { return colorr(TipoT.VAL);}
        {characc}         { return colorr(TipoT.VAL); }

        {cadena}       {  return colorr(TipoT.VAL);}

        }





     

  
 {BLANCOS} {}

 . {
                { return colorr(TipoT.ERROR); }


}