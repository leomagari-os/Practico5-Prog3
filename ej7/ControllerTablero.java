package ej7;

import java.util.ArrayList;


public class ControllerTablero {

	private ArrayList<Tablero> t;
	private int s;
	private ArrayList<Integer> k;
	private boolean[] opcVistas;
	public ControllerTablero(Tablero t,int s, int k){
		this.t= new ArrayList<Tablero>();
		this.s=s;
		this.opcVistas = new boolean[k+1];//opciones van desde 1 a k
		
	}
	

	
	public void solucionPorBacktrack(Tablero t,ArrayList<Integer> k,int paso,boolean isSol){
		int n=t.getLength();
		if(paso == n*n) {
			if (t.solucion(this.s)) {
				System.out.println("Solucion Encontrada!");
				System.out.println("Buscando Soluciones faltantes...");
				addSolucion(t);
			//	t.imprimir();
				//return true;
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
				//isSol=solucionPorBacktrack(t, k, paso+1,isSol); //exploro opciones
				solucionPorBacktrack(t, k, paso+1,isSol); 
				//	if(isSol==true){
					//return true;
				//}
				// vuelvo a estado anterior
				t.setElement(0,posCol, posFil);
				t.actualizarSumas();
				this.opcVistas[val] = false;

			}
		}
		//sreturn false;
	}
		
		
		
	
	private void addSolucion(Tablero t) {
		this.t.add(new Tablero(t.getTablero()));
	}

	public void imprimirSolucionAleatoria(){
		this.t.get((int) Math.floor(Math.random() * this.t.size()-1)).imprimir();
	}

	public ArrayList<Integer> getK(){
		return this.k;
	}
}
