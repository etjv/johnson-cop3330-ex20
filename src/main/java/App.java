/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Edmund Johnson V
 */

import java.text.DecimalFormat;
import java.util.Scanner;

/*
More complex programs may have decisions nested in other decisions, so that when one decision is made, additional decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state. The program prompts the user for the order amount and the state where the order will be shipped.

Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt for the county of residence.
For Eau Claire county residents, add an additional 0.005 tax.
For Dunn county residents, add an additional 0.004 tax.
Illinois residents must be charged 8% sales tax with no additional county-level charge.
All other states are not charged tax.
The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone else.

Example Output
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The total is $10.50.
Constraints
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.
 */

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] arg){
        int amount = getAmount();
        System.out.println(taxCalculator(amount));
    }

    private static int getAmount(){
        System.out.print("What is the order amount? ");
        String x = in.nextLine();
        if(x.matches("[0-9]+")){
            return Integer.parseInt(x.replace(" ",""));
        }
        else{
            System.out.println("Enter only numerical digits!");
            return getAmount();
        }
    }


    private static String taxCalculator(int amount){
        DecimalFormat dc = new DecimalFormat("0.00");
        System.out.print("What state do you live in? ");
        String x = in.nextLine();
        if(x.equals("Wisconsin")){
            System.out.print("What county do you live in? ");
            String y = in.nextLine();
            if(y.equals("Eau Claire")){
                double tax = amount * 0.055;
                return "The tax is $" + dc.format(tax) + ".\nThe total is $" + dc.format((amount + tax)) + ".";
            }
            else if(y.equals("Dunn")){
                double tax = amount * 0.054;
                return "The tax is $" + dc.format(tax) + ".\nThe total is $" + dc.format((amount + tax)) + ".";
            }
            else{
                double tax = amount * 0.05;
                return "The tax is $" + dc.format(tax) + ".\nThe total is $" + dc.format((amount + tax)) + ".";
            }
        }
        else if(x.equals("Illinois")){
            double tax = amount * 0.08;
            return "The tax is $" + dc.format(tax) + ".\nThe total is $" + dc.format((amount + tax)) + ".";
        }
        else{
            return "The total is $" + dc.format(amount) + ".";
        }
    }
}
