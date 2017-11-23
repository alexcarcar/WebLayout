console.log("=== The Error Object (p 169)");
function emailError(email) {
	return new Error(`Invalid email: ${email}`);
}

function validateEmail(email) {
	return email.match(/@/) ? email : emailError(email);
}

const emailGood = "jane@doe.com";
const emailBad = "johndoedoe.com";
const emails = [emailGood, emailBad];

for (let email of emails) {
	let validatedEmail = validateEmail(email);
	if (validatedEmail instanceof Error) {
		console.error(`Error: ${validatedEmail.message}`);
	} else {
		console.log(`Valid email: ${validatedEmail}`);
	}
}

console.log("\n=== Exception Handling with try and catch (p 170)");
emails.push(null); // create an invalid email => null ... whoops
emails.push("anchor@abc.com");
console.log(emails);
for (let email of emails) {
	try {
		let validatedEmail = validateEmail(email);
		if (validatedEmail instanceof Error) { // handling anticipated errors (email without @)
			console.error(`Error: ${validatedEmail.message}`);
		} else {
			console.log(`Valid email: ${validatedEmail}`);
		}
	} catch(err) { // handling unanticipated errors (email==null)
		console.error(`Error: ${err.message}`);
	}
}

console.log("\n=== Throwing errors");
const account = {balance: 500};
function pay(amount, payee, account) {
	if (amount>account.balance) {
		throw new Error(`insufficient funds: ${amount} > ${account.balance}`);
	} else {
		account.balance -= amount;
		console.log(`new balance: ${account.balance}, ${payee} => ${amount}`);
	}
}
try {
	console.log(account);
	pay(10, "John", account);
	pay(30, "Alice", account);
	pay(40, "John", account);
	pay(4000, "Alice", account);
} catch(err) {
	console.error(`Error: ${err.message}.`);
	console.log(account);
}
/*
=== The Error Object (p 169)
Valid email: jane@doe.com
Error: Invalid email: johndoedoe.com

=== Exception Handling with try and catch (p 170)
[ 'jane@doe.com', 'johndoedoe.com', null, 'anchor@abc.com' ]
Valid email: jane@doe.com
Error: Invalid email: johndoedoe.com
Error: Cannot read property 'match' of null
Valid email: anchor@abc.com

=== Throwing errors
{ balance: 500 }
new balance: 490, John => 10
new balance: 460, Alice => 30
new balance: 420, John => 40
Error: insufficient funds: 4000 > 420.
{ balance: 420 }
*/