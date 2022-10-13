package org.abratuhi.quarkus;

import io.smallrye.reactive.messaging.kafka.Record;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@JBossLog
@ApplicationScoped
public class SmartMeterValueDoublingProcessor {
    @Incoming("string-in")
    @Outgoing("string-out")
    public Record<String, String> x2(byte[] bytes) {
        String str = new String(bytes);

        if (str == null) {
            return null;
        }

        return Record.of(str, str + str);
    }
}
