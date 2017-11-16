console.log("=== array manipulation (p 133)");
const arr = ["b", "c", "d"];
// Example 1: treating the array as a "stack" pushing/poping elements from the back
console.log(arr.push("e")); // returns the size of the new array: 4
console.log(arr);
console.log(arr.pop()); // return e

// Example 2: treating the array as a "queue" using shift (pop from front) , unshift (push to front)
arr.unshift("a"); // returns 4
console.log(arr); // a, b, c, d
console.log(arr.shift()); // a
console.log(arr); // b, c, d

// Example 3: concatenation of elements
const arrConcat = [1, 2, 3];
console.log(arrConcat.concat(4, 5, 6));
console.log(arrConcat.concat([4, 5, 6]));
console.log(arrConcat.concat([4, 5], 6));
console.log(arrConcat.concat([4, [5, 6]]));

// Example 4: get subarrays from [start, end]
const arrSlice = [1, 2, 3, 4, 5];
console.log(arrSlice.slice(3)); // [4, 5]
console.log(arrSlice.slice(2, 4)); // [3, 4]
console.log(arrSlice.slice(-2)); // [4, 5]
console.log(arrSlice.slice(1, -2)); // [2, 3]
console.log(arrSlice.slice(-2, -1)); // [4]

// Example 5: cutting and replacing within an array, ES6
const arrCopyWithin = [1, 2, 3, 4];
arrCopyWithin.copyWithin(1, 2); // copy target: index=1 "2", start=2 "3,4" -> 1,3,4,4
console.log(arrCopyWithin); // 1,3,4,4
arrCopyWithin.copyWithin(2, 0, 2); // target:2 "4", start=0 "1" end=2 "4" -> 1,3,1,3
console.log(arrCopyWithin); // 1,3,1,3
arrCopyWithin.copyWithin(0,-3,-1); // target:0 "1", start=-3 "3" end=-1 "3" -> 3,1,1,3
console.log(arrCopyWithin); // 3,1,1,3

// Example 6: filling an array with a specific value, ES6
const arrFill = new Array(5).fill(1);
console.log(arrFill); // [1, 1, 1, 1, 1]
console.log(arrFill.fill("a")); // [a,a,a,a,a]
console.log(arrFill.fill("b", 1)); // target=1 [a,b,b,b,b]
console.log(arrFill.fill("c", 2, 4)); // target=2 [a,b,c,c,b]
console.log(arrFill.fill(5.5, -4)); //[a,5.5,5.5,5.5,5.5]
console.log(arrFill.fill(0, -3, -1)); // [a,5.5,0,0,5.5]

// Example 7: reversing and sorting arrays
const arrSort = [1,2,3,4,5];
arrSort.reverse();
console.log(arrSort); //5,4,3,2,1
arrSort.sort();
console.log(arrSort); //1,2,3,4,5

// Example 8: sorting objects
const arrObjects = [
	{name:"George"},{name:"Alex"},{name:"Simon"},{name:"Carol"}
];
arrObjects.sort(); // does not work: returns the same order
console.log(arrObjects);
arrObjects.sort((a,b) => a.name > b.name); // sorts alphabetically
console.log(arrObjects);
arrObjects.sort((a,b) => a.name < b.name); // sorts reverse alphabetically
console.log(arrObjects);
arrObjects.sort((a,b) => a.name[1] > b.name[1]); // sorts alphabetically by second letter
console.log(arrObjects);

/*
=== array manipulation (p 133)
4
[ 'b', 'c', 'd', 'e' ]
e
[ 'a', 'b', 'c', 'd' ]
a
[ 'b', 'c', 'd' ]
[ 1, 2, 3, 4, 5, 6 ]
[ 1, 2, 3, 4, 5, 6 ]
[ 1, 2, 3, 4, 5, 6 ]
[ 1, 2, 3, 4, [ 5, 6 ] ]
[ 4, 5 ]
[ 3, 4 ]
[ 4, 5 ]
[ 2, 3 ]
[ 4 ]
[ 1, 3, 4, 4 ]
[ 1, 3, 1, 3 ]
[ 3, 1, 1, 3 ]
[ 1, 1, 1, 1, 1 ]
[ 'a', 'a', 'a', 'a', 'a' ]
[ 'a', 'b', 'b', 'b', 'b' ]
[ 'a', 'b', 'c', 'c', 'b' ]
[ 'a', 5.5, 5.5, 5.5, 5.5 ]
[ 'a', 5.5, 0, 0, 5.5 ]
[ 5, 4, 3, 2, 1 ]
[ 1, 2, 3, 4, 5 ]
[ { name: 'George' },
  { name: 'Alex' },
  { name: 'Simon' },
  { name: 'Carol' } ]
[ { name: 'Alex' },
  { name: 'Carol' },
  { name: 'George' },
  { name: 'Simon' } ]
[ { name: 'Simon' },
  { name: 'George' },
  { name: 'Carol' },
  { name: 'Alex' } ]
[ { name: 'Carol' },
  { name: 'George' },
  { name: 'Simon' },
  { name: 'Alex' } ]
*/
