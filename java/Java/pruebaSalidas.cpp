#include<iostream>
using namespace std;
int ptr = 0;
int stack[100];

void sumar(){
int w7 = ptr + 1;

int w8 = stack[w7];
int w9 = ptr + 2;

int w10 = stack[w9];
int w11 = w8*w10;
int w12 = ptr + 3;

int w13 = stack[w12];
int w14 = w11-w13;
int w15 = ptr + 4;

stack[w15] = w14;
int w16 = ptr + 4;

int w17 = stack[w16];
int w18 = ptr + 0;

stack[w18] = w17;

}

int main(){
int w0 = ptr + 0;

stack[w0] = 0;
int w1 = ptr + 1;

stack[w1] = 0;
int w2 = ptr + 2;

stack[w2] = 0;
cout<<"El resultado es:" <<endl;
int w3 = ptr + 3;

int w4 = w3 + 1;

stack[w4] = 5;
int w5 = w3 + 2;

stack[w5] = 6;
int w6 = w3 + 3;

stack[w6] = 2;
ptr = ptr + 3;
sumar();
ptr = ptr - 3;
int w19 = ptr + 3;

int w20 = w19 + 0;

int w21 = stack[w20];
cout<<w21<<endl;

}//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

