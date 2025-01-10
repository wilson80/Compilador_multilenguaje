#include <iostream>

using namespace std;

int stack[1000];
int heap[1000];
int ptr = 0;
int h = 0;



void java_sumar_adicion(){
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

w37 = ptr + 3;
w38 = stack[w37];

w39 = ptr + 4;
w40 = stack[w39];

w41 = w38+w40;
w42 = ptr + 5;
w43 = stack[w42];

w44 = w41+w43;
w45 = ptr + 6;
w46 = stack[w45];

w47 = w44+w46;
w48 = ptr + 1;
stack[w48] = w47;

goto retorno36;
retorno36:
    cout<< "";
}

void java_sumar_restar(){
int w67;
int w68;
int w69;
int w70;
int w71;
int w72;
int w73;

w68 = ptr + 3;
w69 = stack[w68];

w70 = ptr + 4;
w71 = stack[w70];

w72 = w69-w71;
w73 = ptr + 1;
stack[w73] = w72;

goto retorno67;
retorno67:
    cout<< "";
}

void java_sumar_multiplicar(){
int w89;
int w90;
int w91;
int w92;
int w93;
int w94;
int w95;

w90 = ptr + 3;
w91 = stack[w90];

w92 = ptr + 4;
w93 = stack[w92];

w94 = w91*w93;
w95 = ptr + 1;
stack[w95] = w94;

goto retorno89;
retorno89:
    cout<< "";
}

void java_sumar_div(){
int w111;
int w112;
int w113;
int w114;
int w115;
int w116;
int w117;

w112 = ptr + 3;
w113 = stack[w112];

w114 = ptr + 4;
w115 = stack[w114];

w116 = w113/w115;
w117 = ptr + 1;
stack[w117] = w116;

goto retorno111;
retorno111:
    cout<< "";
}

void java_sumar_info(){
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

w14 = ptr + 2;
stack[w14] = 12;

w15 = ptr + 3;
stack[w15] = 4;

w16 = ptr + 0;
w17 = stack[w16];

w18 = w17 + 1;
w19 = heap[w18];

w20 = ptr + 2;
w21 = stack[w20];

w22 = ptr + 0;
w23 = stack[w22];

w24 = w23 + 2;
w25 = heap[w24];

w26 = ptr + 3;
w27 = stack[w26];

w28 = ptr + 5;

w29 = ptr + 0;
w30 = stack[w29];

w31 = w28 + 0;
stack[w31] = w30;

w32 = w28 + 3;
stack[w32] = w19;

w33 = w28 + 4;
stack[w33] = w21;

w34 = w28 + 5;
stack[w34] = w25;

w35 = w28 + 6;
stack[w35] = w27;

ptr = ptr + 5;
java_sumar_adicion();
ptr = ptr - 5;

//retorno
w49 = ptr + 5;

w50 = w49 + 1;
w51 = stack[w50];


//retorno
w52 = ptr + 4;
stack[w52] = w51;

cout<<"sumar: ";
w53 = ptr + 4;
w54 = stack[w53];

cout<<w54;
cout<<endl;
cout<<"restar: ";
w55 = ptr + 2;
w56 = stack[w55];

w57 = ptr + 0;
w58 = stack[w57];

w59 = w58 + 2;
w60 = heap[w59];

w61 = ptr + 7;

w62 = ptr + 0;
w63 = stack[w62];

w64 = w61 + 0;
stack[w64] = w63;

w65 = w61 + 3;
stack[w65] = w56;

w66 = w61 + 4;
stack[w66] = w60;

ptr = ptr + 7;
java_sumar_restar();
ptr = ptr - 7;

//retorno
w74 = ptr + 7;

w75 = w74 + 1;
w76 = stack[w75];


//retorno
cout<<w76;
cout<<endl;
cout<<"multi: ";
w77 = ptr + 2;
w78 = stack[w77];

w79 = ptr + 0;
w80 = stack[w79];

w81 = w80 + 2;
w82 = heap[w81];

w83 = ptr + 5;

w84 = ptr + 0;
w85 = stack[w84];

w86 = w83 + 0;
stack[w86] = w85;

w87 = w83 + 3;
stack[w87] = w78;

w88 = w83 + 4;
stack[w88] = w82;

ptr = ptr + 5;
java_sumar_multiplicar();
ptr = ptr - 5;

//retorno
w96 = ptr + 5;

w97 = w96 + 1;
w98 = stack[w97];


//retorno
cout<<w98;
cout<<endl;
cout<<"div: ";
w99 = ptr + 2;
w100 = stack[w99];

w101 = ptr + 0;
w102 = stack[w101];

w103 = w102 + 2;
w104 = heap[w103];

w105 = ptr + 5;

w106 = ptr + 0;
w107 = stack[w106];

w108 = w105 + 0;
stack[w108] = w107;

w109 = w105 + 3;
stack[w109] = w100;

w110 = w105 + 4;
stack[w110] = w104;

ptr = ptr + 5;
java_sumar_div();
ptr = ptr - 5;

//retorno
w118 = ptr + 5;

w119 = w118 + 1;
w120 = stack[w119];


//retorno
cout<<w120;
cout<<endl;
cout<<"varL: ";
w121 = ptr + 2;
w122 = stack[w121];

cout<<w122;
cout<<endl;
cout<<"varl2: ";
w123 = ptr + 3;
w124 = stack[w123];

cout<<w124;
cout<<endl;
cout<<"att atri: ";
w125 = ptr + 0;
w126 = stack[w125];

w127 = w126 + 1;
w128 = heap[w127];

cout<<w128;
cout<<endl;
cout<<"att uno: ";
w129 = ptr + 0;
w130 = stack[w129];

w131 = w130 + 2;
w132 = heap[w131];

cout<<w132;
cout<<endl;
cout<<"total: ";
w133 = ptr + 4;
w134 = stack[w133];

cout<<w134;
cout<<endl;
retorno13:
    cout<< " ";
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

w1 = h;
h = w1 + 3;

w2 = ptr + 0;
stack[w2] = w1;

w3 = ptr + 0;
w4 = stack[w3];

w5 = w4 + 1;
heap[w5] = 6;


w6 = ptr + 0;
w7 = stack[w6];

w8 = w7 + 2;
heap[w8] = 3;


w9 = ptr + 2;

w10 = ptr + 0;
w11 = stack[w10];

w12 = w9 + 0;
stack[w12] = w11;

ptr = ptr + 2;
java_sumar_info();
ptr = ptr - 2;
retorno0:
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

