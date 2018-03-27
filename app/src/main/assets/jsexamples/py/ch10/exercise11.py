import time
# Exercise 11: bisect to determine if a word is in a dictionary
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

print bisect(t, "apple"), bisect(t, "aa") # 4450 0
print bisect(t, "aaa"), bisect(t, "zzz") # None None
print bisect(t, "stream"), bisect(t, "zebra") # 96567 113501
