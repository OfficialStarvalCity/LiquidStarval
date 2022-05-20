package de.starvalcity.base.api.def.economy;

public class EconomyResponse {

    public static enum EconomyResponseType {
        NOT_IMPLEMENTED(1),
        FAILURE(2),
        SUCCESS(3);

        private int id;

        EconomyResponseType(int id) {
            this.id = id;
        }

        int getId() {
            return id;
        }
    }

    public final double amount;
    public final double balance;
    public final EconomyResponseType responseType;
    public final String errorMessage;

    public EconomyResponse(double amount, double balance, EconomyResponseType responseType, String errorMessage) {
        this.amount = amount;
        this.balance = balance;
        this.responseType = responseType;
        this.errorMessage = errorMessage;
    }

    public boolean operationStatus() {
        switch (responseType) {
            case FAILURE:
                return false;
            case SUCCESS:
                return true;
            default:
                return false;
        }
    }
}
