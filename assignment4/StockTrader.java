
import java.util.Scanner;
// stocktrade class encompasses all methods and subclasses
class StockTrader{

	// main controls program flow and all function handling
	public static void main(String[]args){
		System.out.println("___________________________________");
		Deque stocks = new Deque();

		Scanner s = new Scanner(System.in);
		String trade = "";
		System.out.println("Enter trades in the form:");
		System.out.println("B/S shares price");
		System.out.println("EXAMPLE : 'B 150 20'");
		System.out.println("(Enter : 'D 0 0' to exit)");
		
		while (!trade.equals("done")){
		//while (!trade.equals("")){
			System.out.print(">>  ");
			trade = s.nextLine();
			String[] parts = trade.split(" ");

			// line is parsed into three variables
			char buysell = parts[0].charAt(0);
			int amount = Integer.parseInt(parts[1]);
			int price = Integer.parseInt(parts[2]);

			// char buysell determines whether or not
			// to call buy or sell function
			if (buysell == 'B')
				stocks = buyStock(amount, price, stocks);
			else if (buysell == 'S')
				stocks = sellStock(amount, price, stocks);
		}
		stocks.printDeque();
	}

	// buys a new stock at specified amount and price
	public static Deque buyStock(int amount, int price, Deque stocks){
		stocks.enqueueFront(price, amount);
		String buyResult = "Buy " + amount + " shares at $" + price + " each.";
		System.out.println(buyResult);
		return stocks;
	}

	// sells a specified amount of stocks at price
	public static Deque sellStock(int sellAmount, int sellPrice, Deque stocks){
		
		// sellLimit limits the loop from taking more shares
		// than it requires
		int sellLimit = sellAmount;

		// totalSale is how much money will be made from
		// the sale, whether there were gains or losses
		int totalSale = sellAmount * sellPrice;

		// origSale keeps track of what the 
		// stock were originally purchased for
		int origSale = 0;

		// capitalGain ends up being the difference
		// of totalSale - origSale
		int capitalGain = 0;

		// a simple boolean variable which tells whether
		// or not a sale was made or if not enough stocks
		boolean saleMade = true;
		
		// if no stocks are left, nothing is done
		if (stocks.isEmpty()){
			System.out.println("You do not have any shares left");
			sellLimit = 0;
			saleMade = false;
		}
		// if user is trying to sell more shares than existent,
		// then the program sells whatever is left
		else if (stocks.totalStocks() < sellAmount){
			sellLimit = stocks.totalStocks();
			System.out.println("You only hade " + sellLimit + " shares to sell");
			totalSale = sellLimit * sellPrice;
			sellAmount = sellLimit;
		}

		// while there are still shares to be sold, this loop runs
		while (sellLimit > 0){

			// if the back of the deque contains less/equal waht
			// the sellLimit requires, whatever is there is taken/sold
			// and the back is dequeued
			if (stocks.back.amount-sellLimit <= 0){
				origSale += stocks.back.amount * stocks.back.price;
				stocks.back.amount -= sellLimit;
				sellLimit = Math.abs(stocks.back.amount);
				stocks.dequeueBack();
			}
			
			// if there are sufficient stocks in the back
			// then they are taken and everything is OK
			else{
				origSale += sellLimit * stocks.back.price;
				stocks.back.amount -= sellLimit;
				sellLimit = 0;
			}
		}

		// if a sale actually occurred,
		// goes through if else to format a print statement
		// for a profit, loss, or an even break
		if (saleMade){
			capitalGain = totalSale - origSale;
			String sellResult = "Sell " + sellAmount + " shares at $" + sellPrice + " each";
			System.out.println(sellResult);
			
			if (capitalGain > 0)
				System.out.println("Profit : $" + capitalGain + ".00");
			else if (capitalGain < 0)
				System.out.println("Loss   : $" + -1*capitalGain + ".00");
			else
				System.out.println("No profit or loss occurred");
		}

		return stocks;
	}

	// straightforward deque
	static class Deque{

		// three member variables
		public Node front;
		public Node back;
		
		// constructor which creates an empty deque
		public Deque(){
			front = null;
			back = null;
		}
		
		// returns true if deque empty
		public boolean isEmpty(){
			return (front == null);
		}

		// returns front of deque if existent
		public Node peekFront(){
			if (front == null){
				return null;
			}
			return front;
		}

		// returns back of deque if existent
		public Node peekBack(){
			if (back == null){
				return null;
			}
			return back;
		}

		// enqueues new node to the front of deque
		public void enqueueFront(int price, int amount){
			Node newTrade = new Node(price, amount);
			newTrade.next = front;
			if (isEmpty())
				back = newTrade;
			else
				front.prev = newTrade;
			front = newTrade;
		}
		
		// enqueues new node to the back of deque
		public void enqueueBack(int price, int amount){
			Node newTrade = new Node(price, amount);
			newTrade.prev = back;
			if (isEmpty())
				front = newTrade;
			else
				back.next = newTrade;
			back = newTrade;
		}

		// dequeues node from the front of deque
		public void dequeueFront(){
			if (isEmpty())
				System.out.println("This deque is empty");
			else{
				front = front.next;
				if (front != null)
					front.prev = null;
				else
					back = front;
			}
		}

		// dequeues node from the back of deque
		public void dequeueBack(){
			if (isEmpty())
				System.out.println("This deque is empty");
			else{
				back = back.prev;
				if (back != null)
					back.next = null;
				else
					front = back;
			}
		}

		// prints a formatted version of the deque
		// showing the stocks on the deque 
		// including share amounts and prices
		public void printDeque(){
			Node current = front;
			System.out.println("________________________");
			if (isEmpty()){
				System.out.println("No Stocks remain");
			}
			else{
				System.out.println("--- Remaining stocks ---");

				while (current != null){
					System.out.println("$" + String.valueOf(current.price) + " " + String.valueOf(current.amount) + " shares.");
					current = current.next;
				}
			}
			System.out.println("________________________");
		}
		
		// returns total share amount of the entire deque
		public int totalStocks(){
			int total = 0;
			Node current = front;
			while (current != null){
				total += current.amount;
				current = current.next;
			}
			return total;
		}
	}

	// modified node which contains two elements
	static class Node{
		
		int price;
		int amount;
		Node prev;
		Node next;

		// stock amount and price are the two elements required for every node
		public Node(int price, int amount){
			this.price = price;
			this.amount = amount;
		}	
	}
	
}