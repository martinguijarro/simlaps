export class Car {
    carId: string;
    brand: string;
    model: string;
    year: number;
    horsepower: number;
    weight: number;

    constructor(carId: string, brand: string, model: string, year: number, horsepower: number, weight: number) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
        this.weight = weight;
    }
}