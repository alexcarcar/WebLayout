# Function Calls (page 23)
print(type(32)) # <type 'int'>
print(int('32')) # 32
# print (int('Hello'))
# ValueError: invalid literal for int() with base 10: 'Hello'
print(int(3.99999), round(3.99999), int(-2.3)) # (3, 4.0, -2)
print(float(32), float('3.14159')) # (32.0, 3.14159)
print(str(32), str(3.14159), str(7)+":"+str(32)) # ('32', '3.14159', '7:32')

# Math Functions (page 24)
import math
print math # <module 'math' (built-in)>
print round # <built-in function round>
signal_power = 65.3; noise_power = 793.2;
ratio = signal_power / noise_power
decibels = 10 * math.log10(ratio)
print(ratio, decibels) # (0.0823247604639435, -10.844695242581912)
radians = 0.7; height = math.sin(radians);
print height; # 0.644217687238
degrees = 45; radians = degrees / 360.0 * 2 * math.pi
print math.sin(radians); # 0.707106781187
print math.sqrt(2) / 2.0; # 0.707106781187

# Adding New Functions (page 25)
def print_lyrics():
	print "I'm a lumberjack, and I'm okay."
	print "I sleep all night and I work all day."

print_lyrics();
# I'm a lumberjack, and I'm okay.
# I sleep all night and I work all day.

def repeat_lyrics():
	print_lyrics();
	print_lyrics();

repeat_lyrics();
# I'm a lumberjack, and I'm okay.
# I sleep all night and I work all day.
# I'm a lumberjack, and I'm okay.
# I sleep all night and I work all day.

# Parameters and Arguments (page 28)
def print_twice(bruce):
	print bruce
	print bruce

print_twice('Spam '+str(17)+' '+str(math.pi));
# Spam 17 3.14159265359
# Spam 17 3.14159265359

# Variables and Parameters Are Local (page 29)
def cat_twice(part1, part2):
	cat = part1 + part2
	print_twice(cat)
line1 = 'Bing tiddle '
line2 = 'tiddle bang.'
cat_twice(line1, line2)
# Bing tiddle tiddle bang.
# Bing tiddle tiddle bang.

result = print_twice('Bing')
# Bing
# Bing
print(result) # None
print(type(None)) # <type 'NoneType'>

# Importing with "from"
from math import pi
print pi # 3.14159265359

from math import *
print cos(pi) # -1.0

exit()