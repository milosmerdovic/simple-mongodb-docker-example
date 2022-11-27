package com.ecommerce.items.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {
    private String field;
    private String source;
    private String code;
    private String message;
}
