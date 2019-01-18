function impureFunctionExample1() { // pp 38-39
	// The selfEducate function is not a pure function. It does not take any arguments, and
	// it does not return a value or a function. It also changes a variable outside of its scope:
	// Frederick. Once the selfEducate function is invoked, something about the “world”
	// has changed. It causes side effects:

	var frederick = {
		name: "Frederick Douglass",
		canRead: false,
		canWrite: false
	}

	function selfEducate() {
		frederick.canRead = true
		frederick.canWrite = true
		return frederick
	}

	selfEducate()
	console.log( frederick )
	// { name: 'Frederick Douglass', canRead: true, canWrite: true }
}
impureFunctionExample1()

function impureFunctionExample2() { // p 39
	// This selfEducate function is also impure: it causes side effects. Invoking this function
	// mutates the objects that are sent to it. If we could treat the arguments sent to this
	// function as immutable data, then we would have a pure function.

	const frederick = {
		name: "Frederick Douglass",
		canRead: false,
		canWrite: false
	}
	const selfEducate = (person) => {
		person.canRead = true
		person.canWrite = true
		return person
	}
	console.log( selfEducate(frederick) )
	console.log( frederick )
	// { name: 'Frederick Douglass', canRead: true, canWrite: true }
	// { name: 'Frederick Douglass', canRead: true, canWrite: true }
}
impureFunctionExample2()

function pureFunctionExample() {
	// Finally, this version of selfEducate is a pure function. It computes a value based on
	// the argument that was sent to it: the person. It returns a new person object without
	// mutating the argument sent to it and therefore has no side effects.
	const frederick = {
		name: "Frederick Douglass",
		canRead: false,
		canWrite: false
	}
	const selfEducate = person => Object.assign({}, person, {canRead: true, canWrite: true})
	console.log( selfEducate(frederick) )
	console.log( frederick )
	// { name: 'Frederick Douglass', canRead: true, canWrite: true }
	// { name: 'Frederick Douglass', canRead: false, canWrite: false }
}
pureFunctionExample()