FILE *file;

int open_file(string filename, string mode){
   file = fopen(filename,mode);
   if(!file){
        return -1;
   }else{
        return 1;
   }
}

void close_file(){
    fclose(file);
}

char* next_line(){
    char *linha;
    fgets(linha, sizeof(linha), file);
    return linha;
}

char next_char(){
    char_pos++;
    return fgetc(file);
}

char previous_char(){
    char_pos--;
    return fseek(file,-1,SEEK_CUR);
}

int end_file(){
    return feof(file);
}