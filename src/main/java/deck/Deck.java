package deck;

import card.Card;
import card.CardType;
import card.Mark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 山札
 */
public class Deck {

    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>(52);
        Stream.of(Mark.values()).forEach(mark -> {
            Stream.of(CardType.values()).forEach(cardType -> {
                cards.add(new Card(mark, cardType));
            });
        });
    }

    /**
     * 山札からカードを一枚取得します。
     *
     * @return取得したカード
     */
    public Card draw() {
        return this.cards.remove(0);
    }

    /**
     * 山札をシャッフルします。
     */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

}
