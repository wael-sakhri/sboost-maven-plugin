package io.sakhri.sourceboost.generic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseData {

	private String code;
	private String message;
	private String source;
	private HttpStatus status;
	private Object responseData;
	private Object extraData;
	private boolean warning;
	private List<ResponseData> extraMessages;

	public ResponseData() {
		super();
		this.extraMessages = new ArrayList<>();
	}

	public ResponseData(String code, String message) {
		super();
		this.code = code;
		this.message = message;
		this.extraMessages = new ArrayList<>();
	}

	public ResponseData(String code, String message, String source, HttpStatus status) {
		super();
		this.code = code;
		this.message = message;
		this.source = source;
		this.status = status;
		this.extraMessages = new ArrayList<>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public List<ResponseData> getExtraMessages() {
		return extraMessages;
	}

	public void setExtraMessages(List<ResponseData> extraMessages) {
		this.extraMessages = extraMessages;
	}

	public void addExtraMessage(ResponseData msg) {

		if (this.extraMessages == null) {
			this.extraMessages = new ArrayList<>();
		}

		this.extraMessages.add(msg);
		this.setCode("EXTRA");
	}

	public Object getExtraData() {
		return extraData;
	}

	public void setExtraData(Object extraData) {
		this.extraData = extraData;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

	public boolean isWarning() {
		return warning;
	}

	public void setWarning(boolean warning) {
		this.warning = warning;
	}

	@Override
	public String toString() {
		return "ResponseMessage [code=" + code + ", message=" + message + ", source=" + source + ", status=" + status
				+ ", extraData=" + extraData + ", extraMessages=" + extraMessages + "]";
	}

}
