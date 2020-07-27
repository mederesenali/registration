use register;
create table role(
 role_id int not  null auto_increment ,
 role varchar(10),
 primary key (role_id)
);
create table user(
 user_id int not null auto_increment ,
 full_name varchar(30) ,
 email varchar (30),
 enabled bit,
 password varchar(128),
 primary key (user_id)
);
create table user_role(
 user_id int,
 role_id int,
 foreign key(user_id) references user(user_id),
 foreign key(role_id) references role(role_id)
);
insert into role(role) value ("USER");