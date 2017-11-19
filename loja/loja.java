import java.util.Scanner;
import java.util.ArrayList;


public class loja{
	    
		public static void main(String[] args){

			int d =0 ;
			Scanner in = new Scanner (System.in);
			System.out.println("Minha Lista de Compras");
			System.out.println("----------------------\n");
		
			ArrayList<item> listadeCompras = new ArrayList<item> ();
			
			loja minhaloja = new loja();
			minhaloja.inicializa(listadeCompras);
			minhaloja.imprime(listadeCompras);

		}

		void inicializa(ArrayList<item> listadeCompras){
			listadeCompras.add(new item("Sanduiche de File Simples", 48 , 2, false));
			listadeCompras.add(new item("Medalhão", 25, 1, true));
			listadeCompras.add(new item("Salada Caprese", 13, 3, true));
			listadeCompras.add(new item("Rosbife", 43, 1, false));
			listadeCompras.add(new item("Lasanha", 26, 2, false));

		}

		void imprime(ArrayList<item> listadeCompras){
			for(int i=0; i<5; i++){
				listadeCompras.get(i).imprime();
			}

			System.out.println("Entrega (60- 75min) \t \t \t            RS 12.00");
			System.out.println("-------------------------------------------------------------");
			System.out.println("Total:                                              RS " + total(listadeCompras));

		}

		float total(ArrayList<item> listadeCompras){
			float total = 0;

			for(int i=0; i<5; i++){
				item a = listadeCompras.get(i);
				total= total + (a.quantidade*a.valor);
				if(a.embalagem) total+= 3;
			}

			total+=12; //entrega;

			return total;

		}

}


