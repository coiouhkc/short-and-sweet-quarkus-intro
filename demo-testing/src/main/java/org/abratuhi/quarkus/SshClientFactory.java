package org.abratuhi.quarkus;

import lombok.SneakyThrows;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.Dependent;

@Dependent
public class SshClientFactory {
    @ConfigProperty(name = "app.sftp.host")
    String sftpHost;

    @ConfigProperty(name = "app.sftp.port")
    Integer sftpPort;

    @ConfigProperty(name = "app.sftp.user")
    String sftpUser;

    @ConfigProperty(name = "app.sftp.password")
    String sftpPassword;

    @SneakyThrows
    public SSHClient getClient() {
        SSHClient client = new SSHClient();
        client.addHostKeyVerifier(new PromiscuousVerifier());
        client.connect(sftpHost, sftpPort);
        client.authPassword(sftpUser, sftpPassword);
        return client;
    }
}
