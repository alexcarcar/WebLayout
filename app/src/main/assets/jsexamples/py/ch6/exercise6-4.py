def b(z):
	prod = a(z,z)
	print z, prod
	return prod

def a(x, y):
	x = x + 1
	return x * y

def c(x, y, z):
	total = x + y + z
	square = b(total)**2
	return square

x = 1
y = x + 1				# 2
print c(x, y+3, x+y)	# c(1, 5, 3) = b(9)**2 = a(9,9)**2 = 90**2 = 8100