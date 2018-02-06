function plus(x,inc) {
	if (+x<Number.MAX_SAFE_INTEGER) {
		return +x+inc;
	} else {
		let s = "" + x;
		let n = s.length;
		let h = Math.floor(n/2);
		let a = s.substring(0,h);
		let b = s.substring(h,n);

		let b_len = b.length;
		let b_inc = "" + plus(+b,1);
		if (b_inc.length == b_len) {
			// no carrying needed
			return a + "" + b_inc;
		}
		let carry = b_inc.substring(0,1);
		b = b_inc.substring(1, b_len);
		a_inc = "" + plus(+a,carry);
		return a_inc + "" + b;
	}
}

function seq(a, n) { // sequence starting at a with length n
	let str = ""+a;
	let x = ""+a;
	while(str.length<n) {
		x=plus(x,1);
		str += "" +x;
	}
	return str;
}

function separateNumbers(s) {
	let str = "" + s;
	let n = str.length;
	if (n<=1) {
		console.log("NO");
		return;
	}
	if (str == seq(str[0],n)) {
		console.log("YES " + str[0]);
		return;
	}
	if (str[0] == "0" || n<=3) {
		console.log("NO");
		return;
	}
	let substr = "" + str[0];
	for (let i=1; i<n/2; i++) {
		substr += "" + str[i];
		let pattern = seq(substr,n);
		if (str == pattern) {
			console.log("YES " + substr);
			return;
		}
	}
	console.log("NO");
}

separateNumbers("99332720572758669933272057275867");
separateNumbers("99332720572758669933272057274867");
separateNumbers("93178437594967159317843759496716");
separateNumbers("93178437594967159317843759486716");
separateNumbers("22026106139335712202610613933572");
separateNumbers("22026106139335712202610613833572");
separateNumbers("63862140762791746386214076279175");
separateNumbers("63862140762791746386214075279175");
separateNumbers("8342840360736983428403607370");
/*
separateNumbers("90071992547409929007199254740993");
separateNumbers("12345");
separateNumbers("");
separateNumbers("91011");
separateNumbers("99100101");
separateNumbers("101103");
separateNumbers("010203");
separateNumbers("13");
separateNumbers("1");
*/