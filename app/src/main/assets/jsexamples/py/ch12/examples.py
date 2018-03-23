# Tuples are Immutable (p 135)
t = 'a', 'b', 'c', 'd', 'e'
x = (1, 2, 3)
a = 'a',
e = tuple()
print t, x, a, e
print type(t), type(x), type(a), type(e)
# ('a', 'b', 'c', 'd', 'e') (1, 2, 3) ('a',) ()
# <type 'tuple'> <type 'tuple'> <type 'tuple'> <type 'tuple'>

g = tuple('george')
print g # ('g', 'e', 'o', 'r', 'g', 'e')
print g[3] # r
print g[1:3] # ('e', 'o')
print type(g[3]), type(g[1:3]) # <type 'str'> <type 'tuple'>
try: g[0] = 'A'
except Exception as e: print e
# 'tuple' object does not support item assignment
g = ('G',) + g[1:]
print g # ('G', 'e', 'o', 'r', 'g', 'e')