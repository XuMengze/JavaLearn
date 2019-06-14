package com.alg.array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ContinuousDate {
    public static void main(String[] args) {
        String beginTime = "2019-05-06 00:00:00";
        String endTime = "2019-09-06 23:59:59";
        List<String> dateList = new ContinuousDate().getContinuousDateMonth(beginTime, endTime);
        System.out.println(dateList);
    }

    public List<String> getContinuousDateMonth(String beginTime, String endTime) {
        List<String> dateList = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatMonth = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();

        int i = 0;
        try {
            while (true) {
                c.setTime(format.parse(beginTime));
                c.add(Calendar.MONTH, +i);
                Date d = c.getTime();
                String day = formatMonth.format(d);
                if ((day + "-01 00:00:00").compareTo(endTime) > 0) {
                    break;
                }
                dateList.add(day);
                i++;
            }
        } catch (ParseException ex) {

        }
        return dateList;
    }

    public Map<String, Object> service() {
        List<Object[]> resFromDao = new ArrayList<>();
        List<String> dataList = new ArrayList<>();
        Map<String, Map<String, Integer>> dbHashMap = new HashMap<>();
        for (String d : dataList) {
            dbHashMap.put(d, new HashMap<>());
        }
        for (Object[] objarr : resFromDao) {
            dbHashMap.get(objarr[0] + "").put(objarr[1] + "", Integer.parseInt(objarr[2] + ""));
        }
        return null;
    }
}
