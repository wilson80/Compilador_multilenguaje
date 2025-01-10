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

w25 = h;
h = w25 + 3;

w26 = ptr + 0;
stack[w26] = w25;

w27 = 0;

w28 = ptr + 2;
stack[w28] = w27;


w29 = ptr + 0;
w30 = stack[w29];

w31 = w30 + 1;
heap[w31] =  -1;


w32 = ptr + 0;
w33 = stack[w32];

w34 = w33 + 2;
heap[w34] =  -1;


w35 = ptr + 2;
w36 = stack[w35];

w37 = ptr + 0;
w38 = stack[w37];

w39 = w38 + 0;
heap[w39] = w36;


retorno24:
    cout<< "";
}

void java_ListaE_getSize(){
int w40;
int w41;
int w42;
int w43;
int w44;
int w45;

w41 = ptr + 0;
w42 = stack[w41];

w43 = w42 + 2;
w44 = heap[w43];

w45 = ptr + 1;
stack[w45] = w44;

goto retorno40;
retorno40:
    cout<< "";
}

void java_ListaE_getNum(){
int w46;
int w47;
int w48;
int w49;
int w50;
int w51;

w47 = ptr + 0;
w48 = stack[w47];

w49 = w48 + 3;
w50 = heap[w49];

w51 = ptr + 1;
stack[w51] = w50;

goto retorno46;
retorno46:
    cout<< "";
}

void java_ListaE_esVacia(){
int w52;
int w53;
int w54;
int w55;
int w56;
int w57;

w53 = ptr + 0;
w54 = stack[w53];

w55 = w54 + 0;
w56 = heap[w55];

w57 = ptr + 1;
stack[w57] = w56;

goto retorno52;
retorno52:
    cout<< "";
}

void java_ListaE_agregar(){
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

w59 = ptr + 2;
w60 = stack[w59];

w61 = ptr + 4;

w62 = w61 + 2;
stack[w62] =  -1;

ptr = ptr + 4;
java_Nodo_Nodo();
ptr = ptr - 4;
w63 = ptr + 4;

w64 = w63 + 0;
w65 = stack[w64];

w66 = ptr + 3;
stack[w66] = w60;

w71 = ptr + 0;
w72 = stack[w71];

w73 = w72 + 0;
w74 = heap[w73];

if(w74== -1)goto if67;
goto else69;
if67:
cout<<"agregando el primero";
cout<<endl;
w75 = ptr + 3;
w76 = stack[w75];

w77 = ptr + 0;
w78 = stack[w77];

w79 = w78 + 0;
heap[w79] = w76;


w80 = ptr + 3;
w81 = stack[w80];

w82 = ptr + 0;
w83 = stack[w82];

w84 = w83 + 1;
heap[w84] = w81;



goto salida68;
else69:
cout<<"agregando el otro";
cout<<endl;
w85 = ptr + 0;
w86 = stack[w85];

w87 = w86 + 1;
w88 = heap[w87];

w89 = ptr + 3;
w90 = stack[w89];

w91 = ptr + 4;

w92 = w91 + 0;
stack[w92] = w88;

w93 = w91 + 2;
stack[w93] = w90;

ptr = ptr + 4;
java_Nodo_setSiguiente();
ptr = ptr - 4;
w94 = ptr + 3;
w95 = stack[w94];

w96 = ptr + 0;
w97 = stack[w96];

w98 = w97 + 1;
w99 = heap[w98];

w100 = ptr + 4;

w101 = w100 + 0;
stack[w101] = w95;

w102 = w100 + 2;
stack[w102] = w99;

ptr = ptr + 4;
java_Nodo_setAnterior();
ptr = ptr - 4;
w103 = ptr + 3;
w104 = stack[w103];

w105 = ptr + 0;
w106 = stack[w105];

w107 = w106 + 1;
heap[w107] = w104;



salida68:
w108 = ptr + 0;
w109 = stack[w108];

w110 = w109 + 2;
w111 = heap[w110];

w112 = 1;

w113 = w111+w112;
w114 = ptr + 0;
w115 = stack[w114];

w116 = w115 + 2;
heap[w116] = w113;


retorno58:
    cout<< " ";
}

void java_ListaE_imprimirLista(){
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

w118 = ptr + 0;
w119 = stack[w118];

w120 = w119 + 0;
w121 = heap[w120];

w122 = ptr + 2;
stack[w122] = w121;

w123 = ptr + 0;
w124 = stack[w123];

w125 = w124 + 3;
heap[w125] = 0;

w129 = 0;

w130 = ptr + 3;
stack[w130] = w129;


label_Loop126:{}
w131 = ptr + 3;
w132 = stack[w131];

w133 = ptr + 0;
w134 = stack[w133];

w135 = w134 + 2;
w136 = heap[w135];

if(w132<w136)goto label_ins128;
goto salida127;
label_ins128:{}
cout<<"contenido: ";
w137 = ptr + 2;
w138 = stack[w137];

w139 = ptr + 4;

w140 = w139 + 0;
stack[w140] = w138;

ptr = ptr + 4;
java_Nodo_getContenido();
ptr = ptr - 4;

//retorno
w141 = ptr + 4;

w142 = w141 + 1;
w143 = stack[w142];


//retorno
cout<<w143;
cout<<endl;
w144 = ptr + 2;
w145 = stack[w144];

w146 = ptr + 4;

w147 = w146 + 0;
stack[w147] = w145;

ptr = ptr + 4;
java_Nodo_getSiguiente();
ptr = ptr - 4;

//retorno
w148 = ptr + 4;

w149 = w148 + 1;
w150 = stack[w149];


//retorno
w151 = w150;

w152 = ptr + 2;
stack[w152] = w151;


w153 = ptr + 3;
w154 = stack[w153];

w155 = 1;

w156 = w154+w155;
w157 = w156;

w158 = ptr + 3;
stack[w158] = w157;


goto label_Loop126;
salida127:{}
retorno117:
    cout<< " ";
}

void java_ListaE_ListaE(){
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

w160 = h;
h = w160 + 4;

w161 = ptr + 0;
stack[w161] = w160;

w162 = ptr + 0;
w163 = stack[w162];

w164 = w163 + 0;
heap[w164] =  -1;


w165 = ptr + 0;
w166 = stack[w165];

w167 = w166 + 1;
heap[w167] =  -1;


w168 = ptr + 0;
w169 = stack[w168];

w170 = w169 + 2;
heap[w170] = 0;


w171 = ptr + 0;
w172 = stack[w171];

w173 = w172 + 3;
heap[w173] = 0;


retorno159:
    cout<< "";
}

void java_sumar_iniciar(){
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

w175 = ptr + 3;

ptr = ptr + 3;
java_ListaE_ListaE();
ptr = ptr - 3;
w176 = ptr + 3;

w177 = w176 + 0;
w178 = stack[w177];

w179 = ptr + 0;
w180 = stack[w179];

w181 = w180 + 2;
heap[w181] = w178;


w182 = ptr + 0;
w183 = stack[w182];

w184 = w183 + 2;
w185 = heap[w184];

w186 = ptr + 2;

w187 = w186 + 0;
stack[w187] = w185;

w188 = w186 + 2;
stack[w188] = 71;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
w189 = ptr + 0;
w190 = stack[w189];

w191 = w190 + 2;
w192 = heap[w191];

w193 = ptr + 2;

w194 = w193 + 0;
stack[w194] = w192;

w195 = w193 + 2;
stack[w195] = 72;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
w196 = ptr + 0;
w197 = stack[w196];

w198 = w197 + 2;
w199 = heap[w198];

w200 = ptr + 2;

w201 = w200 + 0;
stack[w201] = w199;

w202 = w200 + 2;
stack[w202] = 73;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
w203 = ptr + 0;
w204 = stack[w203];

w205 = w204 + 2;
w206 = heap[w205];

w207 = ptr + 2;

w208 = w207 + 0;
stack[w208] = w206;

w209 = w207 + 2;
stack[w209] = 74;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
w210 = ptr + 0;
w211 = stack[w210];

w212 = w211 + 2;
w213 = heap[w212];

w214 = ptr + 2;

w215 = w214 + 0;
stack[w215] = w213;

w216 = w214 + 2;
stack[w216] = 75;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
w217 = ptr + 0;
w218 = stack[w217];

w219 = w218 + 2;
w220 = heap[w219];

w221 = ptr + 2;

w222 = w221 + 0;
stack[w222] = w220;

w223 = w221 + 2;
stack[w223] = 76;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
w224 = ptr + 0;
w225 = stack[w224];

w226 = w225 + 2;
w227 = heap[w226];

w228 = ptr + 2;

w229 = w228 + 0;
stack[w229] = w227;

w230 = w228 + 2;
stack[w230] = 77;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
w231 = ptr + 0;
w232 = stack[w231];

w233 = w232 + 2;
w234 = heap[w233];

w235 = ptr + 2;

w236 = w235 + 0;
stack[w236] = w234;

w237 = w235 + 2;
stack[w237] = 78;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
w238 = ptr + 0;
w239 = stack[w238];

w240 = w239 + 2;
w241 = heap[w240];

w242 = ptr + 2;

w243 = w242 + 0;
stack[w243] = w241;

w244 = w242 + 2;
stack[w244] = 79;

ptr = ptr + 2;
java_ListaE_agregar();
ptr = ptr - 2;
cout<<"lista: ";
w245 = ptr + 0;
w246 = stack[w245];

w247 = w246 + 2;
w248 = heap[w247];

w249 = ptr + 2;

w250 = w249 + 0;
stack[w250] = w248;

ptr = ptr + 2;
java_ListaE_getSize();
ptr = ptr - 2;

//retorno
w251 = ptr + 2;

w252 = w251 + 1;
w253 = stack[w252];


//retorno
cout<<w253;
cout<<endl;
w254 = ptr + 0;
w255 = stack[w254];

w256 = w255 + 2;
w257 = heap[w256];

w258 = ptr + 2;

w259 = w258 + 0;
stack[w259] = w257;

ptr = ptr + 2;
java_ListaE_imprimirLista();
ptr = ptr - 2;
retorno174:
    cout<< " ";
}

void java_sumar_sumar(){
int w260;
int w261;
int w262;
int w263;
int w264;
int w265;

w261 = h;
h = w261 + 3;

w262 = ptr + 0;
stack[w262] = w261;

w263 = ptr + 0;
w264 = stack[w263];

w265 = w264 + 2;
heap[w265] =  -1;


retorno260:
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

