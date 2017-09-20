from memory import Memory
from process import Process
from process_list import ProcessList
from mmu import MemoryMU

physical_memory = Memory(32768)
process_list = ProcessList()
mmu = MemoryMU(process_list);

process1 = Process('chrome',16384)
process2 = Process('skype', 8192)
process3 = Process('libreoffice',4098)
process4 = Process('atom',4098)
process5 = Process('apache',2048)

process_list.add_process(process1);
process_list.add_process(process2);
process_list.add_process(process3);
process_list.add_process(process4);
process_list.add_process(process5);

mmu.allocate_process_pages(process1,physical_memory);
