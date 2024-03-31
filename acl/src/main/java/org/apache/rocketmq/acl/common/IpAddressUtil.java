package org.apache.rocketmq.acl.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.acl.common.AclUtils;
public class IpAddressUtil {

    public static String expandIP(String netAddress, int part) {
        netAddress = netAddress.toUpperCase();
        // expand netAddress
        int separatorCount = StringUtils.countMatches(netAddress, ":");
        int padCount = part - separatorCount;
        if (padCount > 0) {
            StringBuilder padStr = new StringBuilder(":");
            for (int i = 0; i < padCount; i++) {
                padStr.append(":");
            }
            netAddress = StringUtils.replace(netAddress, "::", padStr.toString());
        }

        // pad netAddress
        String[] strArray = StringUtils.splitPreserveAllTokens(netAddress, ":");
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length() < 4) {
                strArray[i] = StringUtils.leftPad(strArray[i], 4, '0');
            }
        }

        // output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            sb.append(strArray[i]);
            if (i != strArray.length - 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    public static void verify(String netAddress, int index) {
        if (!AclUtils.isScope(netAddress, index)) {
            throw new AclException(String.format("NetAddress examine scope Exception netAddress is %s", netAddress));
        }
    }

}
