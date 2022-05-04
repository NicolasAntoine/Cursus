package CreditCards;

import Offers.OfferVisitor;

public class SilverCreditCard implements CreditCard{
    @Override
    public String getName() {
        return "Silver";
    }

    @Override
    public void accept(OfferVisitor v) {
        v.visitSilverCreditCard(this);
    }
}
