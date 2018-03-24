import random

# Exercise 12-1
print max(1,2,3) # 3
try:sum(1,2,3)
except Exception as e:print e
# sum expected at most 2 arguments, got 3

def sumall(*x): # gathers all the variables into one tuple x
	return sum(x) # sum takes one gathered tuple
print sumall(1,2,3) # 6

# Exercise 12-2
def sort_by_length(words):
	t = []
	for word in words:
		t.append((len(word), word)) # Decorate
	t.sort(reverse=True) # Sort
	res = []
	for length, word in t:
		res.append(word) # Undecorate
	return res
print sort_by_length(['Alex', 'Carol', 'Simon', 'George'])
# ['George', 'Simon', 'Carol', 'Alex']

def unstable_sort(words):
	t = []
	for word in words:
		t.append((len(word)+random.random(), word)) # Decorate
	t.sort(reverse=True) # Sort
	print t
	res = []
	for length, word in t:
		res.append(word) # Undecorate
	return res
print unstable_sort(['Alex', 'Carol', 'Simon', 'George'])
#[(6.708808641236251, 'George'),
# (5.983306535405309, 'Carol'),
# (5.483431226071642, 'Simon'),
# (4.879200101416522, 'Alex')]
# ['George', 'Carol', 'Simon', 'Alex']

# Exercise 12-3: most_frequent (prints a string in decreasing frequency)
def most_frequent(word):
	d = dict()
	for c in word:
		d[c] = d.get(c,0) + 1
	s = d.items()
	t = []
	for x,y in s:
		t.append((y,x)) # Decorate
	t.sort(reverse=True) # Sort
	res = []
	for x in t:
		print res.append(x[1])
	return res
print most_frequent("apple") # ['p', 'l', 'e', 'a']