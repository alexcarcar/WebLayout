// return a random integer in the range [m, n] (inclusive)
function rand(m, n) {
	return m + Math.floor((n-m+1)*Math.random());
}

// randomly return a string representing one of the six
// Crown and Anchor faces
function randFace() {
	return ["crown", "anchor", "heart", "spade", "club", "diamond"][rand(0,5)];
}

let funds = 50; // starting conditions
let round = 0;

while(funds>1 && funds<100) {
	round++;
	console.log(`round ${round}:`)
	console.log(`\tstarting funds: ${funds}p`)
	// place bets
	let bets = {
		crown:0, anchor:0, heart:0, spade:0, club:0, diamond:0
	};
	let totalBet = rand(1, funds);
	if (totalBet === 7) {
		totalBet = funds;
		bets.heart = totalBet;
	} else {
		// distribute total bet
		let remaining = totalBet;
		do {
			let bet = rand(1, remaining);
			let face = randFace();
			bets[face] = bets[face] + bet;
			remaining = remaining - bet;
		} while(remaining > 0);
	}
	funds = funds - totalBet;
	console.log('\tbets: ' +
		Object.keys(bets).map(face => `${face}: ${bets[face]} pence`).join(', ') +
		` (total: ${totalBet} pence)`);

	// roll dice
	const hand = [];
	for (let roll = 0; roll < 3; roll++) {
		hand.push(randFace());
	}
	console.log(`\thand: ${hand.join(', ')}`);

	// collect winnings
	let winnings = 0;
	for (let die = 0; die < hand.length; die++) {
		let face = hand[die];
		if (bets[face] > 0) winnings = winnings + bets[face];
	}
	funds = funds + winnings;
	console.log(`\twinnings: ${winnings}`);
}
console.log(`\tending funds: ${funds}`);

/*
round 1:
	starting funds: 50p
	bets: crown: 0 pence, anchor: 5 pence, heart: 42 pence, spade: 0 pence, club: 0 pence, diamond: 0 pence (total: 47 pence)
	hand: heart, spade, club
	winnings: 42
round 2:
	starting funds: 45p
	bets: crown: 0 pence, anchor: 0 pence, heart: 0 pence, spade: 0 pence, club: 1 pence, diamond: 0 pence (total: 1 pence)
	hand: heart, anchor, diamond
	winnings: 0
round 3:
	starting funds: 44p
	bets: crown: 27 pence, anchor: 0 pence, heart: 0 pence, spade: 1 pence, club: 0 pence, diamond: 0 pence (total: 28 pence)
	hand: heart, anchor, club
	winnings: 0
round 4:
	starting funds: 16p
	bets: crown: 9 pence, anchor: 0 pence, heart: 0 pence, spade: 1 pence, club: 0 pence, diamond: 0 pence (total: 10 pence)
	hand: crown, anchor, heart
	winnings: 9
round 5:
	starting funds: 15p
	bets: crown: 1 pence, anchor: 0 pence, heart: 0 pence, spade: 0 pence, club: 0 pence, diamond: 0 pence (total: 1 pence)
	hand: club, diamond, club
	winnings: 0
round 6:
	starting funds: 14p
	bets: crown: 0 pence, anchor: 0 pence, heart: 14 pence, spade: 0 pence, club: 0 pence, diamond: 0 pence (total: 14 pence)
	hand: spade, diamond, club
	winnings: 0
	ending funds: 0

*/