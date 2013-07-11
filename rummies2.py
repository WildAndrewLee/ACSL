keys = ['D', 'C', 'H', 'S']
vals = ['A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K']

thing = open('rummies')
first = thing.readline()

split = lambda q: [(x[0], x[1]) for x in q.rstrip().split(', ')]
same = lambda x: [(y, suit) for suit in hand for y in hand[suit] if y == x]
isSet = lambda card: 1 < len(same(card[0])) < 4
isRun = lambda card, hand: 1 < len(hand[card[1]]) < 4 and inRange(card)

def inRange(card):
	cards = [vals.index(x) for x in hand[card[1]]]

	for x in range(len(cards) - 1):
		if vals.index(card[0]) == cards[x] + 1 == cards[x + 1] - 2:
			return True
		if cards[x] + 1 != cards[x + 1]:
			break
	else:
		return cards[0] - 1 == vals.index(card[0]) or cards[-1] + 1 == vals.index(card[0])


def numerize(lizst):
	dic = {vals.index(x): x for x in lizst}
	return [dic[x] for x in sorted(dic.keys())]

def sort(lizst):
	dic = {x: [] for x in keys}
	[dic[x[1]].append(x[0]) for x in lizst]
	return {x: numerize(dic[x]) for x in keys}

def garbage(hand):
	x = [(y, x) for x in keys for y in hand[x] if len(hand[x]) < 3 and len(same(y)) < 3]

	hand[min(x, key = lambda x: vals.index(x[0]))[1]].pop(0)
	return hand

for line in thing:
	hand = sort(split(first))
	cards = split(line)

	for card in cards:
		if isRun(card, hand) or isSet(card):
			hand[card[1]].append(card[0])
			hand = {x: numerize(hand[x]) for x in hand}
			garbage(hand)

	output = ''

	for c in range(4, 2, -1):
		output += ''.join([y + x + ', ' for x in hand for y in hand[x] if len(hand[x]) == c])

		for (x, key) in [(x, key) for key in hand for x in hand[key]]:
			if len(same(x)) == c:
				for z in same(x):
					output += z[0] + z[1] + ', '
					hand[z[1]].remove(z[0])

	vals.reverse()
	trash = {x: [] for x in vals}

	keys.reverse()
	[trash[y].append(x) for x in keys for y in hand[x] if not (len(same(y)) > 2 or len(hand[x]) > 2)]
	output += ''.join(x + key + ', ' for x in vals for key in keys if key in trash[x])

	print(output[:-2])
	vals.reverse()
	keys.reverse()