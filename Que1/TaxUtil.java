//Que 1: Would you consider the method calculateTax() a 'pure function'? Why or why not?

import java.util.Scanner;

public class TaxUtil{
    double rate = 0.15;

    public double calculateTax(double amount){
        return amount * rate;
    }

    // This method CalculateTax is not a Pure Function, as it cannot return the same output for the same input i.e. the same amount.
    // For eg: Let the amount be 1000, then the tax will be 150.
    // But if the rate is changed to 0.2(say), then the tax for the same amount will be 200.
    // Since this function cannot return the same output for the same input, it is not a Pure Function.

    //However, we can make this method a Pure Function by also passing the rate as a parameter.
    // This will ensure that it returns the same output for the same input.
    // Also, as it's not modifying either the rate or the amount, it follows the rules of a Pure Function.

    public double calculateTax_Pure(double amount, double rate){
        return amount * rate;
    }

    // Now the calculateTax_Pure method is a Pure Function, as it will always return the same output for the same input.

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount: ");
        int amount = sc.nextInt();
        TaxUtil tax = new TaxUtil();
        System.out.println("Tax on " + amount + " is: " + tax.calculateTax_Pure(amount, tax.rate));
        sc.close();
    }
}