package player;

import card.Card;
import deck.Deck;
import handcardsopener.HandCardsOpener;

import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements Player {

    private final PlayerType playerType;
    private final List<Card> cards;

    public PlayerImpl(final PlayerType playerType) {
        this.cards = new ArrayList<>();
        this.playerType = playerType;
    }

    /**
     * プレイヤーが山札からカードを取得します。
     *
     * @param deck カードを取得する山札
     *
     * @return 取得したカード
     */
    @Override
    public Card draw(final Deck deck) {
        final Card drawCard = deck.draw();
        this.cards.add(drawCard);
        System.out.println(this.playerType.getLabel() + "の引いたカードは => " + drawCard.asText());
        return drawCard;
    }

    public int getSum() {
        return this.cards.stream().mapToInt(Card::getValue).sum();
    }

    @Override
    public boolean isBurst() {
        final int sum = this.cards.stream().mapToInt(c -> c.getValue()).sum();
        return 21 < sum;
    }

    @Override
    public boolean isDraw() {
        final int sum = this.cards.stream().mapToInt(c -> c.getValue()).sum();
        return sum < 17;
    }

    @Override
    public void showHandCards() {
        final HandCardsOpener handCardsOpener = this.playerType.getHandCardsOpener();
        handCardsOpener.show(this.cards);
    }

    @Override
    public void showScore() {
        final PlayingScoreOpener playingScoreOpener = this.playerType.getPlayingScoreOpener();
        playingScoreOpener.show(this.cards);
    }

    public void showPlayerCards() {
        final HandCardsOpener opener = this.playerType.getHandCardsOpener();
        opener.show(this.cards);

        System.out.println("あなたの点数 => " + this.getSum());
    }

    public void showDealerCards() {

        System.out.println(this.cards.get(0).getValue());
        this.cards.stream().skip(1).forEach((s) -> System.out.println("見せられないカード"));
    }

}
