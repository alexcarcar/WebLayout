from swampy.TurtleWorld import *
world = TurtleWorld()

simon = Turtle()
print simon

for j in range(4):
	for i in range(4):
		fd(simon, 15*(j+1))
		lt(simon)

fd(simon, 100)
lt(simon)
fd(simon, 82)
lt(simon)
fd(simon, 28)
rt(simon)
fd(simon, 50)
rt(simon)
fd(simon, 60)

for i in range(4):
	print 'Hello!'

wait_for_user()
exit()