class ManageFile:
    def __init__(self):
        self.analise_file = ''
        self.line_number = 1
        self.char_pos = 0
    
    #Abre o Arquivo
    @staticmethod
    def set_file_name(self,file_name):
        self.analise_file = open(file_name,'r')
    
    #Pega o proximo caractere do arquivo
    @staticmethod
    def get_next_file_char(self):
        char_read = self.analise_file.read()
        if(char_read == '\n'):
            self.char_pos = 0
            self.line_number = self.line_number + 1
        else:
            self.char_pos = self.char_pos + 1
        return char_read

    #Retorna a posição do caractere na linha
    @staticmethod
    def get_char_pos(self):
        return self.char_pos

    #Retorna o numero da linha
    @staticmethod
    def get_line_number(self):
        return self.line_number