package com.eplaton.xyz.util;

import java.util.Random;

/**
 * 고유한 아이디를 생성한다.
 * 
 * @author 
 * @version 1.0
 * @see
 *  
 */

public class UUID {

    private static final String zeroX = "0x";

    private static long lastTime = 0;

    private static long thisTime;

    private static long timeOffset;

    private static long nanosPerDay; //  Note: this is really
                                                       // 100-nanos.

    private static short versionNumber;

    private static short variantNumber;

    private static short thisClockSeq;

    private static short lastClockSeq;

    private static short newUuid[] = new short[16];

    private static long timeMask[] = new long[3];

    private static final char hexChar[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    //  Note that this is essentially a "base36", but several letters are omitted
    //  because they resemble numeric characters.
    private static final char base36Char[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y' };

    public UUID() {
        super();

        // Set constant values:
        versionNumber = (short) 0x0010;
        variantNumber = (short) 0x0080;
        timeMask[0] = (long) 0x00000000FFFFFFFFL;
        timeMask[1] = (long) 0x0000FFFF00000000L;
        timeMask[2] = (long) 0x0FFF000000000000L;

        //  To do: Load real IEEE 802 address.
        for (int i = 0; i < 10; i++) {
            newUuid[i] = 0;
        }
        newUuid[10] = (short) 0x0000;
        newUuid[11] = (short) 0x0080;
        newUuid[12] = (short) 0x00c7;
        newUuid[13] = (short) 0x0044;
        newUuid[14] = (short) 0x0055;
        newUuid[15] = (short) 0x00c6;

        //  Algorithm is number of 100-nanosecond intervals since 10/15/1582.
        //  Java clocks are based on 1970.
        //  Therefore offset is the number of 100-nanosecond intervals between
        //  10/15/1582 00:00:00 and 01/01/1900 00:00:00
        nanosPerDay = ((long) 86400 * 10000000);
        timeOffset = nanosPerDay * ((365 * (1970 - 1583)) // based
                                                                                      // on
                                                                                      // years
                + (24 * 3) // based on leap-year days / century
                + (5) // leap year days 1583-1600, inclusive
                + (17) // leap year days 1900-1970
        + (17 + 30 + 31) // remaining days in 1582
                );

        //  Initialize elements that can subsequently change:
        Random randVal = new Random();
        thisClockSeq = (short) ((randVal.nextInt()) & 0x00003FFF);
        thisTime = timeOffset + (10000 * System.currentTimeMillis());
        lastClockSeq = thisClockSeq;

    }

    /**
     * Returns a String.
     * 
     * @return String UUID
     * @exception weblogic.rmi.RemoteException
     */
    public synchronized String getNewSQLUuid() {
        return uuidTo0xString(getNewUuid());
    }

    /**
     * Returns a String.
     * 
     * @return String[] UUID
     * @exception weblogic.rmi.RemoteException
     */
    public synchronized String[] getNewSQLUuidBlock(int blockSize) {
        String block[] = new String[blockSize];
        for (int i = 0; i < blockSize; ++i)
            block[i] = uuidTo0xString(getNewUuid());
        return block;
    }

    /**
     * Returns a String.
     * 
     * @return String Base36Number
     * @exception weblogic.rmi.RemoteException
     */
    public synchronized String getNewBase36Number() {
        return toBase36Number(getNewUuid());
    }

    /**
     * Returns a String.
     * 
     * @return String[] Base36Number
     * @exception weblogic.rmi.RemoteException
     */
    public synchronized String[] getNewBase36NumberBlock(int blockSize) {
        String block[] = new String[blockSize];
        for (int i = 0; i < blockSize; ++i)
            block[i] = toBase36Number(getNewUuid());
        return block;
    }

    public synchronized byte[] getNewUuid() {
        long nowMillis;
        boolean mustContinue;
        long timeBuff;
        int i;
        byte byteUuid[] = new byte[16];
        short tempUuid[] = new short[16];

        //  This loop will stall until the time changes if we would
        //  issue a duplicate value of timestamp + version.
        do {
            // Convert to nanoseconds. To Do: get real 100-nanoseconds.
            thisTime = timeOffset + (10000 * System.currentTimeMillis());
            mustContinue = false;

            if (thisTime > lastTime) { // Most common case
                lastTime = thisTime;
                lastClockSeq = thisClockSeq;
            } else if (thisTime < lastTime) { // Clock setback
                thisClockSeq++;
                thisClockSeq %= 16384;
                lastClockSeq = thisClockSeq;
                lastTime = thisTime;
            } else { //  Multiple ID's in the same interval
                if (!mustContinue) {
                    thisClockSeq++;
                    thisClockSeq %= 16384;
                }
                if (thisClockSeq == lastClockSeq) {
                    mustContinue = true;
                }
            }
        } while (mustContinue == true);

        // Now the fun. We assemble the UUID based on a variety of parts.
        for (i = 0; i < 16; i++) {
            tempUuid[i] = newUuid[i];
        }

        timeBuff = thisTime & timeMask[0];
        tempUuid[3] |= (short) (timeBuff % 256);
        timeBuff >>>= 8;
        tempUuid[2] |= (short) (timeBuff % 256);
        timeBuff >>>= 8;
        tempUuid[1] |= (short) (timeBuff % 256);
        timeBuff >>>= 8;
        tempUuid[0] |= (short) (timeBuff % 256); //timeBuff
                                                                       // >>>=
                                                                       // 8;

        timeBuff = (thisTime & timeMask[1]) >>> 32;
        tempUuid[5] |= (short) (timeBuff % 256);
        timeBuff >>>= 8;
        tempUuid[4] |= (short) (timeBuff % 256); //timeBuff
                                                                       // >>>=
                                                                       // 8;

        timeBuff = (thisTime & timeMask[2]) >>> 48;
        tempUuid[7] |= (short) (timeBuff % 256);
        timeBuff >>>= 8;
        tempUuid[6] |= (short) (timeBuff % 16); //timeBuff
                                                                     // >>>= 8;
        tempUuid[6] |= versionNumber;

        timeBuff = thisClockSeq;
        tempUuid[9] |= (short) (timeBuff % 256);
        timeBuff >>>= 8;
        tempUuid[8] |= (short) (timeBuff % 64); //timeBuff
                                                                     // >>>= 8;
        tempUuid[8] |= variantNumber;

        for (i = 0; i < 16; i++) {
            byteUuid[i] = (byte) tempUuid[i];
        }

        return byteUuid;
    }

    /**
     * Translates the raw form of a UUID to its character representation This
     * method DOES include the often-required "0x"
     */
    public synchronized String uuidTo0xString(byte rawUUID[]) {
        return zeroX + uuidToString(rawUUID);
    }

    /**
     * Translates a "native" UUID to base 36 number. Relies exclusively on the
     * temporal aspects of the identifier. In addition, it produces a modified
     * base-36 representation of the actual value
     */
    public synchronized String toBase36Number(byte[] rawUUID) {

        String returnedValue = "";
        int mask = 0x0000001F; // Lowest-order 5 bits
        int wrkBuffer, tmpBuffer;
        int i, j, loBit, shiftBits;
        int loByte = 0x000000FF;

        for (i = 0; i < 16; i++) {
            //  Figure out the byte offset from which we are going to grab stuff
            //  Goal is to grab 5 bits at a time.
            j = (i * 5) / 8; // Which byte has the high-order bit?
            loBit = ((i * 5) % 8); //  Where is the lowest order bit in
                                          // the byte?
            wrkBuffer = rawUUID[j]; //  Grab the first byte
            wrkBuffer <<= 8; //  Shift to high order
            if (j < 15) { //  Just safety. Should never be false
                tmpBuffer = loByte & (rawUUID[j + 1]);
                wrkBuffer |= tmpBuffer; // Put in low-order byte
            }
            //  Now get rid of the extraneous bits, high- and low-order.
            shiftBits = 11 - loBit; //  How many bits to shift so that the
            // hi-order bit is bit 4?
            wrkBuffer >>>= shiftBits; //  Roll off what we don't need
            wrkBuffer &= mask; //  Mask off extraneous hi bits.
            returnedValue += base36Char[wrkBuffer];
        }
        return returnedValue;

    }

    /**
     * Translates the string form of a UUID to its "raw" representation Handles
     * with and without
     */
    public synchronized byte[] toRaw(String stringUUID) {

        int i, j, k, len;
        char tempChar;
        char val0 = '0', val9 = '9', valA = 'A', valZ = 'Z';
        short buffer;
        byte[] returnedValue = new byte[16];

        len = stringUUID.length();

        if (len > 32) {
            returnedValue = toRaw(stringUUID.substring(len - 32));
        }
        //  To Do: Throw an exception if invalid length for a UUID
        else {
            len /= 2; // Convert from length of string to the length of the
            // array
            stringUUID = stringUUID.toUpperCase();
            for (i = 0; i < 16; i++) {
                j = 2 * i;
                returnedValue[i] = 0;
                if (i < len) {

                    for (k = j; k <= (j + 1); k++) {

                        tempChar = stringUUID.charAt(k);
                        buffer = 0;

                        if ((tempChar >= val0) && (tempChar <= val9)) {
                            buffer = (short) (tempChar - val0);
                        } else if ((tempChar >= valA) && (tempChar <= valZ)) {
                            buffer = (short) ((tempChar - valA) + 10);
                        }

                        // Handle High-order nibble
                        if ((k % 2) == 0)
                            buffer <<= 4;

                        returnedValue[i] |= buffer;

                    }
                }
            }
        }

        return returnedValue;

    }

    public synchronized String uuidToString(byte rawUUID[]) {
        // Translates the raw form of a UUID to its character representation
        // This method does NOT include the often-required "0x"
        short hiNibble = 0xF0;
        short loNibble = 0x0F;
        int i, len;
        String returnedValue = "";

        len = rawUUID.length;

        for (i = 0; i < len; i++) {
            returnedValue += hexChar[(hiNibble & rawUUID[i]) >>> 4];
            returnedValue += hexChar[(loNibble & rawUUID[i])];
        }

        return returnedValue;

    }

    public synchronized String uuidToFullString(byte rawUUID[]) {
        String uuid = uuidToString(rawUUID);
        uuid = uuid.substring(0, 8) + "-" + uuid.substring(8, 12) + "-" + uuid.substring(12, 16) + "-" + uuid.substring(16, 20) + "-" + uuid.substring(20);
        return uuid;
    }

    public static void main(String[] args) {
        UUID uuid = new UUID();
        for (int i = 0; i < 2; i++) {
            System.out.println(uuid.uuidToFullString(uuid.getNewUuid()));
        }

    }
}
