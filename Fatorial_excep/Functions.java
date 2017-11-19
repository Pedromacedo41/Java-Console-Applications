

public class Functions{

	public static char NextChar(char c){
    	if( c == 'z'){
    		return 'a';

    	}else{
    		return c++;
    	}
    }

    public static StringBuilder  Inverte(StringBuilder a){


        return a;

    }

    

    public StringBuilder Substitui(StringBuilder  a , char c){

        for (int i=0; i < a.length(); i++){
            if (a.charAt(i) == c) a.setCharAt(i,'#');
        }

    	return a;
    }

    public int cont(StringBuilder  a , char c){

        int cont =0;

        for (int i=0; i < a.length(); i++){
            if (a.charAt(i) == c) 
            cont ++;
        }
        return cont;
    }



    public static boolean notLetra(char c){
        if (c < 'a' || c > 'z') return true;
        else return false;
    }



    public static boolean SoLetras(String a){
        for (int i=0; i < a.length(); i++){
            if (notLetra(a.charAt(i)))  return true;
        }
        return false; 
    }

}