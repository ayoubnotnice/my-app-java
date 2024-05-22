// package mossaab.ayoub.restservice.config;

// import org.springframework.amqp.core.Binding;
// import org.springframework.amqp.core.BindingBuilder;
// import org.springframework.amqp.core.DirectExchange;
// import org.springframework.amqp.core.Queue;
// import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.messaging.converter.MessageConverter;

// @Configuration
// public class RabbitMqConfig {

//     public static final String QUEUE_NAME = "test-queue";  // Removed unnecessary prefix "q."
//     public static final String EXCHANGE_NAME = "test-exchange"; // Removed unnecessary prefix "ex."

//     @Bean
//     public Queue queue() {
//         return new Queue(QUEUE_NAME, false);
//     }

//     @Bean
//     public DirectExchange exchange() {
//         return new DirectExchange(EXCHANGE_NAME, false, false);
//     }

//     @Bean
//     public Binding binding(Queue queue, DirectExchange exchange) {
//         return BindingBuilder.bind(queue).to(exchange).with(QUEUE_NAME);
//     }

//     @Bean
//     public Jackson2JsonMessageConverter messageConverter() {
//         return new Jackson2JsonMessageConverter();
//     }
// }
