
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {

		private List<StocksInfo> stockInfoList = new CopyOnWriteArrayList<>();
		
		Map<String,Double> symbolToAveragePriceMap;
		
		Map<String, Long> symbolToCountMap;
		
		String lock1,lock2;
		
		@Override
		public void putNewPrice(String symbol, double price) {
		// YOUR CODE HERE
			StocksInfo symbolObj = new StocksInfo(symbol, price);
			stockInfoList.add(symbolObj);
			System.out.println(stockInfoList.size());
		}

		@Override
		public double getAveragePrice(String symbol) {
			// YOUR CODE HERE
			System.out.println(stockInfoList.size());
			System.out.println(stockInfoList);
			if(symbolToAveragePriceMap==null){
				synchronized (lock1) {
					symbolToAveragePriceMap = stockInfoList.stream().collect(Collectors.groupingBy(
							StocksInfo::getStockName,Collectors.averagingDouble(StocksInfo::getPrice)
							));
					}
				}
			System.out.println(symbolToAveragePriceMap);
			return symbolToAveragePriceMap.get(symbol);
		}

		@Override
		public int getTickCount(String symbol) {
			// YOUR CODE HERE
			System.out.println(stockInfoList.size());
			if(symbolToCountMap==null){
				synchronized(lock2){
					symbolToCountMap = stockInfoList.stream().collect(Collectors.groupingBy(
					StocksInfo::getStockName,Collectors.counting()
					));
				}
			}
			System.out.println(symbolToCountMap);
			return symbolToCountMap.get(symbol).intValue();
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
