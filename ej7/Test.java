package ej7;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;//Tablero genera un tablero de n * n. EJ n=3 =>tablero de 9 posiciones
		Tablero t= new Tablero(n);
		int s=15;//es el numero que tiene que dar la suma de cada fila y cada columna
		int k=10;//k tiene que ser mayor a n*n
		ControllerTablero c=new ControllerTablero(t,s,k);
		ControllerTablero res=c.explorarOpciones(c);
		System.out.println(res);
		
	}

}
