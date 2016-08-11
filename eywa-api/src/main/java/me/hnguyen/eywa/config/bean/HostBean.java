package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 */
public interface HostBean extends ConfigBean {

    public static final String AMQ_PORT = "post";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    
    public void setPort(int port);
    
    public int getPort();

    public void setUsername(String username);

    public String getUsername();

    public void setPassword(String password);

    public String getPassword();

}
