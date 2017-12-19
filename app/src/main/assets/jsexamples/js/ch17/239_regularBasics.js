console.log("=== Regular Expressions (p 239)");
const re1 = /going/;
const re2 = new RegExp("going");

const input1 = "As I was going to Saint Ives";
const input2 = "Another sentence to search";
console.log(input1, re1, re1.test(input1), re2.test(input1));
console.log(input2, re2, re1.test(input2), re2.test(input2));

console.log("=== Searching with Regular Expressions");
const re3 = /\w{3,}/ig;
console.log(input1.match(re3), input1.search(re3), re3.test(input1));
let s = re3.exec(input1);
while (s != null) {
	console.log(s[0]);
	s = re3.exec(input1);
}
console.log("// note that any of these methods can be used directly with a regex literal");
console.log(input1.match(/\w{4,}/ig));
console.log(input1.search(/\w{4,}/ig));
console.log("=== Replacing with Regular Expressions (p 239)");
const out1 = input1.replace(/\w{4,}/ig, '****');
console.log(out1);
console.log("=== Alternation (p 242)");
const html = 'HTML with <a href="/one">one link</a>, and some Javascript.'+
	'<script src="stuff.js"></script>';
const matches1 = html.match(/area|a|link|script|source/ig);
console.log("1st attempt:", matches1);
const matches2 = html.match(/<area|<a|<link|<script|<source/ig);
console.log("2nd attempt:", matches2);
/*
=== Regular Expressions (p 239)
As I was going to Saint Ives /going/ true true
Another sentence to search /going/ false false
=== Searching with Regular Expressions
[ 'was', 'going', 'Saint', 'Ives' ] 5 true
going
Saint
Ives
// note that any of these methods can be used directly with a regex literal
[ 'going', 'Saint', 'Ives' ]
9
=== Replacing with Regular Expressions (p 239)
As I was **** to **** ****
=== Alternation (p 242)
1st attempt: [ 'a', 'link', 'a', 'a', 'a', 'a', 'script', 'script', 'script' ]
2nd attempt: [ '<a', '<script' ]
*/