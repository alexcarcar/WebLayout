# Exercise 7-1 (p. 78): Rewrite print_n from "Recursion" (p. 54) using iteration

# print_n using "recursion" (p. 54)

def print_n(s, n):
	if n <= 0:
		print ""
		return
	print s,
	print_n(s, n-1)

print_n("test", 3)		# test test test

def print_n_while(s, n):
	while n > 0:
		print s,
		n = n - 1
	print ""

print_n("alex", 5)		# alex alex alex alex alex
