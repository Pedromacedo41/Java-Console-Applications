import java.util.Scanner;


public class Beaufort {

    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        Encripta message = new Encripta();

        message.getkey("FURACAO");
        message.getmessage(a);
        message.encripta();
        message.printmessage();

        System.out.println((int) 'A');

    }

}