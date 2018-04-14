# GUI (p 217)
from swampy.Gui import *

g = Gui()
g.title('Gui')

# Buttons and Callbacks (p 218)
button = g.bu(text='Press me.')
label = g.la(text='Press the button.')

def make_label():
	g.la(text='Thank you.')

button2 = g.bu(text='No, press me!', command=make_label)
g.mainloop()
