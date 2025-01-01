#include <iostream>

using namespace std;

int stack[100];
int heap[100];
int ptr = 0;
int h = 0;



void java_Simple_imprimirInfo(){
cout<<"unoo: ";
int w36 = ptr + 0;
int w37 = stack[w36];

int w38 = w37 + 0;
int w39 = heap[w38];

cout<<w39;
cout<<endl;
cout<<"doss: ";
int w40 = ptr + 0;
int w41 = stack[w40];

int w42 = w41 + 1;
int w43 = heap[w42];

cout<<w43;
cout<<endl;
cout<<"tresss: ";
int w44 = ptr + 0;
int w45 = stack[w44];

int w46 = w45 + 2;
int w47 = heap[w46];

cout<<w47;
cout<<endl;

}

void java_Simple_Simple(){
int w12 = h;
h = w12 + 3;

int w13 = ptr + 0;
stack[w13] = w12;

int w14 = ptr + 0;
int w15 = stack[w14];

int w16 = w15 + 0;
heap[w16] = 0;

int w17 = ptr + 0;
int w18 = stack[w17];

int w19 = w18 + 1;
heap[w19] = 0;

int w20 = ptr + 0;
int w21 = stack[w20];

int w22 = w21 + 2;
heap[w22] = 0;

int w23 = ptr + 0;
int w24 = stack[w23];

int w25 = w24 + 0;
heap[w25] = 4;


int w26 = ptr + 0;
int w27 = stack[w26];

int w28 = w27 + 1;
heap[w28] = 6;


int w29 = ptr + 0;
int w30 = stack[w29];

int w31 = w30 + 2;
heap[w31] = 9;


int w32 = ptr + 3;

int w33 = ptr + 0;
int w34 = stack[w33];

int w35 = w32 + 0;
stack[w35] = w34;

ptr = ptr + 3;
java_Simple_imprimirInfo();
ptr = ptr - 3;

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

int w11 = ptr + 5;

ptr = ptr + 5;
java_Simple_Simple();
ptr = ptr - 5;
int w48 = ptr + 5;

int w49 = w48 + 0;
int w50 = stack[w49];

int w51 = ptr + 0;
int w52 = stack[w51];

int w53 = w52 + 0;
heap[w53] = w50;



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

