package com.alg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primes {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\13240\\Desktop\\T.S. - Folklore");
        File[] flist = f.listFiles();
        for (File fileItem : flist) {
            if (!fileItem.getName().endsWith("flac")) {
                continue;
            }
            fileItem.renameTo(new File(fileItem.getParent() + "\\" + fileItem.getName().substring(0, fileItem.getName().length() - 4) + "mp3"));
        }
        for (File fileItem : flist) {
            System.out.println(fileItem.getName());
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> res = new ArrayList<>();
        int count = 0;
        while (true) {
            count++;
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (start == 0 && end == 0) {
                break;
            } else {
                for (int i = start; i <= end; i++) {
                    if (!checkPrime(i * i + i + 41)) {
                        res.add("Sorry");
                        break;
                    }
                }
                if (count != res.size()) {
                    res.add("OK");
                }

            }
        }
        for (String s : res) {
            System.out.println(s);
        }
    }

    static boolean checkPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            int bound = (int) Math.sqrt(number);
            for (int i = 2; i <= bound; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
