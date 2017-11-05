console.log("=== Comparison Operators (p 86) ===");

const n = 5;
const s = "5";
console.log(n===s, n!==s); // false, true -- different types
console.log(n===Number(s), n!==Number(s)); // true, false -- "5" converted to #
console.log(n==s, n!=s); // true, false -- ignores type, but not recommended

const a = {name: "an object"};
const b = {name: "an object"};
console.log(a===b,a!==b); // false, true -- distinct objects
console.log(a==b,a!=b); // false, true -- not recommended
console.log (3>5, 3>=5, 3<5, 3<=5, 5>5, 5>=5, 5<5, 5<=5);

console.log("=== Be careful with floating points (p 88) ===");
let n1 = 0;
while(true) {
	n1 += 0.1;
	if (Math.abs(n1-0.3) < Number.EPSILON) break;
}
console.log(`Stopped at ${n1}`);
console.log(3+5+"8", "3"+5+8);

console.log("=== Evaluation of XOR ===");
function XOR(x, y) {return (x || y) && x !== y}
console.log("x", "y", "x XOR y");
console.log(false, false, XOR(false, false));
console.log(false, true, XOR(false, true));
console.log(true, false, XOR(true, false));
console.log(true, true, XOR(true, true));

console.log("=== Short-Circuit Evaluation ===");
const skipIt = true;
let xSkip = 0;
const result = skipIt || xSkip++;
console.log(result, xSkip);

console.log("=== Conditional Operator ===");
const doIt = false;
console.log(doIt ? "Did it!" : "Didn't do it.");

console.log("=== Comma Operator ===");
let xComma = 0, yComma = 10, zComma;
zComma = (xComma++, yComma++);
console.log(xComma, yComma, zComma);
let aComma = 1, bComma = 2, cComma = 3, dComma;
dComma = (aComma++, bComma++, cComma++);
console.log(aComma, bComma, cComma, dComma);

console.log("=== Bitwise Operators ===");
let nB = 22; console.log("n =", nB, nB.toString(2));
let nResult = nB >> 1;
console.log("n >> 1", nResult, nResult.toString(2));
nResult = nB >>> 1;
console.log("n >>> 1", nResult, nResult.toString(2));
nResult = ~nB; nB = nResult;
console.log("n = ~n", nResult, nResult.toString(2));
nResult = nB++;
console.log("n++", nResult, nResult.toString(2));
nResult = nB >> 1;
console.log("n >> 1", nResult, nResult.toString(2));
nResult = nB >>> 1;
console.log("n >>> 1", nResult, nResult.toString(2));

const FLAG_READ = 1; console.log(FLAG_READ, FLAG_READ.toString(2));
const FLAG_WRITE = 2; console.log(FLAG_WRITE, FLAG_WRITE.toString(2));
const FLAG_EXECUTE = 4; console.log(FLAG_EXECUTE, FLAG_EXECUTE.toString(2));
let p = FLAG_READ | FLAG_WRITE; console.log(p.toString(2));
let hasWrite = p & FLAG_WRITE; console.log(hasWrite, hasWrite?'truthy':'falsy');
let hasExecute = p & FLAG_EXECUTE; console.log(hasExecute, hasExecute?'truthy':'falsy');
p = p ^ FLAG_WRITE; console.log(p.toString(2)); // toggle write off
p = p ^ FLAG_WRITE; console.log(p.toString(2)); // toggle write on

/*
=== Comparison Operators (p 86) ===
false true
true false
true false
false true
false true
false false true true false true false true
=== Be careful with floating points (p 88) ===
Stopped at 0.30000000000000004
88 358
=== Evaluation of XOR ===
x y x XOR y
false false false
false true true
true false true
true true false
=== Short-Circuit Evaluation ===
true 0
=== Conditional Operator ===
Didn't do it.
=== Comma Operator ===
1 11 10
2 3 4 3
=== Bitwise Operators ===
n = 22 10110
n >> 1 11 1011
n >>> 1 11 1011
n = ~n -23 -10111
n++ -23 -10111
n >> 1 -11 -1011
n >>> 1 2147483637 1111111111111111111111111110101
1 '1'
2 '10'
4 '100'
11
2 'truthy'
0 'falsy'
1
11
*/
