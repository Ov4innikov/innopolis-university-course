-- Table: lesson15."ROLE"

-- DROP TABLE lesson15."ROLE";

CREATE TABLE lesson15."ROLE"
(
  id bigint,
  name character varying(255),
  description character varying(255)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE lesson15."ROLE"
  OWNER TO postgres;
