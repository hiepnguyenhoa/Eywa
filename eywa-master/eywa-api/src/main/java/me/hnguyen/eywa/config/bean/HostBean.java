package me.hnguyen.eywa.config.bean;

/**
 * @author hnguyen
 */
public interface HostBean extends ConfigBean {

    String AMQ_PORT = "post";
    String USERNAME = "username";
    String PASSWORD = "password";

    void setPort(int port);

    int getPort();

    void setUsername(String username);

    String getUsername();

    void setPassword(String password);

    String getPassword();

}
