/**
 * Minha versão de gets() e print() para testes
 */
function gets(pergunta) {
    let valor = prompt(pergunta);
    while (isNaN(valor) || valor < 0) {
        valor = prompt("Você não digitou um número. Favor digitar um número: ");
    }
    return valor;
}

function print(variavel) {
    console.log(variavel)
}

//Para poder mostrar o resultado no HTML
const res = document.querySelector('#resultado');

//Desafio
let totalItems = parseInt(gets("Digite o total de números a serem recebidos"));
let pares = [];
let impares = [];

for (let i = 0; i < totalItems ; i++) {
    let number = parseInt(gets("Digite o valor:"));
    if (number%2 === 0){
        pares.push(number);
    }
    else {
        impares.push(number);
    }
}


pares.sort((a, b) =>  a - b);

impares.sort((a, b) =>  b - a);


let html = `Foram recebidos ${totalItems} valores: \n\n`;

for(let i = 0; i < pares.length;i++){
    html += `${pares[i]}\n`;
    print(pares[i])
}
html += "\n";
for(let i = 0; i < impares.length;i++){
    html += `${impares[i]}\n`;
    print(impares[i])
}
res.innerHTML = html;