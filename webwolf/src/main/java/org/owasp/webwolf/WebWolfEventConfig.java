package org.owasp.webwolf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WebWolfEventConfig {

    private int port;

    public WebWolfEventConfig(@Value("${server.port}") int port) {
        this.port = port;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void started() {
        log.info("Browse to http://localhost:{}/WebWolf to get started", port);
    }
}
