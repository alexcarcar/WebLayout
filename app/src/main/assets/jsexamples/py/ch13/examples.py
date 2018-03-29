# Random Numbers (p 148)import random

import random
for i in range(10):
	x = random.random()
	print x,
# 0.111731158394 0.933590751828 0.677197657821 0.32501260863 0.257776330663
# 0.697285221522 0.261738252042 0.482822595503 0.661214362955 0.824044003515
print

print random.randint(5,10) # 8
print random.randint(5,10) # 10

t = ['alex', 'carol', 'simon', 'george']
print random.choice(t) # george
print random.choice(t) # alex
