BEGIN
  FOR l IN (
    SELECT loan_id, customer_id, due_date
    FROM loans
    WHERE due_date <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('🔔 Reminder: Customer ID ' || l.customer_id ||
                         ', Loan ID ' || l.loan_id ||
                         ' is due on ' || TO_CHAR(l.due_date, 'DD-MON-YYYY'));
  END LOOP;
END;
/