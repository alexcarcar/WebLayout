# Random Numbers (p 148)

import random
for i in range(10):
	x = random.random()
	print x,
# 0.111731158394 0.933590751828 0.677197657821 0.32501260863 0.257776330663
# 0.697285221522 0.261738252042 0.482822595503 0.661214362955 0.824044003515
print

print random.randint(5,10) # 8
print random.randint(5,10) # 10

t = ['alex', 'carol', 'simon', 'george']
print random.choice(t) # george
print random.choice(t) # alex

print "----------------------------------------------------"
print "# Word Histogram (p 149)"
print "----------------------------------------------------"
import string
def process_file(filename):
	hist = dict()
	fp = open(filename)
	for line in fp:
		process_line(line, hist)
	return hist

def process_line(line, hist):
	line = line.replace('-', ' ')
	for word in line.split():
		word = word.strip(string.punctuation + string.whitespace)
		word = word.lower()
		hist[word] = hist.get(word,0) + 1

def total_words(hist):
	return sum(hist.values())

def different_words(hist):
	return len(hist)

hist = process_file('example2.txt')
print total_words(hist) # 925
print different_words(hist) # 509

print "----------------------------------------------------"
print "# Most Common Words (p 150)"
print "----------------------------------------------------"
def most_common(hist):
	t = []
	for key,value in hist.items():
		t.append((value,key))
	t.sort(reverse=True)
	return t
t = most_common(hist)
for freq, word in t[0:5]:
	print word, freq
# the 59
# of 39
# and 33
# a 26
# i 25

print "----------------------------------------------------"
print "# Optional Parameters (p 151)"
print "----------------------------------------------------"
def print_most_common(hist, num=10):
	t = most_common(hist)
	print 'The most common words are:'
	for freq, word in t[:num]:
		print word, '\t', freq

print_most_common(hist)
# The most common words are:
# the     59
# of      39
# and     33
# a       26
# i       25
# in      17
# to      16
# with    11
# was     11
# that    11

print_most_common(hist, 3)
# The most common words are:
# the     59
# of      39
# and     33

print "----------------------------------------------------"
print "# Dictionary Subtraction (p 151)"
print "----------------------------------------------------"
def subtract(d1, d2):
	res = dict()
	for key in d1:
		if key not in d2:
			res[key] = None
	return res

words = process_file("../ch9/words.txt")
diff = subtract(hist, words)
print "The words in the book that aren't in the word list are:"
for word in diff.keys():
	print word,
# The words in the book that aren't in the word list are:
# penetrating greenland letterpress don't thief's lapland naze concentre bessie
# be wick reservoir endeavouring eliza georgiana reed's pamela hebrides lindeness
# norway imperfect moreland iceland atlantic chidings november zembla siberia a
# bewick's thule i ceaseless british mrs boh children's turk spitzbergen
print
print "----------------------------------------------------"
print "# Exercise 13-6 (p 152) - using set to subract"
print "----------------------------------------------------"

from sets import Set
engineers = Set(['John', 'Jane', 'Jack', 'Janice'])
programmers = Set(['Jack', 'Sam', 'Susan', 'Janice'])
managers = Set(['Jane', 'Jack', 'Susan', 'Zack'])
fulltime_management = managers - engineers - programmers # difference
engineers.add('Marvin')                                  # add element
print fulltime_management # Set(['Zack'])

diff = Set(hist) - Set(words)
print ' '.join(list(diff))
# penetrating greenland letterpress don't thief's lapland naze concentre bessie bewick
# reservoir endeavouring eliza georgiana reed's pamela hebrides lindeness norway
# imperfect moreland iceland atlantic chidings november zembla siberia a bewick's
# thule i ceaseless british mrs boh children's turk spitzbergen

print "----------------------------------------------------"
print "# Random Words (p 152)"
print "----------------------------------------------------"

def random_word(h):
	t = []
	for word, freq in h.items():
		t.extend([word]*freq)
	return random.choice(t)
print random_word({'alex':46, 'carol':40, 'simon':10, 'george':6}) # alex

print "----------------------------------------------------"
print "# Exercise 13-7 (p 153) - efficient random_word"
print "----------------------------------------------------"

k = words.keys()
print k[:5] # ['biennials', 'catechols', 'lenitives', 'vang', 'impotents']
n = 0
totals = []
for keys in k:
	n += words[keys]
	totals.append(n)
print totals[:5]
print n, sum(words.values()) # 113809 113809
r = random.randint(1,n)
print r # 111397

def bisect(t, target):
	if len(t) == 0:
		return
	middle = int(len(t)/2)
	x = t[middle]
	if x == target:
		return middle
	if middle == 0:
		return
	if target<x:
		return bisect(t[:middle], target)
	else:
		k = bisect(t[middle:], target)
		if k == None:
			return None
		return middle + k

key = bisect(totals, r)
print list(words)[key] # gyred
