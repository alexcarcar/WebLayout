import math

class Point(object):
	"""Represents a point in 2-D space."""

blank = Point()
print Point # <class '__main__.Point'>
print blank # <__main__.Point object at 0x0175B710>

def hypotenuse(p):
	return math.sqrt(p.x**2 + p.y**2)

def print_point(p):
	print '(%g, %g)' % (p.x, p.y)

# Attributes (p 172)
blank.x = 3.0
blank.y = 4.0
print_point(blank) # (3, 4)
print hypotenuse(blank) # 5.0

# Rectangles (p 173)
class Rectangle(object):
	"""Represents a rectangle

	attributes: width, height, corner.
	"""

box = Rectangle()
box.width = 100.0
box.height = 200.0
box.corner = Point()
box.corner.x = 0.0
box.corner.y = 0.0

# Instances as Return Values (p 175)
def find_center(rect):
	p = Point()
	p.x = rect.corner.x + rect.width/2.0
	p.y = rect.corner.y + rect.height/2.0
	return p

center = find_center(box)
print_point(center) # (50, 100)

# Objects Are Mutable
box.width = box.width + 50
box.height = box.height + 100
center = find_center(box)
print_point(center) # (75, 150)

def grow_rectangle(rect, dwidth, dheight):
	rect.width += dwidth
	rect.height += dheight

grow_rectangle(box, 50, 100)
center = find_center(box)
print_point(center) # (100, 200)

# Copying (p 176)
p1 = Point()
p1.x = 3.0
p1.y = 4.0

import copy
p2 = copy.copy(p1)
print_point(p1) # (3, 4)
print_point(p2) # (3, 4)
print p1 is p2 # False
print p1 == p2 # False

box2 = copy.copy(box)
print box2 is box # False
print box2.corner is box.corner # True

box3 = copy.deepcopy(box)
print box3 is box # False
print box3.corner is box.corner # False

# Debugging (p 177)
p = Point()
p.x = 12.0
p.y = 34.0
try: print p.z
except Exception as e:
	print e # 'Point' object has no attribute 'z'

print type(p) # <class '__main__.Point'>
print hasattr(p, 'x') # True
print hasattr(p, 'z') # False
