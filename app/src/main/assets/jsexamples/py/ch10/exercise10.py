import time
# Exercise 10-10: build a list using append
t = []
n = 0
fin = open('../ch9/words.txt')
s = time.clock();
for line in fin:
	word = line.strip()
	n = n + 1
	t.append(word)
fin.close()
e = time.clock();
print "# " + str(n)
print "append " + str(e-s) + " seconds"

# Exercise 10-10: build a list using t = t + [x]
t = []
fin = open('../ch9/words.txt')
s = time.clock();
n = 0
for line in fin:
	word = line.strip()
	t = t + [word]
	n = n + 1
	if (n%10000 == 0):
		print "#" + str(n)
fin.close()
e = time.clock();
print "t = t + [x] " + str(e-s) + " seconds"

# % python2 exercise10.py
#  113809
# append 0.356101403949 seconds
#10000
#20000
#30000
#40000
#50000
#60000
#70000
#80000
#90000
#100000
#110000
# t = t + [x] 388.604205004 seconds
