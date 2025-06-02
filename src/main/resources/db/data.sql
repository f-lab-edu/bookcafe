-- book
INSERT INTO book(id, book_id, isbn, title, author, translator, publisher, publish_date, price, stock, borrowed_count, reserved_count)
VALUES
    (1, 1, 9788936433598, '채식주의자', '한강', NULL, '창비', '2007-10-30', 35000, 5, 1, 0),
    (2, 2, 9788954651134, '흰', '한강', NULL, '문학동네', '2018-04-25', 13000, 2, 2, 1);

-- borrower
INSERT INTO borrower(id, password, name, level, borrow_count, reservation_count, create_date, update_date)
VALUES
    (1, NULL, '슈카', 'BASIC', 0, 1, '2025-05-03 12:00:00', '2025-05-03 12:00:00'),
    (2, NULL, '머스크', 'WORM', 3, 2, '2025-05-03 12:00:00', '2025-05-03 12:00:00');

-- borrow
INSERT INTO borrow(id, member_id, book_id, time, return_time, "from", "to", extension_count)
VALUES
    (1, 1, 1, '2025-06-01 12:00:00', NULL, '2025-06-01', '2025-06-08', 0),
    (2, 1, 2, '2025-06-01 12:00:00', NULL, '2025-06-01', '2025-06-08', 0);

-- reservation
INSERT INTO reservation(id, member_id, book_id, time, "from", "to")
VALUES
    (1, 1, 1, '2025-05-03 15:00:00', '2025-05-10 12:00:00', '2025-05-12 12:00:00'),
    (2, 2, 1, '2025-05-03 16:00:00', NULL, NULL);