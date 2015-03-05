import java.util.Scanner;
class StockTrade {
	
	public static void main(String[]args){
		System.out.println("___________________________________");
		Deque stocks = new Deque();

		Scanner s = new Scanner(System.in);
		String trade = "";

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
		System.out.println("WE ARE SELLING!");
		//int priceDiff = sellPrice - stocks.back.price;
		int profitloss = sellPrice * sellAmount;
		String sellResult = "Sell " + sellAmount + " shares at $" + sellPrice + " each.";

		return stocks;
	}

}