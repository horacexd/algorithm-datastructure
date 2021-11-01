
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        graphDict = {}
        for e in employees:
            graphDict[e.id] = e
        return self.__getImportance(graphDict, id)
    def __getImportance(self, graph, id: int) -> int:
        cur = graph[id].importance
        for sub in graph[id].subordinates:
            cur += self.__getImportance(graph, sub)
        return cur