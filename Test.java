package pluralsight;

import java.util.*;
import java.lang.*;
import java.lang.String;
import java.util.concurrent.*;




class Operation implements Runnable {




	private int filaInicio;
	private int filaTermina;
	private Integer[][] mat;
	private Integer[][] mat2;
	private Integer[][] resultado;
	private Integer[] resultado2;
	private Integer[][] resultado3;



	//private int[] res;


	Operation(int filaInicio, int filaTermina, Integer[][] mat,Integer[][] mat2, Integer[][] mat3){
		this.filaInicio=filaInicio;
		this.filaTermina=filaTermina;
		this.mat=mat;
		this.mat2=mat2;
		this.resultado3 = mat3;
		//this.resultado2 = new Integer[filaTermina];

	}

	/*	
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

		*/	


	public Integer[][] multMatrix(){
	//public void multMatrix(Integer[][] mat, Integer[][] mat2){

		

		int cont = 0;
	//	System.out.println(Integer.toString(filaInicio)+Integer.toString(filaTermina));

		for(int m=filaInicio;m<filaTermina;m++){
			for(int h=0;h<mat[0].length;h++){
				for(int i=0;i<mat[0].length;i++){
					//cont=mat[i][m]*mat[2][]
					//System.out.println(mat[m][i].toString()+"x"+mat[i][h].toString()+"="+Integer.toString(mat[m][i]*mat[i][h]));
				//	System.out.println(Integer.toString(i)+","+Integer.toString(h));
					cont+=mat[m][i]*mat[i][h];
					
				}
				resultado3[m][h]=cont;			
				cont=0;

			}

		

		}
			

		return resultado;
		


	}

	public void run(){
		this.multMatrix();


	}

	public Integer[][] getResultado(){
		return this.resultado3;

	}



}


public class Test{

	public static void main(String[] args){



		Integer tam = 1024;
		Integer hilos=1024;
		Integer indice=tam/hilos;

		Integer[][] matrix= new Integer[tam][tam];
		Integer[][] matrix2= new Integer[tam][tam];
		Integer[][] matrix3= new Integer[tam][tam];

		Integer test[];
		Integer test2[];
		Integer resultado[];
    	

		matrix=llenarMatrix(matrix);
		matrix2=llenarMatrix(matrix2);
		matrix3=llenarMatrix2(matrix3);

		//imprimirMatrix(matrix);
		//imprimirMatrix(matrix2);
		//Operation operation;

		

		Thread[] threads = new Thread[hilos];


		ExecutorService es = Executors.newFixedThreadPool(3);

		for (int i=0;i<hilos;i+=indice){
			Operation operation = new Operation(i,i+indice, matrix, matrix2, matrix3);
			/*
			threads[i]= new Thread(operation);
			threads[i].start();
			*/
			es.submit(operation);
			matrix3=operation.getResultado();

		}
		
		
		for(Thread thread : threads){
			try{
				//thread.join();
				es.shutdown();
				es.awaitTermination(60, TimeUnit.SECONDS);
			}
			catch(Exception e){}
		}

		/*
		Operation operation = new Operation(2,3, matrix, matrix2, matrix3);
		Thread thread = new Thread(operation);
        thread.start();
        

		
		try{
			thread.join();
		} 
		catch(Exception e){}
		*/
		
		//imprimirMatrix(matrix3);



	//	System.out.println(Arrays.toString(resultado));


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


	static Integer[][] llenarMatrix2(Integer[][] mat){


	
		int cont=0;

		for(int m=0; m<mat[0].length;m++){
			for(int n=0; n<mat[0].length;n++){
				mat[m][n]=-1;
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