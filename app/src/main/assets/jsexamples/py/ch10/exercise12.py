# Exercise 12: find all palendrones
def is_reverse(x):
	word = str(x)
	reverse = word[::-1]
	return word == reverse

fin = open('../ch9/words.txt')
for line in fin:
	word = line.strip()
	if is_reverse(word):
		print word,
fin.close()

# aa aba aga aha ala alula ama ana anna ava awa bib bob boob bub civic dad deed
# deified deked deled denned dewed did dud eke eme ere eve ewe eye gag gig hah
# halalah hallah huh kaiak kayak keek kook level madam marram mem mim minim mom
# mum noon nun oho otto pap peep pep pip poop pop pup radar redder refer reifier
# repaper reviver rotator rotor sagas sees selles sememes semes seres sexes shahs
# sis solos sos stets tat tenet terret tit toot tot tut vav waw wow yay