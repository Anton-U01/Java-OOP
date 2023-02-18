package WorkingwithAbstractionExercise.CardRank;

public class Main {
    public static void main(String[] args) {
        CardRank[] cardRanks = CardRank.values();
        System.out.println("Card Ranks:");
        for (CardRank card : cardRanks) {
            System.out.println("Ordinal value: " + card.ordinal() + "; Name value: " + card.name());
        }
    }
}
