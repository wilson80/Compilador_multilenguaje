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

w0 = h;
h = w0 + 2;

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

w8 = ptr + 2;
w9 = stack[w8];

w10 = ptr + 0;
w11 = stack[w10];

w12 = w11 + 0;
heap[w12] = w9;


w13 = ptr + 3;
w14 = stack[w13];

w15 = ptr + 0;
w16 = stack[w15];

w17 = w16 + 1;
heap[w17] = w14;



}

void java_sumar_calcularFibonacci(){
int w23;
int w24;
int w25;
int w26;
int w27;
int w28;
int w29;

w24 = ptr + 4;
stack[w24] = 44;

cout<<"varrrrrrrr local: ";
w25 = ptr + 4;
w26 = stack[w25];

cout<<w26;
cout<<endl;
w27 = ptr + 4;
w28 = stack[w27];

w29 = ptr + 1;
stack[w29] = w28;

goto retorno23;
retorno23:

}

void java_sumar_crearCartas(){
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

w18 = ptr + 3;
stack[w18] = 10;

w19 = ptr + 2;

w20 = ptr + 0;
w21 = stack[w20];

w22 = w19 + 0;
stack[w22] = w21;

ptr = ptr + 2;
java_sumar_calcularFibonacci();
ptr = ptr - 2;

//retorno
w30 = ptr + 2;

w31 = w30 + 1;
w32 = stack[w31];


//retorno
w33 = ptr + 4;
stack[w33] = w32;

cout<<"El número : ";
w34 = ptr + 3;
w35 = stack[w34];

cout<<w35;
cout<<endl;
cout<<"resultadooo: ";
w36 = ptr + 4;
w37 = stack[w36];

cout<<w37;
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

w8 = ptr + 5;

w9 = w8 + 2;
stack[w9] = w5;

w10 = w8 + 3;
stack[w10] = w7;

ptr = ptr + 5;
java_sumar_sumar();
ptr = ptr - 5;
w11 = ptr + 5;

w12 = w11 + 0;
w13 = stack[w12];

w14 = ptr + 4;
stack[w14] = w13;

w15 = ptr + 4;
w16 = stack[w15];

w17 = ptr + 5;

w18 = w17 + 0;
stack[w18] = w16;

w19 = ptr + 5;

ptr = ptr + 5;
java_sumar_crearCartas();
ptr = ptr - 5;

}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

