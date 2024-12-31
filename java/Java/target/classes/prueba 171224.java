
%%PASCAL
%%JAVA
public class sumar {
	int uno;
	int dos;
	int tres;
	int total;
    Carta carta1;
    Carta carta2;
    Carta carta3;

	public sumar(int uno, int dos, int tres) {
		 this.uno = uno;
		 this.dos = dos;
		 this.tres = tres;
	}

	public void crearCartas(){
        carta1 = new Carta(1,2,3);
        carta2 = new Carta(4,5,6);
        carta3 = new Carta(7,8,9);
        carta1.printInfoCarta();
        carta2.printInfoCarta();
        carta3.printInfoCarta();

    }

	public int getTotal(){
		return this.total;
	}
 
} 

public class Carta {
	int color;
	int numero;
	int numeroTipo;
 
	public Carta(int color, int numero, int numeroTipo) {
		 this.color = color;
		 this.numero = numero;
		 this.numeroTipo = numeroTipo;
	}
	public void printInfoCarta(){
        println("Color: ", color);
        println("Numero: ", numero);
        println("#tipo: ", numeroTipo);
	}
    
	public int getColor(){
		return this.color;
	}
	public int getNumero(){
		return this.numero;
	}
	public int getNumeroTipo(){
		return this.numeroTipo;
	}
 
}

 
%%PROGRAMA
#include "JAVA.*"  
int x = 12;
int y = 6;
int z = 9;
int total = 88;

	 JAVA.sumar      call1(x, y, z);
	  
void main()
{ 	   
	JAVA.call1.crearCartas();

    
    
	
}




























































 


%%PASCAL
%%JAVA
public class sumar {
	int uno;
	int dos;
	int tres;
	int total;
	public sumar(int uno, int dos, int tres) {
		 this.uno = uno;
		 this.dos = dos;
		 this.tres = tres;
	}
	public void calcular(){
		total = this.uno - this.dos;
	}
	public int getTotal(){
		return this.total;
	}
 
} 

 
%%PROGRAMA
#include "JAVA.*"  
int x = 12;
int y = 6;
int z = 9;
int total = 88;

	 JAVA.sumar      call1(x, y, z);
	 JAVA.sumar      call2(7, 2, 3);
	 JAVA.sumar      call3(6, 2, 3);
void main()
{ 	   
	JAVA.call1.calcular();
	
	JAVA.call2.calcular();
	
	JAVA.call3.calcular();
	
	
	total = JAVA.call1.getTotal();
	printf("TototalllllXl: %d", total);
	total = JAVA.call2.getTotal();
	printf("Tototallllll: %d", total);
	total = JAVA.call3.getTotal();
	printf("Tototallllll: %d", total);
	
}

