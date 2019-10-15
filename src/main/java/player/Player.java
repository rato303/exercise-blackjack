package player;

import card.Card;
import deck.Deck;

public interface Player {

    /**
     * プレイヤーが山札からカードを取得します。
     *
     * @param deck カードを取得する山札
     *
     * @return 取得したカード
     */
    Card draw(final Deck deck);

    int getSum();

    boolean isBurst();

    boolean isDraw();

    /**
     * 手札を出力します。
     */
    void showHandCards();

    /**
     * 現在の得点を出力します。
     */
    void showScore();

}
