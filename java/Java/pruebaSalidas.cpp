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

w26 = ptr + 3;
stack[w26] = 10;

w27 = ptr + 4;
stack[w27] = 5;

w29 = ptr + 3;
w30 = stack[w29];

case31_0:{}
if(w30==1)goto caseIns33;
goto case31_1;
caseIns33:{}
cout<<"a es: ";
w34 = ptr + 3;
w35 = stack[w34];

cout<<w35;
cout<<endl;
goto salida28;
case31_1:{}
if(w30==10)goto caseIns36;
goto deff32;
caseIns36:{}
cout<<"a es: ";
w37 = ptr + 3;
w38 = stack[w37];

cout<<w38;
cout<<endl;
goto salida28;
deff32:{}
cout<<"DEFFFF a es: ";
w40 = ptr + 3;
w41 = stack[w40];

cout<<w41;
cout<<endl;
salida28:{}

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

