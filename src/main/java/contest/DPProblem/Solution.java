package contest.DPProblem;

public class Solution {

    /**
     * Given a 2D binary matrix filled with 0's and 1's,
     * find the largest rectangle containing all ones and return its area.
     * <p>
     * solution: 记录每一行、每一列当前元素到左上角顶点之间最大的距离
     * 记录后从行或者列逐一分析可能的最大值
     */
    public static int maximalRectangle(char[][] matrix) {
        int w = matrix.length;
        if (w == 0) return -1;
        int h = matrix[0].length;
        int[][] left = new int[w][h];
        int[][] top = new int[w][h];
        for (int i = 0; i < matrix.length; i++) {
            int sumLeft = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] - 48 == 0) {
                    sumLeft = 0;
                } else {
                    sumLeft++;
                }
                left[i][j] = sumLeft;
                if (i == 0) {
                    top[i][j] = matrix[i][j] - 48;
                } else if (matrix[i][j] - 48 != 0) {
                    top[i][j] += top[i - 1][j] + 1;
                }
            }
        }
/*      Print test
        for (int[] aLeft : left) {
            for (int j = 0; j < left[0].length; j++) {
                System.out.print(" " + aLeft[j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int[] aTop : top) {
            for (int j = 0; j < top[0].length; j++) {
                System.out.print(" " + aTop[j]);
            }
            System.out.println();
        }
*/
        int maxArea = 0;
        int area;
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < left[0].length; j++) {
                if (left[i][j] == 0) {
                    continue;
                }
                int minWidth = left[i][j];
                for (int k = 1; k <= top[i][j]; k++) {
                    minWidth = Math.min(minWidth, left[i - k + 1][j]);
                    area = k * minWidth;
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    /**
     * 回文的最小分割数
     * 1.dp[i]表示当前i到len-1这段的最小分割数
     * 2.dp[i]=min{dp[j+1]+1}（i=<j<len）其中str[i..j]必须是回文、
     * 3.isPalindrome[i][j]=true表示str[i..j]是回文
     * 4.isPalindrome[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2||isPalindrome[i+1][j-1])
     *
     * @param s
     * @return
     */
    public static int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        dp[s.length()] = -1;    //确保dp[s.length()-1]=0
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        char[][] matrix = {
                "0110".toCharArray(),
                "1111".toCharArray(),
                "1111".toCharArray(),
                "1110".toCharArray()};
        System.out.println(maximalRectangle(matrix));
    }


}
