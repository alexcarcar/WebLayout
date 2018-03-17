def histogram(s):
	d = dict()
	for c in s:
		if c not in d:
			d[c] = 1
		else:
			d[c] += 1
	return d

def print_hist(h):
	for c in h:
		print c, h[c]


# ===============================================================================
# Exercise 11-1 (p 122)
words = dict()
fin = open('../ch9/words.txt')
for line in fin:
        words[line.strip()] = ""
fin.close()
print "apple" in words	# True
print "abple" in words	# False

# ===============================================================================
# Exercise 11-2: using get and default values (p 122)
h = histogram('a')
print h
print h.get('a', 0) # 1
print h.get('b', 0) # 0

def histogram_concise(s):
	d = dict()
	for c in s:
		d[c] = d.get(c, 0) + 1
	return d
print histogram_concise('happy') # {'a': 1, 'h': 1, 'y': 1, 'p': 2}

# ===============================================================================
# Looping and Dictionaries
# Exercise 11-3 (p 124)

g = histogram("george")
print_hist(g)
# r 1
# e 2
# o 1
# g 2
print "--"
def print_sort_hist(h):
	sortedKeys = sorted(h.keys())
	for k in sortedKeys:
		print k, h[k]
print_sort_hist(g)
# e 2
# g 2
# o 1
# r 1

# ===============================================================================
# Exercise 11-4 (p 126)

def reverse_lookup(d, v):
	t = []
	for k in d:
		if d[k] == v:
			t.append(k)
	return t
h = histogram('parrot')
print reverse_lookup(h, 2) # ['r']
print reverse_lookup(h, 1) # ['a', 'p', 't', 'o']
print reverse_lookup(h, 3) # []

# ===============================================================================
# Exercise 11-5 (p 127)

def invert_dict(d):
	inverse = dict()
	for key in d:
		val = d[key]
		inverse[val] = [key] + inverse.setdefault(val, [])
	return inverse
p = histogram('parrot')
print invert_dict(p) # {1: ['o', 't', 'p', 'a'], 2: ['r']}
	