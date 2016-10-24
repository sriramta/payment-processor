package org.acme.micro.streaming.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaStreamProducer {

	public void produceMessage() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "osboxes:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);

		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);
		for (int i = 100000; i < 100010; i++) {
			producer.send(new ProducerRecord("acme-test", "key" + i, "value" + i));
		}

		producer.close();

	}

	public static void main(String[] args) {
		KafkaStreamProducer prod = new KafkaStreamProducer();
		prod.produceMessage();
	}

}
