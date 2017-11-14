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
