# Reading Word Lists (p 97)
fin = open('words.txt')
print fin					# <open file 'words.txt', mode 'r' at 0x01296230>
print fin.readline()		# aa
print fin.readline()		# aah
line = fin.readline()
word = line.strip()
print word 					# aahed
fin.close()
