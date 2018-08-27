package actors;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import stocks.StockWrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * This actor contains a set of stocks internally that may be used by
 * all websocket clients.
 */
public class StocksActor extends AbstractActor {

    private final Map<String, StockWrapper> stocksMap = new HashMap<>();

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Messages.WatchStocks.class, watchStocks -> {
                    Set<StockWrapper> stocks = watchStocks.symbols.stream()
                            .map(symbol -> stocksMap.compute(symbol, (k, v) -> new StockWrapper(k)))
                            .collect(Collectors.toSet());
                    sender().tell(new Messages.Stocks(stocks), self());
                }).build();
    }
}
