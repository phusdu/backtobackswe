/**
 *
 * Deconstruct the Construct Problem Code: BC20R105
 * Add problem to Todo list
 * Submit
 *
 *
 * Assume a machine that has a single register and six instructions.
 *
 * Instruction	Operation
 * LD A	places the operand A into the register
 * ST A	places the contents of the register into the variable A
 * AD A	adds the contents of the variable A to the register
 * SB A	subtracts the contents of variable A from the register
 * ML A	multiplies the contents of the register by the variable A
 * DV A	divides the contents of the register by the variable A
 * Consider postfix expressions containing single-letter operands like A, B, C, etc., and the operators +,−, ∗ and /. Using variables of the form TEMPn as temporary variables, your task is to accept a postfix expression as defined above and print a sequence of instructions to evaluate the expression and leave the result in the register.
 *
 * Note: There will be a new temporary variable for each binary operation, including storing the final result. Do not apply any optimizations. Otherwise, your result may be marked incorrect. Also, separate the instruction label (LD, ST, etc.) and the variable (A, B, etc.) by a single space.
 *
 * Input:
 * The first line of input consists of an integer T denoting the number of test cases. The description of T test cases follows.
 * The only line of each test case consists of a string S denoting the postfix expression to be evaluated.
 * Output:
 * For each test case, print the sequence of instructions which evaluates the postfix expression and leaves the result in the register, with each line having one instruction.
 *
 * Constraints
 * 1≤T≤100
 * 3≤length(S)≤1000
 * Sample Input:
 * 1
 * ABC*+DE-/
 * Sample Output:
 * LD  B
 * ML  C
 * ST  TEMP1
 * LD  A
 * AD  TEMP1
 * ST  TEMP2
 * LD  D
 * SB  E
 * ST  TEMP3
 * LD  TEMP2
 * DV  TEMP3
 * ST  TEMP4
 * EXPLANATION:
 * The first operation is (B∗C). Hence, B is loaded into the register and its contents then multiplied by Also,C. The result is stored in TEMP1. The next operation is (A+(B∗C)). Hence, A is loaded into the register and TEMP1 added to its contents. The result is stored in TEMP2. The next operation is (D−E). Hence, D is loaded into the register and then E is subtracted from its contents. The result is stored in TEMP3. Now, we have the following:
 *
 * TEMP2=(A+(B∗C)) and TEMP3=(D−E)
 * The final operation is (A+(B∗C))/(D−E). Hence, TEMP2 is loaded into the register and its contents divided by TEMP3. Finally, the result is stored in TEMP4.
 */