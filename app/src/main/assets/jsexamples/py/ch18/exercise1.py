# Exercise 18-1 (p 205)
class Time(object):
    """Represents the time of day.

    attributes: hour, minute, second
    """
    def __init__(self, hour=0, minute=0, second=0):
        self.hour = hour
        self.minute = minute
        self.second = second

    def __str__(self):
        return '%.2d:%.2d:%.2d' % (self.hour, self.minute, self.second)

    def __cmp__(self, other):
        t1 = self.hour, self.minute, self.second
        t2 = other.hour, other.minute, other.second
        return cmp(t1, t2)

t1 = Time(9, 45, 00)
t2 = Time(9, 45, 03)
print t1, t2, t1 < t2 # 09:45:00 09:45:03 True
