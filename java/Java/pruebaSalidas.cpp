#include <iostream>
#include <termios.h>
#include <unistd.h>
using namespace std;

int stackint[10000];
string stackstring[10000];
float stackfloat[10000];
char stackchar[10000];
int heapint[10000];
string heapstring[10000];
float heapfloat[10000];
char heapchar[10000];
int ptr = 0;
int h = 0;





 









int main(){
int int0;
int int1;
char char2;
int int3;
string string4;
int int5;
int int6;
int int7;
int int8;
int int9;
char char10;
int int11;
int int12;
string string13;
int int14;
int int15;
int int16;
int int17;
char char18;
int int19;
string string20;


int0 = 10;
int1 = ptr + 0;
stackint[int1] = int0;

char2 = 'a';
int3 = ptr + 1;
stackchar[int3] = char2;

string4 = "Aaa";
int5 = ptr + 2;
stackstring[int5] = string4;


cout<<"Ingrese el primer valor entero";
cout<<endl;int6 = ptr + 0;
int7 = stackint[int6];

//un cin



cin>> int7;
int8 = ptr + 0;
stackint[int8] = int7;


cout<<"Ingrese el primer valor charrrr";
cout<<endl;int9 = ptr + 1;
char10 = stackchar[int9];

//un cin



cin>> char10;
int11 = ptr + 1;
stackchar[int11] = char10;


cout<<"Ingrese el primer valor stringg";
cout<<endl;int12 = ptr + 2;
string13 = stackstring[int12];

//un cin



cin>> string13;
int14 = ptr + 2;
stackstring[int14] = string13;

int15 = ptr + 0;
int16 = stackint[int15];


cout<<" el  es char ";

cout<<int16;
cout<<endl;int17 = ptr + 1;
char18 = stackchar[int17];


cout<<" el  es char ";

cout<<char18;
cout<<endl;int19 = ptr + 2;
string20 = stackstring[int19];


cout<<" el  es char ";

cout<<string20;
cout<<endl;
labelReturn0:

cout<<endl;
}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

