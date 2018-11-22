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

// If you want to get a subarray from an array, use "slice".
// - first argument -- is where the subarray begins
// - second argument -- is where the subarray ends (not including the second argument)
function gettingASubarray() {
	const arr = [1, 2, 3, 4, 5];
	console.log(arr.slice(3), arr); // [ 4, 5 ] [ 1, 2, 3, 4, 5 ]
	console.log(arr.slice(2, 4), arr); // [ 3, 4 ] [ 1, 2, 3, 4, 5 ]
	console.log(arr.slice(-2), arr); // [ 4, 5 ] [ 1, 2, 3, 4, 5 ]
	console.log(arr.slice(1, -2), arr); // [ 2, 3 ] [ 1, 2, 3, 4, 5 ]
	console.log(arr.slice(-2, -1), arr); // [ 4 ] [ 1, 2, 3, 4, 5 ]
}

// "splice" allows you to do in-place modification of the string,
// adding and/or removing elements from any index.
// - first argument -- is the index you want to start modifying
// - second argument -- number of elements to remove [and returned] (0 not to remove any)
// - remaning arguments -- to be added
function addingRemovingAtAnPosition() {
	const arr = [1, 5, 7];
	console.log(arr.splice(1, 0, 2, 3, 4), arr); // [] [ 1, 2, 3, 4, 5, 7 ]
	console.log(arr.splice(5, 0, 6), arr); // [] [ 1, 2, 3, 4, 5, 6, 7 ]
	console.log(arr.splice(1, 2), arr); // [ 2, 3 ] [ 1, 4, 5, 6, 7 ]
	console.log(arr.splice(2, 1, 'a', 'b'), arr); // [ 5 ] [ 1, 4, 'a', 'b', 6, 7 ]
}	

// ES6 introduces "copyWithin" that takes a sequence of elements from an array
// and copies them in place, to a different part of the array, overwriting elements
// - first argument -- is where to copy (the target)
// - second argument -- is where to copy from
// - final (optional) argument -- where to stop copying from
function cuttingAndReplacing() {
	const arr = [1, 2, 3, 4];
	console.log(arr.copyWithin(1, 2), arr); // [ 1, 3, 4, 4 ] [ 1, 3, 4, 4 ]
	console.log(arr.copyWithin(2, 0, 2), arr); // [ 1, 3, 1, 3 ] [1, 3, 1, 3 ]
	console.log(arr.copyWithin(0, -3, -1), arr); // [ 3, 1, 1, 3 ] [3, 1, 1, 3 ]
}

// ES6 introduces "fill" that sets any number of elements to a fixed value (in place)
// - first argument -- value to fill
// - (optional) start and end indicies
function fillArray() {
	const arr = new Array(5).fill(1);
	console.log(arr); // [ 1, 1, 1, 1, 1 ]
	console.log(arr.fill("a")); // [ 'a', 'a', 'a', 'a', 'a' ]
	console.log(arr.fill("b", 1)); // [ 'a', 'b', 'b', 'b', 'b' ]
	console.log(arr.fill("c", 2, 4)); // [ 'a', 'b', 'c', 'c', 'b' ]
	console.log(arr.fill(5.5, -4)); // [ 'a', 5.5, 5.5, 5.5, 5.5 ]
	console.log(arr.fill(0, -3, -1)) // [ 'a', 5.5, 0, 0, 5.5 ]
}

function reverseAndSort() {
	const arr = [1, 2, 3, 4, 5];
	arr.reverse(); console.log(arr); // [ 5, 4, 3, 2, 1 ]
	arr.sort(); console.log(arr); // [ 1, 2, 3, 4, 5 ]

	const people = [{name:"Alex"}, {name:"Carol"}, {name:"Simon"}, {name:"George"}];
	people.sort(); console.log(people);
	// [ { name: 'Alex' },
	//   { name: 'Carol' },
	//   { name: 'Simon' },
	//   { name: 'George' } ]

	people.sort((a, b) => a.name > b.name); console.log(people);
	// [ { name: 'Alex' },
	//   { name: 'Carol' },
	//   { name: 'George' },
	//   { name: 'Simon' } ]

	people.sort((a, b) => a.name < b.name); console.log(people);
	// [ { name: 'Simon' },
	//   { name: 'George' },
	//   { name: 'Carol' },
	//   { name: 'Alex' } ]

	people.sort(function(a, b) {return a.name > b.name;}); console.log(people);
	// [ { name: 'Alex' },
	//   { name: 'Carol' },
	//   { name: 'George' },
	//   { name: 'Simon' } ]
}

reviewOfArrays();
addingOrRemoving();
addingMultipleElements();
gettingASubarray();
addingRemovingAtAnPosition();
cuttingAndReplacing();
fillArray();
reverseAndSort();