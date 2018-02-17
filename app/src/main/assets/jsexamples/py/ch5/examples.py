# Modulous Operator (p 49)
quotient = 7/3
print quotient		# 2
remainder = 7%3
print remainder		# 1

# Boolean Expressions (p 49)
print 5 == 5		# True
print 5 == 6		# False
print type(True)	# <type 'bool'>
print type(False)	# <type 'bool'>

# Relational Operators (p 50)
# ==, !=, >, <, >=, <=

# Logic Operators: and, or, not (p 50)
n = 9
print n%2==0 or n%3==0	# True
print 17 and True		# True (any non zero number is interpreted as "true")

# Conditional Execution (p 50)
if n > 0:
	print 'n is positive'	# n is positive
m = -9
if m < 0:
	pass	# "pass" does nothing, i.e. need to handle negative cases

# Alternative Exeuction (p 51)
x = 2
if x%2 == 0:
	print 'x is even' 	# x is even
else:
	print 'x is odd'

# Chained Conditionals (p 51)
x = 15; y = 7;
if x < y:
	print 'x is less than y'
elif x > y:
	print 'x is greater than y'		# x is greater than y
else:
	print 'x and y are equal'

# Nested Conditionals (p 52)
if x == y:
	print 'x and y are equal'
else:
	if x < y:
		print 'x is less than y'
	else:
		print 'x is greater than y'		# x is greater than y

if 0 < x and x < 10:
	print 'x is a positive single-digit number'
else:
	print 'or it is not!'	# or it is not!

# Recursion (p 53)
def countdown(n):
	if n <= 0:
		print 'Blastoff!'
	else:
		print "--> " + str(n)
		countdown(n-1)
countdown(3)	# 3 2 1 Blastoff!
def print_n(s, n):
	if n <= 0:
		return
	print s
	print_n(s, n-1)
print_n("Alex", 3)		# Alex Alex Alex

# Infinite Recurision (p 55)
def recurse():
	recurse()
# recurse() # RuntimeError: maximum recursion depth exceeded

# Keyboard input (raw_input)
name = raw_input('What...is your name?\n')
print name
speed = raw_input('Speed?')
print int(speed)