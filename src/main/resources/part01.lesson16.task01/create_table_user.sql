-- Table: lesson15."USER"

-- DROP TABLE lesson15."USER";

CREATE TABLE lesson15."USER"
(
  id bigint,
  name character varying(255),
  birthday date,
  login_id integer,
  city character varying(255),
  email character varying(255),
  description character varying(255)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE lesson15."USER"
  OWNER TO postgres;