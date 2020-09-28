#Priority Queue is a type of queue that places a priority on its elements
#the pop method, returns the item from the priority queue
#with the highest priority
#implement using the heapq built-in module

import heapq

class PriorityQueue:
    def __init__(self):
        self.queue = []
        self.index = 0

    def push(self, item, priority):
        heapq.heappush(self.queue, (-priority, self.index, item))
        self.index += 1

    def pop(self):
        return heapq.heappop(self.queue)[-1]

class Item:
    def __init__(self, name):
        self.name = name

    def __repr__(self):
        return f"Item({self.name})"

pq = PriorityQueue()
pq.push(Item('Allen'), 1)
pq.push(Item('Jack'), 2)
pq.push(Item('Zerin'), 3)
pq.push(Item('Sarim'), 4)

print(pq.pop())
