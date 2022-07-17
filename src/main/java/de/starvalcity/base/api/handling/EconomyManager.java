package de.starvalcity.base.api.handling;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.EconomyParticipator;
import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.def.economy.BalanceType;
import org.jetbrains.annotations.NotNull;

public class EconomyManager {

    private static Pluginbase pluginbase = new Pluginbase();

    public void setDefaultBalance(@NotNull EconomyParticipator economyParticipator) {
        int objectId = ObjectManager.getObjectId(economyParticipator);
        economyParticipator.setDefaultBalance();
    }

    public void setBalance(@NotNull EconomyParticipator economyParticipator, double balance, BalanceType balanceType) {
        economyParticipator.setBalance(balance);
        if (economyParticipator instanceof StarvalPlayer) {
            StarvalPlayer starvalPlayer = (StarvalPlayer) economyParticipator;
            starvalPlayer.setBalance(balance);

        }
    }

}
