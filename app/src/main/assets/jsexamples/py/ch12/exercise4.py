# Exercise 12-4.1: prints all words that are anagrams
def sortletters(word):
	return ''.join(sorted(list(word)))

anagrams = dict()
def make_word_dict():
    """Read the words in words.txt and return a dictionary
    that contains the words as keys"""
    d = dict()
    fin = open('../ch9/words.txt')
    for line in fin:
        word = line.strip().lower()
        d[word] = word
        k = sortletters(word)
        if k in anagrams:
        	anagrams[k].append(word)
        else:
        	anagrams[k] = [word]
    return d

word_dict = make_word_dict()
print len(word_dict)
# 113809
print sortletters("apple") # aelpp
print sortletters("alex") # aelx
for x in anagrams:
	if len(anagrams[x])>8:
		print anagrams[x]
# ['least', 'setal', 'slate', 'stale', 'steal', 'stela', 'taels', 'tales', 'teals', 'tesla']
# ['estrin', 'inerts', 'insert', 'inters', 'niters', 'nitres', 'sinter', 'triens', 'trines']
# ['apers', 'asper', 'pares', 'parse', 'pears', 'prase', 'presa', 'rapes', 'reaps', 'spare', 'spear']
# ['capers', 'crapes', 'escarp', 'pacers', 'parsec', 'recaps', 'scrape', 'secpar', 'spacer']
# ['alerts', 'alters', 'artels', 'estral', 'laster', 'ratels', 'salter', 'slater', 'staler', 'stelar', 'talers']
