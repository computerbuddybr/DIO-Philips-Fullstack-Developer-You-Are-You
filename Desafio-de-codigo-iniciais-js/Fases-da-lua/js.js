/**
 * Para quem for fazer o desafio. Adaptei o código para poder testar em um IDE
 * O que você vai querer usar, é a lógica do if/else, e o valor do console.log
 * mas não altere nada mais no código deles.
 * Eu troquei os print por console.log e já fiz um array lines para lidar com
 * os valores entregues.
 */
//Minha implementação do print para testes
function print(variavel){
    console.log(variavel)
}
let lines = [];
function gets(){
    let valor1 = prompt("Digite o valor de porcentagem encontrado a duas noites atrás: ");
    while(isNaN(valor1)){
        valor1 = prompt("Você não digitou um número. Favor digitar um número: ");
    }
    lines[0] = valor1;
    let valor2 = prompt("Digite o valor de porcentagem encontrado a esta noite: ");
    while(isNaN(valor2)){
        valor2 = prompt("Você não digitou um número. Favor digitar um número: ");
    }
    lines[1] = valor2;

}
gets();
console.log(lines);
//let line = lines.shift().split(" ");
let inicio = parseInt(lines[0]);
console.log(`Valor de duas noites atrás: ${inicio}%`);
let final = parseInt(lines[1]);
console.log(`Valor de hoje: ${final}%`);

//Parte que temos que completar. Eu substitui os print por console.log
if (inicio >= 0 && final <= 2) {
    print('nova\n');
} else if (final > inicio && inicio >= 3 &&  final <= 96) {
    print('crescente\n');
} else if (final < inicio && final <= 3) {
    print('minguante\n');                 //complete o código nos espaços em branco
} else {
    print('cheia\n');
}