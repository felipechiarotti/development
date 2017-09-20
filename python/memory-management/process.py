from memory import Memory
from page import Page

class Process(object):
    def config_process(self):
        i = 0;
        while i < self.logical_memory.size:
            self.logical_memory.pages[bin(i)] = Page();
            i = i + 1;

    def __init__(self,name,size):
        self.logical_memory = Memory(size);
        self.name = name+".exe"
        self.config_process();

    def get_process_pages(self):
        return self.logical_memory.pages;