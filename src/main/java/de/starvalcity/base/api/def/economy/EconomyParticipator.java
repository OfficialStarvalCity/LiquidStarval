package de.starvalcity.base.api.def.economy;

/**
 * Ein {@link EconomyParticipator} ist ein {@link Object}, welches an der Wirtschaft teilnimmt.
 */
public interface EconomyParticipator {

    //--------------------------------------------------------------------------------------------------//
    // Instanz
    //--------------------------------------------------------------------------------------------------//

    /**
     * Geldüberprüfung
     * Überprüft, ob eine <b>Instanz</b> genügend <b>Bargeld</b> für eine Aktion besitzt.
     * @param requiredAmount Erforderliche Bargeldmenge
     * @return true / false
     */
    boolean hasEnoughMoney(double requiredAmount);

    /**
     * Kontostand Getter
     * Zeigt den aktuellen Kontostand einer <b>Instanz</b> an.
     * @return Kontostand der <b>Instanz</b>
     */
    double getBalance();

    /**
     * Standardmenge Setter
     * Setzt den Kontostand einer <b>Instanz</b> auf den Standardwert.
     */
    void setDefaultBalance();

    /**
     * Geld Setter
     * Setzt eine spezifische Menge an Geld einer <b>Instanz</b> als Kontostand.
     * @param amount Geldmenge, welche gesetzt werden soll
     */
    void setBalance(double amount);

    /**
     * Geld Hinzufügung
     * Fügt einem Kontostand einer <b>Instanz</b> eine bestimmte Menge an Geld hinzu.
     * @param amount Geldmenge, welche hinzugefügt werden soll
     */
    void addMoney(double amount);

    /**
     * Geld Entfernung
     * Entfernt einem Kontostand einer <b>Instanz</b> eine bestimmte Menge an Geld.
     * @param amount Geldmenge, welche entfernt werden soll
     */
    void removeMoney(double amount);

    //--------------------------------------------------------------------------------------------------//
    // Bank
    //--------------------------------------------------------------------------------------------------//

    /**
     * Bankkonto Besitztum Überprüfung
     * Diese Methode überprüft, ob eine <b>Instanz</b> ein Konto besitzt oder nicht.
     * @return true / false
     */
    boolean hasBankAccount();

    /**
     * Bankkonto Mitglied Überprüfung
     * Diese Methode überprüft, ob eine <b>Instanz</b> Mitglied eines Kontos ist oder nicht.
     * @return true / false
     */
    boolean isBankAccountMember();

    /**
     * Spezifische Bankkonto Besitztum Überprüfung
     * Diese Methode überprüft, ob das angegebene Konto einer <b>Instanz</b> gehört oder nicht.
     * @param id ID des Kontos
     * @return true / false
     */
    boolean isOwnerOfBankAccount(int id);

    /**
     * Spezifische Bankkonto Mitglied Überprüfung
     * Diese Methode überprüft, ob eine <b>Instanz</b> Mitglied des angegebenen Kontos ist oder nicht.
     * @param id ID des Kontos
     * @return true / false
     */
    boolean isMemberOfBankAccount(int id);

}
