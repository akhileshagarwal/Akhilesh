
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Stats2 {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {

		private List<StocksInfo> stockInfoList = new CopyOnWriteArrayList<>();
		
		private Map<String,Double> symbolToAveragePriceMap;
		
		private Map<String, Long> symbolToCountMap;
		
		@Override
		public void putNewPrice(String symbol, double price) {
		// YOUR CODE HERE
			StocksInfo symbolObj = new StocksInfo(symbol.trim(), price);
			stockInfoList.add(symbolObj);
		}

		@Override
		public double getAveragePrice(String symbol) {
			// YOUR CODE HERE
			if(symbolToAveragePriceMap==null){
					symbolToAveragePriceMap = stockInfoList.stream().collect(Collectors.groupingBy(
							StocksInfo::getStockName,Collectors.averagingDouble(StocksInfo::getPrice)
							));
				}
			return symbolToAveragePriceMap.get(symbol);
		}

		@Override
		public int getTickCount(String symbol) {
			// YOUR CODE HERE
			if(symbolToCountMap==null){
					symbolToCountMap = stockInfoList.stream().collect(Collectors.groupingBy(
					StocksInfo::getStockName,Collectors.counting()
					));
			
			}
			return symbolToCountMap.get(symbol).intValue();
		}
		
		public final class StocksInfo{
			private final String stockName;
			private final double price;
			
			private StocksInfo(String stockName,double price) {
				this.stockName = stockName;
				this.price = price;
			}
			
			@Override
			public String toString() {
				return "StocksInfo [stockName=" + stockName + ", price=" + price + "]";
			}

			public String getStockName() {
				return stockName;
			}
			public double getPrice() {
				return price;
			}
		}
		
	}
	
	

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}
