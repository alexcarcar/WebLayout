# Exercise 13-4
import string

def make_word_dict():
    """Read the words in words.txt and return a dictionary
    that contains the words as keys"""
    d = dict()
    fin = open('../ch9/words.txt')
    for line in fin:
        word = line.strip().lower()
        d[word] = word
    return d

word_dict = make_word_dict()
words = dict()

def addWord(word):
    cleanWord = ""
    for c in word:
        if c in string.punctuation: continue
        cleanWord += c
    if cleanWord != "" and not cleanWord in word_dict:
        words[cleanWord] = words.get(cleanWord, 0) + 1

fin = open('example2.txt')
for line in fin:
    text = line.strip().lower()
    text = text.split(" ");
    for word in text:
        addWord(word)
print words

# {'penetrating': 1, 'greenland': 1, 'dont': 1, 'letterpress': 1, 'lapland': 1, 'naze': 1,
# 'concentre': 1, 'bessie': 4, 'breakfastroom': 1, 'childrens': 1, 'bewick': 1, 'reservoir': 1,
# 'ironingtable': 1, 'endeavouring': 1, 'eliza': 2, 'halfcomprehended': 1, 'georgiana': 2,
# 'pamela': 1, 'hebrides': 1, 'lindeness': 1, 'drawingroom': 2, 'wereshe': 1, 'imperfect': 1,
# 'moreland': 1, 'iceland': 1, 'crosslegged': 1, 'spacethat': 1, 'deathwhite': 1, 'bookbewicks': 1,
# 'atlantic': 1, 'chidings': 1, 'november': 1, 'zembla': 1, 'siberia': 1, 'a': 26, 'thule': 1,
# 'i': 25, 'norway': 1, 'ceaseless': 1, 'newlyrisen': 1, 'thiefs': 1, 'british': 1, 'mrs': 2,
# 'boh': 1, 'mannersomething': 1, 'turk': 1, 'spitzbergen': 1, 'stormbeat': 1}