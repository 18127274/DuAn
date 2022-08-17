package DuAn.model;

public class ApiResponse<T> {
	int code;
	String message;
	T payload;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public ApiResponse(int code, String mess,T payload) {
		super();
		this.code = code;
		this.message = mess;
		this.payload = payload;
	}
}
