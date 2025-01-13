#include <iostream>

using namespace std;

int stack[1000];
int heap[1000];
int ptr = 0;
int h = 0;



void pasSUMARintint(){
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

cout<<"impresion desde pascal sumar";
w83 = ptr + 3;
w84 = stack[w83];

cout<<w84;
cout<<endl;
cout<<"impresion desde pascal sumar";
w85 = ptr + 4;
w86 = stack[w85];

cout<<w86;
cout<<endl;
w87 = ptr + 3;
w88 = stack[w87];

w89 = ptr + 4;
w90 = stack[w89];

w91 = w88+w90;
w92 = ptr + 5;
stack[w92] = w91;


w93 = ptr + 5;
w94 = stack[w93];

w95 = ptr + 1;
stack[w95] = w94;


retorno82:
    cout<< " ";
}

void pashellowintint(){
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

cout<<"Hello, World!";
cout<<endl;
cout<<"hos es /";
w97 = ptr + 2;
w98 = stack[w97];

cout<<w98;
cout<<"/";
w99 = ptr + 3;
w100 = stack[w99];

cout<<w100;
cout<<endl;
cout<<"uno + dos) por 3: ";
w101 = ptr + 4;
w102 = stack[w101];

w103 = ptr + 5;
w104 = stack[w103];

w105 = w102+w104;
w106 = 3;

w107 = w105*w106;
cout<<w107;
cout<<endl;
retorno96:
    cout<< " ";
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

w0 = ptr + 0;
stack[w0] = 10;

w1 = ptr + 1;
stack[w1] = 20;

w2 = ptr + 2;
stack[w2] = 30;

w3 = ptr + 3;
stack[w3] = 40;

w4 = ptr + 4;
stack[w4] = 50;

w5 = ptr + 5;
stack[w5] = 0;

w6 = ptr + 6;
stack[w6] = 50;

w7 = ptr + 7;
stack[w7] = 5;

w8 = ptr + 8;
stack[w8] = 10;

w9 = ptr + 9;
stack[w9] = 0;

w10 = ptr + 10;
stack[w10] = 0;



//invocacion a subP de pascal, id: hellow
w12 = ptr + 11;

w13 = w12 + 2;
stack[w13] = 12;

w14 = w12 + 3;
stack[w14] = 1;

ptr = ptr + 11;
pashellowintint();
ptr = ptr - 11;
cout<<"un for ";
cout<<endl;w18 = ptr + 9;
stack[w18] = 0;


label_Loop15:{}
w19 = ptr + 9;
w20 = stack[w19];

w21 = ptr + 6;
w22 = stack[w21];

if(w20<w22)goto label_ins17;
goto salida16;
label_ins17:{}
w23 = ptr + 9;
w24 = stack[w23];

cout<<"Número: ";
cout<<w24;
cout<<endl;w25 = ptr + 9;
w26 = stack[w25];

w27 = 1;

w28 = w26+w27;
w29 = ptr + 9;
stack[w29] = w28;


goto label_Loop15;
salida16:{}
w33 = ptr + 9;
stack[w33] = 10;


label_Loop30:{}
w34 = ptr + 9;
w35 = stack[w34];

if(w35>=0)goto label_ins32;
goto salida31;
label_ins32:{}
w36 = ptr + 9;
w37 = stack[w36];

cout<<"Cuenta regresiva: ";
cout<<w37;
cout<<endl;w38 = ptr + 9;
w39 = stack[w38];

w40 = 1;

w41 = w39-w40;
w42 = ptr + 9;
stack[w42] = w41;


goto label_Loop30;
salida31:{}
cout<<"otro for: ";
cout<<endl;w46 = ptr + 9;
stack[w46] = 1;


label_Loop43:{}
w47 = ptr + 9;
w48 = stack[w47];

if(w48<=10)goto label_ins45;
goto salida44;
label_ins45:{}
w49 = ptr + 10;
w50 = stack[w49];

w51 = ptr + 9;
w52 = stack[w51];

w53 = w50+w52;
w54 = ptr + 10;
stack[w54] = w53;


w55 = ptr + 10;
w56 = stack[w55];

cout<<"Suma acumulada: ";
cout<<w56;
cout<<endl;w57 = ptr + 9;
w58 = stack[w57];

w59 = 1;

w60 = w58+w59;
w61 = ptr + 9;
stack[w61] = w60;


goto label_Loop43;
salida44:{}
cout<<"otro for: ";
cout<<endl;w65 = ptr + 9;
stack[w65] = 1;


label_Loop62:{}
w66 = ptr + 9;
w67 = stack[w66];

if(w67<=10)goto label_ins64;
goto salida63;
label_ins64:{}
w68 = 5;

w69 = ptr + 9;
w70 = stack[w69];

w71 = w68*w70;
w72 = ptr + 6;
stack[w72] = w71;


w73 = ptr + 9;
w74 = stack[w73];

cout<<"Multiplicación de 5 por ";
cout<<w74;
w75 = ptr + 6;
w76 = stack[w75];

cout<<" es igual a ";
cout<<w76;
cout<<endl;w77 = ptr + 9;
w78 = stack[w77];

w79 = 1;

w80 = w78+w79;
w81 = ptr + 9;
stack[w81] = w80;


goto label_Loop62;
salida63:{}
labelReturn11:

cout<<endl;
}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

