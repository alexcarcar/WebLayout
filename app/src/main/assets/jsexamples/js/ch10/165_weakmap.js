console.log("=== Application of WeakMaps (p 164)");

// IIFE -- Immediately Invoked Function Expression
const SecretHolder = (function() {
	const secrets = new WeakMap();
	return class {
		setSecret(secret) {
			secrets.set(this, secret);
		}
		getSecret() {
			return secrets.get(this);
		}
	}
})();

const a = new SecretHolder();
const b = new SecretHolder();
a.setSecret('secret A');
b.setSecret('secret B');
console.log(a.getSecret(), b.getSecret());
/*
=== Application of WeakMaps (p 164)
secret A secret B
*/