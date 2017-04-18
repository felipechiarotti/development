#ifndef MANAGEFILE_H
#define MANAGEFILE_H
#include <fstream>
#include <stdlib.h>
using namespace std;

/*
//---------------HEADER DLL---------------//
//-Manipulação geral de Arquivos
extern "C" __declspec(dllexport) int readFile(fstream&,string,bool);
extern "C" __declspec(dllexport) streamsize readBinaryFile(fstream&,string);
//-Manipulação de Arquivos INI
extern "C" __declspec(dllexport) bool getCampo(string,string);
extern "C" __declspec(dllexport) int getIntValue(string);
extern "C" __declspec(dllexport) string getStringValue(string);
extern "C" __declspec(dllexport) int getIntData(string,fstream&);
extern "C" __declspec(dllexport) string getStringData(string,fstream&);
//---------------FIM HEADER DLL---------------//
*/


//---------------MANIPULAÇÃO GERAL DE ARQUIVOS---------------//
//readFile(fstream, nome_do_arquivo, total_de_linhas) - Lê um arquivo e se for setado como 1, retorna a quantidade de linhas.
int readFile(fstream& arquivo, string name, bool totalLine){
	arquivo.open(name.c_str(), ios::in);
	if(arquivo){
		if(totalLine){
			int Size=0;
			string line;
			while(getline(arquivo,line)){
				Size++;
			}
			arquivo.close();
			arquivo.open(name.c_str(), ios::in);
			return Size;
		}
	}else{
		return 0;
	}
}

//readBinaryFile(fstream, nome_do_arquivo, posicao) - Lê um arquivo binário e retorna seu tamanho.
streamsize readBinaryFile(fstream& arquivo, string name){
		arquivo.open(name.c_str(), ios::in | ios::binary | ios::ate);
		if(arquivo){
			streamsize Size = arquivo.tellg();
			arquivo.seekg(0,arquivo.beg);
			return Size;			
		}else{
			return 0;
		}
}
//---------------FIM MANIPULAÇÃO GERAL DE ARQUIVOS---------------//


//---------------MANIPULAÇÃO DE ARQUIVOS INI---------------//

//getCampo(linha_de_dados, nome_do_campo) - Verifica se a linha possui o campo desejado.
bool getCampo(string line, string campo){
	for(int i = 0; i<campo.size(); i++){
		if(line[i] != campo[i]){
			return false;
		}
	}
	return true;
}

//getIntValue(linha_de_dados) - Recebe uma linha de dados e retorna o valor da mesma em INT
int getIntValue(string line){
	string aux;
	int pos;
	for(int i = 0; line[i] != '='; i++){pos = i;}
	for(int i=pos+2; i<line.size(); i++){
		aux+= line[i];
	}
	return atoi(aux.c_str());
}

//getStringValue(linha_de_dados) - Recebe uma linha de dados e retorna o valor da mesma em STRING
string getStringValue(string line){
	string aux;
	int pos;
	for(int i = 0; line[i] != '='; i++){pos = i;}
	for(int i=pos+2; i<line.size(); i++){
		aux+= line[i];
	}
	return aux;
}

//getIntData(nome_campo, fstream) - Verifica o arquivo até encontrar um campo, e retorna o valor do mesmo em INT.
int getIntData(string campo, fstream& arquivo){
	string line;
	while(getline(arquivo,line)){
		if(getCampo(line,campo)){
			return getIntValue(line);
		}
	}
	return 0;
}

//getStringData(nome_campo, fstream) - Verifica o arquivo até encontrar um campo, e retorna o valor do mesmo em STRING.
string getStringData(string campo, fstream& arquivo){
	string line;
	while(getline(arquivo,line)){
		if(getCampo(line,campo)){
			return getStringValue(line);
		}
	}
	return "Valor Não Retornado!";
}
//---------------FIM MANIPULAÇÃO DE ARQUIVOS INI---------------//

//---------------MANIPULAÇÃO DE ARQUIVOS CSV-------------------//

void clearCabec(fstream &arquivo){
	string line;
	getline(arquivo,line);
}
#endif