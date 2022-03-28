//Avatar do dinossauro
//TODO: Mudar cor de dinossauro ou avatar (dependendo do que a pessoa clicar colocar uma imagem ou outra. A pessoa também vai poder escolher o obstaculo Ter play e Stop. Se Stop a pessoa pode trocar avatar, obstaculo e velocidade
const avatar = document.querySelector('.avatar');
const background = document.querySelector('.background');
const chosenKey = document.querySelector('.chosenKey');
const errorMessage = document.querySelector('.errorMessage');
const playButton = document.querySelector('.play');
const pontos = document.querySelector('.pontos');
const mainContent = document.querySelector('.main');
//Intervalo de movimento
//TODO:Dar possibilidade da pessoa escolher velocidade Slow, medium, fast
let avatarTiming = 20;
let obstacleTiming = 40;
let avatarPosition = 0;
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
//Controlando se o jogo já começou
let playing = false;

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
        //Removendo mensagem de escolher tecla e começando o jogo.
        let keyMessage = document.querySelector('#keyChoice');
        mainContent.removeChild(keyMessage);
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
        if (avatarPosition >= jumpHeight) {
            clearInterval(upInterval);
            //Descer
            let downInterval = setInterval(() => {
                if (avatarPosition <= 0) {
                    clearInterval(downInterval);
                    isJumping = false;
                } else {
                    avatarPosition -= 20;
                    avatar.style.bottom = avatarPosition + 'px';
                }
            }, avatarTiming);

        } else {
            //Subir
            avatarPosition += 20;
            avatar.style.bottom = avatarPosition + 'px';
            console.log("Fui pra cima");

        }
    }, avatarTiming);

}


function createObstacle() {
    //TODO: Refatorar talvez já começar existindo desde o começo pra poder fazer um cactusMovement
    const obstacle = document.createElement('div');
    let obstaclePosition = 1000;
    let randomTime = Math.random() * 6000;
    obstacle.classList.add('obstacle');
    obstacle.style.left = obstaclePosition + 'px';
    background.appendChild(obstacle);

    let leftInterval = setInterval(() => {
        if (obstaclePosition < -60) {
            clearInterval(leftInterval);
            background.removeChild(obstacle);
        } else if(obstaclePosition > 0 && obstaclePosition < 60){
            if(avatarPosition < 60){
                clearInterval(leftInterval);
                mainContent.innerHTML = '<h2>Game Over!</h2><h3>Pontuação: </h3>' + pontuacao;
                gameOver = true;
            } else {
                pontuacao += 2;
                pontos.innerHTML = pontuacao;
            }
        }
        obstaclePosition -= 10;
        obstacle.style.left = obstaclePosition + 'px';
    }, obstacleTiming);
    setTimeout(createObstacle, randomTime);
}

//TODO:Só começa a criar p cactus depois de escolhida a tecla

createObstacle();


//Adicionando botão de Play/Pause
//TODO:Colocar funcionalidade. Talvez fazer a pessoa ter que escolher tecla, velocidade e avatar antes de dar play. Não aparecer o play até ela escolher
playButton.addEventListener('click', () => {
    if (!playing) {
        playing = true;
        playButton.innerHTML = '<i class="fab fa-pause"></i>';
    } else {
        playing = false;
        playButton.innerHTML = '<i class="fab fa-play"></i>';
    }
});
document.addEventListener('keyup', handleKeyUP);