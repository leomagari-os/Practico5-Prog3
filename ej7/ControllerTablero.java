package entregable3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ControllerTablero {
	private HashMap<Integer,Integer> k;
	private Tablero t;
	private int s;
	private ArrayList<ControllerTablero> opciones;
	public ControllerTablero(Tablero t,int s, int k){
		this.t= t;
		this.s=s;
		this.opciones=new ArrayList<ControllerTablero>();
		this.k=new HashMap<Integer,Integer>();
		for (int i = 1; i < k; i++) {
			this.k.put(new Integer(i),new Integer(i));
		}
	}
	
	public ControllerTablero(Tablero t, int s, HashMap<Integer, Integer> k) {
		this.t= t;
		this.s=s;
		this.opciones=new ArrayList<ControllerTablero>();
		this.k=k;
		
	}

	public boolean generarOpciones(int posCol,int posFil){
		if(t.checkSumas(this.s)){
			Iterator<Integer> it=k.keySet().iterator();
			while (it.hasNext()) {
				int actual=it.next();
				this.opciones.add(new ControllerTablero(
						this.t.setElement(actual, posCol, posFil)
						,this.s
						,quitarElemento(this.k, actual)));

			}
		}else{
			return false;
		}
		return true;
	}
	public Tablero getTablero(){
		return this.t;
	}
	public HashMap<Integer,Integer> quitarElemento(HashMap<Integer,Integer> k,int elem){
		HashMap<Integer,Integer> res=new HashMap<Integer,Integer>();
		Iterator<Integer> it=k.keySet().iterator();
		while (it.hasNext()) {
			int actual=it.next();
			res.put(actual, actual);
		}
		res.remove(elem);
		return res;
	}
	public void imprimirOpciones(){
		for (int i = 0; i < this.opciones.size(); i++) {
			Tablero t=opciones.get(i).getTablero();
					
			t.imprimir();
			System.out.println();
		}
	}
}
