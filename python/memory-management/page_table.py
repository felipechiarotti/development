class PageTable(object):
    def __init__(self):
        self.content = [];

    def add_route(self, full_address, physical_mem_address):
        self.content.append([full_address,physical_mem_address]);