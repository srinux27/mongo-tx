package com.sample.mongotemplatesample.service;

import com.sample.mongotemplatesample.dao.SampleImplDao;
import com.sample.mongotemplatesample.dto.SampleDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SampleServiceImpl implements SampleService {
    private SampleImplDao sampleImplDao;

    @Override
    @Transactional
    public boolean updateSample(SampleDTO sample) {
        sampleImplDao.saveSampleObject(sample.getSample());
        if (true)
            throw new RuntimeException("Simulating error");
        sampleImplDao.saveSampleChildObject(sample.getSampleChild());

        return false;
    }
}
