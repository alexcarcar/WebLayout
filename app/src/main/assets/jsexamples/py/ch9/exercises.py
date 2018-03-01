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

# Exercise 9-7: three consecutive letters
def three_consecutive_letters(word):
	s = 1; prev = "-"; n = 0
	for c in word:
		print s, c, prev, n
		if s == 1: # first letter
			prev = c; n = 0; s = 2
			continue

		if s == 2: # second letter
			if c == prev:
				s = 3
				n = n + 1
				continue;
			if n == 3: return True;
			n = 0
			continue

		if s == 3: # repeated letter
			if c == prev: continue
			s = 1; continue

	return False

three_consecutive_letters("aapplleedd")

# fin = open('words.txt')
# for line in fin:
# 	word = line.strip()
# 	if three_consecutive_letters(word):
# 		print word
# fin.close()
