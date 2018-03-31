# Reading and Writing (p 159)
fout = open('output.txt', 'w')
print fout # <open file 'output.txt', mode 'w' at 0x012F6230>
line1 = "This here's the wattle,\n"
fout.write(line1)
line2 = "the emblem of our land.\n"
fout.write(line2)
fout.close()

fin = open('output.txt')
for line in fin: print line.strip()
fin.close()
# This here's the wattle,
# the emblem of our land.

# Format Operator (p 160)
x = 52
f = open('output.txt', 'w')
f.write(str(x))
f.close()
f = open('output.txt')
for line in f: print line.strip()
f.close()
# 52

camels = 42
res =  'I have spotted %d camels.' % camels
print res # I have spotted 42 camels.
res = 'In %d years I have spotted %g %s.' % (3, 0.1, 'camels')
print res # In 3 years I have spotted 0.1 camels.

try: res = '%d %d %d' % (1, 2)
except Exception as e: print e # not enough arguments for format string

try: res = '%d' % 'dollars'
except Exception as e: print e # %d format: a number is required, not str

# Filenames and Paths (p 161)
import os
cwd = os.getcwd()
print cwd # C:\py\ch14
print os.path.abspath('output.txt') # C:\py\ch14\output.txt
print os.path.exists('output.txt') # True
print os.path.exists('fakeoutput.txt') # False
print os.path.isdir('output.txt') # False
print os.path.isdir('.') # True
print os.listdir(cwd) # ['examples.py', 'exercises.py', 'index.html', 'output.txt']

def walk(dirname):
	for name in os.listdir(dirname):
		path = os.path.join(dirname,name)
		if os.path.isfile(path):
			print path
		else:
			walk(path)
walk(".")
# .\examples.py
# .\exercises.py
# .\index.html
# .\output.txt

# Catching Exceptions (p 162)
try:
	fin = open('bad_file')
	for line in fin:
		print line
	fin.close()
except:
	print 'Something went wrong.'
# Something went wrong.

# Databases (p 163)
import anydbm
db = anydbm.open('captions.db', 'c') # 'c' means to create if it doesn't exist
db['cleese.png'] = 'Photo of John Cleese.'
print db['cleese.png']
db['cleese.png'] = 'Photo of John Cleese doing a silly walk.'
print db['cleese.png']
for key in db:
	print key
db.close()
# Photo of John Cleese.
# Photo of John Cleese doing a silly walk.
# cleese.png