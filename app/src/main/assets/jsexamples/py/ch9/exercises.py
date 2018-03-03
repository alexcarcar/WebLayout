# Exercise 9-1: count words more than 20 characters
fin = open('words.txt')
for line in fin:
	word = line.strip()
	if len(word)>20:
		print word
fin.close()
# counterdemonstrations
# hyperaggressivenesses
# microminiaturizations

# Exercise 9-2: determine if a word has an "e"
def has_no_e(word):
	for c in word:
		if c=='e' or c=='E':
			return False
	return True
print has_no_e('apple'), has_no_e('Elf'), has_no_e('fat')	# False False True

def word_with_no_e(word):
	if has_no_e(word):
		return word
	return ""
print word_with_no_e('apple'), word_with_no_e('Elf'), word_with_no_e('fat') #  fat

fin = open('words.txt')
count = 0
total = 0
for line in fin:
	total = total + 1
	word = line.strip()
	if has_no_e(word):
		count = count + 1
fin.close()
print "words without e:", count 
print "total words:", total
print float(count)/float(total)*100, "%"
# words without e: 37641
# total words: 113809
# 33.073834231 %

# Exercise 9-3: avoid letters in a string
def avoids(word, forbidden):
	for c in word:
		if c in forbidden:
			return False
	return True
print avoids("apple", "abc")		# False
print avoids("apple", "ghi")		# True

# Exercise 9-4: words with only certain letters
def uses_only(word, uses):
	for c in word:
		if not c in uses:
			return False
	return True
print uses_only("apple", "apf")		# False
print uses_only("apple", "apl")		# False
print uses_only("apple", "aple")	# True

# Exercise 9-5: words with all certain letters
def uses_all(word, uses):
	return uses_only(word, uses) and uses_only(uses, word)
print uses_all("apple", "ap")		# False
print uses_all("apple", "aple")		# True

# Exercise 9-6: letters in a word in alphabetical order
def is_abecedarian(word):
	word = word.lower()
	previous = word[0]
	for c in word:
		if c < previous:
			return False
	return True
print is_abecedarian("Abc")			# True
print is_abecedarian("cat")			# False

# Exercise 9-7: k consecutive repetitions
def consecutive_repetitions(word):
	firstLetter = True
	consecutive = False
	repetition = False
	max = 0
	m = 0
	for c in word:
		if firstLetter:
			previous = c
			firstLetter = False
			continue
		if c == previous:
			if not consecutive:
				consecutive = True
			consecutive = True
		else:
			if consecutive:
				m = m + 1
			else:
				if m > max:
					max = m
				m = 0
			consecutive = False
		previous = c
	if consecutive:
		m = m + 1
	if m > max:
		max = m
	return max

word = "aapplleeddd"
print word, consecutive_repetitions(word)			# 5

fin = open('words.txt')
for line in fin:
	word = line.strip()
	if consecutive_repetitions(word) >= 3:
		print word
fin.close()
# bookkeeper
# bookkeepers
# bookkeeping
# bookkeepings

# Exercise 9-8
# Find some mileage x, so that (starting at 300000)
# 1. x      last 4 digits is a palendrone
# 2. x+1    last 5 digits is a palendrone
# 3. x+2    middle 4 digits is a palendrone
# 4. x+3    all 6 digits is a palendrone 
def palendrone(x):
	word = str(x)
	reverse = word[::-1]
	return word == reverse

def print_condition(x):
	s = str(x)
	l = len(s)
	if not l == 6: return
	print x, "last 4 digits", s[2:6]
	x = x + 1
	s = str(x)
	print x, "last 5 digits", s[1:6]
	x = x + 1
	s = str(x)
	print x, "middle 4 digits", s[1:5]
	x = x + 1
	s = str(x)
	print x, "all digits", s

def test_condition(x):
	s = str(x)
	l = len(s)
	if not l == 6: return False
	if not palendrone(s[2:6]):
		return False
	x = x + 1
	s = str(x)
	if not palendrone(s[1:6]):
		return False
	x = x + 1
	s = str(x)
	if not palendrone(s[1:5]):
		return False
	x = x + 1
	s = str(x)
	if not palendrone(s):
		return False
	return True

x = 123456
print_condition(x)
# 123456 last 4 digits 3456
# 123457 last 5 digits 23457
# 123458 middle 4 digits 2345
# 123459 all digits 123459
print test_condition(x)				# False

x = 100000
while x < 300000:
	if test_condition(x):
		print_condition(x)
		print ""
	x = x + 1

# There are two solutions:
# 198888 last 4 digits 8888
# 198889 last 5 digits 98889
# 198890 middle 4 digits 9889
# 198891 all digits 198891
#
# 199999 last 4 digits 9999
# 200000 last 5 digits 00000
# 200001 middle 4 digits 0000
# 200002 all digits 200002

# Exercise 9-9
# for example: son = 37, mom = 73
# reversible 6 times so far
# will happen two more times

def is_reverse(x,y):
	word = str(x)
	reverse = str(y)
	reverse = reverse[::-1]
	return word == reverse
print is_reverse(37, 73)		# True
print is_reverse(37, 72)		# False

ages = {}
pairs = {}
for x in range(1,99):
	for y in range(1,99):
		if x>=y:
			continue
		a = str(x).zfill(2)
		b = str(y).zfill(2)
		if is_reverse(a,b):
			diff = abs(int(a)-int(b))
			ages[diff] = ages.get(diff, 0) + 1
			pairs[diff] = pairs.get(diff, "") + "("+str(a)+","+str(b)+") "
for x in ages:
	if ages[x] >= 8:
		print pairs[x]
#(01,10) (12,21) (23,32) (34,43) (45,54) (56,65) (67,76) (78,87) (89,98)
#(02,20) (13,31) (24,42) (35,53) (46,64) (57,75) (68,86) (79,97)

# First solution mother is too young
# Son is now 57 and mother is 75, see solution 2
#(02,20) (13,31) (24,42) (35,53) (46,64) (57,75) (68,86) (79,97)
