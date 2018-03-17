t = []
n = 0
fin = open('../ch9/words.txt')
for line in fin:
	word = line.strip()
	n = n + 1
	t.append(word)
fin.close()
print t[0], t[1], len(t), n # aa aah 113809 113809
print 2**17 # 131072

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

def remove_duplicates(t):
	s = sorted(t)
	newT = []
	first = True
	last = ""
	for x in s:
		if first:
			first = False
		elif x == last:
			continue
		last = x
		newT.append(x)
	return newT

def permute(word):
	from itertools import permutations
	perms = [''.join(p) for p in permutations(word)]
	return remove_duplicates(perms)

# Exercise 13: determine if two words interlock
def interlock(word1, word2):
	word = str(word1) + str(word2)
	listt = permute(word)
	interlocks = []
	print len(listt)
	n = 0
	for w in listt:
		n = n + 1
		if n%1000 == 0:
			print "#", n
		if bisect(t, w):
			interlocks.append(w)
			print w
	return interlocks
	
print interlock("shoe", "cold")

# % python2 exercise13.py
# aa aah 113809 113809
# 131072
# 20160
# 1000
# 2000
# 3000
# 4000
# 5000
# 6000
# 7000
# 8000
# 9000
# 10000
# 11000
# 12000
# 13000
# 14000
# 15000
# 16000
# 17000
# schooled
# 18000
# 19000
# 20000
# ['schooled']