# Springboot AMQP Pattern using RabbitMQ

Create a simple Messaging pattern using AMQP based RabbitMQ with Springboot.
This does the following

1) Create configuration
    (i) for 2 queues generic queue, specific queue
    (ii) bind it to the exchange with routing key
    (iii) Create configuration using RabbitListenerConfigurer for converting the
    java serialized messages into JSON responses.

2) Create Sender which will send messages every 2 secs on this exchange
3) Create Receiver which receives from both of these queues
