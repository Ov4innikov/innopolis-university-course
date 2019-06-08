-- Table: lesson15."USER_ROLE"

-- DROP TABLE lesson15."USER_ROLE";

CREATE TABLE lesson15."USER_ROLE"
(
  id bigint,
  user_id bigint,
  role_id bigint
)
WITH (
  OIDS=FALSE
);
ALTER TABLE lesson15."USER_ROLE"
  OWNER TO postgres;
