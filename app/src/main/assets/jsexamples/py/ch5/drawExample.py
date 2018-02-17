from swampy.TurtleWorld import *
world = TurtleWorld()

def draw(t, length, n):
	if n == 0:
		return
	angle = 50
	fd(t, length*n)
	lt(t, angle)
	draw(t, length, n-1)
	rt(t, 2*angle)
	draw(t, length, n-1)
	lt(t, angle)
	bk(t, length*n)

t = Turtle()
t.delay = 0.001
for n in range(12):
	draw(t, 10, 5)
	rt(t, 15)

raw_input()
exit()