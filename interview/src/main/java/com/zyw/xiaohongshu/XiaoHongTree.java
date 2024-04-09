package com.zyw.xiaohongshu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class XiaoHongTree {
    //构建树
    static class TreeNode{
        int val;
        List<TreeNode> children = new ArrayList<>();
        boolean isRed = false;
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int dfs(TreeNode node, TreeNode parent) {
        //dfs遍历树，返回以node为根的子树中红色节点的个数
        int redCount = 0;
        for (TreeNode child : node.children) {
            if (child != parent) {
                redCount += dfs(child, node);
            }
        }
        if(parent !=null&&!node.isRed&&!parent.isRed&&isPrime(node.val)){
            //染色
            node.isRed = true;
            redCount++;
        }
        return redCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeNode[] nodes = new TreeNode[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new TreeNode();
            nodes[i].val = in.nextInt();  //权值
        }
        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            nodes[u].children.add(nodes[v]);
            nodes[v].children.add(nodes[u]);
        }
        System.out.println(dfs(nodes[1], null));
    }
}
