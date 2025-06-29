CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department IN VARCHAR2,
  p_bonus_pct IN NUMBER
) IS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * p_bonus_pct / 100)
  WHERE department = p_department;

  DBMS_OUTPUT.PUT_LINE('Bonus applied to department: ' || p_department);
  COMMIT;
END;
/