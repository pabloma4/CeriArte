package com.ceriarte.central.excepciones;

import com.ceriarte.central.enums.ErrorCodeEnum;

public class ServidorCentralBusinessException extends RuntimeException{

    private static final long serialVersionUID = 3168916215544421958L;
    private ErrorCodeEnum errorCode;
    private String errorData;
	
    public ServidorCentralBusinessException(String msg) {
        super(msg);
    }
    
	public ServidorCentralBusinessException(ErrorCodeEnum errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }
	
	public ServidorCentralBusinessException(ErrorCodeEnum errorCode, String errorData, String msg) {
        super(msg);
        this.errorCode = errorCode;
        this.errorData = errorData;
    }

	public ErrorCodeEnum getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCodeEnum errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorData() {
		return errorData;
	}

	public void setErrorData(String errorData) {
		this.errorData = errorData;
	}
}
