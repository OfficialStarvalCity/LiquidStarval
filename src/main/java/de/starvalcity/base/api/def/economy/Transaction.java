package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.UniqueObject;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Transaction implements UniqueObject {

    private Object sender;
    private Object receiver;
    private int amount;
    private int id;

    public Transaction(Object sender, Object receiver, int amount, int id) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
