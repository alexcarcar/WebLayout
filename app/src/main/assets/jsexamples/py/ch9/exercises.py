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
