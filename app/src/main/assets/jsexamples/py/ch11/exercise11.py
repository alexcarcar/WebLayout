# Exercise 11-11: 5 letter riddle

words = dict()
domain = [] # 5 letter words
fin = open('../ch9/words.txt')
for line in fin:
		word = line.strip()
		words[word] = ""
		if len(word) == 5:
			domain.append(word)

fin.close()
print "apple" in words	# True
print "abple" in words	# False

for w in domain:
	w1 = w[1:]
	if w1 not in words: continue
	w2 = w[:1] + w[2:]
	if w2 not in words: continue
	if w[0] == w1[0]: print w, w1, w2

# True
# False
# llama lama lama
# oohed ohed ohed
