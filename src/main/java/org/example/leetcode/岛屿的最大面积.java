package org.example.leetcode;

//https://leetcode.cn/problems/max-area-of-island/
public class 岛屿的最大面积 {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(maxAreaOfIsland(grid));

    }

    private static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length; // 行
        int nc = grid[0].length; // 列
        int maxAreaOdIsland = 0; // 岛屿面积

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 1) {
                    // 当遇到一个岛屿的时候，就进行递归，在递归中标记已经遍历过的岛屿=2
                    int sum = dfs(grid, i, j);  //返回这个岛屿的面积
                    maxAreaOdIsland = Math.max(maxAreaOdIsland, sum);

                }
            }
        }

        return maxAreaOdIsland;
    }

    // 深度遍历：递归
    private static int dfs(int[][] grid, int i, int j) {
        // base 条件：非法数据直接返回
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        //岛屿个数：需要加1
        int sum = 1;
        grid[i][j] = 0;// 进行标记

        sum += dfs(grid, i, j - 1);
        sum += dfs(grid, i, j + 1);
        sum += dfs(grid, i - 1, j);
        sum += dfs(grid, i + 1, j);


        return sum;
    }


}
