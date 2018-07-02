CREATE SEQUENCE ws_schema.ws_sequence
    INCREMENT 1
    START 1;

ALTER SEQUENCE ws_schema.ws_sequence
    OWNER TO ws_user;
	
CREATE TABLE ws_schema.search_term
(
    id bigint NOT NULL,
    term character varying NOT NULL,
    search_date timestamp without time zone NOT NULL,
    positive_score integer,
    negative_score integer,
    platform integer,
    CONSTRAINT "search_term_PK" PRIMARY KEY (id),
    CONSTRAINT "search_term_CHK1" CHECK (platform IN (1))
)
WITH (
    OIDS = FALSE
);

ALTER TABLE ws_schema.search_term
    OWNER to ws_user;

COMMENT ON CONSTRAINT "search_term_CHK1" ON ws_schema.search_term
    IS '1 - github';