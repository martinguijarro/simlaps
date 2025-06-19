import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';

import { LapService } from '../services/lap.service';
import { CircuitService } from '../services/circuit.service';
import { CarService } from '../services/car.service';
import { GameService } from '../services/game.service';
import { Circuit } from '../models/circuit.model';
import { Car } from '../models/car.model';
import { Game } from '../models/game.model';
import { Lap } from '../models/lap.model';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-create-lap',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule
  ],
  templateUrl: './create-lap.component.html',
  styleUrl: './create-lap.component.css'
})
export class CreateLapComponent {

  lapForm: FormGroup;

  circuits: Circuit[] = [];
  cars: Car[] = [];
  games: Game[] = [];

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<CreateLapComponent>,
    private lapService: LapService,
    private circuitService: CircuitService,
    private carService: CarService,
    private gameService: GameService
  ) {
    this.lapForm = this.fb.group({
      date: [new Date(), Validators.required],
      time: ['', Validators.required],
      userId: ['68535932ac02d461916fcf86', Validators.required],
      circuitId: ['', Validators.required],
      carId: ['', Validators.required],
      gameId: ['', Validators.required]
    })
  }

  ngOnInit() {
    this.getCircuits();
    this.getCars();
    this.getGames();
  }

  getCircuits() {
    this.circuitService.getAllCircuits().subscribe((data) => {
      this.circuits = data;
    });
  }

  getCars() {
    this.carService.getAllCars().subscribe((data) => {
      this.cars = data;
    });
  }

  getGames() {
    this.gameService.getAllGames().subscribe((data) => {
      this.games = data;
    });
  }

  createLap() {
    if (!this.lapForm.valid) {
      console.log('Formulario inválido');
      return;
    }

    const newLap: Lap = this.lapForm.value;
    
    this.lapService.createLap(newLap).subscribe({
      next: res => {
        console.log('Vuelta creada: ' + res);
        this.dialogRef.close(true);
      },
      error: err => {
        console.error('Error al crear vuelta: ', err);
      }
    });
  }

}
