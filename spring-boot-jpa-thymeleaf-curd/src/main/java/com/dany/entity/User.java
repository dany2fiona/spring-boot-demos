package com.dany.entity;

import com.dany.utils.Timer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Entity中不映射成列的字段得加@Transient 注解，不加注解也会映射成列
 */
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false,unique = true)
    private String password;
    @Column(nullable = false,unique = true)
    private int age;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = true, unique = true)
    private String nickName;
    @Column(nullable = false)
    private String regTime;
    @Column(nullable = false)
    private int state = 0;//0-正常；1-已逻辑删除
    @Column(nullable = true)
    private String cancleTime;

    public User() {
        super();
    }
    public User(String userName, String password,int age, String email, String nickName, String regTime,int state,String cancleTime) {
        super();
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.email = email;
        this.nickName = nickName;
        this.regTime = regTime;
        this.state = state;
        this.cancleTime = cancleTime;
    }

    public User(String userName, String password,int age, String email, String nickName) {
        super();
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.email = email;
        this.nickName = nickName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() { return age; }public void setAge(int age) { this.age = age; }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getRegTime() {
        return regTime;
    }
    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }
    public int getState() { return state; }public void setState(int state) { this.state = state; }
    public String getCancleTime() { return cancleTime; }public void setCancleTime(String cancleTime) { this.cancleTime = cancleTime; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", regTime='" + regTime + '\'' +
                ", state=" + state +
                ", cancleTime='" + cancleTime + '\'' +
                '}';
    }
}
