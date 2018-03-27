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

def is_swap(word1, word2):
    n = len(word1)
    if len(word2) != n: return False
    different = 0
    for i in range(n):
        if word1[i] != word2[i]:
            different += 1
        if different>2: return False
    if different == 2: return True
    return False

def print_swaps(t):
    for word in t:
        for other_word in t:
            if word != other_word and is_swap(word, other_word):
                print word, other_word

word_dict = make_word_dict()
for x in anagrams:
	print_swaps(anagrams[x])

print is_swap("abc", "cba") # True

# ...
# spader spared
# spared spader
# beraking breaking
# breaking beraking
# True