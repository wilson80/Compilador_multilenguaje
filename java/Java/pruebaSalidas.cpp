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

cout<<"Constrrr sumar";
cout<<endl;
int w8 = ptr + 2;
int w9 = stack[w8];

int w10 = ptr + 0;
int w11 = stack[w10];

int w12 = w11 + 0;
heap[w12] = w9;


int w13 = ptr + 3;
int w14 = stack[w13];

int w15 = ptr + 0;
int w16 = stack[w15];

int w17 = w16 + 1;
heap[w17] = w14;


cout<<"NUm1: ";
int w18 = ptr + 0;
int w19 = stack[w18];

int w20 = w19 + 0;
int w21 = heap[w20];

cout<<w21;
cout<<endl;
cout<<"NUm2: ";
int w22 = ptr + 0;
int w23 = stack[w22];

int w24 = w23 + 1;
int w25 = heap[w24];

cout<<w25;
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
stack[w2] = 0;

int w3 = ptr + 0;
int w4 = stack[w3];

int w5 = ptr + 0;
int w6 = stack[w5];

int w7 = ptr + 5;

int w8 = w7 + 1;
stack[w8] = w4;

int w9 = w7 + 2;
stack[w9] = w6;

ptr = ptr + 5;
java_sumar();
ptr = ptr - 5;
int w10 = ptr + 5;

int w11 = w10 + 0;
int w12 = stack[w11];


}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

