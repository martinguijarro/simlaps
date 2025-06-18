import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Lap } from '../models/lap.model';

@Injectable({
    providedIn: 'root'
})

export class LapService {

    url: string = "http://localhost:8080";

    constructor(private http: HttpClient) {}

    getAllLaps() {
        return this.http.get<Lap[]>(`${this.url}/laps/all`, { withCredentials: false })
    }

    createLap(lap: Lap) {
        return this.http.post<Lap>(`${this.url}/lap/create`, lap, { withCredentials: false })
    }

}