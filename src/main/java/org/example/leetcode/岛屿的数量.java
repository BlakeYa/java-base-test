package org.example.leetcode;

//https://leetcode.cn/problems/surrounded-regions/
public class 岛屿的数量 {

    public static void main(String[] args){

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));

    }


    // 二维数组的遍历：基于二叉树实际上是有一个框架的DFS递归框架
    public static int numIslands(char[][] grid) {
       if (grid == null || grid.length == 0) {
           return 0;
       }

       //定义行、列
        int nr = grid.length;
        int nc = grid[0].length;
        int numIsLands = 0 ;// 岛屿个数初始值

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                // 当该节点值为1时，表示这个是个岛屿，然后进行深度优先遍历（并且将找到的相邻的表格标记为2） ，然后所有的未遍历的表格从一开始进行累加就是岛屿数量
                if (grid[i][j] == '1') {
                    ++numIsLands; // 就算找到一个岛屿了，如果这个岛屿全部连接其他的表格，那么第二轮循环将找不到gird[i][j]=1的
                    dfs(grid, i, j);
                }
            }
        }
        return numIsLands;
    }

    // 深度优先遍历：标记连接的是岛屿的表格
    private static void dfs(char[][] grid, int i, int j) {
        // 如果是不合法的数据，则直接返回
        if (!inArea(grid,i,j)) {
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        // 标记：已经遍历过的标记为2
        grid[i][j] = '2';

        // 递归上下左右四个相邻表格
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }

    // 是否在表格有效范围内
    private static boolean inArea(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
