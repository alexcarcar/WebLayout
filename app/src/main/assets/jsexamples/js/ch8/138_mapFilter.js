console.log("=== map (p 138)");
const cart = [
	{name:"Widget", price:9.95},
	{name:"Gadget", price:19.95}
];
const names = cart.map(x=>x.name);
const prices = cart.map(function(x){return x.price;});
const discountPrices = cart.map(x=>x.price*0.8);
const lowerNames = names.map(x=>x.toLowerCase());
const upperNames = cart.map(x=>x.name.toUpperCase());
console.log(names, prices, discountPrices);
console.log(lowerNames, upperNames);

const kidNames = ["Simon", "George"];
const kidAges = [9, 3];
const kids = kidNames.map((x,i)=> ({name:x, age:kidAges[i]}));
console.log(kids);

const cafeNames = ["coffee", "cookie"];
const cafePrices = [1.95, 2.10];
const cafeItems = cafeNames.map((x,i) => ({name:x, price:cafePrices[i]}));
console.log(cafeItems);

console.log("=== filter (p 139)");
const cards = [];
for (let suit of ['H', 'C', 'D', 'S']) {
	for (let value=1; value<=13; value++) {
		cards.push({suit,value});
	}
}
const cards2s = cards.filter(x=>x.value===2);
console.log(cards2s.map(x=>x.value+x.suit).join());
const diamonds = cards.filter(x=>x.suit==='D');
console.log(diamonds.map(x=>x.value+x.suit).join());
const faceCards = cards.filter(x=>x.value>10);
console.log(faceCards.map(x=>x.value+x.suit).join());
const faceHearts = cards.filter(x=>x.value>10&&x.suit==='H');
console.log(faceHearts.map(x=>x.value+x.suit).join());

function cardToString(c) {
	const suits = {'H': '\u2665', 'C': '\u2663', 'D': '\u2666', 'S': '\u2660'};
	const values = {1:'A', 11:'J', 12:'Q', 13:'K'};
	for (let i=2; i<=10;i++) {
		values[i] = i;
	}
	return values[c.value] + suits[c.suit];
}
console.log(cards.filter(c=>c.value===7).map(cardToString));
console.log(cards.filter(c=>c.value>10 && c.suit==='H').map(cardToString));

console.log("=== reduce (p 140)");
const arrSum = [5, 7, 2, 4];
const sum = arrSum.reduce((a,x) => a += x,0);
const sum1= arrSum.reduce((a,x) => a += x,1);
const sum2= arrSum.reduce((a,x) => a += x);
const sum3= arrSum.reduce((a,x) => a + x);
console.log(sum,sum1,sum2,sum3); // 18 19 18 18

const words = ["Beachball", "Rodeo", "Angel", "Aardvark", "Xylophone", "November", "Chocolate", "Papaya", "Uniform", "Joker", "Clover", "Bali"];
const alphabetical = words.reduce((a,x) => {
	if (!a[x[0]]) {
		a[x[0]] = []; // creates a container for words beginning with the first letter
	}
	a[x[0]].push(x); // is building an array of arrays
	return a;
},{});
console.log(alphabetical);

const data = [3.3, 5, 7.2, 12, 4, 6, 10.3];
const stats = data.reduce((a,x) => {
	a.N++;
	let delta = x - a.mean;
	a.mean += delta/a.N;
	a.M2 += delta*delta;
	return a;
},{N:0, mean:0, M2:0});
if (stats.N > 2) {
	stats.variance = stats.M2 / (stats.N - 1);
	stats.stdev =  Math.sqrt(stats.variance);
}
console.log(data.join(), stats);

const longWords = words.reduce((a,w)=>w.length>6 ? a+" "+w : a, "").trim();
console.log(longWords);
const longWords2 = words.filter(w=>w.length>6).join(' ');
console.log(longWords2);

console.log("=== deleted, or never-defined elements");
const arrExample = Array(10).map(function(x){return 5}); // function is not called for undefined
console.log(arrExample); // , , , , ...
const arrExample2 = [1,2,3,4,5];
delete arrExample2[2];
arrExample2.map(x=>0);
console.log(arrExample2); // 1,2,,4,5

console.log("=== join (p 143)");
const arrJoin = [1, null, "hello", "world", true, undefined];
delete arrJoin[3];
console.log(arrJoin.join());
console.log(arrJoin.join(''));
console.log(arrJoin.join(' -- '));
const attributes = ["Nimble", "Perceptive", "Generous"];
const html = '<ul><li>' + attributes.join('</li><li>') + '</li></ul>';
console.log(html);
/*
=== map (p 138)
[ 'Widget', 'Gadget' ] [ 9.95, 19.95 ] [ 7.96, 15.96 ]
[ 'widget', 'gadget' ] [ 'WIDGET', 'GADGET' ]
[ { name: 'Simon', age: 9 }, { name: 'George', age: 3 } ]
[ { name: 'coffee', price: 1.95 },
  { name: 'cookie', price: 2.1 } ]
=== filter (p 139)
2H,2C,2D,2S
1D,2D,3D,4D,5D,6D,7D,8D,9D,10D,11D,12D,13D
11H,12H,13H,11C,12C,13C,11D,12D,13D,11S,12S,13S
11H,12H,13H
[ '7♥', '7♣', '7♦', '7♠' ]
[ 'J♥', 'Q♥', 'K♥' ]
=== reduce (p 140)
18 19 18 18
{ B: [ 'Beachball', 'Bali' ],
  R: [ 'Rodeo' ],
  A: [ 'Angel', 'Aardvark' ],
  X: [ 'Xylophone' ],
  N: [ 'November' ],
  C: [ 'Chocolate', 'Clover' ],
  P: [ 'Papaya' ],
  U: [ 'Uniform' ],
  J: [ 'Joker' ] }
3.3,5,7.2,12,4,6,10.3 { N: 7,
  mean: 6.828571428571428,
  M2: 94.53506944444445,
  variance: 15.755844907407408,
  stdev: 3.969363287406106 }
Beachball Aardvark Xylophone November Chocolate Uniform
Beachball Aardvark Xylophone November Chocolate Uniform
=== deleted, or never-defined elements
[ , , , , , , , , ,  ]
[ 1, 2, , 4, 5 ]
=== join (p 143)
1,,hello,,true,
1hellotrue
1 --  -- hello --  -- true --
<ul><li>Nimble</li><li>Perceptive</li><li>Generous</li></ul>

% node 138_mapFilter.js
=== map (p 138)
[ 'Widget', 'Gadget' ] [ 9.95, 19.95 ] [ 7.96, 15.96 ]
[ 'widget', 'gadget' ] [ 'WIDGET', 'GADGET' ]
[ { name: 'Simon', age: 9 }, { name: 'George', age: 3 } ]
[ { name: 'coffee', price: 1.95 },
  { name: 'cookie', price: 2.1 } ]
=== filter (p 139)
2H,2C,2D,2S
1D,2D,3D,4D,5D,6D,7D,8D,9D,10D,11D,12D,13D
11H,12H,13H,11C,12C,13C,11D,12D,13D,11S,12S,13S
11H,12H,13H
[ '7♥', '7♣', '7♦', '7♠' ]
[ 'J♥', 'Q♥', 'K♥' ]
=== reduce (p 140)
18 19 18 18
{ B: [ 'Beachball', 'Bali' ],
  R: [ 'Rodeo' ],
  A: [ 'Angel', 'Aardvark' ],
  X: [ 'Xylophone' ],
  N: [ 'November' ],
  C: [ 'Chocolate', 'Clover' ],
  P: [ 'Papaya' ],
  U: [ 'Uniform' ],
  J: [ 'Joker' ] }
3.3,5,7.2,12,4,6,10.3 { N: 7,
  mean: 6.828571428571428,
  M2: 94.53506944444445,
  variance: 15.755844907407408,
  stdev: 3.969363287406106 }
Beachball Aardvark Xylophone November Chocolate Uniform
Beachball Aardvark Xylophone November Chocolate Uniform
=== deleted, or never-defined elements
[ , , , , , , , , ,  ]
[ 1, 2, , 4, 5 ]
=== join (p 143)
1,,hello,,true,
1hellotrue
1 --  -- hello --  -- true --
<ul><li>Nimble</li><li>Perceptive</li><li>Generous</li></ul>
*/