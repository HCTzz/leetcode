package com.hf;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**水桶问题
 * @Description
 * @auther Administrator
 * @create 2020-03-22 下午 3:29
 */
public class CanMeasureWater {

    /**************************广度搜索*****************************************/
    private LinkedList<int[]> queue;
    private Set<Long> visited;
    private int capY;

    private void handle(int x, int y) {
        long key = x * (capY + 1L) + y;
        if (!visited.contains(key)) {
            queue.offer(new int[]{x, y});
            visited.add(key);
        }
    }

    private boolean bfs(int capX, int capY, int z) {
        this.capY = capY;
        queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited = new HashSet<>();
        visited.add(0L);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int curX = node[0];
                int curY = node[1];
                if (curX + curY == z || curX == z || curY == z) {
                    return true;
                }
                // 水壶1装满
                handle(capX, curY);
                // 水壶1清空
                handle(0, curY);
                // 水壶2装满
                handle(curX, capY);
                // 水壶2清空
                handle(curX, 0);
                // 水壶1往水壶2倒
                int diff1 = Integer.min(curX, capY - curY);
                handle(curX - diff1, curY + diff1);
                // 水壶2往水壶1倒
                int diff2 = Integer.min(curY, capX - curX);
                handle(curX + diff2, curY - diff2);
            }
        }

        return false;
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == x || z == y || z == 0) {
            return true;
        }

        if (x + y < z || x == y && x + y != z) {
            return false;
        }

        return bfs(x, y, z);
    }
    /**************************广度搜索*****************************************/

    /**************************数学方法*****************************************/
    public boolean canMeasureWater1(int x, int y, int z) {
        if(x + y < z){
            return false;
        }
        if(x == 0 || y == 0){
            return z == 0 || x + y == z;
        }
        // 求最大公约数
        int bigComponent;
        int tmpMax = Math.max(x, y);
        int tmpMin = Math.min(x, y);
//        bigComponent = tmpMax % tmpMin;
//        if (bigComponent == 0) {
//            if (z % tmpMin == 0) {
//                return true;
//            }
//        }
        while ((bigComponent = tmpMax % tmpMin) != 0) {
            tmpMax = tmpMin;
            tmpMin = bigComponent;
//            bigComponent = tmpMax % tmpMin;
        }
        if (z % tmpMin == 0) {
            return true;
        }
        return false;
    }
}
