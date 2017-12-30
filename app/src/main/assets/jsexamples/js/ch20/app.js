const alex_calculate = require('./alexCalculate.js');
const simon_calculate = require('./simonCalculate.js');
console.log(alex_calculate(1, 2, 5)); // 1 + 2 + 4 + 8 + 16 = 31 (geometric sum)
console.log(simon_calculate(2)); // 4/3 Pi (2)^3 = 33.51.. (volume of a sphere)

// using better labels
const geometricSum = require('./alexCalculate.js');
const sphereVolume = require('./simonCalculate.js');
console.log(geometricSum(1, 2, 5)); // 1 + 2 + 4 + 8 + 16 = 31 (geometric sum)
console.log(sphereVolume(2)); // 4/3 Pi (2)^3 = 33.51.. (volume of a sphere)

// importing multiple functions
const mathLibrary = require('./mathLibrary.js');
console.log(mathLibrary.geometricSum(1, 2, 5)); // 31
console.log(mathLibrary.arithmeticSum(100)); // 1+2...+100 = 5050
console.log(mathLibrary.quadraticFormula(1, 2, -15)); // [3, -5] ... x^2+2x-15=0 ... (x-3)(x+5) = 0

/*
31
33.510321638291124
31
33.510321638291124
31
5050
[ 3, -5 ]
*/