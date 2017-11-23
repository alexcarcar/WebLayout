console.log("=== Creating Maps (p 164)");
// Using a list of object
const redBall = {name:'red'};
const blueBall = {name:'blue'};
const greenBall = {name: 'green'};
const points = new Map();
points.set(redBall, -10);
points.set(blueBall, 5);
points.set(greenBall, 50);
console.log(points);

// The set() method is chainable
const romanValues = new Map();
romanValues.set('I', 1).set('V', 5).set('X', 10).set('L', 50).set('C', 100);
console.log(romanValues);

// The Map.constructor() method accepts arrays
const grades = new Map([["Math", 98], ["Science", 88], ["English", 79]]);
console.log(grades);

console.log("=== Inspecting Maps");
console.log(points.get(greenBall), romanValues.get('X'), grades.get("English")); // 50 10 79
console.log(points.size, romanValues.size, grades.size, grades.has("Art"), romanValues.has("X")); // 3 5 3 false true
console.log(grades.keys(), grades.values(), grades.entries());
for (let r of romanValues.keys()) {
	console.log(r);
}
for (let subject of grades.entries()) {
	console.log(subject[0],subject[1]);
}
// An example of deconstruting arguments
for (let [ball,point] of points) { // entries is the default iterator
	console.log("-->", point, ball.name);
}

// Using the separator object to convert an iteratable to an array
console.log([...romanValues.keys()],[...romanValues.values()]);
romanValues.delete('L');
console.log([...romanValues.keys()], romanValues.size);
romanValues.clear();
console.log(romanValues.size);
/*
=== Creating Maps (p 164)
Map {
  { name: 'red' } => -10,
  { name: 'blue' } => 5,
  { name: 'green' } => 50 }
Map { 'I' => 1, 'V' => 5, 'X' => 10, 'L' => 50, 'C' => 100 }
Map { 'Math' => 98, 'Science' => 88, 'English' => 79 }
=== Inspecting Maps
50 10 79
3 5 3 false true
MapIterator { 'Math', 'Science', 'English' } MapIterator { 98, 88, 79 } MapItera
tor { [ 'Math', 98 ], [ 'Science', 88 ], [ 'English', 79 ] }
I
V
X
L
C
Math 98
Science 88
English 79
--> -10 red
--> 5 blue
--> 50 green
[ 'I', 'V', 'X', 'L', 'C' ] [ 1, 5, 10, 50, 100 ]
[ 'I', 'V', 'X', 'C' ] 4
0
*/
