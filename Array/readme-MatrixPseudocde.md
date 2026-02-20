# MatrixPseudocode
## Description
This program performs multiplication of two 2*2 matrices using nested loops in java.

---
## Pseudocode
BEGIN
   DECLARE  matrix   A    as   2 * 2
    DECLARE  matrix   B   as    2 * 2
      DECLARE  matrix  C  as    2 * 2
       INITIALIZE A = {{1 , 2} , {3 , 4}}
         INITIALIZE B = {{6 , 7} , {8 , 9}}
         FOR i = 0  TO 1
            FOR j = 0 TO 1
              SET C [i] [j] = 0
                 FOR k = 0 TO 1
                    C[i] [j] = C[i] [j] + (A[i] [k] * B[k] [j] )
                        END FOR
          END FOR
END FOR
PRINT matrix C
 
                   



