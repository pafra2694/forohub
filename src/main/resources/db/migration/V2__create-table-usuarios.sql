create table usuarios(

    id bigint not null auto_increment,
    email varchar(100) not null,
    contrasena varchar(300) not null,

    primary key(id)

);