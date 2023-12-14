package com.bob;

import java.util.HashMap;
import java.util.Map;

/**
 * Java program for LFU Cache (https://en.wikipedia.org/wiki/Least_frequently_used)
 * LFU缓存的Java程序
 * 作者：Akshay Dubey (https://github.com/itsAkshayDubey)
 */
public class LFUCache<K, V> {

    // 内部类表示缓存中的节点
    private class Node {

        private K key;
        private V value;
        private int frequency;
        private Node previous;
        private Node next;

        public Node(K key, V value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }

    private Node head; // 缓存中头部节点
    private Node tail; // 缓存中尾部节点
    private Map<K, Node> map = null; // 用于存储键和节点的映射关系
    private Integer capacity; // 缓存容量
    private static final int DEFAULT_CAPACITY = 100; // 默认容量为100
    public LFUCache() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public LFUCache(Integer capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    /**
     * 通过传入的键获取
     *缓存中对应的值
     * @param <K> 键的类型
     * @returns <V> 与传入键对应的值，如果键不存在则返回null
     */
    public V get(K key) {
        if (this.map.get(key) == null) {
            return null;
        }

        Node node = map.get(key);
        removeNode(node);
        node.frequency += 1;
        addNodeWithUpdatedFrequency(node);

        return node.value;
    }

    /**
     * 将键值对存储到缓存中
     *
     * @param <K> 要存储的键
     * @param <V> 要存储的值
     */
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            node.frequency += 1;
            removeNode(node);
            addNodeWithUpdatedFrequency(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(this.head.key);
                removeNode(head);
            }
            Node node = new Node(key, value, 1);
            addNodeWithUpdatedFrequency(node);
            map.put(key, node);
        }
    }

    /**
     * 将节点以更新频率的方式存储到缓存中
     *
     * @param Node 要存储的节点
     */
    private void addNodeWithUpdatedFrequency(Node node) {
        if (tail != null && head != null) {
            Node temp = this.head;
            while (temp != null) {
                if (temp.frequency > node.frequency) {
                    if (temp == head) {
                        node.next = temp;
                        temp.previous = node;
                        this.head = node;
                        break;
                    } else {
                        node.next = temp;
                        node.previous = temp.previous;
                        temp.previous.next = node;
                        temp.previous = node;
                        break;
                    }
                } else {
                    temp = temp.next;
                    if (temp == null) {
                        tail.next = node;
                        node.previous = tail;
                        node.next = null;
                        tail = node;
                        break;
                    }
                }
            }
        } else {
            tail = node;
            head = tail;
        }
    }

    /**
     * 从缓存中移除节点
     *
     * @param Node 要移除的节点
     */
    private void removeNode(Node node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            this.head = node.next;
        }

        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            this.tail = node.previous;
        }
    }
}