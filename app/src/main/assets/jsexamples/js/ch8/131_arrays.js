console.log("=== arrays (p 131)");
// array literals
const arr1 = [1, 2, 3];
const arr2 = ["one", 2, "three"];
const arr3 = [[1,2,3], ["one", 2, "three"]];
const arr4 = [
	{name: "Fred", type: "object", luckyNumbers:[5, 7, 13]},
	[
		{name: "Susan", type: "object"},
		{name: "Anthony", type: "object"}
	],
	1,
	function() {return "arrays can contain functions too";},
	"three"
];
console.log(arr1);
console.log(arr2);
console.log(arr3);
console.log(arr4);
console.log(arr1[0], arr1[2], arr3[1], arr4[1][0]);
console.log(arr1.length, arr4.length, arr4[1].length)

arr1[4]=5;
console.log(arr1, arr1.length);
console.log(arr2[10], arr2.length);

// Array constructor (rarely used)
const arr5 = new Array(); // empty array
const arr6 = new Array(1, 2, 3); // [1, 2, 3]
const arr7 = new Array(2); // new array of size 2
const arr8 = new Array("2") // ["2"]

console.log(arr5);
console.log(arr6);
console.log(arr7);
console.log(arr8);
/*
=== arrays (p 131)
[ 1, 2, 3 ]
[ 'one', 2, 'three' ]
[ [ 1, 2, 3 ], [ 'one', 2, 'three' ] ]
[ { name: 'Fred', type: 'object', luckyNumbers: [ 5, 7, 13 ] },
  [ { name: 'Susan', type: 'object' },
    { name: 'Anthony', type: 'object' } ],
  1,
  [Function],
  'three' ]
1 3 [ 'one', 2, 'three' ] { name: 'Susan', type: 'object' }
3 5 2
[ 1, 2, 3, , 5 ] 5
undefined 3
[]
[ 1, 2, 3 ]
[ ,  ]
[ '2' ]
*/
