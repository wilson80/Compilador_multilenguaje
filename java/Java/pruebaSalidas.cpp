#include <iostream>

using namespace std;

int stack[100];
int heap[100];
int ptr = 0;
int h = 0;



void java_sumar_adicion(){
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

w44 = ptr + 3;
w45 = stack[w44];

w46 = ptr + 4;
w47 = stack[w46];

w48 = w45+w47;
w49 = ptr + 5;
w50 = stack[w49];

w51 = w48+w50;
w52 = ptr + 6;
w53 = stack[w52];

w54 = w51+w53;
w55 = ptr + 1;
stack[w55] = w54;

goto retorno43;
retorno43:

}

void java_sumar_restar(){
int w74;
int w75;
int w76;
int w77;
int w78;
int w79;
int w80;

w75 = ptr + 3;
w76 = stack[w75];

w77 = ptr + 4;
w78 = stack[w77];

w79 = w76-w78;
w80 = ptr + 1;
stack[w80] = w79;

goto retorno74;
retorno74:

}

void java_sumar_multiplicar(){
int w96;
int w97;
int w98;
int w99;
int w100;
int w101;
int w102;

w97 = ptr + 3;
w98 = stack[w97];

w99 = ptr + 4;
w100 = stack[w99];

w101 = w98*w100;
w102 = ptr + 1;
stack[w102] = w101;

goto retorno96;
retorno96:

}

void java_sumar_div(){
int w118;
int w119;
int w120;
int w121;
int w122;
int w123;
int w124;

w119 = ptr + 3;
w120 = stack[w119];

w121 = ptr + 4;
w122 = stack[w121];

w123 = w120/w122;
w124 = ptr + 1;
stack[w124] = w123;

goto retorno118;
retorno118:

}

void java_sumar_info(){
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

w21 = ptr + 2;
stack[w21] = 12;

w22 = ptr + 3;
stack[w22] = 4;

w23 = ptr + 0;
w24 = stack[w23];

w25 = w24 + 1;
w26 = heap[w25];

w27 = ptr + 2;
w28 = stack[w27];

w29 = ptr + 0;
w30 = stack[w29];

w31 = w30 + 2;
w32 = heap[w31];

w33 = ptr + 3;
w34 = stack[w33];

w35 = ptr + 7;

w36 = ptr + 0;
w37 = stack[w36];

w38 = w35 + 0;
stack[w38] = w37;

w39 = w35 + 3;
stack[w39] = w26;

w40 = w35 + 4;
stack[w40] = w28;

w41 = w35 + 5;
stack[w41] = w32;

w42 = w35 + 6;
stack[w42] = w34;

ptr = ptr + 7;
java_sumar_adicion();
ptr = ptr - 7;

//retorno
w56 = ptr + 7;

w57 = w56 + 1;
w58 = stack[w57];


//retorno
w59 = ptr + 4;
stack[w59] = w58;

cout<<"sumar: ";
w60 = ptr + 4;
w61 = stack[w60];

cout<<w61;
cout<<endl;
cout<<"restar: ";
w62 = ptr + 2;
w63 = stack[w62];

w64 = ptr + 0;
w65 = stack[w64];

w66 = w65 + 2;
w67 = heap[w66];

w68 = ptr + 5;

w69 = ptr + 0;
w70 = stack[w69];

w71 = w68 + 0;
stack[w71] = w70;

w72 = w68 + 3;
stack[w72] = w63;

w73 = w68 + 4;
stack[w73] = w67;

ptr = ptr + 5;
java_sumar_restar();
ptr = ptr - 5;

//retorno
w81 = ptr + 5;

w82 = w81 + 1;
w83 = stack[w82];


//retorno
cout<<w83;
cout<<endl;
cout<<"multi: ";
w84 = ptr + 2;
w85 = stack[w84];

w86 = ptr + 0;
w87 = stack[w86];

w88 = w87 + 2;
w89 = heap[w88];

w90 = ptr + 5;

w91 = ptr + 0;
w92 = stack[w91];

w93 = w90 + 0;
stack[w93] = w92;

w94 = w90 + 3;
stack[w94] = w85;

w95 = w90 + 4;
stack[w95] = w89;

ptr = ptr + 5;
java_sumar_multiplicar();
ptr = ptr - 5;

//retorno
w103 = ptr + 5;

w104 = w103 + 1;
w105 = stack[w104];


//retorno
cout<<w105;
cout<<endl;
cout<<"div: ";
w106 = ptr + 2;
w107 = stack[w106];

w108 = ptr + 0;
w109 = stack[w108];

w110 = w109 + 2;
w111 = heap[w110];

w112 = ptr + 5;

w113 = ptr + 0;
w114 = stack[w113];

w115 = w112 + 0;
stack[w115] = w114;

w116 = w112 + 3;
stack[w116] = w107;

w117 = w112 + 4;
stack[w117] = w111;

ptr = ptr + 5;
java_sumar_div();
ptr = ptr - 5;

//retorno
w125 = ptr + 5;

w126 = w125 + 1;
w127 = stack[w126];


//retorno
cout<<w127;
cout<<endl;
cout<<"varL: ";
w128 = ptr + 2;
w129 = stack[w128];

cout<<w129;
cout<<endl;
cout<<"varl2: ";
w130 = ptr + 3;
w131 = stack[w130];

cout<<w131;
cout<<endl;
cout<<"att atri: ";
w132 = ptr + 0;
w133 = stack[w132];

w134 = w133 + 1;
w135 = heap[w134];

cout<<w135;
cout<<endl;
cout<<"att uno: ";
w136 = ptr + 0;
w137 = stack[w136];

w138 = w137 + 2;
w139 = heap[w138];

cout<<w139;
cout<<endl;
cout<<"total: ";
w140 = ptr + 4;
w141 = stack[w140];

cout<<w141;
cout<<endl;

}

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

w11 = ptr + 0;
w12 = stack[w11];

w13 = w12 + 1;
heap[w13] = 6;


w14 = ptr + 0;
w15 = stack[w14];

w16 = w15 + 2;
heap[w16] = 3;


w17 = ptr + 5;

w18 = ptr + 0;
w19 = stack[w18];

w20 = w17 + 0;
stack[w20] = w19;

ptr = ptr + 5;
java_sumar_info();
ptr = ptr - 5;

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


}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

