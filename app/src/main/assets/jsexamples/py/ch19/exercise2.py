# Exercise 19-2
from swampy.Gui import *

g = Gui()
g.title('Exercise 19-2')

canvas = g.ca(width=500, height=500)
canvas.config(bg='white')
def draw_circle():
	item = canvas.circle([0,0], 100, fill='red')
	item.config(fill='yellow', outline='orange', width=10)

b1 = g.bu(text='Button', command=draw_circle)
g.mainloop()