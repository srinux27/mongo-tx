package com.sample.mongotemplatesample.dto;

import com.sample.mongotemplatesample.model.Sample;
import com.sample.mongotemplatesample.model.SampleChild;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleDTO {

    private Sample sample;

    private SampleChild sampleChild;
}
