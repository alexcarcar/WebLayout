# Coordinate Sequences (p 220)
from swampy.Gui import *

g = Gui()
g.title('Coordinate Sequences')

canvas = g.ca(width=500, height=500)
canvas.config(bg='white')
canvas.rectangle([[0,0], [200,100]], fill='blue', outline='orange', width=10)
canvas.oval([[0,0], [200,100]], outline='orange', width=10)
canvas.line([[0,100], [100,200], [200,100]], width=10)
canvas.polygon([[0,100], [100,200], [200,100]], fill='red', outline='orange', width=10)

# More Widgets (p 221)
entry = g.en(text='Default text.')
entry.get()
text = g.te(width=100, height=5)
text.insert(END, 'A line of text.')
text.insert(1.1, 'nother')
text.get(0.0, END)
text.delete(1.2, END)
text.get(0.0, END)
g.mainloop()
