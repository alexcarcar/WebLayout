// return a random integer in the range [m,n] (inclusive)
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
		
	}
}