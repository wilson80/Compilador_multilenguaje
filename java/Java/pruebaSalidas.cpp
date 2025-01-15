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





 void javaNodogetContenido();
void javaNodogetSiguiente();
void javaNodogetAnterior();
void javaNodosetSiguienteNodo();
void javaNodosetAnteriorNodo();
void javaNodoNodochar();
void javaListaEgetSize();
void javaListaEobtenerNodoint();
void javaListaEgetContentint();
void javaListaEagregarchar();
void javaListaEimprimirLista();
void javaListaEeliminarUltimo();
void javaListaEListaE();
void javaSumariniciar();
void javaSumarSumar();







void javaNodogetContenido(){
int int19;
int int20;
int int21;
char char22;
int int23;

int19 = ptr + 0;
int20 = stackint[int19];

int21 = int20 + 0;
char22 = heapchar[int21];

int23 = ptr + 1;
stackchar[int23] = char22;

goto retorno18;
retorno18:
    cout<< "";
}

void javaNodogetSiguiente(){
int int25;
int int26;
int int27;
int int28;
int int29;

int25 = ptr + 0;
int26 = stackint[int25];

int27 = int26 + 1;
int28 = heapint[int27];

int29 = ptr + 1;
stackint[int29] = int28;

goto retorno24;
retorno24:
    cout<< "";
}

void javaNodogetAnterior(){
int int31;
int int32;
int int33;
int int34;
int int35;

int31 = ptr + 0;
int32 = stackint[int31];

int33 = int32 + 2;
int34 = heapint[int33];

int35 = ptr + 1;
stackint[int35] = int34;

goto retorno30;
retorno30:
    cout<< "";
}

void javaNodosetSiguienteNodo(){
int int37;
int int38;
int int39;
int int40;
int int41;
int37 = ptr + 2;
int38 = stackint[int37];

int39 = ptr + 0;
int40 = stackint[int39];

int41 = int40 + 1;
heapint[int41] = int38;


retorno36:
    cout<< " ";
}

void javaNodosetAnteriorNodo(){
int int43;
int int44;
int int45;
int int46;
int int47;
int43 = ptr + 2;
int44 = stackint[int43];

int45 = ptr + 0;
int46 = stackint[int45];

int47 = int46 + 2;
heapint[int47] = int44;


retorno42:
    cout<< " ";
}

void javaNodoNodochar(){
int int49;
int int50;
int int51;
char char52;
int int53;
int int54;
int int55;
int int56;
int int57;
int int58;
int int59;
int int60;
int int61;

int49 = h;
h = int49 + 3;

int50 = ptr + 0;
stackint[int50] = int49;

int51 = ptr + 2;
char52 = stackchar[int51];

int53 = ptr + 0;
int54 = stackint[int53];

int55 = int54 + 0;
heapchar[int55] = char52;


int56 = ptr + 0;
int57 = stackint[int56];

int58 = int57 + 1;
heapint[int58] =  -1;


int59 = ptr + 0;
int60 = stackint[int59];

int61 = int60 + 2;
heapint[int61] =  -1;


retorno48:
    cout<< "";
}

void javaListaEgetSize(){
int int63;
int int64;
int int65;
int int66;
int int67;

int63 = ptr + 0;
int64 = stackint[int63];

int65 = int64 + 2;
int66 = heapint[int65];

int67 = ptr + 1;
stackint[int67] = int66;

goto retorno62;
retorno62:
    cout<< "";
}

void javaListaEobtenerNodoint(){
int int69;
int int70;
int int71;
int int72;
int int73;
int int74;
int int75;
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

int69 = ptr + 0;
int70 = stackint[int69];

int71 = int70 + 0;
int72 = heapint[int71];

int73 = ptr + 4;
stackint[int73] = int72;

int75 = ptr + 5;
stackint[int75] = int74;

int79 = 0;
int80 = ptr + 5;
stackint[int80] = int79;


label_Loop76:{}
int81 = ptr + 5;
int82 = stackint[int81];

int83 = ptr + 3;
int84 = stackint[int83];

if(int82<int84)goto label_ins78;
goto salida77;
label_ins78:{}
int85 = ptr + 4;
int86 = stackint[int85];

int87 = ptr + 6;

int88 = int87 + 0;
stackint[int88] = int86;

ptr = ptr + 6;
javaNodogetSiguiente();
ptr = ptr - 6;

//retorno
int89 = ptr + 6;

int90 = int89 + 1;
int91 = stackint[int90];


//retorno
int92 = ptr + 4;
stackint[int92] = int91;


int93 = ptr + 5;
int94 = stackint[int93];

int95 = 1;
int96 = int94+int95;
int97 = ptr + 5;
stackint[int97] = int96;


goto label_Loop76;
salida77:{}
int98 = ptr + 4;
int99 = stackint[int98];

int100 = ptr + 1;
stackint[int100] = int99;

goto retorno68;
retorno68:
    cout<< "";
}

void javaListaEgetContentint(){
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
int int114;
int int115;
int int116;
int int117;
int int118;
char char119;
int int120;

int102 = ptr + 3;
int103 = stackint[int102];

int104 = ptr + 5;

int105 = ptr + 0;
int106 = stackint[int105];

int107 = int104 + 0;
stackint[int107] = int106;

int108 = int104 + 3;
stackint[int108] = int103;

ptr = ptr + 5;
javaListaEobtenerNodoint();
ptr = ptr - 5;

//retorno
int109 = ptr + 5;

int110 = int109 + 1;
int111 = stackint[int110];


//retorno
int112 = ptr + 4;
stackint[int112] = int111;

int113 = ptr + 4;
int114 = stackint[int113];

int115 = ptr + 5;

int116 = int115 + 0;
stackint[int116] = int114;

ptr = ptr + 5;
javaNodogetContenido();
ptr = ptr - 5;

//retorno
int117 = ptr + 5;

int118 = int117 + 1;
char119 = stackchar[int118];


//retorno
int120 = ptr + 1;
stackchar[int120] = char119;

goto retorno101;
retorno101:
    cout<< "";
}

void javaListaEagregarchar(){
int int122;
char char123;
int int124;
int int125;
int int126;
int int127;
int int128;
int int129;
int int134;
int int135;
int int136;
int int137;
string string138;
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
string string149;
int int150;
int int151;
int int152;
int int153;
int int154;
int int155;
int int156;
int int157;
int int158;
int int159;
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
int int171;
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
int122 = ptr + 2;
char123 = stackchar[int122];

int124 = ptr + 4;

int125 = int124 + 2;
stackint[int125] = char123;

ptr = ptr + 4;
javaNodoNodochar();
ptr = ptr - 4;
int126 = ptr + 4;

int127 = int126 + 0;
int128 = stackint[int127];

int129 = ptr + 3;
stackint[int129] = int128;

int134 = ptr + 0;
int135 = stackint[int134];

int136 = int135 + 0;
int137 = heapint[int136];

if(int137== -1)goto if130;
goto else132;
if130:
string138 = "Agregando el primero";

cout<<string138;
cout<<endl;
int139 = ptr + 3;
int140 = stackint[int139];

int141 = ptr + 0;
int142 = stackint[int141];

int143 = int142 + 0;
heapint[int143] = int140;


int144 = ptr + 3;
int145 = stackint[int144];

int146 = ptr + 0;
int147 = stackint[int146];

int148 = int147 + 1;
heapint[int148] = int145;



goto salida131;
else132:
string149 = "Agregando el otro";

cout<<string149;
cout<<endl;
int150 = ptr + 0;
int151 = stackint[int150];

int152 = int151 + 1;
int153 = heapint[int152];

int154 = ptr + 3;
int155 = stackint[int154];

int156 = ptr + 4;

int157 = int156 + 0;
stackint[int157] = int153;

int158 = int156 + 2;
stackint[int158] = int155;

ptr = ptr + 4;
javaNodosetSiguienteNodo();
ptr = ptr - 4;
int159 = ptr + 3;
int160 = stackint[int159];

int161 = ptr + 0;
int162 = stackint[int161];

int163 = int162 + 1;
int164 = heapint[int163];

int165 = ptr + 4;

int166 = int165 + 0;
stackint[int166] = int160;

int167 = int165 + 2;
stackint[int167] = int164;

ptr = ptr + 4;
javaNodosetAnteriorNodo();
ptr = ptr - 4;
int168 = ptr + 3;
int169 = stackint[int168];

int170 = ptr + 0;
int171 = stackint[int170];

int172 = int171 + 1;
heapint[int172] = int169;



salida131:
int173 = ptr + 0;
int174 = stackint[int173];

int175 = int174 + 2;
int176 = heapint[int175];

int177 = 1;
int178 = int176+int177;
int179 = ptr + 0;
int180 = stackint[int179];

int181 = int180 + 2;
heapint[int181] = int178;


retorno121:
    cout<< " ";
}

void javaListaEimprimirLista(){
int int183;
int int184;
int int185;
int int186;
int int187;
int int188;
int int189;
int int193;
int int194;
int int195;
int int196;
int int197;
int int198;
int int199;
int int200;
string string201;
int int202;
int int203;
int int204;
int int205;
int int206;
int int207;
char char208;
string string209;
int int210;
int int211;
int int212;
int int213;
int int214;
int int215;
int int216;
int int217;
int int218;
int int219;
int int220;
int int221;
int int222;
int183 = ptr + 0;
int184 = stackint[int183];

int185 = int184 + 0;
int186 = heapint[int185];

int187 = ptr + 2;
stackint[int187] = int186;

int189 = ptr + 3;
stackint[int189] = int188;

int193 = 0;
int194 = ptr + 3;
stackint[int194] = int193;


label_Loop190:{}
int195 = ptr + 3;
int196 = stackint[int195];

int197 = ptr + 0;
int198 = stackint[int197];

int199 = int198 + 2;
int200 = heapint[int199];

if(int196<int200)goto label_ins192;
goto salida191;
label_ins192:{}
string201 = "contenido: ";
int202 = ptr + 2;
int203 = stackint[int202];

int204 = ptr + 4;

int205 = int204 + 0;
stackint[int205] = int203;

ptr = ptr + 4;
javaNodogetContenido();
ptr = ptr - 4;

//retorno
int206 = ptr + 4;

int207 = int206 + 1;
char208 = stackchar[int207];


//retorno
string209 = string201+char208;

cout<<string209;
cout<<endl;
int210 = ptr + 2;
int211 = stackint[int210];

int212 = ptr + 4;

int213 = int212 + 0;
stackint[int213] = int211;

ptr = ptr + 4;
javaNodogetSiguiente();
ptr = ptr - 4;

//retorno
int214 = ptr + 4;

int215 = int214 + 1;
int216 = stackint[int215];


//retorno
int217 = ptr + 2;
stackint[int217] = int216;


int218 = ptr + 3;
int219 = stackint[int218];

int220 = 1;
int221 = int219+int220;
int222 = ptr + 3;
stackint[int222] = int221;


goto label_Loop190;
salida191:{}
retorno182:
    cout<< " ";
}

void javaListaEeliminarUltimo(){
int int224;
int int225;
int int226;
int int231;
int int232;
int int233;
int int234;
string string235;
int int240;
int int241;
int int242;
int int243;
int int244;
int int245;
int int246;
int int247;
int int248;
int int249;
int int250;
int int251;
int int252;
int int253;
int int254;
int int255;
int int256;
int int257;
int int258;
int int259;
int int260;
int int261;
int int262;
int int263;
int int264;
int int265;
int int266;
int int267;
int int268;
int int269;
int int270;
int int271;
int int272;
int int273;
int int274;
int int275;
int int276;
int int277;
int int278;
int int279;
int int280;
int int281;
int225 = ptr + 2;
stackint[int225] = int224;

int226 = ptr + 3;
stackint[int226] =  -1;

int231 = ptr + 0;
int232 = stackint[int231];

int233 = int232 + 0;
int234 = heapint[int233];

if(int234== -1)goto if227;
goto else229;
if227:
string235 = "La lista está vacía";

cout<<string235;
cout<<endl;

goto salida228;
else229:
int240 = ptr + 0;
int241 = stackint[int240];

int242 = int241 + 2;
int243 = heapint[int242];

int244 = 1;
if(int243==int244)goto if236;
goto else238;
if236:
int245 = ptr + 0;
int246 = stackint[int245];

int247 = int246 + 0;
heapint[int247] =  -1;


int248 = ptr + 0;
int249 = stackint[int248];

int250 = int249 + 1;
heapint[int250] =  -1;



goto salida237;
else238:
int251 = ptr + 0;
int252 = stackint[int251];

int253 = int252 + 1;
int254 = heapint[int253];

int255 = ptr + 4;

int256 = int255 + 0;
stackint[int256] = int254;

ptr = ptr + 4;
javaNodogetAnterior();
ptr = ptr - 4;

//retorno
int257 = ptr + 4;

int258 = int257 + 1;
int259 = stackint[int258];


//retorno
int260 = ptr + 2;
stackint[int260] = int259;


int261 = ptr + 2;
int262 = stackint[int261];

int263 = ptr + 3;
int264 = stackint[int263];

int265 = ptr + 4;

int266 = int265 + 0;
stackint[int266] = int262;

int267 = int265 + 2;
stackint[int267] = int264;

ptr = ptr + 4;
javaNodosetSiguienteNodo();
ptr = ptr - 4;
int268 = ptr + 2;
int269 = stackint[int268];

int270 = ptr + 0;
int271 = stackint[int270];

int272 = int271 + 1;
heapint[int272] = int269;



salida237:
int273 = ptr + 0;
int274 = stackint[int273];

int275 = int274 + 2;
int276 = heapint[int275];

int277 = 1;
int278 = int276-int277;
int279 = ptr + 0;
int280 = stackint[int279];

int281 = int280 + 2;
heapint[int281] = int278;



salida228:
retorno223:
    cout<< " ";
}

void javaListaEListaE(){
int int283;
int int284;
int int285;
int int286;
int int287;
int int288;
int int289;
int int290;
int int291;
int int292;
int int293;
int int294;

int283 = h;
h = int283 + 3;

int284 = ptr + 0;
stackint[int284] = int283;

int285 = ptr + 0;
int286 = stackint[int285];

int287 = int286 + 0;
heapint[int287] =  -1;


int288 = ptr + 0;
int289 = stackint[int288];

int290 = int289 + 1;
heapint[int290] =  -1;


int291 = 0;
int292 = ptr + 0;
int293 = stackint[int292];

int294 = int293 + 2;
heapint[int294] = int291;


retorno282:
    cout<< "";
}

void javaSumariniciar(){
int int296;
int int297;
int int298;
int int299;
int int300;
int int301;
int int302;
int int303;
int int304;
int int305;
int int306;
char char307;
int int308;
int int309;
int int310;
int int311;
int int312;
int int313;
int int314;
char char315;
int int316;
int int317;
int int318;
int int319;
int int320;
int int321;
int int322;
char char323;
int int324;
int int325;
int int326;
int int327;
int int328;
int int329;
int int330;
char char331;
int int332;
int int333;
int int334;
int int335;
int int336;
int int337;
int int338;
char char339;
int int340;
int int341;
int int342;
int int343;
int int344;
int int345;
int int346;
char char347;
int int348;
int int349;
int int350;
int int351;
int int352;
int int353;
int int354;
char char355;
int int356;
int int357;
int int358;
int int359;
int int360;
int int361;
int int362;
int int363;
int int364;
string string365;
int int366;
int int367;
int int368;
int int369;
int int370;
int int371;
int int372;
int int373;
int int374;
int int375;
int int376;
int int377;
string string378;
int int379;
int int380;
int int381;
int int382;
int int383;
int int384;
int int385;
int int386;
int int387;
string string388;
int int389;
int int390;
int int391;
int int392;
int int393;
int int394;
int int395;
int int396;
int int397;
int int398;
char char399;
int296 = ptr + 2;

ptr = ptr + 2;
javaListaEListaE();
ptr = ptr - 2;
int297 = ptr + 2;

int298 = int297 + 0;
int299 = stackint[int298];

int300 = ptr + 0;
int301 = stackint[int300];

int302 = int301 + 0;
heapint[int302] = int299;


int303 = ptr + 0;
int304 = stackint[int303];

int305 = int304 + 0;
int306 = heapint[int305];

char307 = 'H';
int308 = ptr + 2;

int309 = int308 + 0;
stackint[int309] = int306;

int310 = int308 + 2;
stackint[int310] = char307;

ptr = ptr + 2;
javaListaEagregarchar();
ptr = ptr - 2;
int311 = ptr + 0;
int312 = stackint[int311];

int313 = int312 + 0;
int314 = heapint[int313];

char315 = 'O';
int316 = ptr + 2;

int317 = int316 + 0;
stackint[int317] = int314;

int318 = int316 + 2;
stackint[int318] = char315;

ptr = ptr + 2;
javaListaEagregarchar();
ptr = ptr - 2;
int319 = ptr + 0;
int320 = stackint[int319];

int321 = int320 + 0;
int322 = heapint[int321];

char323 = 'L';
int324 = ptr + 2;

int325 = int324 + 0;
stackint[int325] = int322;

int326 = int324 + 2;
stackint[int326] = char323;

ptr = ptr + 2;
javaListaEagregarchar();
ptr = ptr - 2;
int327 = ptr + 0;
int328 = stackint[int327];

int329 = int328 + 0;
int330 = heapint[int329];

char331 = 'A';
int332 = ptr + 2;

int333 = int332 + 0;
stackint[int333] = int330;

int334 = int332 + 2;
stackint[int334] = char331;

ptr = ptr + 2;
javaListaEagregarchar();
ptr = ptr - 2;
int335 = ptr + 0;
int336 = stackint[int335];

int337 = int336 + 0;
int338 = heapint[int337];

char339 = 'M';
int340 = ptr + 2;

int341 = int340 + 0;
stackint[int341] = int338;

int342 = int340 + 2;
stackint[int342] = char339;

ptr = ptr + 2;
javaListaEagregarchar();
ptr = ptr - 2;
int343 = ptr + 0;
int344 = stackint[int343];

int345 = int344 + 0;
int346 = heapint[int345];

char347 = 'U';
int348 = ptr + 2;

int349 = int348 + 0;
stackint[int349] = int346;

int350 = int348 + 2;
stackint[int350] = char347;

ptr = ptr + 2;
javaListaEagregarchar();
ptr = ptr - 2;
int351 = ptr + 0;
int352 = stackint[int351];

int353 = int352 + 0;
int354 = heapint[int353];

char355 = 'N';
int356 = ptr + 2;

int357 = int356 + 0;
stackint[int357] = int354;

int358 = int356 + 2;
stackint[int358] = char355;

ptr = ptr + 2;
javaListaEagregarchar();
ptr = ptr - 2;
int359 = ptr + 0;
int360 = stackint[int359];

int361 = int360 + 0;
int362 = heapint[int361];

int363 = ptr + 2;

int364 = int363 + 0;
stackint[int364] = int362;

ptr = ptr + 2;
javaListaEimprimirLista();
ptr = ptr - 2;
string365 = "Eliminando el último nodo:";

cout<<string365;
cout<<endl;
int366 = ptr + 0;
int367 = stackint[int366];

int368 = int367 + 0;
int369 = heapint[int368];

int370 = ptr + 2;

int371 = int370 + 0;
stackint[int371] = int369;

ptr = ptr + 2;
javaListaEeliminarUltimo();
ptr = ptr - 2;
int372 = ptr + 0;
int373 = stackint[int372];

int374 = int373 + 0;
int375 = heapint[int374];

int376 = ptr + 2;

int377 = int376 + 0;
stackint[int377] = int375;

ptr = ptr + 2;
javaListaEimprimirLista();
ptr = ptr - 2;
string378 = "Tamaño de la lista: ";

cout<<string378;
int379 = ptr + 0;
int380 = stackint[int379];

int381 = int380 + 0;
int382 = heapint[int381];

int383 = ptr + 2;

int384 = int383 + 0;
stackint[int384] = int382;

ptr = ptr + 2;
javaListaEgetSize();
ptr = ptr - 2;

//retorno
int385 = ptr + 2;

int386 = int385 + 1;
int387 = stackint[int386];


//retorno

cout<<int387;
cout<<endl;
string388 = "Contenido en posición 2: ";

cout<<string388;
int389 = ptr + 0;
int390 = stackint[int389];

int391 = int390 + 0;
int392 = heapint[int391];

int393 = 2;
int394 = ptr + 2;

int395 = int394 + 0;
stackint[int395] = int392;

int396 = int394 + 3;
stackint[int396] = int393;

ptr = ptr + 2;
javaListaEgetContentint();
ptr = ptr - 2;

//retorno
int397 = ptr + 2;

int398 = int397 + 1;
char399 = stackchar[int398];


//retorno

cout<<char399;
cout<<endl;
retorno295:
    cout<< " ";
}

void javaSumarSumar(){
int int401;
int int402;
int int403;
int int404;
int int405;

int401 = h;
h = int401 + 1;

int402 = ptr + 0;
stackint[int402] = int401;

int403 = ptr + 0;
int404 = stackint[int403];

int405 = int404 + 0;
heapint[int405] =  -1;


retorno400:
    cout<< "";
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


int0 = 12;
int1 = ptr + 0;
stackint[int1] = int0;

int2 = 6;
int3 = ptr + 1;
stackint[int3] = int2;

int4 = 9;
int5 = ptr + 2;
stackint[int5] = int4;

int6 = 88;
int7 = ptr + 3;
stackint[int7] = int6;

int8 = ptr + 5;

ptr = ptr + 5;
javaSumarSumar();
ptr = ptr - 5;
int9 = ptr + 5;

int10 = int9 + 0;
int11 = stackint[int10];

int12 = ptr + 4;
stackint[int12] = int11;

int13 = ptr + 4;
int14 = stackint[int13];

int15 = ptr + 5;

int16 = int15 + 0;
stackint[int16] = int14;

int17 = ptr + 5;

ptr = ptr + 5;
javaSumariniciar();
ptr = ptr - 5;

labelReturn0:

cout<<endl;
}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

