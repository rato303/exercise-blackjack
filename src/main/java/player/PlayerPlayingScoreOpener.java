package player;

import card.Card;

import java.util.List;

public class PlayerPlayingScoreOpener implements PlayingScoreOpener{

    @Override
    public void show(List<Card> cards) {
        final int score = cards.stream().mapToInt(Card::getValue).sum();
        System.out.println("あなたの点数 => " + score);
    }

}
