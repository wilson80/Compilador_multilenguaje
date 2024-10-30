#include<iostream>
using namespace std;
int ptr = 0;
int stack[100];

void sumar(){
int w8 = ptr + 1;
int w9 = stack[w8];
int w10 = ptr + 2;
int w11 = stack[w10];
int w12 = w9+w11;
int w13 = ptr + 3;
stack[w13] = w12;
int w14 = ptr + 3;
int w15 = stack[w14];
int w16 = ptr + 0;
stack[w16] = w15;

}

int main(){
int w0 = ptr + 0;
stack[w0] = 0;
int w1 = ptr + 1;
stack[w1] = 0;
int w2 = ptr + 2;
stack[w2] = 0;
int w3 = ptr + 0;
stack[w3] = 5;

int w4 = ptr + 1;
stack[w4] = 4;

cout<<"El resultado es" <<endl;
int w5 = ptr + 3;

int w6 = w5 + 1;
stack[w6] = 4;
int w7 = w5 + 2;
stack[w7] = 77;
ptr = ptr + 3;
sumar();
ptr = ptr - 3;
int w17 = ptr + 3;

int w18 = w17 + 0;
int w19 = stack[w18];
cout<<w19<<endl;

}//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

