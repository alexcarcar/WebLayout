// ===========================================
// - "map" transforms the elements of array
// - Both "map" and "filter" return copies and
// do not modify the original array.

function mapExample1() {
	const cart = [
		{name:"Widget", price:9.95},
		{name:"Gadget", price:22.95}
	];

	const names = cart.map(x => x.name);
	console.log(names); // [ 'Widget', 'Gadget' ]

	const prices = cart.map(function(x){return x.price;});
	console.log(prices); // [ 9.95, 22.95 ]

	const discountPrices = prices.map(x => x*0.8);
	console.log(discountPrices); // [ 7.96, 18.36 ]

	const lcNames = names.map(x => x.toLowerCase());
	console.log(lcNames); // [ 'widget', 'gadget' ]
}

function mapExample2() {
	const items = ["Widget", "Gadget"];
	const prices = [9.95, 22.95];
	const cart = items.map((x,i)=>({name:x,price:prices[i]}));
	console.log(cart);
	// [ { name: 'Widget', price: 9.95 },
	//   { name: 'Gadget', price: 22.95 } ]

}

mapExample1();
mapExample2();

// ===========================================
// - "filter" removes unwanted this from an array.

function filterExample1() {
	// create a deck of playing cards
	const cards = [];
	for (let suit of ['H', 'C', 'D', 'S']) {
		for (let value=1; value<=13; value++) {
			cards.push({suit, value});
		}
	}

	const twos = cards.filter(c=>c.value===2);
	console.log(twos);
	// [ { suit: 'H', value: 2 },
	//   { suit: 'C', value: 2 },
	//   { suit: 'D', value: 2 },
	//   { suit: 'S', value: 2 } ]

	const diamonds = cards.filter(c=>c.suit==='D');
	const face = cards.filter(c=>c.value>10);
	const heartFace = cards.filter(c=>c.value>10 && c.suit==='H');
	console.log(diamonds.length, face.length, heartFace.length); // 13 12 3
	console.log(twos.map(cardToString)); // [ '2♥', '2♣', '2♦', '2♠' ]
	console.log(heartFace.map(cardToString)); // [ 'J♥', 'Q♥', 'K♥' ]
}

function cardToString(c) {
	const suits = {'H':'\u2665', 'C':'\u2663', 'D':'\u2666', 'S':'\u2660'};
	const values = {1:'A', 11:'J', 12:'Q', 13:'K'};
	for (let i=2;i<=10;i++) values[i] = i;
	return values[c.value]+suits[c.suit];
}

filterExample1();

// ================================================================================
// Array Magic: reduce

// - Where "map" transforms each element in the array,
// - "reduce" transforms the entire array (i.e. sum, average)
// - "reduce" allows you to provide a callback function, with:
// -> first element is an "accumulator" which is what the array is reducing to
// -> second element - current array element
// -> third element - current index
// -> forth element - the array itself
// - in addition to the callback function, reduce can take a optional initial value

reduceExamples();
function reduceExamples() {
	const arr = [5, 7, 2, 4];
	const sum = arr.reduce((a,x) => a+=x, 0); // a initially is 0
	const sum2 = arr.reduce((a,x) => a+=x); // here a is initially undefined
	console.log(sum, sum2);
}

// For example, if you have an array of strings you can create an object accumulator
// to divide the strings into alphabetic arrays
alphabeticArrays();
function alphabeticArrays() {
	const words = [
		"Beachball", "Rodeo", "Angel", "Aardvark", "Xylophone", "November",
		"Chocolate", "Papaya", "Uniform", "Joker", "Clover", "Bali"];

	const alphabetical = words.reduce((a,x) => {
		if (!a[x[0]]) a[x[0]] = [];
		a[x[0]].push(x);
		return a;
	}, {});
	console.log(alphabetical);
	// { B: [ 'Beachball', 'Bali' ],
	//   R: [ 'Rodeo' ],
	//   A: [ 'Angel', 'Aardvark' ],
	//   X: [ 'Xylophone' ],
	//   N: [ 'November' ],
	//   C: [ 'Chocolate', 'Clover' ],
	//   P: [ 'Papaya' ],
	//   U: [ 'Uniform' ],
	//   J: [ 'Joker' ] }
}

// For example, reduce to calculate mean and variation
meanAndVaration();
function meanAndVaration() {
	const data = [3.3, 5, 7.2, 12, 4, 6, 10.3];
	// Using Donald Knuth's Algorithm
	const stats = data.reduce((a,x) => {
		a.N++;
		let delta = x-a.mean;
		a.mean += delta/a.N;
		a.M2 += delta*(x - a.mean);
		return a;
	}, {N:0, mean:0, M2:0});
	if (stats.N>2) {
		stats.variance = stats.M2/(stats.N-1);
		stats.stdev = Math.sqrt(stats.variance);
	}
	console.log(stats);
	// { N: 7,
	//   mean: 6.828571428571428,
	//   M2: 63.41428571428572,
	//   variance: 10.56904761904762,
	//   stdev: 3.2510071699471257 }
}

// For example, using a string accumulator to get a single string
// containing all words longer than six letters.
longerThan6();
function longerThan6() {
	const words = [
		"Beachball", "Rodeo", "Angel", "Aardvark", "Xylophone", "November",
		"Chocolate", "Papaya", "Uniform", "Joker", "Clover", "Bali"];

	const longWords = words.reduce((a,w)=>w.length>6?a+" "+w:a ,"").trim();
	console.log(longWords);
	// Beachball Aardvark Xylophone November Chocolate Uniform
}

// =========================================================================
arrayMethodsWithDeletedElements(); // map skips deleted elements
function arrayMethodsWithDeletedElements() {
	const arr = Array(10).map(function(x) {return 5});
	console.log(arr); // [ , , , , , , , , ,  ]

	const arr2 = [1, 2, 3, 4, 5];
	delete arr2[2];
	console.log(arr2.map(x=>0)); // [ 0, 0, , 0, 0 ]
}

// =========================================================================
// Array.prototype.join takes a single argument (comma if you omit it)
stringJoining();
function stringJoining() {
	const arr = [1, null, "hello", "world", true, undefined];
	delete arr[3];
	console.log(arr.join()); // 1,,hello,,true,
	console.log(arr.join('')); // 1hellotrue
	console.log(arr.join(' -- ')); // 1 --  -- hello --  -- true --

	const attributes = ["Nimble", "Perceptive", "Generous"];
	const html = '<ul><li>' + attributes.join('</li><li>') + '</li></ul>';
	console.log(html); // <ul><li>Nimble</li><li>Perceptive</li><li>Generous</li></ul>
}
