/**
 *
 * To solve this problem, we model the state of the problem as a combination of visited positions,
 * current position and battery left. 
 * 
 * The goal test, corresponding to the two questions, are EmtpyBatteryGoalTest and MapCoveringGoalTest.
 * 
 * The search algorithm used is A* Graph Search with UnvisitedPositionHeuristic, which simply count the 
 * number of unvisited positions. Another alternative heuristic is ClosestUnvisitedHeuristic which on top
 * of the number of unvisited positions, add the distance from current position to the closest unvisited
 * position. Shortest distance between all pairs of positions are pre-computed on the first run. 
 *
 *A* graph search on Mars with 20 battery life, ClosestUnvisitedHeuristic
	0: start
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, c, 1, 0, 1]
	[1, 1, 0, 0, 0, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 1 battery left: 20
	
	1: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, 0, c, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 2 battery left: 19
	
	2: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, c, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 3 battery left: 18
	
	3: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, c, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 4 battery left: 17
	
	4: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, v, c, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 4 battery left: 16
	
	5: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, c, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 5 battery left: 15
	
	6: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, v, c, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 6 battery left: 14
	
	7: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, v, v, 0, 0, 1]
	[1, 1, 1, 1, c, 1, 1, 1]
	visited: 7 battery left: 13
	
	8: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, v, c, 0, 0, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 7 battery left: 12
	
	9: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, v, v, c, 0, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 8 battery left: 11
	
	10: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, v, v, v, c, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 9 battery left: 10
	
	11: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, c, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 10 battery left: 9
	
	12: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, c, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 11 battery left: 8
	
	13: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, c, 0]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 12 battery left: 7
	
	14: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, c, v, 0]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 13 battery left: 6
	
	15: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, c, 1, 1]
	[0, 0, 1, 1, 1, v, v, 0]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 14 battery left: 5
	
	16: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, c, 0, 1]
	[1, 0, 1, 0, 1, v, 1, 1]
	[0, 0, 1, 1, 1, v, v, 0]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 15 battery left: 4
	
	17: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, c, v, 0, 1]
	[1, 0, 1, 0, 1, v, 1, 1]
	[0, 0, 1, 1, 1, v, v, 0]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 16 battery left: 3
	
	18: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, c, 1, 1, 1]
	[1, 1, 0, 0, v, v, 0, 1]
	[1, 0, 1, 0, 1, v, 1, 1]
	[0, 0, 1, 1, 1, v, v, 0]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 17 battery left: 2
	
	19: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, v, 1, 1, 1]
	[1, 1, 0, 0, c, v, 0, 1]
	[1, 0, 1, 0, 1, v, 1, 1]
	[0, 0, 1, 1, 1, v, v, 0]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 17 battery left: 1
	
	20: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, v, 1, 1, 1]
	[1, 1, 0, c, v, v, 0, 1]
	[1, 0, 1, 0, 1, v, 1, 1]
	[0, 0, 1, 1, 1, v, v, 0]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 18 battery left: 0
	
	Search: 1154 bff: 640
	
	A* graph search on Mars with 20 battery life, UnvisitedPositionHeuristic
	0: start
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, c, 1, 0, 1]
	[1, 1, 0, 0, 0, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 1 battery left: 20
	
	1: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, 0, c, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 2 battery left: 19
	
	2: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, c, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 3 battery left: 18
	
	3: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, v, v, 1, 0, 1]
	[1, 1, 1, c, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 4 battery left: 17
	
	4: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, v, v, 1, 0, 1]
	[1, 1, 1, v, c, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 5 battery left: 16
	
	5: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, v, v, 1, 0, 1]
	[1, 1, 1, v, v, 0, 0, 1]
	[1, 1, 1, 1, c, 1, 1, 1]
	visited: 6 battery left: 15
	
	6: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, v, v, 1, 0, 1]
	[1, 1, 1, v, c, 0, 0, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 6 battery left: 14
	
	7: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, v, v, 1, 0, 1]
	[1, 1, 1, v, v, c, 0, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 7 battery left: 13
	
	8: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, v, v, 1, 0, 1]
	[1, 1, 1, v, v, v, c, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 8 battery left: 12
	
	9: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, v, v, 1, c, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 9 battery left: 11
	
	10: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, c, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 10 battery left: 10
	
	11: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, c, 0]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 11 battery left: 9
	
	12: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, v, c]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 12 battery left: 8
	
	13: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, c, v]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 12 battery left: 7
	
	14: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, c, v, v]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 13 battery left: 6
	
	15: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, c, 1, 1]
	[0, 0, 1, 1, 1, v, v, v]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 14 battery left: 5
	
	16: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, c, 0, 1]
	[1, 0, 1, 0, 1, v, 1, 1]
	[0, 0, 1, 1, 1, v, v, v]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 15 battery left: 4
	
	17: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, c, v, 0, 1]
	[1, 0, 1, 0, 1, v, 1, 1]
	[0, 0, 1, 1, 1, v, v, v]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 16 battery left: 3
	
	18: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, c, v, v, 0, 1]
	[1, 0, 1, 0, 1, v, 1, 1]
	[0, 0, 1, 1, 1, v, v, v]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 17 battery left: 2
	
	19: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, v, v, v, 0, 1]
	[1, 0, 1, c, 1, v, 1, 1]
	[0, 0, 1, 1, 1, v, v, v]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 18 battery left: 1
	
	20: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, c, v, v, 0, 1]
	[1, 0, 1, v, 1, v, 1, 1]
	[0, 0, 1, 1, 1, v, v, v]
	[1, 0, 0, 1, v, 1, v, 1]
	[1, 1, 0, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 18 battery left: 0
	
	Search: 1414 bff: 624
	
	A-star graph search on Mars for full coverage, UnvisitedPositionHeuristic
	0: start
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, c, 1, 0, 1]
	[1, 1, 0, 0, 0, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 1 battery left: 0
	
	1: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, 0, c, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 2 battery left: -1
	
	2: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, 0, c, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 3 battery left: -2
	
	3: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, 0, 1, v, 1, 0, 1]
	[1, 1, c, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 4 battery left: -3
	
	4: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, 0, c, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 5 battery left: -4
	
	5: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, 0, 1, 1, 1, 0, 0, 0]
	[1, c, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 6 battery left: -5
	
	6: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[0, c, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 7 battery left: -6
	
	7: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[c, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 8 battery left: -7
	
	8: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, 0, 1, 0, 1, 0, 1, 1]
	[v, c, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 8 battery left: -8
	
	9: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, c, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 9 battery left: -9
	
	10: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, c, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 9 battery left: -10
	
	11: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, c, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 9 battery left: -11
	
	12: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, c, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 9 battery left: -12
	
	13: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, c, v, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 9 battery left: -13
	
	14: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, c, v, 1, 0, 1]
	[1, 1, 1, 0, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 9 battery left: -14
	
	15: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, c, 0, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 10 battery left: -15
	
	16: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, v, c, 0, 0, 1]
	[1, 1, 1, 1, 0, 1, 1, 1]
	visited: 11 battery left: -16
	
	17: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, v, v, 0, 0, 1]
	[1, 1, 1, 1, c, 1, 1, 1]
	visited: 12 battery left: -17
	
	18: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, v, c, 0, 0, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 12 battery left: -18
	
	19: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, v, v, c, 0, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 13 battery left: -19
	
	20: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, 0, 1]
	[1, 1, 1, v, v, v, c, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 14 battery left: -20
	
	21: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, 0, 1]
	[1, 1, v, v, v, 1, c, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 15 battery left: -21
	
	22: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, 0, 0]
	[1, v, v, 1, v, 1, c, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 16 battery left: -22
	
	23: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, c, 0]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 17 battery left: -23
	
	24: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, v, c]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 18 battery left: -24
	
	25: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, 0, c, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 18 battery left: -25
	
	26: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, 0, 1, 1]
	[v, v, 1, 1, 1, c, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 19 battery left: -26
	
	27: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, 0, 0, 1]
	[1, v, 1, 0, 1, c, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 20 battery left: -27
	
	28: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, c, 0, 1]
	[1, v, 1, 0, 1, v, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 21 battery left: -28
	
	29: Move {deltaY=1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, v, c, 1]
	[1, v, 1, 0, 1, v, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 22 battery left: -29
	
	30: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, 0, c, v, 1]
	[1, v, 1, 0, 1, v, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 22 battery left: -30
	
	31: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, 0, 1, 1, 1]
	[1, 1, 0, 0, c, v, v, 1]
	[1, v, 1, 0, 1, v, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 23 battery left: -31
	
	32: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, c, 1, 1, 1]
	[1, 1, 0, 0, v, v, v, 1]
	[1, v, 1, 0, 1, v, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 24 battery left: -32
	
	33: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, v, 1, 1, 1]
	[1, 1, 0, 0, c, v, v, 1]
	[1, v, 1, 0, 1, v, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 24 battery left: -33
	
	34: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, v, 1, 1, 1]
	[1, 1, 0, c, v, v, v, 1]
	[1, v, 1, 0, 1, v, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 25 battery left: -34
	
	35: Move {deltaY=0, deltaX=1}
	
	[1, 1, 1, 1, v, 1, 1, 1]
	[1, 1, 0, v, v, v, v, 1]
	[1, v, 1, c, 1, v, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 26 battery left: -35
	
	36: Move {deltaY=0, deltaX=-1}
	
	[1, 1, 1, 1, v, 1, 1, 1]
	[1, 1, 0, c, v, v, v, 1]
	[1, v, 1, v, 1, v, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 26 battery left: -36
	
	37: Move {deltaY=-1, deltaX=0}
	
	[1, 1, 1, 1, v, 1, 1, 1]
	[1, 1, c, v, v, v, v, 1]
	[1, v, 1, v, 1, v, 1, 1]
	[v, v, 1, 1, 1, v, v, v]
	[1, v, v, 1, v, 1, v, 1]
	[1, 1, v, v, v, 1, v, 1]
	[1, 1, 1, v, v, v, v, 1]
	[1, 1, 1, 1, v, 1, 1, 1]
	visited: 27 battery left: -37
	
	
	A-star graph search on Mars for full coverage, ClosestUnvisitedHeuristic
	N/A
 */
public class MarsDemo {

    public static void demo_asgs_closest() {
        System.out.println();
        System.out.println("A* graph search on Mars with 20 battery life, ClosestUnvisitedHeuristic");

        Exploration initialConfiguration = new Exploration(new Position(4, 4), 20);

        search.GoalTest goalTest = new EmptyBatteryGoalTest();
        Frontier bff = new BestFirstFrontier(new AStarFunction(new ClosestUnvisitedHeuristic()));
        Search gs = new GraphSearch(bff);
        Node solution = gs.findSolution(initialConfiguration, goalTest);
        new ExplorationPrinting().printSolution(solution);
        System.out.println("Search: " + gs.maxNodeCount() + " bff: " + bff.maxNodeCount());
    }

    public static void demo_asgs_count() {
        System.out.println();
        System.out.println("A* graph search on Mars with 20 battery life, UnvisitedPositionHeuristic");

        Exploration initialConfiguration = new Exploration(new Position(4, 4), 20);

        search.GoalTest goalTest = new EmptyBatteryGoalTest();
        Frontier bff = new BestFirstFrontier(new AStarFunction(new UnvisitedPositionHeuristic()));
        Search gs = new GraphSearch(bff);
        Node solution = gs.findSolution(initialConfiguration, goalTest);
        new ExplorationPrinting().printSolution(solution);
        System.out.println("Search: " + gs.maxNodeCount() + " bff: " + bff.maxNodeCount());
    }

    public static void demo_asgs_cover_map() {
        System.out.println();
        System.out.println("A-star graph search on Mars for full coverage, UnvisitedPositionHeuristic");

        Exploration initialConfiguration = new Exploration(new Position(4, 4), 0);

        search.GoalTest goalTest = new MapCoveringGoalTest();
        Frontier bff = new BestFirstFrontier(new AStarFunction(new UnvisitedPositionHeuristic()));
        Search gs = new GraphSearch(bff);
        Node solution = gs.findSolution(initialConfiguration, goalTest);
        new ExplorationPrinting().printSolution(solution);
    }
    
    public static void demo_asgs_cover_map_closest() {
        System.out.println();
        System.out.println("A-star graph search on Mars for full coverage, ClosestUnvisitedHeuristic");

        Exploration initialConfiguration = new Exploration(new Position(4, 4), 0);

        search.GoalTest goalTest = new MapCoveringGoalTest();
        Frontier bff = new BestFirstFrontier(new AStarFunction(new ClosestUnvisitedHeuristic()));
        Search gs = new GraphSearch(bff);
        Node solution = gs.findSolution(initialConfiguration, goalTest);
        new ExplorationPrinting().printSolution(solution);
    }


    public static void main(String[] args) {
        demo_asgs_closest();
        demo_asgs_count();
        demo_asgs_cover_map();
        demo_asgs_cover_map_closest();
    }
}


package mars;

import search.Node;
import search.NodeFunction;

import java.util.Set;

public class ClosestUnvisitedHeuristic implements NodeFunction {
    @Override
    public int compute(Node n) {
        int count = new UnvisitedPositionHeuristic().compute(n);

        int distance = Integer.MAX_VALUE;

        Exploration ex = (Exploration) n.state;

        int[][] map = Planet.getAccessible();
        for (int i=0; i<map.length; ++i) {
            for (int j=0; j<map[i].length; ++j) {
                Position to = new Position(i,j);
                if (!ex.getCurrentPosition().equals(to) &&
                        Planet.isAccessible(i,j) && !ex.getVisitedPositions().contains(to)) {
                    distance = Math.min(distance, ex.getCurrentPosition().shortestDistance(to));
                }
            }
        }
        return count + distance;
    }
}
package mars;

import search.GoalTest;
import search.State;

public class EmptyBatteryGoalTest implements GoalTest {
    @Override
    public boolean isGoal(State state) {
        return ((Exploration) state).getBattery() == 0;
    }
}
package mars;

import search.Action;
import search.State;

import java.util.HashSet;
import java.util.Set;

public class Exploration implements State {
    private final int battery;
    private Position currentPosition;
    private Set<Position> visitedPositions;

    public Exploration(Position currentPosition, int battery) {
        this.visitedPositions = new HashSet<>();
        this.currentPosition = currentPosition;
        this.visitedPositions.add(currentPosition);
        this.battery = battery;
    }

    public Exploration(Position currentPosition, Set<Position> visitedPositions, int battery) {
        this.currentPosition = currentPosition;
        this.visitedPositions = visitedPositions;
        this.battery = battery;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public int getBattery() {
        return battery;
    }

    public Set<Position> getVisitedPositions() {
        return visitedPositions;
    }

    @Override
    public Set<? extends Action> getApplicableActions() {
        Set<Move> res;
        Set<Position> neighbors = Planet.getAccessibleNeighbors(currentPosition);

        Set<Move> moves = new HashSet<>();
        for (Position n : neighbors) {
            moves.add(new Move(n.x - currentPosition.x, n.y - currentPosition.y));
        }
        return moves;
    }

    @Override
    public State getActionResult(Action action) {
        Move m = (Move) action;
        Position newPos = new Position(currentPosition.x + m.deltaX, currentPosition.y + m.deltaY);
        Set<Position> visited = new HashSet<>(visitedPositions);
        visited.add(newPos);
        return new Exploration(newPos, visited, battery - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exploration that = (Exploration) o;

        if (battery != that.battery) return false;
        if (currentPosition != null ? !currentPosition.equals(that.currentPosition) : that.currentPosition != null)
            return false;
        return !(visitedPositions != null ? !visitedPositions.equals(that.visitedPositions) : that.visitedPositions != null);

    }

    @Override
    public int hashCode() {
        int result = battery;
        result = 31 * result + (currentPosition != null ? currentPosition.hashCode() : 0);
        result = 31 * result + (visitedPositions != null ? visitedPositions.hashCode() : 0);
        return result;
    }

    public boolean isVisited(int x, int y) {
        return visitedPositions.contains(new Position(x, y));
    }


}
package mars;

import search.Action;
import search.Printing;
import search.State;

import java.util.Arrays;

public class ExplorationPrinting extends Printing {
    @Override
    public void print(Action action) {
        System.out.print(((Move) action));
    }

    @Override
    public void print(State state) {
        char[][] map = Planet.getMap();

        Exploration ex = (Exploration) state;
        for (Position p : ex.getVisitedPositions()) {
            map[p.x][p.y] = 'v';
        }

        Position curr = ex.getCurrentPosition();
        map[curr.x][curr.y] = 'c';

        for (char[] line : map) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println("visited: " + ((Exploration) state).getVisitedPositions().size() + " battery left: " + ex.getBattery());
    }
}
package mars;

import search.State;

public class MapCoveringGoalTest implements search.GoalTest {
    @Override
    public boolean isGoal(State state) {
        int[][] map = Planet.getAccessible();
        Exploration ex = (Exploration) state;

        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                if (map[i][j] == 0 && !ex.isVisited(i, j)) return false;
            }
        }
        return true;
    }
}
package mars;

import search.*;

package mars;

import search.Action;

public class Move implements Action {
    public final int deltaY;
    public final int deltaX;

    Move(int deltaX, int deltaY) {
        this.deltaY = deltaY;
        this.deltaX = deltaX;
    }

    @Override
    public int cost() {
        return 1;
    }

    @Override
    public String toString() {
        return "Move {" +
                "deltaY=" + deltaY +
                ", deltaX=" + deltaX +
                '}';
    }
}
package mars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Planet {
    private static HashMap<Position, int[][]> shortestDistances = new HashMap<>();
    private static final int[][] accessible = new int[][]{
            {1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1},
            {0, 0, 1, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 0, 1, 0, 1},
            {1, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 1, 1, 1},
    };
    public static int accessibleCount = -1;

    public static boolean isAccessible(int x, int y) {
        int offx = x + 0;
        int offy = y + 0;
        if (offx >= 0 && offy >= 0 && offx < accessible.length && offy < accessible[0].length)
            return (accessible[offx][offy] == 0);
        else return false;
    }

    public static int getAccessibleCount() {
        if (accessibleCount > 0) return accessibleCount;

        accessibleCount = 0;
        for (int i = 0; i < accessible.length; ++i) {
            for (int j = 0; j < accessible[i].length; ++j) {
                accessibleCount += accessible[i][j] == 1 ? 0 : 1;
            }
        }
        return accessibleCount;
    }

    public static char[][] getMap() {
        char[][] map = new char[accessible.length][accessible[0].length];
        for (int i = 0; i < accessible.length; ++i) {
            for (int j = 0; j < accessible[i].length; ++j) {
                map[i][j] = accessible[i][j] == 1 ? '1' : '0';
            }
        }
        return map;
    }

    public static int[][] getAccessible() {
        return accessible;
    }

    public static Set<Position> getAccessibleNeighbors(Position p) {
        Set<Position> res = new HashSet<>();
        if (isAccessible(p.x - 1, p.y)) res.add(new Position(p.x - 1, p.y));
        if (isAccessible(p.x + 1, p.y)) res.add(new Position(p.x + 1, p.y));
        if (isAccessible(p.x, p.y + 1)) res.add(new Position(p.x, p.y + 1));
        if (isAccessible(p.x, p.y - 1)) res.add(new Position(p.x, p.y - 1));
        return res;
    }

    public int height() {
        return accessible.length;
    }

    public int width() {
        return accessible[0].length;
    }

    public static int[][] shortestDistanceForPosition(Position p) {
        if (shortestDistances.containsKey(p)) {
            return shortestDistances.get(p);
        }

        int[][] shortestDistance = new int[accessible.length][accessible[0].length];

        final int MAX_DIST = shortestDistance.length * shortestDistance[0].length;
        for (int i=0; i<shortestDistance.length; ++i) {
            for (int j=0; j<shortestDistance[i].length; ++j) {
                shortestDistance[i][j] = accessible[i][j] == 1 ? Integer.MAX_VALUE : MAX_DIST;
            }
        }
        shortestDistance[p.x][p.y] = 0;

        boolean done = false;
        while (!done) {
            done = true;
            for (int i=0; i<shortestDistance.length; ++i) {
                for (int j=0; j<shortestDistance[i].length; ++j) {
                    if (shortestDistance[i][j] == Integer.MAX_VALUE)
                        continue;
                    int up = i >= 1 ? shortestDistance[i-1][j] : Integer.MAX_VALUE;
                    int left = j >= 1 ? shortestDistance[i][j-1] : Integer.MAX_VALUE;
                    int down = i < shortestDistance.length-1 ? shortestDistance[i+1][j] : Integer.MAX_VALUE;
                    int right = j < shortestDistance[i].length-1 ? shortestDistance[i][j+1] : Integer.MAX_VALUE;
                    int update = Math.min(up, Math.min(left, Math.min(down, right))) + 1;
                    if (update < shortestDistance[i][j]) {
                        done = false;
                        shortestDistance[i][j] = update;
                    }
                }
            }
        }
        shortestDistances.put(p, shortestDistance);
        return shortestDistance;
    }
}
package mars;

import java.util.Arrays;

/**
 * Created by siqi on 11/18/15.
 */
public class Position {
    public final int x;
    public final int y;
    private final int[][] shortestDistance;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        shortestDistance = Planet.shortestDistanceForPosition(this);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public int shortestDistance(Position p) {
        return shortestDistance[p.x][p.y];
    }

    public void printShortestDistance() {
        for (int[] line : shortestDistance) {
            for (int i : line) {
                System.out.printf("%5d,", i == Integer.MAX_VALUE ? -1 : i);
            }
            System.out.println();
        }
        System.out.println();
    }
}
package mars;

import search.Node;
import search.NodeFunction;

import java.util.Set;

public class UnvisitedPositionHeuristic implements NodeFunction {
    @Override
    public int compute(Node n) {
        Exploration state = (Exploration) n.state;
        Set<Position> explored = state.getVisitedPositions();

        return Planet.getAccessibleCount() - explored.size();
    }
}
