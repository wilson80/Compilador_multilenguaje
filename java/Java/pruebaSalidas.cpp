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
int w47 = ptr + 0;
int w48 = stack[w47];

int w49 = w48 + 0;
int w50 = heap[w49];

cout<<w50;
cout<<endl;
cout<<"doss: ";
int w51 = ptr + 0;
int w52 = stack[w51];

int w53 = w52 + 1;
int w54 = heap[w53];

cout<<w54;
cout<<endl;
cout<<"tresss: ";
int w55 = ptr + 0;
int w56 = stack[w55];

int w57 = w56 + 2;
int w58 = heap[w57];

cout<<w58;
cout<<endl;
cout<<"cuaa: ";
int w59 = ptr + 0;
int w60 = stack[w59];

int w61 = w60 + 3;
int w62 = heap[w61];

cout<<w62;
cout<<endl;

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


int w38 = ptr + 0;
int w39 = stack[w38];

int w40 = w39 + 0;
int w41 = heap[w40];

int w42 = ptr + 0;
stack[w42] = w41;

int w43 = ptr + 4;

int w44 = ptr + 0;
int w45 = stack[w44];

int w46 = w43 + 0;
stack[w46] = w45;

ptr = ptr + 4;
java_Simple_imprimirInfo();
ptr = ptr - 4;

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

