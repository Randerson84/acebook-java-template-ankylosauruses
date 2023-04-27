alter table users add column friends_list varchar;

update users set friends_list = '3,4,5,6' where id = 1;

update users set friends_list = '1' where id = 2;