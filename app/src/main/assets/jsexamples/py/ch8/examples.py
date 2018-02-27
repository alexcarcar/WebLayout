# A String Is a Sequence (p 85)
fruit = 'banana'
letter = fruit[1]
print letter			# a
letter = fruit[0]
print letter			# b
#letter = fruit[1.5]	# TypeError: string indices must be integers, not float
print len(fruit)		# 6
length = len(fruit)
#last = fruit[length]	# IndexError: string index out of range
last = fruit[length-1]
print last				# a

# Traversal with a for Loop (p 86)
index = 0
while index < len(fruit):
	letter = fruit[index]
	print letter,
	index = index + 1
print ""				# b a n a n a

# Exercise 8-1: display letters backward
index = len(fruit)
while index > 0:
	index = index - 1
	letter = fruit[index]
	print letter,
print ""				# a n a n a b

for char in fruit:
	print char,
print ""				# b a n a n a

prefixes = 'JKLMNOPQ'
suffix = 'ack'
for letter in prefixes:
	print letter+suffix,
print ""				# Jack Kack Lack Mack Nack Oack Pack Qack

# Excercise 8-2: add u to "Oack" and "Qack"
prefixes = 'JKLMNOPQ'
for letter in prefixes:
	if letter=='O' or letter=='Q':
		letter = letter + 'u'
	print letter+suffix,
print ""				# Jack Kack Lack Mack Nack Ouack Pack Quack

# String Slices (p 87)
# => 0123456789abc
s = 'Monty-Python'
print s[0:5]			# Monty
print s[6:12]			# Python

fruit = 'banana'
print fruit[:3],fruit[3:]		# ban ana
print "'"+ fruit[3:3] + "'"		# ''

# Exercise 8-3: what does fruit[:] mean?
print fruit[:]			# banana

# Strings Are Immutable (p 88)
greeting = 'Hello, world!'
# greeting[0] = 'J'				# TypeError: 'str' object does not support item assignment
greeting = 'J' + greeting[1:]
print greeting					# Jello, world!

# Searching (p 89)
def find(word, letter):
	index = 0
	while index < len(word):
		if word[index] == letter:
			return index
		index = index + 1
	return -1
word = "Simon"
print find(word, "i"), find(word,"n"), find(word, "z")	# 1 4 -1

# Exercise 8-4: modify find to take start index
def findAt(word, letter, at):
	index = at
	while index < len(word):
		if word[index] == letter:
			return index
		index = index + 1
	return -1
print findAt(word,"i",3), findAt(word,"n",3), findAt(word,"z",3)	# -1 4 -1

# Looping and Counting (p 89)
word = 'banana'
count = 0
for letter in word:
	if letter == 'a':
		count = count + 1
print count 				# 3

# Exercise 8-5: Encapsulate this code in a function named "count"
def count(word, l):
	count = 0
	for letter in word:
		if letter == l:
			count = count + 1
	return count
print count('banana', 'a')		# 3
print count('banana', 'n')		# 2
print count('banana', 'b')		# 1
print count('banana', 'z')		# 0

# Exercise 8-6: Use findAt to rewrite count
def countAt(word, l):
	count = 0
	index = 0
	while not index == -1:
		index = findAt(word, l, index)
		if not index == -1:
			count = count + 1
			index = index + 1
	return count
print countAt('banana', 'a')		# 3
print countAt('banana', 'n')		# 2
print countAt('banana', 'b')		# 1
print countAt('banana', 'z')		# 0

# String Methods (p 90)
word = 'banana'
new_word = word.upper()
print new_word				# BANANA
print word.find('a')		# 1
print word.find('na')		# 2
print word.find('na',3)		# 4
name = 'bob'
print name.find('b',1,2)	# -1

# Exercise 8-7: Use word.count() to count number of 'a's
print word.count('a')		# 3
print word.count('na')		# 2

# Exercise 8-8: Use word.strip() and word.replace()
word = 'alex--'
word = word.strip('-')
print word 					# alex
word = word.replace("x","x the great")	
print word 					# alex the great

# The in Operator (p 91)
print 'a' in 'banana'		# True
print 'seed' in 'banana'	# False

def in_both(word1, word2):
	for letter in word1:
		if letter in word2:
			print letter,
	print ""		
in_both('apples', 'oranges') # a e s

# String Comparison (p 92)
def string_compare(word1, word2):
	if word1 < word2:
		print 'Your word, ' + word1 + ', comes before ' + word2
	elif word1 > word2:
		print 'Your word, ' + word1 + ', comes after ' + word2
	else:
		print 'All right, ' + word2 + '.'
string_compare('apple', 'banana')		# Your word, apple, comes before banana
string_compare('carrot', 'banana')		# Your word, carrot, comes after banana
string_compare('banana', 'banana')		# All right, banana.

# Debugging (p 92)
def is_reverse(word1, word2):
	if len(word1) != len(word2):
		return False
	i = 0
	j = len(word2)-1
	while j>0:
		print i,j
		if word1[i] != word2[j]:
			return False
		i = i+1
		j = j-1
	return True

print is_reverse('pots', 'stop')
# 0 3
# 1 2
# 2 1
# True