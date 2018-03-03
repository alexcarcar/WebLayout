# Exercise 10-1 (p 110) --> reduce example
def nested_sum(nests):
	total = 0
	for nest in nests:
		total += sum(nest)
	return total

print nested_sum([[1,2,3], [4], [5, 6]]) # 21

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