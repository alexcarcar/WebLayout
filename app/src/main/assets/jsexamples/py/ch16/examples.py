# Time (p 181)

class Time(object):
	"""Represents the time of day.

	attributes: hour, minute, second
	"""

time = Time()
time.hour = 11
time.minute = 59
time.second = 30

def print_time(t):
    print "%.2d:%.2d:%.2d" % (t.hour,t.minute,t.second)

def is_after(t1, t2):
    return t1.hour>t2.hour or (t1.hour==t2.hour and (t1.minute>t2.minute or (t1.minute==t2.minute and t1.second>t2.second)))

# Pure Functions (p 182)

def add_time(t1, t2):
	sum = Time()
	sum.hour = t1.hour + t2.hour
	sum.minute = t1.minute + t2.minute
	sum.second = t1.second + t2.second

	if sum.second >= 60:
		sum.second -= 60
		sum.minute += 1

	if sum.minute >= 60:
		sum.minute -= 60
		sum.hour += 1

	return sum

start = Time()
start.hour = 9
start.minute = 45
start.second = 0

duration = Time()
duration.hour = 1
duration.minute = 35
duration.second = 0

done = add_time(start, duration)
print_time(done) # 11:20:00

def time_to_int(time):
	minutes = time.hour*60 + time.minute
	seconds = minutes*60 + time.second
	return seconds

def int_to_time(seconds):
	time = Time()
	minutes, time.second = divmod(seconds, 60)
	time.hour, time.minute = divmod(minutes, 60)
	return time

def add_time2(t1, t2):
	seconds = time_to_int(t1) + time_to_int(t2)
	return int_to_time(seconds)

print_time(add_time2(start, duration)) # 11:20:00

# Debugging (p 185)

def valid_time(time):
	if time.hour < 0 or time.minute < 0 or time.second < 0:
		return False
	if time.minute > 60 or time.second > 60:
		return False
	return True

def add_valid_time(t1, t2):
	if not valid_time(t1) or not valid_time(t2):
		raise ValueError, 'invalid Time object in add_valid_time'
	seconds = time_to_int(t1) + time_to_int(t2)
	return int_to_time(seconds)

def add_assert_time(t1, t2):
	assert valid_time(t1) and valid_time(t2)
	seconds = time_to_int(t1) + time_to_int(t2)
	return int_to_time(seconds)

t1 = Time()
(t1.hour, t1.minute, t1.second) = (3, 15, 54)

t2 = Time()
(t2.hour, t2.minute, t2.second) = (3, 500, 54)

try: add_valid_time(t1, t2)
except Exception as e: print e # invalid Time object in add_valid_time

try: add_assert_time(t1, t2)
except Exception as e: print e
