package de.starvalcity.base.api.def.faction;

public class FactionResponse {

    public enum FactionResponseType {

        NOT_IMPLEMENTED(0),
        FAILURE(1),
        SUCCESS(2);

        private int id;

        FactionResponseType(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public final String cause;
    public final FactionResponseType responseType;
    public final String errorMessage;

    public FactionResponse(String cause, FactionResponseType responseType, String errorMessage) {
        this.cause = cause;
        this.responseType = responseType;
        this.errorMessage = errorMessage;
    }

    public boolean operationStatus() {
        switch (responseType) {
            case NOT_IMPLEMENTED:
                return false;
            case FAILURE:
                return false;
            case SUCCESS:
                return true;
            default:
                return false;
        }
    }

}
