from swampy.TurtleWorld import *
world = TurtleWorld()

def polygon(t, length, n):
	for i in range(n):
		fd(t, length)
		rt(t, 360/n)

t = Turtle()
polygon(t, 50, 5)
polygon(t, 100, 3)
polygon(t, 75, 7)
wait_for_user()