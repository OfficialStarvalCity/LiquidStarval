package de.starvalcity.base.api.def;

import java.security.SecureRandom;

/**
 * Die {@link StarvalID} ist eine benutzerdefinierte Implementation der {@link java.util.UUID}.
 */
public class StarvalID implements Comparable<StarvalID> {

    private final long mostSigBits;
    private final long leastSigBits;

    public StarvalID(byte[] data) {
        long msb = 0;
        long lsb = 0;
        assert data.length == 16 : "data must be 16 bytes in length";
        for (int i=0; i<8; i++)
            msb = (msb << 8) | (data[i] & 0xff);
        for (int i=8; i<16; i++)
            lsb = (lsb << 8) | (data[i] & 0xff);
        this.mostSigBits = msb;
        this.leastSigBits = lsb;
    }

    public StarvalID(long mostSigBits, long leastSigBits) {
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
    }


    public static StarvalID randomID() {
        SecureRandom random = new SecureRandom();

        byte[] randomBytes = new byte[64];
        random.nextBytes(randomBytes);
        return new StarvalID(randomBytes);
    }

    @Override
    public int compareTo(StarvalID val) {
        return (this.mostSigBits < val.mostSigBits ? -1 :
                (this.mostSigBits > val.mostSigBits ? 1 :
                        (Long.compare(this.leastSigBits, val.leastSigBits))));
    }
}
