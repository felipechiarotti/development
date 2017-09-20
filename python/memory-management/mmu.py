from memory import Memory
from process import Process
from process_list import ProcessList
from page import Page
from page_table import PageTable
class MemoryMU(object):
    def __init__(self, process_list):
        self.page_table = PageTable();
        self.process_list = process_list;

    def allocate_process_pages(self, process, physical_memory):
        process_pages = process.get_process_pages();
        process_address = self.process_list.get_process_address(process.name);
        for page_address, page in process_pages.items():
            physicial_memory_address = physical_memory.set_page(page_address);
            full_address = ""+process_address+page_address;
            self.page_table.add_route(full_address, physicial_memory_address);