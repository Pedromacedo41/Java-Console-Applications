import java.util.Scanner;
import java.util.Random;


public class Percolation {

    boolean matrice[];

    int size, N;
    float moyenne=0;

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
        Percolation percolation = new Percolation(size, N);
        percolation.print();
        percolation.montecarlo(N);
        percolation.print();

    }


    private void init(){
        matrice = new boolean[size*size];
        for (int i=0; i < size*size ; i++ ) {
            matrice[i]= false;
        }

    }

    public void print(){
        for (int i=0; i < size*size ; i++ ) {
            int j = i%size;
            if(j==0)  System.out.print('\n');

            if(matrice[i]) System.out.print('*'); else System.out.print('-');
        }
        System.out.print('\n');

    }


    private int random_shadow(){
        Random aleatoire = new Random();
        int n;
        do{
            n= aleatoire.nextInt(size*size);
        }while(matrice[n]);
        matrice[n]=true;

        return n;
    }

    private boolean is_percolation(int n){
        boolean chemin[size*size];
        for (int i=0; i < size*size ; i++ ) {
            chemin[i]= false;
        }
        visit(chemin, n, false);
        

        return true;  
    }

    private void visit(boolean chemin[], int n, boolean up){
        chemin[n]=true;
        int Up, right, left, down;
        Up =   (n> size*(size-1) )? -1 : n+size;
        down = (n<size)?            -1 : n-size;
        right= (n%size == 0)?       -1 : (n+1); 
        left = (n%size == 1)?       -1 : (n-1); 


    }


    public int percolation_method(){
        int i=0;
        while(is_percolation(random_shadow())){
            i++;
            print();
        } 
        return i;
    }

    public float montecarlo(int n){
        init();
        for (int i=0; i < n; i++ ) {
            moyenne+=percolation_method();
        }
        moyenne/=n;
        System.out.printf("%f", moyenne/(size*size));
        
        return moyenne;
    }


}







