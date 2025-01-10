#include <iostream>

using namespace std;

int stack[1000];
int heap[1000];
int ptr = 0;
int h = 0;



void java_Nodo_getContenido(){
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

void java_Nodo_getSiguiente(){
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

void java_Nodo_setSiguiente(){
int w12;
int w13;
int w14;
int w15;
int w16;
int w17;

w13 = ptr + 2;
w14 = stack[w13];

w15 = ptr + 0;
w16 = stack[w15];

w17 = w16 + 1;
heap[w17] = w14;


retorno12:
    cout<< " ";
}

void java_Nodo_setAnterior(){
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

w23 = w22 + 2;
heap[w23] = w20;


retorno18:
    cout<< " ";
}

void java_Nodo_Nodo(){
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

w25 = h;
h = w25 + 3;

w26 = ptr + 0;
stack[w26] = w25;

w27 = ptr + 0;
w28 = stack[w27];

w29 = w28 + 0;
heap[w29] = 0;


w30 = ptr + 0;
w31 = stack[w30];

w32 = w31 + 1;
heap[w32] =  -1;


w33 = ptr + 0;
w34 = stack[w33];

w35 = w34 + 2;
heap[w35] =  -1;


w36 = ptr + 2;
w37 = stack[w36];

w38 = ptr + 0;
w39 = stack[w38];

w40 = w39 + 0;
heap[w40] = w37;


retorno24:
    cout<< "";
}

void java_ListaE_getSize(){
int w41;
int w42;
int w43;
int w44;
int w45;
int w46;

w42 = ptr + 0;
w43 = stack[w42];

w44 = w43 + 2;
w45 = heap[w44];

w46 = ptr + 1;
stack[w46] = w45;

goto retorno41;
retorno41:
    cout<< "";
}

void java_ListaE_getNum(){
int w47;
int w48;
int w49;
int w50;
int w51;
int w52;

w48 = ptr + 0;
w49 = stack[w48];

w50 = w49 + 3;
w51 = heap[w50];

w52 = ptr + 1;
stack[w52] = w51;

goto retorno47;
retorno47:
    cout<< "";
}

void java_ListaE_obtenerNodo(){
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

cout<<"indice: ";
w54 = ptr + 3;
w55 = stack[w54];

cout<<w55;
cout<<endl;
w56 = ptr + 0;
w57 = stack[w56];

w58 = w57 + 0;
w59 = heap[w58];

w60 = ptr + 4;
stack[w60] = w59;

w61 = 0;

w62 = ptr + 5;
stack[w62] = w61;

w66 = 0;

w67 = ptr + 5;
stack[w67] = w66;


label_Loop63:{}
w68 = ptr + 5;
w69 = stack[w68];

w70 = ptr + 3;
w71 = stack[w70];

if(w69<w71)goto label_ins65;
goto salida64;
label_ins65:{}
w72 = ptr + 4;
w73 = stack[w72];

w74 = ptr + 6;

w75 = w74 + 0;
stack[w75] = w73;

ptr = ptr + 6;
java_Nodo_getSiguiente();
ptr = ptr - 6;

//retorno
w76 = ptr + 6;

w77 = w76 + 1;
w78 = stack[w77];


//retorno
w79 = w78;

w80 = ptr + 4;
stack[w80] = w79;


w81 = ptr + 5;
w82 = stack[w81];

w83 = 1;

w84 = w82+w83;
w85 = w84;

w86 = ptr + 5;
stack[w86] = w85;


goto label_Loop63;
salida64:{}
w87 = ptr + 4;
w88 = stack[w87];

w89 = ptr + 1;
stack[w89] = w88;

goto retorno53;
retorno53:
    cout<< "";
}

void java_ListaE_agregar(){
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

w91 = ptr + 2;
w92 = stack[w91];

w93 = ptr + 4;

w94 = w93 + 2;
stack[w94] = w92;

ptr = ptr + 4;
java_Nodo_Nodo();
ptr = ptr - 4;
w95 = ptr + 4;

w96 = w95 + 0;
w97 = stack[w96];

w98 = ptr + 3;
stack[w98] = w97;

w103 = ptr + 0;
w104 = stack[w103];

w105 = w104 + 0;
w106 = heap[w105];

if(w106== -1)goto if99;
goto else101;
if99:
cout<<"agregando el primero";
cout<<endl;
w107 = ptr + 3;
w108 = stack[w107];

w109 = ptr + 0;
w110 = stack[w109];

w111 = w110 + 0;
heap[w111] = w108;


w112 = ptr + 3;
w113 = stack[w112];

w114 = ptr + 0;
w115 = stack[w114];

w116 = w115 + 1;
heap[w116] = w113;



goto salida100;
else101:
cout<<"agregando el otro";
cout<<endl;
w117 = ptr + 0;
w118 = stack[w117];

w119 = w118 + 1;
w120 = heap[w119];

w121 = ptr + 3;
w122 = stack[w121];

w123 = ptr + 4;

w124 = w123 + 0;
stack[w124] = w120;

w125 = w123 + 2;
stack[w125] = w122;

ptr = ptr + 4;
java_Nodo_setSiguiente();
ptr = ptr - 4;
w126 = ptr + 3;
w127 = stack[w126];

w128 = ptr + 0;
w129 = stack[w128];

w130 = w129 + 1;
w131 = heap[w130];

w132 = ptr + 4;

w133 = w132 + 0;
stack[w133] = w127;

w134 = w132 + 2;
stack[w134] = w131;

ptr = ptr + 4;
java_Nodo_setAnterior();
ptr = ptr - 4;
w135 = ptr + 3;
w136 = stack[w135];

w137 = ptr + 0;
w138 = stack[w137];

w139 = w138 + 1;
heap[w139] = w136;



salida100:
w140 = ptr + 0;
w141 = stack[w140];

w142 = w141 + 2;
w143 = heap[w142];

w144 = 1;

w145 = w143+w144;
w146 = ptr + 0;
w147 = stack[w146];

w148 = w147 + 2;
heap[w148] = w145;


retorno90:
    cout<< " ";
}

void java_ListaE_imprimirLista(){
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

w150 = ptr + 0;
w151 = stack[w150];

w152 = w151 + 0;
w153 = heap[w152];

w154 = ptr + 2;
stack[w154] = w153;

w155 = 0;

w156 = ptr + 3;
stack[w156] = w155;

w160 = 0;

w161 = ptr + 3;
stack[w161] = w160;


label_Loop157:{}
w162 = ptr + 3;
w163 = stack[w162];

w164 = ptr + 0;
w165 = stack[w164];

w166 = w165 + 2;
w167 = heap[w166];

if(w163<w167)goto label_ins159;
goto salida158;
label_ins159:{}
cout<<"contenido: ";
w168 = ptr + 2;
w169 = stack[w168];

w170 = ptr + 4;

w171 = w170 + 0;
stack[w171] = w169;

ptr = ptr + 4;
java_Nodo_getContenido();
ptr = ptr - 4;

//retorno
w172 = ptr + 4;

w173 = w172 + 1;
w174 = stack[w173];


//retorno
cout<<w174;
cout<<endl;
w175 = ptr + 2;
w176 = stack[w175];

w177 = ptr + 4;

w178 = w177 + 0;
stack[w178] = w176;

ptr = ptr + 4;
java_Nodo_getSiguiente();
ptr = ptr - 4;

//retorno
w179 = ptr + 4;

w180 = w179 + 1;
w181 = stack[w180];


//retorno
w182 = w181;

w183 = ptr + 2;
stack[w183] = w182;


w184 = ptr + 3;
w185 = stack[w184];

w186 = 1;

w187 = w185+w186;
w188 = w187;

w189 = ptr + 3;
stack[w189] = w188;


goto label_Loop157;
salida158:{}
retorno149:
    cout<< " ";
}

void java_ListaE_ListaE(){
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

w191 = h;
h = w191 + 4;

w192 = ptr + 0;
stack[w192] = w191;

w193 = ptr + 0;
w194 = stack[w193];

w195 = w194 + 0;
heap[w195] =  -1;


w196 = ptr + 0;
w197 = stack[w196];

w198 = w197 + 1;
heap[w198] =  -1;


w199 = ptr + 0;
w200 = stack[w199];

w201 = w200 + 2;
heap[w201] = 0;


w202 = ptr + 0;
w203 = stack[w202];

w204 = w203 + 3;
heap[w204] = 0;


retorno190:
    cout<< "";
}

void java_sumar_iniciar(){
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

w206 = ptr + 3;

ptr = ptr + 3;
java_ListaE_ListaE();
ptr = ptr - 3;
w207 = ptr + 3;

w208 = w207 + 0;
w209 = stack[w208];

w210 = ptr + 0;
w211 = stack[w210];

w212 = w211 + 2;
heap[w212] = w209;


w213 = ptr + 0;
w214 = stack[w213];

w215 = w214 + 2;
w216 = heap[w215];

w217 = ptr + 3;

w218 = w217 + 0;
stack[w218] = w216;

w219 = w217 + 2;
stack[w219] = 71;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w220 = ptr + 0;
w221 = stack[w220];

w222 = w221 + 2;
w223 = heap[w222];

w224 = ptr + 3;

w225 = w224 + 0;
stack[w225] = w223;

w226 = w224 + 2;
stack[w226] = 72;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w227 = ptr + 0;
w228 = stack[w227];

w229 = w228 + 2;
w230 = heap[w229];

w231 = ptr + 3;

w232 = w231 + 0;
stack[w232] = w230;

w233 = w231 + 2;
stack[w233] = 73;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w234 = ptr + 0;
w235 = stack[w234];

w236 = w235 + 2;
w237 = heap[w236];

w238 = ptr + 3;

w239 = w238 + 0;
stack[w239] = w237;

w240 = w238 + 2;
stack[w240] = 74;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w241 = ptr + 0;
w242 = stack[w241];

w243 = w242 + 2;
w244 = heap[w243];

w245 = ptr + 3;

w246 = w245 + 0;
stack[w246] = w244;

w247 = w245 + 2;
stack[w247] = 75;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w248 = ptr + 0;
w249 = stack[w248];

w250 = w249 + 2;
w251 = heap[w250];

w252 = ptr + 3;

w253 = w252 + 0;
stack[w253] = w251;

w254 = w252 + 2;
stack[w254] = 76;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w255 = ptr + 0;
w256 = stack[w255];

w257 = w256 + 2;
w258 = heap[w257];

w259 = ptr + 3;

w260 = w259 + 0;
stack[w260] = w258;

w261 = w259 + 2;
stack[w261] = 77;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w262 = ptr + 0;
w263 = stack[w262];

w264 = w263 + 2;
w265 = heap[w264];

w266 = ptr + 3;

w267 = w266 + 0;
stack[w267] = w265;

w268 = w266 + 2;
stack[w268] = 78;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w269 = ptr + 0;
w270 = stack[w269];

w271 = w270 + 2;
w272 = heap[w271];

w273 = ptr + 3;

w274 = w273 + 0;
stack[w274] = w272;

w275 = w273 + 2;
stack[w275] = 79;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w276 = ptr + 0;
w277 = stack[w276];

w278 = w277 + 2;
w279 = heap[w278];

w280 = ptr + 3;

w281 = w280 + 0;
stack[w281] = w279;

ptr = ptr + 3;
java_ListaE_imprimirLista();
ptr = ptr - 3;
cout<<"lista: ";
w282 = ptr + 0;
w283 = stack[w282];

w284 = w283 + 2;
w285 = heap[w284];

w286 = ptr + 3;

w287 = w286 + 0;
stack[w287] = w285;

ptr = ptr + 3;
java_ListaE_getSize();
ptr = ptr - 3;

//retorno
w288 = ptr + 3;

w289 = w288 + 1;
w290 = stack[w289];


//retorno
cout<<w290;
cout<<endl;
w291 = ptr + 0;
w292 = stack[w291];

w293 = w292 + 2;
w294 = heap[w293];

w295 = ptr + 3;

w296 = w295 + 0;
stack[w296] = w294;

w297 = w295 + 3;
stack[w297] = 5;

ptr = ptr + 3;
java_ListaE_obtenerNodo();
ptr = ptr - 3;

//retorno
w298 = ptr + 3;

w299 = w298 + 1;
w300 = stack[w299];


//retorno
w301 = ptr + 2;
stack[w301] = w300;

cout<<"obteniendo contenido de un nodo: ";
w302 = ptr + 2;
w303 = stack[w302];

w304 = ptr + 3;

w305 = w304 + 0;
stack[w305] = w303;

ptr = ptr + 3;
java_Nodo_getContenido();
ptr = ptr - 3;

//retorno
w306 = ptr + 3;

w307 = w306 + 1;
w308 = stack[w307];


//retorno
cout<<w308;
cout<<endl;
retorno205:
    cout<< " ";
}

void java_sumar_sumar(){
int w309;
int w310;
int w311;
int w312;
int w313;
int w314;

w310 = h;
h = w310 + 3;

w311 = ptr + 0;
stack[w311] = w310;

w312 = ptr + 0;
w313 = stack[w312];

w314 = w313 + 2;
heap[w314] =  -1;


retorno309:
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

