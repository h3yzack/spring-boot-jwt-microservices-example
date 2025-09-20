-- liquibase formatted sql

-- changeset Zack:1758304269289-1
INSERT INTO roles (id, role_name) VALUES (1, 'ADMIN'),(2, 'USER');

-- changeset Zack:1758304269289-3
INSERT INTO users (id, password_hash, username) VALUES (1, '$2a$10$OvqTrTkLJ3bMp1SkwNBx2OGULVcb9MRa6iPUWV4DfTJhYvnvA/bta', 'admin'),(2, '$2a$10$OvqTrTkLJ3bMp1SkwNBx2OGULVcb9MRa6iPUWV4DfTJhYvnvA/bta', 'user');

-- changeset Zack:1758304269289-2
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1),(1, 2),(2, 2);



