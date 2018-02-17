import math
from swampy.TurtleWorld import *
world = TurtleWorld()

def polyline(t, n, length, angle):
	"""Draws n line segments with the given length and
	angle (in degrees) between them.  t is a turtle
	"""
	for i in range(n):
		fd(t, length)
		lt(t, angle)

def polygon(t, n, length):
	angle = 360.0 / n
	polyline(t, n, length, angle)

def arc(t, r, angle):
	arc_length = 2 * math.pi * r * angle / 360
	n = int(arc_length/3) + 1
	step_length = arc_length / n
	step_angle = float(angle) /n
	polyline(t, n, step_length, step_angle)

def circle(t, r):
	arc(t, r, 360)

t = Turtle()
t.delay = 0.01
arc(t,50,90)
polygon(t,10,20)
circle(t,25)
wait_for_user()