# Exercise 10-1 (p 110) --> reduce example
def nested_sum(nests):
	total = 0
	for nest in nests:
		total += sum(nest)
	return total

print nested_sum([[1,2,3], [4], [5, 6]])
# 21

def capitalize_all(t):
	res = []
	for s in t:
		res.append(s.capitalize())
	return res

print capitalize_all(["alex", "george", "simon", "carol"]) # ['Alex', 'George', 'Simon', 'Carol']

# Exercise 10-2 (p 110) --> map example
def capitalized_nested(nests):
	res = []
	for nest in nests:
		res += capitalize_all(nest)
	return res
print capitalized_nested([["alex", "carol"], ["george", "simon"]]) # ['Alex', 'Carol', 'George', 'Simon']

def only_upper(t): # --> filter example
	res = []
	for s in t:
		if s.isupper():
			res.append(s)
	return res
print only_upper(["ALEX", "carol", "GEORGE", "simon"]) # ['ALEX', 'GEORGE']

def vector_sum(a,b):
	res = []
	if not len(a) == len(b):
		print "vectors are not the same size"
		return None
	for i in range(len(a)):
		res.append(a[i] + b[i])
	return res

vector_sum([12,3],[3]) # vectors are not the same size
print vector_sum([4,3,7],[3,9,3]) # [7, 12, 10]

# Exercise 10-3 (p 110)
def cumulative_sum(t): # --> map example
	res = []
	sum = 0
	for s in t:
		sum += s
		res.append(sum)
	return res
print cumulative_sum([1,2,3]) # [1, 3, 6]

# Exercise 10-4 (p 111)
def middle(t): # returns everything except the first and last elements in a list
	l = len(t)
	if l<3: return []
	return t[1:l-1]
print middle([1,2])
print middle([1,2,3])
print middle([1,2,3,4,5,6])
# []
# [2]
# [2, 3, 4, 5]

# Exercise 10-5 (p 111)
def chop(t): # removes the first and last elements in a list, and returns none
	t[:] = middle(t)
	return None
t = ['a', 'b', 'c', 'd']
print chop(t)
print t
# None
# ['b', 'c']

# Exercise 10-6 (p 118)
def is_sorted(t):
	first = True
	last = ""
	for x in t:
		if first:
			first = False
		elif x < last:
			return False
		last = x
	return True
print is_sorted([1, 2, 2]) # True
print is_sorted(['b', 'a']) # False
print is_sorted([]) # True
print is_sorted([1]) # True

# Exercise 10-7 (p 118)
def is_anagram(w1, w2):
	if not len(w1) == len(w2):
		return False
	word1 = list(w1)
	word1.sort()
	word1 = ''.join(word1)

	word2 = list(w2)
	word2.sort()
	word2 = ''.join(word2)
	return word1 == word2
print is_anagram("apple", "leapp") # True
print is_anagram("bat", "tab") # True
print is_anagram("bus", "sub") # True
print is_anagram("ask", "nop") # False

# Exercise 10-8.1 (p 118)
def has_duplicates(t):
	s = sorted(t)
	first = True
	last = ""
	for x in s:
		if first:
			first = False
		elif x == last:
			return True
		last = x
	return False
print has_duplicates([1, 2, 4, 1, 2]) # True
print has_duplicates([4, 5, 3, 2, 1]) # False

# Exercise 10-8.2 (p 118)
import random
birthdays = []
for i in range(23):
	birthdays.append(random.randint(1, 365))
print birthdays
print "has duplicates? " + str(has_duplicates(birthdays))

#[185, 181, 248, 83, 172, 74, 176, 131, 83, 191, 29, 304, 313, 250, 337, 254, 298
#, 86, 27, 359, 218, 263, 285]
#has duplicates? True

# Exercise 10-9 (p 118)
def remove_duplicates(t):
	s = sorted(t)
	newT = []
	first = True
	last = ""
	for x in s:
		if first:
			first = False
		elif x == last:
			continue
		last = x
		newT.append(x)
	return newT
print remove_duplicates([1, 2, 4, 1, 2]) # [1, 2, 4]
