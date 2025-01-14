#include <iostream>
#include <termios.h>
#include <unistd.h>
using namespace std;

int stack[1000];
int heap[1000];
int ptr = 0;
int h = 0;





 void javaNodogetContenido();
void javaNodogetSiguiente();
void javaNodogetAnterior();
void javaNodosetSiguienteNodo();
void javaNodosetAnteriorNodo();
void javaNodoNodoint();
void javaListaEgetSize();
void javaListaEgetNum();
void javaListaEobtenerNodoint();
void javaListaEgetContentint();
void javaListaEobtenerNodoPROint();
void javaListaEobtenerNodoAvanzandoint();
void javaListaEobtenerNodoRetrocediendoint();
void javaListaEagregarint();
void javaListaEimprimirLista();
void javaListaEeliminarUltimo();
void javaListaEListaE();
void javasumariniciar();
void javasumarsumar();







void javaNodogetContenido(){
int w0;
int w1;
int w2;
int w3;
int w4;
int w5;

w1 = ptr + 0;
w2 = stack[w1];

w3 = w2 + 0;
w4 = heap[w3];

w5 = ptr + 1;
stack[w5] = w4;

goto retorno0;
retorno0:
    cout<< "";
}

void javaNodogetSiguiente(){
int w6;
int w7;
int w8;
int w9;
int w10;
int w11;

w7 = ptr + 0;
w8 = stack[w7];

w9 = w8 + 1;
w10 = heap[w9];

w11 = ptr + 1;
stack[w11] = w10;

goto retorno6;
retorno6:
    cout<< "";
}

void javaNodogetAnterior(){
int w12;
int w13;
int w14;
int w15;
int w16;
int w17;

w13 = ptr + 0;
w14 = stack[w13];

w15 = w14 + 2;
w16 = heap[w15];

w17 = ptr + 1;
stack[w17] = w16;

goto retorno12;
retorno12:
    cout<< "";
}

void javaNodosetSiguienteNodo(){
int w18;
int w19;
int w20;
int w21;
int w22;
int w23;

w19 = ptr + 2;
w20 = stack[w19];

w21 = ptr + 0;
w22 = stack[w21];

w23 = w22 + 1;
heap[w23] = w20;


retorno18:
    cout<< " ";
}

void javaNodosetAnteriorNodo(){
int w24;
int w25;
int w26;
int w27;
int w28;
int w29;

w25 = ptr + 2;
w26 = stack[w25];

w27 = ptr + 0;
w28 = stack[w27];

w29 = w28 + 2;
heap[w29] = w26;


retorno24:
    cout<< " ";
}

void javaNodoNodoint(){
int w30;
int w31;
int w32;
int w33;
int w34;
int w35;
int w36;
int w37;
int w38;
int w39;
int w40;
int w41;
int w42;
int w43;
int w44;
int w45;
int w46;
int w47;

w31 = h;
h = w31 + 3;

w32 = ptr + 0;
stack[w32] = w31;

w34 = ptr + 0;
w35 = stack[w34];

w36 = w35 + 0;
heap[w36] = 0;


w37 = ptr + 0;
w38 = stack[w37];

w39 = w38 + 1;
heap[w39] =  -1;


w40 = ptr + 0;
w41 = stack[w40];

w42 = w41 + 2;
heap[w42] =  -1;


w43 = ptr + 2;
w44 = stack[w43];

w45 = ptr + 0;
w46 = stack[w45];

w47 = w46 + 0;
heap[w47] = w44;


retorno30:
    cout<< "";
}

void javaListaEgetSize(){
int w48;
int w49;
int w50;
int w51;
int w52;
int w53;

w49 = ptr + 0;
w50 = stack[w49];

w51 = w50 + 2;
w52 = heap[w51];

w53 = ptr + 1;
stack[w53] = w52;

goto retorno48;
retorno48:
    cout<< "";
}

void javaListaEgetNum(){
int w54;
int w55;
int w56;
int w57;
int w58;
int w59;

w55 = ptr + 0;
w56 = stack[w55];

w57 = w56 + 3;
w58 = heap[w57];

w59 = ptr + 1;
stack[w59] = w58;

goto retorno54;
retorno54:
    cout<< "";
}

void javaListaEobtenerNodoint(){
int w60;
int w61;
int w62;
int w63;
int w64;
int w65;
int w66;
int w67;
int w68;
int w69;
int w70;
int w71;
int w72;
int w73;
int w74;
int w75;
int w76;
int w77;
int w78;
int w79;
int w80;
int w81;
int w82;
int w83;
int w84;
int w85;
int w86;
int w87;
int w88;
int w89;
int w90;
int w91;
int w92;
int w93;
int w94;
int w95;
int w96;

w61 = ptr + 0;
w62 = stack[w61];

w63 = w62 + 0;
w64 = heap[w63];

w65 = ptr + 4;
stack[w65] = w64;

w66 = 0;

w67 = ptr + 5;
stack[w67] = w66;

w72 = 0;

w73 = ptr + 5;
stack[w73] = w72;


label_Loop68:{}
w74 = ptr + 5;
w75 = stack[w74];

w76 = ptr + 3;
w77 = stack[w76];

if(w75<w77)goto label_ins70;
goto salida69;
label_ins70:{}
w78 = ptr + 4;
w79 = stack[w78];

w80 = ptr + 6;

w81 = w80 + 0;
stack[w81] = w79;

ptr = ptr + 6;
javaNodogetSiguiente();
ptr = ptr - 6;

//retorno
w82 = ptr + 6;

w83 = w82 + 1;
w84 = stack[w83];


//retorno
w85 = w84;

w86 = ptr + 4;
stack[w86] = w85;


w87 = ptr + 5;
w88 = stack[w87];

w90 = 1;

w91 = w88+w90;
w92 = w91;

w93 = ptr + 5;
stack[w93] = w92;


goto label_Loop68;
salida69:{}
w94 = ptr + 4;
w95 = stack[w94];

w96 = ptr + 1;
stack[w96] = w95;

goto retorno60;
retorno60:
    cout<< "";
}

void javaListaEgetContentint(){
int w97;
int w98;
int w99;
int w100;
int w101;
int w102;
int w103;
int w104;
int w105;
int w106;
int w107;
int w108;
int w109;
int w110;
int w111;
int w112;
int w113;
int w114;
int w115;
int w116;

w98 = ptr + 3;
w99 = stack[w98];

w100 = ptr + 5;

w101 = ptr + 0;
w102 = stack[w101];

w103 = w100 + 0;
stack[w103] = w102;

w104 = w100 + 3;
stack[w104] = w99;

ptr = ptr + 5;
javaListaEobtenerNodoPROint();
ptr = ptr - 5;

//retorno
w105 = ptr + 5;

w106 = w105 + 1;
w107 = stack[w106];


//retorno
w108 = ptr + 4;
stack[w108] = w107;

w109 = ptr + 4;
w110 = stack[w109];

w111 = ptr + 5;

w112 = w111 + 0;
stack[w112] = w110;

ptr = ptr + 5;
javaNodogetContenido();
ptr = ptr - 5;

//retorno
w113 = ptr + 5;

w114 = w113 + 1;
w115 = stack[w114];


//retorno
w116 = ptr + 1;
stack[w116] = w115;

goto retorno97;
retorno97:
    cout<< "";
}

void javaListaEobtenerNodoPROint(){
int w117;
int w118;
int w119;
int w120;
int w121;
int w122;
int w123;
int w124;
int w125;
int w126;
int w127;
int w128;
int w129;
int w130;
int w131;
int w132;
int w133;
int w134;
int w135;
int w136;
int w137;
int w138;
int w139;
int w140;
int w141;
int w142;
int w143;
int w144;
int w145;
int w146;
int w147;
int w148;
int w149;
int w150;
int w151;
int w152;
int w153;
int w154;
int w155;
int w156;
int w157;
int w158;
int w159;
int w160;
int w161;
int w162;
int w163;
int w164;
int w165;
int w166;
int w167;
int w168;
int w169;
int w170;
int w171;
int w172;
int w173;
int w174;
int w175;
int w176;
int w177;
int w178;
int w179;
int w180;
int w181;

w122 = ptr + 0;
w123 = stack[w122];

w124 = w123 + 0;
w125 = heap[w124];

if(w125== -1)goto if118;
goto salida119;
if118:
cout<<La lista esta vacia.;
cout<<endl;
w127 = ptr + 1;
stack[w127] =  -1;

goto retorno117;

goto salida119;
salida119:
w132 = ptr + 3;
w133 = stack[w132];

w134 = ptr + 0;
w135 = stack[w134];

w136 = w135 + 2;
w137 = heap[w136];

if(w133>=w137)goto if128;
goto cmpOp2138;
w139 = ptr + 3;
w140 = stack[w139];

cmpOp2138:
if(w140<0)goto if128;
goto salida129;
if128:
cout<<El indice esta fuera del tama;o de la lista.;
cout<<endl;
w143 = ptr + 1;
stack[w143] =  -1;

goto retorno117;

goto salida129;
salida129:
w144 = ptr + 0;
w145 = stack[w144];

w146 = w145 + 2;
w147 = heap[w146];

w149 = 2;

w150 = w147/w149;
w151 = ptr + 4;
stack[w151] = w150;

w156 = ptr + 3;
w157 = stack[w156];

w158 = ptr + 4;
w159 = stack[w158];

if(w157<w159)goto if152;
goto else154;
if152:
w160 = ptr + 3;
w161 = stack[w160];

w162 = ptr + 5;

w163 = ptr + 0;
w164 = stack[w163];

w165 = w162 + 0;
stack[w165] = w164;

w166 = w162 + 3;
stack[w166] = w161;

ptr = ptr + 5;
javaListaEobtenerNodoAvanzandoint();
ptr = ptr - 5;

//retorno
w167 = ptr + 5;

w168 = w167 + 1;
w169 = stack[w168];


//retorno
w170 = ptr + 1;
stack[w170] = w169;

goto retorno117;

goto salida153;
else154:
w171 = ptr + 3;
w172 = stack[w171];

w173 = ptr + 5;

w174 = ptr + 0;
w175 = stack[w174];

w176 = w173 + 0;
stack[w176] = w175;

w177 = w173 + 3;
stack[w177] = w172;

ptr = ptr + 5;
javaListaEobtenerNodoRetrocediendoint();
ptr = ptr - 5;

//retorno
w178 = ptr + 5;

w179 = w178 + 1;
w180 = stack[w179];


//retorno
w181 = ptr + 1;
stack[w181] = w180;

goto retorno117;

salida153:
retorno117:
    cout<< "";
}

void javaListaEobtenerNodoAvanzandoint(){
int w182;
int w183;
int w184;
int w185;
int w186;
int w187;
int w188;
int w189;
int w190;
int w191;
int w192;
int w193;
int w194;
int w195;
int w196;
int w197;
int w198;
int w199;
int w200;
int w201;
int w202;
int w203;
int w204;
int w205;
int w206;
int w207;
int w208;
int w209;
int w210;
int w211;
int w212;
int w213;
int w214;
int w215;
int w216;
int w217;
int w218;

w183 = ptr + 0;
w184 = stack[w183];

w185 = w184 + 0;
w186 = heap[w185];

w187 = ptr + 4;
stack[w187] = w186;

w188 = 0;

w189 = ptr + 5;
stack[w189] = w188;

w194 = 0;

w195 = ptr + 5;
stack[w195] = w194;


label_Loop190:{}
w196 = ptr + 5;
w197 = stack[w196];

w198 = ptr + 3;
w199 = stack[w198];

if(w197<w199)goto label_ins192;
goto salida191;
label_ins192:{}
w200 = ptr + 4;
w201 = stack[w200];

w202 = ptr + 6;

w203 = w202 + 0;
stack[w203] = w201;

ptr = ptr + 6;
javaNodogetSiguiente();
ptr = ptr - 6;

//retorno
w204 = ptr + 6;

w205 = w204 + 1;
w206 = stack[w205];


//retorno
w207 = w206;

w208 = ptr + 4;
stack[w208] = w207;


w209 = ptr + 5;
w210 = stack[w209];

w212 = 1;

w213 = w210+w212;
w214 = w213;

w215 = ptr + 5;
stack[w215] = w214;


goto label_Loop190;
salida191:{}
w216 = ptr + 4;
w217 = stack[w216];

w218 = ptr + 1;
stack[w218] = w217;

goto retorno182;
retorno182:
    cout<< "";
}

void javaListaEobtenerNodoRetrocediendoint(){
int w219;
int w220;
int w221;
int w222;
int w223;
int w224;
int w225;
int w226;
int w227;
int w228;
int w229;
int w230;
int w231;
int w232;
int w233;
int w234;
int w235;
int w236;
int w237;
int w238;
int w239;
int w240;
int w241;
int w242;
int w243;
int w244;
int w245;
int w246;
int w247;
int w248;
int w249;
int w250;
int w251;
int w252;
int w253;
int w254;
int w255;
int w256;
int w257;
int w258;
int w259;
int w260;
int w261;
int w262;
int w263;
int w264;
int w265;
int w266;
int w267;
int w268;
int w269;

w220 = ptr + 0;
w221 = stack[w220];

w222 = w221 + 2;
w223 = heap[w222];

w225 = 1;

w226 = w223-w225;
w227 = ptr + 4;
stack[w227] = w226;

w228 = ptr + 4;
w229 = stack[w228];

w230 = ptr + 3;
w231 = stack[w230];

w232 = w229-w231;
w233 = ptr + 5;
stack[w233] = w232;

w234 = ptr + 0;
w235 = stack[w234];

w236 = w235 + 1;
w237 = heap[w236];

w238 = ptr + 6;
stack[w238] = w237;

w239 = 0;

w240 = ptr + 7;
stack[w240] = w239;

w245 = 0;

w246 = ptr + 7;
stack[w246] = w245;


label_Loop241:{}
w247 = ptr + 7;
w248 = stack[w247];

w249 = ptr + 5;
w250 = stack[w249];

if(w248<w250)goto label_ins243;
goto salida242;
label_ins243:{}
w251 = ptr + 6;
w252 = stack[w251];

w253 = ptr + 8;

w254 = w253 + 0;
stack[w254] = w252;

ptr = ptr + 8;
javaNodogetAnterior();
ptr = ptr - 8;

//retorno
w255 = ptr + 8;

w256 = w255 + 1;
w257 = stack[w256];


//retorno
w258 = w257;

w259 = ptr + 6;
stack[w259] = w258;


w260 = ptr + 7;
w261 = stack[w260];

w263 = 1;

w264 = w261+w263;
w265 = w264;

w266 = ptr + 7;
stack[w266] = w265;


goto label_Loop241;
salida242:{}
w267 = ptr + 6;
w268 = stack[w267];

w269 = ptr + 1;
stack[w269] = w268;

goto retorno219;
retorno219:
    cout<< "";
}

void javaListaEagregarint(){
int w270;
int w271;
int w272;
int w273;
int w274;
int w275;
int w276;
int w277;
int w278;
int w279;
int w280;
int w281;
int w282;
int w283;
int w284;
int w285;
int w286;
int w287;
int w288;
int w289;
int w290;
int w291;
int w292;
int w293;
int w294;
int w295;
int w296;
int w297;
int w298;
int w299;
int w300;
int w301;
int w302;
int w303;
int w304;
int w305;
int w306;
int w307;
int w308;
int w309;
int w310;
int w311;
int w312;
int w313;
int w314;
int w315;
int w316;
int w317;
int w318;
int w319;
int w320;
int w321;
int w322;
int w323;
int w324;
int w325;
int w326;
int w327;
int w328;
int w329;
int w330;
int w331;

w271 = ptr + 2;
w272 = stack[w271];

w273 = ptr + 4;

w274 = w273 + 2;
stack[w274] = w272;

ptr = ptr + 4;
javaNodoNodoint();
ptr = ptr - 4;
w275 = ptr + 4;

w276 = w275 + 0;
w277 = stack[w276];

w278 = ptr + 3;
stack[w278] = w277;

w283 = ptr + 0;
w284 = stack[w283];

w285 = w284 + 0;
w286 = heap[w285];

if(w286== -1)goto if279;
goto else281;
if279:
cout<<agregando el primero;
cout<<endl;
w288 = ptr + 3;
w289 = stack[w288];

w290 = ptr + 0;
w291 = stack[w290];

w292 = w291 + 0;
heap[w292] = w289;


w293 = ptr + 3;
w294 = stack[w293];

w295 = ptr + 0;
w296 = stack[w295];

w297 = w296 + 1;
heap[w297] = w294;



goto salida280;
else281:
cout<<agregando el otro;
cout<<endl;
w299 = ptr + 0;
w300 = stack[w299];

w301 = w300 + 1;
w302 = heap[w301];

w303 = ptr + 3;
w304 = stack[w303];

w305 = ptr + 4;

w306 = w305 + 0;
stack[w306] = w302;

w307 = w305 + 2;
stack[w307] = w304;

ptr = ptr + 4;
javaNodosetSiguienteNodo();
ptr = ptr - 4;
w308 = ptr + 3;
w309 = stack[w308];

w310 = ptr + 0;
w311 = stack[w310];

w312 = w311 + 1;
w313 = heap[w312];

w314 = ptr + 4;

w315 = w314 + 0;
stack[w315] = w309;

w316 = w314 + 2;
stack[w316] = w313;

ptr = ptr + 4;
javaNodosetAnteriorNodo();
ptr = ptr - 4;
w317 = ptr + 3;
w318 = stack[w317];

w319 = ptr + 0;
w320 = stack[w319];

w321 = w320 + 1;
heap[w321] = w318;



salida280:
w322 = ptr + 0;
w323 = stack[w322];

w324 = w323 + 2;
w325 = heap[w324];

w327 = 1;

w328 = w325+w327;
w329 = ptr + 0;
w330 = stack[w329];

w331 = w330 + 2;
heap[w331] = w328;


retorno270:
    cout<< " ";
}

void javaListaEimprimirLista(){
int w332;
int w333;
int w334;
int w335;
int w336;
int w337;
int w338;
int w339;
int w340;
int w341;
int w342;
int w343;
int w344;
int w345;
int w346;
int w347;
int w348;
int w349;
int w350;
int w351;
int w352;
int w353;
int w354;
int w355;
int w356;
int w357;
int w358;
int w359;
int w360;
int w361;
int w362;
int w363;
int w364;
int w365;
int w366;
int w367;
int w368;
int w369;
int w370;
int w371;
int w372;
int w373;
int w374;
int w375;

w333 = ptr + 0;
w334 = stack[w333];

w335 = w334 + 0;
w336 = heap[w335];

w337 = ptr + 2;
stack[w337] = w336;

w338 = 0;

w339 = ptr + 3;
stack[w339] = w338;

w344 = 0;

w345 = ptr + 3;
stack[w345] = w344;


label_Loop340:{}
w346 = ptr + 3;
w347 = stack[w346];

w348 = ptr + 0;
w349 = stack[w348];

w350 = w349 + 2;
w351 = heap[w350];

if(w347<w351)goto label_ins342;
goto salida341;
label_ins342:{}
cout<<contenido: ;
w353 = ptr + 2;
w354 = stack[w353];

w355 = ptr + 4;

w356 = w355 + 0;
stack[w356] = w354;

ptr = ptr + 4;
javaNodogetContenido();
ptr = ptr - 4;

//retorno
w357 = ptr + 4;

w358 = w357 + 1;
w359 = stack[w358];


//retorno
cout<<w359;
cout<<endl;
w360 = ptr + 2;
w361 = stack[w360];

w362 = ptr + 4;

w363 = w362 + 0;
stack[w363] = w361;

ptr = ptr + 4;
javaNodogetSiguiente();
ptr = ptr - 4;

//retorno
w364 = ptr + 4;

w365 = w364 + 1;
w366 = stack[w365];


//retorno
w367 = w366;

w368 = ptr + 2;
stack[w368] = w367;


w369 = ptr + 3;
w370 = stack[w369];

w372 = 1;

w373 = w370+w372;
w374 = w373;

w375 = ptr + 3;
stack[w375] = w374;


goto label_Loop340;
salida341:{}
retorno332:
    cout<< " ";
}

void javaListaEeliminarUltimo(){
int w376;
int w377;
int w378;
int w379;
int w380;
int w381;
int w382;
int w383;
int w384;
int w385;
int w386;
int w387;
int w388;
int w389;
int w390;
int w391;
int w392;
int w393;
int w394;
int w395;
int w396;
int w397;
int w398;
int w399;
int w400;
int w401;
int w402;
int w403;
int w404;
int w405;
int w406;
int w407;
int w408;
int w409;
int w410;
int w411;
int w412;
int w413;
int w414;
int w415;
int w416;
int w417;
int w418;
int w419;
int w420;
int w421;
int w422;
int w423;
int w424;
int w425;
int w426;
int w427;
int w428;
int w429;
int w430;
int w431;
int w432;
int w433;
int w434;
int w435;
int w436;
int w437;
int w438;
int w439;
int w440;
int w441;
int w442;
int w443;
int w444;

w377 = ptr + 2;
stack[w377] =  -1;

w378 = ptr + 3;
stack[w378] =  -1;

w383 = ptr + 0;
w384 = stack[w383];

w385 = w384 + 0;
w386 = heap[w385];

if(w386== -1)goto if379;
goto else381;
if379:
cout<<La lista esta vacia;
cout<<endl;

goto salida380;
else381:
w392 = ptr + 0;
w393 = stack[w392];

w394 = w393 + 2;
w395 = heap[w394];

if(w395==1)goto if388;
goto else390;
if388:
w397 = ptr + 0;
w398 = stack[w397];

w399 = w398 + 0;
heap[w399] =  -1;


w400 = ptr + 0;
w401 = stack[w400];

w402 = w401 + 1;
heap[w402] =  -1;



goto salida389;
else390:
w403 = ptr + 0;
w404 = stack[w403];

w405 = w404 + 1;
w406 = heap[w405];

w407 = ptr + 4;

w408 = w407 + 0;
stack[w408] = w406;

ptr = ptr + 4;
javaNodogetAnterior();
ptr = ptr - 4;

//retorno
w409 = ptr + 4;

w410 = w409 + 1;
w411 = stack[w410];


//retorno
w412 = w411;

w413 = ptr + 2;
stack[w413] = w412;


w414 = ptr + 2;
w415 = stack[w414];

w416 = ptr + 3;
w417 = stack[w416];

w418 = ptr + 4;

w419 = w418 + 0;
stack[w419] = w415;

w420 = w418 + 2;
stack[w420] = w417;

ptr = ptr + 4;
javaNodosetSiguienteNodo();
ptr = ptr - 4;
w421 = ptr + 0;
w422 = stack[w421];

w423 = w422 + 1;
w424 = heap[w423];

w425 = ptr + 3;
w426 = stack[w425];

w427 = ptr + 4;

w428 = w427 + 0;
stack[w428] = w424;

w429 = w427 + 2;
stack[w429] = w426;

ptr = ptr + 4;
javaNodosetAnteriorNodo();
ptr = ptr - 4;
w430 = ptr + 2;
w431 = stack[w430];

w432 = ptr + 0;
w433 = stack[w432];

w434 = w433 + 1;
heap[w434] = w431;



salida389:
w435 = ptr + 0;
w436 = stack[w435];

w437 = w436 + 2;
w438 = heap[w437];

w440 = 1;

w441 = w438-w440;
w442 = ptr + 0;
w443 = stack[w442];

w444 = w443 + 2;
heap[w444] = w441;



salida380:
retorno376:
    cout<< " ";
}

void javaListaEListaE(){
int w445;
int w446;
int w447;
int w448;
int w449;
int w450;
int w451;
int w452;
int w453;
int w454;
int w455;
int w456;
int w457;
int w458;
int w459;
int w460;
int w461;

w446 = h;
h = w446 + 4;

w447 = ptr + 0;
stack[w447] = w446;

w448 = ptr + 0;
w449 = stack[w448];

w450 = w449 + 0;
heap[w450] =  -1;


w451 = ptr + 0;
w452 = stack[w451];

w453 = w452 + 1;
heap[w453] =  -1;


w455 = ptr + 0;
w456 = stack[w455];

w457 = w456 + 2;
heap[w457] = 0;


w459 = ptr + 0;
w460 = stack[w459];

w461 = w460 + 3;
heap[w461] = 0;


retorno445:
    cout<< "";
}

void javasumariniciar(){
int w462;
int w463;
int w464;
int w465;
int w466;
int w467;
int w468;
int w469;
int w470;
int w471;
int w472;
int w473;
int w474;
int w475;
int w476;
int w477;
int w478;
int w479;
int w480;
int w481;
int w482;
int w483;
int w484;
int w485;
int w486;
int w487;
int w488;
int w489;
int w490;
int w491;
int w492;
int w493;
int w494;
int w495;
int w496;
int w497;
int w498;
int w499;
int w500;
int w501;
int w502;
int w503;
int w504;
int w505;
int w506;
int w507;
int w508;
int w509;
int w510;
int w511;
int w512;
int w513;
int w514;
int w515;
int w516;
int w517;
int w518;
int w519;
int w520;
int w521;
int w522;
int w523;
int w524;
int w525;
int w526;
int w527;
int w528;
int w529;
int w530;
int w531;
int w532;
int w533;
int w534;
int w535;
int w536;
int w537;
int w538;
int w539;
int w540;
int w541;
int w542;
int w543;
int w544;
int w545;
int w546;
int w547;
int w548;
int w549;
int w550;
int w551;
int w552;
int w553;
int w554;
int w555;
int w556;
int w557;
int w558;
int w559;
int w560;
int w561;
int w562;
int w563;
int w564;
int w565;
int w566;
int w567;
int w568;
int w569;
int w570;
int w571;
int w572;
int w573;
int w574;
int w575;
int w576;
int w577;
int w578;
int w579;
int w580;
int w581;
int w582;
int w583;
int w584;
int w585;
int w586;
int w587;
int w588;
int w589;
int w590;
int w591;
int w592;
int w593;
int w594;
int w595;
int w596;
int w597;
int w598;
int w599;
int w600;
int w601;
int w602;
int w603;
int w604;
int w605;
int w606;
int w607;
int w608;
int w609;
int w610;
int w611;
int w612;
int w613;
int w614;

w463 = ptr + 3;

ptr = ptr + 3;
javaListaEListaE();
ptr = ptr - 3;
w464 = ptr + 3;

w465 = w464 + 0;
w466 = stack[w465];

w467 = ptr + 0;
w468 = stack[w467];

w469 = w468 + 2;
heap[w469] = w466;


w470 = ptr + 0;
w471 = stack[w470];

w472 = w471 + 2;
w473 = heap[w472];

w475 = ptr + 3;

w476 = w475 + 0;
stack[w476] = w473;

w477 = w475 + 2;
stack[w477] = 71;

ptr = ptr + 3;
javaListaEagregarint();
ptr = ptr - 3;
w478 = ptr + 0;
w479 = stack[w478];

w480 = w479 + 2;
w481 = heap[w480];

w483 = ptr + 3;

w484 = w483 + 0;
stack[w484] = w481;

w485 = w483 + 2;
stack[w485] = 72;

ptr = ptr + 3;
javaListaEagregarint();
ptr = ptr - 3;
w486 = ptr + 0;
w487 = stack[w486];

w488 = w487 + 2;
w489 = heap[w488];

w491 = ptr + 3;

w492 = w491 + 0;
stack[w492] = w489;

w493 = w491 + 2;
stack[w493] = 73;

ptr = ptr + 3;
javaListaEagregarint();
ptr = ptr - 3;
w494 = ptr + 0;
w495 = stack[w494];

w496 = w495 + 2;
w497 = heap[w496];

w499 = ptr + 3;

w500 = w499 + 0;
stack[w500] = w497;

w501 = w499 + 2;
stack[w501] = 74;

ptr = ptr + 3;
javaListaEagregarint();
ptr = ptr - 3;
w502 = ptr + 0;
w503 = stack[w502];

w504 = w503 + 2;
w505 = heap[w504];

w507 = ptr + 3;

w508 = w507 + 0;
stack[w508] = w505;

w509 = w507 + 2;
stack[w509] = 75;

ptr = ptr + 3;
javaListaEagregarint();
ptr = ptr - 3;
w510 = ptr + 0;
w511 = stack[w510];

w512 = w511 + 2;
w513 = heap[w512];

w515 = ptr + 3;

w516 = w515 + 0;
stack[w516] = w513;

w517 = w515 + 2;
stack[w517] = 76;

ptr = ptr + 3;
javaListaEagregarint();
ptr = ptr - 3;
w518 = ptr + 0;
w519 = stack[w518];

w520 = w519 + 2;
w521 = heap[w520];

w523 = ptr + 3;

w524 = w523 + 0;
stack[w524] = w521;

w525 = w523 + 2;
stack[w525] = 77;

ptr = ptr + 3;
javaListaEagregarint();
ptr = ptr - 3;
w526 = ptr + 0;
w527 = stack[w526];

w528 = w527 + 2;
w529 = heap[w528];

w531 = ptr + 3;

w532 = w531 + 0;
stack[w532] = w529;

w533 = w531 + 2;
stack[w533] = 78;

ptr = ptr + 3;
javaListaEagregarint();
ptr = ptr - 3;
w534 = ptr + 0;
w535 = stack[w534];

w536 = w535 + 2;
w537 = heap[w536];

w539 = ptr + 3;

w540 = w539 + 0;
stack[w540] = w537;

w541 = w539 + 2;
stack[w541] = 79;

ptr = ptr + 3;
javaListaEagregarint();
ptr = ptr - 3;
w542 = ptr + 0;
w543 = stack[w542];

w544 = w543 + 2;
w545 = heap[w544];

w546 = ptr + 3;

w547 = w546 + 0;
stack[w547] = w545;

ptr = ptr + 3;
javaListaEimprimirLista();
ptr = ptr - 3;
cout<<eliminando algunos:  ;
cout<<endl;
w549 = ptr + 0;
w550 = stack[w549];

w551 = w550 + 2;
w552 = heap[w551];

w553 = ptr + 3;

w554 = w553 + 0;
stack[w554] = w552;

ptr = ptr + 3;
javaListaEeliminarUltimo();
ptr = ptr - 3;
w555 = ptr + 0;
w556 = stack[w555];

w557 = w556 + 2;
w558 = heap[w557];

w559 = ptr + 3;

w560 = w559 + 0;
stack[w560] = w558;

ptr = ptr + 3;
javaListaEeliminarUltimo();
ptr = ptr - 3;
w561 = ptr + 0;
w562 = stack[w561];

w563 = w562 + 2;
w564 = heap[w563];

w565 = ptr + 3;

w566 = w565 + 0;
stack[w566] = w564;

ptr = ptr + 3;
javaListaEeliminarUltimo();
ptr = ptr - 3;
w567 = ptr + 0;
w568 = stack[w567];

w569 = w568 + 2;
w570 = heap[w569];

w571 = ptr + 3;

w572 = w571 + 0;
stack[w572] = w570;

ptr = ptr + 3;
javaListaEimprimirLista();
ptr = ptr - 3;
cout<<lista: ;
w574 = ptr + 0;
w575 = stack[w574];

w576 = w575 + 2;
w577 = heap[w576];

w578 = ptr + 3;

w579 = w578 + 0;
stack[w579] = w577;

ptr = ptr + 3;
javaListaEgetSize();
ptr = ptr - 3;

//retorno
w580 = ptr + 3;

w581 = w580 + 1;
w582 = stack[w581];


//retorno
cout<<w582;
cout<<endl;
cout<<obtener modo pro pos(3): ;
w584 = ptr + 0;
w585 = stack[w584];

w586 = w585 + 2;
w587 = heap[w586];

w589 = ptr + 3;

w590 = w589 + 0;
stack[w590] = w587;

w591 = w589 + 3;
stack[w591] = 4;

ptr = ptr + 3;
javaListaEgetContentint();
ptr = ptr - 3;

//retorno
w592 = ptr + 3;

w593 = w592 + 1;
w594 = stack[w593];


//retorno
cout<<w594;
cout<<endl;
w595 = ptr + 0;
w596 = stack[w595];

w597 = w596 + 2;
w598 = heap[w597];

w600 = ptr + 3;

w601 = w600 + 0;
stack[w601] = w598;

w602 = w600 + 3;
stack[w602] = 3;

ptr = ptr + 3;
javaListaEobtenerNodoint();
ptr = ptr - 3;

//retorno
w603 = ptr + 3;

w604 = w603 + 1;
w605 = stack[w604];


//retorno
w606 = ptr + 2;
stack[w606] = w605;

cout<<obteniendo contenido de un nodo: en pos 3: ;
w608 = ptr + 2;
w609 = stack[w608];

w610 = ptr + 3;

w611 = w610 + 0;
stack[w611] = w609;

ptr = ptr + 3;
javaNodogetContenido();
ptr = ptr - 3;

//retorno
w612 = ptr + 3;

w613 = w612 + 1;
w614 = stack[w613];


//retorno
cout<<w614;
cout<<endl;
retorno462:
    cout<< " ";
}

void javasumarsumar(){
int w615;
int w616;
int w617;
int w618;
int w619;
int w620;

w616 = h;
h = w616 + 3;

w617 = ptr + 0;
stack[w617] = w616;

w618 = ptr + 0;
w619 = stack[w618];

w620 = w619 + 2;
heap[w620] =  -1;


retorno615:
    cout<< "";
}




int main(){
int w0;
int w1;
int w2;
int w3;
int w4;
int w5;
int w6;
int w7;
int w8;
int w9;
int w10;
int w11;
int w12;
int w13;
int w14;
int w15;
int w16;
int w17;
int w18;

w1 = ptr + 0;
stack[w1] = 12;

w3 = ptr + 1;
stack[w3] = 6;

w5 = ptr + 2;
stack[w5] = 9;

w7 = ptr + 3;
stack[w7] = 88;

w8 = ptr + 5;

ptr = ptr + 5;
javasumarsumar();
ptr = ptr - 5;
w9 = ptr + 5;

w10 = w9 + 0;
w11 = stack[w10];

w12 = ptr + 4;
stack[w12] = w11;

w14 = ptr + 4;
w15 = stack[w14];

w16 = ptr + 5;

w17 = w16 + 0;
stack[w17] = w15;

w18 = ptr + 5;

ptr = ptr + 5;
javasumariniciar();
ptr = ptr - 5;

labelReturn13:

cout<<endl;
}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

