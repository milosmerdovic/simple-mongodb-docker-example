package com.ecommerce.items.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {
    private static final long serialNumberID = 899405112022L;
    private int operationResultCode;
    private String operationResultDescription;
    private int returnedObjectNumber;
    private long totalObjectNumber;
    private T payload;
    private List<ErrorDetail> details;
}
