package me.hnguyen.eywa.logging;

import me.hnguyen.eywa.Neo4JContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author hnguyen
 */
@Configuration
@ComponentScan(basePackages={"me.hnguyen.eywa"})
@Import(value = Neo4JContext.class)
public class LoggingConfiguration {
    
}
