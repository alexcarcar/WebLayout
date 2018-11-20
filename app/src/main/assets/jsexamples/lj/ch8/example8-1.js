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
//=====================================

function addingOrRemoving() {
	const arr = ["b", "c", "d"];
	// push and pop operate on the end of the array
	console.log(arr.push("e"), arr); // 4 [ 'b', 'c', 'd', 'e' ]
	console.log(arr.pop(), arr); // e [ 'b', 'c', 'd' ]
	// unshift and shift operate on the front of the array
	console.log(arr.unshift("a"), arr); // 4 [ 'a', 'b', 'c', 'd' ]
	console.log(arr.shift(), arr); // a [ 'b', 'c', 'd' ]
}

function addingMultipleElements() {
	const arr  = [1, 2, 3];

	// returns concatenated arr, but does not modify original array
	console.log(arr.concat(4, 5, 6), arr); // [ 1, 2, 3, 4, 5, 6 ] [ 1, 2, 3 ]
	console.log(arr.concat([4, 5, 6]), arr); // [ 1, 2, 3, 4, 5, 6 ] [ 1, 2, 3 ]
	console.log(arr.concat([4, 5], 6), arr); // [ 1, 2, 3, 4, 5, 6 ] [ 1, 2, 3 ]
	console.log(arr.concat(4, [5, 6]), arr); // [ 1, 2, 3, 4, 5, 6 ] [ 1, 2, 3 ]
}

reviewOfArrays();
addingOrRemoving();
addingMultipleElements();
