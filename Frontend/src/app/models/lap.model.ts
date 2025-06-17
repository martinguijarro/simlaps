export class Lap {
    lapId: string;
    date: Date;
    time: string;
    userId: string;
    circuitId: string;
    carId: string;
    gameId: string;

    constructor(lapId: string, date: Date, time: string, userId: string, circuitId: string, carId: string, gameId: string) {
        this.lapId = lapId;
        this.date = date;
        this.time = time;
        this.userId = userId;
        this.circuitId = circuitId;
        this.carId = carId;
        this.gameId = gameId;
    }
}