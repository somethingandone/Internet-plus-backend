后端测试。
需要配置数据库
mysql
mongodb
登录注册需要启动Redis

mysql 建表语句
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
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

操作方法：

1.获取idf数据和词频数据需要跑一次WordFrequencyTest
2.示例见Test中的MatchTest
