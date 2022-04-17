import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;

public class Literal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.equals("true")||line.equals("false")){
            System.out.println("boolean");
        }
        else if (line.endsWith("l") || line.endsWith("L")){
            System.out.println("long");
        }
        else if (line.endsWith("F")||line.endsWith("f")){
            System.out.println("float");
        }
        else if (line.endsWith("\"")){
            System.out.println("String");
        }
        else if (line.endsWith("\'")){
            System.out.println("char");
        }
        else if (line.contains(".")){
            System.out.println("double");
        }
        else {
            System.out.println("integer");
        }
    }
}
