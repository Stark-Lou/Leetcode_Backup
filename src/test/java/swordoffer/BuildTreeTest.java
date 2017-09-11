package swordoffer;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by louzh on 2017/6/19.
 */
class BuildTreeTest {
    @org.junit.jupiter.api.Test
    void reConstructBinaryTree() {
        int[] a = {2, 3, 5, 1, 0, 9, 8, 7, 6};
        Arrays.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

}