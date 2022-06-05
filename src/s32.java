import java.util.Random;
/* https://leetcode.cn/problems/generate-random-point-in-a-circle/ */
public class s32 {
    static class Solution {
        double radius, x_center, y_center;
        Random random = new Random();

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {
            double theta = 2 * Math.PI * random.nextDouble();
            double fai = Math.sqrt(radius * radius * random.nextDouble());
            double x = x_center + fai * Math.cos(theta);
            double y = y_center + fai * Math.sin(theta);
            return new double[]{x, y};
        }
    }
}
