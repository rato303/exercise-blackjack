package handcardsopener;

import card.Card;

import java.util.List;

/**
 * 手札を見せるインタフェース
 */
public interface HandCardsOpener {

    /**
     * 手札を表示します。
     *
     * @param cards 手札
     */
    void show(final List<Card> cards);

}
