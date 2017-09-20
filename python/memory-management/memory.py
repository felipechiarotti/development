from page import Page
class Memory(object):
    def __init__(self,size):
        self.size = size/1024;
        self.pages = {}

    def get_page(self, page_number):
        return self.pages[bin(page_number)];

    def get_page_address(self, page_number):
        keys = self.pages.keys();
        if bin(page_number) in keys:          
            return bin(page_number);
        else:
            return NULL;
    
    def set_page(self, page):
        if(len(self.pages) > self.size):
            page_queue.remove_page();

        self.pages[bin(len(self.pages))] = page
        page_queue.insert_page(page);
        return bin(len(self.pages)-1);