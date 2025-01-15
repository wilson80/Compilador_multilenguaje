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
char char9;
int int10;
string string11;
int int12;
int int13;
int int14;
char char15;
int int16;
string string17;


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

cout<<"Ingrese el primer valor charrrr";
cout<<endl;int8 = ptr + 1;
char9 = stackchar[int8];

//un cin



cin>> char9;

cout<<"Ingrese el primer valor stringg";
cout<<endl;int10 = ptr + 2;
string11 = stackstring[int10];

//un cin



cin>> string11;
int12 = ptr + 0;
int13 = stackint[int12];


cout<<" el  es char ";

cout<<int13;
cout<<endl;int14 = ptr + 1;
char15 = stackchar[int14];


cout<<" el  es char ";

cout<<char15;
cout<<endl;int16 = ptr + 2;
string17 = stackstring[int16];


cout<<" el  es char ";

cout<<string17;
cout<<endl;
labelReturn0:

cout<<endl;
}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

