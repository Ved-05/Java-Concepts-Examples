package org.personal.multithreading.entities;

import java.util.ArrayList;
import java.util.List;

public class AppUserGroup {

    private final String name;
    private final List<AppUser> users;

    public AppUserGroup(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addUser(AppUser user) {
        this.users.add(user);
    }

    public void removeUser(AppUser user) {
        this.users.add(user);
    }

    public List<AppUser> getUsers() {
        return users;
    }
}
