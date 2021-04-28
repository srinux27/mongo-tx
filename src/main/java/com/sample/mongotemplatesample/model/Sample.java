package com.sample.mongotemplatesample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sample {
    private String id;
    private String objectName;
    private String objectType;
    private String processMessage;
}
