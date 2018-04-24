import java.util.Scanner;
import java.util.Random;


public class Percolation {

    boolean matrice[];

    int size, N;
    Union class_union;

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
        //percolation.percolation_method_3();
        percolation.montecarlo(N);

    }


    private void init(){
        matrice = new boolean[size*size];
        for (int i=0; i < size*size ; i++ ) {
            matrice[i]= false;
        }
        class_union = new Union(size*size);
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
        int n=0;
        do{
            n= aleatoire.nextInt(size*size-1);
        }while(matrice[n]);
        matrice[n]=true;

        return n;
    }

    private boolean is_percolation(int n){
        boolean up, down;
        boolean chemin[] = new boolean[size*size];
        for (int i=0; i < size*size ; i++ ) {
            chemin[i]= false;
        }
        up= visithigh(chemin, n);
        for (int i=0; i < size*size ; i++ ) {
            chemin[i]= false;
        }
        down= visitlow(chemin,n);
        return (up && down);
    }

    private boolean is_percolation2(int n){
       propagate_union2(n);
       boolean up=false, down=false;
       int  a =  class_union.find_quickfind(n);
       for(int i =0; i< size; i++){
            int b= class_union.find_quickfind(i);
            if(b==a) up=true;
            
       }

        for(int j= (size*(size-1)); j < size*size; j++){
            int b= class_union.find_paresseaux(j);
            if(b==a) down=true;
        }
       return (up && down);
    }

    private boolean is_percolation3(int n){
       propagate_union2(n);
       boolean up=false, down=false;
       int  a =  class_union.find_paresseaux(n);
       for(int i =0; i< size; i++){
            int b= class_union.find_paresseaux(i);
            if(b==a) up=true;
            
       }

        for(int j= (size*(size-1)); j < size*size; j++){
            int b= class_union.find_paresseaux(j);
            if(b==a) down=true;
        }
       return (up && down);
    }

    private void propagate_union(int n){
        int Up, right, left, Down;
        Down =   (n> (size*(size-1)-1))? -1 : n+size; 
        Up= (n<size)?                -1 : n-size;  
        right= (n%size == (size-1))?   -1 : (n+1); 
        left = (n%size == 0)?          -1 : (n-1); 
        if(voisin(Up)) class_union.union_quickfind(n,Up);
        if(voisin(Down)) class_union.union_quickfind(n,Down);
        if(voisin(left)) class_union.union_quickfind(n,left);
        if(voisin(right)) class_union.union_quickfind(n,right);
    }

    private void propagate_union2(int n){      // avec optimization parressaux
        int Up, right, left, Down;
        Down =   (n> (size*(size-1)-1))? -1 : n+size; 
        Up= (n<size)?                -1 : n-size;  
        right= (n%size == (size-1))?   -1 : (n+1); 
        left = (n%size == 0)?          -1 : (n-1); 
        if(voisin(Up)) class_union.union_paresseaux(n,Up);
        if(voisin(Down)) class_union.union_paresseaux(n,Down);
        if(voisin(left)) class_union.union_paresseaux(n,left);
        if(voisin(right)) class_union.union_paresseaux(n,right);
    }


    private boolean visithigh(boolean chemin[], int n){
            if(validmotion(n,chemin)) {
                if(n<size) return true;
                else{
                    chemin[n]=true;
                    int Up, right, left, Down;
                    Down =   (n> (size*(size-1)-1))? -1 : n+size; 
                    Up= (n<size)?                -1 : n-size;  
                    right= (n%size == (size-1))?   -1 : (n+1); 
                    left = (n%size == 0)?          -1 : (n-1); 

                    return (visithigh(chemin,Up) || visithigh(chemin,Down) || visithigh(chemin,left) || visithigh(chemin,right));
                }
            }else{
                return false;
            }
    }

    private boolean visitlow(boolean chemin[], int n){
            if(validmotion(n,chemin)) {
                if(n> (size*(size-1)-1)) return true;
                else{
                    chemin[n]=true;
                    int Up, right, left, Down;
                    Down =   (n> (size*(size-1)-1))? -1 : n+size; 
                    Up= (n<size)?                -1 : n-size;  
                    right= (n%size == (size-1))?   -1 : (n+1); 
                    left = (n%size == 0)?          -1 : (n-1); 

                    return (visitlow(chemin,Up) || visitlow(chemin,Down) || visitlow(chemin,left) || visitlow(chemin,right));
                }
            }else{
                return false;
            }
    }

    private boolean validmotion(int n, boolean chemin[]){
        if(n<0){ return false; }
        else{
            if(chemin[n] || !matrice[n]){ return false; }
            else{
                return true;
            }
        }  
    }

    private boolean voisin(int n){
        if(n<0){ return false; }
        else{
            if(!matrice[n]){ return false; }
            else{
                return true;
            }
        }  
    }


    public int percolation_method_1(){
        int i=0;
        while(!is_percolation(random_shadow())){
            i++;
            //print();
        } 
        //print();
        return i;
    }

    public int percolation_method_2(){
        int i=0;
        while(!is_percolation2(random_shadow())){
            i++;
            //print();
        } 
        //print();
        return i;
    }

    public int percolation_method_3(){
        int i=0;
        while(!is_percolation3(random_shadow())){
            i++;
        } 
        return i;
    }

    public float montecarlo(int n){
        float moyenne=0;
        for (int i=0; i < n; i++ ) {
            init();
            moyenne+=percolation_method_3();
        }
        moyenne/=n;
        System.out.printf("%f", moyenne/(size*size)*100);
        
        return moyenne;
    }
}







