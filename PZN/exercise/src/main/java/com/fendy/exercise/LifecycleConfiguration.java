package com.fendy.exercise;

import com.fendy.exercise.data.Connection;
import com.fendy.exercise.data.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleConfiguration {

    // config bean lifecycle not using bean annotation
    @Bean
    public Connection connection() {
        return new Connection();
    }

    // we can use config bean lifecycle annotation to run method when it initialized and destroyed
    // easier than non bean lifecycle  annotation
    // @Bean(initMethod = "start", destroyMethod = "stop")
    @Bean
    public Server server() {

        return new Server();
    }

}
