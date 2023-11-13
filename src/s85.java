import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* https://leetcode.cn/problems/making-a-large-island/ */
public class s85 {

    private static final int[] dir = {0, 1, 0, -1, 0};
    int nextArea = 2;

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> area = new HashMap<>();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int newArea = nextArea++;
                    area.put(newArea, findArea(grid, i, j, newArea));
                    ans = Math.max(ans, area.get(newArea));
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> connected = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dir[k];
                        int ny = j + dir[k + 1];
                        if(valid(nx, ny, n) && grid[nx][ny] > 0) {
                            connected.add(grid[nx][ny]);
                        }
                    }
                    int res = 1;
                    for (int t : connected) {
                        res += area.get(t);
                    }
                    ans = Math.max(ans, res);
                }
            }
        }

        return ans;
    }

    private int findArea(int[][] grid, int x, int y, int area) {
        int n = grid.length, res = 1;

        grid[x][y] = area;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i];
            int ny = y + dir[i + 1];
            if(valid(nx, ny, n) && grid[nx][ny] == 1) {
                res += findArea(grid, nx, ny, area);
            }
        }

        return res;
    }


    private boolean valid(int x, int y, int n) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}
