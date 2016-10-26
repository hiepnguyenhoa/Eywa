package me.hnguyen.eywa.logging;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import me.hnguyen.eywa.Neo4JContext;

/**
 * @author hnguyen
 */
@Configuration
@ComponentScan(basePackages = {"me.hnguyen.eywa"})
@Import(value = Neo4JContext.class)
public class LoggingConfiguration {

}
