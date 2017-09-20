class Memory(object):
    def __init__(self,size):
        self.size = size/1024;
        self.pages = [];

    def get_free_slot(self):
        for position, page in enumerate(self.pages):
            if(page.allocated == False):
                return position;
        return -1;

    def get_page_address(self,page_in):
        for position, page in enumerate(self.pages):
            if(page == page_in):
                return bin(position)

    def get_page(self,position):
        return self.pages[position]