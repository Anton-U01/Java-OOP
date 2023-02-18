package WorkingwithAbstractionExercise.CardsWithPower;

public class Card {
    private CardRank rank;
    private CardSuit suit;
    private int power;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
        this.power = 0;
    }

    public void setRank(CardRank rank) {
        this.rank = rank;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getPower() {
        return this.suit.getPower() + this.rank.getPower();
    }
}
