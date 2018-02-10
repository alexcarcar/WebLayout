# Values and Types (page 13)
print type('Hello, World!')
print type(17)
print type(3.2)
print type('17')
print 1,000,000

# <type 'str'>
# <type 'int'>
# <type 'float'>
# <type 'str'>
# 1 0 0

# Variables (p 14)
message = 'And now for something completely different'
n = 17
pi = 3.1415926535897932
print type(message)
print type(n)
print type(pi)
# <type 'str'>
# <type 'int'>
# <type 'float'>

#zipcode = 02492
#  File "example.py", line 21
#    zipcode = 02492
#                  ^
#SyntaxError: invalid token

zipcode = 02132 
# "octal number" = 2*512 + 1*64 + 3*8 + 2*1 = 1024 + 64 + 24 + 2 = 1024 + 90 = 1114
print (01, 010, 0100, 01000)
print (02000, 0100, 030, 02)
print '02132'
print zipcode
# (1, 8, 64, 512)
# (1024, 64, 24, 2)
# 02132
# 1114

# Operators and Operands (page 16)
hour = 5; minute = 32;
print (20+32, hour*60+minute, minute/60.0, 5**2, (5+9)*(15-7))
# (52, 332, 0.5333333333333333, 25, 112)

# integer/floating-point division:
print (minute/60, minute/60.0) # (0, 0.5333333333333333)

# String Operations (page 18)
first = "Simon"
second = "George"
print first+second # SimonGeorge
print 3*second # GeorgeGeorgeGeorge

# Exercise 2.3 (page 21)
width = 17; height = 12.0; delimiter = '.';
print(width/2, width/2.0, height/3, 1+2*5, delimiter*5); # (8, 8.5, 4.0, 11, '.....')

# Exercise 2.4 (page 22)
r = 5; V = 4/3 * 3.14159 * r**3
print V # 392.69875

price = 24.95; discount = 0.40; shippingBook1 = 3.00; shippingOther = 0.75; copies = 60
wholesale = price*(1-discount)*copies + shippingBook1 + shippingOther*(copies-1)
print wholesale # 945.45

sH = 6; sM = 52; # start 6:52
eM = 8; eS = 15; # easy pace 8:15 / mile
tM = 7; tS = 12; # tempo pace 7:12 / mile

minutes = int (sM + eM*2 + eS*2/60.0 + sM*3.0 + tS*3/60.0)
fH = sH + minutes/60
fM = minutes%60
print (fH, fM) # (9, 45) ... back home at 9:45 AM
exit()

