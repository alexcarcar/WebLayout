# Exercise 11-1 (p 122)
words = dict()
fin = open('../ch9/words.txt')
for line in fin:
        words[line.strip()] = ""
fin.close()
print "apple" in words	# True
print "abple" in words	# False