// return a random integer in the range [m,n] inclusive
function rand(m, n) {
	return m + Math.floor((n-m+1)*Math.random());
}

// randomly returns one of the six crown and anchor faces
function randFace() {
	return ["crown", "anchor", "heart", "spade", "club", "diamond"][rand(0,5)];
}

let funds = 50; // starting conditions
let round = 0;

while (funds>1 && funds<100) {
	round++;
	console.log(`round ${round}:`);
	console.log(`\tstarting funds: ${funds}p`);
	// place bets
	let bets = {crown:0, anchor:0, heart:0, spade:0, club:0, diamond:0};
	let totalBet = rand(1, funds);
	if (totalBet === 7) {
		totalBet = funds;
		bets.heart = totalBet
	} else {
		// distribute total bet
		let remaining = totalBet;
		do {
			let bet = rand(1, remaining);
			let face = randFace();
			bets[face] += bet;
			remaining -= bet;
		} while(remaining > 0);
		funds -= totalBet;
		console.log('\tbets: ' + Object.keys(bets).map(face => `${face}: ${bets[face]} pence`).join(', ') + ` (total: ${totalBet} pence)`);

		// roll dice
		const hand = [];
		for (let roll=0; roll<3; roll++) {
			hand.push(randFace());
		}
		console.log(`\thand: ${hand.join(', ')}`);

		// collect winnings
		let winnings = 0;
		for (let die=0; die<hand.length; die++) {
			let face = hand[die];
			if(bets[face]>0) winnings += bets[face];
		}
		funds += winnings;
		console.log(`\twinnings: ${winnings}`);
	}
	console.log(`\tending funds: ${funds}`);
}

/*
round 1:
	starting funds: 50p
	bets: crown: 2 pence, anchor: 1 pence, heart: 3 pence, spade: 13 pence, club: 0 pence, diamond: 0 pence (total: 19 pence)
	hand: anchor, crown, heart
	winnings: 6
	ending funds: 37
round 2:
	starting funds: 37p
	bets: crown: 1 pence, anchor: 1 pence, heart: 0 pence, spade: 0 pence, club: 0 pence, diamond: 32 pence (total: 34 pence)
	hand: diamond, diamond, heart
	winnings: 64
	ending funds: 67
round 3:
	starting funds: 67p
	bets: crown: 40 pence, anchor: 4 pence, heart: 0 pence, spade: 0 pence, club: 0 pence, diamond: 6 pence (total: 50 pence)
	hand: spade, club, anchor
	winnings: 4
	ending funds: 21
round 4:
	starting funds: 21p
	bets: crown: 0 pence, anchor: 1 pence, heart: 1 pence, spade: 0 pence, club: 0 pence, diamond: 0 pence (total: 2 pence)
	hand: anchor, club, spade
	winnings: 1
	ending funds: 20
round 5:
	starting funds: 20p
	bets: crown: 0 pence, anchor: 6 pence, heart: 4 pence, spade: 0 pence, club: 0 pence, diamond: 0 pence (total: 10 pence)
	hand: spade, club, heart
	winnings: 4
	ending funds: 14
round 6:
	starting funds: 14p
	bets: crown: 0 pence, anchor: 0 pence, heart: 0 pence, spade: 1 pence, club: 0 pence, diamond: 4 pence (total: 5 pence)
	hand: diamond, crown, crown
	winnings: 4
	ending funds: 13
round 7:
	starting funds: 13p
	bets: crown: 0 pence, anchor: 2 pence, heart: 0 pence, spade: 0 pence, club: 0 pence, diamond: 11 pence (total: 13 pence)
	hand: anchor, anchor, spade
	winnings: 4
	ending funds: 4
round 8:
	starting funds: 4p
	bets: crown: 0 pence, anchor: 0 pence, heart: 0 pence, spade: 0 pence, club: 0 pence, diamond: 1 pence (total: 1 pence)
	hand: anchor, diamond, heart
	winnings: 1
	ending funds: 4
round 9:
	starting funds: 4p
	bets: crown: 0 pence, anchor: 0 pence, heart: 0 pence, spade: 3 pence, club: 1 pence, diamond: 0 pence (total: 4 pence)
	hand: diamond, club, crown
	winnings: 1
	ending funds: 1
*/