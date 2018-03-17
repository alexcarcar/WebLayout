# Basics (p 121)
eng2sp = dict()
print eng2sp # {}
eng2sp['one'] = 'uno'
print eng2sp # {'one': 'uno'}

eng2sp = { # stored in a different order...
	'one':'uno',
	'two':'dos',
	'three':'tres'
}
print eng2sp # {'three': 'tres', 'two': 'dos', 'one': 'uno'}
print eng2sp['two'] # dos
try:
	print eng2sp['four'] 
except Exception as e:
	print "KeyError: " + str(e) # KeyError: 'four'
print len(eng2sp) # 3
print 'one' in eng2sp # True (matches the keys)
print 'uno' in eng2sp # False

vals = eng2sp.values()
print 'uno' in vals # True

# Dictionary as a Set of Counters: (p 123)