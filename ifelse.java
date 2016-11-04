/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifelse;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;
/**
 *
 * @author patrickbenitez
 */
public class IfElse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        taxPayer Patrick = new taxPayer();
        Patrick.askStatus();
        Patrick.returnTax();
        Patrick.printStatus();
    }
    
    private static class taxPayer {
    
        private taxPayer() {
            employmentStatus = null;
            income = 0;
        }
        
        private void askStatus() {
            try {
                InputStreamReader reader = new InputStreamReader (System.in);
                BufferedReader console = new BufferedReader(reader);
            
                System.out.println("What is your employment status?\n" );
                System.out.println("'E' for employed");
                System.out.println("'U' for unemployed");
                employmentStatus = console.readLine();;
                
                System.out.println("What is your income?");
                String temp = console.readLine();
                income = Double.parseDouble(temp);
            }
            catch(IOException e) {
                System.out.println(e);
                System.exit(1);
            }
        }
        
        private void returnTax() {
            double tax = 0;
           
            final double rate1 = 0.15;
            final double rate2 = 0.25;
            final double rate3 = 0.28;
            final double rate4 = 0.33;
            final double rate5 = 0.35;
            
            final double singleCutoff1 = 37650;
            final double singleCutoff2 = 91150;
            final double singleCutoff3 = 190150;
            final double singleCutoff4 = 413350;
            final double singleCutoff5 = 415050;
            
            if(employmentStatus.equalsIgnoreCase("E")){
                if (income <= singleCutoff1)
                    tax = rate1 * income;
                else if (income <= singleCutoff2)
                    tax = rate2 * income;
                else if (income <= singleCutoff3)
                    tax = rate3 * income;
                else if (income <= singleCutoff4)
                    tax = rate4 * income;
                else if (income <= singleCutoff5)
                    tax = rate5 * income;
            }
            
            else {
                tax = 0;
            }
            System.out.println("You pay $" + tax +" in taxes.");
        }
        
        public String returnStatus() {
            String temp;
            if (employmentStatus.equals("e")) 
                temp = "You are employed and your income is: " + income;
            else if (employmentStatus.equals("E"))
                temp = "You are employed and your income is: " + income;
            else if (employmentStatus.equals("u"))
                temp = "You are unemployed and you should contribute back to society: " + income;
            else if (employmentStatus.equals("U"))
                temp = "You are unemployed and you should contribute back to society: " + income;
            else
                temp = "You entered a wrong employment status value. Try again.";
            return temp;
        }   
        
        public void printStatus() {
            System.out.println("Your employment status is: " + employmentStatus);
            System.out.println("Your income is: " + income);
        }
        
        String employmentStatus;
        double income;
    }
}
