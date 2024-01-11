create table relation
(
    id           int auto_increment
        primary key,
    exRegulation varchar(100) null,
    inRegulation varchar(100) null
);

drop table if exists user;
create table user(
                     `id` int not null auto_increment,
                     `name` varchar(20) not null,
                     `password_hash` varchar(255) not null,
                     `email` varchar(20),
                     `avatar_id` int,
                     `created_at` timestamp,
                     `ip_addr` varchar(100),
                     `level` int,
                     primary key (`id`)
)
drop table if exists level_perm;
CREATE TABLE `level_perm` (
                              `level` int NOT NULL,
                              `perm` varchar(20) NOT NULL DEFAULT '0',
                              PRIMARY KEY (`level`,`perm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


