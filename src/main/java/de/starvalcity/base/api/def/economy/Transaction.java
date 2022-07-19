package de.starvalcity.base.api.def.economy;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Transaction {

    private Object sender;
    private Object receiver;
    private int amount;

    public Transaction(Object sender, Object receiver, int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }
}
