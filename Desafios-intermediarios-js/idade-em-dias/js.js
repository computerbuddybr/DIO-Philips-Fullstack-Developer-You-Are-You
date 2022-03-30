/**
 * Minha versão de gets() e print() para testes
 */
function gets() {
    let valor = prompt(`Digite o valor: `);
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
let totalDeDias = parseInt(gets());

//Para ajudar no raciocínio. Não deve estar no código final
console.log(`São ${totalDeDias} dias`)
//Estabelecendo o numero de dias no ano e mes
let ano = 365;
let mes = 30;

let qtdAnos, qtdMeses;

qtdAnos = parseInt(totalDeDias/ano);
totalDeDias = totalDeDias%ano;

//Para ajudar no raciocínio. Não deve estar no código final
console.log(`Resultam em ${qtdAnos} que vai sobrar ${totalDeDias}`);


qtdMeses = parseInt(totalDeDias/mes);
totalDeDias =   totalDeDias%mes;

//Para ajudar no raciocínio. Não deve estar no código final
console.log(`Resultam em ${qtdMeses} que vai sobrar ${totalDeDias}`);

let resultado = (qtdAnos + " ano(s) " + '\n' +
    qtdMeses +" mes(es)" + '\n' +
    totalDeDias + " dia(s)");

print(resultado);
res.innerHTML = resultado;