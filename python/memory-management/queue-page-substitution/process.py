class Process(object):
    def __init__(object,size):
        self.logical_memory = Memory(size);

    def config_process(self):
        self.logical_memory.content