package com.alg.other;

public class ConseuctiveSum {
    public static void main(String[] args) {
        int num = 1002;
        double round = Math.ceil(Math.pow(Double.parseDouble(num * 2 + ""), 0.5));
        for (int i = 2; i <= round; i++) {
            String res = get(num, i);
            if (!res.isEmpty()) {
                System.out.println(res);
            }
        }
    }

    static String get(int num, int digits) {
        String rs = "";
        if (digits % 2 == 1) {
            if (num % digits == 0) {
                int mid = num / digits;
                if (mid - digits / 2 >= 1) {
                    for (int i = mid - digits / 2; i <= mid + digits / 2; i++) {
                        rs += i + " + ";
                    }
                }
            }
        } else {
            int base = digits / 2;
            if (num % base == 0 && (num / base) % 2 == 1) {
                if ((num / base) / 2 - (base - 1) >= 1) {
                    for (int i = (num / base) / 2 - (base - 1); i <= (num / base) / 2 + (base); i++) {
                        rs += i + " + ";
                    }
                }
            }
        }
        if (!rs.isEmpty()) {
            return rs.substring(0, rs.length() - 2) + " = " + num;
        }
        return rs;
    }
}

