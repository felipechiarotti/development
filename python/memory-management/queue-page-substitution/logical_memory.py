class LogicalMemory(Memory):
    def __init__(self,size):
        super(self,size)

    def allocate_page(self, pos):
        return self.pages