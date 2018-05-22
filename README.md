# service-user

This service is very simple, restful microservice. It has 4 methods;

* method GET path /users will get the list of all users
```
[
    {
        "id": 1,
        "name": "Ali",
        "surname": "Atakan",
        "fullName": "Ali Atakan"
    },
    {
        "id": 2,
        "name": "name2",
        "surname": "surname2",
        "fullName": "fullname2"
    },
    {
        "id": 3,
        "name": "name3",
        "surname": "surname3",
        "fullName": "fullname3"
    }
]
```
* method GET path /users/1 will get the user 1
```
{
    "id": 1,
    "name": "Ali",
    "surname": "Atakan",
    "fullName": "Ali Atakan"
}
```
* method DELETE path /users/1 will delete the user 1
* method POST path /users will create a user
* method PUT path /users will update a user 


Tech : scala, akka http, slick and postgres

Configuration : 
```
server{
  host = "localhost"
  port = 8090
}

db {
  dataSourceClass = "org.postgresql.ds.PGSimpleDataSource"
  properties = {
    serverName = "localhost"
    portNumber = "5432"
    databaseName = "deneme_db"
    user = "ali_user"
    password = ""
  }
}
``` 
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