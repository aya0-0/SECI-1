import java.io.*;
import java.util.Scanner;

public class MatrixRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int matrix[][] = new int[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int degree = sc.nextInt();
        int judgePoint = (degree/90)%4;
        if (judgePoint == 0){
            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++){
                    System.out.print(matrix[i][j]);
                    if (j != cols-1){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        else if (judgePoint == 1){
            for (int j=0;j<cols;j++){
                for (int i=rows-1;i>=0;i--){
                    System.out.print(matrix[i][j]);
                    if (i != 0){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        else if (judgePoint == 2){
            for (int i=rows-1;i>=0;i--){
                for (int j=cols-1;j>=0;j--){
                    System.out.print(matrix[i][j]);
                    if (j != 0){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        else {
            for (int j=cols-1;j>=0;j--){
                for (int i=0;i<rows;i++){
                    System.out.print(matrix[i][j]);
                    if (i != rows-1){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
