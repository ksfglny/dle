package com.qq.common;

import java.io.Serializable;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class QQonLineUserList extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8149737703645339913L;

	public QQonLineUserList(HashMap<String, Socket>  onlineUser ) {
		for (String key : onlineUser.keySet()) {
			this.content=this.content+key+",";
		}
		this.time=getTime();
		this.sender="";
		this.getter="";
	}
}
