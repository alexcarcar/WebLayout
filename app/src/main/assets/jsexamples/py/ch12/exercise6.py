# Exercise 12-5: longest word whose "children" are words
def make_word_dict():
    d = dict()
    fin = open('../ch9/words.txt')
    for line in fin:
        word = line.strip().lower()
        d[word] = word
    return d

def children(word, d):
    t = []
    for i in range(len(word)):
        w = ""
        for j in range(len(word)):
            if i != j: w += word[j]
        if w in d: t.append(w)
    return t
d = make_word_dict()
print children("alex", d)
# ['lex', 'ale']
