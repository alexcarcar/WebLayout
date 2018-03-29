# Exercise 13-2: count the frequency of words
import string

words = dict()

def addWord(word):
	cleanWord = ""
	for c in word:
		if c in string.punctuation: continue
		cleanWord += c
	if cleanWord != "":
		words[cleanWord] = words.get(cleanWord, 0) + 1

fin = open('example2.txt')
for line in fin:
    text = line.strip().lower()
    text = text.split(" ");
    for word in text:
    	addWord(word)

# print most frequent words
def most_frequent():
	t = []
	for key in words:
		if words[key]>2: t.append((words[key],key)) # Decorate
	t.sort(reverse=True) # Sort
	return t[:5]

print most_frequent()
# [(59, 'the'), (39, 'of'), (33, 'and'), (26, 'a'), (25, 'i')]
