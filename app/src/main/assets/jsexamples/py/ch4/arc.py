import math
from swampy.TurtleWorld import *
world = TurtleWorld()

def polygonDegree(t, length, n, degree):
	k = int(round(n*degree/360.0))
	print n
	print k
	for i in range(k):
		fd(t, length)
		rt(t, 360/n)

def polygon(t, length, n):
	for i in range(n):
		fd(t, length)
		rt(t, 360/n)

def circle(t, r):
	arc(t, r, 360)

def arc(t, r, d):
	n = 360
	c = math.pi * r
	l = c/n * d/360
	polygonDegree(t, l, n, d)


t = Turtle()
t.delay = 0.001
polygon(t, 10, 20)
polygonDegree(t, 20, 20, 90)
arc(t, 100, 270)
wait_for_user()