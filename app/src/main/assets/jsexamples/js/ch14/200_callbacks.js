console.log("=== callbacks (p 200)");
console.log("Before timeout: " + new Date());
function f() {
	console.log("After timeout: " + new Date());
}
setTimeout(f, 1000); // one second
console.log("I happen after setTimeout!");
console.log("Me too!");

console.log("=== setInterval and clearInterval (p 202)");
const start = new Date();
let i = 0;
const intervalId = setInterval(function(){
	let now = new Date();
	if (now.getMinutes() !== start.getMinutes() || ++i>10) {
		return clearInterval(intervalId);
	}
	console.log(`${i}: ${now}`);
}, 5*1000);
/*
=== callbacks (p 200)
Before timeout: Sat Dec 02 2017 06:22:44 GMT-0800 (Pacific Standard Time)
I happen after setTimeout!
Me too!
=== setInterval and clearInterval (p 202)
After timeout: Sat Dec 02 2017 06:22:45 GMT-0800 (Pacific Standard Time)
1: Sat Dec 02 2017 06:22:49 GMT-0800 (Pacific Standard Time)
2: Sat Dec 02 2017 06:22:54 GMT-0800 (Pacific Standard Time)
3: Sat Dec 02 2017 06:22:59 GMT-0800 (Pacific Standard Time)
*/