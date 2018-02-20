def divides(a,b):
	return a%b==0

def is_power(a,b):
	print a,b
	if (a==b): return True
	if (a<b): return False
	return divides(a,b) and is_power(a/b,b)

print is_power(25, 5)
# 25 5
# 5 5
# True

print is_power(27, 3)
# 27 3
# 9 3
# 3 3
# True

print is_power(28, 3)
# 28 3
# False
