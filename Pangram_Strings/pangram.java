import java.util.Arrays;
import java.util.Scanner;



public class pangram
{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		String message  = in.nextLine();
		int[] cont = new int[26];
		Arrays.fill(cont,0);
		char[] message2 = message.toCharArray();

		for(int i= 0; i< 26; i++){
			char upper = (char) ('A'+ i) ;
			char f2 = (char) ('a'+ i) ;
			for (int j = 0; j < message.length(); j++){
					if(message2[j]==f2 || message2[j] == upper ) cont[i]++;
			}
		}


		for(int k = 0; k< 26 ; k++){
			int  c = 'A' + k;
			char d = (char) c;
			if(cont[k] != 0) {
				System.out.printf(cont[k]+":") ;
				for(int h = 0; h< cont[k]; h++){
					System.out.print(d);
				}
				System.out.printf("\n");
			}
		}

 	}

 	
 }
 
