import CreditCards.BronzeCreditCard;
import CreditCards.CreditCard;
import CreditCards.GoldCreditCard;
import CreditCards.SilverCreditCard;
import Offers.GasOfferVisitor;

public class Runner {
    public static void main(String[] args) {
        GasOfferVisitor visitor = new GasOfferVisitor();

        CreditCard bronze = new BronzeCreditCard();
        CreditCard silver = new SilverCreditCard();
        CreditCard gold = new GoldCreditCard();

        bronze.accept(visitor);

    }
}
