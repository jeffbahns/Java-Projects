import java.util.Scanner;
class StockTrade {
	
	public static void main(String[]args){
		System.out.println("___________________________________");
		Deque stocks = new Deque();

		Scanner s = new Scanner(System.in);
		String trade = "";
		System.out.println("Enter trades in the form:");
		System.out.println("B/S price shares");
		//while (!trade.equals("done")){
		for (int i = 0; i < 3; i++){
			trade = s.nextLine();
			String[] parts = trade.split(" ");
			char buysell = parts[0].charAt(0);
			int price = Integer.parseInt(parts[1]);
			int amount = Integer.parseInt(parts[2]);
			
			if (buysell == 'B')
				stocks = buyStock(price, amount, stocks);
			else
				stocks = sellStock(price, amount, stocks);
		}
		stocks.printDeque();

	}

	public static Deque buyStock(int price, int amount, Deque stocks){
		stocks.enqueueFront(price, amount);
		String buyResult = "Buy " + amount + " shares at $" + price + " each.";
		System.out.println(buyResult);
		return stocks;
	}

	public static Deque sellStock(int sellPrice, int sellAmount, Deque stocks){
		int totalSale = sellPrice * sellAmount;
		int sellLimit = sellAmount;
		int origSale = 0;

		while (sellLimit > 0){

			stocks.back.amount -= sellLimit;
			if (stocks.back.amount < 0){
				sellLimit = Math.abs(stocks.back.amount);
				//sellAmount += stocks.back.amount;
				stocks.back.amount += Math.abs(stocks.back.amount);
			}
			else{
				sellLimit -= sellAmount;
			}

			origSale += sellAmount * stocks.back.price;
			//totalSale += sellAmount * sellPrice;
			if (stocks.back.amount == 0)
				stocks.dequeueBack();
		}

		String sellResult = "Sell " + sellAmount + " shares at $" + sellPrice + " each.";
		System.out.println(sellResult);
		System.out.println("TOTAL SALE: $" + totalSale);
		System.out.println("ORIG SALE : $" + origSale);
		if (origSale > totalSale)
			System.out.println("Loss   : $" + Integer.valueOf(origSale - totalSale));
		else if (totalSale < origSale)
			System.out.println("Profit : $" + Integer.valueOf(totalSale - origSale));
		else
			System.out.println("You neither gained nor lost");


	/*	~~ General Algorithm ~~

		int total = 0;
		int sellLimit = sellAmount

		*keep running until sellLimit = 0
		while sellLimit not reached

			*take as much as needed from stocks.back.amount without going over
			stocks.back.amount -= sellAmount
			
			if (stocks.back.amount < 0){
				sellLimit = abs(stocks.back.amount)
				sellAmount += stocks.back.amount
				stocks.back.amount += Math.abs(stocks.back.amount)
			}
			else{
				sellLimit -= sellAmount
			}

		
			total += sellAmount * stocks.back.price


			if (stocks.back.price == 0)
				stocks.dequeueBack
	*/



		
		
		return stocks;
	}

}