truncate lesson15."ROLE";
truncate lesson15."USER";
truncate lesson15."USER_ROLE";

insert into lesson15."ROLE" values (1, 'Administration', 'Administration');
insert into lesson15."ROLE" values (2, 'Clients', 'Clients');
insert into lesson15."ROLE" values (3, 'Billing', 'Billing');

insert into lesson15."USER" values (1, 'Vadim', '21/03/2007', 1, 'Пятигорск', 'af@gmail.com', 'описание');
insert into lesson15."USER" values (2, 'Alex', '21/03/2007', 2, 'Краснодар', 'ad@gmail.com', 'описание');
insert into lesson15."USER" values (3, 'Uriy', '21/03/2008', 3, 'Краснодар', 'ff@gmail.com', 'описание');
insert into lesson15."USER" values (4, 'Vadim', '21/03/2008', 4, 'Анапа', 'faa@gmail.com', 'описание');

insert into lesson15."USER_ROLE" values (1, 1, 1);
insert into lesson15."USER_ROLE" values (2, 2, 2);
insert into lesson15."USER_ROLE" values (3, 3, 3);
insert into lesson15."USER_ROLE" values (4, 4, 3);