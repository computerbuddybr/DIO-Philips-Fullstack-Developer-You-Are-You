//Avatar do dinossauro
//TODO: Mudar cor de dinossauro ou avatar (dependendo do que a pessoa clicar colocar uma imagem ou outra. A pessoa também vai poder escolher o obstaculo Ter play e Stop. Se Stop a pessoa pode trocar avatar, obstaculo e velocidade
const dino = document.querySelector('.dino');
const background = document.querySelector('.background');
const chosenKey = document.querySelector('.chosenKey');
const errorMessage = document.querySelector('.errorMessage');
const pontos = document.querySelector('.pontos');
const mainContent = document.querySelector('.main');

//Intervalo de movimento
//TODO:Dar possibilidade da pessoa escolher velocidade Slow, medium, fast
let dinoTiming = 20;
let cactusTiming = 40;
let dinoPosition = 0;
//Altura que o dino pula, quanto mais alto mais fácil
let jumpHeight = 300;
//Deixando a pessoa escolher a tecla que quer usar
//Variável para controlorar se é a primeira vez que a tecla é pressionada
let firstClick = 0;
//Variáveis para guardar o código da tecla e seu nome
let keyCode;
let keyName;

//Controlando se está pulando ou não
let isJumping = false;


//Controlando se o jogo acabou
let gameOver = false;
let pontuacao = 0;
pontos.innerHTML = pontuacao;
/**
 * Função responsável por lidar com quando pressionamos a tecla de espaço
 * @param event
 */
//TODO: Trocar por tecla de flecha pra cima?
//TODO: trocar dinossauro pelo meu Avatar
function handleKeyUP(event) {

    if (firstClick === 0) {
        keyCode = event.keyCode;
        keyName = event.key;
        chosenKey.innerHTML = "<p>Tecla escolhida: " + keyName + "</p><p> Você está pronto para começar a jogar!</p>";


    }
    firstClick++;
    if (firstClick > 0) {
        if (event.keyCode === keyCode) {
            //Retirando mensagens de erro
            errorMessage.innerHTML = "";
            //Fazendo o movimento
            if (!isJumping) {
                jump();
            }
        } else {
            //Devolvendo uma mensagem de erro caso a pessoa clique na tecla errada
            errorMessage.innerHTML = "<p>Oopsie, lembra, você escolheu a tecla" + keyName + "</p>";
        }
    }
}

function jump() {

    isJumping = true;

    let upInterval = setInterval(() => {
        if (dinoPosition >= jumpHeight) {
            clearInterval(upInterval);
            //Descer
            let downInterval = setInterval(() => {
                if (dinoPosition <= 0) {
                    clearInterval(downInterval);
                    isJumping = false;
                } else {
                    dinoPosition -= 20;
                    dino.style.bottom = dinoPosition + 'px';
                }
            }, dinoTiming);

        } else {
            //Subir
            dinoPosition += 20;
            dino.style.bottom = dinoPosition + 'px';
            console.log("Fui pra cima");

        }
    }, dinoTiming);

}


function createCactus() {
    //TODO: Refatorar talvez já começar existindo desde o começo pra poder fazer um cactusMovement

    const cactus = document.createElement('div');
    let cactusPosition = 1000;
    let randomTime = Math.random() * 6000;
    cactus.classList.add('cactus');
    cactus.style.left = cactusPosition + 'px';
    background.appendChild(cactus);

    let leftInterval = setInterval(() => {
        if (cactusPosition < -60) {
            clearInterval(leftInterval);
            background.removeChild(cactus);
        } else if(cactusPosition > 0 && cactusPosition < 60){
            if(dinoPosition < 60){
            clearInterval(leftInterval);
            mainContent.innerHTML = '<h2>Game Over!</h2><h3>Pontuação: </h3>' + pontuacao;
            gameOver = true;
            } else {
                pontuacao += 2;
                pontos.innerHTML = pontuacao;
            }
        }
        cactusPosition -= 10;
        cactus.style.left = cactusPosition + 'px';
    }, cactusTiming);
    setTimeout(createCactus, randomTime);
}

//Só começa a criar p cactus depois de escolhida a tecla

createCactus();


//Adicionando botão de Play/Pause

document.addEventListener('keyup', handleKeyUP);