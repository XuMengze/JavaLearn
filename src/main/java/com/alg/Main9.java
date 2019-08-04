package com.alg;

import java.util.*;

public class Main9 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        while (sc.hasNextLine()) {
            int stubCount = sc.nextInt();
            int edge = sc.nextInt();
            int move = sc.nextInt();

            int[][] weight = new int[stubCount][stubCount];
            for (int[] arr : weight) {
                Arrays.fill(arr, -1);
            }

            for (int i = 0; i < stubCount; i++) {
                weight[i][i] = 0;
            }

            for (int i = 0; i < edge; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int v = sc.nextInt();
                weight[s][e] = v;
                weight[e][s] = v;
            }

            String[] str = new String[stubCount];
            Arrays.fill(str, "hhh");

            Dijkstra dijkstra = new Dijkstra(stubCount);
            //依次让各点当源点，并调用dijkstra函数
            int[][] res = new int[stubCount][stubCount];
            for (int i = 0; i < stubCount; i++) {
                dijkstra.dijkstra(weight, str, i, res[i]);
            }

            int step = sc.nextInt();
            int s = res[0][step];
            for (int i = 1; i < move; i++) {
                int step2 = sc.nextInt();
                s += res[step][step2];
                step = step2;
            }
            result.add(s);
        }
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}

class Dijkstra {
    private Queue visited;
    int[] distance;

    public Dijkstra(int len) {
        // TODO Auto-generated constructor stub
        visited = new LinkedList();
        distance = new int[len];

    }

    private int getIndex(Queue q, int[] dis) {
        int k = -1;
        int min_num = Integer.MAX_VALUE;
        for (int i = 0; i < dis.length; i++) {
            if (!q.contains(i)) {
                if (dis[i] < min_num) {
                    min_num = dis[i];
                    k = i;
                }
            }
        }
        return k;
    }

    public void dijkstra(int[][] weight, Object[] str, int v, int[] res) {
        HashMap path;
        path = new HashMap();
        for (int i = 0; i < str.length; i++)
            path.put(i, "");

        //初始化路径长度数组distance
        for (int i = 0; i < str.length; i++) {
            path.put(i, path.get(i) + "" + str[v]);
            if (i == v)
                distance[i] = 0;
            else if (weight[v][i] != -1) {
                distance[i] = weight[v][i];
                path.put(i, path.get(i) + "-->" + str[i]);
            } else
                distance[i] = Integer.MAX_VALUE;
        }
        visited.add(v);
        while (visited.size() < str.length) {
            int k = getIndex(visited, distance);//获取未访问点中距离源点最近的点
            visited.add(k);
            if (k != -1) {

                for (int j = 0; j < str.length; j++) {
                    if (weight[k][j] != -1)//判断k点能够直接到达的点
                    {
                        //通过遍历各点，比较是否有比当前更短的路径，有的话，则更新distance，并更新path。
                        if (distance[j] > distance[k] + weight[k][j]) {
                            distance[j] = distance[k] + weight[k][j];
                            path.put(j, path.get(k) + "-->" + str[j]);
                        }
                    }

                }
            }
        }
        for (int h = 0; h < str.length; h++) {
            res[h] = distance[h];
            System.out.printf(str[v] + "-->" + str[h] + ":" + distance[h] + " ");
            if (distance[h] == Integer.MAX_VALUE)
                System.out.print(str[v] + "-->" + str[h] + "之间没有可通行路径");
            else {
                System.out.print(str[v] + "-" + str[h] + "之间有最短路径，具体路径为：" + path.get(h).toString());
            }
            System.out.println();
        }
    }
}
