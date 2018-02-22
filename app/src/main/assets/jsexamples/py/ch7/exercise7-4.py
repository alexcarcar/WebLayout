import math

# Exercise 7-4 (p 82)
# print eval('1 + 2*3')				# 7
# print eval('math.sqrt(5)')		# 2.2360679775
# print eval('type(math.pi)')		# <type 'float'>

print "Enter a mathematical expression to evaluate ('done' to quit)"
while True:
	line = raw_input("> ")
	if line == 'done':
		break
	print eval(line)

# % python exercise7-4.py
# Enter a mathematical expression to evaluate ('done' to quit)
# > math.sqrt(25)+math.pi
# 8.14159265359
# > 3**3
# 27
# > 3**4+1
# 82
# > done
# 
# %