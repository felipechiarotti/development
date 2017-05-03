struct Symbol{
    int token; // TIPO
    int value; // VALOR
    string lexem; // 
    bool keyword = false;
};

vector<Symbol> symbols;

int add_symbol(Symbol symbol){
    for(int i = 0; i < symbols.size(); i++){
        Symbol s = symbols[i];
        if(s.lexem.compare(symbol.lexem) == 0){
            symbols[i] = symbol;
            return i;
        }
    }
    symbols.push_back(symbol);
    return symbols.size()-1;
}

bool reserve_keywords(){
    L = lua_open();
}
