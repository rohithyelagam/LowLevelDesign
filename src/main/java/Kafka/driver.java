package Kafka;

import com.sun.tools.jconsole.JConsoleContext;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;
import java.util.regex.Pattern;

public class driver {
    public static void main(String[] args) {

        try{

            Properties properties = new Properties();

            properties.put(ConsumerConfig.GROUP_ID_CONFIG, "CMDBAssetSyncRealTime");  // Consumer group ID
            properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());  // Key deserializer
            properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());  // Value deserializer
            properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

            properties.put("bootstrap.servers","10.169.88.139:9093,10.169.88.140:9093,10.169.88.137:9093,10.169.88.138:9093,10.169.88.141:9093,10.169.88.136:9093");

            KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

            consumer.subscribe(Pattern.compile("CMDBAssetSyncRealTime"));

            try {
                while (true) {
                    // Poll for messages, with a timeout of 1000 milliseconds
                    var records = consumer.poll(1000);

                    // Iterate through the records
                    records.forEach(record -> {
                        System.out.println("Consumed record: " + record.value());
                        System.out.println("Offset: " + record.offset());
                        System.out.println("Partition: " + record.partition());
                    });
                }
            } finally {
                consumer.close();  // Close the consumer when done
            }

        }catch (Exception e){
            System.out.println("exception e="+e.getMessage());
            e.printStackTrace();
        }
    }
}
