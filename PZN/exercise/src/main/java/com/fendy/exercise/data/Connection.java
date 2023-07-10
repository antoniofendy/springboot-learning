package com.fendy.exercise.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class Connection implements InitializingBean, DisposableBean {

    // this method will be run when the beans is ready to use
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Connection is ready to be used");
    }

    // this method will be run when the application shutdown
    @Override
    public void destroy() throws Exception {
        log.info("Connection is closed");
    }
}
