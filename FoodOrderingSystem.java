package com.vikram.casestudy;

import java.util.Scanner;

public class FoodOrderingSystem {
	int id;
	String CustomerName;
	String FoodItem;
	int extraItem = 0;

	FoodOrderingSystem(int id, String CustomerName) {
		this(id, CustomerName, "not ordered");

	}

	FoodOrderingSystem(int id, String CustomerName, String FoodItem) {
		this.id = id;
		this.CustomerName = CustomerName;
		this.FoodItem = FoodItem;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter orderId");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("enter customer Name:");
		String CustomerName = scanner.nextLine();
		System.out.println("enter the FoodItem");
		String FoodItem = scanner.next();
		System.out.println("number of quantities");
		int Quantities = scanner.nextInt();
		System.out.println("Price");
		int price = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Do you want extra item? (yes/no)");
		String choice = scanner.nextLine();
		int extra = 0;
		if (choice.equalsIgnoreCase("yes")) {
			System.out.println("enter the extraItem name ");
			scanner.nextLine();
			System.out.println("Enter Extra Item Price:");
			extra = scanner.nextInt();
		}

		FoodOrderingSystem f = new FoodOrderingSystem(id, CustomerName, FoodItem);

		f.addExtraItem(extra);
		int bill = f.calculateBill(price, Quantities);

		f.displayOrder(price, Quantities, bill);
		if (bill > 1000) {
			System.out.println("discount applied 10%");
			int discount = 10;
			f.discount(discount, bill);
		}

		scanner.close();
	}

	public int calculateBill(int price, int quantities) {
		int bill = 0;
		if (extraItem > 0)
			bill = (price * quantities) + extraItem;

		else {
			bill = price * quantities;
		}
		return bill;

	}

	public void addExtraItem(int extraItem) {
		this.extraItem = extraItem;

	}

	public void displayOrder(int price, int quantities, int bill) {
		System.out.println("\n------ Order Details ------");
		System.out.println("Customer Id is :" + id);
		System.out.println("Customer Name is :" + CustomerName);
		System.out.println("Food Item is :" + FoodItem);
		System.out.println("number of quantities:" + quantities);
		System.out.println("extra item price :" + extraItem);
		System.out.println("Price of the Item:" + price);
		System.out.println("total bill:" + bill);
	}

	public void discount(int discount, int bill) {
		int dis = (bill * discount) / 100;
		int finalAmount = bill - dis;
		System.out.println("Total bill after discount:" + finalAmount);

	}

}
