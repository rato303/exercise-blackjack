package player;

import card.Card;

import java.util.List;

/**
 * プレイ中の得点を表示するインタフェース
 */
public interface PlayingScoreOpener {

    /**
     * プレイ中の得点を表示します。
     *
     * @param cards 手札
     */
    void show(final List<Card> cards);

}
