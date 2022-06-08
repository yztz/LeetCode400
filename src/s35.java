import java.util.Arrays;

public class s35 {
    public boolean isBoomerang(int[][] points) {
        int[] vec0 = new int[]{points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] vec1 = new int[]{points[2][0] - points[0][0], points[2][1] - points[0][1]};

        return vec0[0] * vec1[1] - vec0[1] * vec1[0] != 0;
    }
}
