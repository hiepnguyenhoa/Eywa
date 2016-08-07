package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 */
public interface HostBean extends ConfigBean {

    public static final String HOST_NAME = "name";
    public static final String HOST_PORT = "port";

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public void setName(String hostName);

    public String getName();

    public void setPortNumber(int port);

    public int getPortNumber();

    public void setUsername(String username);

    public String getUsername();

    public void setPassword(String password);

    public String getPassword();

}
