//=====================================
function arraySearching() {
	const o = {name: "Jerry"};
	const arr = [1, 5, "a", o, true, 5, [1, 2], "9"];
	console.log(arr.indexOf(5)); // 1
	console.log(arr.lastIndexOf(5)); // 5
	console.log(arr.indexOf("a")); // 2
	console.log(arr.lastIndexOf("a")); // 2
	console.log(arr.indexOf({name: "Jerry"})); // -1
	console.log(arr.indexOf(o)); // 3
	console.log(arr.indexOf([1, 2])); // -1
	console.log(arr.indexOf("9")); // 7
	console.log(arr.indexOf(9)); // -1

	console.log(arr.indexOf("a", 5)); // -1
	console.log(arr.indexOf(5, 5)); // 5
	console.log(arr.lastIndexOf(5, 4)); // 1
	console.log(arr.lastIndexOf(true, 3)); // -1
}

// "findIndex" returns an index (or -1 if no match)
// but you can provide a function to determine a match
function findIndexExamples() {
	const arr = [
		{id:4, name:"George"},
		{id:10, name:"Simon"}
	];
	console.log(arr.findIndex(o=>o.id===4)); // 0
	console.log(arr.findIndex(o=>o.name==="Simon")); // 1
	console.log(arr.findIndex(o=>o.id===3)); // -1
}


// "find" returns undefined or the element itself if found
function findExamples() {
	const arr = [
		{id:4, name:"George"},
		{id:10, name:"Simon"}
	];
	console.log(arr.find(o=>o.id===4));
	// { id: 4, name: 'George' }
	console.log(arr.find(o=>o.id===3)); // undefined

	const numbers = [1, 17, 16, 5, 4, 16, 10, 3, 49];
	console.log(numbers.find(
		(x,i) => i>2 && Number.isInteger(Math.sqrt(x))
	)); // 4
}

function findObjectExample() {
	class Person {
		constructor(name) {
			this.name = name;
			this.id = Person.nextId++;
		}
	}
	Person.nextId = 0;
	const alex = new Person("Alex"),
		carol = new Person("Carol"),
		simon = new Person("Simon"),
		george = new Person("George");
	const family = [alex, carol, simon, george];

	// option 1: find by direct comparison of ID:
	console.log(family.find(p=>p.id===george.id));
	// Person { name: 'George', id: 3 }

	// option 2: find by using "this" argument:
	console.log(family.find(p=>p.id===this.id, george));
	// undefined
} 

function someAndEveryExamples() {
	const arr = [5, 7, 12, 15, 17];
	console.log(arr.some(x=>x%2===0));
	// true; 12 even
	console.log(arr.some(x=>Number.isInteger(Math.sqrt(x))));
	// false; no squares

	const anotherArr = [4, 6, 16, 36];
	console.log(anotherArr.every(x=>x%2===0));
	// true; every number is even
	console.log(anotherArr.every(x=>Number.isInteger(Math.sqrt(x))));
	// false; 6 is not a perfect square
}

arraySearching();
findIndexExamples();
findExamples();
findObjectExample();
someAndEveryExamples();