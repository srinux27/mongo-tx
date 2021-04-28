package com.sample.mongotemplatesample.configs;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;


//@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChainedTransactionConfig {

    private MongoTransactionManager mongoTransactionManager;

    private PlatformTransactionManager kafkaTransactionManager;

    //@Bean
    //@Primary
    public PlatformTransactionManager transactionManager() {
        ChainedTransactionManager chainedTransactionManager = new
                ChainedTransactionManager(
                        this.mongoTransactionManager,
                        this.kafkaTransactionManager);
        return chainedTransactionManager;
    }
}
