// declare variables
const todoInput = document.getElementById('todoInput');
const addButton = document.getElementById('addButton');
const ulContainer = document.getElementById('todoUl');

// adding click event 
addButton.addEventListener('click', addButtonClicked);

// calling function on add button click
function addButtonClicked(){
    console.log('add button clicked');
    // getting input values
    let userInput = todoInput.value  ;
    console.log(userInput);
    // check the input for null undefined and empty values
    if (userInput && userInput != ""){
        // creating li elements 
        const listElement = document.createElement('li');
        // selecting deletebutton in list element to add delete functionality

        listElement.innerHTML= `<span>${userInput}</span>
                                <button class='deleteButton'>Delete</button>`
        
        //    adding delete functionality 
        const dltBtn = listElement.querySelector('.deleteButton');
        dltBtn.addEventListener('click',()=>{
            listElement.remove();
        });

        // only creation of li element is done need to append it to the ul element
        ulContainer.append(listElement);

        // finally deleting the user input value

        todoInput.value = '';
    }
}
