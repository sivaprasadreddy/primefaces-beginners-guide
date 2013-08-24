package com.packtpub.techbuzz.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author siva
 */
public class Role implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String roleName;
    private String description;
    private List<User> users;

    public Role() {
    }

    public Role(Integer id) {
        this.id = id;
    }

    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
