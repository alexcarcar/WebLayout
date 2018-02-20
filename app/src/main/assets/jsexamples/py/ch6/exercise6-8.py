# greatest common divisor (gcd) = euclid
def gcd(a,b):
	print a, b
	if b == 0: return a
	return gcd(b, a%b)

print(gcd(81, 27))
# 81 27
# 27 0
# 27 

print(gcd(91,17))
# 91 17
# 17 6
# 6 5
# 5 1
# 1 0
# 1

print(gcd(91,13))
# 91 13
# 13 0
# 13