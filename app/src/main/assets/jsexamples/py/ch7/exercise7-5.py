import math
def estimate_pi():
	k = 0.0
	sum = 0.0
	while True:
		top = float(math.factorial(4*k)*(1103+26390*k));
		bottom = float((math.factorial(k))**4 * 396**(4*k))
		ds = float(top/bottom)
		sum = sum + ds
		if k>0 and ds < 1e-15:
			break
		k = k + 1
	C = 9801.0/(2*math.sqrt(2))
	print "k:"+str(k)
	return C/sum

pi_est = estimate_pi()
print pi_est, math.pi, abs(pi_est-math.pi)

# k:3.0
# 3.14159265359 3.14159265359 0.0