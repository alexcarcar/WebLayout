console.log("----- for loops (p. 75)");

const player = {name: 'Alex', rank: 'Midshipman', age: 25};
for (let prop in player) {
	if (!player.hasOwnProperty(prop)) continue;
	console.log(prop + ": " + player[prop]);
}

function rand(m, n) {
	return m + Math.floor((n-m+1)*Math.random());
}

function randFace() {
	return ["crown", "anchor", "heart", "spade", "club", "diamond"][rand(0,5)];
}

const hand = [randFace(), randFace(), randFace()];
for (let face of hand) {
	console.log(`You rolled...${face}!`);
}

/*
----- for loops (p. 75)
name: Alex
rank: Midshipman
age: 25
You rolled...anchor!
You rolled...crown!
You rolled...spade!
 */