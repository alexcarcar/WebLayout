# check if three sides can form a triangle

def is_triangle(a, b, c):
	t = [a, b, c]
	t.sort()
	return t[0]+t[1]>t[2]

a = float(raw_input("a? "));
b = float(raw_input("b? "));
c = float(raw_input("c? "));

if is_triangle(a,b,c):
	print "Yes"
else:
	print "No"

# % python checkTriangle.py
# a? 1
# b? 1
# c? 1
# Yes
# 
# % python checkTriangle.py
# a? 10
# b? 10
# c? 21
# No
# 
# % python checkTriangle.py
# a? 10
# b? 10
# c? 19
# Yes
