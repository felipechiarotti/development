
class Buffer:
    def __init__(self):
        self.buffer_size = 256 #Tamanho do Buffer
        self.buffer = [] # Buffer
        self.buffer_control = 0 #Quantidade de caracteres no buffer
        self.read_buffer_pos = 0 #Quantidade de caracteres lidos no buffer
    
    #Esvazia o Buffer
    def empty_buffer(self):
        self.buffer = []
        self.buffer_control = 0
        self.read_buffer_pos = 0
    
    #Preenche o Buffer
    def fill_buffer(self):
        next_char = ManageFile.get_next_file_char()
        while buffer_control < buffer_size:
            buffer.append(next_char)
            next_char = self.get_next_file_char()

    #Retorna o proximo char do buffer
    def get_char(self):
        self.read_buffer_pos = self.read_buffer_pos + 1
        return self.buffer[read_buffer_pos-1]
    
    #Volta a fita do buffer
    def go_back(self):
        self.read_buffer_pos = self.read_buffer_pos - 1

    #Verifica se o buffer foi inteiro lido e reenche o mesmo
    def verify_buffer(self):
        while(True):
            if(self.read_buffer_pos == self.buffer_size):
                self.empty_buffer()
                self.fill_buffer()