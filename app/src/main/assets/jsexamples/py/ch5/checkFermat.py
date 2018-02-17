# check fermat's last theorem

def check_fermat(a, b, c, n):
	print str(a**n + b**n) + " = " + str(c**n) + " and " + str(n) + ">2?"
	return not (n>2 and a**n + b**n == c**n)

a = int(raw_input("a? "));
b = int(raw_input("b? "));
c = int(raw_input("c? "));
n = int(raw_input("n? "));

if not check_fermat(a,b,c,n):
	print "Holy smokes, Fermat was wrong!"
else:
	print "No, that doesn't work."
