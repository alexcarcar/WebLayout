# Exercise 13-5
# Write a function named choose_from_hist that takes a histogram and returns a random value,
# chosen with probability in proportion to frequency.

import random

def choose_from_hist(h):
	t = []
	for x in h:
		for i in range(h[x]):
			t.append(x)
	print random.choice(t)

def histogram(s):
	d = dict()
	for c in s:
		if c not in d:
			d[c] = 1
		else:
			d[c] += 1
	return d

t = ['a', 'a', 'b']
hist = histogram(t)
print hist

choose_from_hist(hist)