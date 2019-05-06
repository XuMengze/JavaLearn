package com.alg.Tests;

import java.io.*;
import java.util.Properties;

public class JavaTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(new FileInputStream("/Users/xumz-pc/Desktop/fds.properties"), "utf-8");
        BufferedReader bufferedReader = new BufferedReader(in);
        Properties p = new Properties();
        p.load(bufferedReader);
        System.out.println(p);
    }
}
