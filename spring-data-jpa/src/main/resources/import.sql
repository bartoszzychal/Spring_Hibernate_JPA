
insert into library (id,name) values (14, 'Biblioteka Miejska');
insert into library (id,name) values (15, 'Biblioteka Wiejska');

insert into book (id, title,library) values (1, 'Pierwsza książka',14);
insert into book (id, title,library) values (2, 'Druga książka',14);
insert into book (id, title,library) values (3, 'Trzecia książka',14);
insert into book (id, title,library) values (4, 'Czwarta książka',15);

insert into author (id, first_name, last_name) values (7, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (8, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (9, 'Janusz', 'Jankowski');
insert into author (id, first_name, last_name) values (10, 'Janusz', 'Marek');


insert into book_author(book_id, author_id) values (1, 7);
insert into book_author(book_id, author_id) values (2, 8);
insert into book_author(book_id, author_id) values (3, 9);
insert into book_author(book_id, author_id) values (4, 10);

