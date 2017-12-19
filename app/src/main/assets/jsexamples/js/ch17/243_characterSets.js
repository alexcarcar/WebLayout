console.log("=== Character Sets (p 243)");
const beer99 = "99 bottles of beer on the wall take 1 down and pass it around -- 98 bottles of beer on the wall.";
console.log(beer99);
const matches = beer99.match(/0|1|2|3|4|5|6|7|8|9/g);
console.log("tedious:", matches);
console.log("okay:", beer99.match(/[0123456789]/g));
console.log("better:", beer99.match(/[0-9]/g));
console.log("#'s and letters:", beer99.match(/[\-0-9a-z.]/ig).length, beer99.length);
console.log("Spaces:", beer99.match(/ /g).length);
console.log("Negated Set:", beer99.match(/[^\-0-9a-z.]/g).length);
console.log("=== Named Character Sets (p 244)");
const stuff =
	'high:       9\n' +
	'medium:     5\n' +
	'low:        2\n';
console.log(stuff.match(/:\s*[0-9]/g));
const messyPhone = '(505) 555-1515';
console.log(messyPhone, messyPhone.replace(/\D/g, ''));
const field = '   something   	';
console.log(field, /\S/.test(field));

/*
=== Character Sets (p 243)
99 bottles of beer on the wall take 1 down and pass it around -- 98 bottles of beer on the wall.
tedious: [ '9', '9', '1', '9', '8' ]
okay: [ '9', '9', '1', '9', '8' ]
better: [ '9', '9', '1', '9', '8' ]
#'s and letters: 75 96
Spaces: 21
Negated Set: 21
=== Named Character Sets (p 244)
[ ':       9', ':     5', ':        2' ]
(505) 555-1515 5055551515
   something     true
*/