console.log("=== Sets (p 166)");
const primes = new Set();
primes.add(2);
primes.add(3);
console.log(primes, primes.size); // {2, 3} 2
primes.add(3);
console.log(primes, primes.size); // {2, 3} 2 -- duplicates are not allowed
console.log(primes.delete(3)); // true
console.log(primes, primes.size); // {2} 1
console.log(primes.delete(3)); // false -- 3 is no longer in the set

console.log("=== Weak Set (p 167)");
const naughty = new WeakSet();
const children = [
	{name:"Suzy"},
	{name:"Derek"}
];
naughty.add(children[1]);
for (let child of children) {
	if (naughty.has(child)) {
		console.log(`Coal for ${child.name}!`);
	} else {
		console.log(`Presents for ${child.name}!`);
	}
}
/*
=== Sets (p 166)
Set { 2, 3 } 2
Set { 2, 3 } 2
true
Set { 2 } 1
false
=== Weak Set (p 167)
Presents for Suzy!
Coal for Derek!
*/