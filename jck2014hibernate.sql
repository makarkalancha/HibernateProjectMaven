select * from exhibitor order by id desc
select * from exhibitor where id = 11
select * from exhibitor_id_seq  

--create table PAYMENT(
--PAYMENT_ID char(1) NOT NULL,
--PAYMENT_AMOUNT DECIMAL(7,2),
--CREDITCARDNUMBER VARCHAR(20),
--BANKNAME VARCHAR(20),
--BANKREF VARCHAR(20)
--);

--INSERT INTO PAYMENT VALUES('W',1000,NULL,'A BANK','BANKREF-1');
--INSERT INTO PAYMENT VALUES('C',2000,'CC1000',NULL,NULL);

--select * from payment 

-----------------------------------------------------------------------
------------postgres procedures----------------------------------------
--http://www.sqlines.com/postgresql/how-to/return_result_set_from_stored_procedure
--drop FUNCTION if exists getexhibitor(exhid INT);
--drop FUNCTION if exists getexhibitor(exhid varchar);
--drop FUNCTION if exists getexhibitor(exhid INT, ref refcursor);
CREATE OR REPLACE FUNCTION getexhibitor(exhid INT, curs1 refcursor) 
--CREATE OR REPLACE FUNCTION getexhibitor(INT, refcursor) 
    RETURNS refcursor AS $$
    --DECLARE curs1 refcursor;
    BEGIN
      OPEN curs1 FOR SELECT * FROM exhibitor WHERE id = exhid;
      RETURN curs1;
    END;
    $$ LANGUAGE plpgsql;

--http://stackoverflow.com/questions/15517429/postgresql-displaying-the-data-fetched-by-the-cursor
-- Start a transaction, run each query separately
BEGIN;
SELECT getexhibitor(11,'exhibitor');
FETCH ALL IN "exhibitor";
COMMIT;