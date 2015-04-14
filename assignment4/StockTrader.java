
// jeff bahns
// assignment 4

import java.util.Scanner;
// stocktrade class encompasses all methods and subclasses
class StockTrader{

   /*
   	* method main controls program flow
	*
	* intro 
	* stocks		deque object where all stocks are stored
	* scan			scan object that grabs keyboard input
	* trade			string where scans are stored
	* parts			string array where each parsed input it stored
	* buysell		char which is either 'B' or 'S'
	* amount		contains amount of shares desired to buy/sell
	* price			contains buying/selling price
   	*/
	public static void main(String[]args){
		Deque stocks = new Deque();
		Scanner scan = new Scanner(System.in);
		String trade = " ";
		String intro = "_____________________________________\n"
					 + "| Enter trades in the form:          |\n"
					 + "| B/S shares price:                  |\n"
					 + "| EXAMPLE : 'B 150 20' OR 'S 10 5'   |\n"
					 + "| (To exit program, press return)    |\n"
					 + "|____________________________________|";
		System.out.println(intro);
		// while loop runs until scanner receives nothing
		// aka, return key is pressed after no input
		while (!trade.equals("")){
			System.out.print(">>  ");
			trade = scan.nextLine();

			if (!trade.equals("")){
				String[] parts = trade.split(" ");
				char buysell = parts[0].charAt(0);
				int amount = Integer.parseInt(parts[1]);
				int price = Integer.parseInt(parts[2]);
				
				if (buysell == 'B')
					stocks = buyStock(amount, price, stocks);
				else if (buysell == 'S')
					stocks = sellStock(amount, price, stocks);
			}
		}
	}

   /*
   	* method buyStock buys a new stock at specified amount and price
	*/
	public static Deque buyStock(int amount, int price, Deque stocks){
		stocks.enqueueFront(price, amount);
		String buyResult = "Buy " + amount + " shares at $" + price + " each.";
		System.out.println(buyResult);
		System.out.println("-----------------");
		return stocks;
	}

   /* 
   	* method sellStock sells a specified amount of stocks at price
   	*
	* sellLimit 	limits the loop from taking more shares than it requires
	* totalSale 	how much money will be made from the sale
	* origSale		keeps track of what the shares were originally purchased at
	* capitalGain	contains the difference of totalSale-origSale
	* saleMade		boolean that decides whether a sale occurred
	*/
	public static Deque sellStock(int sellAmount, int sellPrice, Deque stocks){
		
		int sellLimit = sellAmount;
		int totalSale = sellAmount * sellPrice;
		int origSale = 0;
		int capitalGain = 0;
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
		System.out.println("-----------------");
		return stocks;
	}

   /* 
   	* linked list implementation of a deque
   	*
   	* front 		node that is at front of deque
   	* back			node that is at back of deque
   	*
   	* Deque			single class constructor, creates empty deque
   	* isEmpty		return true if deque empty
   	* peekFront		returns front of deque
   	* peekBack		returns back of deque
   	* enqueueFront	enqueues new node to the front
   	* enqueueBack	enqueues new node to the back
   	* dequeueFront	dequeues node from the front
   	* dequeueBack	dequeues node from the back
   	* printDeque	prints a formatted version of the deque
   	* totalStocks	returns total share amount of the entire deque
	*/
	static class Deque{

		public Node front;
		public Node back;
		
		public Deque(){
			front = null;
			back = null;
		}
		
		public boolean isEmpty(){
			return (front == null);
		}

		public Node peekFront(){
			if (front == null){
				return null;
			}
			return front;
		}

		public Node peekBack(){
			if (back == null){
				return null;
			}
			return back;
		}

		public void enqueueFront(int price, int amount){
			Node newTrade = new Node(price, amount);
			newTrade.next = front;
			if (isEmpty())
				back = newTrade;
			else
				front.prev = newTrade;
			front = newTrade;
		}
		
		public void enqueueBack(int price, int amount){
			Node newTrade = new Node(price, amount);
			newTrade.prev = back;
			if (isEmpty())
				front = newTrade;
			else
				back.next = newTrade;
			back = newTrade;
		}

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

   /*
   	* node modified to be stock related
   	*
   	* price			element that contains price of a stock
   	* amount		element that contains amount of shares held
   	* prev			contains previous node
   	* next			contains next node
   	*
   	* Node			constructor, creates new node but requires price, amount
   	*/
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