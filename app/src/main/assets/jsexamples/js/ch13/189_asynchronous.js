console.log("=== IIFEs and Asynchronous Code (p 189)");
setTimeout(function() {console.log("hello");}, 1500);
for(let i=5; i>=0; i--) {
	setTimeout(function() {
		console.log(i===0 ? "go!" : i);
	}, (5-i)*1000);
}

/*
=== IIFEs and Asynchronous Code (p 189)
5
4
hello
3
2
1
go!
*/