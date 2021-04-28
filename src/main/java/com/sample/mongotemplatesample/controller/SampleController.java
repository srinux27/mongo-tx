package com.sample.mongotemplatesample.controller;

import com.sample.mongotemplatesample.dto.SampleDTO;
import com.sample.mongotemplatesample.service.SampleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sample-inbound")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SampleController {

    private SampleService sampleService;

    @RequestMapping(value="/send-message", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> postSampleRequest(@RequestBody SampleDTO sample)
    {
     sampleService.updateSample(sample);
     Map<String, String> responseMap = new HashMap<>();
     responseMap.put("STATUS", "SUCCESS");

     return ResponseEntity.ok(responseMap);
    }
}
