import java.util.Scanner;


public class fatorial{

	public static void main(String[] args){

		int n;
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o numero N:");

		try{ 
			System.out.println(fatorial((new Scanner(System.in)).nextInt()));
		}
		catch(NumeroNegativo e){
			e.printStackTrace();
		}

	}

	public static int fatorial(int n) throws NumeroNegativo {
		if(n<0) throw new NumeroNegativo("N é negativo");
		if(n>12) throw new NumeroNegativo("N causa overflow");

		return (n>1)? n*fatorial(n-1) : 1;
	}



}