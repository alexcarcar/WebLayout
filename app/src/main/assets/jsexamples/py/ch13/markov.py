import sys
import string
import random

def random_text(suffix_map, n=100):
    # choose a random prefix (not weighted by frequency)
    start = random.choice(suffix_map.keys())
    for i in range(n):
        suffixes = suffix_map.get(start, None)
        if suffixes == None:
            # if the prefix isn't in map, we got to the end of the
            # original text, so we have to start again.
            random_text(n-i)
            return
        # choose a random suffix
        word = random.choice(suffixes)
        print word,
        start = shift(start, word)


def shift(t, word):
    return t[1:] + (word,)

filename = "example2.txt"
order = 4
suffix_map = {}
prefix = ()
fp = open(filename)
for line in fp:
    for word in line.rstrip().split():
        if len(prefix) < order:
            prefix += (word,)
            break
        try:
            suffix_map[prefix].append(word)
        except KeyError:
            # if there is no entry for this prefix, make one
            suffix_map[prefix] = [word]
        prefix = shift(prefix, word)        

random_text(suffix_map, 50)
# good earnest to acquire a more sociable and childlike disposition, a more attractive
# and sprightly manner--something lighter, franker, more natural, as it were--she really must
# exclude me from privileges intended only for contented, happy,
# little children." "What does Bessie say I have done?" I asked. "Jane, I don't like cavillers