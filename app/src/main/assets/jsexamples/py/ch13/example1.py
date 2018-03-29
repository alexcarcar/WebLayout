# Exercise 13-1: convert words in a text file to lower case (and remove punctuation)

import string
print string.punctuation

def printWord(word):
	cleanWord = ""
	for c in word:
		if c in string.punctuation: continue
		cleanWord += c
	if cleanWord != "":
		print cleanWord

# Exercise 13-1
fin = open('example1.txt')
for line in fin:
    text = line.strip().lower()
    text = text.split(" ");
    for word in text:
    	printWord(word)

# ...
# from
# words
# and
# converts
# them
# to
# lowercase
