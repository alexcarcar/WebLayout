console.log("=== Repetition (p 245)");
const beer99 = "99 bottles of beer on the wall take 1 down and pass it around -- 98 bottles of beer on the wall.";
console.log(beer99.match(/\d\d\d|\d\d|\d/g)); // order matters (most specific to least specific)
console.log(beer99.match(/\d+/g));

console.log("=== Period Metacharacter and Escaping (p 246)");
const address1 = "Address: 333 Main St., Anywhere, NY, 55532. Phone: 555-555-2525.";
console.log(address1.match(/\d{5}.*/)[0]);
console.log(address1.match(/\d{5}/)[0]);
const equation = "(2 + 3.5) * 7";
console.log(equation.match(/\(\d \+ \d\.\d\) \* \d/)[0]);

console.log("=== Grouping (p 247)");
const title1 = "Visit oreilly.com today!";
console.log(title1.match(/[a-z]+(?:\.com|\.org|\.edu)/i)[0]);
const html1 = '<link rel="stylesheet" href="http://insecure.com/stuff.css">\n' +
'<link rel="stylesheet" href="https://secure.com/securestuff.css">\n' +
'<link rel="stylesheet" href="//anything.com/flexible.css">';
console.log(html1.match(/(?:https?)?\/\/[a-z][a-z0-9]+[a-z0-9]+/ig))

console.log("=== Lazy Matches, Greedy Matches (p 248)");
const greedy = "Regex pros know the difference between\n" +
	"<i>greedy</i> and <i>lazy</i> matching.";
console.log(greedy.replace(/<i>(.*)<\/i>/ig, '<strong>$1</strong>'));
console.log(greedy.replace(/<i>(.*?)<\/i>/ig, '<strong>$1</strong>'));

console.log("=== Backreferences (p 249)");
const promo = "Opening for XAAX is the dynamic GOOG! At the box office now!";
console.log(promo.match(/(?:[A-Z]){4}/g));
const html2 = `<img alt='A "simple" example.'><img alt="Don't abuse it!">`;
console.log(html2.match(/<img alt=(?:['"]).*?/g));

console.log("=== Replacing Groups (p 250)");
const nop = '<a class="nope" href="/yep">Yep</a>';
console.log(nop.replace(/<a .*?(href=".*?").*>/, '<a $1>'));
const yep = '<a class="yep" href="/yep" id="nope">Yep</a>';
console.log(yep.replace(/<a .*?(class=".*?").*?(href=".*?").*>/, '<a $2 $1>'));
const in123 = "One two three";
console.log(in123.replace(/two/,'($`)')); // replace with everything before: "One (One ) three"
console.log(in123.replace(/\w+/g,'($&)')); // replace with result: "(One) (two) (three)"
console.log(in123.replace(/two/, "($')")); // replace with everything after: "One ( three) three"
console.log(in123.replace(/two/, "($$)")); // used to specify a literal $: "One ($) three"

console.log("=== Function Replacements (p 251)");
const html3 =
	`<a class="foo" href="/foo" id="foo">Foo</a>\n`+
	`<A href='/foo' Class="foo">Foo</a>\n` +
	`<a onclick="javascript:alert('foo!')" href="/foo">Foo</a>`;
function sanitizeATag(aTag) {
	const parts = aTag.match(/<a\s+(.*?)>(.*?)<\/a>/i);
	const attributes = parts[1].split(/\s+/);
	return '<a ' + attributes.filter(attr => /^(?:class|id|href)[\s=]/i.test(attr)).join(' ')+'>'+parts[2]+'</a>';
}
console.log(html3.replace(/<a .*?<\/a>/ig, sanitizeATag));

console.log("=== Anchoring (p 253)");
const anchorInput = "It was the best of times, it was the worst of times";
console.log(anchorInput.match(/^\w+/g)); // beginning word: "It"
console.log(anchorInput.match(/\w+$/g)); // ending word: "times"
console.log(anchorInput.match(/^.*$/g)); // everything
console.log(anchorInput.match(/^best/ig)); // no match
console.log(anchorInput.match(/worst$/ig)); // no match
console.log(anchorInput.match(/times$/ig)); // "times"
const multiline = "One line\nTwo lines\nThree lines\nFour";
console.log(multiline.match(/^\w+/mg)); // "One", "Two", "Three", "Four"
console.log(multiline.match(/\w+$/mg)); // "line", "lines", "lines", "Four"

console.log("=== Word Boundary Matches (p 253)");
const emails = [ "john@doe.com", "john@doe.com is my email", "my email is john@doe.com", "use john@doe.com", "my email:john@doe.com."];
const emailMatcher = /\b[a-z][a-z0-9._-]*@[a-z][a-z0-9_-]+\.[a-z]+(?:\.[a-z]+)?\b/ig;
console.log(emails.map(s => s.replace(emailMatcher, '<a href="mailto:$&">$&</a>')));

console.log("=== Lookaheads (p 254)");
function validPassword(p) {
	return /(?=.*[A-Z])(?=.*[0-9])(?=.[a-z])(?!.*[a-zA-Z0-9])/.test(p);
}
console.log(validPassword("Apple123"));

console.log("=== Dynamic Construction (p 256)");
const users = ["mary", "nick", "arthur", "sam", "yvette"];
const text = "User @arthur started the backup at 15:15, " +
	"and @nick and @yvette restored it at 18:35.";
const userRegex = new RegExp(`@(?:${users.join('|')})\\b`, 'g');
console.log(text.match(userRegex));
/*
=== Repetition (p 245)
[ '99', '1', '98' ]
[ '99', '1', '98' ]
=== Period Metacharacter and Escaping (p 246)
55532. Phone: 555-555-2525.
55532
(2 + 3.5) * 7
=== Grouping (p 247)
oreilly.com
[ '//insecure', '//secure', '//anything' ]
=== Lazy Matches, Greedy Matches (p 248)
Regex pros know the difference between
<strong>greedy</i> and <i>lazy</strong> matching.
Regex pros know the difference between
<strong>greedy</strong> and <strong>lazy</strong> matching.
=== Backreferences (p 249)
[ 'XAAX', 'GOOG' ]
[ '<img alt=\'', '<img alt="' ]
=== Replacing Groups (p 250)
<a href="/yep">
<a href="/yep" class="yep">
One (One ) three
(One) (two) (three)
One ( three) three
One ($) three
=== Function Replacements (p 251)
<a class="foo" href="/foo" id="foo">Foo</a>
<a href='/foo' Class="foo">Foo</a>
<a href="/foo">Foo</a>
=== Anchoring (p 253)
[ 'It' ]
[ 'times' ]
[ 'It was the best of times, it was the worst of times' ]
null
null
[ 'times' ]
[ 'One', 'Two', 'Three', 'Four' ]
[ 'line', 'lines', 'lines', 'Four' ]
=== Word Boundary Matches (p 253)
[ '<a href="mailto:john@doe.com">john@doe.com</a>',
  '<a href="mailto:john@doe.com">john@doe.com</a> is my email',
  'my email is <a href="mailto:john@doe.com">john@doe.com</a>',
  'use <a href="mailto:john@doe.com">john@doe.com</a>',
  'my email:<a href="mailto:john@doe.com">john@doe.com</a>.' ]
=== Lookaheads (p 254)
false
=== Dynamic Construction (p 256)
[ '@arthur', '@nick', '@yvette' ]
*/