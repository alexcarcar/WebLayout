console.log("=== Proxies (p 308)");
const coefficients = {a:1, b:2, c:5};
function evaluate(x,c) {
	return c.a + c.b*x + c.c*Math.pow(x,2);
}
console.log(evaluate(1,coefficients)); // 1 + 2*1 + 5*1^2 = 8
console.log(evaluate(2,coefficients)); // 1 + 2*2 + 5*2^2 = 1 + 4 + 20 = 25
const incomplete = {a:1, c:3};
console.log(evaluate(5, incomplete)); // NaN (since b is undefined)

// create a proxy to handle undefined values
const betterCoefficients = new Proxy(incomplete, {
	get(target, key) {
		return target[key] || 0;
	}
});

console.log(betterCoefficients.a, betterCoefficients.b, betterCoefficients.c, betterCoefficients.d, betterCoefficients.anything);

// create a proxy to handle undefined values for only single lower case characters
const singleLowerCase = new Proxy(incomplete, {
	get(target, key) {
		if(!/^[a-z]$/.test(key)) return target[key];
		return target[key] || 0;
	}
});
console.log(singleLowerCase.a, singleLowerCase.b, singleLowerCase.c, singleLowerCase.d, singleLowerCase.anything);

console.log("=== Proxies for Accessors (p 310)");
const cook = {name:"Walt", redPhosporus:100, water:500};
const protectedCook = new Proxy(cook,{
	set(target, key, value) {
		if(key==='redPhosporus') {
			if(target.allowDangerousOperations)
				return target.redPhosporus	= value;
			else
				return console.log("Too dangerous!");
		}
		target[key] = value;
	}
});

console.log(protectedCook);
protectedCook.water = 550; // OK
protectedCook.redPhosporus = 150; // Too dangerous!
protectedCook.allowDangerousOperations = true;
protectedCook.redPhosporus = 150; // OK
console.log(protectedCook);

/*
=== Proxies (p 308)
8
25
NaN
1 0 3 0 0

e:\ansvn\WebLayout\app\src\main\assets\jsexamples\js\ch21>node 308_proxy.js
=== Proxies (p 308)
8
25
NaN
1 0 3 0 0
1 0 3 0 undefined

e:\ansvn\WebLayout\app\src\main\assets\jsexamples\js\ch21>node 308_proxy.js
=== Proxies (p 308)
8
25
NaN
1 0 3 0 0
1 0 3 0 undefined
=== Proxies for Accessors (p 310)
{ name: 'Walt', redPhosporus: 100, water: 500 }
Too dangerous!
{ name: 'Walt',
  redPhosporus: 150,
  water: 550,
  allowDangerousOperations: true }
 */
