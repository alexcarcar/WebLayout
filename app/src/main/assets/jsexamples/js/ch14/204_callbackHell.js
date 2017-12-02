console.log("=== Callback Hell (p 204)");
const fs = require('fs');
fs.readFile('a.txt' , function(err, dataA) {
	if (err) return console.error(err);
	fs.readFile('b.txt', function(err, dataB) {
		if (err) return console.error(err);
		fs.readFile('c.txt', function(err, dataC) {
			if (err) return console.error(err);
			setTimeout(function() {
				console.log(dataA+dataB+dataC);
				fs.writeFile('d.txt', dataA+dataB+dataC, function(err) {
					if(err) return console(err);
				});
			}, 5*1000);
		});
	});
});

/*
=== Callback Hell (p 204)
a
b
c
*/