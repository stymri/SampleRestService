package rai.satyam.SampleRestService.controller.userController;

import rai.satyam.SampleRestService.entity.User;

public class ResponseWrapperAllUser {
	private int status;
	private String msg;
	private Iterable<User> list;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Iterable<User> getList() {
		return list;
	}
	public void setList(Iterable<User> list) {
		this.list = list;
	}
	
	
}
