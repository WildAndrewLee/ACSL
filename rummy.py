from copy import deepcopy

herpies = open('rummies')

keys = ['S', 'H', 'C', 'D']
vals = ['A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K']

cards = herpies.readline().rstrip().split(', ')
hand = {x: [card[0] for card in cards if card[1] == x] for x in keys}

def sort(priority, lizst):
	dick = {priority.index(x): x for x in lizst}
	return [dick[x] for x in sorted(dick.keys())]

def same(x):
	return len([y for suit in hand for y in hand[suit] if y == x])

def garbage():
	gay = (None, None, None);
	for key in keys:
		if len(hand[key]) < 3:
			for zzz in range(len(hand[key])):
				if same(hand[key][zzz]) < 3:
					if gay[0] == None or vals.index(hand[key][zzz]) < vals.index(gay[0]):
						gay = (hand[key][zzz], key, zzz)

	if gay[0] != None:
		hand[gay[1]].pop(gay[2])

def isRun(card):
	return 1 < len(hand[card[1]]) < 4 and (vals.index(hand[card[1]][0]) - 1 == vals.index(card[0]) or vals.index(hand[card[1]][-1]) + 1 == vals.index(card[0]))

def isSet(card):
	return 1 < same(card[0]) < 4

hand = {thing: sort(vals, hand[thing]) for thing in keys}
backup = deepcopy(hand)

for rest in herpies:
	cards = rest.rstrip().split(', ')
	thingies = 0

	for card in cards:
		if isRun(card) or isSet(card):
			hand[card[1]].append(card[0])
			hand[card[1]] = sort(vals, hand[card[1]])

			garbage()

			thingies += 1

			if thingies == 2:
				break;

	output = ''
	used = []

	for c in range(4, 2, -1):
		output += ''.join([y + x + ', ' for x in hand for y in hand[x] if len(hand[x]) == c])

		for key in keys:
			for x in hand[key]:
				matches = [(qq, zzz) for zzz in hand for qq in hand[zzz] if qq == x and not (qq, zzz) in used]

				if(len(matches) == c):
					used.extend(matches)

					output += ''.join([g + j + ', ' for (g, j) in matches])

	trash = {x: [] for x in vals}
	[trash[y].append(x) for x in keys for y in hand[x] if (not (y, x) in used) and (len(hand[x]) < 3)]

	vals.reverse()

	for key in vals:
		trash[key] = sort(keys, trash[key])

		for derp in trash[key]:
			output += key + derp + ', '

	print (output[:-2])

	hand = deepcopy(backup)
	vals.reverse()