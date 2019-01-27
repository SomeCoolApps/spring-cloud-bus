# spring-cloud-bus
Summary of Notes
For config server changes the client is responsible for checking for updates and refresh the config.
To implement a system where the config is pushed to the client instead and the client does not need a restart we can utilize Spring cloud bus.  The way it works is that any change that config server receives is pushed onto a queue[RabbitMQ/Kafka], and the clients can subscribe to the change using the amqp client. 
The only manual step in this setup will be to update the config server once the property repository is changed.

Key Points
Setup RabitMQ server:
* Install RabitMQ server or run it though docker.
* spring amqp should be able to use the default setup if no changes to config are done in local env.
* if rabbitMQ is using non-default config, the below project will need to use the specific rabitMQ config by updating the spring.rabitmq properties in application.properties.
Config Server
* for the config server we need to include the dependencies for 
    * spring-cloud-config-server
    * spring-cloud-starter-bus-amqp
    * spring-boot-starter-actuator
* also we need to expose the bus-refresh actuator end point in application.yml
    * management.endpoints.web.exposure.include: health,info,bus-refresh
* and the usual setup for a config server 
Config server Client
* We need to set up the properties for config server spring.cloud.config.uri
* Include dependencies for actuator and amqp as above for the server.
This setup should be enough to refresh properties in the client without client need to restart or manually fetch config changes.
How to update the config:
* update the config in the base repository file 
* invoke the post command on actuator/bus-refresh end point on the config server. 
* the client should be refreshed with new property values. 

  

