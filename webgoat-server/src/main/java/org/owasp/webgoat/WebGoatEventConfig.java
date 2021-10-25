package org.owasp.webgoat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WebGoatEventConfig {

    private int port;

    public WebGoatEventConfig(@Value("${server.port}") int port) {
        this.port = port;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void started() {
        log.info("Browse to http://localhost:{}/WebGoat to get started", port);
    }
}
