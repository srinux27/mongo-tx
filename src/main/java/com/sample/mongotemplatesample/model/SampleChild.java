package com.sample.mongotemplatesample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleChild {
    private String id;
    private String childItemName;
    private String childItemType;
    private String processMessage;
}
