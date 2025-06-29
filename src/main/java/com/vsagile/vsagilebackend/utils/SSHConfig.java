package com.vsagile.vsagilebackend.utils;

import io.micrometer.common.lang.NonNullApi;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import com.vsagile.vsagilebackend.utils.SSHProperties.Forward;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;

@Configuration
@ConditionalOnProperty(prefix = "ssh", value = "enabled", havingValue = "true")
@EnableConfigurationProperties(SSHProperties.class)
@Slf4j
@NonNullApi
public class SSHConfig implements LoadTimeWeaverAware {

    private final Session session;

    public SSHConfig(SSHProperties sshProperties) {
        JSch jsch = new JSch();
        Session session = null;
        try {
            jsch.addIdentity(sshProperties.getIdentity());
            session = jsch.getSession(sshProperties.getUsername(), sshProperties.getHost(), sshProperties.getPort());
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            Forward forward = sshProperties.getForward();
            if (forward != null) {
                session.setPortForwardingL(forward.getFromHost(), forward.getFromPort(), forward.getToHost(), forward.getToPort());
                log.info("Port forwarding established from {}:{} to {}:{}.", forward.getFromHost(), forward.getFromPort(), forward.getToHost(), forward.getToPort());
                log.info("SSH tunnel established successfully.");
            }
        } catch (JSchException e) {
            log.error("SSH tunnel established failed: ", e);
        }
        this.session = session;
    }

    @PreDestroy
    public void disconnect() {
        if (session != null && session.isConnected()) {
            session.disconnect();
            log.info("SSH tunnel closed successfully.");
        }
    }

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {}
}
