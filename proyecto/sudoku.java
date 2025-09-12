package proyecto;
import java.util.Scanner;
public class sudoku {
	public static void main(String [] arg) {
		Scanner sc = new Scanner(System.in);
		int[][] matriz = new int[9][9];
		int[][] matrizaux= new int[9][9];
		int aux= 0;
		int aux3 =0;
		int Switch=0;
		
		resolversudoku(matrizaux);
		resolversudoku(matriz);
		System.out.println("presione un numero del 1-3 para elejir el nivel de la dificultad, siendo 1 nivel facil, 3 nivel dificil");
		Switch = sc.nextInt();
		switch(Switch) {
		case 1: aux3 = 40;
		break;
		case 2: aux3 = 60;
		break;
		case 3: aux3 = 75;
		}
		
		boolean valido = false;
		while (!valido) {
		    valido = asignartablerodeinicio(matrizaux, aux3);
		}
		imprimirTablero(matrizaux);
		System.out.println("");
		completarsudokumanual(matrizaux, matriz);
		boolean resuelto = resolversudoku(matriz);
	    //imprimirTablero(matriz);
	}
	
public static boolean noserepite(int[][] tablero, int fila, int col, int num ){
	
	for(int j= 0; j < 9; j++) {
		if(tablero[fila][j] == num) return false;
	}
	for(int i= 0; i < 9; i++) {
		if(tablero[i][col] == num) return false;
	}
	
	int idf = (fila/3) * 3;
	int fdc = (col/3) * 3;
	for(int a = 0; a < 3; a++) {
		for(int i = 0; i < 3; i++) {
		if(tablero[idf + a][fdc + i] == num ) return false;
		
	}
	}
return true;
}
public static boolean resolversudoku(int[][] matriz) {
	for(int fila = 0; fila < 9; fila++) {
		for (int col = 0; col < 9; col++){
			if(matriz[fila][col] == 0) {
				for(int num= 1; num <= 9; num++) {
					if(noserepite(matriz , fila , col , num)){
						matriz[fila][col] = num;
					
					if (resolversudoku(matriz)) {
					return true;
					}
				matriz[fila][col] = 0;
				}
		
			}
		return false;
			}
	}
	
	}	
	return true;
}
public static void imprimirTablero(int[][] tablero) {
   for (int i = 0; i < 9; i++) {
       for (int j = 0; j < 9; j++) {
           System.out.print(tablero[i][j] + "| ");
       }
       System.out.println();
       System.out.println("--------------------------");
   }
}
public static boolean asignartablerodeinicio(int[][] matriz,int aux3) {
	
	
	int a=0;
	int b=0;
	int [][] aux = new int[9][9];
	int [][] aux2 = new int[9][9];
	
	
	
	for(int j = 1; j <= aux3 ; j++) {
		a=(int)(Math.random() * 9);
		b=(int)(Math.random() * 9) ;
		matriz[a][b]=0;
	}
	for(int i = 0; i < 9; i++){
		for (int h= 0; h < 9; h++) {
			aux[i][h] = matriz[i][h];
			aux2[i][h] = matriz[i][h];
		}
	}
	resolversudoku(aux);
	resolversudoku(aux2);
	for(int i = 0; i < 9; i++){
	    for(int j = 0; j < 9; j++){
	        if(aux[i][j] != aux2[i][j]) {
	            return false;
	        }
	    }
	}
	return true;
	}	
public static  void completarsudokumanual(int [][]a,int [][] b ) {
	Scanner sc = new Scanner(System.in);
	int aux=0;
	int aux2=0;
	int Switch= 0;
	int p = 0;
	outer:
		for(int i = 1; i != 0 ;i++ ) {
			System.out.println("ingrese la pocicion (x) en la que desea ingresar el numero");
			aux = sc.nextInt();
			System.out.println("ingrese la pocicion (y) en la que desea ingresar el numero");
			aux2=sc.nextInt();
			if(a[aux-1][aux2 - 1] == 0) {
				System.out.println("ingrese el numero que quiere ingresar: ");
				a[aux-1][aux2 - 1] = sc.nextInt();
				imprimirTablero(a);
			}else {
				System.out.println("esa posicion no esta vacia...");
			}
			System.out.println("presione 0 si desea borrar una casilla o presione 1 si desea modificar alguna casilla, o presione cualquier otro numero para seguir llenando el suoku");
			Switch = sc.nextInt();
			for(int g = 0; g < 9; g++){
			    for(int j = 0; j < 9; j++){
			        if(a[g][j] == b[g][j]) {
			        	p = p + 1;
			        }
			    }
				
			}
			if(p == 81) {
				break outer;
			}
			switch(Switch) {
			case 0: System.out.println("ingrese la pocicion (x) en la que desea borrar el numero");
			aux = sc.nextInt();
			System.out.println("ingrese la pocicion (y) en la que desea borrar el numero");
			aux2=sc.nextInt();
				a[aux - 1][aux2 - 1] = 0;
				imprimirTablero(a);
				break;
			case 1: System.out.println("ingrese la pocicion (x) en la que deesea modificar el numero");
			aux = sc.nextInt();
			System.out.println("ingrese la pocicion (y) en la que deesea modificar el numero");
			aux2=sc.nextInt();
				a[aux -1][aux2 - 1] = sc.nextInt();
				imprimirTablero(a);
				break;
			
			default:System.out.println("elejiste seguir jugando.");
			break;
			
			
			}		
	sc.close();
}
     	System.out.println("Felicidades 😊, lograste completar el sudoku🎉🎉");
}
}