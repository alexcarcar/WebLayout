console.log("=== Preventing Unsettled Promises (p 211)");

function launch() {
	return new Promise (function(resolve, reject){
		console.log("Lift off!");
		if (Math.random()<0.5) return; // rocket failure <= returned without resolve
		setTimeout(function(){
			console.log("In orbit");
			resolve;
		}, 2*1000); // a very fast rocket
	});
}

launch();

/*
=== Preventing Unsettled Promises (p 211)
Lift off!
In orbit
*/