package order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.QRpay;

import pizza.Pizza;
import pizza.SizeSmall;

public class Order {

	public ArrayList<Pizza> pizzas  = new ArrayList<Pizza>(); 
	public String orderID;
	public double total;
	public String orderDate;
	
	
	public double calTotalWithTax(double amount) { //
		System.out.println("6% Tax Applied to total");
		return amount*106/100;
	}
	
	
	public ArrayList<Pizza> addPizza(ArrayList<Pizza>  currentPizzas){//
		
		Pizza p = new SizeSmall();
		
		currentPizzas.add(p.createPizza());
		
		return currentPizzas;
		
	}
	
	public static void showPizzaOrder(ArrayList<Pizza>  currentPizzas) {//
	
		if(!currentPizzas.isEmpty()) {
			
			for(int i = 0; i< currentPizzas.size(); i++ ) {
				System.out.println("Created Pizzas");
				System.out.println("-----------------------");
				System.out.println("Pizza Index: " +i);
				System.out.println("Pizza Size: " + currentPizzas.get(i).size);
				System.out.println("Pizza Toppings: " + currentPizzas.get(i).toppings.toString().replace("[", "").replace("]", "") );
				System.out.println("Pizza Price: " + currentPizzas.get(i).totalPrice);
			
			}
		}else {
			System.out.println("No Pizzas Have Been Made");
		}
		
	}
	
	public ArrayList<Pizza> rmvPizza(ArrayList<Pizza> currentPizzas) {
	    if (!currentPizzas.isEmpty()) {
	        showPizzaOrder(currentPizzas);

	        while (true) {
	            System.out.println("Enter Pizza Index To Remove Pizza or Enter -1 to Cancel: ");
	            Scanner proceedScan = new Scanner(System.in);
	            int selectedOption = proceedScan.nextInt();

	            try {
	                if (selectedOption < currentPizzas.size()) {
	                    currentPizzas.remove(selectedOption);
	                    break;
	                } else if (selectedOption == -1) {
	                    break;
	                } else {
	                    System.out.println("Invalid Selection");
	                }
	            } catch (Exception e) {
	                System.out.println("Invalid Value Entered.");
	            }
	        }
	    } else {
	        System.out.println("No Pizzas Have Been Made");
	    }

	    return currentPizzas;
	}
	
	
	public static void genReceipt(Order order) {//
		System.out.println("------------------------");
		System.out.println("-----Receipt------");
		System.out.println("-----OrderId------");
		System.out.println(order.orderID);
		System.out.println("-----Order Date------");
		System.out.println(order.orderDate);
		System.out.println("-----Ordered Pizzas------");
		showPizzaOrder(order.pizzas);
		System.out.println("-----Total After 6% Tax------");
		System.out.println(order.total);
		System.out.println("------------------------");
	}

	
	
	
	public void orderPizza(Order order) {
	    while (true) {
	        System.out.println("-----------------------");
	        System.out.println("1 AddOrder\n2 ViewOrder\n3 Remove Pizza From Order\n4 Pay For Ordern\n5 Cancel Order\nPlease Enter the corresponding number to proceed:");
	        Scanner selectionScan = new Scanner(System.in);
	        String sizeIndex = selectionScan.next();

	        if (sizeIndex.trim().equals("1")) {
	            order.pizzas = addPizza(order.pizzas);
	        } else if (sizeIndex.trim().equals("2")) {
	            showPizzaOrder(order.pizzas);
	        } else if (sizeIndex.trim().equals("3")) {
	            order.pizzas = rmvPizza(order.pizzas);
	        } else if (sizeIndex.trim().equals("4")) {
	            if (!order.pizzas.isEmpty()) {
	            	Payment.payOrder(order);
	                System.out.println("Order Ended");
	                break;
	            } else {
	                System.out.println("No Pizzas Added");
	            }
	        } else if (sizeIndex.trim().equals("5")) {
	            order = null;
	            System.out.println("Order Canceled.");
	            break;
	        } else {
	            System.out.println("Invalid Input. Please Try Again.");
	        }
	    }
	}

	

	
	
	
}


