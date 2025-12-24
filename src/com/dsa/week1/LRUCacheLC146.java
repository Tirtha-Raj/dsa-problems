package com.dsa.week1;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheLC146 {
//	Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//	Input
//	["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//	[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//	Output
//	[null, null, null, 1, null, -1, null, -1, 3, 4]
	public class Node {
		int key, value;
		Node prev, next;

		public Node(int k, int v) {
			key = k;
			value = v;
		}
	}

	Map<Integer, Node> map;
	Node head, tail;
	int capacity;

	public LRUCacheLC146(int capacity) {
		this.capacity = capacity;

		map = new HashMap<Integer, Node>();

		head = new Node(0, 0);
		tail = new Node(0, 0);

		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		if(!map.containsKey(key)) return -1;
		Node node = map.get(key);
		remove(node);
		addToFront(node);
		return node.value;
	}
	
	public void put(int key, int value) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			map.remove(key);
			remove(node);
		} else {
			if(map.size() >= capacity) {
				Node lru = tail.prev;
				remove(lru);
				map.remove(lru.key);
			}
		}
		Node node = new Node(key, value);
		addToFront(node);
		map.put(key, node);
	}

	private void addToFront(Node node) {
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
		
	}

	private void remove(Node node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}
}
