package de.starvalcity.base.api.def.economy;

public class Transaction {

    private Object sender;
    private Object receiver;
    private int amount;

    public Transaction(Object sender, Object receiver, int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public Object getSender() {
        return sender;
    }

    public Object getReceiver() {
        return receiver;
    }

    public int getAmount() {
        return amount;
    }
}
