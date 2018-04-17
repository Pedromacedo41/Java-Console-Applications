import java.util.Scanner;
import java.util.Random;


public class Percolation {

    int matrice[];

    int size, N;
    float moyenne;

    public Percolation(int size, int N){
        this.size= size;
        this.N=N;
        init();
    }



    
    public static void main(String[] args) {

        int size, N;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Taille du Tableau:");
        size= in.nextInt();
        System.out.println("Nombres de cas");
        N =  in.nextInt();
        Percolation Percolation = new Percolation(size, N);

    }


    private void init(){
        matrice = new int[size*size];
        for (int i=0; i < matrice.size() ; i++ ) {
            matrice[i]= 0;
        }

    }



}







