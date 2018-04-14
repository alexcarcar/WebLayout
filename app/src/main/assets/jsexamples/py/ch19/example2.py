# Canvas Widgets (p 219)
from swampy.Gui import *

g = Gui()
g.title('Canvas Widgets')

canvas = g.ca(width=500, height=500)
canvas.config(bg='white')
item = canvas.circle([0,0], 100, fill='red')
item.config(fill='yellow', outline='orange', width=10)
g.mainloop()
