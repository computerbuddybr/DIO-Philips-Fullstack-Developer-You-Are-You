let quantidadePositivos = 0;

/**
 * Para quem for fazer o desafio está função e array foi implementação minha. NÃO É NECESSÁRIO IMPLEMENTAR A FUNÇÃO. ALIÁS. NÃO É PARA IMPLEMENTAR. Seu código não vai passar nos testes deles. Eles já implementaram a função. Realmente só adicione código onde aparecem os comentários deles.
 * @param iteracao
 * @returns {string}
 */
let valoresDigitados = [];
function gets(iteracao){
    let valor = prompt(`Digite o ${iteracao+1}º número: `);
    while(isNaN(valor)){
        valor = prompt("Você não digitou um número. Favor digitar um número: ");
    }
    return valor;
}
//Este é o for da DIO
for (let i = 0; i < 6; i++) {

    const valorInformadoPeloUsuario = gets(i);
    valoresDigitados.push(valorInformadoPeloUsuario);
    
    if(valorInformadoPeloUsuario > 0){
        quantidadePositivos++;
    }


}
/**
 * O mesmo aviso de cima. Aqui alterei a saída do console. É simplesmente para ficar melhor aqui e para que a pessoa que quiser usar meu código como referência possa entender o que está acontecendo. Mas não altere o console.log do desafio ou seu código não irá passar nos testes.
 */
console.log(`No array ${valoresDigitados} temos ${quantidadePositivos} valores positivos`);
