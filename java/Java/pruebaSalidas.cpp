#include <iostream>

using namespace std;

int stack[100];
int heap[100];
int ptr = 0;
int h = 0;



void java_sumar_sumar(){
int w0 = h;
h = w0 + 9;

int w1 = ptr + 0;
stack[w1] = w0;

int w2 = ptr + 0;
int w3 = stack[w2];

int w4 = w3 + 0;
heap[w4] = 0;

int w5 = ptr + 0;
int w6 = stack[w5];

int w7 = w6 + 1;
heap[w7] = 0;

int w8 = ptr + 0;
int w9 = stack[w8];

int w10 = w9 + 2;
heap[w10] = 0;

int w11 = ptr + 0;
int w12 = stack[w11];

int w13 = w12 + 3;
heap[w13] = 0;

int w14 = ptr + 0;
int w15 = stack[w14];

int w16 = w15 + 4;
heap[w16] = 0;

int w17 = ptr + 0;
int w18 = stack[w17];

int w19 = w18 + 5;
heap[w19] = 0;

int w20 = ptr + 0;
int w21 = stack[w20];

int w22 = w21 + 6;
heap[w22] = 0;

int w23 = ptr + 0;
int w24 = stack[w23];

int w25 = w24 + 7;
heap[w25] = 0;

int w26 = ptr + 0;
int w27 = stack[w26];

int w28 = w27 + 8;
heap[w28] = 0;

int w29 = ptr + 2;
int w30 = stack[w29];

int w31 = ptr + 0;
int w32 = stack[w31];

int w33 = w32 + 0;
heap[w33] = w30;


int w34 = ptr + 3;
int w35 = stack[w34];

int w36 = ptr + 0;
int w37 = stack[w36];

int w38 = w37 + 1;
heap[w38] = w35;


int w39 = ptr + 4;
int w40 = stack[w39];

int w41 = ptr + 0;
int w42 = stack[w41];

int w43 = w42 + 2;
heap[w43] = w40;



}

void java_Simple_Simple(){
int w44 = h;
h = w44 + 2;

int w45 = ptr + 0;
stack[w45] = w44;

int w46 = ptr + 0;
int w47 = stack[w46];

int w48 = w47 + 0;
heap[w48] = 0;

int w49 = ptr + 0;
int w50 = stack[w49];

int w51 = w50 + 1;
heap[w51] = 0;

int w52 = ptr + 2;
int w53 = stack[w52];

int w54 = ptr + 0;
int w55 = stack[w54];

int w56 = w55 + 0;
heap[w56] = w53;


int w57 = ptr + 3;
int w58 = stack[w57];

int w59 = ptr + 0;
int w60 = stack[w59];

int w61 = w60 + 1;
heap[w61] = w58;



}

void java_Carta_Carta(){
int w110 = h;
h = w110 + 3;

int w111 = ptr + 0;
stack[w111] = w110;

int w112 = ptr + 0;
int w113 = stack[w112];

int w114 = w113 + 0;
heap[w114] = 0;

int w115 = ptr + 0;
int w116 = stack[w115];

int w117 = w116 + 1;
heap[w117] = 0;

int w118 = ptr + 0;
int w119 = stack[w118];

int w120 = w119 + 2;
heap[w120] = 0;

int w121 = ptr + 2;
int w122 = stack[w121];

int w123 = ptr + 0;
int w124 = stack[w123];

int w125 = w124 + 0;
heap[w125] = w122;


int w126 = ptr + 3;
int w127 = stack[w126];

int w128 = ptr + 0;
int w129 = stack[w128];

int w130 = w129 + 1;
heap[w130] = w127;


int w131 = ptr + 4;
int w132 = stack[w131];

int w133 = ptr + 0;
int w134 = stack[w133];

int w135 = w134 + 2;
heap[w135] = w132;



}

void java_Carta_printInfoCarta(){
cout<<"Color: ";
int w286 = ptr + 0;
int w287 = stack[w286];

int w288 = w287 + 0;
int w289 = heap[w288];

cout<<w289;
cout<<endl;
cout<<"Numero: ";
int w290 = ptr + 0;
int w291 = stack[w290];

int w292 = w291 + 1;
int w293 = heap[w292];

cout<<w293;
cout<<endl;
cout<<"#tipo: ";
int w294 = ptr + 0;
int w295 = stack[w294];

int w296 = w295 + 2;
int w297 = heap[w296];

cout<<w297;
cout<<endl;

}

void java_Simple_getNumber(){
int w340 = ptr + 0;
int w341 = stack[w340];

int w342 = w341 + 0;
int w343 = heap[w342];

int w344 = ptr + 1;
stack[w344] = w343;


}

void java_Simple_getCarne(){
int w354 = ptr + 0;
int w355 = stack[w354];

int w356 = w355 + 1;
int w357 = heap[w356];

int w358 = ptr + 1;
stack[w358] = w357;


}

void java_sumar_crearCartas(){
int w106 = ptr + 9;

int w107 = w106 + 2;
stack[w107] = 1;

int w108 = w106 + 3;
stack[w108] = 2;

int w109 = w106 + 4;
stack[w109] = 3;

ptr = ptr + 9;
java_Carta_Carta();
ptr = ptr - 9;
int w136 = ptr + 9;

int w137 = w136 + 0;
int w138 = stack[w137];

int w139 = ptr + 0;
int w140 = stack[w139];

int w141 = w140 + 4;
heap[w141] = w138;


int w142 = ptr + 9;

int w143 = w142 + 2;
stack[w143] = 4;

int w144 = w142 + 3;
stack[w144] = 5;

int w145 = w142 + 4;
stack[w145] = 6;

ptr = ptr + 9;
java_Carta_Carta();
ptr = ptr - 9;
int w172 = ptr + 9;

int w173 = w172 + 0;
int w174 = stack[w173];

int w175 = ptr + 0;
int w176 = stack[w175];

int w177 = w176 + 5;
heap[w177] = w174;


int w178 = ptr + 9;

int w179 = w178 + 2;
stack[w179] = 7;

int w180 = w178 + 3;
stack[w180] = 8;

int w181 = w178 + 4;
stack[w181] = 9;

ptr = ptr + 9;
java_Carta_Carta();
ptr = ptr - 9;
int w208 = ptr + 9;

int w209 = w208 + 0;
int w210 = stack[w209];

int w211 = ptr + 0;
int w212 = stack[w211];

int w213 = w212 + 6;
heap[w213] = w210;


int w214 = ptr + 0;
int w215 = stack[w214];

int w216 = w215 + 0;
int w217 = heap[w216];

int w218 = ptr + 0;
int w219 = stack[w218];

int w220 = w219 + 1;
int w221 = heap[w220];

int w222 = ptr + 9;

int w223 = w222 + 2;
stack[w223] = w217;

int w224 = w222 + 3;
stack[w224] = w221;

ptr = ptr + 9;
java_Simple_Simple();
ptr = ptr - 9;
int w243 = ptr + 9;

int w244 = w243 + 0;
int w245 = stack[w244];

int w246 = ptr + 0;
int w247 = stack[w246];

int w248 = w247 + 7;
heap[w248] = w245;


int w249 = ptr + 0;
int w250 = stack[w249];

int w251 = w250 + 1;
int w252 = heap[w251];

int w253 = ptr + 9;

int w254 = w253 + 2;
stack[w254] = 44;

int w255 = w253 + 3;
stack[w255] = w252;

ptr = ptr + 9;
java_Simple_Simple();
ptr = ptr - 9;
int w274 = ptr + 9;

int w275 = w274 + 0;
int w276 = stack[w275];

int w277 = ptr + 0;
int w278 = stack[w277];

int w279 = w278 + 8;
heap[w279] = w276;


cout<<">>>>>>>CARTA1";
cout<<endl;
int w280 = ptr + 0;
int w281 = stack[w280];

int w282 = w281 + 4;
int w283 = heap[w282];

int w284 = ptr + 9;

int w285 = w284 + 0;
stack[w285] = w283;

ptr = ptr + 9;
java_Carta_printInfoCarta();
ptr = ptr - 9;
cout<<">>>>>>>CARTA2";
cout<<endl;
int w298 = ptr + 0;
int w299 = stack[w298];

int w300 = w299 + 5;
int w301 = heap[w300];

int w302 = ptr + 9;

int w303 = w302 + 0;
stack[w303] = w301;

ptr = ptr + 9;
java_Carta_printInfoCarta();
ptr = ptr - 9;
cout<<">>>>>>>CARTA3";
cout<<endl;
int w316 = ptr + 0;
int w317 = stack[w316];

int w318 = w317 + 6;
int w319 = heap[w318];

int w320 = ptr + 9;

int w321 = w320 + 0;
stack[w321] = w319;

ptr = ptr + 9;
java_Carta_printInfoCarta();
ptr = ptr - 9;
cout<<"Simpleeeeeeeeeeeee";
cout<<endl;
cout<<"uno: ";
int w334 = ptr + 0;
int w335 = stack[w334];

int w336 = w335 + 7;
int w337 = heap[w336];

int w338 = ptr + 9;

int w339 = w338 + 0;
stack[w339] = w337;

ptr = ptr + 9;
java_Simple_getNumber();
ptr = ptr - 9;
int w345 = ptr + 9;

int w346 = w345 + 1;
int w347 = stack[w346];

cout<<w347;
cout<<endl;
cout<<"uno: ";
int w348 = ptr + 0;
int w349 = stack[w348];

int w350 = w349 + 7;
int w351 = heap[w350];

int w352 = ptr + 9;

int w353 = w352 + 0;
stack[w353] = w351;

ptr = ptr + 9;
java_Simple_getCarne();
ptr = ptr - 9;
int w359 = ptr + 9;

int w360 = w359 + 1;
int w361 = stack[w360];

cout<<w361;
cout<<endl;
cout<<"uno: ";
int w362 = ptr + 0;
int w363 = stack[w362];

int w364 = w363 + 8;
int w365 = heap[w364];

int w366 = ptr + 9;

int w367 = w366 + 0;
stack[w367] = w365;

ptr = ptr + 9;
java_Simple_getNumber();
ptr = ptr - 9;
int w373 = ptr + 9;

int w374 = w373 + 1;
int w375 = stack[w374];

cout<<w375;
cout<<endl;
cout<<"uno: ";
int w376 = ptr + 0;
int w377 = stack[w376];

int w378 = w377 + 8;
int w379 = heap[w378];

int w380 = ptr + 9;

int w381 = w380 + 0;
stack[w381] = w379;

ptr = ptr + 9;
java_Simple_getCarne();
ptr = ptr - 9;
int w387 = ptr + 9;

int w388 = w387 + 1;
int w389 = stack[w388];

cout<<w389;
cout<<endl;
cout<<"Simpleeeeeeeeeeeee";
cout<<endl;

}

int main(){
int w0 = ptr + 0;
stack[w0] = 12;

int w1 = ptr + 1;
stack[w1] = 6;

int w2 = ptr + 2;
stack[w2] = 9;

int w3 = ptr + 3;
stack[w3] = 88;

int w4 = ptr + 0;
int w5 = stack[w4];

int w6 = ptr + 1;
int w7 = stack[w6];

int w8 = ptr + 2;
int w9 = stack[w8];

int w10 = ptr + 7;

int w11 = w10 + 2;
stack[w11] = w5;

int w12 = w10 + 3;
stack[w12] = w7;

int w13 = w10 + 4;
stack[w13] = w9;

ptr = ptr + 7;
java_sumar_sumar();
ptr = ptr - 7;
int w14 = ptr + 7;

int w15 = w14 + 0;
int w16 = stack[w15];

int w17 = ptr + 4;
stack[w17] = w16;

int w18 = ptr + 7;

int w19 = w18 + 2;
stack[w19] = 4;

int w20 = w18 + 3;
stack[w20] = 3;

ptr = ptr + 7;
java_Simple_Simple();
ptr = ptr - 7;
int w21 = ptr + 7;

int w22 = w21 + 0;
int w23 = stack[w22];

int w24 = ptr + 5;
stack[w24] = w23;

int w25 = ptr + 0;
int w26 = stack[w25];

int w27 = ptr + 1;
int w28 = stack[w27];

int w29 = ptr + 2;
int w30 = stack[w29];

int w31 = ptr + 7;

int w32 = w31 + 2;
stack[w32] = w26;

int w33 = w31 + 3;
stack[w33] = w28;

int w34 = w31 + 4;
stack[w34] = w30;

ptr = ptr + 7;
java_sumar_sumar();
ptr = ptr - 7;
int w35 = ptr + 7;

int w36 = w35 + 0;
int w37 = stack[w36];

int w38 = ptr + 6;
stack[w38] = w37;

int w39 = ptr + 6;
int w40 = stack[w39];

int w41 = ptr + 7;

int w42 = w41 + 0;
stack[w42] = w40;

int w43 = ptr + 7;

ptr = ptr + 7;
java_sumar_crearCartas();
ptr = ptr - 7;
int w44 = ptr + 5;
int w45 = stack[w44];

int w46 = ptr + 7;

int w47 = w46 + 0;
stack[w47] = w45;

int w48 = ptr + 7;

ptr = ptr + 7;
java_Simple_getNumber();
ptr = ptr - 7;
int w49 = ptr + 7;

int w50 = w49 + 1;
int w51 = stack[w50];

int w52 = ptr + 3;
stack[w52] = w51;


int w53 = ptr + 3;
int w54 = stack[w53];

cout<<"algo: ";
cout<<w54;
cout<<endl;
}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

