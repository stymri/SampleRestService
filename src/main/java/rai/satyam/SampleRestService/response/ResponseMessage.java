package rai.satyam.SampleRestService.response;

public class ResponseMessage {
	private int id;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseMessage(int id, String message) {
		this.id = id;
		this.message = message;
	}
	public ResponseMessage() {}
}
