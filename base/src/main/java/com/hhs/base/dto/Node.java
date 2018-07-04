package com.hhs.base.dto;

import com.hhs.base.model.Member;

/**
 * 无限级节点模型
 */
public class Node {
	/**
	 * 节点id
	 */
	private String id;

	/**
	 * 节点名称
	 */
	private String nodeName;

	/**
	 * 父节点id
	 */
	private String parentId;

	public Node() {
	}

	public Node(String id, String parentId) {
		this.id = id;
		this.parentId = parentId;
	}

	public Node(String id, String nodeName, String parentId) {
		this.id = id;
		this.nodeName = nodeName;
		this.parentId = parentId;
	}

	public Node(Member member) {
		this.id = member.getGeneralizeId();
		this.parentId = member.getReferrerGeneralizeId();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
}