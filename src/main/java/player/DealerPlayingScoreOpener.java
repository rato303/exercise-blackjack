package player;

import card.Card;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DealerPlayingScoreOpener implements PlayingScoreOpener {

    @Override
    public void show(List<Card> cards) {
        System.out.println("ディーラーの点数 => " + cards.get(0).getValue());
    }

}
