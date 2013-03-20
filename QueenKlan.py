# Andrew Lee
# School Code: 3001
# Freehold High School
# Contest 2
# ACSL Cells
# Senior 5
# Advisor: Mr. Gill
# Language: Python

# NOTE: THIS IMPLEMENTATION ABUSES LIST COMPREHENSIONS <3

# Iterate over each line in the INPUT file.
for line in open('INPUT'):
	# Split the line using ", " as the delimeter.
	coors = line.split(', ');
	# List comprehension to map each pair of points to a tuple. Subtract 2 from the length
	# of "coors" to ignore the ending zeros.
	grid = [(int(coors[n]), int(coors[n + 1])) for n in range(0, len(coors) - 2, 2)]

	# Create a list composed of tuples and then iterate over each tuple.
	for (x, y) in [(x, y) for x in range(1, 9) for y in range(1, 9)]:
		# Once again abuse list comprehensions.
		# Use the all(...) function to make sure the slope of the line containing the current 
		# point (n, p) and the current space (x, y) is either 1, -1, 0, or undefined.
		if all((y - p == 0 or abs(x - n) == abs(y - p) or x - n == 0) for (n, p) in grid):
			# Print the current point and then break out of this endless looping.
			print (str(x) + ', ' + str(y))
			break
	# Use a for...else control to avoid extraneous sentinel values. The else portion of a for...else control 
	# structure will only be executed if the for loop terminates naturally (e.g not using a break)
	else:
		print ('NONE')