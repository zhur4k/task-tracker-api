CREATE TABLE t_client(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL ,
    last_name VARCHAR(100)
);

CREATE TABLE t_user(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    is_enabled BOOLEAN NOT NULL,
    client_id BIGINT UNIQUE REFERENCES t_client(id) ON DELETE CASCADE
);

CREATE TABLE t_user_role(
    user_id BIGINT NOT NULL REFERENCES t_user(id) ON DELETE CASCADE,
    roles VARCHAR(100) NOT NULL,
    PRIMARY KEY (user_id, roles)
);
