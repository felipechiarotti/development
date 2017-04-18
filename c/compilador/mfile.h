FILE *file;

int openFile(char *filename, char* mode){
   file = fopen(filename,mode);
   if(!file){
        return -1;
   }else{

        return 1;
   }
}

void closeFile(){
    fclose(file);
}

char* getNextLine(){
    char *linha;
    fgets(linha, sizeof(linha), file);
    return linha;
}

char getNextByte(){
    fgetc(file);
}

char returnFilePointer(){
    fseek(file,-1,SEEK_CUR);
}

int endFile(){
    return feof(file);
}