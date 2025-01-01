#include <iostream>

using namespace std;

int stack[100];
int heap[100];
int ptr = 0;
int h = 0;



void java_Simple_Simple(){
int w6 = h;
h = w6 + 4;

int w7 = ptr + 0;
stack[w7] = w6;

int w8 = ptr + 0;
int w9 = stack[w8];

int w10 = w9 + 0;
heap[w10] = 0;

int w11 = ptr + 0;
int w12 = stack[w11];

int w13 = w12 + 1;
heap[w13] = 0;

int w14 = ptr + 0;
int w15 = stack[w14];

int w16 = w15 + 2;
heap[w16] = 0;

int w17 = ptr + 0;
int w18 = stack[w17];

int w19 = w18 + 3;
heap[w19] = 0;

int w20 = ptr + 0;
int w21 = stack[w20];

int w22 = w21 + 0;
heap[w22] = 4;


int w23 = ptr + 0;
int w24 = stack[w23];

int w25 = w24 + 1;
heap[w25] = 6;


int w26 = ptr + 0;
int w27 = stack[w26];

int w28 = w27 + 2;
heap[w28] = 9;


int w29 = ptr + 0;
int w30 = stack[w29];

int w31 = w30 + 3;
heap[w31] = 55;



}

void java_Simple_imprimirInfo(){
cout<<"unoo: ";
int w44 = ptr + 0;
int w45 = stack[w44];

int w46 = w45 + 0;
int w47 = heap[w46];

cout<<w47;
cout<<endl;
cout<<"doss: ";
int w48 = ptr + 0;
int w49 = stack[w48];

int w50 = w49 + 1;
int w51 = heap[w50];

cout<<w51;
cout<<endl;
cout<<"tresss: ";
int w52 = ptr + 0;
int w53 = stack[w52];

int w54 = w53 + 2;
int w55 = heap[w54];

cout<<w55;
cout<<endl;
cout<<"cuaa: ";
int w56 = ptr + 0;
int w57 = stack[w56];

int w58 = w57 + 3;
int w59 = heap[w58];

cout<<w59;
cout<<endl;

}

void java_Simple_setUno(){
int w67 = ptr + 2;
int w68 = stack[w67];

int w69 = ptr + 0;
int w70 = stack[w69];

int w71 = w70 + 0;
heap[w71] = w68;



}

void java_Simple_setDos(){
int w79 = ptr + 2;
int w80 = stack[w79];

int w81 = ptr + 0;
int w82 = stack[w81];

int w83 = w82 + 1;
heap[w83] = w80;



}

void java_Simple_getUno(){
int w112 = ptr + 0;
int w113 = stack[w112];

int w114 = w113 + 0;
int w115 = heap[w114];

int w116 = ptr + 1;
stack[w116] = w115;


}

void java_Simple_getDos(){
int w126 = ptr + 0;
int w127 = stack[w126];

int w128 = w127 + 1;
int w129 = heap[w128];

int w130 = ptr + 1;
stack[w130] = w129;


}

void java_Simple_getTres(){
int w140 = ptr + 0;
int w141 = stack[w140];

int w142 = w141 + 2;
int w143 = heap[w142];

int w144 = ptr + 1;
stack[w144] = w143;


}

void java_Simple_getCuatro(){
int w154 = ptr + 0;
int w155 = stack[w154];

int w156 = w155 + 3;
int w157 = heap[w156];

int w158 = ptr + 1;
stack[w158] = w157;


}

void java_sumar_sumar(){
int w0 = h;
h = w0 + 1;

int w1 = ptr + 0;
stack[w1] = w0;

int w2 = ptr + 0;
int w3 = stack[w2];

int w4 = w3 + 0;
heap[w4] = 0;

int w5 = ptr + 1;

ptr = ptr + 1;
java_Simple_Simple();
ptr = ptr - 1;
int w32 = ptr + 1;

int w33 = w32 + 0;
int w34 = stack[w33];

int w35 = ptr + 0;
int w36 = stack[w35];

int w37 = w36 + 0;
heap[w37] = w34;


cout<<"before del sett";
cout<<endl;
int w38 = ptr + 0;
int w39 = stack[w38];

int w40 = w39 + 0;
int w41 = heap[w40];

int w42 = ptr + 1;

int w43 = w42 + 0;
stack[w43] = w41;

ptr = ptr + 1;
java_Simple_imprimirInfo();
ptr = ptr - 1;
int w60 = ptr + 0;
int w61 = stack[w60];

int w62 = w61 + 0;
int w63 = heap[w62];

int w64 = ptr + 1;

int w65 = w64 + 0;
stack[w65] = w63;

int w66 = w64 + 2;
stack[w66] = 11;

ptr = ptr + 1;
java_Simple_setUno();
ptr = ptr - 1;
int w72 = ptr + 0;
int w73 = stack[w72];

int w74 = w73 + 0;
int w75 = heap[w74];

int w76 = ptr + 1;

int w77 = w76 + 0;
stack[w77] = w75;

int w78 = w76 + 2;
stack[w78] = 12;

ptr = ptr + 1;
java_Simple_setDos();
ptr = ptr - 1;
cout<<"after del sett";
cout<<endl;
int w84 = ptr + 0;
int w85 = stack[w84];

int w86 = w85 + 0;
int w87 = heap[w86];

int w88 = ptr + 1;

int w89 = w88 + 0;
stack[w89] = w87;

ptr = ptr + 1;
java_Simple_imprimirInfo();
ptr = ptr - 1;
cout<<"un get de uno: ";
int w106 = ptr + 0;
int w107 = stack[w106];

int w108 = w107 + 0;
int w109 = heap[w108];

int w110 = ptr + 1;

int w111 = w110 + 0;
stack[w111] = w109;

ptr = ptr + 1;
java_Simple_getUno();
ptr = ptr - 1;
int w117 = ptr + 1;

int w118 = w117 + 1;
int w119 = stack[w118];

cout<<w119;
cout<<endl;
cout<<"un get de dosss: ";
int w120 = ptr + 0;
int w121 = stack[w120];

int w122 = w121 + 0;
int w123 = heap[w122];

int w124 = ptr + 1;

int w125 = w124 + 0;
stack[w125] = w123;

ptr = ptr + 1;
java_Simple_getDos();
ptr = ptr - 1;
int w131 = ptr + 1;

int w132 = w131 + 1;
int w133 = stack[w132];

cout<<w133;
cout<<endl;
cout<<"un get de tres: ";
int w134 = ptr + 0;
int w135 = stack[w134];

int w136 = w135 + 0;
int w137 = heap[w136];

int w138 = ptr + 1;

int w139 = w138 + 0;
stack[w139] = w137;

ptr = ptr + 1;
java_Simple_getTres();
ptr = ptr - 1;
int w145 = ptr + 1;

int w146 = w145 + 1;
int w147 = stack[w146];

cout<<w147;
cout<<endl;
cout<<"un get de cuatro: ";
int w148 = ptr + 0;
int w149 = stack[w148];

int w150 = w149 + 0;
int w151 = heap[w150];

int w152 = ptr + 1;

int w153 = w152 + 0;
stack[w153] = w151;

ptr = ptr + 1;
java_Simple_getCuatro();
ptr = ptr - 1;
int w159 = ptr + 1;

int w160 = w159 + 1;
int w161 = stack[w160];

cout<<w161;
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

int w4 = ptr + 5;

ptr = ptr + 5;
java_sumar_sumar();
ptr = ptr - 5;
int w5 = ptr + 5;

int w6 = w5 + 0;
int w7 = stack[w6];

int w8 = ptr + 4;
stack[w8] = w7;


}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

