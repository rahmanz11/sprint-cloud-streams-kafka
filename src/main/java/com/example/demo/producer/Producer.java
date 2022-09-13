package com.example.demo.producer;

import com.example.demo.schema.Teacher;
import com.example.demo.schema.TeacherKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Autowired
    private Sink sink;

    public void produce(int id, String name, int age, String subject) {
        Teacher value = new Teacher();
        value.setId(id);
        value.setName(name);
        value.setAge(age);
        value.setSubject(subject);

        // creating partition key for kafka topic
        TeacherKey key = new TeacherKey();
        key.setId(id);
        key.setSubjectName(subject);

        Message<Teacher> message = MessageBuilder.withPayload(value)
                .setHeader(KafkaHeaders.MESSAGE_KEY, key)
                .build();

        sink.input().send(message);
    }
}
