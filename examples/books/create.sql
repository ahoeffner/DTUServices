drop table books;


create table books
(
  id bigint not null primary key,
  title varchar not null,
  author varchar not null
);


alter table books owner to postgres;
grant all on books to public;


insert into books values (1,'Pillars of the earth','Ken Follet');
insert into books values (2,'The Great Gatsby','F. Scott Fitzgerald');


delete from books where id > 2;
select * from books;
