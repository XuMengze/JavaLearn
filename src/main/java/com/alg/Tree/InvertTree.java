package com.alg.Tree;

import com.alg.model.TreeNode;

public class InvertTree {
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            TreeNode a = new TreeNode(2);
            TreeNode b = new TreeNode(3);
            TreeNode c = new TreeNode(4);
            TreeNode d = new TreeNode(5);

            root.left = a;
            root.right = b;
            a.left = c;
            a.right = d;

            printTree(root);

            TreeNode root2 = inverttreeNode(root);
            System.out.println("");
            printTree(root2);

        }

        public static TreeNode inverttreeNode(TreeNode root){
            if(root == null){
                return root;
            }
            TreeNode tmp = root.left;
            root.left = inverttreeNode(root.right);
            root.right = inverttreeNode(tmp);
            return root;
        }

        public static void printTree(TreeNode root){

            System.out.print(root.val);
            if (root.left!=null){
                printTree(root.left);
            }
            if(root.right!=null){
                printTree(root.right);
            }
        }
    }