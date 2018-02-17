import math
from swampy.TurtleWorld import *
world = TurtleWorld()

def polygon(t, length, n):
	for i in range(n):
		fd(t, length)
		rt(t, 360/n)

def circle(t, r):
	n = 360
	c = math.pi * r
	l = c/n
	polygon(t, l, n)

t = Turtle()
t.delay = 0.001
polygon(t, 50, 5)
circle(t, 50)
circle(t, 150)
circle(t, 200)
wait_for_user()