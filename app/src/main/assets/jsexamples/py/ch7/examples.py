# Multiple Assignments (p 75)
bruce = 5
print bruce,
bruce = 7
print bruce		# 5 7

a = 5
b = a
a = 3
print a, b 		# 3 5

# Updating Variables (p 76)
# x = x+1		# NameError: name 'x' is not defined
x = 0
x = x + 1
print x			# 1

# The while Statement (p 76)
def countdown(n):
	while n > 0:
		print n,
		n = n-1
	print 'Blastoff!' 

countdown(10)	# 10 9 8 7 6 5 4 3 2 1 Blastoff!

def sequence(n):
	while n != 1:
		print n,
		if n%2 == 0:	# n is even
			n = n/2
		else:			# n is odd
			n = n*3+1
	print ""

sequence(3)		# 3 10 5 16 8 4 2
sequence(7)		# 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2

# break (p 78)
def input_test():
	while True:
		line = raw_input('> ')
		if line == 'done':
			break
		print line
	print 'Done!'
# input_test()
# > not done
# not done
# > done
# Done!

# Square Roots (p 79)
a = 4.0
x = 3.0					# Newton's method:
y = (x + a/x) / 2		# estimate square root of 4.0 (with first estimate of 3.0)
print y
# 2.16666666667

x = y
y = (x + a/x) / 2
print y
# 2.00641025641

x = y
y = (x + a/x) / 2
print y
# 2.00001024003

x = y
y = (x + a/x) / 2
print y
# 2.00000000003

x = y
y = (x + a/x) / 2
print y
# 2.0

x = y
y = (x + a/x) / 2
print y
# 2.0

x = 4
while True:
	print x
	y = (x + a/x) / 2
	if y == x:
		break
	x = y

# 4
# 2.5
# 2.05
# 2.0006097561
# 2.00000009292
# 2.0
# 2.0

x = 4
epsilon = 0.0000001
while True:
	print x
	y = (x + a/x) / 2
	if abs(y-x) < epsilon:
		break
	x = y

# 4
# 2.5
# 2.05
# 2.0006097561
# 2.00000009292
