console.log("=== Iterators (p 175)");
const poem = [
	"Twinkle, twinkle, little star,",
	"How I wonder what you are!",
	"Up above the world so high,",
	"Like a diamond in the sky."
];
const poemIterator = poem.entries();
console.log(poemIterator.next());
console.log(poemIterator.next());
console.log(poemIterator.next());
console.log(poemIterator.next());
console.log(poemIterator.next());

const it = poem.entries();
let current = it.next();
while(!current.done) {
	console.log(current.value[1]);
	current = it.next();
}

// iterators are independent
const it1 = poem.entries();
const it2 = poem.entries();
it1.next();
it1.next();
console.log(it2.next().value[1], "\n"+it1.next().value[1]); // 1st line, 3rd line
/*
=== Iterators (p 175)
{ value: [ 0, 'Twinkle, twinkle, little star,' ], done: false }
{ value: [ 1, 'How I wonder what you are!' ], done: false }
{ value: [ 2, 'Up above the world so high,' ], done: false }
{ value: [ 3, 'Like a diamond in the sky.' ], done: false }
{ value: undefined, done: true }
Twinkle, twinkle, little star,
How I wonder what you are!
Up above the world so high,
Like a diamond in the sky.
Twinkle, twinkle, little star,
Up above the world so high,
*/