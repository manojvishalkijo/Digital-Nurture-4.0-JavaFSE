CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_acc IN NUMBER,
  p_to_acc IN NUMBER,
  p_amount IN NUMBER
) IS
  insufficient_funds EXCEPTION;
BEGIN
  -- Check balance
  DECLARE
    v_balance NUMBER;
  BEGIN
    SELECT balance INTO v_balance FROM accounts WHERE account_id = p_from_acc;
    IF v_balance < p_amount THEN
      RAISE insufficient_funds;
    END IF;
  END;

  -- Deduct from source
  UPDATE accounts
  SET balance = balance - p_amount
  WHERE account_id = p_from_acc;

  -- Add to destination
  UPDATE accounts
  SET balance = balance + p_amount
  WHERE account_id = p_to_acc;

  DBMS_OUTPUT.PUT_LINE('₹' || p_amount || ' transferred from Account ' || p_from_acc || ' to Account ' || p_to_acc);
  COMMIT;

EXCEPTION
  WHEN insufficient_funds THEN
    DBMS_OUTPUT.PUT_LINE('❌ Transfer failed: Insufficient funds in Account ' || p_from_acc);
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('❌ Transfer failed: One or both account IDs not found');
END;
/