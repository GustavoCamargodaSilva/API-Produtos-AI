package com.gustavocamargodasilva.produto.dto;

import java.time.Instant;

public class CustomError {

    private Instant timestap;
    private Integer status;
    private String error;
    private String path;

    public CustomError() { }

    public CustomError(Instant timestap, Integer status, String error, String path) {
        this.timestap = timestap;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestap() {
        return timestap;
    }

    public void setTimestap(Instant timestap) {
        this.timestap = timestap;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
