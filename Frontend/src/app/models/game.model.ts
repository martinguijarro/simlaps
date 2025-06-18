export class Game {
    gameId: string;
    name: string;
    developer: string;
    year: number;

    constructor(gameId: string, name: string, developer: string, year: number) {
        this.gameId = gameId;
        this.name = name;
        this.developer = developer;
        this.year = year;
    }
}