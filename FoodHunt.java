import java.util.Scanner;

/*
* Author: Kanaja Hunt
* Date: Feb. 11, 2025
*
* Programming Assigment: Restaurant Food Ordering System
* Program Description: Application that presents the customer with a menu of the restaurant, 
let them choose the dishes from the menu, and show them the total price of the order implementing rounding
branching and looping concepts.
* Honor Code: I pledge that I will not cheat, help others to cheat, plagiarize, or otherwise
engage in any misrepresentation of my work
*
*/

public class FoodHunt {
    public static void main(String[]args){
      Scanner input = new Scanner(System.in);
      
      //declaring variables 
      int numDishes;
      double tax;
      double totalAmount = 0.0;
      double price = 0;
      int inputDish = 0; //need to initalize to 0 so i can access this var outside loop
      int numServing = 0; //need to initalize to 0 so i can access this var outside loop
      double sum;

      
      //displaying menu to user
      System.out.println("\tMenu");
      System.out.printf("%-20s %-5s", "Item", "Price");
      System.out.println("\n");
      System.out.printf("%-16s", "1 Chicken Curry");
      System.out.print("\t10.69");
      System.out.print("\n");
      System.out.printf("%-16s", "2 Oxtail Soup");
      System.out.print("\t14.00");
      System.out.println();
      System.out.printf("%-16s", "3 Banana Fritters");
      System.out.print("\t5.00");
      System.out.print("\n");
      System.out.printf("%-16s", "4 Rice and Peas");
      System.out.print("\t7.00");
      System.out.println();
      System.out.printf("%-16s", "5 Plantains");
      System.out.print("\t7.24");
      System.out.println();
      System.out.printf("%-16s", "6 Bake and Shark");
      System.out.print("\t10.00");
      System.out.println();
      System.out.printf("%-16s", "7 West indian Soup");
      System.out.print("\t8.00");
      System.out.println();
      System.out.printf("%-16s", "8 Homemade bread");
      System.out.print("\t12.00");
      System.out.println();
      System.out.printf("%-16s", "9 Saltfish");
      System.out.print("\t9.00");
      System.out.println();
      System.out.printf("%-16s", "10 Fresh fruit");
      System.out.print("\t4.99");
      System.out.println("\n");


    //getting user input
    System.out.print("How many different dishes would you like to order today?: " );
    numDishes = input.nextInt();

    //need to initalize dishCount to 0 so it will loop userInput amount of times --> must increment as well!
    int dishCount = 0;

    // keeping track / iterating how many dishes a user wants and their servings - while loop being implemented
    while(dishCount < numDishes){
      // getting dish and serving input from user
      System.out.print("Enter dish [1-10]: ");
      inputDish = input.nextInt();
  
      System.out.print("How many servings?: ");
      numServing = input.nextInt();

      // need to use switch case in order to make sure input is assigned w correct base pricing
      switch(inputDish){
        case 1:
            price = 10.69 * numServing;
            totalAmount += price;
            break;
        case 2:
            price = 14.00 * numServing;
            totalAmount += price;
            break;
        case 3:
            price = 5.00 * numServing;
            totalAmount += price;
            break;
        case 4:
            price = 7.00 * numServing;
            totalAmount += price;
            break;
        case 5:
            price = 7.24 * numServing;
            totalAmount += price;
            break;
        case 6:
            price = 10.00 * numServing;
            totalAmount += price;
            break;
        case 7:
            price = 8.00 * numServing;
            totalAmount += price;
            break;
        case 8:
            price = 12.00 * numServing;
            totalAmount += price;
            break;
        case 9:
            price = 9.00 * numServing;
            totalAmount += price;
            break;
        case 10:
            price = 4.99 * numServing;
            totalAmount += price;
            break;
        default:
            System.out.println("Invalid dish selection! Please select a dish between 1-10.");
            break;
    }
    dishCount++;

    }
    
    //user input - tax and tip
    System.out.print("Enter the tax percentage: ");
    tax = input.nextDouble();


    System.out.print("Would you like to tip? ['y' for yes, 'n' for no]: ");
    String userInputTip = input.next();


    // asking user for tip using switch case
    double tip = 0;
    // method that checks if a string equals user input
    if(userInputTip.equals("y")){
      System.out.print("Enter tip percentage [0-100]: ");
      tip = input.nextDouble();
    }

    else if(userInputTip.equals("n")){
      System.out.println("You're cheap. Calculating total. Please stand by");
    }
    
    else{
      System.out.println("Invalid response. Try again");
    }

    System.out.println();

    //calc tax and tip percentage
    double taxAmount;
    taxAmount = totalAmount * (tax / 100);


    double tipAmount;
    tipAmount = (totalAmount + taxAmount) * tip / 100;

    // sum
    sum = totalAmount + taxAmount + tipAmount;



      System.out.println("- - - - - - - - - - - - - - - - -");
      System.out.printf("Price: $%.2f", totalAmount);
      System.out.println();
      System.out.printf("Tax: $%.2f", taxAmount);
      System.out.println();
      System.out.printf("Tip: $%.2f", tipAmount);
      System.out.println();
      System.out.printf("Total Amount: $%.2f", sum);
      System.out.println();
      System.out.println("⢆⠀⠀⠀⠀⠀⠀⠀⠈⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
              "⠈⢆⠀⠀⠀⠀⠀⠀⠀⠘⡀⠀⠀⠀⠀⠀⠀⢀⠤⠄⠠⠄⡀⠀⠀\n" + //
              "⠀⠀⠣⡀⠀⠀⢀⣀⡀⠀⢡⠀⠀⠀⠀⢀⠔⠁⠀⠀⠀⠀⠈⢂⠀\n" + //
              "⠀⠀⡰⠉⠉⣱⠁⡀⠈⡆⠉⠉⠁⠀⠀⠁⠀⠸⠀⠀⠀⠀⠀⠀⠇\n" + //
              "⠀⠀⠳⣀⡌⠀⠀⢰⠘⢦⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀\n" + //
              "⠀⠀⠰⡁⠈⠐⣆⣁⡠⠊⠀⠀⠀⠀⠀⠀⠀⠀⢷⡀⠀⠀⠀⢀⠆\n" + //
              "⠀⠀⢠⠋⠀⠉⠀⠀⢀⡀⠤⠤⠤⠄⢀⡀⠀⠀⠀⠉⠓⠒⡆⠁⠀\n" + //
              "⠀⠀⡆⠀⠀⢀⠔⠉⠀⠀⠀⠀⠀⠀⠀⠀⠉⠲⢀⠀⠀⠀⢹⠀⠀\n" + //
              "⠀⠀⠇⠀⣠⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀⢸⠀⠀\n" + //
              "⠀⠀⠘⡄⢇⠴⠛⠉⠒⠀⠀⠀⡄⠀⠀⠠⠶⠒⢦⣀⠀⢀⠇⠀⠀\n" + //
              "⠀⠀⠀⠈⠺⣆⠀⠀⠀⠀⠀⠐⠐⠀⠀⠀⠀⠀⠀⢠⡠⠂⠀⠀⠀\n" + //
              "⠀⠀⠀⠀⠀⢈⠵⢢⠔⠈⠉⠑⢔⠉⠀⠑⢄⢤⠒⠁⠀⠀⠀⠀⠀\n" + //
              "⠀⠀⠀⠀⠀⢇⣠⠆⠀⠀⠀⠀⡘⠀⠀⠀⠈⣄⣵⠀⠀⠀⠀⠀⠀\n" + //
              "⠀⠀⠀⠀⠀⠀⡘⠄⠀⠀⠀⡐⠱⡀⠀⠀⠀⣾⠋⠀⠀⠀⠀⠀⠀\n" + //
              "⠀⠀⠀⠀⠀⠀⠁⠈⠀⢒⠈⠀⠀⠈⠐⠒⠊⠸⠀⠀⠀⠀⠀⠀⠀");
      System.out.println("- - - - - - - - - - - - - - - - -");

    }
}
