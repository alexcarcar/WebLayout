import math

class Point(object):
    """Represents a point in 2-D space."""

class Rectangle(object):
    """Represents a rectangle
    attributes: width, height, corner.
    """

def print_point(p):
    print "(%g, %g)" % (p.x, p.y)

# Exercise 15-1
def distance_between_points(a, b):
    dx = b.x-a.x
    dy = b.y-a.y
    return math.sqrt(dx**2 + dy**2)

a = Point()
b = Point()
a.x = 1
a.y = 3
b.x = 2
b.y = 5
print_point(a) # (1, 3)
print_point(b) # (2, 5)
print distance_between_points(a,b) # 2.2360679775

# Exercise 15-2
def move_rectangle(rect, dx, dy):
    rect.corner.x += dx
    rect.corner.y += dy

rect = Rectangle()
rect.width = 100
rect.height = 150
rect.corner = Point()
rect.corner.x = 15
rect.corner.y = 30
move_rectangle(rect, 50, 50)
print_point(rect.corner) # (65, 80)

import copy

# Exercise 15-3
def move_copy_rectangle(r, dx, dy):
    rect = copy.deepcopy(r)
    rect.corner.x += dx
    rect.corner.y += dy
    return rect

newRect = move_copy_rectangle(rect, 50, 50)
print_point(rect.corner) # (65, 80)
print_point(newRect.corner) # (115, 130)

# Exercise 15-4
from swampy.World import World
world = World()
canvas = world.ca(width=500, height=500, background='white')
bbox = [[-150,-100], [150,100]]
canvas.rectangle(bbox, outline='black', width=2, fill='green4')
canvas.circle([-25,0], 70, outline=None, fill='red')
points = [[-150,-100], [150,100], [150,-100]]
canvas.polygon(points,fill='blue')
world.mainloop()