package com.ceriarte.central.utilidades;


public class Crypt {
    private static int Hex2Dec (byte byte0) {
        return byte0 > 57 ? byte0 - 65 + 10 & 0xF : byte0 - 48;
    }

    private static String Dec2Hex (int i) {
        String s = Integer.toHexString(i);
        if (i < 16)
            s = "0" + s;
        return s;
    }

    public static String Encrypt(String s, String s1){
        String s2 = "";
        byte abyte0[];
        try
        {
            abyte0 = s1.getBytes();
        }
        catch(Exception exception)
        {
            return null;
        }
        if(s == null || s1 == null)
            return null;
        if(s1.length() != 48)
            return null;
        int k1 = s.length();
        int l = 0;
        for(int j1 = 0; j1 < k1; j1++)
        {
            int i1 = j1 % 16;
            if(i1 == 0 && j1 > 0)
            {
                int i = l ^ abyte0[32];
                s2 = s2 + Dec2Hex(i);
                l = 0;
            }
            int j = s.charAt(j1) ^ abyte0[i1];
            l ^= j;
            j ^= abyte0[16 + i1];
            s2 = s2 + Dec2Hex(j);
        }

        int k = l ^ abyte0[32];
        s2 = s2 + Dec2Hex(k);
        return s2;
    }

    public static String decrypt(String s, String s1){
        String s2 = "";
        byte abyte2[] = {
            0
        };
        if(s == null || s1 == null)
            return null;
        if(s1.length() != 48)
            return null;
        byte abyte0[];
        byte abyte1[];
        try
        {
            abyte0 = s1.getBytes();
            abyte1 = s.getBytes();
        }
        catch(Exception exception)
        {
            return null;
        }
        int k1 = s.length();
        int l = 0;
        for(int j1 = 0; j1 < k1 / 2 - 1; j1++)
        {
            int i1 = j1 % 17;
            if(i1 == 16)
            {
                if(j1 > 0)
                {
                    int i = Hex2Dec(abyte1[j1 * 2]) << 4 | Hex2Dec(abyte1[j1 * 2 + 1]);
                    l ^= abyte0[32];
                    if(l != i)
                    {
                        System.out.println("control erroneo " + l + " " + i);
                        return null;
                    }
                }
                l = 0;
            } else
            {
                int j = Hex2Dec(abyte1[j1 * 2]) << 4 | Hex2Dec(abyte1[j1 * 2 + 1]);
                j ^= abyte0[16 + i1];
                l ^= j;
                j ^= abyte0[i1];
                if(j1 < k1 / 2 - 1)
                {
                    abyte2[0] = (byte)j;
                    try
                    {
                        s2 = s2 + new String(abyte2, "ASCII");
                    }
                    catch(Exception exception1)
                    {
                        return null;
                    }
                }
            }
        }

        int k = Hex2Dec(abyte1[k1 - 2]) << 4 | Hex2Dec(abyte1[k1 - 1]);
        l ^= abyte0[32];
        if(l != k)
            return null;
        else
            return s2;
    }
}