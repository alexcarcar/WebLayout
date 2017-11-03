console.log("===== Simple Expressions (p 80)");
let x, y;
y = x = 3 * 5;
console.log(x, y);

const xa = 5;
const ya = 3 - -xa;
console.log(ya); // ya is 8
const sb = "5";
const yb = 3 + +sb; // yb is 8; without the unary plus yb is 35
console.log(yb, 3+sb);

let xc = 3, yc;
xc += yc = 6*5/2;
console.log(xc, yc);

/*
===== Simple Expressions (p 80)
15 15
8
8 '35'
18 15
*/