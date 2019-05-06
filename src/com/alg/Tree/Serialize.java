package com.alg.Tree;

import com.alg.model.TreeNode;

public class Serialize {


    static String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    int index = -1;

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) {
            return null;
        }
        String[] stra = str.split(",");
        TreeNode node = null;
        if (!stra[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(stra[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(3);
//        TreeNode d = new TreeNode(4);
//        TreeNode e = new TreeNode(5);
//        TreeNode f = new TreeNode(6);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        c.left = e;
//        c.right = f;
//
//        System.out.println(Serialize(a));

        String tree = "1,2,4,#,#,#,3,5,#,#,6,#,#,";

        Serialize s = new Serialize();

        TreeNode hhh = s.Deserialize(tree);

        System.out.println(hhh.right.right.val);

    }
}

