const log = console.log;
log("=== property enumeration (p 148)");
const SYM = Symbol();
const o1 = {a:1, b:2, c:3, [SYM]:4};

let temp = "";
for (let prop in o1) {
	if (!o1.hasOwnProperty(prop)) continue; // skip built-in properties
	temp += `${prop}:${o1[prop]} `;
}
log(temp);

temp = "";
Object.keys(o1).forEach(prop => temp += `_${prop}:${o1[prop]} `); log(temp);
const o2 = {apple:1, xochitl:2, balloon:3, guitar:4, xylophone:5};

temp = "";
Object.keys(o2)
	.filter(prop=>prop.match(/^x/))
	.forEach(prop=>temp += `*${prop}:${o2[prop]} `);
log(temp);

log("=== class and instance creation (p 150)");
class Car {
	constructor(make, model) {
		this.make = make;
		this.model = model;
		this._userGears = ['P', 'N', 'R', 'D'];
		this.userGear = this._userGears[0];
	}

	get userGear() {return this._userGear;}
	set userGear(gear) {
		if (this._userGears.indexOf(gear)<0) {
			throw new Error(`Invalid gear: ${gear}`);
		}
		this._userGear = gear;
	}
	shift(gear) {this.userGear = gear;}
}
const car1 = new Car("Tesla", "Model S");
const car2 = new Car("Mazda", "3i");
log("-->", car1 instanceof Car, car1 instanceof Array);
log(car1);
log(car2);
car1.shift('D');
car2.shift('R');
// car1.shift('X'); -- throws an error
log(car1.userGear, car2.userGear);

log("=== WeakMap (p 152)");
const Car2 = (function() {
	const carProps = new WeakMap();

	class Car2 {
		constructor(make,model) {
			this.make = make;
			this.model = model;
			this._userGears = ['P', 'N', 'R', 'D'];
			carProps.set(this, {userGear: this._userGears[0]});
		}

		get userGear() {return carProps.get(this).userGear;}
		set userGear(value) {
			if(this._userGears.indexOf(value) < 0)
				throw new Error(`Invalid gear: ${value}`);
			carProps.get(this).userGear = value;
		}
		shift(gear) {this.userGear = gear;}
	}
	return Car2;
})();

var honda = new Car2("Honda", "Accord");
honda.shift("D");
log(honda, honda.userGear);