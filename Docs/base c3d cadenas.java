//cabecera
#include<iostream>
using namespace std;
int ptr = 0;
int stack[100];



void suma(){
    int tr1;
    int tr2;
    int tr3;
    int tr4;
    int tr5;
    int tr6;
    int tr7;
    int tr8;
    int tr9;

// ins Statement
    //expSuma 
//acces x
    tr1 = ptr + 1;
    tr2 = stack[tr1];

//acces y
    tr3 = ptr + 2;
    tr4 = stack[tr3];
//op
    tr5 = tr2 - tr4;
//assig a total
    tr6 = ptr + 3;
    stack[tr6] = tr5;

//return
    tr7 = ptr + 3;
    tr8 = stack[tr7];

    tr9 = ptr + 0;
    stack[tr9] = tr8;

}


int main(){
// bajo nivel
    int t1;
    int t2; 
    int t3;
    int t4;
    int t5;
    int t6;
    int t7;
    int t8;
    int t9;
    int t10;
    int t11;
    int t12;
    int t13;
    int t14;
    int t15;
    int t16;
    int t17;
    int t18;
    int t19;
    int t20;
    int t21;
    int t22;
    int t23;
    int t24;
    int t25;
    int t26;
    int t27;
    int t28;
    int t29;
    int t30;
    int t31;

________________________________________________________
    t1 = ptr + 0;
    stack[t1] = 0;

    t2 = ptr + 1;
    stack[t2] = 0;

    t3 = ptr + 2;
    stack[t3] = 0;

    cout<<"Ingresa un número: ";

    //scan_int t4;
    cin >> t4;

    t5 = ptr + 0;
    stack[t5] = t4;
    cout<<"Ingresa otro numero: ";


    //scan_int t6;
    cin >> t6;
    t7 = ptr + 1;
    stack[t7] = t6;

   

  
    // valor de num1
    t21 = ptr + 0;
    t22 = stack[t21];

    // valor de num2
    t23 = ptr + 1;
    t24 = stack[t23];

    // temporalmente nos movemos al stack de resta
    t25 = ptr + 3;

    // copiando el valor de num1 al param x
    t26 = t25 + 1;
    stack[t26] = t22;

    // copiando el valor de num1 al param y
    t27 = t25 + 2;
    stack[t27] = t24;

    ptr = ptr + 3;
    suma();
    ptr = ptr - 3;


    // movemos temporalmente al stack de resta
    t27 = ptr + 3;

    t28 = t27 + 0;
    t29 = stack[t28];

    t30 = ptr + 2;
    stack[t30] = t29;

    cout<<"Resta";

    t30 = ptr + 2;
    t31 = stack[t30];
    cout<<">>"<<t31;



//
//    cout<<"Ingresa un número: "<<stack[0];
////        cin >> pedir;



}