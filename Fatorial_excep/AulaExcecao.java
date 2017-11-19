
import java.util.Scanner;


public class AulaExcecao {

    
    public static void main(String[] args) {
        try {
            System.out.print("N:");
            Negativo((new Scanner(System.in)).nextInt());
        } catch (NumeroNegativo e) {
            e.printStackTrace();
        }
    }

    public static void Negativo(int N) throws NumeroNegativo {
        if (N < 0) {
            throw new NumeroNegativo("N é negativo");
        }
    }

}
