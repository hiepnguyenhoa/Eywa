package me.hnguyen.eywa.config.bean;

/**
 * @author hnguyen
 */
public class HostBeanImpl extends ConfigBeanAbst implements HostBean {

    private int port;
    private String username;
    private String password;

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getKeyMap() {
        return this.getKey();
    }

}
