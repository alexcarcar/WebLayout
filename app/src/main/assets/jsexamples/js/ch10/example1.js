$(document).ready(function() {
	'use strict';
	const log = console.log;
	log("---------------------------------");
	const u1 = {name: 'Simon'};
	const u2 = {name: 'George'};
	const u3 = {name: 'Carol'};
	const u4 = {name: 'Alex'};

	const userRoles = new Map();
	userRoles.set(u1, 'User');
	userRoles.set(u2, 'User');
	userRoles.set(u3, 'Admin');

	/*
	const userRoles2 = new Map();
	userRoles2
		.set(u1, 'User')
		.set(u1, 'User')
		.set(u1, 'Admin');

	const userRoles3 = new Map([
			[u1, 'User'],
			[u2, 'User'],
			[u3, 'Admin']
		]);
	*/
	log(userRoles.get(u1));
	log(userRoles.has(u1));
	userRoles.set(u2, 'Admin');
	log(userRoles.get(u2));
	log(userRoles.size);

	for(let u of userRoles.keys()) log(u.name);
	for(let r of userRoles.values()) log(r)
	for(let ur of userRoles.entries())
		log(`${ur[0].name}: ${ur[1]}`);

	log("---------------------------------");
	for(let [u,r] of userRoles.entries())
		console.log(`${u.name}: ${r}`);
	for(let [u,r] of userRoles)
		console.log(`${u.name}: ${r}`);
	log([...userRoles.values()]);
	userRoles.delete(u2);
	log(userRoles.size);
	userRoles.clear();
	log(userRoles.size)
	log("---------------------------------");
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
	log(a.getSecret());
	log(b.getSecret());
	log("---------------------------------");
	const roles = new Set();
	roles.add("User");
	roles.add("Admin");
	log(roles.size);
	log(roles);
	roles.add("User");
	log(roles);
	log(roles.delete("Admin"));
	log(roles);
	log(roles.delete("Admin"));
	log("---------------------------------");
	const naughty = new WeakSet();
	const children = [
		{name: "Simon"},
		{name: "George"}
	];
	naughty.add(children[1]);
	for(let child of children) {
		if(naughty.has(child)) {
			log(`Coal for ${child.name}!`);
		} else {
			log(`Presents for ${child.name}!`);
		}
	}
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");
	log("---------------------------------");

});