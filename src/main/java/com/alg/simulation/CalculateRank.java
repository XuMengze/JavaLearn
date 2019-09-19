package com.alg.simulation;


import java.util.*;

public class CalculateRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int record = sc.nextInt();
        int classroomsNum = sc.nextInt();
        sc.nextLine();
        Map<String, Classroom> classrooms = new HashMap<>(classroomsNum);
        for (int i = 0; i < classroomsNum; i++) {
            String[] tmp = sc.nextLine().split(" ");
            Classroom c = new Classroom();
            c.classId = tmp[2];
            Teacher t = new Teacher();
            t.teacherId = tmp[1];
            c.t = t;
            c.sList = new HashMap<>();
            int studentNum = Integer.parseInt(tmp[0]);
            for (int j = 0; j < studentNum; j++) {
                Student stu = new Student();
                stu.studentId = tmp[j + 3];
                c.sList.put(tmp[j + 3], stu);
            }
            classrooms.put(tmp[2], c);
        }

        for (int i = 0; i < record; i++) {
            String[] tmp = sc.nextLine().split(" ");
            if (tmp[0].equals("IN")) {
                for (Map.Entry<String, Classroom> entry : classrooms.entrySet()) {
                    if (tmp[1].equals(entry.getValue().t.teacherId)) {
                        entry.getValue().t.inTime = tmp[2];
                        break;
                    }
                    if (entry.getValue().sList.get(tmp[1]) != null) {
                        entry.getValue().sList.get(tmp[1]).inTime = tmp[2];
                        break;
                    }
                }

            }
            if (tmp[0].equals("OUT")) {
                for (Map.Entry<String, Classroom> entry : classrooms.entrySet()) {
                    if (tmp[1].equals(entry.getValue().t.teacherId)) {
                        entry.getValue().t.outTime = tmp[2];
                        break;
                    }
                    if (entry.getValue().sList.get(tmp[1]) != null) {
                        entry.getValue().sList.get(tmp[1]).outTime = tmp[2];
                        break;
                    }
                }
            }
        }
        TreeMap<Double, String> map = new TreeMap();
        for (Map.Entry<String, Classroom> entry : classrooms.entrySet()) {
            entry.getValue().cal();
            map.put(entry.getValue().ratio, entry.getKey());

        }
        for (Map.Entry<Double, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

class Classroom {
    public String classId;
    public Teacher t;
    public Map<String, Student> sList;

    public double ratio;

    public void cal() {
        int upper = (Integer.parseInt(t.outTime) - Integer.parseInt(t.inTime)) * sList.size();
        int lowwer = 0;
        for (Map.Entry<String, Student> entry : sList.entrySet()) {
            lowwer += (Integer.parseInt(entry.getValue().outTime) - Integer.parseInt(entry.getValue().inTime));
        }
        ratio = Double.valueOf(upper + "") / lowwer;
    }
}

class Teacher {
    public String teacherId;
    public String inTime;
    public String outTime;
}

class Student {
    public String studentId;
    public String inTime;
    public String outTime;
}
