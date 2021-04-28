package com.sample.mongotemplatesample.processor;

import com.sample.mongotemplatesample.dto.SampleDTO;
import com.sample.mongotemplatesample.service.SampleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.config.ListenerContainerCustomizer;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.transaction.ChainedKafkaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
@EnableTransactionManagement
public class MessageProcessor {

    private SampleService sampleService;

    private StreamBridge streamBridge;

    private MongoTransactionManager mongoTransactionManager;

    @Bean
    @Transactional
    public Function<SampleDTO, SampleDTO> process() {
        return message -> {
            message.getSample().setProcessMessage("Processed");
            message.getSampleChild().setProcessMessage("Processed");
            streamBridge.send("bridge-out-0", message);

            if (false)
                throw new RuntimeException("Simulating kafka error");

            message.getSample().setProcessMessage("Processed-2");
            message.getSampleChild().setProcessMessage("Processed-2");
            streamBridge.send("bridge-out-0", message);
            sampleService.updateSample(message);


            return message;
        };
    }

    @Bean
    public ListenerContainerCustomizer<AbstractMessageListenerContainer<byte[], byte[]>> customizer() {
        // Disable retry in the AfterRollbackProcessor
        return (container, destination, group) ->
                container.getContainerProperties().setTransactionManager(
                        new ChainedKafkaTransactionManager<>(container.getContainerProperties().getTransactionManager(),
                                mongoTransactionManager));
    }
}
