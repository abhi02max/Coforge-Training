package com.coforge.departmentservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetails {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String path;

    public ErrorDetails() {
    }

    public ErrorDetails(LocalDateTime timestamp, int status, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static ErrorDetailsBuilder builder() {
        return new ErrorDetailsBuilder();
    }

    public static class ErrorDetailsBuilder {
        private LocalDateTime timestamp;
        private int status;
        private String message;
        private String path;

        public ErrorDetailsBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ErrorDetailsBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorDetailsBuilder path(String path) {
            this.path = path;
            return this;
        }

        public ErrorDetails build() {
            return new ErrorDetails(timestamp, status, message, path);
        }
    }
}
