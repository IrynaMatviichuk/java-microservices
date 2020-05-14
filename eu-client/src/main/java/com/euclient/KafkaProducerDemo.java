package com.euclient;

import com.euclient.apartmentsService.Apartment;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo {

    private final static String TOPIC_CREATED = "create.entity";
    private final static String TOPIC_UPDATED = "update.entity";
    private final static String BOOTSTRAP_SERVERS = "kafka:9092";

    private static Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return new KafkaProducer<>(props);
    }

    public static void sendCreateMessage(Apartment apartment) throws Exception {
        final Producer<Long, String> producer = createProducer();

        try {
            final ProducerRecord<Long, String> record = new ProducerRecord<>(
                    TOPIC_CREATED, apartment.getId(), apartment.getApartmentCondition()
            );

            RecordMetadata metadata = producer.send(record).get();

            System.out.printf(
                    "sent records(key=%s value=%s) meta(partition=%d offset=%d)",
                    record.key(), record.value(), metadata.partition(), metadata.offset()
            );
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        } finally {
            producer.flush();
            producer.close();
        }
    }

    public static void sendUpdateMessage(Apartment apartment) throws Exception {
        final Producer<Long, String> producer = createProducer();

        try {
            final ProducerRecord<Long, String> record = new ProducerRecord<>(
                    TOPIC_UPDATED, apartment.getId(),apartment.getApartmentCondition()
            );

            RecordMetadata metadata = producer.send(record).get();
            System.out.printf(
                    "sent records(key=%s value=%s) meta(partition=%d offset=%d)",
                    record.key(), record.value(), metadata.partition(), metadata.offset()
            );
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        } finally {
            producer.flush();
            producer.close();
        }
    }
}
