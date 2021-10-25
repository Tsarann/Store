package model.builder;

import model.entity.User;

public interface UserBuilder {
    UserBuilder setId(long id);

    UserBuilder setName(String name);

    UserBuilder setEmail(String email);

    UserBuilder setPassword(String password);

    UserBuilder setAccessLevel(String accessLevel);

    User build();
}
