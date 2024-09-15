package assignment1;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.GregorianCalendar;
import java.lang.Math;

public class Wlodawski_Mark {
	public static void main (String[] args ) {
		
		// Print receipt header
		System.out.println("******************************");
		System.out.println("****** S store ***************");
		System.out.println("******************************");
		// Generate random receipt number between 1000 and 2000, 2000 exclusive, 1000 inclusive
		generateReceiptNumber();
		
		// Generate random date in the format (Month Day Year) between 1900 & 2100(exclusive), day is 1-28(both inclusive)
		generateDate();
	
		// Function with Scanner class to accept input for item names & prices, must enter DONE to finish
		getInputFromScanner();
			
		// Print receipt footer
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("******************************");

	}
	
	public static String getInputFromScanner() {
		
		Scanner scanner = new Scanner(System.in);
		double itemPrice = 0.0;	
		double totalPrice = 0.0;
		double itemPriceWithTax = 0.0;
		String itemName = "";
		int itemCount = 0;
		
		// Check if user has input the word DONE
		do {
			System.out.print("Write item name. Type DONE when finished.: ");
			itemName = scanner.next();
			
			// Capitalize first letter of the item's name
			String itemNameCap = itemName.substring(0,1).toUpperCase() + itemName.substring(1);
			
			// Break out of loop if DONE is entered
			if (itemNameCap.equals("DONE")) {
				break;
			}
			System.out.print("Write price: ");
			itemPrice = scanner.nextDouble();
			itemCount++;
			
			// Check if name of item is "food" for tax calculation
			// For tax rate: food tax rate=0, other items tax = 30%
			if (itemName.equalsIgnoreCase("food")) {
				itemPriceWithTax = itemPrice;
			} else {
				itemPriceWithTax = itemPrice * 1.3;
			}
			totalPrice = totalPrice += itemPriceWithTax;
			System.out.println("Item number " + itemCount + " " + itemNameCap + "   " + Math.round(itemPriceWithTax));
		} while (!itemName.equals("DONE"));	// End of Loop
		System.out.println(itemCount + " items" + "      " + "Total " + Math.round(totalPrice));
				
		return "";
	}
	
	// Method to generate random receipt numbers
	public static void generateReceiptNumber() {
		Random rand = new Random();
		int max = 2000,min=1000;
		System.out.println("Receipt Number" + "      " + rand.nextInt(max - min + 1) + min);
		
	}
	
	// Method to generate random number
	public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
		
	}
	
	// Method to generate random dates
	public static void generateDate() {
		GregorianCalendar Calendar = new GregorianCalendar();
		
		// Format month to display name
		String month = Calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		
		// Use randBetween method to limit years and days to be output
		int year = randBetween(1900,2100);
		int day = randBetween(1,28);
		
		Calendar.set(Calendar.YEAR,  year);
		Calendar.set(Calendar.DAY_OF_MONTH, day);
		
		// Calculate random day of year
		int dayOfYear = randBetween(1, Calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		Calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		
		System.out.println(new SimpleDateFormat("MMMM").format(Calendar.get(Calendar.MONTH)) + " " + Calendar.get(Calendar.DAY_OF_MONTH) + " " + Calendar.get(Calendar.YEAR)); 
		
	}

}
