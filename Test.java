import java.util.*;
import java.lang.*;


class Operation implements Runnable {


	private Integer[] fila;
	private Integer[] columna;
	//private int[] res;


	Operation(Integer[] fila, Integer[] columna){
		this.fila=fila;
		this.columna=columna;

	}


	public Integer[] resultado(){	

		Integer[] res = new Integer[fila.length];
		int acumRes=0;

		for(int m=0;m<fila.length;m++){
			for(int k=0;k<fila.length;k++){
				acumRes=fila[m]*columna[k];
			}
			res[m]=acumRes;
		}

		return res;
	}
	public void run(){


		System.out.println("Hola mundo");

	}


}


public class Test{

	public static void main(String[] args){



		Integer tam = 3;

		Integer[][] matrix= new Integer[tam][tam];
		Integer[][] matrix2= new Integer[tam][tam];
		Integer test[];
		Integer test2[];
		Integer resultado[];
    	

		matrix=llenarMatrix(matrix);

		imprimirMatrix(matrix);
		test=convertirMatrix(matrix, 1, 0);
		test2=convertirMatrix(matrix, 0, 1);
		Operation operation = new Operation(test, test2);
		resultado = operation.resultado();






		System.out.println(Arrays.toString(resultado));


	}

	static Integer[][] llenarMatrix(Integer[][] mat){


	
		int cont=0;

		for(int m=0; m<mat[0].length;m++){
			for(int n=0; n<mat[0].length;n++){
				mat[m][n]=cont+=1;
			}

		}

		return mat;

	}
	

	static void imprimirMatrix(Integer[][] mat){

		String str = "|\t";

		for(int i=0;i<mat[0].length;i++){
            for(int j=0;j<mat[0].length;j++){
                str += mat[i][j] + "\t";
            }

            System.out.println(str + "|");
            str = "|\t";
        }



	}


	static Integer[] convertirMatrix(Integer[][] mat, int f, int c){

		Integer[] resultado = new Integer[mat[0].length];

		if(f>0){
			for(int k=0;k<mat[0].length;k++){
				resultado[k]=mat[k][f-1];
			}

		}
		else if(c>0){
			for(int k=0;k<mat[0].length;k++){
				resultado[k]=mat[c-1][k];
			}

		}

		return resultado;


	}






}