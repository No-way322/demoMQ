package com.qif.mainstate.util.node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qif.mainstate.util.DealString;


public class Node implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5121478741148825954L;

	public static final String  URL = "url";
	
	public static final String 	ICON_CLS = "iconCls";
	
	private String 		id;
	
	private String 		text;
	
	private String 		pId;
	
	private String 		iconCls;
	
	private Map<String,Object> tag = new HashMap<String, Object>();
	
	private String		state;
	
	private boolean		checked;
	
	private int			flag;
	
	
	private String		phoneticize;
	
	private Map<String,Object> alarm_Status = new HashMap<String, Object>();
	
	private Map<String,Object> attributes = new HashMap<String, Object>();
	
	private List<Node>  children = new ArrayList<Node>();
	
	public Node(){
		
	}
	
	public Node(String id, String text, String pId,String iconCls ) {
		this.id = id;
		this.text = text;
		this.pId = pId;
		if(!"".equals(DealString.toString(iconCls))){
			this.attributes.put(ICON_CLS, iconCls);
		}
	}
	public Node(String id, String text, String pId, String url,String iconCls) {
		this.id = id;
		this.text = text;
		this.pId = pId;
		if(!"".equals(DealString.toString(url))){
			this.attributes.put(URL, url);
		}
		if(!"".equals(DealString.toString(iconCls))){
			this.attributes.put(ICON_CLS, iconCls);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Map<String, Object> getTag() {
		return tag;
	}

	public void setTag(Map<String, Object> tag) {
		this.tag = tag;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getPhoneticize() {
		return phoneticize;
	}

	public void setPhoneticize(String phoneticize) {
		this.phoneticize = phoneticize;
	}

	public Map<String, Object> getAlarm_Status() {
		return alarm_Status;
	}

	public void setAlarm_Status(Map<String, Object> alarm_Status) {
		this.alarm_Status = alarm_Status;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
}
