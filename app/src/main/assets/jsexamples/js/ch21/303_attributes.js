'use strict';

console.log("=== Object Property Attributes (p 303)");
const obj = {foo: "bar", foo2: "bar2"};
console.log(obj);
console.log(Object.getOwnPropertyDescriptor(obj, 'foo'));
Object.defineProperty(obj, 'foo', {writable:false});
try {
	obj.foo = 3;
} catch(err) {
	console.log(err.message);
}
obj.foo2 = 3;
console.log(obj);
console.log(Object.getOwnPropertyDescriptor(obj, 'foo')); // notice foo is still "bar"
