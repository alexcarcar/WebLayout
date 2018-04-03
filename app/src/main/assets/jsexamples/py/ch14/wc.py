def linecount(filename):
	count = 0
	for line in open(filename):
		count += 1
	return count

if __name__ == '__main__': # only is printed if not imported
	print linecount('wc.py')
