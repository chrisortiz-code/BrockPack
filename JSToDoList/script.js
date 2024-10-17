const form = document.getElementById('form');
const input = document.getElementById('input');
const list = document.getElementById('list');
const sortB = document.getElementById('sort');

let tasks = [];


function addTask(text){
    if(text){
        tasks.push({text: text,completed: false});
    }
}
function displayTasks() {
    list.innerHTML = ''; // Clear the list before re-displaying
    for (let i = 0; i < tasks.length; i++) {
        const li = document.createElement('li');
        li.innerHTML = `
            <span class="${tasks[i].completed ? 'completed' : ''}">${tasks[i].text}</span>
            <button onclick="toggleCompletion(${i})">
                ${tasks[i].completed ? 'Undo' : 'Complete'}
            </button>
        `;
        list.appendChild(li);
    }
}

function toggleCompletion(index) {
    tasks[index].completed = !tasks[index].completed;
    displayTasks();
}
function sort(){
    tasks.sort((a, b) => a.text.localeCompare(b.text));
    displayTasks();
}
form.addEventListener('submit', (e) => {
    e.preventDefault();
    addTask(input.value);
    displayTasks();
    input.value = "";
});
sortB.addEventListener('click', sort)

