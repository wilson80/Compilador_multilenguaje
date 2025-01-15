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
int int160;
int int161;
int int162;
int int163;
int int164;
int int165;
int int166;
int int167;
int int168;
int int169;
int int170;

int160 = 0;
int161 = ptr + 5;
stackint[int161] = int160;


int162 = ptr + 3;
int163 = stackint[int162];

int164 = ptr + 4;
int165 = stackint[int164];

int166 = int163+int165;
int167 = ptr + 5;
stackint[int167] = int166;


int168 = ptr + 5;
int169 = stackint[int168];

int170 = ptr + 1;
stackint[int170] = int169;


retorno159:
    cout<< " ";
}

void pasrestarintint(){
int int172;
int int173;
int int174;
int int175;
int int176;
int int177;
int int178;
int int179;
int int180;
int int181;
int int182;

int172 = 0;
int173 = ptr + 5;
stackint[int173] = int172;


int174 = ptr + 3;
int175 = stackint[int174];

int176 = ptr + 4;
int177 = stackint[int176];

int178 = int175-int177;
int179 = ptr + 5;
stackint[int179] = int178;


int180 = ptr + 5;
int181 = stackint[int180];

int182 = ptr + 1;
stackint[int182] = int181;


retorno171:
    cout<< " ";
}

void pasmultiplicarintint(){
int int184;
int int185;
int int186;
int int187;
int int188;
int int189;
int int190;
int int191;
int int192;
int int193;
int int194;

int184 = 0;
int185 = ptr + 5;
stackint[int185] = int184;


int186 = ptr + 3;
int187 = stackint[int186];

int188 = ptr + 4;
int189 = stackint[int188];

int190 = int187*int189;
int191 = ptr + 5;
stackint[int191] = int190;


int192 = ptr + 5;
int193 = stackint[int192];

int194 = ptr + 1;
stackint[int194] = int193;


retorno183:
    cout<< " ";
}

void pasdividirintint(){
int int196;
int int197;
int int198;
int int199;
int int200;
int int201;

int196 = ptr + 3;
int197 = stackint[int196];

int198 = ptr + 4;
int199 = stackint[int198];

int200 = int197/int199;
int201 = ptr + 1;
stackint[int201] = int200;


retorno195:
    cout<< " ";
}

void pasmodulointint(){
int int203;
int int204;
int int205;
int int206;
int int207;
int int208;

int203 = ptr + 3;
int204 = stackint[int203];

int205 = ptr + 4;
int206 = stackint[int205];

int207 = int204%int206;
int208 = ptr + 1;
stackint[int208] = int207;


retorno202:
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
int int38;
int int39;
int int40;
int int41;
int int42;
int int43;
int int44;
int int45;
int int46;
int int47;
int int48;
int int49;
int int50;
int int51;
int int52;
int int53;
int int54;
int int55;
int int56;
int int57;
int int58;
int int59;
int int60;
int int61;
int int62;
int int63;
int int64;
int int65;
int int66;
int int67;
int int68;
int int69;
int int70;
int int71;
int int72;
int int73;
int int74;
int int75;
int int76;
int int77;
int int78;
int int79;
int int80;
int int81;
int int82;
int int83;
int int84;
int int85;
int int86;
int int87;
int int88;
int int89;
int int90;
int int91;
int int92;
int int93;
int int94;
int int95;
int int96;
int int97;
int int98;
int int99;
int int100;
int int101;
int int102;
int int103;
int int104;
int int105;
int int106;
int int107;
int int108;
int int109;
int int110;
int int111;
int int112;
int int113;
float float114;
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
int int135;
int int136;
int int137;
int int138;
int int139;
int int140;
int int141;
int int142;
int int143;
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
int int155;
int int156;
int int157;
int int158;


int0 = 2;
int1 = ptr + 0;
stackint[int1] = int0;

int2 = 2;
int3 = ptr + 1;
stackint[int3] = int2;

int4 = 0;
int5 = ptr + 2;
stackint[int5] = int4;

int6 = 1;
int7 = ptr + 3;
stackint[int7] = int6;

int8 = 3;
int9 = ptr + 4;
stackint[int9] = int8;

int10 = 4;
int11 = ptr + 5;
stackint[int11] = int10;

int12 = 0;
int13 = ptr + 13;
stackint[int13] = int12;


system("clear");
int14 = 1;
int15 = 2;
int16 = int14+int15;
int17 = ptr + 9;
stackint[int17] = int16;


int18 = 0;
int19 = ptr + 10;
stackint[int19] = int18;


int20 = 86;
int21 = ptr + 11;
stackint[int21] = int20;


int22 = 100;
int23 = ptr + 12;
stackint[int23] = int22;



cout<<"Bienvenido";
cout<<endl;
cout<<"Archivo de prueba...";
cout<<endl;
cout<<"Ingrese el primer valor entero";
cout<<endl;int24 = ptr + 6;
int25 = stackint[int24];

//un cin



cin>> int25;
int26 = ptr + 6;
stackint[int26] = int25;


cout<<"Ingrese el segudo valor entero ";
cout<<endl;int27 = ptr + 7;
int28 = stackint[int27];

//un cin



cin>> int28;
int29 = ptr + 7;
stackint[int29] = int28;



//invocacion a subP de pascal, id: MODULO
int30 = ptr + 14;

int31 = ptr + 6;
int32 = stackint[int31];

int33 = ptr + 7;
int34 = stackint[int33];

int35 = int30 + 3;
stackint[int35] = int32;

int36 = int30 + 4;
stackint[int36] = int34;

ptr = ptr + 14;
pasmodulointint();
ptr = ptr - 14;
int37 = ptr + 14;

int38 = int37 + 1;
int39 = stackint[int38];

int40 = ptr + 12;
stackint[int40] = int39;




//invocacion a subP de pascal, id: SUMAR
int41 = ptr + 14;

int42 = ptr + 6;
int43 = stackint[int42];

int44 = ptr + 7;
int45 = stackint[int44];

int46 = int41 + 3;
stackint[int46] = int43;

int47 = int41 + 4;
stackint[int47] = int45;

ptr = ptr + 14;
passumarintint();
ptr = ptr - 14;
int48 = ptr + 14;

int49 = int48 + 1;
int50 = stackint[int49];

int51 = ptr + 9;
stackint[int51] = int50;




//invocacion a subP de pascal, id: RESTAR
int52 = ptr + 14;

int53 = ptr + 6;
int54 = stackint[int53];

int55 = ptr + 7;
int56 = stackint[int55];

int57 = int52 + 3;
stackint[int57] = int54;

int58 = int52 + 4;
stackint[int58] = int56;

ptr = ptr + 14;
pasrestarintint();
ptr = ptr - 14;
int59 = ptr + 14;

int60 = int59 + 1;
int61 = stackint[int60];

int62 = ptr + 10;
stackint[int62] = int61;




//invocacion a subP de pascal, id: MULTIPLICAR
int63 = ptr + 14;

int64 = ptr + 6;
int65 = stackint[int64];

int66 = ptr + 7;
int67 = stackint[int66];

int68 = int63 + 3;
stackint[int68] = int65;

int69 = int63 + 4;
stackint[int69] = int67;

ptr = ptr + 14;
pasmultiplicarintint();
ptr = ptr - 14;
int70 = ptr + 14;

int71 = int70 + 1;
int72 = stackint[int71];

int73 = ptr + 11;
stackint[int73] = int72;




//invocacion a subP de pascal, id: DIVIDIR
int74 = ptr + 14;

int75 = ptr + 6;
int76 = stackint[int75];

int77 = ptr + 7;
int78 = stackint[int77];

int79 = int74 + 3;
stackint[int79] = int76;

int80 = int74 + 4;
stackint[int80] = int78;

ptr = ptr + 14;
pasdividirintint();
ptr = ptr - 14;
int81 = ptr + 14;

int82 = int81 + 1;
int83 = stackint[int82];

int84 = ptr + 8;
stackfloat[int84] = int83;


int85 = ptr + 6;
int86 = stackint[int85];


cout<<"";

cout<<int86;
int87 = ptr + 7;
int88 = stackint[int87];


cout<<" + ";

cout<<int88;
int89 = ptr + 9;
int90 = stackint[int89];


cout<<" es igual a ";

cout<<int90;
cout<<endl;int91 = ptr + 6;
int92 = stackint[int91];


cout<<"";

cout<<int92;
int93 = ptr + 7;
int94 = stackint[int93];


cout<<" - ";

cout<<int94;
int95 = ptr + 10;
int96 = stackint[int95];


cout<<" es igual a ";

cout<<int96;
cout<<endl;int97 = ptr + 6;
int98 = stackint[int97];


cout<<"";

cout<<int98;
int99 = ptr + 7;
int100 = stackint[int99];


cout<<" * ";

cout<<int100;
int101 = ptr + 11;
int102 = stackint[int101];


cout<<" es igual a ";

cout<<int102;
cout<<endl;int103 = ptr + 6;
int104 = stackint[int103];


cout<<"";

cout<<int104;
int105 = ptr + 7;
int106 = stackint[int105];


cout<<" mod ";

cout<<int106;
int107 = ptr + 12;
int108 = stackint[int107];


cout<<" es igual a ";

cout<<int108;
cout<<endl;int109 = ptr + 6;
int110 = stackint[int109];


cout<<"";

cout<<int110;
int111 = ptr + 7;
int112 = stackint[int111];


cout<<" / ";

cout<<int112;
int113 = ptr + 8;
float114 = stackfloat[int113];


cout<<" es igual a ";

cout<<float114;
cout<<endl;int115 = 0;
int116 = ptr + 2;
stackint[int116] = int115;


int117 = 0;
int118 = ptr + 3;
stackint[int118] = int117;


int119 = 0;
int120 = ptr + 4;
stackint[int120] = int119;


int121 = 0;
int122 = ptr + 5;
stackint[int122] = int121;


int126 = 0;
int127 = ptr + 13;
stackint[int127] = int126;


label_Loop123:{}
int128 = ptr + 13;
int129 = stackint[int128];

int130 = 2;
if(int129<int130)goto label_ins125;
goto salida124;
label_ins125:{}
int135 = ptr + 13;
int136 = stackint[int135];

int137 = 0;
if(int136==int137)goto if131;
goto else133;
if131:
int138 = ptr + 13;
int139 = stackint[int138];


cout<<"Arreglo [ ";

cout<<int139;
int140 = ptr + 2;
int141 = stackint[int140];


cout<<" ] [ 0 ] su contenido es ";

cout<<int141;
cout<<endl;int142 = ptr + 13;
int143 = stackint[int142];


cout<<"Arreglo [ ";

cout<<int143;
int144 = ptr + 3;
int145 = stackint[int144];


cout<<" ] [ 1 ] su contenido es ";

cout<<int145;
cout<<endl;
goto salida132;
else133:
int146 = ptr + 13;
int147 = stackint[int146];


cout<<"Arreglo [ ";

cout<<int147;
int148 = ptr + 4;
int149 = stackint[int148];


cout<<" ] [ 0 ] su contenido es ";

cout<<int149;
cout<<endl;int150 = ptr + 13;
int151 = stackint[int150];


cout<<"Arreglo [ ";

cout<<int151;
int152 = ptr + 5;
int153 = stackint[int152];


cout<<" ] [ 1 ] su contenido es ";

cout<<int153;
cout<<endl;
salida132:
int154 = ptr + 13;
int155 = stackint[int154];

int156 = 1;
int157 = int155+int156;
int158 = ptr + 13;
stackint[int158] = int157;


goto label_Loop123;
salida124:{}

// un getch
getchint();

labelReturn0:

cout<<endl;
}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

