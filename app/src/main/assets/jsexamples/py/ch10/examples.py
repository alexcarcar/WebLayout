# A List Is a Sequence (p 105)
tens = [10, 20, 30, 40]
ingredients = ['crunchy frog', 'ram bladder', 'lark vomit']
print tens, ingredients	# [10, 20, 30, 40] ['crunchy frog', 'ram bladder', 'lark vomit']

nested = ['spam', 2.0, 5, [10, 20]]
print nested # ['spam', 2.0, 5, [10, 20]]

cheeses = ['Cheddar', 'Edam', 'Gouda']
numbers = [17, 123]
empty = []
print cheeses, numbers, empty # ['Cheddar', 'Edam', 'Gouda'] [17, 123] []

# Lists are Mutable (p 106)
print cheeses[0] # Cheddar
print numbers # [17, 123]
numbers[1] = 5
print numbers # [17, 5]
print 'Edam' in cheeses, 'Brie' in cheeses # True False

# Traversing a List (p 107)
for cheese in cheeses:
	print cheese,
print "" # Cheddar Edam Gouda

print numbers # [17, 5]
for i in range(len(numbers)):
	numbers[i] = numbers[i] * 2
print numbers # [34, 10]

for x in []:
	print 'This never happens.'
print len(['spam', 1, ['Brie', 'Roquefort', 'Pol le Veq'], [1,2,3]]) # 4

# List Operations (p 107)
a = [1, 2, 3]
b = [4, 5, 6]
c = a + b
print c 			# [1, 2, 3, 4, 5, 6]
print [0]*4 		# [0, 0, 0, 0]
print [1,2,3]*3 	# [1, 2, 3, 1, 2, 3, 1, 2, 3]

# List Slices (p 108)
t = ['a', 'b', 'c', 'd', 'e', 'f']
print t[1:3]		# ['b', 'c']
print t[:4]			# ['a', 'b', 'c', 'd']
print t[3:]			# ['d', 'e', 'f']
print t[::-1]		# ['f', 'e', 'd', 'c', 'b', 'a']
s = t[:] 			# Makes a copy of t
s[1:3] = ['x', 'y']
print t, s 			# ['a', 'b', 'c', 'd', 'e', 'f'] ['a', 'x', 'y', 'd', 'e', 'f']
s[1:3] = []
print s 			# ['a', 'd', 'e', 'f']

# List Methods (p 108)
t = ['a', 'b', 'c']
t.append('d')
print t 			# ['a', 'b', 'c', 'd']
t1 = ['a', 'b', 'c']
t2 = ['d', 'e']
t1.extend(t2)
print t1			# ['a', 'b', 'c', 'd', 'e']
t = ['d', 'c', 'e', 'b', 'a']
t.sort()
print t
# ['a', 'b', 'c', 'd', 'e']
t = t.sort()
print t # None

# Map, Filter, and Reduce (p 109)
def add_all(t):
	total = 0
	for x in t:
		total += x
	return total
print sum([1,2,3]), add_all([1,2,3])		# 6 6

# Deleting Elements (p 111)
t = ['a', 'b', 'c']
x = t.pop(1)
print x, t # b ['a', 'c']

t = ['a', 'b', 'c']
del t[1]
print t # ['a', 'c']

t = ['a', 'b', 'c', 'b']
t.remove('b')
print t # ['a', 'c', 'b']
t.remove('b')
print t # ['a', 'c']

t = [1,2,3,4,5,6]
del t[1:5]
print t # [1, 6]

# Lists and Strings (p 112)
s = 'spam'
t = list(s)
print t # ['s', 'p', 'a', 'm']

s = 'three little bears'
t = s.split()
print t # ['three', 'little', 'bears']

s = 'spam-spam-spam'
t = s.split('-')
print t # ['spam', 'spam', 'spam']
print ' '.join(t), '*'.join(t) # spam spam spam spam*spam*spam
print ''.join(t) # spamspamspam 

# Objects and Values (p 112)
a = 'banana'
b = 'banana'
print a is b # True

a = [1,2,3]
b = [1,2,3]
print a is b # False

# Aliasing (p 114)
a = [1,2,3]
b = a
print a is b # True
b[0] = 17
print a # [17, 2, 3]

# List Arguments (p 114)
def delete_head(t):
	del t[0]
letters = ['a', 'b', 'c']
delete_head(letters)
print letters # ['b', 'c']

t1 = [1,2]
t2 = t1.append(3)
print t1, t2 # [1, 2, 3] None

t3 = t1 + [4]
print t1, t3 # [1, 2, 3] [1, 2, 3, 4]

def tail(t):
	return t[1:]
letters = ['a', 'b', 'c']
rest = tail(letters)
print rest, letters # ['b', 'c'] ['a', 'b', 'c']

t = ['d', 'a', 'c']
print sorted(t), t # ['a', 'c', 'd'] ['d', 'a', 'c']
