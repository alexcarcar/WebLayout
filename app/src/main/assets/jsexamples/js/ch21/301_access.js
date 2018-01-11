console.log("=== Getters and Setters (p 301)");

const USER_EMAIL = Symbol();
class User {
	setEmail(value) {
		if (!/@/.test(value)) throw new Error(`invalid email: ${value}`);
		this[USER_EMAIL] = value;
	}
	getEmail() {
		return this[USER_EMAIL];
	}
}

const u = new User();
u.setEmail("john@doe.com");
console.log(`User email: ${u.getEmail()}`);

class BetterUser {
	set email(value) {
		if (!/@/.test(value)) throw new Error(`invalid email: ${value}`);
		this[USER_EMAIL] = value;
	}
	get email() {
		return this[USER_EMAIL];
	}
}

const bu = new BetterUser();
bu.email = "john@doe.com";
console.log(`User email: ${bu.email}`);

class Rectangle {
	constructor(width, height) {
		this.width = width;
		this.height = height;
		console.log(`Contructing a rectangle: ${width}x${height}`);
	}
	get perimeter() {
		return this.width*2 + this.height*2;
	}
}
const rectangle = new Rectangle(200,150);
console.log(`Perimeter: ${rectangle.perimeter}`);

/*
=== Getters and Setters (p 301)
User email: john@doe.com
User email: john@doe.com
Contructing a rectangle: 200x150
Perimeter: 700
*/