class Kangaroo(object):
	"""Represents a kangaroo.

	attributes: pouch_contents
	"""
	def __init__(self):
		self.pouch_contents = []

	def put_in_pouch(self, item):
		self.pouch_contents.append(item)

	def __str__(self):
		s = "["
		for i in self.pouch_contents:
			s += str(i) + " "
		s += "]"
		return s

kanga = Kangaroo()
roo = Kangaroo()

kanga.put_in_pouch(roo)
print kanga # [[] ]
print roo # []