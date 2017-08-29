class ProcessList(object):
    def __init__(self):
        self.content = {}

    def add_process(self,process):
        self.content[bin(len(self.content))] = process

    def remove_process(self, pos):
        del self.content[bin(len(pos))]