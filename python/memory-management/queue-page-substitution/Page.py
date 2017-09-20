class Page(object):
    def __init__(self):
        self.size = 1024;
        self.allocated = False;

    def set_page_allocated(self,allocate):
        self.allocated = allocate;