from swampy.TurtleWorld import *
world = TurtleWorld()

def drawKosh(t, length, n):
	if n == 0:
		fd(t, length)
		return
	drawKosh(t, length/3, n-1)
	lt(t, 60)
	drawKosh(t, length/3, n-1)
	rt(t, 120)
	drawKosh(t, length/3, n-1)
	lt(t, 60)
	drawKosh(t, length/3, n-1)

t = Turtle()
t.delay = 0.001
drawKosh(t, 100, 3)
t.rt(120)
drawKosh(t, 100, 3)
t.rt(120)
drawKosh(t, 100, 3)
drawKosh(t, 200, 3)
t.rt(150)
drawKosh(t, 200, 3)

raw_input()
exit()