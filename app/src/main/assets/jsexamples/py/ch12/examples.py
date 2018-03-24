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

# Tuple Assignment (p 136)
a = 1
b = 2
a,b = b,a
print a,b # 2 1
try: a,b = 1,2,3
except Exception as e: print e
# too many values to unpack

addr = 'simon@ceo.com'
uname, domain = addr.split('@')
print uname, domain #simon ceo.com

t = divmod(7,3)
print t # 2 1
x, r = divmod(7,3)
print x*3+r # 7

def min_max(t):
	return min(t), max(t)
min, max = min_max({1,4,5,-3,7,3,4})
print min, max, max-min # -3 7 10

# Variable-Length Argument Tuples (p 137)
def printall(*args):
	print args
printall(min, max, max-min) # (-3, 7, 10)

t = (7,3)
try: print divmod(t)
except Exception as e: print e
# divmod expected 2 arguments, got 1
print divmod(*t) # (2, 1) -- scatters the tuple into two arguments

# Lists and Tuples (p 138)
s = 'abc'
t = [0,1]
t2 = [1,2,3]
print zip(s,t) # [('a', 0), ('b', 1)]
print zip(s,t2) # [('a', 1), ('b', 2), ('c', 3)]
print zip('Anne', 'Elk') # [('A', 'E'), ('n', 'l'), ('n', 'k')]
for letter, number in zip(s,t2):
	print number, letter
# 1 a
# 2 b
# 3 c
def has_match(t1, t2):
	for x,y in zip(t1,t2):
		if x==y: return True
	return False
print has_match([1,2,3], [3,1,2]) # False
print has_match([1,2,3], [3,2,1]) # True
for index, element in enumerate('abc'):
	print element, index
# a 0
# b 1
# c 2

# Dictionaries and Tuples
d = {'a':0, 'b':1, 'c':2}
print d.items() # [('a', 0), ('c', 2), ('b', 1)]
d = dict(zip('alex','0325'))
print d # {'a': '0', 'x': '5', 'e': '2', 'l': '3'}
print d.items() # [('a', '0'), ('x', '5'), ('e', '2'), ('l', '3')]
d = dict(zip('abc', range(3)))
print d # {'a': 0, 'c': 2, 'b': 1}
for key,val in d.items():
	print val, key
# 0 a
# 2 c
# 1 b
directory = dict()
directory["George", "Carr"] = "415 123-9090"
directory["Simon", "Carr"] = "650 123-4343"
print directory 
# {('Simon', 'Carr'): '650 123-4343', ('George', 'Carr'): '415 123-9090'}

# Comparing Tuples
print (0, 1, 2) < (0, 3, 4) # True
print (0, 1, 20000) < (0, 3, 4) # True

# DSU: decorate sort undecorate
def sort_by_length(words):
	t = []
	for word in words:
		t.append((len(word), word)) # Decorate
	t.sort(reverse=True) # Sort
	res = []
	for length, word in t:
		res.append(word) # Undecorate
	return res
print sort_by_length(['Alex', 'Carol', 'Simon', 'George'])
# ['George', 'Simon', 'Carol', 'Alex']

# Sequences of Sequences (p 143)
t = ['apple', 'orange', 'carrot', 'banana']
print sorted(t) # ['apple', 'banana', 'carrot', 'orange']
print list(reversed(t)) # ['banana', 'carrot', 'orange', 'apple']

# Debugging (p 143)
from structshape import structshape
t = [1,2,3]
print structshape(t) # list of 3 int
t2 = [[1,2],[3,4],[5,6]]
print structshape(t2) # list of 3 list of 2 int
t3 = [1,2,3,4.0,'5','6',[7],[8],9]
print structshape(t3) # list of (3 int, float, 2 str, 2 list of int, int)

s = 'abc'
lt = zip(t,s)
print lt
print structshape(lt)
# [(1, 'a'), (2, 'b'), (3, 'c')]
# list of 3 tuple of (int, str)

d = dict(lt)
print structshape(d)
# dict of 3 int->str