/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.utilities;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class AjaxResponse implements Serializable{
    private String status;
	private Object data;
	
	public AjaxResponse(){
		
	}
	
	public AjaxResponse(String status, Object data){
		this.status = status;
		this.data = data;
	}
 
	public String getStatus() {
		return status;
	}
 
	public void setStatus(String status) {
		this.status = status;
	}
 
	public Object getData() {
		return data;
	}
 
	public void setData(Object data) {
		this.data = data;
	}
}
