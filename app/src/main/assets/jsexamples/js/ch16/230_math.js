console.log("=== Formatting Numbers (p 230)");
const x19 = 19.51;
console.log("toFixed:", x19.toFixed(3), x19.toFixed(2), x19.toFixed(1), x19.toFixed(0));
const x3800 = 3800.5;
console.log("toExponential:", x3800.toExponential(4), x3800.toExponential(3), x3800.toExponential(2), x3800.toExponential(1), x3800.toExponential(0));
const x1000 = 1000;
console.log("toPrecision:", x1000.toPrecision(5), x1000.toPrecision(4), x1000.toPrecision(3), x1000.toPrecision(2), x1000.toPrecision(1));
const x15 = 15.335;
console.log("toPrecision:", x15.toPrecision(6), x15.toPrecision(5), x15.toPrecision(4), x15.toPrecision(3), x15.toPrecision(2), x15.toPrecision(1));
const x12 = 12;
console.log("Different Bases (toString):", x12.toString(), x12.toString(10), x12.toString(16), x12.toString(8), x12.toString(2));
console.log("Constants:", Math.E, Math.PI, Math.LN2, Math.LN10, Math.LOG2E, Math.LOG10E, Math.SQRT1_2, Math.SQRT2, Math.hypot(3, 4));
/*
=== Formatting Numbers (p 230)
toFixed: 19.510 19.51 19.5 20
toExponential: 3.8005e+3 3.801e+3 3.80e+3 3.8e+3 4e+3
toPrecision: 1000.0 1000 1.00e+3 1.0e+3 1e+3
toPrecision: 15.3350 15.335 15.34 15.3 15 2e+1
Different Bases (toString): 12 12 c 14 1100
Constants: 2.718281828459045 3.141592653589793 0.6931471805599453 2.302585092994
046 1.4426950408889634 0.4342944819032518 0.7071067811865476 1.4142135623730951
5
*/