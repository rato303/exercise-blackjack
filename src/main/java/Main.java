import deck.Deck;
import player.Player;
import player.PlayerImpl;
import player.PlayerType;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("ブラックジャック START");
        System.out.println("ゲームを開始します。");

        final Deck deck = new Deck();
        deck.shuffle();

        final Player player = new PlayerImpl(PlayerType.PLAYER);
        player.draw(deck);
        player.draw(deck);
        player.showHandCards();
        player.showScore();

        if (player.isBurst()) {
            System.out.println("【あなた】バースト!");
            System.out.println("あなたの負けです");
            System.exit(0);
        }

        final Player dealer = new PlayerImpl(PlayerType.DEALER);
        dealer.draw(deck);
        dealer.draw(deck);

        dealer.showHandCards();
        if (dealer.isBurst()) {
            System.out.println("【ディーラー】バースト!");
            System.out.println("あなたの勝ちです");
            System.exit(0);
        }

        System.out.println("カードを引きますか？ Y:引く N:引かない Q:ゲームをやめる");
        final BufferedReader standardInputReader = new BufferedReader(new InputStreamReader(System.in));
        standardInputReader.lines().forEach((inputValue) -> {
            if ("Y".equals(inputValue)) {
                player.draw(deck);
                player.showHandCards();
                player.showScore();

                if (player.isBurst()) {
                    System.out.println("【あなた】バースト!");
                    System.out.println("あなたの負けです");
                    System.exit(0);
                }
                System.out.println("カードを引きますか？ Y:引く N:引かない Q:ゲームをやめる");
            }
            if ("N".equals(inputValue)) {
                while (dealer.isDraw()) {
                    dealer.draw(deck);
                    if (dealer.isBurst()) {
                        System.out.println("【ディーラー】バースト!");
                        System.out.println("あなたの勝ちです");
                        System.exit(0);
                    }
                }

                // 最終判定
                final int playerSum = player.getSum();
                final int dealerSum = dealer.getSum();
                System.out.println("あなたの点数 => " + playerSum);
                System.out.println("ディーラーの点数 => " + dealerSum);

                if (dealerSum < playerSum) {
                    System.out.println("あなたの勝ちです");
                    System.exit(0);
                }
                if (playerSum < dealerSum) {
                    System.out.println("あなたの負けです");
                    System.exit(0);
                }

            }
            if ("Q".equals(inputValue)) {
                System.out.println("ゲームを終了");
                System.exit(0);
            }
        });
    }

}
