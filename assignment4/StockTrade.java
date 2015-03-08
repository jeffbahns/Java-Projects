import java.util.Scanner;

// stocktrade class encompasses all methods and subclasses
class StockTrade {
	
	// ***
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
			trade = s.nextLine();
			String[] parts = trade.split(" ");
			char buysell = parts[0].charAt(0);
			int amount = Integer.parseInt(parts[1]);
			int price = Integer.parseInt(parts[2]);

			if (buysell == 'B')
				stocks = buyStock(amount, price, stocks);
			else if (buysell == 'S')
				stocks = sellStock(amount, price, stocks);
			else
				trade = "done";
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
		
		int totalSale = sellPrice * sellAmount;
		int sellLimit = sellAmount;
		int origSale = 0;
		int capitalGains = 0;

		while (sellLimit > 0){
			
			if (stocks.isEmpty()){
				System.out.println("You have no more stocks to sell");
				sellLimit = 0;
			}

			else if (stocks.back.amount-sellLimit < 0){
				origSale += stocks.back.amount * stocks.back.price;
				stocks.back.amount -= sellLimit;
				sellLimit = Math.abs(stocks.back.amount);
				stocks.dequeueBack();
			}

			else{
				stocks.back.amount -= sellLimit;
				origSale += sellLimit * stocks.back.price;
				sellLimit -= sellLimit;
			}

		}

		String sellResult = "Sell " + sellAmount + " shares at $" + sellPrice + " each.";
		System.out.println(sellResult);
		System.out.println("TOTAL SALE: $" + totalSale);
		System.out.println("ORIG SALE : $" + origSale);
		if (origSale > totalSale)
			System.out.println("Loss   : $" + Integer.valueOf(origSale - totalSale));
		else if (origSale < totalSale)
			System.out.println("Profit : $" + Integer.valueOf(totalSale - origSale));
		else
			System.out.println("You neither gained nor lost");

		return stocks;
	}

}