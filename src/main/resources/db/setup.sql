create database auction_db;
create user 'auction_user'@'localhost' identified by 'pass_123';
grant all privileges on auction_db. * to 'auction_user'@'localhost';
flush privileges;
