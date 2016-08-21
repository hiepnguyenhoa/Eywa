# Eywa
Inspired of "I Heart Logs" by Jay Kreps and difficulties of investigation of issues in production environments, I developed Eywa, a logging system, uses rabbitmq to communcate with logged systems and NeoJ4 to store logging messages into a database which helps developers easier in reaching logging.
The system helps robust your system, improves your system architect making it clearer and focusing on businesses.
The system consists of two pars:

1) workig with message queue, RabbitMQ, to receive logging message. Moreover, all message queue information are stored in Neo4J to let configuring RabbitMQ visually and can be changed at runtime (implemented in next version). All information of configuration is used to establish RabbitMQ components consisting of connection factory, exchanges, bindings, and/or message queue(s) if any.

2) processing logging mesage, using Neo4J. To process Logging messages received from RabbitMQ:

     - develop your processor by extending MessageProcessorAbst<T extends BaseDto> and implement messageProcessing(T t) (Eywa will converter receiving messages by Jackson2Json.
     - develop your logging message beans consisting of Bean, Dto, and Entity.

I have developed two message processors (i) PrintOutMessageProcessor to print logging message to consonler; (ii) SaveNeo4JProcessor to save logging message to Neo4J.

To run the system, Neo4J and RabbitMQ must be installed and run properly. Configuration inforamtion are stored in ogm.poperties - Neo4J configuration, eywa-config.xml and eywa-config.properties - RabbitMQ configration and Eywa configuration.

Last but not least, Using Eywa - RabbitMQ module works with RabbitMQ to create RabbitMQ elements, connect, and process message as you want
