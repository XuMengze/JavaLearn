package com.alg.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ShuffleCards {
    public static final int CARD_NUM = 52;

    public static void main(String[] args) {
        String[] colors = {"红桃", "黑桃", "梅花", "方片"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] cards = new String[CARD_NUM];
        int index = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                cards[index++] = colors[i] + numbers[j];
            }
        }
        Random r = new Random();
        int times = r.nextInt(7) + 1;
        for (int i = 0; i < times; i++) {
            if (r.nextInt(2) == 0) {
                cards = qiepai(cards);
            } else {
                cards = shuffle(cards);
            }
        }

        List person1 = new ArrayList();
        List person2 = new ArrayList();
        List person3 = new ArrayList();
        List person4 = new ArrayList();
        for (int i = 0; i < CARD_NUM; i++) {
            if (i % 4 == 0) {
                person1.add(cards[i]);
            } else if (i % 4 == 1) {
                person2.add(cards[i]);
            } else if (i % 4 == 2) {
                person3.add(cards[i]);
            } else {
                person4.add(cards[i]);
            }
        }

        System.out.println(Arrays.toString(person1.toArray()));
        System.out.println(Arrays.toString(person2.toArray()));
        System.out.println(Arrays.toString(person3.toArray()));
        System.out.println(Arrays.toString(person4.toArray()));
    }

    public static String[] shuffle(String[] originalArr) {
        String[] part1 = new String[CARD_NUM / 2];
        String[] part2 = new String[CARD_NUM / 2];
        System.arraycopy(originalArr, 0, part1, 0, CARD_NUM / 2);
        System.arraycopy(originalArr, CARD_NUM / 2, part2, 0, CARD_NUM / 2);

        int part1Index = 0;
        int part2Index = 0;

        String[] resArr = new String[CARD_NUM];

        Random r = new Random();
        String flag = "left";
        while (part1Index < part1.length || part2Index < part2.length) {
            int shuffleNum = r.nextInt(3) + 1;
            if (flag.equals("left")) {
                System.arraycopy(part1, part1Index, resArr, part1Index + part2Index, Math.min(shuffleNum, part1.length - part1Index));
                part1Index += Math.min(shuffleNum, part1.length - part1Index);
                flag = "right";
            } else {
                System.arraycopy(part2, part2Index, resArr, part1Index + part2Index, Math.min(shuffleNum, part2.length - part2Index));
                part2Index += Math.min(shuffleNum, part2.length - part2Index);
                flag = "left";
            }
        }
        return resArr;
    }

    public static String[] qiepai(String[] originalArr) {
        Random r = new Random();
        int qiepaiStartPos = r.nextInt(13);//选择前1/4的一个随机位置做开始
        int qiepaiNum = r.nextInt(13) + 13;//选择连续的13张导26张作为切牌的个数
        String[] resArr = new String[CARD_NUM];
        System.arraycopy(originalArr, qiepaiStartPos, resArr, 0, qiepaiNum);
        System.arraycopy(originalArr, 0, resArr, qiepaiNum, qiepaiStartPos);
        System.arraycopy(originalArr, qiepaiStartPos + qiepaiNum, resArr, qiepaiStartPos + qiepaiNum, originalArr.length - qiepaiStartPos - qiepaiNum);
        return resArr;
    }
}
