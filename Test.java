import java.util.*;


class Operation implements Runnable {



public void run(){


	System.out.println("Hola mundo");

}







}



public class Test{

	public static void main(String[] args){



		Integer tam = Integer.parseInt(args[0]);

		Integer[][] matrix= new Integer[tam][tam];
		 String str = "|\t";
		 int cont=0;

		for(int m=0; m<tam;m++){
			for(int n=0; n<tam;n++){
				matrix[m][n]=cont+=1;
			}

		}

        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                str += matrix[i][j] + "\t";
            }

            System.out.println(str + "|");
            str = "|\t";
        }

    	





	}



}