package ej7;

import java.util.ArrayList;


public class ControllerTablero {

	private Tablero t;
	private int s;
	private ArrayList<Integer> k;
	private boolean[] opcVistas;
	public ControllerTablero(Tablero t,int s, int k){
		this.t= t;
		this.s=s;
		this.opcVistas = new boolean[k+1];//opciones van desde 1 a k
		
	}
	

	
	public boolean solucionPorBacktrack(Tablero t,ArrayList<Integer> k,int paso,boolean isSol){
		int n=t.getLength();
		if(paso == n*n) {
			if (t.solucion(this.s)) {
				System.out.println("Solucion de Tablero magico:");
				t.imprimir();
				return true;
			}		
		}else {
			for (int val = 1; val <= opcVistas.length-1; val++) {
				if (this.opcVistas[val]) {
					continue; 
				}
				this.opcVistas[val] = true;
				int posCol=paso%n;
				int posFil=paso/n;
				t.setElement(val,posCol, posFil);
				t.actualizarSumas();
				isSol=solucionPorBacktrack(t, k, paso+1,isSol); //exploro opciones
				if(isSol==true){
					return true;
				}
				// vuelvo a estado anterior
				t.setElement(0,posCol, posFil);
				t.actualizarSumas();
				this.opcVistas[val] = false;

			}
		}
		return false;
	}
		
		
		
	
	public ArrayList<Integer> getK(){
		return this.k;
	}
}
