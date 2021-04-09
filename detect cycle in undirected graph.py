from collections import defaultdict

class Graph:
	def __init__(self):
		self.graph = defaultdict(list)

	def addEdge(self, u, v):
		self.graph[u].append(v)
		self.graph[v].append(u)

	def isCycleUtil(self, v, visited, parent):
		visited[v] = True

		for i in self.graph[v]:
			if not visited[i]:
				if self.isCycleUtil(i, visited, v):
					return True
			elif parent != i:
				return True

		return False

	def isCycle(self):
		visited = [False] * len(self.graph)

		for i in range(len(self.graph)):
			if not visited[i]:
				if self.isCycleUtil(i, visited, -1):
					return True

		return False


g = Graph()
g.addEdge(1, 0)
g.addEdge(1, 2)
g.addEdge(2, 0)
g.addEdge(0, 3)
g.addEdge(3, 4)

if g.isCycle():
	print("Graph contains cycle")
else:
	print("Graph does not contain cycle ")
g1 = Graph()
g1.addEdge(0, 1)
g1.addEdge(1, 2)

if g1.isCycle():
	print("Graph contains cycle")
else:
	print("Graph does not contain cycle ")


