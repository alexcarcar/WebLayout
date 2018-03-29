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
	return t
print most_frequent()

# [(59, 'the'), (39, 'of'), (33, 'and'), (26, 'a'), (25, 'i'), (17, 'in'), (16, 'to'),
# (11, 'with'), (11, 'was'), (10, 'that'), (9, 'my'), (8, 'it'), (7, 'she'),
# (7, 'on'), (7, 'from'), (6, 'its'), (6, 'her'), (6, 'by'), (6, 'as'), (5, 'there'),
# (5, 'me'), (5, 'but'), (5, 'be'), (5, 'at'), (4, 'were'), (4, 'up'), (4, 'happy'),
# (4, 'bessie'), (3, 'winter'), (3, 'when'), (3, 'taking'), (3, 'so'), (3, 'reed'),
# (3, 'pages'), (3, 'or'), (3, 'more'), (3, 'like'), (3, 'john'), (3, 'had'),
# (3, 'for'), (3, 'could'), (3, 'cold'), (3, 'an')]