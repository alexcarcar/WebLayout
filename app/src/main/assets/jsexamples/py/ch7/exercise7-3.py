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

a = 1.0
while a <= 9.0:
	sqrt_est = square_root(a)
	sqrt = math.sqrt(a)
	diff = abs(sqrt - sqrt_est)
	print str(a) + "\t" + str(sqrt_est) + "\t" + str(sqrt) + "\t" + str(diff)
	a = a+1

# 1.0     1.00000004646   1.0     4.64611473738e-08
# 2.0     1.41421356237   1.41421356237   1.59472435257e-12
# 3.0     1.73205081001   1.73205080757   2.44585018905e-09
# 4.0     2.0     2.0     0.0
# 5.0     2.23606797792   2.2360679775    4.16013890003e-10
# 6.0     2.44948979592   2.44948974278   5.31351895816e-08
# 7.0     2.64575131106   2.64575131106   1.02584607475e-13
# 8.0     2.82842712475   2.82842712475   3.18944870514e-12
# 9.0     3.00000000004   3.0    3.9321434997e-11