console.log("=== Using Promises (p 207)");
function countdown(seconds) {
	return new Promise(function(resolve, reject) {
		for(let i=seconds; i>=0; i--) {
			setTimeout(function() {
				if(i===13) return reject(new Error("DEFINITELY NOT COUNTING THAT"));
				if(i>0) console.log(i+'...');
				else resolve(console.log("GO!"));
			}, (seconds-i)*1000);
		}
	});
}

const p = countdown(13);

p.then(function() { // resolve function
	console.log("countdown completed successfully");
}	);
p.catch(function(err) { // reject function
	console.log("countdown experienced an error: " + err.message);
});
/*
=== Using Promises (p 207)
countdown experienced an error: DEFINITELY NOT COUNTING THAT
(node:616) UnhandledPromiseRejectionWarning: Unhandled promise rejection (reject
ion id: 1): Error: DEFINITELY NOT COUNTING THAT
12...
11...
10...
9...
8...
7...
6...
5...
4...
3...
2...
1...
GO!
*/