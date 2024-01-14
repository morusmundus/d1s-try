# -- data.sql
#
# -- Добавление авторов
# INSERT IGNORE INTO authors_ref (id, f_name, t_name, s_name , bio_description, born_date)
# VALUES (1, 'Александр', 'Сергеевич', 'Пушкин', 'Русский поэт, автор "Евгения Онегина".', '1799-06-06'),
#        (2, 'Лев', 'Николаевич', 'Толстой', 'Великий русский писатель, автор "Война и мир".', '1828-09-09'),
#        (3, 'Фёдор', 'Михайлович', 'Достоевский', 'Великий русский писатель, автор "Преступление и наказание".',
#         '1821-11-11'),
#        (4, 'Иван', 'Александрович', 'Бунин', 'Русский писатель и поэт, лауреат Нобелевской премии по литературе.',
#         '1870-10-22'),
#        (5, 'Михаил', 'Афанасьевич', 'Булгаков', 'Русский писатель и драматург, автор "Мастера и Маргариты".','1891-05-15'),
#        (6, 'Иван', 'Техникович', 'Программистов', 'Технический автор, эксперт в области программирования.', '1980-06-06'),
#        (7, 'Елена', 'Техническая', 'Специалистова', 'Эксперт в области технологий, автор многих статей о новых технологиях.', '1985-09-09'),
#        (8, 'Петр', 'Разработчиков', 'Технический', 'Профессиональный программист, специализирующийся на веб-технологиях.', '1990-11-11'),
#        (9, 'Анна', 'Архитекторова', 'Техническая', 'Архитектор программного обеспечения, пишет о передовых методах проектирования.', '1988-04-04'),
#        (10, 'Сергей', 'Кодиров', 'Технический', 'Специалист по безопасности, автор статей о кибербезопасности.', '1982-07-07');
#
# -- Добавление жанров
# INSERT IGNORE INTO genre_ref (id, name)
# VALUES (7, 'Все'),
#        (2, 'Фантастика'),
#        (3, 'Детектив'),
#        (4, 'Драма'),
#        (5, 'Фэнтези'),
#        (6, 'Технологии'),
#        (1, 'Роман');
#
# -- Добавление книг
# INSERT IGNORE INTO book (id, title, published, url, copies_count)
# VALUES (1, 'Евгений Онегин', '1823-01-01', 'https://s5-goods.ozstatic.by/2000/958/181/10/10181958_0.jpg', 100),
#        (2, 'Война и мир', '1869-01-01', 'https://s5-goods.ozstatic.by/2000/879/354/10/10354879_0.jpg', 150),
#        (3, 'Преступление и наказание', '1866-01-01', 'https://s5-goods.ozstatic.by/2000/218/52/1/1052218_0.jpg', 200),
#        (4, 'Тихий Дон', '1928-01-01', 'https://s2-goods.ozstatic.by/2000/583/115/10/10115583_0.jpg', 120),
#        (5, 'Мастер и Маргарита', '1966-01-01', 'https://s5-goods.ozstatic.by/2000/259/163/10/10163259_0.jpg', 180),
#        (6, 'Основы программирования', '2010-01-01', 'https://s1-goods.ozstatic.by/2000/120/779/10/10779120_0.jpg', 80),
#        (7, 'Современные технологии', '2015-01-01', 'https://s1-goods.ozstatic.by/2000/120/779/10/10779120_0.jpg', 120),
#        (8, 'Web-разработка: Полный курс', '2018-01-01', 'https://s1-goods.ozstatic.by/2000/120/779/10/10779120_0.jpg', 150),
#        (9, 'Проектирование высоконагруженных систем', '2020-01-01', 'https://s1-goods.ozstatic.by/2000/120/779/10/10779120_0.jpg', 100),
#        (10, 'Кибербезопасность: Практическое руководство', '2019-01-01', 'https://s1-goods.ozstatic.by/2000/120/779/10/10779120_0.jpg', 90);
#
# -- Связи авторов с книгами
# INSERT IGNORE INTO book_authors (book_id, authors_ref_id)
# VALUES (1, 1), -- Евгений Онегин - Александр Пушкин
#        (2, 2), -- Война и мир - Лев Толстой
#        (3, 3), -- Преступление и наказание - Фёдор Достоевский
#        (4, 4), -- Тихий Дон - Иван Бунин
#        (5, 5),
#        (6, 6), -- Основы программирования - Иван Техникович Программистов
#        (7, 7), -- Современные технологии - Елена Техническая Специалистова
#        (8, 8), -- Web-разработка: Полный курс - Петр Разработчиков
#        (9, 9), -- Проектирование высоконагруженных систем - Анна Архитекторова
#        (10, 10); -- Кибербезопасность: Практическое руководство - Сергей Кодиров Технический
#
# -- Связи жанров с книгами
# INSERT IGNORE INTO book_genres (book_id, genre_ref_id)
# VALUES (1, 1), -- Евгений Онегин - Роман
#        (2, 2), -- Война и мир - Фантастика
#        (3, 3), -- Преступление и наказание - Детектив
#        (4, 4), -- Тихий Дон - Драма
#        (5, 5), -- Мастер и Маргарита - Фэнтези;
#        (6, 6), -- Основы программирования - Технологии
#        (7, 6), -- Современные технологии - Технологии
#        (8, 6), -- Web-разработка: Полный курс - Технологии
#        (9, 6), -- Проектирование высоконагруженных систем - Технологии
#        (10, 6); -- Кибербезопасность: Практическое руководство - Технологии
#
# insert IGNORE into user (email, password, role)
# values
#     ('u@gmail.com', '$2a$12$o9OT2tIAfkhtgQnhZ1WY6.wlRy2fc3nENxfPqVQ4erYyANKD6d6US', 'USER'),
#     ('l@gmail.com', '$2a$12$o9OT2tIAfkhtgQnhZ1WY6.wlRy2fc3nENxfPqVQ4erYyANKD6d6US', 'LIBRARIAN');

-- Receipts
# INSERT INTO Receipt (id, user_id, creation_time) VALUES
#                                                     (1, 1, '2023-11-26 12:00:00'),
#                                                     (2, 1, '2023-11-27 12:00:00'),
#                                                     (3, 1, '2023-11-28 12:00:00'),
#                                                     (4, 1, '2023-11-28 12:00:00'),
#                                                     (5, 1, '2023-11-28 12:00:00'),
#                                                     (6, 1, '2023-11-29 12:00:00'),
#                                                     (7, 1, '2023-11-30 12:00:00'),
#                                                     (8, 1, '2023-12-01 12:00:00'),
#                                                     (9, 1, '2023-12-01 12:00:00'),
#                                                     (10, 2, '2023-12-02 12:00:00');
#
# -- Orders
# INSERT INTO Orders (id, receipt_id, book_id, product_quantity) VALUES
#                                                                   (1, 1, 1, 3),
#                                                                   (2, 2, 2, 3),
#                                                                   (3, 3, 3, 3),
#                                                                   (4, 4, 4, 3),
#                                                                   (5, 5, 5, 3),
#                                                                   (6, 6, 6, 3),
#                                                                   (7, 7, 7, 3),
#                                                                   (8, 8, 8, 3),
#                                                                   (9, 9, 9, 3),
#                                                                   (10, 10, 10, 3);