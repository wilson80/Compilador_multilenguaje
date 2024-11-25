#include <iostream>

using namespace std;

int stack[100];
int heap[100];
int ptr = 0;
int h = 0;





void java_sumar(){
int w0 = h;
h = w0 + 1;

int w1 = ptr + 0;
stack[w1] = w0;

int w2 = ptr + 0;
int w3 = stack[w2];

int w4 = w3 + 0;
heap[w4] = 0;

int w5 = ptr + 1;
int w6 = stack[w5];

int w7 = w6 + 1;
heap[w7] = 0;

int w8 = ptr + 2;
int w9 = stack[w8];

int w10 = w9 + 2;
heap[w10] = 0;

cout<<"Constrrr sumar";
cout<<endl;
int w11 = ptr + 2;
int w12 = stack[w11];

int w13 = ptr + 0;
int w14 = stack[w13];

int w15 = w14 + 0;
heap[w15] = w12;


int w16 = ptr + 3;
int w17 = stack[w16];

int w18 = ptr + 0;
int w19 = stack[w18];

int w20 = w19 + 1;
heap[w20] = w17;


int w21 = ptr + 4;
int w22 = stack[w21];

int w23 = ptr + 0;
int w24 = stack[w23];

int w25 = w24 + 2;
heap[w25] = w22;


cout<<"NUm1: ";
int w26 = ptr + 0;
int w27 = stack[w26];

int w28 = w27 + 0;
int w29 = heap[w28];

cout<<w29;
cout<<endl;
cout<<"NUm2: ";
int w30 = ptr + 0;
int w31 = stack[w30];

int w32 = w31 + 1;
int w33 = heap[w32];

cout<<w33;
cout<<endl;
cout<<"NUm3: ";
int w34 = ptr + 0;
int w35 = stack[w34];

int w36 = w35 + 2;
int w37 = heap[w36];

cout<<w37;
cout<<endl;
cout<<"Constru:finnnnn";
cout<<endl;

}

int main(){
int w0 = ptr + 0;
stack[w0] = 4;

int w1 = ptr + 1;
stack[w1] = 6;

int w2 = ptr + 2;
stack[w2] = 9;

int w3 = ptr + 0;
int w4 = stack[w3];

int w5 = ptr + 1;
int w6 = stack[w5];

int w7 = ptr + 2;
int w8 = stack[w7];

int w9 = ptr + 6;

int w10 = w9 + 1;
stack[w10] = w4;

int w11 = w9 + 2;
stack[w11] = w6;

int w12 = w9 + 3;
stack[w12] = w8;

ptr = ptr + 5;
java_sumar();
ptr = ptr - 5;
int w13 = ptr + 5;

int w14 = w13 + 0;
int w15 = stack[w14];


}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

