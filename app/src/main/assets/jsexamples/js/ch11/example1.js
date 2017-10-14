$(document).ready(function() {
	'use strict';
	const log = console.log;
	const err = new Error('invalid email');

	function validateEmail(email) {
		return email.match(/@/) ?
			email :
			new Error(`invalid email: ${email}`);
	}
	
	const email = "jane@doe.com";
	//const email = null;
	try {
		const validatedEmail = validateEmail(email);
		if(validatedEmail instanceof Error) {
			console.error(`Error: ${validatedEmail.message}`);
		} else {
			log(`Valid email: ${validatedEmail}`);
		}
	} catch(err) {
		console.error(`Error: ${err.message}`);
	}
	log("continue");
	log("---------------------------------");

	function billPay(amount, payee, account) {
		if(amount > account.balance) {
			throw new Error("insufficient funds");
		}
		account.transfer(payee, amount);
	}
	log("---------------------------------");
	function a() {
		log('a: calling b');
		b();
		log('a: done');
	}
	function b() {
		log('b: calling c');
		c();
		log('b: done');
	}
	function c() {
		log('c: throwing error');
		throw new Error('c error');
		log('c: done');
	}
	function d() {
		log('d: calling c');
		c();
		log('d: done');
	}
	try {
		a();
	} catch(err) {
		console.log(err.stack);
	}

	try {
		d();
	} catch(err) {
		console.log(err.stack);
	}
	log("---------------------------------");
	try {
		log("this line is executed...");
		throw new Error("whoops");
		log("this line is not");
	} catch(err) {
		log("there was an error...");
	} finally {
		log("...always executed");
		log("perform cleanup here");
	}


	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");

});