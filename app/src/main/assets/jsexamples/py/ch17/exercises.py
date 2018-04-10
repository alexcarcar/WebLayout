# Exercise 17-2
class Point(object):
	"""Represents a point in 2D.

	attributes: x, y
	"""
	def __init__(self, x=0, y=0):
		(self.x, self.y) = (x, y)

	# Exercise 17-3 (p 194)
	def __str__(self):
		return '(%g, %g)' % (self.x, self.y)

	# Exercise 17-4 (p 194)
	def __add__(self, other):
		# Exercise 17-5 (p 196)
		if isinstance(other, Point):
			return self.add_point(other)
		else:
			(x,y) = other
			return Point(self.x + x, self.y + y)

	def __radd__(self, other):
		return self.__add__(other)

	def add_point(self, other):
		return Point(self.x + other.x, self.y + other.y)

	def print_point(self):
		print '(%g, %g)' % (self.x, self.y)


p = Point(2,3)
p.print_point() # (2, 3) 

# Exercise 17-3 (p 194)
p2 = Point (3.1415, 2.1818)
print p2 # (3.1415, 2.1818)

# Exercise 17-4 (p 194)
print p + p2 # (5.1415, 5.1818)

# Exercise 17-5
print p + (5, 7) # (7, 10)
print (3, 3) + p # (5, 6)

p = Point(3, 4)
print p.__dict__ # {'y': 4, 'x': 3}

def print_attributes(obj):
	for attr in obj.__dict__:
		print attr, getattr(obj, attr)
print_attributes(p)
# y 4
# x 3


