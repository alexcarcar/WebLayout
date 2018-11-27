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
