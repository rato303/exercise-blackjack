package card;

/**
 * マーク
 */
public enum Mark {

    /** ハート */
    HEART("♡"),
    /** ダイアモンド */
    DIAMOND("♢"),
    /** クローバー(クラブ) */
    CLUB("♣"),
    /** スペード */
    SPADE("♠");

    private final String label;

    Mark(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

}
