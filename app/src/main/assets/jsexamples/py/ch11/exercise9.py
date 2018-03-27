# Exercise 11-9: use dictionary to write a faster has_duplicates (exercise 10-8)

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

def has_faster_dup(t):
	d = dict()
	for x in t:
		if x in d: return True
		d[x] = 1
	return False	
print has_faster_dup([1, 2, 4, 1, 2]) # True
print has_faster_dup([4, 5, 3, 2, 1]) # False

