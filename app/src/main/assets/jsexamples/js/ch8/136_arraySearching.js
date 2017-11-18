console.log("=== Array Searching (p 136)");
const o1 = {name: "Jerry"};
const a1 = [1, 5, "a", o1, true, 5, [1,2], "9"];
console.log(a1.indexOf(5), a1.lastIndexOf(5), a1.indexOf("a"), a1.lastIndexOf("a")); // 1, 5, 2, 2
console.log(a1.indexOf({name: "Jerry"}), a1.indexOf(o1)); // -1 (not 'strictly equal'), 3
console.log(a1.indexOf([1,2])); // -1, arrays (objects) must reference the same object
console.log(a1.indexOf("9"), a1.indexOf(9)); // 7, -1
console.log(a1.indexOf("a",5),a1.indexOf(5,5),a1.lastIndexOf(5,4),a1.lastIndexOf(true,3));//-1,5,1,-1

console.log("=== findIndex");
const a2 = [{id:5, name:"Judith"}, {id:7, name:"Francis"}];
console.log(a2.findIndex(o=>o.id===5)); // 0
console.log(a2.findIndex(o=>o.name==="Francis")); // 1
console.log(a2.findIndex(o=>o===3), a2.findIndex(o=>o.id===17)); // -1 -1

console.log("=== find");
console.log(a2.find(o=>o.id===5)); // {id:5, name:"Judith"}
console.log(a2.find(o=>o.id===2)); // undefined
const a3 = [1, 17, 16, 5, 4, 36, 10, 3, 49];
console.log(a3.find((x,i)=> i>1 && Number.isInteger(Math.sqrt(x)))); // 16
console.log(a3.find((x,i)=> i>2 && Number.isInteger(Math.sqrt(x)))); // 4
console.log(a3.find((x,i)=> i>6 && Number.isInteger(Math.sqrt(x)))); // 49

console.log("=== find (this)");
class Person {
	constructor(name) {
		this.name = name;
		this.id = Person.nextId++;
	}
}
Person.nextId = 0;
const
	george = new Person("George"),
	simon = new Person("Simon"),
	alex = new Person("Alex"),
	carol = new Person("Carol");
const aFamily = [george, simon, alex, carol];
console.log(aFamily);
// option 1: direct comparison of ID:
console.log(aFamily.find(p => p.id===simon.id));
// option 2: using "this" argument:
console.log(aFamily.find(p => p.id===this.id, george));

console.log("=== some (p 137)");
const a4 = [5, 7, 12, 15, 17];
console.log(a4.some(x=>x%2===0)); // true, 12 is even
console.log(a4.some(x=>Number.isInteger(Math.sqrt(x))));  // false, no squares
const a5 = [5, 7, 12, 15, 121];
console.log(a5.some(x=>Number.isInteger(Math.sqrt(x))));  // true, 121 is a square

console.log("=== every");
const a6 = [4, 6, 16, 36];
console.log(a6.every(x => x%2 === 0)); // true; every element is even
console.log(a6.every(x => Number.isInteger(Math.sqrt(x)))); // false; 6 is not a square

/*
=== Array Searching (p 136)
1 5 2 2
-1 3
-1
7 -1
-1 5 1 -1
=== findIndex
0
1
-1 -1
=== find
{ id: 5, name: 'Judith' }
undefined
16
4
49
=== find (this)
[ Person { name: 'George', id: 0 },
  Person { name: 'Simon', id: 1 },
  Person { name: 'Alex', id: 2 },
  Person { name: 'Carol', id: 3 } ]
Person { name: 'Simon', id: 1 }
undefined
=== some (p 137)
true
false
true
=== every
true
false
*/