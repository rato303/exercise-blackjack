package card;

public class Card {

    private final Mark mark;
    private final CardType cardType;

    public Card(final Mark mark, final CardType cardType) {
        this.mark = mark;
        this.cardType = cardType;
    }

    public int getValue() {
        return this.cardType.value;
    }

    public String asText() {
        return this.mark.getLabel() + "の" + this.cardType.label;
    }

}
