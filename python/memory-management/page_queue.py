from collections import deque
class PageQueue(object):
    def __init___(self):
        self.content = deque()

    def insert_page(self, page):
        self.content.append(page)

    def remove_page(self):
        self.content.popleft();