import java.util.*;
/* https://leetcode.cn/problems/cut-off-trees-for-golf-event/ */
public class s19 {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        int row = forest.size();
        int col = forest.get(0).size();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int h = forest.get(i).get(j);
                if (h > 1) {
                    list.add(new int[] {h, i, j});
                }
            }
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int x = 0, y = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] tree = list.get(i);
            int step = getStep(forest, x, y, tree[1], tree[2]);
            if (step < 0) return -1;
            ans += step;
            x = tree[1];
            y = tree[2];
        }

        return ans;
    }


    private int getStep(List<List<Integer>> forest, int x, int y, int tx, int ty) {
        if (x == tx && y == ty) return 0;

        int row = forest.size();
        int col = forest.get(0).size();
        boolean[][] visited = new boolean[row][col];
        int step = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] DIR : DIRS) {
                    int nx = pos[0] + DIR[0];
                    int ny = pos[1] + DIR[1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                        if (nx == tx && ny == ty) return step;
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return -1;
    }
}
