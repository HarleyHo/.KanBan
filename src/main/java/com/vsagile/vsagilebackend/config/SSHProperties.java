package com.vsagile.vsagilebackend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="ssh")
public class SSHProperties {

    private String enabled;

    private String host;
    private Integer port;
    private String username;
    private String identity;
    private Forward forward;

    @Data
    public static class Forward {
        private String fromHost;
        private Integer fromPort;
        private String toHost;
        private Integer toPort;
    }
}
