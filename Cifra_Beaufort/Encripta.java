
public class Encripta {
    
    private String chave;
    private String message;

    public void getkey(String a){
        chave = a;
    }

    public void getmessage(String a){
        this.message = a;
    }


    public void printmessage(){
        System.out.println(message);
    }
    
    public void encripta(){
        
        StringBuilder s = new StringBuilder(message);
        int espacos = 0; 
        for(int i = 0; i < message.length(); i++){
            if(message.charAt(i)== ' '){
                espacos++;
                continue;
            }
            int a = message.charAt(i) - 65; 
            int b = chave.charAt(((i-espacos) % chave.length())) - 65;
            int c = (b-a) % 26;
            if(c < 0) c= c+ 26;
            s.setCharAt(i, (char)(c+65));
        }

        message = s.toString();
    }


    public void decripta(){
        
    }
    
}