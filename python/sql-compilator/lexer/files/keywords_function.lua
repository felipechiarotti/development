function get_keywords(){
    return keywords;
}

function get_keyword(name){
    for key,value in pairs(keywords) do
        if name == value
            return value
        else
            return -1
}