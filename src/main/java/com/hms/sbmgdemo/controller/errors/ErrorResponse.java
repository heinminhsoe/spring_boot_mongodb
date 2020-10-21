package com.hms.sbmgdemo.controller.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    @NonNull
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FieldError> fieldErrors;


    @Data
    @AllArgsConstructor
    public static class FieldError {
        private String fieldName;
        private String description;
    }
}
