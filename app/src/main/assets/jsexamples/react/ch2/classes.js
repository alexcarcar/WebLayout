function vacationClass() {
	// Previously in JavaScript, there were no official classes. Types were defined by functions.
	// We had to create a function and then define methods on the function object
	// using the prototype:
	function Vacation(destination, length) {
		this.destination = destination
		this.length = length
	}
	Vacation.prototype.print = function() {
		console.log(this.destination + " | " + this.length + " days")
	}
	var maui = new Vacation("Maui", 7)
	maui.print() // Maui | 7 days
}
vacationClass()

function e6VacationClass() {
	// ES6 introduces class declaration, but JavaScript still works the same way. Functions
	// are objects, and inheritance is handled through the prototype, but this syntax makes
	// more sense if you come from classical object orientation:
	class Vacation {
		constructor(destination, length) {
			this.destination = destination
			this.length = length
		}
		print() {
			console.log(`${this.destination} will take ${this.length} days.`)
		}
	}
	const disney = new Vacation("Disney Land", 5)
	disney.print() // Disney Land will take 5 days.

	// Once you’ve created the class, you can create a new instance of the class using the new
	// keyword. Then you can call the custom method on the class:
	const trip = new Vacation("Santiago, Chile", 7)
	trip.print() // Chile will take 7 days.

	// You can use Vacation as an abstract class to create different types of vacations. For
	// instance, an Expedition can extend the Vacation class to include gear:
	class Expedition extends Vacation {
		constructor(destination, length, gear) {
			super(destination, length)
			this.gear = gear
		}
		print() {
			super.print()
			console.log(`Bring your ${this.gear.join(" and your ")}.`)
		}
	}

	const fiji = new Expedition("Fiji", 3, ["sunglasses", "camera"])
	fiji.print()
	// Fiji will take 3 days.
	// Bring your sunglasses and your camera.
}
e6VacationClass()
