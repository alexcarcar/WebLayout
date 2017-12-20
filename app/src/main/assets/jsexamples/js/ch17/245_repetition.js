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
