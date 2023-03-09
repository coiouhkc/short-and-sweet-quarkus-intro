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

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@JBossLog
@QuarkusTest
@TestProfile(SftpTestProfile.class)
public class SftpResourceTest {
  @Inject
  SshClientFactory sshClientFactory;

  @Test
  void fileIsUploaded() {
    try (
        SSHClient sshClient = sshClientFactory.getClient();
        SFTPClient sftp = sshClient.newSFTPClient()
    ) {
      // precondition/ pre-assert
      assertThat(sftp.ls("upload")).hasSize(0);

      // action
      given()
          .when().post("/sftp")
          .then()
          .statusCode(HttpStatus.SC_CREATED);

      // postcondition/ assert
      assertThat(sftp.ls("upload")).hasSize(1);
      assertThat(sftp.ls("upload").get(0).getName()).contains(".zshrc");

    } catch (Exception e) {
      log.error(e);
    }
  }
}
