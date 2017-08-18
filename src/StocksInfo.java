public final class StocksInfo {
	private final String stockName;
	private final double price;

	StocksInfo(String stockName, double price) {
		this.stockName = stockName;
		this.price = price;
	}

	public String getStockName() {
		return stockName;
	}

	public double getPrice() {
		return price;
	}
}