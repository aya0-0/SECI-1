import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class CurrencyCalculation {
	public static void main(String[] args){
		System.out.println("How many euros are you exchanging?");
		Scanner in = new Scanner(System.in);
		double euros = in.nextDouble();
		System.out.println("What is the exchange rate?");
		double rate = in.nextDouble();
		double dollar = euros*rate*0.01;
		System.out.println(String.format("%.2f",euros)+" euros at an exchange rate of "+String.format("%.2f",rate)+" is "+String.format("%.2f",dollar)+" U.S. dollars.");
	}

}