package org.abratuhi.quarkus;

import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@JBossLog
@ApplicationScoped
public class SmartMeterValueDoublingProcessor {
    @Incoming("string-in")
    @Outgoing("string-out")
    public String x2(String str) {
        log.info(str);

        if (str == null) {
            return null;
        }

        return str + str;
    }
}
