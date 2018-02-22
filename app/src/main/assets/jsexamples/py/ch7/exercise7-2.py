import math

# Exercise 7-2 (p 80)

def square_root(a):
	x = float(a/2)		# first estimate
	epsilon = 0.0000001
	while True:
		y = (x + a/x) / 2
		if abs(y-x) < epsilon:
			break
		x = y
	return x

print square_root(27), math.sqrt(27)
print square_root(13), math.sqrt(13)
print square_root(10), math.sqrt(10)

# 5.19615242272 5.19615242271
# 3.60555127707 3.60555127546
# 3.16227766044 3.16227766017
