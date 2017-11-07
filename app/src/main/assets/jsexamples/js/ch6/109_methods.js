console.log("=== methods (p 109)");

// Example 1:
const oA = {
	name: 'Wallace',
	bark: function() {return 'Woof!';}
}
console.log(oA.bark());

// Example 1 (ES6):
const oES6 = {
	name: 'Doggie',
	bark() {return 'bark bark';}
}
console.log(oES6.bark());

// Example 2:
const oGeorge = {
	name: 'George',
	speak: function() {return `My name is ${this.name}!`;}
}
console.log(oGeorge.speak());
const speakGeorge = oGeorge.speak;
console.log(speakGeorge === oGeorge.speak, speakGeorge()); // this is undefined here

// Example 3:
const oJulie = {
	name: 'Julie',
	greetBackwards: function() {
		const self = this;
		function getReverseName() {
			let nameBackwards = '';
			for(let i=self.name.length-1; i>=0; i--) {
				nameBackwards += self.name[i];
			}
			return nameBackwards;
		}
		return `${getReverseName()} si eman ym ,olleH`;
	}
};
console.log(oJulie.greetBackwards());

// Arrow Notation:
const f1 = () => 'hello!';
const f2 = name => `Hello, ${name}!`;
const f3 = (a,b) => a+b
console.log(f1(), f2("George"), f3(5,6));
const oArrow = {
	name: 'Arrow',
	greetBackwards: function() {
		const getReverseName = () => {
			let nameBackwards = '';
			for(let i=this.name.length-1; i>=0; i--) {
				nameBackwards += this.name[i];
			}
			return nameBackwards;
		};
		return `${getReverseName()} si eman ym ,olleH`;
	}
}
console.log(oArrow.greetBackwards());

/*
=== methods (p 109)
Woof!
bark bark
My name is George!
true 'My name is undefined!'
eiluJ si eman ym ,olleH
hello! Hello, George! 11
worrA si eman ym ,olleH
*/