import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ZTransformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char str[] = line.toCharArray();

        line = sc.nextLine();
        int rows = Integer.parseInt(line);

        int strLength = str.length;
        int i = 0;
        int j = 0;
        int indexOfStr = 0;
        char arr[][] = new char[rows][100];

        if (rows == 1){
            while (indexOfStr<strLength-1){
                System.out.print(str[indexOfStr]+" ");
                indexOfStr++;
            }
            System.out.println(str[indexOfStr]);
        }
        else {
            while (indexOfStr < strLength){
                int judgePoin = j%(rows-1);
                if(judgePoin == 0){
                    for (i=0;i<rows;i++){
                        if (indexOfStr>=strLength){
                            break;
                        }
                        arr[i][j] = str[indexOfStr];
                        indexOfStr++;
                    }
                    j++;
                }
                else {
                    for (i=0; i<rows; i++){
                        if (i == rows-1-judgePoin){
                            if (indexOfStr>=strLength){
                                break;
                            }
                            arr[i][j] = str[indexOfStr];
                            indexOfStr++;
                            j++;
                        }
                        else {
                            arr[i][j] = ' ';
                        }
                    }
                }
            }
        }

        int cols = j;
        String result = "";
        for (i=0;i<rows;i++){
            line = "";
            for (j=0;j<cols;j++){
                if ((int)arr[i][j] == 0){
                    arr[i][j] = ' ';
                }
                line = line+(arr[i][j])+" ";
            }
            line = line.trim();
            if (i < rows-1) {
                line = line + "\n";
            }
            result = result + line;
        }

        System.out.print(result);
    }
}