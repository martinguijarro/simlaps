import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Game } from '../models/game.model';

@Injectable({
    providedIn: 'root'
})

export class GameService {

    url: string = "http://localhost:8080";

    constructor(private http: HttpClient) {}

    getAllGames() {
        return this.http.get<Game[]>(`${this.url}/games/all`, { withCredentials: false })
    }

    createGame(game: Game) {
        return this.http.post<Game>(`${this.url}/game/create`, game, { withCredentials: false })
    }

}