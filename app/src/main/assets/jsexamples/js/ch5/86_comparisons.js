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