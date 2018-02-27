# Exercise 8-10: step size (string slices)
fruit = 'banana'
print fruit[0:5:2]						# bnn
print fruit[::-1]						# ananab

def is_palendrome(word1, word2):
	return word1 == word2[::-1]

print is_palendrome('stop', 'pots')		# True
print is_palendrome('apple', 'orange')	# False

# Exercise 8-11

def any_lowercase1(s):
	for c in s:
		if c.islower():
			return True
		else:
			return False # <-- Error: only checks the first character
print any_lowercase1('ABCDe')			# False
print any_lowercase1('ABCDE')			# False
print any_lowercase1('aBCDE')			# True

def any_lowercase2(s):
	for c in s:
		if 'c'.islower(): # <-- Error: always returns true ('c' is always lowercase)
			return True
		else:
			return False
print any_lowercase2('ABCDe')			# True
print any_lowercase2('ABCDE')			# True
print any_lowercase2('aBCDE')			# True

def any_lowercase3(s):
	for c in s:
		flag = c.islower() # <-- Error: only "checks" the last character
	return flag
print any_lowercase3('ABCDe')			# True
print any_lowercase3('ABCDE')			# False
print any_lowercase3('aBCDE')			# False

def any_lowercase4(s): # Correctly determines if any character is lowercase
	flag = False
	for c in s:
		flag = flag or c.islower()
	return flag
print any_lowercase4('ABCDe')			# True
print any_lowercase4('ABCDE')			# False
print any_lowercase4('aBCDE')			# True

def any_lowercase5(s):
	for c in s:
		if not c.islower():
			return False # <-- Error: if word has any capital letter return False
	return True # <-- Error: only True if entire word contains lower case letters
print any_lowercase5('ABCDe')			# False
print any_lowercase5('ABCDE')			# False
print any_lowercase5('aBCDE')			# False
print any_lowercase5('abcde')			# True

# Exercise 8-12
def rotate_word(s, n):
	rotated_word = ""
	for c in s:
		if c >= 'A' and c <= 'Z':
			c = rotate_letter(c, 'A', 'Z', n)
		elif c >= 'a' and c <= 'z':
			c = rotate_letter(c, 'a', 'z', n)
 		rotated_word = rotated_word + c
 	return rotated_word

def rotate_letter(char, start, end, n):
	a = ord(start)
	z = ord(end)
	c = ord(char)-a
	len = z-a+1
	if n<0:
		n = len + n;
	shift = (c + n) % len
	c = a + shift
	return chr(c)

print rotate_word("cheer", 7) 		# jolly
print rotate_word("melon", -10) 	# cubed