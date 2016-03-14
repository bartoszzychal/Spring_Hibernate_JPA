
insert into library (id,name) values (14, 'Biblioteka Miejska');

insert into book (id, title,LIBRARY_ID) values (1, 'Pierwsza książka',14);
insert into book (id, title,LIBRARY_ID) values (2, 'Druga książka',14);
insert into book (id, title,LIBRARY_ID) values (3, 'Trzecia książka',14);

insert into author (id, first_name, last_name) values (7, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (8, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (9, 'Janusz', 'Jankowski');


insert into book_author(book_id, author_id) values (1, 7);
insert into book_author(book_id, author_id) values (2, 8);
insert into book_author(book_id, author_id) values (3, 9);

