BEGIN
  FOR c IN (SELECT customer_id FROM customers WHERE balance > 10000) LOOP
    UPDATE customers
    SET is_vip = 'Y'
    WHERE customer_id = c.customer_id;

    DBMS_OUTPUT.PUT_LINE('Customer ID ' || c.customer_id || ' promoted to VIP');
  END LOOP;

  COMMIT;
END;
/