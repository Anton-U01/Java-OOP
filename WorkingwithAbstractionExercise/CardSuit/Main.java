package WorkingwithAbstractionExercise.CardSuit;


public class Main {
    public static void main(String[] args) {
       CardSuit[] cardSuit = CardSuit.values();
        System.out.println("Card Suits:");
        for (CardSuit card : cardSuit) {
            System.out.println("Ordinal value: " + card.ordinal() + "; Name value: " + card.name());
        }
    }
}
