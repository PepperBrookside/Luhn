package com.zackparr;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        String cardNum;
        do{
            System.out.println("Please enter a card number:");
            cardNum = scan.nextLine();
        }while(!isNumeric(cardNum));

        int result = luhnAlgorithm(cardNum);

        if(result % 10 == 0){
            System.out.println("Valid account number");
        } else {
            System.out.println("Invalid account number");
        }

    }

    public static boolean isNumeric(String s){
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    public static int luhnAlgorithm(String num){
        num = new StringBuffer(num).reverse().toString();
        int sum = 0;
        int x;

        for(int i=0; i<num.length(); i++){
            x = Integer.parseInt(String.valueOf(num.charAt(i)));

            if(i%2==1){
                x = x * 2;
                if(x>9){
                    x -= 9;
                }
            }
            sum += x;
        }

        return sum;

    }
}
