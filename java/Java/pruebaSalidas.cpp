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

w43 = ptr + 3;
w44 = stack[w43];

w45 = ptr + 4;
w46 = stack[w45];

w47 = w44+w46;
w48 = ptr + 5;
w49 = stack[w48];

w50 = w47+w49;
w51 = ptr + 6;
w52 = stack[w51];

w53 = w50+w52;
w54 = ptr + 1;
stack[w54] = w53;


}

void java_sumar_restar(){
int w73;
int w74;
int w75;
int w76;
int w77;
int w78;

w73 = ptr + 3;
w74 = stack[w73];

w75 = ptr + 4;
w76 = stack[w75];

w77 = w74-w76;
w78 = ptr + 1;
stack[w78] = w77;


}

void java_sumar_multiplicar(){
int w94;
int w95;
int w96;
int w97;
int w98;
int w99;

w94 = ptr + 3;
w95 = stack[w94];

w96 = ptr + 4;
w97 = stack[w96];

w98 = w95*w97;
w99 = ptr + 1;
stack[w99] = w98;


}

void java_sumar_div(){
int w115;
int w116;
int w117;
int w118;
int w119;
int w120;

w115 = ptr + 3;
w116 = stack[w115];

w117 = ptr + 4;
w118 = stack[w117];

w119 = w116/w118;
w120 = ptr + 1;
stack[w120] = w119;


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

w21 = ptr + 3;
stack[w21] = 2;

w22 = ptr + 4;
stack[w22] = 4;

w23 = ptr + 0;
w24 = stack[w23];

w25 = w24 + 1;
w26 = heap[w25];

w27 = ptr + 3;
w28 = stack[w27];

w29 = ptr + 0;
w30 = stack[w29];

w31 = w30 + 2;
w32 = heap[w31];

w33 = ptr + 4;
w34 = stack[w33];

w35 = ptr + 3;

w36 = ptr + 0;
w37 = stack[w36];

w38 = w35 + 0;
stack[w38] = w37;

w39 = w35 + 3;
stack[w39] = w34;

w40 = w35 + 4;
stack[w40] = w28;

w41 = w35 + 5;
stack[w41] = w26;

w42 = w35 + 6;
stack[w42] = w32;

ptr = ptr + 3;
java_sumar_adicion();
ptr = ptr - 3;
w55 = ptr + 3;

w56 = w55 + 1;
w57 = stack[w56];

w58 = ptr + 5;
stack[w58] = w57;

cout<<"sumar: ";
w59 = ptr + 5;
w60 = stack[w59];

cout<<w60;
cout<<endl;
cout<<"restar: ";
w61 = ptr + 3;
w62 = stack[w61];

w63 = ptr + 0;
w64 = stack[w63];

w65 = w64 + 2;
w66 = heap[w65];

w67 = ptr + 3;

w68 = ptr + 0;
w69 = stack[w68];

w70 = w67 + 0;
stack[w70] = w69;

w71 = w67 + 3;
stack[w71] = w62;

w72 = w67 + 4;
stack[w72] = w66;

ptr = ptr + 3;
java_sumar_restar();
ptr = ptr - 3;
w79 = ptr + 3;

w80 = w79 + 1;
w81 = stack[w80];

cout<<w81;
cout<<endl;
cout<<"multi: ";
w82 = ptr + 3;
w83 = stack[w82];

w84 = ptr + 0;
w85 = stack[w84];

w86 = w85 + 2;
w87 = heap[w86];

w88 = ptr + 3;

w89 = ptr + 0;
w90 = stack[w89];

w91 = w88 + 0;
stack[w91] = w90;

w92 = w88 + 3;
stack[w92] = w83;

w93 = w88 + 4;
stack[w93] = w87;

ptr = ptr + 3;
java_sumar_multiplicar();
ptr = ptr - 3;
w100 = ptr + 3;

w101 = w100 + 1;
w102 = stack[w101];

cout<<w102;
cout<<endl;
cout<<"div: ";
w103 = ptr + 3;
w104 = stack[w103];

w105 = ptr + 0;
w106 = stack[w105];

w107 = w106 + 2;
w108 = heap[w107];

w109 = ptr + 3;

w110 = ptr + 0;
w111 = stack[w110];

w112 = w109 + 0;
stack[w112] = w111;

w113 = w109 + 3;
stack[w113] = w104;

w114 = w109 + 4;
stack[w114] = w108;

ptr = ptr + 3;
java_sumar_div();
ptr = ptr - 3;
w121 = ptr + 3;

w122 = w121 + 1;
w123 = stack[w122];

cout<<w123;
cout<<endl;
cout<<"varL: ";
w124 = ptr + 3;
w125 = stack[w124];

cout<<w125;
cout<<endl;
cout<<"varl2: ";
w126 = ptr + 4;
w127 = stack[w126];

cout<<w127;
cout<<endl;
cout<<"att atri: ";
w128 = ptr + 0;
w129 = stack[w128];

w130 = w129 + 1;
w131 = heap[w130];

cout<<w131;
cout<<endl;
cout<<"att uno: ";
w132 = ptr + 0;
w133 = stack[w132];

w134 = w133 + 2;
w135 = heap[w134];

cout<<w135;
cout<<endl;
cout<<"total: ";
w136 = ptr + 5;
w137 = stack[w136];

cout<<w137;
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


w17 = ptr + 3;

w18 = ptr + 0;
w19 = stack[w18];

w20 = w17 + 0;
stack[w20] = w19;

ptr = ptr + 3;
java_sumar_info();
ptr = ptr - 3;

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

