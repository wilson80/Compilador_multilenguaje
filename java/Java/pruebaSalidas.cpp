#include <iostream>

using namespace std;

int stack[100];
int heap[100];
int ptr = 0;
int h = 0;



void java_sumar_sumar(){

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
int w19;
int w20;
int w21;
int w22;
int w23;
int w24;
int w25;

w0 = h;
h = w0 + 3;

w1 = ptr + 0;
stack[w1] = w0;

w2 = ptr + 0;
w3 = stack[w2];

w4 = w3 + 0;
heap[w4] = 0;

w5 = ptr + 0;
w6 = stack[w5];

w7 = w6 + 1;
heap[w7] = 0;

w8 = ptr + 0;
w9 = stack[w8];

w10 = w9 + 2;
heap[w10] = 0;

w11 = ptr + 2;
w12 = stack[w11];

w13 = ptr + 0;
w14 = stack[w13];

w15 = w14 + 0;
heap[w15] = w12;


w16 = ptr + 3;
w17 = stack[w16];

w18 = ptr + 0;
w19 = stack[w18];

w20 = w19 + 1;
heap[w20] = w17;


w21 = ptr + 4;
w22 = stack[w21];

w23 = ptr + 0;
w24 = stack[w23];

w25 = w24 + 2;
heap[w25] = w22;



}

void java_sumar_calcularFactorial(){
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

w39 = ptr + 3;
w40 = stack[w39];

w41 = ptr + 3;
w42 = stack[w41];

if(w40==0)goto if35;
goto cmpOp243;
cmpOp243:
if(w42==1)goto if35;
goto salida36;
if35:{
w44 = ptr + 1;
stack[w44] = 1;

goto retorno34;
}
goto salida36;
salida36:
w45 = ptr + 3;
w46 = stack[w45];

w47 = ptr + 3;
w48 = stack[w47];

w49 = 1;

w50 = w48-w49;
w51 = ptr + 4;

w52 = ptr + 0;
w53 = stack[w52];

w54 = w51 + 0;
stack[w54] = w53;

w55 = w51 + 3;
stack[w55] = w50;

ptr = ptr + 4;
java_sumar_calcularFactorial();
ptr = ptr - 4;

//retorno
w56 = ptr + 4;

w57 = w56 + 1;
w58 = stack[w57];


//retorno
w59 = w46*w58;
w60 = ptr + 1;
stack[w60] = w59;

goto retorno34;
retorno34:

}

void java_sumar_calcularFibonacci(){
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

w81 = ptr + 3;
w82 = stack[w81];

if(w82==0)goto if77;
goto labelelif80;
if77:{
w83 = ptr + 1;
stack[w83] = 0;

goto retorno76;
}
goto salida78;
labelelif80:{
w86 = ptr + 3;
w87 = stack[w86];

if(w87==1)goto elif80;
goto else84;
}
elif80:{
w88 = ptr + 1;
stack[w88] = 1;

goto retorno76;
}
goto salida78;
else84:{
w89 = ptr + 3;
w90 = stack[w89];

w91 = 1;

w92 = w90-w91;
w93 = ptr + 4;

w94 = ptr + 0;
w95 = stack[w94];

w96 = w93 + 0;
stack[w96] = w95;

w97 = w93 + 3;
stack[w97] = w92;

ptr = ptr + 4;
java_sumar_calcularFibonacci();
ptr = ptr - 4;

//retorno
w98 = ptr + 4;

w99 = w98 + 1;
w100 = stack[w99];


//retorno
w101 = ptr + 3;
w102 = stack[w101];

w103 = 2;

w104 = w102-w103;
w105 = ptr + 4;

w106 = ptr + 0;
w107 = stack[w106];

w108 = w105 + 0;
stack[w108] = w107;

w109 = w105 + 3;
stack[w109] = w104;

ptr = ptr + 4;
java_sumar_calcularFibonacci();
ptr = ptr - 4;

//retorno
w110 = ptr + 4;

w111 = w110 + 1;
w112 = stack[w111];


//retorno
w113 = w100+w112;
w114 = ptr + 1;
stack[w114] = w113;

goto retorno76;
}
salida78:
retorno76:

}

void java_sumar_crearCartas(){
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

w26 = ptr + 2;
stack[w26] = 9;

w27 = ptr + 2;
w28 = stack[w27];

w29 = ptr + 4;

w30 = ptr + 0;
w31 = stack[w30];

w32 = w29 + 0;
stack[w32] = w31;

w33 = w29 + 3;
stack[w33] = w28;

ptr = ptr + 4;
java_sumar_calcularFactorial();
ptr = ptr - 4;

//retorno
w61 = ptr + 4;

w62 = w61 + 1;
w63 = stack[w62];


//retorno
w64 = ptr + 3;
stack[w64] = w63;

cout<<"El factorial de ";
w65 = ptr + 2;
w66 = stack[w65];

cout<<w66;
cout<<" es: ";
w67 = ptr + 3;
w68 = stack[w67];

cout<<w68;
cout<<endl;
w69 = ptr + 2;
w70 = stack[w69];

w71 = ptr + 4;

w72 = ptr + 0;
w73 = stack[w72];

w74 = w71 + 0;
stack[w74] = w73;

w75 = w71 + 3;
stack[w75] = w70;

ptr = ptr + 4;
java_sumar_calcularFibonacci();
ptr = ptr - 4;

//retorno
w115 = ptr + 4;

w116 = w115 + 1;
w117 = stack[w116];


//retorno
w118 = w117;

w119 = ptr + 3;
stack[w119] = w118;


cout<<"El número Fibonacci en la posición ";
w120 = ptr + 2;
w121 = stack[w120];

cout<<w121;
cout<<" es: ";
w122 = ptr + 3;
w123 = stack[w122];

cout<<w123;
cout<<endl;

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
int w19;
int w20;
int w21;
int w22;

w0 = ptr + 0;
stack[w0] = 12;

w1 = ptr + 1;
stack[w1] = 6;

w2 = ptr + 2;
stack[w2] = 9;

w3 = ptr + 3;
stack[w3] = 88;

w4 = ptr + 0;
w5 = stack[w4];

w6 = ptr + 1;
w7 = stack[w6];

w8 = ptr + 2;
w9 = stack[w8];

w10 = ptr + 5;

w11 = w10 + 2;
stack[w11] = w5;

w12 = w10 + 3;
stack[w12] = w7;

w13 = w10 + 4;
stack[w13] = w9;

ptr = ptr + 5;
java_sumar_sumar();
ptr = ptr - 5;
w14 = ptr + 5;

w15 = w14 + 0;
w16 = stack[w15];

w17 = ptr + 4;
stack[w17] = w16;

w18 = ptr + 4;
w19 = stack[w18];

w20 = ptr + 5;

w21 = w20 + 0;
stack[w21] = w19;

w22 = ptr + 5;

ptr = ptr + 5;
java_sumar_crearCartas();
ptr = ptr - 5;

}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

