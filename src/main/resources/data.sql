-- DROP TABLE IF EXISTS public.user;

CREATE TABLE IF NOT EXISTS public."user"
(
    id bigint NOT NULL,
    name "char",
    CONSTRAINT user_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."user"
    OWNER to postgres;

INSERT INTO public."user"(
    id, name)
VALUES (1, 'admin');
INSERT INTO public."user"(
    id, name)
VALUES (2, 'test');

-- DROP TABLE IF EXISTS public.customer;

CREATE TABLE IF NOT EXISTS public.customer
(
    id bigint NOT NULL DEFAULT nextval('customer_id_seq'::regclass),
    email character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    surname character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer
    OWNER to postgres;

insert into customer(id,name,surname,email)
VALUES(1,'busra','uzan','busrauzan26@gmail.com');
insert into customer(id,name,surname,email)
VALUES(2,'begum','ustcetin','begumustcetin@gmail.com');
insert into customer(id,name,surname,email)
VALUES(3,'elif','indir','elifindir@gmail.com');
insert into customer(id,name,surname,email)
VALUES(4,'sinan','ozcan','sinanozcan@gmail.com');

-- DROP TABLE IF EXISTS public.folder;

CREATE TABLE IF NOT EXISTS public.folder
(
    id bigint NOT NULL DEFAULT nextval('folder_id_seq'::regclass),
    path character varying(255) COLLATE pg_catalog."default",
    customer_id bigint,
    CONSTRAINT folder_pkey PRIMARY KEY (id),
    CONSTRAINT fketr3pliloh3ch7okuvqgwla1r FOREIGN KEY (customer_id)
    REFERENCES public.customer (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.folder
    OWNER to postgres;

insert into folder(id, path, customer_id)
VALUES (1, 'path1', 1);
insert into folder(id, path, customer_id)
VALUES (2, 'path2', 1);
insert into folder(id, path, customer_id)
VALUES (3, 'path3', 1);
insert into folder(id, path, customer_id)
VALUES (4, 'path4', 2);
insert into folder(id, path, customer_id)
VALUES (5, 'path5', 2);
insert into folder(id, path, customer_id)
VALUES (6, 'path6', 3);
insert into folder(id, path, customer_id)
VALUES (7, 'path7', 4);