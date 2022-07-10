package de.starvalcity.base.api.handling.economy;

import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.handling.InstanceManager;

public class TransactionHandler {

    public void executeTransaction(Object sender, Object receiver, double amount) {
        int senderId = InstanceManager.getInstanceId(sender);
        int receiverId = InstanceManager.getInstanceId(receiver);

    }
}
