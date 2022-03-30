/**
 * Minha versão de gets() e print() para testes
 */
function gets(pergunta) {
    let valor = prompt(pergunta);
    while (isNaN(valor)) {
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
const c = parseInt(gets("Quantos candidatos: "));
let v = new Array(c);
let i;
for (i = 0; i < c; i++){
    v[i] = parseInt(gets("Quantos votos o candidato recebeu: "));
}

let  primeiroInscrito = true;

const teste  = Number(v.shift());


for(let a = 0; a < v.length; a++) {
    const bobo  = Number(v[a]);

    if (bobo > teste) {
        primeiroInscrito = false;
    }
};

let ganhou = primeiroInscrito ? "S" : "N";
print(ganhou);
res.innerHTML = ganhou;