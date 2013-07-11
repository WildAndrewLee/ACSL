# Testing Git integration in ST3 lulz.

for l in open('INPUT'):
	l=l.rstrip().split(', ')
	if l[0][0]=='D':print(''.join(sorted(l[1][:4]))*2)+' and '+(''.join(sorted(l[1][4:]))*2)
	elif l[0][0]=='U':print(''.join(sorted(l[1][4:])))+(''.join(sorted(l[2][:4])))
	elif l[0][0]=='I':print''.join(sorted(l[1][:2]+l[1][-2:]))+''.join(sorted(l[2][:2]+l[2][-2:]))
	elif l[0][0]=='A':print l[1][:int(l[0][3:])]+''.join(sorted(l[1][:int(l[0][3:])]))+l[1][int(l[0][3:]):8-int(l[0][3:])]
	else:print l[1][int(l[0][8:]):]+''.join(sorted(l[1][-int(l[0][8:]):]))