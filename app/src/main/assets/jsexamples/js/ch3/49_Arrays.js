console.log("----- Arrays (p. 49) -----");
const a1 = [1, 2, 3, 4];			// array containing numbers
const a2 = [1, 'two', 3, null];		// array containing mixed types
const a3 = [						// array on muliple lines
	"What the hammer? What the chain?",
	"In what furnace was thy brain?",
	"What the anvil? What dread grasp",
	"Dare its deadly terrors clasp?"
];
const a4 = [
	{name: "Ruby", hardness: 9},	// array containing objects
	{name: "Diamond", hardness: 10},
	{name: "Topaz", hardness: 8}
];

console.log(a1, a2, a3, a4);
const arr = ['a', 'b', 'c'];
console.log(arr.length, arr[0], arr[arr.length-1]);

const arr2 = [1,2,'c',4,5];
arr2[2] = 3;
console.log(arr2);

console.log("----- Dates (p. 51) -----");
const now = new Date();
console.log(now);
const halloween = new Date (2017, 9, 31); // zero based month, 9=october
console.log(halloween);
const halloweenParty = new Date(2017, 9, 31, 19, 0); // 19:00 - 7:00 pm
console.log(halloweenParty);
console.log(halloweenParty.getFullYear(), halloweenParty.getMonth(), halloweenParty.getDate(), halloweenParty.getDay(), halloweenParty.getHours(), halloweenParty.getMinutes(), halloweenParty.getSeconds(), halloweenParty.getMilliseconds());

/*
----- Arrays (p. 49) -----
[ 1, 2, 3, 4 ] [ 1, 'two', 3, null ] [ 'What the hammer? What the chain?',
  'In what furnace was thy brain?',
  'What the anvil? What dread grasp',
  'Dare its deadly terrors clasp?' ] [ { name: 'Ruby', hardness: 9 },
  { name: 'Diamond', hardness: 10 },
  { name: 'Topaz', hardness: 8 } ]
3 'a' 'c'
[ 1, 2, 3, 4, 5 ]
----- Dates (p. 51) -----
2017-10-26T12:34:08.608Z
2017-10-31T07:00:00.000Z
2017-11-01T02:00:00.000Z
2017 9 31 2 19 0 0 0
*/