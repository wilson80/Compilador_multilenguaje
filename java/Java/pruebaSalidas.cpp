#include <iostream>

using namespace std;

int stack[100];
int heap[100];
int ptr = 0;
int h = 0;



void java_sumar_sumar(){
int w0 = h;
h = w0 + 4;

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

int w11 = ptr + 0;
int w12 = stack[w11];

int w13 = w12 + 3;
heap[w13] = 0;

cout<<"Constrrr sumar";
cout<<endl;
int w14 = ptr + 2;
int w15 = stack[w14];

int w16 = ptr + 0;
int w17 = stack[w16];

int w18 = w17 + 0;
heap[w18] = w15;


int w19 = ptr + 3;
int w20 = stack[w19];

int w21 = ptr + 0;
int w22 = stack[w21];

int w23 = w22 + 1;
heap[w23] = w20;


int w24 = ptr + 4;
int w25 = stack[w24];

int w26 = ptr + 0;
int w27 = stack[w26];

int w28 = w27 + 2;
heap[w28] = w25;


cout<<"El total es: ";
int w29 = ptr + 0;
int w30 = stack[w29];

int w31 = w30 + 0;
int w32 = heap[w31];

cout<<w32;
cout<<endl;
cout<<"Constru:finnnnn";
cout<<endl;

}

void java_sumar_getTotal(){
int w33 = ptr + 3;
int w34 = stack[w33];

int w35 = 99;

int w36 = w34+w35;
int w37 = 5;

int w38 = w36-w37;
int w39 = ptr + 1;
stack[w39] = w38;


}

int main(){
int w0 = ptr + 0;
stack[w0] = 4;

int w1 = ptr + 1;
stack[w1] = 6;

int w2 = ptr + 2;
stack[w2] = 9;

int w3 = ptr + 3;
stack[w3] = 88;

int w4 = ptr + 0;
int w5 = stack[w4];

int w6 = ptr + 1;
int w7 = stack[w6];

int w8 = ptr + 2;
int w9 = stack[w8];

int w10 = ptr + 5;

int w11 = w10 + 2;
stack[w11] = w5;

int w12 = w10 + 3;
stack[w12] = w7;

int w13 = w10 + 4;
stack[w13] = w9;

ptr = ptr + 5;
java_sumar_sumar();
ptr = ptr - 5;
int w14 = ptr + 5;

int w15 = w14 + 0;
int w16 = stack[w15];

int w17 = ptr + 4;
stack[w17] = w16;

int w18 = ptr + 4;
int w19 = stack[w18];

int w20 = ptr + 5;

int w21 = w20 + 0;
stack[w21] = w19;

int w22 = ptr + 0;
int w23 = stack[w22];

int w24 = ptr + 2;
int w25 = stack[w24];

int w26 = ptr + 5;

int w27 = w26 + 3;
stack[w27] = w23;

int w28 = w26 + 4;
stack[w28] = w25;

ptr = ptr + 5;
java_sumar_getTotal();
ptr = ptr - 5;
int w29 = ptr + 5;

int w30 = w29 + 1;
int w31 = stack[w30];

int w32 = ptr + 3;
stack[w32] = w31;


int w33 = ptr + 3;
int w34 = stack[w33];

cout<<"El total es: ";
cout<<w34;
cout<<endl;
}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

