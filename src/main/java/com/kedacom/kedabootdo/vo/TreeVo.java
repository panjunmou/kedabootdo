package com.kedacom.kedabootdo.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 树VO
 * @author chenghogntao
 * created on 2016年5月10日
 *
 */
public class TreeVo {
	
	/**
	 * 资源ID
	 */
	private Long resid;
	/**
	 * 资源text
	 */
	private String text;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 连接
	 */
	private String url;
	/**
	 * 是否展开
	 */
	private Boolean isexpand;
	/**
	 * 是否叶子节点
	 */
	private Boolean leaf;

	/**
	 * 子
	 */
    private List<TreeVo> children;

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	/**
	 * 增加子节点
	 * @param node
	 */
	public void addChild(TreeVo node) {
        if (children == null){
            children = new ArrayList<TreeVo>();
        }
        children.add(node);
	}

	public Long getResid() {
		return resid;
	}

	public void setResid(Long resid) {
		this.resid = resid;
	}

    public List<TreeVo> getChildren() {
        return children;
    }

	public void setChildren(List<TreeVo> children) {
		this.children = children;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getIsexpand() {
		return isexpand;
	}

	public void setIsexpand(Boolean isexpand) {
		this.isexpand = isexpand;
	}
}

