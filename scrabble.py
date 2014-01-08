f = open('scrabble')
word = f.readline().rstrip().split(', ')

letters = {x: int(y) for x, y in zip('AEDRBMVYJX', '1122334488')}

for line in f.readlines():
	start = line.rstrip().split(', ')
	points = []

	for s in range(0, 6, 2):
		st = int(start[s])
		point = 0
		multiplier = 1

		for letter in word:
			if not st % 3 and st % 2: point += letters[letter]
			elif not st % 5: point += letters[letter] * 2
			elif not st % 7: multiplier *= 2
			elif not st % 8: multiplier *= 3

			point += letters[letter]
			st += 1 if start[s + 1] == 'H' else 10

		points.append(point * multiplier)

	print(max(points))