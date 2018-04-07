# Time (p 181)

class Time(object):
    """Represents the time of day.

    attributes: hour, minute, second
    """

time = Time()
time.hour = 11
time.minute = 59
time.second = 30

# Exercises 16-1
def print_time(t):
    print "%.2d:%.2d:%.2d" % (t.hour,t.minute,t.second)

print_time(time) # 11:59:30

# Exercises 16-2
def is_after(t1, t2):
    return t1.hour>t2.hour or (t1.hour==t2.hour and (t1.minute>t2.minute or (t1.minute==t2.minute and t1.second>t2.second)))

time2 = Time()
time2.hour = 11
time2.minute = 59
time2.second = 31
print is_after(time, time2) # False
print is_after(time2, time) # True
print is_after(time2, time2) # False
print is_after(time, time) # False

# Exercise 16-3
def increment(time, seconds):
    time.second += seconds
    if  time.second >= 60:
        m = int(time.second/60)
        time.second -= 60*m
        time.minute += m
    if time.minute >= 60:
        h = int(time.minute/60)
        time.minute -= 60*h
        time.hour += h
print_time(time) # 11:59:30
increment(time, 832033)
print_time(time) # 243:06:43

z = Time()
z.hour = 0
z.minute = 0
z.second = 0
increment(z,832033)
print_time(z) # 231:07:13

# Exercise 16-4
time.hour = 11
time.minute = 59
time.second = 30

import copy
def add_increment(t, seconds):
    time = copy.copy(t)
    time.second += seconds
    if  time.second >= 60:
        m = int(time.second/60)
        time.second -= 60*m
        time.minute += m
    if time.minute >= 60:
        h = int(time.minute/60)
        time.minute -= 60*h
        time.hour += h
    return time

print_time(time) # 11:59:30
t = add_increment(time, 2033)
print_time(t) # 12:33:23
print_time(time) # 11:59:30


# Exercise 16-5

def time_to_int(time):
    minutes = time.hour*60 + time.minute
    seconds = minutes*60 + time.second
    return seconds

def int_to_time(seconds):
    time = Time()
    minutes, time.second = divmod(seconds, 60)
    time.hour, time.minute = divmod(minutes, 60)
    return time

def increment_time(time, seconds):
    print "*****"
    print_time(time)
    print seconds
    print "*****"
    return int_to_time(time_to_int(time) + seconds)

t1 = Time()
t1.hour = 3
t1.minute = 14
t1.second = 25
t2 = increment_time(t1, 543)
print_time(t1)
print_time(t2)
print time_to_int(t2) - time_to_int(t1)

# *****
# 03:14:25
# 543
# *****
# 03:14:25
# 03:23:28
# 543

