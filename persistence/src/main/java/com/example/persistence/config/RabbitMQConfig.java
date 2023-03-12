package com.example.persistence.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CREATE_TASK = "CreateTask";
    public static final String UPDATE_BY_ADMIN = "UpdateByAdmin";
    public static final String UPDATE_TASK_BY_USER = "UpdateTaskByUser";



    public static String queueName = "crateQueue";
    public static String exchange = "crateExchange";
    public static String routingKey = "rabbitmqRoutingKey";


    @Bean
    Queue crateDecisiveUserExcelQueue() {
        return new Queue(queueName, false);
    }

    @Bean
    DirectExchange crateDecisiveUserExcelExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding bindingForDecisiveUserExcel(Queue crateDecisiveUserExcelQueue,
                                        DirectExchange crateDecisiveUserExcelExchange) {
        return BindingBuilder.bind(crateDecisiveUserExcelQueue).to(crateDecisiveUserExcelExchange).with(routingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // message converter
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    // configure RabbitTemplate
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
