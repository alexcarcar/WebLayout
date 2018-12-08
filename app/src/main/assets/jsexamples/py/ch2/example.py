# ========================================================================================
# Values and Types (page 13)
print type('Hello, World!') # <type 'str'>
print type(17) # <type 'int'>
print type(3.2) # <type 'float'>
print type('17') # <type 'str'>
print 1,000,000 # 1 0 0

# ========================================================================================
# Variables (p 14)
message = 'And now for something completely different'
n = 17
pi = 3.1415926535897932
print type(message) # <type 'str'>
print type(n) # <type 'int'>
print type(pi) # <type 'float'>

# ========================================================================================
# Octal numbers (p 14) are preceded with a 0 (and do not allow 8 and 9 digits)
# For example, "zipcode = 02492" creates an invalid token error
zipcode = 02132 
# "octal number" = 2*512 + 1*64 + 3*8 + 2*1 = 1024 + 64 + 24 + 2 = 1024 + 90 = 1114
print zipcode # 1114
print (01, 010, 0100, 01000) # (1, 8, 64, 512)
print (02000, 0100, 030, 02) # (1024, 64, 24, 2)
print '02132' # 02132 (value treated as a string)

# ========================================================================================
# Operators and Operands (page 16)
hour = 5; minute = 32;
print (20+32, hour*60+minute, minute/60.0, 5**2, (5+9)*(15-7))  # 5**2 (** = exponent operator)
# (52, 332, 0.5333333333333333, 25, 112)
# integer/floating-point division:
print (minute/60, minute/60.0) # (0, 0.5333333333333333)

# ========================================================================================
# String Operations (page 18)
first = "Simon"
second = "George"
print first+second # SimonGeorge
print 3*second # GeorgeGeorgeGeorge

# ========================================================================================
# Exercise 2.3 (page 21)
width = 17; height = 12.0; delimiter = '.';
print(width/2, width/2.0, height/3, 1+2*5, delimiter*5); # (8, 8.5, 4.0, 11, '.....')

# ========================================================================================
# Exercise 2.4.1 (page 22)
r = 5; V = 4/3 * 3.14159 * r**3
print V # 392.69875

# ========================================================================================
# Exercise 2.4.2 (page 22)
price = 24.95; discount = 0.40; shippingBook1 = 3.00; shippingOther = 0.75; copies = 60
wholesale = price*(1-discount)*copies + shippingBook1 + shippingOther*(copies-1)
print wholesale # 945.45

# ========================================================================================
# Exercise 2.4.3 (page 22)
sH = 6; sM = 52; # start 6:52
eM = 8; eS = 15; # easy pace 8:15 / mile
tM = 7; tS = 12; # tempo pace 7:12 / mile

minutes = int (sM + eM*2 + eS*2/60.0 + sM*3.0 + tS*3/60.0)
fH = sH + minutes/60
fM = minutes%60
print (fH, fM) # (9, 45) ... back home at 9:45 AM
exit()
