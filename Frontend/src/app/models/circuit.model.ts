import { Country } from "./countries";

export class Circuit {
    circuitId: string;
    name: string;
    country: Country;
    length: string;

    constructor(circuitId: string, name: string, country: Country, length: string) {
        this.circuitId = circuitId;
        this.name = name;
        this.country = country;
        this.length = length;
    }
}