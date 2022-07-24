CREATE TABLE "user_data"
(
    "id"         BIGSERIAL PRIMARY KEY,
    "code"       VARCHAR   NOT NULL,
    "dep"        VARCHAR   NOT NULL,
    "first_name" VARCHAR,
    "last_name"  VARCHAR,
    "email"      VARCHAR,
    "id_code"    INTEGER   NOT NULL,
    "visit_time" TIMESTAMP NOT NULL
);
CREATE INDEX ON user_data ("id_code");
