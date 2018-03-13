#include <iostream>
#include <fstream>
#include <QLabel>
using namespace std;

struct Version{
	string name;
	string path;
	
	void getFileSize(fstream& arquivo, streampos &size){
		//size = arquivo.tellg();
	}
	
	void getVersion(fstream& arquivo){
		/*char* memblock;
		streampos size;
		getFileSize(arquivo,size);
		memblock = new char[size];
		arquivo.seekg(-15,ios::end);
		arquivo.read(memblock,size);
		*/		
	}
	
	void downloadVersionFile(){
		
	}
	void checkVersion(fstream &arquivo){
		//streampos size = getFileSize(arquivo,size);
	}
	void update(){
				
	}
};

int main(){
	//fstream File;
	//readFile(File,"config.ini");
	//File.open("config/version.dat", ios::binary|ios::in|ios::ate);
	
	//Version version;
	//version.getVersion(File);
}
