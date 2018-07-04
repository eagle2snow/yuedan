package com.gm.base.dto;

import java.util.ArrayList;
import java.util.List;

public class Test {

	// 本地模拟数据测试
	public static void main(String[] args) {
		List<Node> nodeList = new ArrayList<Node>();

		Node node1 = new Node("1", "0");
		Node node2 = new Node("2", "1");
		Node node3 = new Node("3", "1");
		Node node4 = new Node("4", "2");
		Node node5 = new Node("5", "2");
		Node node6 = new Node("6", "4");
		// Node node4 = new Node("100004", "100001");
		// Node node5 = new Node("100005", "100002");
		// Node node6 = new Node("100006", "100002");
		// Node node7 = new Node("100007", "100002");
		// Node node8 = new Node("100008", "100002");
		// Node node9 = new Node("100009", "100003");
		// Node node10 = new Node("100010", "100003");
		// Node node11 = new Node("100011", "100003");
		// Node node12 = new Node("100012", "100004");
		// Node node13 = new Node("100013", "100005");
		// Node node14 = new Node("100014", "100005");
		// Node node15 = new Node("100015", "100005");
		// Node node16 = new Node("100016", "100014");
		// Node node17 = new Node("100017", "100014");
		// Node node18 = new Node("100018", "100017");

		nodeList.add(node1);
		nodeList.add(node2);
		nodeList.add(node3);
		nodeList.add(node4);
		nodeList.add(node5);
		nodeList.add(node6);
		// nodeList.add(node4);
		// nodeList.add(node5);
		// nodeList.add(node6);
		// nodeList.add(node7);
		// nodeList.add(node8);
		// nodeList.add(node9);
		// nodeList.add(node10);
		// nodeList.add(node11);
		// nodeList.add(node12);
		// nodeList.add(node13);
		// nodeList.add(node14);
		// nodeList.add(node15);
		// nodeList.add(node16);
		// nodeList.add(node17);
		// nodeList.add(node18);

		SuperTree mt = new SuperTree();
		List<String> ids = mt.getChildNodes(nodeList, "2");
		for (String string : ids) {
			System.out.println(string);
		}
		
	}

}