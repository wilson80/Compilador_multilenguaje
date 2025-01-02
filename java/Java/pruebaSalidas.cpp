#include <iostream>

using namespace std;

int stack[100];
int heap[100];
int ptr = 0;
int h = 0;



void java_sumar_sumar(){
int w0 = h;
h = w0 + 7;

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

int w23 = ptr + 2;
int w24 = stack[w23];

int w25 = ptr + 0;
int w26 = stack[w25];

int w27 = w26 + 0;
heap[w27] = w24;


int w28 = ptr + 3;
int w29 = stack[w28];

int w30 = ptr + 0;
int w31 = stack[w30];

int w32 = w31 + 1;
heap[w32] = w29;


int w33 = ptr + 4;
int w34 = stack[w33];

int w35 = ptr + 0;
int w36 = stack[w35];

int w37 = w36 + 2;
heap[w37] = w34;



}

void java_Carta_Carta(){
int w42 = h;
h = w42 + 3;

int w43 = ptr + 0;
stack[w43] = w42;

int w44 = ptr + 0;
int w45 = stack[w44];

int w46 = w45 + 0;
heap[w46] = 0;

int w47 = ptr + 0;
int w48 = stack[w47];

int w49 = w48 + 1;
heap[w49] = 0;

int w50 = ptr + 0;
int w51 = stack[w50];

int w52 = w51 + 2;
heap[w52] = 0;

int w53 = ptr + 2;
int w54 = stack[w53];

int w55 = ptr + 0;
int w56 = stack[w55];

int w57 = w56 + 0;
heap[w57] = w54;


int w58 = ptr + 3;
int w59 = stack[w58];

int w60 = ptr + 0;
int w61 = stack[w60];

int w62 = w61 + 1;
heap[w62] = w59;


int w63 = ptr + 4;
int w64 = stack[w63];

int w65 = ptr + 0;
int w66 = stack[w65];

int w67 = w66 + 2;
heap[w67] = w64;



}

void java_Carta_printInfoCarta(){
cout<<"Color: ";
int w152 = ptr + 0;
int w153 = stack[w152];

int w154 = w153 + 0;
int w155 = heap[w154];

cout<<w155;
cout<<endl;
cout<<"Numero: ";
int w156 = ptr + 0;
int w157 = stack[w156];

int w158 = w157 + 1;
int w159 = heap[w158];

cout<<w159;
cout<<endl;
cout<<"#tipo: ";
int w160 = ptr + 0;
int w161 = stack[w160];

int w162 = w161 + 2;
int w163 = heap[w162];

cout<<w163;
cout<<endl;

}

void java_sumar_crearCartas(){
int w38 = ptr + 7;

int w39 = w38 + 2;
stack[w39] = 1;

int w40 = w38 + 3;
stack[w40] = 2;

int w41 = w38 + 4;
stack[w41] = 3;

ptr = ptr + 7;
java_Carta_Carta();
ptr = ptr - 7;
int w68 = ptr + 7;

int w69 = w68 + 0;
int w70 = stack[w69];

int w71 = ptr + 0;
int w72 = stack[w71];

int w73 = w72 + 4;
heap[w73] = w70;


int w74 = ptr + 7;

int w75 = w74 + 2;
stack[w75] = 4;

int w76 = w74 + 3;
stack[w76] = 5;

int w77 = w74 + 4;
stack[w77] = 6;

ptr = ptr + 7;
java_Carta_Carta();
ptr = ptr - 7;
int w104 = ptr + 7;

int w105 = w104 + 0;
int w106 = stack[w105];

int w107 = ptr + 0;
int w108 = stack[w107];

int w109 = w108 + 5;
heap[w109] = w106;


int w110 = ptr + 7;

int w111 = w110 + 2;
stack[w111] = 7;

int w112 = w110 + 3;
stack[w112] = 8;

int w113 = w110 + 4;
stack[w113] = 9;

ptr = ptr + 7;
java_Carta_Carta();
ptr = ptr - 7;
int w140 = ptr + 7;

int w141 = w140 + 0;
int w142 = stack[w141];

int w143 = ptr + 0;
int w144 = stack[w143];

int w145 = w144 + 6;
heap[w145] = w142;


cout<<">>>>>>>CARTA1";
cout<<endl;
int w146 = ptr + 0;
int w147 = stack[w146];

int w148 = w147 + 4;
int w149 = heap[w148];

int w150 = ptr + 7;

int w151 = w150 + 0;
stack[w151] = w149;

ptr = ptr + 7;
java_Carta_printInfoCarta();
ptr = ptr - 7;
cout<<">>>>>>>CARTA2";
cout<<endl;
int w164 = ptr + 0;
int w165 = stack[w164];

int w166 = w165 + 5;
int w167 = heap[w166];

int w168 = ptr + 7;

int w169 = w168 + 0;
stack[w169] = w167;

ptr = ptr + 7;
java_Carta_printInfoCarta();
ptr = ptr - 7;
cout<<">>>>>>>CARTA3";
cout<<endl;
int w182 = ptr + 0;
int w183 = stack[w182];

int w184 = w183 + 6;
int w185 = heap[w184];

int w186 = ptr + 7;

int w187 = w186 + 0;
stack[w187] = w185;

ptr = ptr + 7;
java_Carta_printInfoCarta();
ptr = ptr - 7;

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

int w10 = ptr + 5;

int w11 = w10 + 2;
stack[w11] = w5;

int w12 = w10 + 3;
stack[w12] = w7;

int w13 = w10 + 4;
stack[w13] = w9;

ptr = ptr + 5;
java_sumar_sumar();
ptr = ptr - 5;
int w14 = ptr + 5;

int w15 = w14 + 0;
int w16 = stack[w15];

int w17 = ptr + 4;
stack[w17] = w16;

int w18 = ptr + 4;
int w19 = stack[w18];

int w20 = ptr + 5;

int w21 = w20 + 0;
stack[w21] = w19;

int w22 = ptr + 5;

ptr = ptr + 5;
java_sumar_crearCartas();
ptr = ptr - 5;

}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

