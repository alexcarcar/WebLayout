// Functional programming is all about transforming data from one form to another.

const schools = [
	"Yorktown",
	"Washington & Lee",
	"Wakefield"
]

function basicTransformations() { // p 41
	// We can get a comma-delimited list of these and some other strings by using the Array.join function:
	console.log(schools.join(", ")) // Yorktown, Washington & Lee, Wakefield

	// If we wanted to create a function that creates a new array of the schools that begin
	// with the letter "W", we could use the Array.filter method:
	const wSchools = schools.filter(school => school[0] === "W")
	console.log(wSchools) // [ 'Washington & Lee', 'Wakefield' ]
}
basicTransformations()

function cutUsingFilter() { // p 42
	// In this case, the cutSchool function is used to return a new array that does not contain
	// "Washington & Lee". Then the join function is used with this new array to create
	// a star-delimited string out of the remaining two school names. cutSchool is a pure
	// function. It takes a list of schools and the name of the school that should be removed
	// and returns a new array without that specific school.

	const cutSchool = (cut, list) => list.filter(school => school !== cut)
	console.log(cutSchool("Washington & Lee", schools).join (" * ")) // Yorktown * Wakefield
	console.log(schools) // [ 'Yorktown', 'Washington & Lee', 'Wakefield' ]
}
cutUsingFilter()

function mapHighSchools() { // p 42
	const highSchools = schools.map(school => `${school} High School`)
	console.log(highSchools.join("\n"))
	// Yorktown High School
	// Washington & Lee High School
	// Wakefield High School
	console.log(schools.join("\n"))
	// Yorktown
	// Washington & Lee
	// Wakefield
	 
	const highSchoolsAsObjects = schools.map(school => ({ name: school }))
	console.log( highSchoolsAsObjects )
	// [ { name: 'Yorktown' },
	//   { name: 'Washington & Lee' },
	//   { name: 'Wakefield' } ]
}	
mapHighSchools()

function dontMutate() { // p 43
	// In the following example, we will change the school with
	// the name of "Stratford" to "HB Woodlawn" without mutating the schools array:
	const editName = (oldName, name, arr) =>
		arr.map(item => item.name===oldName?Object.assign({}, item, {name:name}):item)

	let schools = [
		{ name: "Yorktown"},
		{ name: "Stratford" },
		{ name: "Washington & Lee"},
		{ name: "Wakefield"}
	]
	let updatedSchools = editName("Stratford", "HB Woodlawn", schools)
	console.log( updatedSchools[1] ) // { name: "HB Woodlawn" }
	console.log( schools[1] ) // { name: "Stratford" },
}
dontMutate()

function transformObjectToArray() {
	// In this example, Object.keys returns an array of school names, and we can use map
	// on that array to produce a new array of the same length. The name of the new object
	// will be set using the key, and wins is set equal to the value.
	const schools = {
		"Yorktown": 10,
		"Washington & Lee": 2,
		"Wakefield": 5
	}
	console.log(Object.keys(schools)) // [ 'Yorktown', 'Washington & Lee', 'Wakefield' ]
	const schoolArray = Object.keys(schools).map(key => ({name:key, wins:schools[key]}))
	console.log(schoolArray)
	// [ { name: 'Yorktown', wins: 10 },
	//   { name: 'Washington & Lee', wins: 2 },
	//   { name: 'Wakefield', wins: 5 } ]
}
transformObjectToArray()

function reduceMaxAge() {
	// The ages array has been reduced into a single value: the maximum age, 64. reduce
	// takes two arguments: a callback function and an original value. In this case, the original
	// value is 0, which sets the initial maximum value to 0. The callback is invoked once
	// for every item in the array.
	const ages = [21,18,42,40,64,63,34];
	const maxAge = ages.reduce((max, age) => {
		console.log(`${age} > ${max} = ${age > max}`);
		if (age > max) {
			return age
		} else {
			return max
		}
	}, 0)
	console.log('maxAge', maxAge)
	// 21 > 0 = true
	// 18 > 21 = false
	// 42 > 21 = true
	// 40 > 42 = false
	// 64 > 42 = true
	// 63 > 64 = false
	// 34 > 64 = false
	// maxAge 64

	const max = ages.reduce((max, value) => value>max ? value : max, 0)
	console.log('max', max) // max 64
}
reduceMaxAge()

function colorfulReduce() {
	// In this example, the second argument sent to the reduce function is an empty object.
	// This is our initial value for the hash. During each iteration, the callback function adds
	// a new key to the hash using bracket notation and sets the value for that key to the id
	// field of the array. Array.reduce can be used in this way to reduce an array to a single
	// value--in this case, an object.
	const colors = [
		{id: '-xekare', title: "rad red", rating: 3 },
		{id: '-jbwsof', title: "big blue", rating: 2 },
		{id: '-prigbj', title: "grizzly grey", rating: 5 },
		{id: '-ryhbhsl', title: "banana", rating: 1 }
	]
	const hashColors = colors.reduce(
		(hash, {id, title, rating}) => {
			hash[id] = {title, rating}
			return hash
		}, {})
	console.log(hashColors);
	// { '-xekare': { title: 'rad red', rating: 3 },
	//   '-jbwsof': { title: 'big blue', rating: 2 },
	//   '-prigbj': { title: 'grizzly grey', rating: 5 },
	//   '-ryhbhsl': { title: 'banana', rating: 1 } }
}
colorfulReduce()

function distinctColors() { // p 47
	const colors = ["red", "red", "green", "blue", "green"];
	const distinctColors = colors.reduce(
		(distinct, color) => (distinct.indexOf(color) !== -1) ? distinct : [...distinct, color], [])
	console.log(distinctColors) // [ 'red', 'green', 'blue' ]
}
distinctColors()
