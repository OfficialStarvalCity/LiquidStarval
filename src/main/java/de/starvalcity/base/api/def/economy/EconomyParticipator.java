package de.starvalcity.base.api.def.economy;

public interface EconomyParticipator {

    //--------------------------------------------------------------------------------------------------//
    // Instance Account
    //--------------------------------------------------------------------------------------------------//

    boolean hasEnoughMoney(double requiredAmount);

    double getBalance();

    void setDefaultBalance();

    void setBalance(double amount);

    void addMoney(double amount);

    void removeMoney(double amount);

    //--------------------------------------------------------------------------------------------------//
    // Bank Account
    //--------------------------------------------------------------------------------------------------//

    boolean hasBankAccount();

    /**
     * Bank Account Owner
     * <p>This method is <b>optional</b>. It checks, whether a {@link de.starvalcity.base.api.def.StarvalPlayer} is owning
     * a bank account or not and does not specify <b>which</b> account the {@link de.starvalcity.base.api.def.StarvalPlayer} owns.</p>
     * @return true / false
     */
    boolean isBankAccountOwner();

    /**
     * Bank Account Member
     * <p>This method is <b>optional</b>. It checks, whether a {@link de.starvalcity.base.api.def.StarvalPlayer} is member of
     * a bank account or not and does not specify <b>which</b> account the {@link de.starvalcity.base.api.def.StarvalPlayer} is member of.</p>
     * @return true / false
     */
    boolean isBankAccountMember();

    boolean isOwnerOfBankAccount(int id);

    boolean isMemberOfBankAccount(int id);

}
