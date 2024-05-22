// package mossaab.ayoub.restservice.services;

// import lombok.extern.slf4j.Slf4j;
// import mossaab.ayoub.restservice.messages.Message;
// import org.springframework.amqp.rabbit.annotation.RabbitListener;
// import org.springframework.stereotype.Service;

// import static mossaab.ayoub.restservice.config.RabbitMqConfig.QUEUE_NAME;

// @Slf4j
// @Service
// public class Consumer {

//     @RabbitListener(queues = {QUEUE_NAME})
//     public void consume(Message message) {
//         log.info("Received message: " + message);
//     }
// }
