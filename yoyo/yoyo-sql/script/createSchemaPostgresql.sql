DROP TABLE IF EXISTS market;

--
-- Name: market; Type: TABLE; Schema: public; 
--

CREATE TABLE market (
    idmar serial NOT NULL,
    name varchar(30) unique,
    lastModified timestamp,
    version integer NOT NULL default 1,
    description varchar(2000),
    primary key (idmar)
);

