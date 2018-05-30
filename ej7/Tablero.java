package entregable3;


public class Tablero {

	private int[][] tablero;
	private int[] sumaFil;
	private int[] sumaCol;
	
	
	public Tablero(int n){
		this.tablero= new int[n][n];
		this.sumaCol= new int[n];
		this.sumaFil= new int[n];
	}
	public Tablero(int[][] tablero,int[] sumaCol,int[] sumaFil){
		this.tablero= new int[tablero.length][tablero.length];
		this.sumaCol= new int[tablero.length];
		this.sumaFil= new int[tablero.length];
		for (int i = 0; i < sumaFil.length; i++) {
			this.sumaCol[i]=sumaCol[i];
			this.sumaFil[i]=sumaFil[i];
		}
		for (int i = 0; i < tablero.length; i++) {
			
			for (int j = 0; j < tablero.length; j++) {
				this.tablero[i][j]=tablero[i][j];
			}
		}
	}
	public Tablero setElement(int e,int posCol, int posFil){
		this.tablero[posFil][posCol]=e;
		return new Tablero(this.tablero,this.sumaCol,this.sumaFil);
		
	}
	public void actualizarSumas(int posCol,int posFil){
		this.sumaCol[posCol]+=this.tablero[posFil][posCol];
		this.sumaFil[posFil]+=this.tablero[posFil][posCol];
	}
	public void imprimir(){
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j]+" ");
			}
			System.out.println();
		}
	}
	public boolean checkSumas(int s){
		for (int i = 0; i < sumaCol.length; i++) {
			if(sumaCol[i]>s)
				return false;
			if(sumaFil[i]>s)
				return false;
		}
		return true;
	}
	public boolean solucion(int s){
		for (int i = 0; i < sumaCol.length; i++) {
			if(sumaCol[i]!=s)
				return false;
			if(sumaFil[i]!=s)
				return false;
		}
		return true;
	}
	
}
