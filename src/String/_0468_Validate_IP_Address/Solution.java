package String._0468_Validate_IP_Address;

public class Solution {
    public String validIPAddress(String IP) {
        String[] v4 = IP.split("\\.", -1);
        if (v4.length == 4) return validateIPv4(v4);
        String[] v6 = IP.split(":", -1);
        if (v6.length == 8) return validateIPv6(v6);
        return "Neither";
    }

    private String validateIPv4(String[] v4) {
        for (String str : v4) {
            if (str.length() == 0 || str.length() > 3 || (str.charAt(0) == '0' && str.length() != 1))
                return "Neither";
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9')
                    return "Neither";
                num = num * 10 + str.charAt(i) - '0';
            }
            if (num > 255) return "Neither";
        }
        return "IPv4";
    }

    private String validateIPv6(String[] v6) {
        for (String str : v6) {
            if (str.length() == 0 || str.length() > 4)
                return "Neither";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')))
                    return "Neither";
            }
        }
        return "IPv6";
    }
}
