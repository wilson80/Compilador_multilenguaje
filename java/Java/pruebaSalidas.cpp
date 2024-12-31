#include <iostream>

using namespace std;

int stack[100];
int heap[100];
int ptr = 0;
int h = 0;



void java_sumar_adicion(){
int w37 = ptr + 3;
int w38 = stack[w37];

int w39 = ptr + 4;
int w40 = stack[w39];

int w41 = w38+w40;
int w42 = ptr + 5;
int w43 = stack[w42];

int w44 = w41+w43;
int w45 = ptr + 6;
int w46 = stack[w45];

int w47 = w44+w46;
int w48 = ptr + 1;
stack[w48] = w47;


}

void java_sumar_restar(){
int w64 = ptr + 3;
int w65 = stack[w64];

int w66 = ptr + 4;
int w67 = stack[w66];

int w68 = w65-w67;
int w69 = ptr + 1;
stack[w69] = w68;


}

void java_sumar_multiplicar(){
int w82 = ptr + 3;
int w83 = stack[w82];

int w84 = ptr + 4;
int w85 = stack[w84];

int w86 = w83*w85;
int w87 = ptr + 1;
stack[w87] = w86;


}

void java_sumar_div(){
int w100 = ptr + 3;
int w101 = stack[w100];

int w102 = ptr + 4;
int w103 = stack[w102];

int w104 = w101/w103;
int w105 = ptr + 1;
stack[w105] = w104;


}

void java_sumar_info(){
int w18 = ptr + 3;
stack[w18] = 12;

int w19 = ptr + 4;
stack[w19] = 4;

int w20 = ptr + 0;
int w21 = stack[w20];

int w22 = w21 + 1;
int w23 = heap[w22];

int w24 = ptr + 3;
int w25 = stack[w24];

int w26 = ptr + 0;
int w27 = stack[w26];

int w28 = w27 + 2;
int w29 = heap[w28];

int w30 = ptr + 4;
int w31 = stack[w30];

int w32 = ptr + 3;

int w33 = w32 + 3;
stack[w33] = w31;

int w34 = w32 + 4;
stack[w34] = w25;

int w35 = w32 + 5;
stack[w35] = w23;

int w36 = w32 + 6;
stack[w36] = w29;

ptr = ptr + 3;
java_sumar_adicion();
ptr = ptr - 3;
int w49 = ptr + 3;

int w50 = w49 + 1;
int w51 = stack[w50];

int w52 = ptr + 5;
stack[w52] = w51;

cout<<"sumar: ";
int w53 = ptr + 5;
int w54 = stack[w53];

cout<<w54;
cout<<endl;
cout<<"restar: ";
int w55 = ptr + 3;
int w56 = stack[w55];

int w57 = ptr + 0;
int w58 = stack[w57];

int w59 = w58 + 2;
int w60 = heap[w59];

int w61 = ptr + 3;

int w62 = w61 + 3;
stack[w62] = w56;

int w63 = w61 + 4;
stack[w63] = w60;

ptr = ptr + 3;
java_sumar_restar();
ptr = ptr - 3;
int w70 = ptr + 3;

int w71 = w70 + 1;
int w72 = stack[w71];

cout<<w72;
cout<<endl;
cout<<"multi: ";
int w73 = ptr + 3;
int w74 = stack[w73];

int w75 = ptr + 0;
int w76 = stack[w75];

int w77 = w76 + 2;
int w78 = heap[w77];

int w79 = ptr + 3;

int w80 = w79 + 3;
stack[w80] = w74;

int w81 = w79 + 4;
stack[w81] = w78;

ptr = ptr + 3;
java_sumar_multiplicar();
ptr = ptr - 3;
int w88 = ptr + 3;

int w89 = w88 + 1;
int w90 = stack[w89];

cout<<w90;
cout<<endl;
cout<<"div: ";
int w91 = ptr + 3;
int w92 = stack[w91];

int w93 = ptr + 0;
int w94 = stack[w93];

int w95 = w94 + 2;
int w96 = heap[w95];

int w97 = ptr + 3;

int w98 = w97 + 3;
stack[w98] = w92;

int w99 = w97 + 4;
stack[w99] = w96;

ptr = ptr + 3;
java_sumar_div();
ptr = ptr - 3;
int w106 = ptr + 3;

int w107 = w106 + 1;
int w108 = stack[w107];

cout<<w108;
cout<<endl;
cout<<"total: ";
int w109 = ptr + 5;
int w110 = stack[w109];

cout<<w110;
cout<<endl;
cout<<"varL: ";
int w111 = ptr + 3;
int w112 = stack[w111];

cout<<w112;
cout<<endl;
cout<<"varl2: ";
int w113 = ptr + 4;
int w114 = stack[w113];

cout<<w114;
cout<<endl;
cout<<"att atri: ";
int w115 = ptr + 0;
int w116 = stack[w115];

int w117 = w116 + 1;
int w118 = heap[w117];

cout<<w118;
cout<<endl;
cout<<"att uno: ";
int w119 = ptr + 0;
int w120 = stack[w119];

int w121 = w120 + 2;
int w122 = heap[w121];

cout<<w122;
cout<<endl;
cout<<"asdfasdfasdf";
cout<<endl;

}

void java_sumar_sumar(){
int w0 = h;
h = w0 + 3;

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

int w13 = w12 + 1;
heap[w13] = 6;


int w14 = ptr + 0;
int w15 = stack[w14];

int w16 = w15 + 2;
heap[w16] = 3;


int w17 = ptr + 3;

ptr = ptr + 3;
java_sumar_info();
ptr = ptr - 3;

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

