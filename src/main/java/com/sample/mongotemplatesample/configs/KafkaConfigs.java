package com.sample.mongotemplatesample.configs;

import org.springframework.cloud.stream.binder.BinderFactory;
import org.springframework.cloud.stream.binder.kafka.KafkaMessageChannelBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.transaction.KafkaTransactionManager;
import org.springframework.messaging.MessageChannel;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class KafkaConfigs {

    @Bean
    @Primary
    public PlatformTransactionManager kafkaTransactionManager(BinderFactory binders) {
        ProducerFactory<byte[], byte[]> pf = ((KafkaMessageChannelBinder) binders.getBinder("kafka",
                MessageChannel.class)).getTransactionalProducerFactory();
        return new KafkaTransactionManager<>(pf);
    }

}
