package handcardsopener;

import card.Card;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DealerHandCardsOpener implements HandCardsOpener {

    @Override
    public void show(List<Card> cards) {
        System.out.println("ディーラーの手札");
        final Stream<String> visibleStream = Stream.of(cards.get(0).asText());
        final Stream<String> maskedStream = cards.stream().skip(1).map(c -> "*");
        System.out.println(Stream.concat(visibleStream, maskedStream).collect(Collectors.joining(",")));
    }

}
