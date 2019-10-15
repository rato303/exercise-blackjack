package player;

import handcardsopener.DealerHandCardsOpener;
import handcardsopener.HandCardsOpener;
import handcardsopener.PlayerHandCardsOpener;

/**
 * プレイヤーの種類
 */
public enum PlayerType {

    /** プレイヤー */
    PLAYER("あなた", new PlayerHandCardsOpener(), new PlayerPlayingScoreOpener()),
    /** ディーラー */
    DEALER("ディーラー", new DealerHandCardsOpener(), new DealerPlayingScoreOpener());

    private final String label;
    private final HandCardsOpener handCardsOpener;
    private final PlayingScoreOpener playingScoreOpener;

    PlayerType(final String label, final HandCardsOpener handCardsOpener, final PlayingScoreOpener playingScoreOpener) {
        this.label = label;
        this.handCardsOpener = handCardsOpener;
        this.playingScoreOpener = playingScoreOpener;
    }

    public String getLabel() {
        return this.label;
    }

    public HandCardsOpener getHandCardsOpener() {
        return this.handCardsOpener;
    }

    public PlayingScoreOpener getPlayingScoreOpener() {
        return this.playingScoreOpener;
    }

}
