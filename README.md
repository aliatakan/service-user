# service-user

This service is very simple, restful microservice. It has 4 methods;

* method GET path /users will get the list of all users
* method GET path /users/1 will get the user 1
* method DELETE path /users/1 will delete the user 1
* method POST path /users will create a user
* method PUT path /users will update a user 


Tech : scala, akka http, slick and postgres
 
Postgres :

```
CREATE TABLE public.platformusers
(
    id smallint NOT NULL DEFAULT nextval('platformusers_id_seq'::regclass),
    name character varying(100) COLLATE pg_catalog."default",
    surname character varying(100) COLLATE pg_catalog."default",
    fullname character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT platformusers_pkey PRIMARY KEY (id)
)
```