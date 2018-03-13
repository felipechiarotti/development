#ifndef MANAGEFILE_H
#define MANAGEFILE_H
#include <fstream>	
#include <stdio.h>
#include <curl/curl.h>
#include <dirent.h>
#include <sys/stat.h>
using namespace std;

void readFile(fstream&, string);
int readFileCheck(fstream&, string);
int readCSVFile(fstream&,string);
string readLine(fstream&);
string readLinePattern(fstream&);
string readLineNumber(fstream&);
string readLineNumberCSV(fstream&);

void readFile(fstream& arquivo, string name){
	arquivo.open(name.c_str(), ios::in);	
}

int readFileCheck(fstream& arquivo, string name){
	readFile(arquivo, name);

	string line;
	int size;
	for(int i = 1; getline(arquivo,line); i++){
		size = i;
	}
	arquivo.close();
	readFile(arquivo,name);
	return size;
}

int readCSVFile(fstream& arquivo, string name){
	string line;
	int size = readFileCheck(arquivo, name);
	readLine(arquivo);
	return size-1;
}

void writeFile(fstream& arquivo, string name){
	arquivo.open(name.c_str(), ios::out);	
}

void writeFileCSV(fstream& arquivo, string name, string cabec){
	writeFile(arquivo,name);
	arquivo << cabec;
}

string readLine(fstream& fileName){
	string line;
	getline(fileName, line);
	return line;
}

string readLinePattern(fstream& fileName, char data){
	string line;
	getline(fileName, line, data);
	return line;
}

string readLineNumber(fstream& fileName, int nLine){
	string line;
	for(int i = 0; i<nLine; i++){
		line = readLine(fileName);
	}
	return line;
}
string readLineCSV(fstream& fileName){
	string line;
	line = readLinePattern(fileName, ';');
	return line;
}

bool downloadFile(string getURL, string fileName){
	 CURL *curl = curl_easy_init();
	 size_t pos;
	 if(curl){
	 	CURLcode res;		
		FILE *tmp;
		for(int i = 0; i<fileName.size(); i++){
			if(fileName[i] == '/'){
				pos = i;
				string directory = fileName.substr(0,pos);
				DIR *dir = opendir(directory.c_str());
				if(dir == NULL) mkdir(directory.c_str(),S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH);
				closedir(dir);
				break;
			}
		}

		tmp = fopen(fileName.c_str(),"wb");
		curl_easy_setopt(curl, CURLOPT_URL, getURL.c_str());
		curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, NULL);
		curl_easy_setopt(curl, CURLOPT_WRITEDATA, tmp);
		res = curl_easy_perform(curl);
		curl_easy_cleanup(curl);
		fclose(tmp);
		if(res==0)return 1;
		return 0;
	 }
}
#endif
