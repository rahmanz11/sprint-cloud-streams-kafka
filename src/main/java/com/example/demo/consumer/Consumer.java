package com.example.demo.consumer;

import com.example.demo.schema.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @StreamListener(Sink.INPUT)
    public void consume(Teacher teacher) {
        LOGGER.info("Consumed message: {}", teacher);
    }
}
