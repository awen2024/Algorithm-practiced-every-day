package org.zyw.str;

public class BM85VerifyIPAddress {
    //验证输入的字符串是否是有效的 IPv4 或 IPv6 地址
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }
        if (IP.contains(".")) {
            return validIPv4(IP);
        } else if (IP.contains(":")) {
            return validIPv6(IP);
        } else {
            return "Neither";
        }
    }
    //Pv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。
    //比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。
    //而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。
    //所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
    //然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
    //同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
    private String validIPv6(String ip) {
        if (ip.charAt(ip.length() - 1) == ':') {
            return "Neither";
        }
        if (ip.charAt(0) == ':') {
            return "Neither";
        }
        String[] splits = ip.split(":");
        if (splits.length != 8) {
            return "Neither";
        }
        for (String split : splits) {
            if (split.length() == 0 || split.length() > 4) {
                return "Neither";
            }
            if (split.matches(".*[^0-9a-fA-F].*")) {
                return "Neither";
            }
        }
        return "IPv6";
    }

    //范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
    //同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
    private String validIPv4(String ip) {
        String[] splits = ip.split("\\.");
        if (splits.length != 4) {
            return "Neither";
        }
        for (String split : splits) {
            if(split.length() == 0 || split.length() > 3) {
                return "Neither";
            }
            if(split.matches(".*[^0-9].*")) {
                return "Neither";
            }
            if (split.length() > 1 && split.charAt(0) == '0') {
                return "Neither";
            }
            if (Integer.parseInt(split) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public static void main(String[] args) {
        BM85VerifyIPAddress bm85VerifyIPAddress = new BM85VerifyIPAddress();
        //2001:db8:85a3:0:0:8A2E:0370:7334
        //20EE:FGb8:85a3:0:0:8A2E:0370:7334
        System.out.println(bm85VerifyIPAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
