package org.abratuhi.quarkus;

import lombok.extern.jbosslog.JBossLog;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@JBossLog
@Path("/sftp")
public class SftpResource {
  @ConfigProperty(name = "app.sftp.host")
  String sftpHost;

  @ConfigProperty(name = "app.sftp.port")
  Integer sftpPort;

  @ConfigProperty(name = "app.sftp.user")
  String sftpUser;

  @ConfigProperty(name = "app.sftp.password")
  String sftpPassword;

  @POST
  public Response create() {
    try {
      SSHClient client = new SSHClient();
      client.addHostKeyVerifier(new PromiscuousVerifier());
      client.connect(sftpHost, sftpPort);
      client.authPassword(sftpUser, sftpPassword);

      SFTPClient sftp = client.newSFTPClient();

      sftp.put("/home/bratuhia/.zshrc", "upload/.zshrc");

      sftp.close();

      client.close();

      return Response
          .created(URI.create("/"))
          .build();
    } catch (Exception e) {
      log.error(e);
    }

    return Response.serverError().build();
  }
}
