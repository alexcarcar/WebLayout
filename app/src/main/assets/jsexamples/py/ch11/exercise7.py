# Ackerman function A(m,n)
def ack(m,n):
	if m == 0:
		return n+1
	if m>0 and n==0:
		return ack(m-1,1)
	elif m>0 and n>0:
		return ack(m-1, ack(m, n-1))

print ack(3,4) # 125
print ack(3,6) # 509 (larger numbers exhaust recursion stack)

# Memos (p 128)
known = {}
def ackMemo(m,n):
	k = str(m)+","+str(n)
	if k in known:
		return known[k]

	if m == 0:
		ans = n+1
		known[k] = ans
		return ans
	if m>0 and n==0:
		ans = ackMemo(m-1,1)
		known[k] = ans
		return ans
	elif m>0 and n>0:
		ans = ackMemo(m-1, ackMemo(m, n-1))
		known[k] = ans
		return ans

print ackMemo(3,7) # 1021
print ackMemo(3,8) # 2045
