package model.entity;

public enum Role {
    UNREGISTERED,
    USER,
    ADMIN;

    Role() {}

    private String accessLevel;

    Role(String accessLevel) {
        this.accessLevel = accessLevel;
    }


    public String getAccessLevel() {
        return accessLevel;
    }
}
