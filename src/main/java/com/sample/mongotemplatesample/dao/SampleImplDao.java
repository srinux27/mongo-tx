package com.sample.mongotemplatesample.dao;

import com.sample.mongotemplatesample.model.Sample;
import com.sample.mongotemplatesample.model.SampleChild;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SampleImplDao {

    private MongoTemplate mongoTemplate;

    public boolean saveSampleObject(Sample sample) {
        Query query = new Query(Criteria.where("id").is(sample.getId()));
        Update update = new Update().set("id", sample);
        mongoTemplate.upsert(query, update, "sample");

        return true;
    }

    public boolean saveSampleChildObject(SampleChild sampleChild) {
        Query query = new Query(Criteria.where("id").is(sampleChild.getId()));
        Update update = new Update().set("id", sampleChild);
        mongoTemplate.upsert(query, update, "sampleChildren");

        return true;
    }
}
