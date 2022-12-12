package org.abratuhi.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import lombok.extern.jbosslog.JBossLog;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.apache.http.HttpStatus;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@JBossLog
@QuarkusTest
@TestProfile(SftpTestProfile.class)
public class SftpResourceTest {
  @ConfigProperty(name = "app.sftp.host")
  String sftpHost;

  @ConfigProperty(name = "app.sftp.port")
  Integer sftpPort;

  @ConfigProperty(name = "app.sftp.user")
  String sftpUser;

  @ConfigProperty(name = "app.sftp.password")
  String sftpPassword;

  @Test
  void fileIsUploaded() {
    try {
      SSHClient client = new SSHClient();
      client.addHostKeyVerifier(new PromiscuousVerifier());
      client.connect(sftpHost, sftpPort);
      client.authPassword(sftpUser, sftpPassword);

      SFTPClient sftp = client.newSFTPClient();

      assertThat(sftp.ls("upload")).hasSize(0);

      given()
          .when().post("/sftp")
          .then()
          .statusCode(HttpStatus.SC_CREATED);

      assertThat(sftp.ls("upload")).hasSize(1);
      assertThat(sftp.ls("upload").get(0).getName()).contains(".zshrc");

      sftp.close();

      client.close();
    } catch (Exception e) {
      log.error(e);
    }
  }
}
