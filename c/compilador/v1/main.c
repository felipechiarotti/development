#include <stdio.h>
#include "parser.h"

int main(){
    if(openFile("token", "r")){
        printf("Arquivo Aberto, iniciando análise\n");
        runParser();
    }else{
        printf("Erro ao abrir o arquivo\n");
    }
    closeFile();
}