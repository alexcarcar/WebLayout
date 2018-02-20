def first(word):
	return word[0]
	
def last(word):
	return word[-1]

def middle(word):
	return word[1:-1]

print(first("Apple"), middle("Apple"), last("Apple"))	# ('A', 'ppl', 'e')
print(first("AB"), middle("AB"), last("AB"))			# ('A', '', 'B')
#print(first(""), middle(""), last(""))					# IndexError: string index out of range

def reverse(word):
	return word[::-1]

def is_palindrome(word):
	l = len(word)
	if l<2:
		return True
	w1 = word[0:int(l/2)]
	w2 = reverse(word[int((l+1)/2):])
	return w1 == w2

print is_palindrome("apple")		# False
print is_palindrome("abba")			# True
print is_palindrome("redivider")	# True
print is_palindrome("noon")			# True
print is_palindrome("palindrome")	# False
