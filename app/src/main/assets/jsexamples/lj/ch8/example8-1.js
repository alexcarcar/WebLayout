//=====================================
function reviewOfArrays() {
	// array literals
	const arr1 = [1, 2, 3];
	const arr2 = ["one", 2, "three"];
	const arr3 = [[1,2,3], ["one",2,"three"]];
	const arr4 = [
		{name:"Fred", type:"object", luckyNumbers:[5,7,13]},
		[
			{name:"Susan", type:"object"},
			{name:"Anthony", type:"object"},
		],
		1,
		function() { return "arrays can contain functions too";},
		"three"
	];

	// accessing elements
	console.log(arr1[0], arr1[2]); // 1 3
	console.log(arr3[1]); // [ 'one', 2, 'three' ]
	console.log(arr4[1][0]); // { name: 'Susan', type: 'object' }

	// array length
	console.log(arr1.length, arr4.length, arr4[1].length); // 3 5 2

	// increase the array size
	arr1[4] = 5;
	console.log(arr1, arr1.length); // [ 1, 2, 3, , 5 ] 5

	// accessing (not assigning) an index larger than the array
	// does *not* change the size of the array
	console.log(arr2[10], arr2.length); // undefined 3

	// Array constructor (rarely used)
	const arr5 = new Array();
	const arr6 = new Array(1, 2, 3);
	const arr7 = new Array(2);
	const arr8 = new Array("2");
	console.log(arr5); // []
	console.log(arr6); // [ 1, 2, 3 ]
	console.log(arr7); // [ ,  ]
	console.log(arr8); // [ '2' ]
}

reviewOfArrays();