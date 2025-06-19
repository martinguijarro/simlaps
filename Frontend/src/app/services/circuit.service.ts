import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Circuit } from '../models/circuit.model';

@Injectable({
    providedIn: 'root'
})

export class CircuitService {

    url: string = "http://localhost:8080";

    constructor(private http: HttpClient) {}

    getAllCircuits() {
        return this.http.get<Circuit[]>(`${this.url}/circuits/all`, { withCredentials: false })
    }

    create<Circuit>(circuit: Circuit) {
        return this.http.post<Circuit>(`${this.url}/circuit/create`, circuit, { withCredentials: false })
    }

}