# Exercise 2: 
# - Add a parameter length to square
# - Test with a range of values

from swampy.TurtleWorld import *
world = TurtleWorld()

def square(t, length):
	for i in range(4):
		fd(t, length)
		rt(t)

bob = Turtle()
square(bob, 50)

simon = Turtle()
square(simon, 100)

george = Turtle()
square(george, 75)
wait_for_user()