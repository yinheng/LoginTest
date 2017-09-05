package com.android.loginadroid;

/**
 * Created by guohao4 on 2017/9/4.
 * Email: Tornaco@163.com
 */

public class User {

    String name;
    String pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name.equals(user.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
