insert into book (title, author, isbn, description, year) values ('Python dla każdego. Podstawy programowania', 'Jan Kowalski', '45234523', 'Chcesz się nauczyć programować? Świetna decyzja! Wybierz język obiektowy, łatwy w użyciu, z przejrzystą składnią. Python będzie wprost doskonały! Rozwijany od ponad 20 lat, jest dojrzałym językiem, pozwalającym tworzyć zaawansowane aplikacje dla różnych systemów operacyjnych. Ponadto posiada system automatycznego zarządzania pamięcią, który zdejmuje z programisty obowiązek panowania nad tym skomplikowanym obszarem.', '2014');
insert into book (title, author, isbn, description, year) values ('Czysty kod. Podręcznik dobrego programisty', 'Michał Nowak', '54325342', 'Poznaj najlepsze metody tworzenia doskonałego kodu', '2014');
insert into book (title, author, isbn, description, year) values ('Programista samouk. Profesjonalny przewodnik do samodzielnej nauki kodowania', 'Anna Nowak', '634565', 'Nie wystarczy znajomość jednego języka programowania, aby zostać programistą. W rzeczywistości trzeba opanować dość szeroki zakres pojęć i paradygmatów, a także zrozumieć zagadnienia związane z algorytmami. Trzeba być na bieżąco z nowymi technologiami i narzędziami. Należy również poznać i zacząć stosować dobre praktyki programistyczne i przyswoić sobie zasady pracy w zespole. Przede wszystkim jednak priorytetem jest sama praktyka, ponieważ wielu programistów wciąż ma problem z pisaniem poprawnego kodu.', 2017);

insert into role (id, name) values(1, 'ADMIN');
insert into role (id, name) values(2, 'USER');
insert into user (id, username, password) values(1, 'admin', '$2a$10$TlqsKvlCXgr/Ms.Tfv3WXezB2RWgP8g..XvAVYDaIz3SNSlEjAB2K');
insert into user (id, username, password) values(2, 'user', '$2a$10$agFFP5xPMugXBbNJY.toauganbAMAQm2IY/4mvlEEamjoYz4awgNC');
insert into user_role (user_id, role_id) values(1,1);
insert into user_role (user_id, role_id) values(2,2);