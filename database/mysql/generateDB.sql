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
);

drop table if exists level_perm;
CREATE TABLE `level_perm` (
    `level` int NOT NULL,
    `perm` varchar(20) NOT NULL DEFAULT '0',
    PRIMARY KEY (`level`,`perm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

drop table if exists word_frequency;
CREATE TABLE `word_frequency` (
`id` bigint NOT NULL AUTO_INCREMENT,
`word` varchar(255) NOT NULL,
`frequency` int NOT NULL DEFAULT '0',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

drop table if exists word_idf;
CREATE TABLE `word_idf` (
`id` int NOT NULL AUTO_INCREMENT,
`word` varchar(255) NOT NULL,
`idf` float NOT NULL DEFAULT '0',
PRIMARY KEY (`id`, `word`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
