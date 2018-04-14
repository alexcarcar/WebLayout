# Exercise 19-1
from swampy.Gui import *

g = Gui()
g.title('Exercise 19-1')

def make_button2():
	g.bu(text='Second Button', command=make_label)

def make_label():
	g.la(text='Nice job!')

b1 = g.bu(text='First Button', command=make_button2)
g.mainloop()
