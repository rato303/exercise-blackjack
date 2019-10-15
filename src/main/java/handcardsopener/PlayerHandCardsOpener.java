package handcardsopener;

import card.Card;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerHandCardsOpener implements HandCardsOpener {

    @Override
    public void show(List<Card> cards) {
        System.out.println("あなたの手札");
        System.out.println(cards.stream().map(Card::asText).collect(Collectors.joining(",")));
    }

}
