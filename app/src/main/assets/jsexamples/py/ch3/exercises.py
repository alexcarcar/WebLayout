# Exercises 3-3
def right_justify(word):
	line_length = 70
	spaces = ' '*(line_length-len(word))
	print spaces+word

right_justify("Alex");
right_justify("Simon");
right_justify("George");
#                                                                  Alex
#                                                                 Simon
#                                                                George

# Exercise 3-4
def do_twice(f, argument):
	f(argument)
	f(argument)
def print_spam(argument):
	print argument 
do_twice(print_spam, 'spam')
# spam
# spam

def do_four(f, argument):
	do_twice(f, argument)
	do_twice(f, argument)
do_four(print_spam, 'four')
# four
# four
# four
# four

# Exercise 3-5
def print_grid(i, j):
	top  = '+--'*i+'+\n'
	side = '|  '*i+'|\n'
	grid = (top + (side)*2)*j+top
	print grid

print_grid(2, 2);
# +--+--+
# |  |  |
# |  |  |
# +--+--+
# |  |  |
# |  |  |
# +--+--+

print_grid(4, 4);
# +--+--+--+--+
# |  |  |  |  |
# |  |  |  |  |
# +--+--+--+--+
# |  |  |  |  |
# |  |  |  |  |
# +--+--+--+--+
# |  |  |  |  |
# |  |  |  |  |
# +--+--+--+--+
# |  |  |  |  |
# |  |  |  |  |
# +--+--+--+--+