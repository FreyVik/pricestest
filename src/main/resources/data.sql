-- CREATE PRICES TABLE
CREATE TABLE IF NOT EXISTS PRICES (
    PRICE_LIST INT PRIMARY KEY,
    BRAND_ID INT,
    START_DATE TIMESTAMP,
    END_DATE TIMESTAMP,
    PRODUCT_ID INT,
    PRIORITY INT,
    PRICE NUMERIC(10,2),
    CURR VARCHAR(3)
);

-- INSERT INITIAL DATA
INSERT INTO PRICES (PRICE_LIST, BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1, 1, '2020-06-14 00.00.00', '2020-12-31 23.59.59', 35455, 0, 35.50, 'EUR');
INSERT INTO PRICES (PRICE_LIST, BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (2, 1, '2020-06-14 15.00.00', '2020-06-14 18.30.00', 35455, 1, 25.45, 'EUR');
INSERT INTO PRICES (PRICE_LIST, BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (3, 1, '2020-06-15 00.00.00', '2020-06-15 11.00.00', 35455, 1, 30.50, 'EUR');
INSERT INTO PRICES (PRICE_LIST, BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (4, 1, '2020-06-15 16.00.00', '2020-12-31 23.59.59', 35455, 1, 35.50, 'EUR');


