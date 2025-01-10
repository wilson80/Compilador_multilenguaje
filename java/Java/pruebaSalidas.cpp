#include <iostream>

using namespace std;

int stack[1000];
int heap[1000];
int ptr = 0;
int h = 0;



void java_sumar_sumar(){
int w0;
int w1;
int w2;
int w3;
int w4;
int w5;

w1 = h;
h = w1 + 3;

w2 = ptr + 0;
stack[w2] = w1;

w3 = ptr + 0;
w4 = stack[w3];

w5 = w4 + 2;
heap[w5] =  -1;


retorno0:
    cout<< "";
}

void java_ListaE_ListaE(){
int w8;
int w9;
int w10;
int w11;
int w12;
int w13;
int w14;
int w15;
int w16;

w9 = h;
h = w9 + 4;

w10 = ptr + 0;
stack[w10] = w9;

w11 = ptr + 0;
w12 = stack[w11];

w13 = w12 + 0;
heap[w13] =  -1;


w14 = ptr + 0;
w15 = stack[w14];

w16 = w15 + 1;
heap[w16] =  -1;


retorno8:
    cout<< "";
}

void java_Nodo_Nodo(){
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
int w48;

w36 = h;
h = w36 + 3;

w37 = ptr + 0;
stack[w37] = w36;

w38 = ptr + 0;
w39 = stack[w38];

w40 = w39 + 1;
heap[w40] =  -1;


w41 = ptr + 0;
w42 = stack[w41];

w43 = w42 + 2;
heap[w43] =  -1;


w44 = ptr + 2;
w45 = stack[w44];

w46 = ptr + 0;
w47 = stack[w46];

w48 = w47 + 0;
heap[w48] = w45;


retorno35:
    cout<< "";
}

void java_Nodo_setSiguiente(){
int w76;
int w77;
int w78;
int w79;
int w80;
int w81;

w77 = ptr + 2;
w78 = stack[w77];

w79 = ptr + 0;
w80 = stack[w79];

w81 = w80 + 1;
heap[w81] = w78;


retorno76:
    cout<< " ";
}

void java_Nodo_setAnterior(){
int w91;
int w92;
int w93;
int w94;
int w95;
int w96;

w92 = ptr + 2;
w93 = stack[w92];

w94 = ptr + 0;
w95 = stack[w94];

w96 = w95 + 2;
heap[w96] = w93;


retorno91:
    cout<< " ";
}

void java_ListaE_agregar(){
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
int w48;
int w49;
int w50;
int w51;
int w52;
int w53;
int w54;
int w55;
int w56;
int w57;
int w58;
int w59;
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

w31 = ptr + 2;
w32 = stack[w31];

w33 = ptr + 4;

w34 = w33 + 2;
stack[w34] = w32;

ptr = ptr + 4;
java_Nodo_Nodo();
ptr = ptr - 4;
w49 = ptr + 4;

w50 = w49 + 0;
w51 = stack[w50];

w52 = ptr + 3;
stack[w52] = w51;

if53:
cout<<"agregando el primero";
cout<<endl;
w57 = ptr + 3;
w58 = stack[w57];

w59 = ptr + 0;
w60 = stack[w59];

w61 = w60 + 0;
heap[w61] = w58;


w62 = ptr + 3;
w63 = stack[w62];

w64 = ptr + 0;
w65 = stack[w64];

w66 = w65 + 1;
heap[w66] = w63;



goto salida54;
else55:
cout<<"agregando el primero";
cout<<endl;
w67 = ptr + 0;
w68 = stack[w67];

w69 = w68 + 1;
w70 = heap[w69];

w71 = ptr + 3;
w72 = stack[w71];

w73 = ptr + 4;

w74 = w73 + 0;
stack[w74] = w70;

w75 = w73 + 2;
stack[w75] = w72;

ptr = ptr + 4;
java_Nodo_setSiguiente();
ptr = ptr - 4;
w82 = ptr + 3;
w83 = stack[w82];

w84 = ptr + 0;
w85 = stack[w84];

w86 = w85 + 1;
w87 = heap[w86];

w88 = ptr + 4;

w89 = w88 + 0;
stack[w89] = w83;

w90 = w88 + 2;
stack[w90] = w87;

ptr = ptr + 4;
java_Nodo_setAnterior();
ptr = ptr - 4;
w97 = ptr + 3;
w98 = stack[w97];

w99 = ptr + 0;
w100 = stack[w99];

w101 = w100 + 1;
heap[w101] = w98;



salida54:
w102 = ptr + 0;
w103 = stack[w102];

w104 = w103 + 2;
w105 = heap[w104];

w106 = 1;

w107 = w105+w106;
w108 = ptr + 0;
w109 = stack[w108];

w110 = w109 + 2;
heap[w110] = w107;


retorno30:
    cout<< " ";
}

void java_ListaE_getSize(){
int w289;
int w290;
int w291;
int w292;
int w293;
int w294;

w290 = ptr + 0;
w291 = stack[w290];

w292 = w291 + 2;
w293 = heap[w292];

w294 = ptr + 1;
stack[w294] = w293;

goto retorno289;
retorno289:
    cout<< "";
}

void java_Nodo_getSiguiente(){
int w328;
int w329;
int w330;
int w331;
int w332;
int w333;

w329 = ptr + 0;
w330 = stack[w329];

w331 = w330 + 1;
w332 = heap[w331];

w333 = ptr + 1;
stack[w333] = w332;

goto retorno328;
retorno328:
    cout<< "";
}

void java_Nodo_getContenido(){
int w341;
int w342;
int w343;
int w344;
int w345;
int w346;

w342 = ptr + 0;
w343 = stack[w342];

w344 = w343 + 0;
w345 = heap[w344];

w346 = ptr + 1;
stack[w346] = w345;

goto retorno341;
retorno341:
    cout<< "";
}

void java_ListaE_imprimirLista(){
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
int w376;
int w377;

w305 = -1;

w306 = ptr + 2;
stack[w306] = w305;

w311 = ptr + 0;
w312 = stack[w311];

w313 = w312 + 0;
w314 = heap[w313];

if(w314== -1)goto if307;
goto else309;
if307:
cout<<"La lista esta vacia";
cout<<endl;

goto salida308;
else309:
w315 = ptr + 0;
w316 = stack[w315];

w317 = w316 + 0;
w318 = heap[w317];

w319 = w318;

w320 = ptr + 2;
stack[w320] = w319;


while323:{}
w324 = ptr + 2;
w325 = stack[w324];

w326 = ptr + 3;

w327 = w326 + 0;
stack[w327] = w325;

ptr = ptr + 3;
java_Nodo_getSiguiente();
ptr = ptr - 3;

//retorno
w334 = ptr + 3;

w335 = w334 + 1;
w336 = stack[w335];


//retorno
if(w336!= -1)goto insDo322;
goto finWhile321;
insDo322:{}
cout<<"contenido: ";
w337 = ptr + 2;
w338 = stack[w337];

w339 = ptr + 3;

w340 = w339 + 0;
stack[w340] = w338;

ptr = ptr + 3;
java_Nodo_getContenido();
ptr = ptr - 3;

//retorno
w347 = ptr + 3;

w348 = w347 + 1;
w349 = stack[w348];


//retorno
cout<<w349;
cout<<endl;
w350 = ptr + 2;
w351 = stack[w350];

w352 = ptr + 3;

w353 = w352 + 0;
stack[w353] = w351;

ptr = ptr + 3;
java_Nodo_getSiguiente();
ptr = ptr - 3;

//retorno
w360 = ptr + 3;

w361 = w360 + 1;
w362 = stack[w361];


//retorno
w363 = w362;

w364 = ptr + 2;
stack[w364] = w363;


goto while323;
finWhile321:{}
cout<<"contenido: ";
w365 = ptr + 2;
w366 = stack[w365];

w367 = ptr + 3;

w368 = w367 + 0;
stack[w368] = w366;

ptr = ptr + 3;
java_Nodo_getContenido();
ptr = ptr - 3;

//retorno
w375 = ptr + 3;

w376 = w375 + 1;
w377 = stack[w376];


//retorno
cout<<w377;
cout<<endl;

salida308:
retorno304:
    cout<< " ";
}

void java_sumar_iniciar(){
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
int w19;
int w20;
int w21;
int w22;
int w23;
int w24;
int w25;
int w26;
int w27;
int w28;
int w29;
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
int w48;
int w49;
int w50;
int w51;
int w52;
int w53;
int w54;
int w55;
int w56;
int w57;
int w58;
int w59;
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
int w376;
int w377;

w7 = ptr + 2;

ptr = ptr + 2;
java_ListaE_ListaE();
ptr = ptr - 2;
w17 = ptr + 2;

w18 = w17 + 0;
w19 = stack[w18];

w20 = ptr + 0;
w21 = stack[w20];

w22 = w21 + 2;
heap[w22] = w19;


w23 = ptr + 0;
w24 = stack[w23];

w25 = w24 + 2;
w26 = heap[w25];

w27 = ptr + 2;

w28 = w27 + 0;
stack[w28] = w26;

w29 = w27 + 2;
stack[w29] = 99;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
w111 = ptr + 0;
w112 = stack[w111];

w113 = w112 + 2;
w114 = heap[w113];

w115 = ptr + 2;

w116 = w115 + 0;
stack[w116] = w114;

w117 = w115 + 2;
stack[w117] = 37;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
w197 = ptr + 0;
w198 = stack[w197];

w199 = w198 + 2;
w200 = heap[w199];

w201 = ptr + 2;

w202 = w201 + 0;
stack[w202] = w200;

w203 = w201 + 2;
stack[w203] = 43;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
cout<<"lista: ";
w283 = ptr + 0;
w284 = stack[w283];

w285 = w284 + 2;
w286 = heap[w285];

w287 = ptr + 2;

w288 = w287 + 0;
stack[w288] = w286;

ptr = ptr + 2;
java_ListaE_getSize();
ptr = ptr - 2;

//retorno
w295 = ptr + 2;

w296 = w295 + 1;
w297 = stack[w296];


//retorno
cout<<w297;
cout<<endl;
w298 = ptr + 0;
w299 = stack[w298];

w300 = w299 + 2;
w301 = heap[w300];

w302 = ptr + 2;

w303 = w302 + 0;
stack[w303] = w301;

ptr = ptr + 2;
java_ListaE_imprimirLista();
ptr = ptr - 2;
retorno6:
    cout<< " ";
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

w0 = ptr + 0;
stack[w0] = 12;

w1 = ptr + 1;
stack[w1] = 6;

w2 = ptr + 2;
stack[w2] = 9;

w3 = ptr + 3;
stack[w3] = 88;

w4 = ptr + 5;

ptr = ptr + 5;
java_sumar_sumar();
ptr = ptr - 5;
w5 = ptr + 5;

w6 = w5 + 0;
w7 = stack[w6];

w8 = ptr + 4;
stack[w8] = w7;

w9 = ptr + 4;
w10 = stack[w9];

w11 = ptr + 5;

w12 = w11 + 0;
stack[w12] = w10;

w13 = ptr + 5;

ptr = ptr + 5;
java_sumar_iniciar();
ptr = ptr - 5;

}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

