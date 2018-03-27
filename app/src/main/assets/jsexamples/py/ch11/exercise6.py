import time

# Memos (p 128)
known = {0:0, 1:1}
def fibonacci(n):
	if n in known:
		return known[n]
	res = fibonacci(n-1) + fibonacci(n-2)
	known[n] = res
	return res
a = time.clock()
print 30,fibonacci(30), time.clock()-a
a = time.clock()
print 35,fibonacci(35), time.clock()-a
a = time.clock()
print 50,fibonacci(50), time.clock()-a
a = time.clock()
print 100,fibonacci(100), time.clock()-a
a = time.clock()
print 1000,fibonacci(1000), time.clock()-a

def fibNoMemos(n):
	if n == 0: return 0
	if n == 1: return 1
	return fibNoMemos(n-1) + fibNoMemos(n-2)
a = time.clock()
print 30, fibNoMemos(30), time.clock()-a
a = time.clock()
print 35, fibNoMemos(35), time.clock()-a

# 30 832040 0.000356348170226
# 35 9227465 0.000103455920388
# 50 12586269025 0.00020280644711
# 100 354224848179261915075 0.000209785616343
# 1000 43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875 0.00199316862494

# 30 832040 0.438808286327
# 35 9227465 4.87251397887