#include<iostream>
using namespace std;
int ptr = 0;
int stack[100];

void sumar(){
int w6 = ptr + 1;

int w7 = stack[w6];
int w8 = ptr + 2;

int w9 = stack[w8];
int w10 = w7+w9;
int w11 = ptr + 3;

stack[w11] = w10;
int w12 = ptr + 3;

int w13 = stack[w12];
int w14 = ptr + 0;

stack[w14] = w13;

}

int main(){
int w0 = ptr + 0;

stack[w0] = 0;
int w1 = ptr + 1;

stack[w1] = 0;
int w2 = ptr + 2;

stack[w2] = 0;
cout<<"El resultado es:";
int w3 = ptr + 3;

int w4 = w3 + 1;

stack[w4] = 5;
int w5 = w3 + 2;

stack[w5] = 6;
ptr = ptr + 3;
sumar();
ptr = ptr - 3;
int w15 = ptr + 3;

int w16 = w15 + 0;

int w17 = stack[w16];
cout<<w17;
cout<<"sadf";
int w18 = ptr + 0;

int w19 = stack[w18];
cout<<w19;
cout<<endl;cout<<"algo: ";
int w20 = ptr + 0;

int w21 = stack[w20];
cout<<w21;
cout<<endl;
}//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

