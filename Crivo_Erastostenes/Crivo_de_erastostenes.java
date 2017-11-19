import static java.lang.Math.sqrt;
import java.util.Scanner;



public class Crivo_de_erastostenes {


    public static void main(String[] args) {
        
        
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe o valor de n");
        int n = leitura.nextInt();
        imprime(n);
        
    }
    
    public static void imprime (int n){
        int numeros[] = new int[n];
        for(int i = 0; i< n; i++){
            numeros[i]= 0;
        }
        for(int i = 2; i< sqrt(n); i++){
            for(int j = 2; i*j < n ; j++){
                numeros[i*j] = 1;
            }
        }
        for(int i = 2; i< n; i++){
            if(numeros[i] == 0) System.out.print( i+ " ");
        }
    }
    
}