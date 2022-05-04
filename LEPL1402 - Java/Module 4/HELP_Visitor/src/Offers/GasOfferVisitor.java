package Offers;

import CreditCards.BronzeCreditCard;
import CreditCards.GoldCreditCard;
import CreditCards.SilverCreditCard;

public class GasOfferVisitor implements OfferVisitor{
    @Override
    public void visitBronzeCreditCard(BronzeCreditCard bronze) {
        System.out.println("We are computing the cashback for a bronze card buying gas");
    }

    @Override
    public void visitSilverCreditCard(SilverCreditCard silver) {
        System.out.println("We are computing the cashback for a silver card buying gas");
    }

    @Override
    public void visitGoldCreditCard(GoldCreditCard gold) {
        System.out.println("We are computing the cashback for a gold card buying gas");
    }
}
