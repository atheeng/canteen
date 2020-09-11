package com.fuseCanteen.canteen.dto;

import org.springframework.stereotype.Component;

@Component
public class RestResponseDto {
    private String message;

    private String response;

    private Object detail;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = String.valueOf(response);
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }
}
