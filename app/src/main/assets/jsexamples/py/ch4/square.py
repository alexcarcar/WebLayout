from swampy.TurtleWorld import *
world = TurtleWorld()

def square(t, size):
	for i in range(4):
		fd(t, size)
		rt(t)

bob = Turtle()
square(bob, 50)
# wait_for_user()