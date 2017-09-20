/* Multi
    Line
      Comment */

// Single line Comment


// Variable Types
var myVariable = 'Felipe';
var myNumber = 10;
var myBoolean = true;
var myArray = [1,'Felipe','Steve',10];
var myObject = document.querySelector('h1');
    myObject.innerHTML = 'Aguardando ponteiro...';
function onMouseOverHeader(){
    myObject.onmouseover = function(){
      myObject.innerHTML = 'Ola Felipe';
    }
    myObject.onmouseout = function(){
      myObject.innerHTML = 'Aguardando ponteiro...';
    }
}
  onMouseOverHeader();

// Operations
var myString = "Conca" + "tenation"
var myIdentification = 3;
    myIdentification === 4; //Returns False;
var myNot = true;
    !myNot;
var myNotComparation = 3;
    myNotComparation !== 4; //Returns True;

//Conditionals
var myName = 'Felipe';
if(myName === 'Felipe'){
  alert("I like this name!");
}else{
  alert("But I like the name \"Felipe\"");
}

//Functions
function multiply(firstNumber, secondNumber){
  var result = firstNumber * secondNumber;
  return result;
}
multiply(3,2);

//Events
var myHTML = document.querySelector('html');
myHTML.onclick = function(){
  alert("You are touching me!");
}

// Image Modifier
var myImage = document.querySelector('img');
myImage.onclick = function(){
  var mySrc = myImage.getAttribute('src');
  if(mySrc === 'images/tree-pose.jpg'){
    myImage.setAttribute('src', 'images/red-panda.jpg');
  }else{
    myImage.setAttribute('src', 'images/tree-pose.jpg');
  }
}

function slideImage(){
  var currentImage = document.querySelector('img');
  var currentSrc  = currentImage.getAttribute('src');
  if(currentSrc === 'images/tree-pose.jpg'){
    myImage.setAttribute('src', 'images/red-panda.jpg');
  }else{
    myImage.setAttribute('src', 'images/tree-pose.jpg');
  }
  setTimeout(slideImage,3000);
}
//slideImage();
