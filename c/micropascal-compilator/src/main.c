#include <stdio.h>
#include "lexer/tokens.h"
extern int yylex();
extern void yyset_in(FILE*);
extern int nline;

int main(int argc, char **argv){
	if(argc == 2){
		FILE *file;
		if(!(file = fopen(argv[1], "r"))){
			perror("Erro: ");
            return (-1);
		}else{
			yyset_in(file);
			int val;
			while(val = yylex()){
				
			}
		}
		fclose(file);
	}else{
		printf("[!]Utilize o compilador da seguinte forma: \"%s nome-do-arquivo\"\n",argv[0]);
	}
	return 0;
}