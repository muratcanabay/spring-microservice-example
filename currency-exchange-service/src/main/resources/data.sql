-- By default, data.sql scripts are now run before Hibernate is initialized.
-- Feeds the h2 database with the data when the application is started.

INSERT INTO CURRENCY_EXCHANGE (ID, _FROM, _TO, CONVERSION_MULTIPLE, PORT)
VALUES (1, 'TR', 'USD', 14.5, null);