package com.gm.base.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gm.utils.StringUtil;

@Component
public class SuperTree {

	private List<String> sonList = new ArrayList<String>();
	private List<String> parentList = new ArrayList<String>();

	/**
	 * 根据父节点的ID获取所有子节点
	 * 
	 * @param list
	 *            分类表
	 * @param nodeId
	 *            传入的父节点ID
	 * @return List<String>
	 */
	public List<String> getChildNodes(List<Node> list, String nodeId) {
		if (list == null && nodeId == null)
			return null;
		for (Iterator<Node> iterator = list.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			// 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (null != node.getParentId() && !"".equals(node.getParentId().trim())
					&& nodeId.equals(node.getParentId())) {
				recursionFn(list, node);
			}
		}
		return sonList;
	}

	private void recursionFn(List<Node> list, Node node) {
		List<Node> childList = getChildList(list, node);// 得到子节点列表
		if (hasChild(list, node)) {// 判断是否有子节点
			sonList.add(node.getId());
			Iterator<Node> it = childList.iterator();
			while (it.hasNext()) {
				Node n = (Node) it.next();
				recursionFn(list, n);
			}
		} else {
			sonList.add(node.getId());
		}
	}

	public List<String> getParentNodes(List<Node> list, String nodeId) {
		if (list == null && nodeId == null)
			return null;
		for (Node node : list) {
			if (node.getId().equals(nodeId)) {
				recursionFn2(list, node);
			}
		}
		return parentList;
	}

	private void recursionFn2(List<Node> list, Node node) {
		for (Node n : list) {
			if (node.getParentId().equals(n.getId())) {
				parentList.add(n.getId());
				recursionFn2(list, n);
			}
		}
	}

	// 得到子节点列表
	private List<Node> getChildList(List<Node> list, Node node) {
		List<Node> nodeList = new ArrayList<Node>();
		Iterator<Node> it = list.iterator();
		while (it.hasNext()) {
			Node n = (Node) it.next();
			if (null != n.getParentId() && !"".equals(n.getParentId().trim()) && n.getParentId().equals(node.getId())) {
				nodeList.add(n);
			}
		}
		return nodeList;
	}

	// 判断是否有子节点
	private boolean hasChild(List<Node> list, Node node) {
		return getChildList(list, node).size() > 0;
	}
}