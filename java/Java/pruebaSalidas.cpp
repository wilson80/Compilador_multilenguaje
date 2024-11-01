#include<iostream>
using namespace std;
int ptr = 0;
int stack[100];

void sumar(){
int w17 = 2;

int w18 = 3;

int w19 = 6;

int w20 = w18*w19;
int w21 = 2;

int w22 = w20/w21;
int w23 = w17+w22;
int w24 = ptr + 4;
stack[w24] = w23;

int w25 = ptr + 4;
int w26 = stack[w25];

int w27 = ptr + 0;
stack[w27] = w26;


}

int main(){
int w0 = ptr + 0;
stack[w0] = 0;

int w1 = ptr + 1;
stack[w1] = 0;

int w2 = ptr + 2;
stack[w2] = 0;

int w3 = ptr + 3;
stack[w3] = 0;

int w4 = ptr + 0;
stack[w4] = 2;


int w5 = ptr + 1;
stack[w5] = 3;


int w6 = ptr + 2;
stack[w6] = 6;


int w7 = ptr + 0;
int w8 = stack[w7];

int w9 = ptr + 1;
int w10 = stack[w9];

int w11 = ptr + 2;
int w12 = stack[w11];

int w13 = ptr + 4;

int w14 = w13 + 1;
stack[w14] = w8;

int w15 = w13 + 2;
stack[w15] = w10;

int w16 = w13 + 3;
stack[w16] = w12;

ptr = ptr + 4;
sumar();
ptr = ptr - 4;
int w28 = ptr + 4;

int w29 = w28 + 0;
int w30 = stack[w29];

int w31 = ptr + 3;
stack[w31] = w30;


cout<<"El resultado es";
int w32 = ptr + 3;
int w33 = stack[w32];

cout<<w33;
cout<<endl;
}//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

