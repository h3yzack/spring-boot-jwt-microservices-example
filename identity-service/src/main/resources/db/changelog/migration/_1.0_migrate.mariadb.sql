-- liquibase formatted sql
-- changeset Zack:1758302385123-1
CREATE TABLE
    roles (
        id BIGINT AUTO_INCREMENT NOT NULL,
        role_name VARCHAR(255) NOT NULL,
        CONSTRAINT rolesPK PRIMARY KEY (id)
    );

-- changeset Zack:1758302385123-2
CREATE TABLE
    user_roles (
        user_id BIGINT NOT NULL,
        role_id BIGINT NOT NULL,
        CONSTRAINT user_rolesPK PRIMARY KEY (user_id, role_id)
    );

-- changeset Zack:1758302385123-3
CREATE TABLE
    users (
        id BIGINT AUTO_INCREMENT NOT NULL,
        password_hash VARCHAR(255) NOT NULL,
        username VARCHAR(255) NOT NULL,
        CONSTRAINT usersPK PRIMARY KEY (id)
    );

-- changeset Zack:1758302385123-4
ALTER TABLE roles ADD CONSTRAINT UC_ROLESROLE_NAME_COL UNIQUE (role_name);

-- changeset Zack:1758302385123-5
ALTER TABLE users ADD CONSTRAINT UC_USERSUSERNAME_COL UNIQUE (username);

-- changeset Zack:1758302385123-6
ALTER TABLE user_roles ADD CONSTRAINT FKh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES roles (id);

-- changeset Zack:1758302385123-7
ALTER TABLE user_roles ADD CONSTRAINT FKhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES users (id);