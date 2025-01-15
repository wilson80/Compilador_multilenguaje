#include <iostream>
#include <termios.h>
#include <unistd.h>
using namespace std;

int stackint[10000];
string stackstring[10000];
float stackfloat[10000];
char stackchar[10000];
int heapint[10000];
string heapstring[10000];
float heapfloat[10000];
char heapchar[10000];
int ptr = 0;
int h = 0;





 








int getchint() {
    struct termios oldt, newt;
    char ch;
    tcgetattr(STDIN_FILENO, &oldt);           // Guardar configuración actual del terminal
    newt = oldt;
    newt.c_lflag &= ~(ICANON | ECHO);         // Desactivar modo canónico y eco
    tcsetattr(STDIN_FILENO, TCSANOW, &newt);  // Aplicar nueva configuración
    ch = getchar();                           // Leer un carácter
    tcsetattr(STDIN_FILENO, TCSANOW, &oldt);  // Restaurar configuración original
    return static_cast<int>(ch);              // Retornar el valor ASCII como entero
}


void passumarintint(){
string string137;
int int138;
int int139;
string string140;
int int141;
int int142;
string string143;
int int144;
int int145;
int int146;
int int147;
int int148;
int int149;
int int150;
int int151;
int int152;
int int153;
int int154;

string137 = "impresion desde pascal sumar";

cout<<string137;
int138 = ptr + 3;
int139 = stackint[int138];


cout<<int139;
cout<<endl;
string140 = "impresion desde pascal sumar";

cout<<string140;
int141 = ptr + 4;
int142 = stackint[int141];


cout<<int142;
cout<<endl;
string143 = "total desdeee pascal";

cout<<string143;
int144 = ptr + 6;
int145 = stackint[int144];


cout<<int145;
cout<<endl;
int146 = ptr + 3;
int147 = stackint[int146];

int148 = ptr + 4;
int149 = stackint[int148];

int150 = int147+int149;
int151 = ptr + 5;
stackint[int151] = int150;


int152 = ptr + 5;
int153 = stackint[int152];

int154 = ptr + 1;
stackint[int154] = int153;


retorno136:
    cout<< " ";
}

void pashellowintint(){
string string155;
string string156;
int int157;
int int158;
char char159;
int int160;
int int161;
string string162;
int int163;
int int164;
int int165;
int int166;
int int167;
int int168;
int int169;
string155 = "Hello, World!";

cout<<string155;
cout<<endl;
string156 = "hos es /";

cout<<string156;
int157 = ptr + 2;
int158 = stackint[int157];


cout<<int158;
char159 = '/';

cout<<char159;
int160 = ptr + 3;
int161 = stackint[int160];


cout<<int161;
cout<<endl;
string162 = "uno + dos) por 3: ";

cout<<string162;
int163 = ptr + 4;
int164 = stackint[int163];

int165 = ptr + 5;
int166 = stackint[int165];

int167 = int164+int166;
int168 = 3;
int169 = int167*int168;

cout<<int169;
cout<<endl;
retorno1:
    cout<< " ";
}




int main(){
int int0;
int int1;
int int2;
int int3;
int int4;
int int5;
int int6;
int int7;
int int8;
int int9;
int int10;
int int11;
int int12;
int int13;
int int14;
int int15;
int int16;
int int17;
int int18;
int int19;
int int20;
int int21;
int int22;
int int23;
int int24;
int int25;
int int26;
int int27;
int int28;
int int29;
int int30;
int int31;
int int32;
int int33;
int int34;
int int35;
int int36;
int int37;
int int42;
int int43;
int int44;
int int46;
int int47;
int int48;
int int49;
int int54;
int int55;
int int57;
int int58;
int int59;
int int64;
int int65;
int int66;
int int67;
int int69;
int int70;
int int71;
int int72;
int int75;
int int76;
int int80;
int int81;
int int82;
int int84;
int int85;
int int86;
int int87;
int int88;
int int89;
int int90;
int int91;
int int96;
int int97;
int int98;
int int99;
int int100;
int int105;
int int106;
int int107;
int int111;
int int112;
int int113;
int int114;
int int115;
int int116;
int int117;
int int118;
int int119;
int int120;
int int121;
int int122;
int int126;
int int127;
int int128;
int int129;
int int130;
int int131;
int int132;
int int133;
int int134;
int int135;


int0 = 10;
int1 = ptr + 0;
stackint[int1] = int0;

int2 = 20;
int3 = ptr + 1;
stackint[int3] = int2;

int4 = 30;
int5 = ptr + 2;
stackint[int5] = int4;

int6 = 40;
int7 = ptr + 3;
stackint[int7] = int6;

int8 = 50;
int9 = ptr + 4;
stackint[int9] = int8;

int10 = 50;
int11 = ptr + 6;
stackint[int11] = int10;

int12 = 5;
int13 = ptr + 7;
stackint[int13] = int12;

int14 = 10;
int15 = ptr + 8;
stackint[int15] = int14;



//invocacion a subP de pascal, id: hellow
int16 = ptr + 9;

int17 = 12;
int18 = 1;
int19 = int16 + 2;
stackint[int19] = int17;

int20 = int16 + 3;
stackint[int20] = int18;

ptr = ptr + 9;
pashellowintint();
ptr = ptr - 9;


//invocacion a subP de pascal, id: sumar
int21 = ptr + 9;

int22 = ptr + 0;
int23 = stackint[int22];

int24 = ptr + 1;
int25 = stackint[int24];

int26 = int21 + 3;
stackint[int26] = int23;

int27 = int21 + 4;
stackint[int27] = int25;

ptr = ptr + 9;
passumarintint();
ptr = ptr - 9;
int28 = ptr + 9;

int29 = int28 + 1;
int30 = stackint[int29];

int31 = ptr + 5;
stackint[int31] = int30;


int32 = ptr + 0;
int33 = stackint[int32];


cout<<"retorno de pascallll ";

cout<<int33;
int34 = ptr + 1;
int35 = stackint[int34];


cout<<"   con ";

cout<<int35;
int36 = ptr + 5;
int37 = stackint[int36];


cout<<" es: ";

cout<<int37;
cout<<endl;
cout<<"test de AND";
cout<<endl;int42 = 15;
int43 = ptr + 7;
int44 = stackint[int43];

if(int42>int44)goto cmpOp245;
goto else40;
int46 = ptr + 6;
int47 = stackint[int46];

int48 = ptr + 7;
int49 = stackint[int48];

cmpOp245:
if(int47>int49)goto if38;
goto else40;
if38:

cout<<"444 es mayor que 2";
cout<<endl;
goto salida39;
else40:

cout<<"else and";
cout<<endl;
salida39:

cout<<"test de OR";
cout<<endl;int54 = 1;
int55 = 1;
if(int54>int55)goto if50;
goto cmpOp256;
int57 = ptr + 6;
int58 = stackint[int57];

int59 = 2;
cmpOp256:
if(int58>int59)goto if50;
goto else52;
if50:

cout<<"444 es mayor que 2";
cout<<endl;
goto salida51;
else52:

cout<<"else ORR";
cout<<endl;
salida51:

cout<<"test de elifff";
cout<<endl;int64 = ptr + 6;
int65 = stackint[int64];

int66 = ptr + 7;
int67 = stackint[int66];

if(int65>int67)goto if60;
goto cmpOp268;
int69 = ptr + 7;
int70 = stackint[int69];

int71 = ptr + 6;
int72 = stackint[int71];

cmpOp268:
if(int70>int72)goto if60;
goto labelelif63;
if60:

cout<<"444 es mayor que 2";
cout<<endl;
goto salida61;
labelelif63:
int75 = 2;
int76 = 3;
if(int75>int76)goto elif63;
goto else73;

elif63:

cout<<"elifff";
cout<<endl;
goto salida61;
else73:

cout<<"else despues del elif";
cout<<endl;
salida61:

// un getch
getchint();

cout<<"test  Do while";
cout<<endl;while79:{}
int80 = ptr + 6;
int81 = stackint[int80];

int82 = 0;
if(int81>int82)goto cmpOp283;
goto finWhile77;
int84 = ptr + 6;
int85 = stackint[int84];

int86 = 5;
cmpOp283:
if(int85!=int86)goto insDo78;
goto finWhile77;
insDo78:{}
int87 = ptr + 6;
int88 = stackint[int87];

int89 = 1;
int90 = int88-int89;
int91 = ptr + 6;
stackint[int91] = int90;


int96 = ptr + 6;
int97 = stackint[int96];

int98 = 7;
if(int97==int98)goto if92;
goto salida93;
if92:

cout<<"if dentro de un Do-while";
cout<<endl;int99 = 5;
int100 = ptr + 6;
stackint[int100] = int99;


int105 = ptr + 6;
int106 = stackint[int105];

int107 = 5;
if(int106!=int107)goto if101;
goto else103;
if101:

cout<<"if dentro de if dentro de Do-while";
cout<<endl;
goto salida102;
else103:
while110:{}
int111 = ptr + 8;
int112 = stackint[int111];

int113 = 0;
if(int112>int113)goto insDo109;
goto finWhile108;
insDo109:{}
int114 = ptr + 8;
int115 = stackint[int114];

int116 = 1;
int117 = int115-int116;
int118 = ptr + 8;
stackint[int118] = int117;


int119 = ptr + 6;
int120 = stackint[int119];


cout<<"while anidado: ";

cout<<int120;
cout<<endl;goto while110;
finWhile108:{}

salida102:

goto salida93;
salida93:
int121 = ptr + 6;
int122 = stackint[int121];


cout<<"dentro de while: ";

cout<<int122;
cout<<endl;goto while79;
finWhile77:{}

// un getch
getchint();

system("clear");

cout<<"test while";
cout<<endl;while125:{}
int126 = ptr + 6;
int127 = stackint[int126];

int128 = 0;
if(int127>int128)goto insDo124;
goto finWhile123;
insDo124:{}
int129 = ptr + 6;
int130 = stackint[int129];

int131 = 1;
int132 = int130-int131;
int133 = ptr + 6;
stackint[int133] = int132;


int134 = ptr + 6;
int135 = stackint[int134];


cout<<"a es =  ";

cout<<int135;
cout<<endl;goto while125;
finWhile123:{}

labelReturn0:

cout<<endl;
}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

