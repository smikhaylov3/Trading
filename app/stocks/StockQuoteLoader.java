package stocks;

import java.util.concurrent.ThreadLocalRandom;
import java.io.IOException;
import yahoofinance.*;
import java.math.BigDecimal;

public class StockQuoteLoader implements StockQuoteGenerator {

    private final String symbol;
    private Stock stock;
    public StockQuoteLoader(String symbol) {
        this.symbol = symbol;
        try {
            stock = YahooFinance.get(symbol);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private Double random() {
        try {
            BigDecimal price = stock.getQuote(true).getPrice();
            return price.doubleValue();
        } catch(IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }



    @Override
    public StockQuote newQuote(StockQuote last) {
        return new StockQuote(last.symbol, random());
    }

    @Override
    public StockQuote seed() {
        return new StockQuote(symbol, random());
    }
}
