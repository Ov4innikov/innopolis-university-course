-- Table: lesson15.LOGS

DROP TABLE lesson15.LOGS;

CREATE TABLE lesson15.LOGS
(
  "id" character varying(256),
  "date" date,
  "log_level" character varying(256),
  "message" character varying(256),
  "exception" character varying(256)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE lesson15.LOGS
  OWNER TO postgres;