//Minha implementação do print para testes
function print(variavel){
    console.log(variavel)
}
//Minha implementação do gets(). Não usar no desafio. O gets() já é implementado no sistema
function gets(pergunta) {
    let valor = prompt(pergunta);
    while (isNaN(valor) && valor >= 1) {
        valor = prompt("Você não digitou um número válido. Favor digitar um número maior ou igual a 1.");
    }
    return valor;
}

//Peço o número total de espaços
const N = gets('Favor digitar o número total de figurinhas e espaços no álbum');
//Peço o número total de figurinhas compradas
const M = gets('Favor digitar o número de figurinhas já compradas');
//Crio o set para garantir que não terei entradas duplicadas no meu Set mesmo que o usuário forneça valores duplicados
const setFig = new Set();
let figurinhasRepetidas = [];

//Faço um loop pedindo o número de cada figurinha comprada. Ele vai considerar o número total de figurinhas compradas e não o número total de espaços. O que pode acarretar em serem digitadas figurinhas repetidas.
for (let i = 0; i < M; i++) {
    let x = gets('Favor digitar o número da figurinha comprada');
    //Verifico que seja um número válido maior que 1. Essa verificação neste código é redundante pois o gets já verifica isto, mas deixei aqui pois não tenho acesso ao gets() implementado pela DIO para ver se essa verificação já é feita lá. Então na resposta é bom adicionar essa verificação.
    if (x < 1) {
        x = gets(`O número digitado não é um valor válido. Favor digitar um número entre 1 e ${N}`);
    } else {
        //Verifico se o número fornecido é um número menor ou igual do que o número total de espaços, porque se não ele não é válido e peço que seja digitado novamente
        if (x > N) {
            x = gets(`O número digitado não é um valor válido. Favor digitar um número entre 1 e ${N}`);
        } else {
            //Adicionei depois para uma funcionalidade interessante de armazenar as figurinhas repetidas para que o colecionador tenha o controle das que pode querer trocar.
            if (setFig.has(x)) {
                figurinhasRepetidas.push(x);
            }
            //Chegando aqui o número é válido e uso o método add do Set para adicionar o número, pois se ele for repetido não irá adicionar.
            setFig.add(x);
            console.log(`No album que vai de 1 a ${N} comprei a figurinha ${x}`);
        }
    }


}

//Para saber quantas faltam basta ver o tamanho do Set e subtraí-lo do número total de espaços
print(`Faltam ${N - setFig.size}`);
if(figurinhasRepetidas.length > 0){
    console.log(`Tenho as seguintes figurinhas repetidas: ${figurinhasRepetidas}`);
}


