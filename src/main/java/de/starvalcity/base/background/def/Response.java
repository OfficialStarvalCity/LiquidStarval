package de.starvalcity.base.background.def;

/**
 * Die Response definiert eine spezifische Antwort für jeden individuellen Fall. Bei unbestimmten Fällen wird bei einem
 * Erfolg die ID 999 und bei einem Fehler die ID 998 aufgerufen.
 */
public enum Response {

    NOT_IMPLEMENTED(0),
    INSUFFICIENT_USAGE(1),
    INSUFFICIENT_ARGUMENTS(2),
    NOT_ENOUGH_ARGUMENTS(3),
    UNAVAILABLE_ARGUMENTS(4),
    INSUFFICIENT_PERMISSIONS(5),
    INSUFFICIENT_INSTANCE(6),
    INSUFFICIENT_STATUS(7),
    GENERAL_FAILURE(998),
    GENERAL_SUCCESS(999);

    private final int id;

    Response(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
