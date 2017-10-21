console.log("Numbers (page 39)");
console.log("-----------------");

let count = 10;				// integer literal; count is still a double
const blue = 0x0000ff;		// hexidecimal (hex ff = decimal 255 = 15*16 + 15)
console.log(count, blue, 15*16+15);
const umask = 0o0022;		// octal (octal 22 = decimal 18 = 2*8+2)
console.log(umask, 2*8+2);
const roomTemp = 21.5;		// decimal
const c = 3.0e6;			// exponential (3.0 x10^6 = 3,000,000)
const e = -1.6e-19;			// exponential (-1.6x10^-19)
console.log(roomTemp, c, e);
const inf = Infinity;
const ninf = -Infinity;
const nan = NaN;			// "not a number"
console.log(inf, ninf, nan);

const small = Number.EPSILON;
const max = Number.MAX_VALUE;	
const maxInt = Number.MAX_SAFE_INTEGER;
const min = Number.MIN_VALUE;	
const minInt = Number.MIN_SAFE_INTEGER;
const numberNInf = Number.NEGATIVE_INFINITY;
const numberNaN = Number.NaN;
const numberInf = Number.POSITIVE_INFINITY; 
console.log(small, max, maxInt, min, minInt);
console.log(numberNInf, numberNaN, numberInf);

/*
Numbers (page 39)
-----------------
10 255 255
18 18
21.5 3000000 -1.6e-19
Infinity -Infinity NaN
2.220446049250313e-16 1.7976931348623157e+308 9007199254740991 5e-324 -9007199254740991
-Infinity NaN Infinity
*/