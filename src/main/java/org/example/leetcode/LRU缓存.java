package org.example.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 */
public class LRU缓存 {
    // 思路：需要使用双向链表+hash表实现。  现有的java类库：LinkedHashMap

}

class LRUCache {

    private int capacity; //容量
    private Map<Integer, Integer> cache = new LinkedHashMap<>();  // 保持插入顺序，然后获取也很快


    public LRUCache(int capacity) {
        // 初始化缓存
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.get(key) != null) {

            // 提前到队列尾部， 先删除，在添加即可 （尾部的总是最新的）
            takeToTail(key);
            return cache.get(key);

        }
        return -1;
    }

    // 更新值的位置
    private void takeToTail(int key) {
        Integer val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

    public void put(int key, int value) {
        // 是否已经存在
        if (cache.get(key) != null) {
            cache.put(key, value);
            takeToTail(key);
        } else {
            if (cache.size()<capacity) {
                cache.put(key, value);
            } else {
                // 内存空间不足，移除队列首部的值，然后在队列尾部插入新值
                Integer headKey = cache.keySet().iterator().next();
                cache.remove(headKey);
                cache.put(key, value);
            }
        }
    }
}