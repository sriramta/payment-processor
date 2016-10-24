package org.acme.micro.streaming.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaMessageConsumer {

	public void consumeSimple() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.249.129:9092");
		props.put("enable.auto.commit", "false");
		props.put("auto.commit.interval.ms", "1000");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer-1");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "pain-consumers");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("rawpain"));

		try {
			while (true) {
				ConsumerRecords<String, String> msgRecs = consumer.poll(100);
				for (ConsumerRecord<String, String> record : msgRecs) {
					System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(),
							record.value());
					consumer.commitSync();
				}

			}
		} finally {
			consumer.close();
		}

	}

	public static void main(String[] args) {
		KafkaMessageConsumer msgCon = new KafkaMessageConsumer();
		msgCon.consumeSimple();
	}

}
