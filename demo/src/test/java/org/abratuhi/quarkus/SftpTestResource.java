package org.abratuhi.quarkus;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.util.Map;

public class SftpTestResource implements QuarkusTestResourceLifecycleManager {
  private GenericContainer<?> sftp;

  @Override
  public Map<String, String> start() {
    sftp = new GenericContainer<>("atmoz/sftp:alpine")
        .withExposedPorts(22)
        .withCommand("foo:bar:1001::upload")
        .waitingFor(Wait.forListeningPort());
    sftp.start();

    String mappedHost = "localhost";
    String mappedPort = String.valueOf(sftp.getMappedPort(22));
    String mappedUser = "foo";
    String mappedPassword = "bar";

    return Map.of(
        "app.sftp.host", mappedHost,
        "app.sftp.port", mappedPort,
        "app.sftp.user", mappedUser,
        "app.sftp.password", mappedPassword
    );
  }

  @Override
  public void stop() {
    sftp.stop();
  }
}
