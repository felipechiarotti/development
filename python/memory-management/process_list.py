from process import Process
class ProcessList(object):
    def __init__(self):
        self.processes = {}

    def add_process(self,process):
        self.processes[bin(len(self.processes))] = process

    def remove_process(self, pos):
        del self.processes[bin(len(pos))]

    def get_process_address(self, process_name):
        for address, proc in self.processes.items():
            if(proc.name == process_name):
                return address;
        return NULL;