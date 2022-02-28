CREATE SEQUENCE IF NOT EXISTS public.cuenta_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.cuenta_id_seq
    OWNER TO postgres;
    
 CREATE SEQUENCE IF NOT EXISTS public.movimiento_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.movimiento_id_seq
    OWNER TO postgres;
    
CREATE SEQUENCE IF NOT EXISTS public.persona_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.persona_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.persona
(
    dtype character varying(31) COLLATE pg_catalog."default" NOT NULL,
    id bigint NOT NULL DEFAULT nextval('persona_id_seq'::regclass),
    direccion character varying(255) COLLATE pg_catalog."default",
    edad integer,
    identificacion character varying(255) COLLATE pg_catalog."default",
    nombre character varying(255) COLLATE pg_catalog."default",
    telefono character varying(255) COLLATE pg_catalog."default",
    contrasena character varying(255) COLLATE pg_catalog."default",
    estado character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT persona_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.persona
    OWNER to postgres;
    
CREATE TABLE IF NOT EXISTS public.cuenta
(
    id bigint NOT NULL DEFAULT nextval('cuenta_id_seq'::regclass),
    estado character varying(255) COLLATE pg_catalog."default",
    numero_cuenta character varying(255) COLLATE pg_catalog."default",
    saldo_inicial numeric(12,2),
    tipo_cuenta character varying(255) COLLATE pg_catalog."default",
    id_persona bigint,
    CONSTRAINT cuenta_pkey PRIMARY KEY (id),
    CONSTRAINT fk_cuenta_persona FOREIGN KEY (id_persona)
        REFERENCES public.persona (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cuenta
    OWNER to postgres;
    
CREATE TABLE IF NOT EXISTS public.movimiento
(
    id bigint NOT NULL DEFAULT nextval('movimiento_id_seq'::regclass),
    saldo numeric(12,2),
    tipo_movimiento character varying(255) COLLATE pg_catalog."default",
    valor numeric(12,2),
	id_cuenta bigint,
    CONSTRAINT movimiento_pkey PRIMARY KEY (id),
    CONSTRAINT fk_movimiento_cuenta FOREIGN KEY (id_cuenta)
        REFERENCES public.cuenta (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.movimiento
    OWNER to postgres;
    
    