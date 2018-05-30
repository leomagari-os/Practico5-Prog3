package entregable3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tablero t= new Tablero(3);
		ControllerTablero c=new ControllerTablero(t,15,10);
		
		c.generarOpciones(0,0);
		c.imprimirOpciones();
	}

}
