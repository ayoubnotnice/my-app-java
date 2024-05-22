// package mossaab.ayoub.restservice.services;

// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import mossaab.ayoub.restservice.messages.Message;
// import org.springframework.amqp.rabbit.core.RabbitTemplate;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Service;
// import static mossaab.ayoub.restservice.config.RabbitMqConfig.EXCHANGE_NAME;
// import static mossaab.ayoub.restservice.config.RabbitMqConfig.QUEUE_NAME;


// @Slf4j
// @Service
// @RequiredArgsConstructor
// public class Producer {

//     private final RabbitTemplate rabbitTemplate;

//     public void send(Message message) {
//         rabbitTemplate.convertAndSend(EXCHANGE_NAME,QUEUE_NAME,message);
//         log.info("message with id [{}] has been sent", message.getId());
//     }
// }
