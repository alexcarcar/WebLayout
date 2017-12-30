const alex_calculate = require('./alexCalculate.js');
const simon_calculate = require('./simonCalculate.js');
console.log(alex_calculate(1, 2, 5)); // 1 + 2 + 4 + 8 + 16 = 31 (geometric sum)
console.log(simon_calculate(2)); // 4/3 Pi (2)^3 = 33.51.. (volume of a sphere)

/*
31
33.510321638291124
*/