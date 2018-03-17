# Basics (p 121)
eng2sp = dict()
print eng2sp # {}
eng2sp['one'] = 'uno'
print eng2sp # {'one': 'uno'}

eng2sp = { # stored in a different order...
	'one':'uno',
	'two':'dos',
	'three':'tres'
}
print eng2sp # {'three': 'tres', 'two': 'dos', 'one': 'uno'}
print eng2sp['two'] # dos
try:
	print eng2sp['four'] 
except Exception as e:
	print "KeyError: " + str(e) # KeyError: 'four'
print len(eng2sp) # 3
print 'one' in eng2sp # True (matches the keys)
print 'uno' in eng2sp # False

vals = eng2sp.values()
print 'uno' in vals # True

# Dictionary as a Set of Counters: (p 123)
def histogram(s):
	d = dict()
	for c in s:
		if c not in d:
			d[c] = 1
		else:
			d[c] += 1
	return d
print histogram("apple") # {'a': 1, 'p': 2, 'e': 1, 'l': 1}
print histogram("favorite") # {'a': 1, 'e': 1, 'f': 1, 'i': 1, 'o': 1, 'r': 1, 't': 1, 'v': 1}

# Reverse Lookup
def reverse_lookup(d, v):
	for k in d:
		if d[k] == v:
			return k
	raise ValueError
h = histogram('parrot')
k = reverse_lookup(h, 2)
print k # r
try:
	k = reverse_lookup(h, 3)
except ValueError as e:
	print "ValueError"
# ValueError

# Dictionaries and Lists (p 126)
def invert_dict(d):
	inverse = dict()
	for key in d:
		val = d[key]
		if val not in inverse:
			inverse[val] = [key]
		else:
			inverse[val].append(key)
	return inverse
p = histogram('parrot')
print p # {'a': 1, 'p': 1, 'r': 2, 't': 1, 'o': 1}
print invert_dict(p) # {1: ['a', 'p', 't', 'o'], 2: ['r']}

# Lists cannot be keys
t = [1, 2, 3]
d = dict()
try:
	d[t] = 'oops'
except Exception as e:
	print e
# unhashable type: 'list'

# Memos (p 128)
known = {0:0, 1:1}
def fibonacci(n):
	if n in known:
		return known[n]
	res = fibonacci(n-1) + fibonacci(n-2)
	known[n] = res
	return res
print fibonacci(100)
# 3542248481792619150750

# Global Variables (p 129)

verbose = True
def example1():
	if verbose:
		print 'Running example1'
example1() # Running example1

been_called = False
def example2(): # assigning global variables does not work in a local scope
	been_called = True	# Wrong
example2()
print been_called # False

def example3():
	global been_called # used to assign to global variables
	been_called = True
example3()
print been_called # True

count = 0
def example3a():
	count = count+1
try:
	example3a()
except Exception as e:
	print e # local variable 'count' referenced before assignment

# >>> 1000*1000
# 1000000
# >>> 10000 * 10000
# 100000000
# >>> 100000 * 100000
# 10000000000L

print type (fibonacci(50)) # <type 'long'>
