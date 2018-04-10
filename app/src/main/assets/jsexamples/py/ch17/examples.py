class Time(object):
	"""Represents the time of day."""

	# The init Method (p 192)
	def __init__(self, hour=0, minute=0, second=0):
		(self.hour, self.minute, self.second) = (hour, minute, second)

	# The __str__ Method (p 193)
	def __str__(self):
		return '%.2d:%.2d:%.2d' % (self.hour,self.minute,self.second)

	# Operator Overloading (p 194)
	def __add__(self, other):
		# Type-Based Dispatch (p 195)
		if isinstance(other, Time):
			return self.add_time(other)
		else:
			return self.increment(other)

	# Type Based Dispatch (p 195)
	def __radd__(self, other):
		return self.__add__(other)

	def add_time(self, other):
		seconds = self.time_to_int() + other.time_to_int()
		return int_to_time(seconds)

	def print_time(self):
		print '%.2d:%.2d:%.2d' % (self.hour,self.minute,self.second)

	# Exercise 17-1
	def time_to_int(self):
		minutes = self.hour*60 + self.minute
		seconds = minutes*60 + self.second
		return seconds

	# Another Example (p 191)
	def increment(self, seconds):
		seconds += self.time_to_int()
		return int_to_time(seconds)

	# A More Complicated Example (p 192)
	def is_after(self, other):
		return self.time_to_int() > other.time_to_int()

# Another Example (p 191)
def int_to_time(seconds):
	time = Time()
	minutes, time.second = divmod(seconds, 60)
	time.hour, time.minute = divmod(minutes, 60)
	return time

# Printing Objects (p 190)
start = Time()
(start.hour, start.minute, start.second) = (9, 45, 0)
Time.print_time(start) # 09:45:00
start.print_time() # 09:45:00
print start.time_to_int() # 35100
print Time.time_to_int(start) # 35100
print 9*60*60, 45*60, 0 # 32400 2700 0 // sum = 325100

# Another Example (p 191)
end = start.increment(1337)
end.print_time() # 10:07:17
try: end = start.increment(1337, 460)
except Exception as e: print e # increment() takes exactly 2 arguments (3 given)

# A More Complicated Example (p 192)
print end.is_after(start) # True

# The init Method (p 192)
time = Time()
time.print_time() # 00:00:00
time = Time(9)
time.print_time() # 09:00:00
time = Time(9, 45)
time.print_time() # 09:45:00

# The __str__ Method (p 193)
time = Time(10, 20, 34)
print time # 10:20:34

# Operator Overloading (p 194)
start = Time(9, 45)
duration = Time(1, 35)
print start + duration # 11:20:00

# Type-Based Dispatch (p 195)
print start + duration # 11:20:00
print start + 1337 # 10:07:17
# try: print 1337 + start
# except Exception as e: print e # unsupported operand type(s) for +: 'int' and 'Time'
print 1337 + start # 10:07:17

# Polymorphism (p 196)
def histogram(s):
	d = dict()
	for c in s:
		if c not in d:
			d[c] = 1
		else:
			d[c] += 1
	return d
t = ['spam', 'egg', 'spam', 'spam', 'bacon', 'spam']
print histogram(t) # {'bacon': 1, 'egg': 1, 'spam': 4}

t1 = Time(7, 43)
t2 = Time(7, 41)
t3 = Time(7, 37)
total = sum([t1, t2, t3])
print total # 23:01:00

