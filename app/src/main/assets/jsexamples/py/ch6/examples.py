import math

# Return Values (p 61)
e = math.exp(1.0)
print e 	# 2.71828182846
radians = math.pi/4
radius = 150.0
height = radius * math.sin(radians)
print radians, radius, height	# 0.785398163397 150.0 106.066017178

def areaTemp(radius):
	temp = math.pi * radius**2
	return temp

def area(radius):
	return math.pi * radius**2

print area(2.0), areaTemp(2.0)	# 12.5663706144 12.5663706144

def absolute_value(x):
	if x<0:
		return -x
	if x>0:
		return x
print absolute_value(-3), absolute_value(0), absolute_value(3)	# 3 None 3

def compare(x,y):
	if x>y:
		return 1
	elif x==y:
		return 0
	else:
		return -1
print compare(2,2), compare(2,3), compare(3,2)		# 0 -1 1

# Incremental Development (p 63)
def distance(x1, y1, x2, y2):
	dx = x2 - x1
	dy = y2 - y1
	dsquared = dx**2 + dy**2
	result = math.sqrt(dsquared)
	return result
print distance(1, 2, 4, 6), distance(1,0, 5,0)		# 5.0 4.0

def hypotenuse(a, b):
	return math.sqrt(a**2 + b**2)
print hypotenuse(3,4), hypotenuse(5,12)				# 5.0 13.0

# Composition (p 64)
def circle_area(xc, yc, xp, yp):
	return area(distance(xc, yc, xp, yp))
print circle_area(0,0,1,1)							# 6.28318530718

# Boolean Functions (p 65)
def is_divisible(x, y):
	return x % y == 0
print is_divisible(6,4), is_divisible(6,3)			# False True

def is_between(x, y, z):
	return x <= y and y <=z

print is_between(1, 2, 3), is_between(1,1,2), is_between(10,4,12)		# True True False

# More Recursion (p 66)
def factorial(n):
	if n == 0:
		return 1
	else:
		recurse = factorial(n-1)
		result = n * recurse
		return result
print factorial(3), factorial(5), factorial(6)		# 6 120 720

def fibonacci(n):		# 0 1 1 2 3 5 8 13 21 34 55 ...
						# 0 1 2 3 4 5 6  7  8  9 10
	if n == 0:
		return 0
	elif n == 1:
		return 1
	else:
		return fibonacci(n-1) + fibonacci(n-2)
print fibonacci(6), fibonacci(8), fibonacci(10) # 8 21 55

# print factorial(1.5) # RuntimeError: maximum recursion depth exceeded in cmp

def protected_factorial(n):
	if not isinstance(n, int):
		print 'Factorial is only defined for integers.'
		return None
	elif n < 0:
		print 'Factorial is not defined for negative integers.'
		return None
	else:
		return factorial(n)
print protected_factorial(-3)
# Factorial is not defined for negative integers.
# None
print protected_factorial(3.2)
# Factorial is only defined for integers.
# None
	