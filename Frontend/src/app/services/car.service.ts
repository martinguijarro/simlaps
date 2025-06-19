import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Car } from '../models/car.model';

@Injectable({
    providedIn: 'root'
})

export class CarService {

    url: string = "http://localhost:8080";

    constructor(private http: HttpClient) {}

    getAllCars() {
        return this.http.get<Car[]>(`${this.url}/cars/all`, { withCredentials: false })
    }

    getCarById(carId: string) {
        return this.http.get<Car>(`${this.url}/car/id/${carId}`, { withCredentials: false })
    }

    createCar(car: Car) {
        return this.http.post<Car>(`${this.url}/car/create`, car, { withCredentials: false })
    }

}